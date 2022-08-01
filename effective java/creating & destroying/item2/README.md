# Se i costrurttori hanno tanti parametri usiamo un Builder

Le fabbriche e i costruttori statici condividono un limite: non si adattano bene a grandi dimensioni
numero di parametri opzionali. Si consideri il caso di una classe che rappresenta il
Etichetta dei dati nutrizionali che appare sugli alimenti confezionati. Queste etichette ne hanno alcune
campi obbligatori—dimensione della porzione, porzioni per contenitore e calorie per porzione—
e più di venti campi opzionali: grassi totali, grassi saturi, grassi trans, colesterolo,
sodio e così via. La maggior parte dei prodotti ha valori diversi da zero solo per alcuni di questi
campi facoltativi.
Che tipo di costruttori o fabbriche statiche dovresti scrivere per una classe del genere?
Tradizionalmente, i programmatori hanno utilizzato il modello del costruttore telescopico, in
che fornisci a un costruttore solo i parametri richiesti, un altro con a
singolo parametro facoltativo, un terzo con due parametri facoltativi e così via, culminando in un costruttore con tutti i parametri facoltativi. Ecco come appare
la pratica. Per brevità, vengono mostrati solo quattro campi opzionali:

```java

// Telescoping constructor pattern - does not scale well!
public class NutritionFacts {
private final int servingSize; // (mL) required
private final int servings; // (per container) required
private final int calories; // (per serving) optional
private final int fat; // (g/serving) optional
private final int sodium; // (mg/serving) optional
private final int carbohydrate; // (g/serving) optional

public NutritionFacts(int servingSize, int servings) {
this(servingSize, servings, 0);
}

public NutritionFacts(int servingSize, int servings,
int calories) {
this(servingSize, servings, calories, 0);
}

public NutritionFacts(int servingSize, int servings,
int calories, int fat) {
this(servingSize, servings, calories, fat, 0);
}
public NutritionFacts(int servingSize, int servings,
int calories, int fat, int sodium) {
this(servingSize, servings, calories, fat, sodium, 0);
}

public NutritionFacts(int servingSize, int servings,
int calories, int fat, int sodium, int carbohydrate) {
this.servingSize = servingSize;
this.servings = servings;
this.calories = calories;
this.fat = fat;
this.sodium = sodium;
this.carbohydrate = carbohydrate;
}
}

```

Quando vuoi creare un'istanza, usi il costruttore con il più breve
lista parametri contenente tutti i parametri che si vogliono impostare:

``` java
NutritionFacts cocaCola =
new NutritionFacts(240, 8, 100, 0, 35, 27);
```



In genere questa chiamata del costruttore richiederà molti parametri che non sono necessari
vuoi impostare, ma sei comunque costretto a passare un valore per loro. 

In questo caso, noi
passato un valore di 0 per il grasso. Con "solo" sei parametri questo potrebbe non sembrare così male,
ma sfugge rapidamente di mano all'aumentare del numero di parametri.

In breve, il modello del costruttore telescopico funziona, ma è difficile da scrivere
codice client quando ci sono molti parametri e ancora più difficile leggerlo. Il
il lettore si chiede cosa significano tutti quei valori e cosa devono contare con attenzione
parametri per scoprirlo. Possono causare lunghe sequenze di parametri tipizzati in modo identico
bug sottili. Se il client annulla accidentalmente due di questi parametri, il compilatore
non si lamenterà, ma il programma si comporterà in modo anomalo in fase di esecuzione (elemento 51).
Una seconda alternativa quando ti trovi di fronte a molti parametri opzionali in a
costruttore è il modello JavaBeans, in cui si chiama un costruttore senza parametri per creare l'oggetto e quindi si chiamano i metodi setter per impostare ogni parametro richiesto
e ogni parametro facoltativo di interesse:

``` java

// JavaBeans Pattern - allows inconsistency, mandates mutability
public class NutritionFacts {
// Parameters initialized to default values (if any)
private int servingSize = -1; // Required; no default value
private int servings = -1; // Required; no default value
private int calories = 0;
private int fat = 0;
private int sodium = 0;
private int carbohydrate = 0;

public NutritionFacts() { }

// Setters
public void setServingSize(int val) { servingSize = val; }
public void setServings(int val) { servings = val; }
public void setCalories(int val) { calories = val; }
public void setFat(int val) { fat = val; }
public void setSodium(int val) { sodium = val; }
public void setCarbohydrate(int val) { carbohydrate = val; }

}

```
Questo modello non ha nessuno degli svantaggi del modello del costruttore telescopico.
È facile, anche se un po' prolisso, creare istanze e leggere il codice risultante:

``` java
NutritionFacts cocaCola = new NutritionFacts();
cocaCola.setServingSize(240);
cocaCola.setServings(8);
cocaCola.setCalories(100);
cocaCola.setSodium(35);
cocaCola.setCarbohydrate(27);
```


Sfortunatamente, il modello JavaBeans ha seri svantaggi di per sé.
Poiché la costruzione è suddivisa in più chiamate, un JavaBean potrebbe trovarsi in un
stato incoerente a metà della sua costruzione. La classe non ha
la possibilità di far rispettare la coerenza semplicemente verificando la validità dell'art
parametri del costruttore. Tentativo di utilizzare un oggetto quando si trova in una situazione incoerente
state può causare errori molto lontani dal codice che contiene il bug e
quindi difficile da eseguire il debug. Uno svantaggio correlato è che il modello JavaBeans
preclude la possibilità di rendere immutabile una classe (Elemento 17) e richiede
sforzo aggiuntivo da parte del programmatore per garantire la sicurezza del thread.
È possibile ridurre questi svantaggi "congelando" manualmente l'oggetto
quando la sua costruzione è completa e non consente di utilizzarlo fino a quando non è congelato, ma
questa variante è ingombrante e usata raramente nella pratica. Inoltre, può causare errori
in fase di esecuzione perché il compilatore non può garantire che il programmatore chiami il file
freeze metodo su un oggetto prima di usarlo.
Fortunatamente, esiste una terza alternativa che combina la sicurezza del telescopico
modello costruttore con la leggibilità del modello JavaBeans. È una forma del
Modello di costruzione [Gamma95]. Invece di creare direttamente l'oggetto desiderato, il
client chiama un costruttore (o una factory statica) con tutti i parametri richiesti e
ottiene un oggetto builder. Quindi il client chiama metodi simili a setter sull'oggetto builder
per impostare ogni parametro opzionale di interesse. Infine, il client chiama un parametro senza parametri
build per generare l'oggetto, che in genere è immutabile. Il costruttore è
in genere una classe membro statica (elemento 24) della classe che compila. Ecco come appare
in pratica:

```java

// Builder Pattern
public class NutritionFacts {
private final int servingSize;
private final int servings;
private final int calories;
private final int fat;
private final int sodium;
private final int carbohydrate;
public static class Builder {
// Required parameters
private final int servingSize;
private final int servings;
// Optional parameters - initialized to default values
private int calories = 0;
private int fat = 0;
private int sodium = 0;
private int carbohydrate = 0;
public Builder(int servingSize, int servings) {
this.servingSize = servingSize;
this.servings = servings;
}
public Builder calories(int val)
{ calories = val; return this; }
public Builder fat(int val)
{ fat = val; return this; }
public Builder sodium(int val)
{ sodium = val; return this; }
public Builder carbohydrate(int val)
{ carbohydrate = val; return this; }
public NutritionFacts build() {
return new NutritionFacts(this);
}
}
private NutritionFacts(Builder builder) {
servingSize = builder.servingSize;
servings = builder.servings;
calories = builder.calories;
fat = builder.fat;
sodium = builder.sodium;
carbohydrate = builder.carbohydrate;
}
}

```

La classe NutritionFacts è immutabile e lo sono tutti i valori predefiniti dei parametri
in un posto. I metodi setter del builder restituiscono il builder stesso in modo che le invocazioni possano essere concatenate, risultando in un'API fluida. Ecco come appare il codice client:

```java

NutritionFacts cocaCola = new NutritionFacts.Builder(240, 8)
.calories(100).sodium(35).carbohydrate(27).build();

```


Questo codice client è facile da scrivere e, soprattutto, facile da leggere. Il costruttore
pattern simula parametri opzionali denominati come quelli che si trovano in Python e Scala.
I controlli di validità sono stati omessi per brevità. Per rilevare i parametri non validi al più presto
controllare la validità dei parametri nel costruttore e nei metodi del costruttore.
Controlla le invarianti che coinvolgono più parametri nel costruttore invocato da
metodo di costruzione. Per garantire queste invarianti contro l'attacco, eseguire i controlli sull'oggetto
campi dopo aver copiato i parametri dal builder (elemento 50). Se un controllo fallisce, lancia
un IllegalArgumentException (elemento 72) il cui messaggio di dettaglio indica quale
i parametri non sono validi (elemento 75).
Il modello Builder è adatto alle gerarchie di classi. Utilizzare una gerarchia parallela di builder, ciascuno annidato nella classe corrispondente. Le classi astratte hanno
costruttori astratti; classi concrete hanno costruttori concreti. Ad esempio, considera
una classe astratta alla radice di una gerarchia che rappresenta vari tipi di pizza:


```java

// Builder pattern for class hierarchies
public abstract class Pizza {
public enum Topping { HAM, MUSHROOM, ONION, PEPPER, SAUSAGE }
final Set<Topping> toppings;
abstract static class Builder<T extends Builder<T>> {
EnumSet<Topping> toppings = EnumSet.noneOf(Topping.class);
public T addTopping(Topping topping) {
toppings.add(Objects.requireNonNull(topping));
return self();
}
abstract Pizza build();
// Subclasses must override this method to return "this"
protected abstract T self();
}
Pizza(Builder<?> builder) {
toppings = builder.toppings.clone(); // See Item 50
}
}

```

Si noti che Pizza.Builder è un tipo generico con un parametro di tipo ricorsivo
(Articolo 30). Questo, insieme al metodo del sé astratto, consente il concatenamento del metodo
funzionano correttamente nelle sottoclassi, senza la necessità di calchi. Questa soluzione per il
il fatto che Java manchi di un tipo self è noto come idioma del tipo self simulato.

Ecco due sottoclassi concrete di Pizza, una delle quali rappresenta uno standard
Pizza newyorkese, l'altro un calzone. Il primo ha un parametro di dimensione richiesto, mentre il secondo ti consente di specificare se la salsa deve essere dentro o fuori:

```java

public class NyPizza extends Pizza {
public enum Size { SMALL, MEDIUM, LARGE }
private final Size size;
public static class Builder extends Pizza.Builder<Builder> {
private final Size size;
public Builder(Size size) {
this.size = Objects.requireNonNull(size);
}
@Override public NyPizza build() {
return new NyPizza(this);
}
@Override protected Builder self() { return this; }
}
private NyPizza(Builder builder) {
super(builder);
size = builder.size;
}
}
public class Calzone extends Pizza {
private final boolean sauceInside;
public static class Builder extends Pizza.Builder<Builder> {
private boolean sauceInside = false; // Default
public Builder sauceInside() {
sauceInside = true;
return this;
}
@Override public Calzone build() {
return new Calzone(this);
}
@Override protected Builder self() { return this; }
}
private Calzone(Builder builder) {
super(builder);
sauceInside = builder.sauceInside;
}
}


```

Nota che il metodo build nel builder di ogni sottoclasse è dichiarato per restituire il
sottoclasse corretta: il metodo build di NyPizza.Builder restituisce NyPizza, mentre
quello in Calzone.Builder restituisce Calzone. Questa tecnica, in cui una sottoclasse
viene dichiarato per restituire un sottotipo del tipo restituito dichiarato nella superclasse, è noto come tipizzazione restituita covariante. Consente ai clienti di utilizzare questi builder
senza bisogno di colata.
Il codice client per questi "builder gerarchici" è essenzialmente identico al
codice per il semplice builder NutritionFacts. Il codice client di esempio mostrato di seguito
presuppone importazioni statiche su costanti enum per brevità:

```java

NyPizza pizza = new NyPizza.Builder(SMALL)
.addTopping(SAUSAGE).addTopping(ONION).build();
Calzone calzone = new Calzone.Builder()
.addTopping(HAM).sauceInside().build();

```

Un vantaggio minore dei builder rispetto ai costruttori è che i builder possono avere più parametri varargs perché ogni parametro è specificato nel proprio metodo.
In alternativa, i builder possono aggregare i parametri passati in più chiamate a a
metodo in un singolo campo, come dimostrato in precedenza nel metodo addTopping.
Il modello Builder è abbastanza flessibile. Un singolo builder può essere utilizzato ripetutamente
per costruire più oggetti. I parametri del builder possono essere modificati tra
invocazioni del metodo build per variare gli oggetti creati. Un costruttore può
compilare automaticamente alcuni campi al momento della creazione dell'oggetto, come un numero di serie che
aumenta ogni volta che viene creato un oggetto.
Anche il modello Builder presenta degli svantaggi. Per creare un oggetto, tu
deve prima creare il suo costruttore. Mentre è improbabile che il costo della creazione di questo costruttore sia
evidente nella pratica, potrebbe essere un problema in situazioni critiche per le prestazioni.
Inoltre, il modello Builder è più dettagliato del modello del costruttore telescopico,
quindi dovrebbe essere usato solo se ci sono abbastanza parametri per renderlo utile, diciamo
quattro o più. Ma tieni presente che potresti voler aggiungere più parametri nel file
futuro. Ma se inizi con costruttori o fabbriche statiche e passi a a
builder quando la classe evolve al punto in cui ottiene il numero di parametri
fuori mano, i costruttori obsoleti o le fabbriche statiche sporgeranno come una piaga
pollice. Pertanto, spesso è meglio iniziare con un costruttore in primo luogo.
In sintesi, il modello Builder è una buona scelta quando si progettano classi
i cui costruttori o fabbriche statiche ne avrebbero più di una manciata
parametri, soprattutto se molti dei parametri sono opzionali o di tipo identico.
Il codice client è molto più facile da leggere e scrivere con i builder che con il telescoping
costruttori e costruttori sono molto più sicuri di JavaBeans