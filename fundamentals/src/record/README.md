

Utilizzo di Record per modellare dati immutabili
================================================

Il linguaggio Java ti offre diversi modi per creare una classe immutabile. Probabilmente il modo più semplice è creare una classe finale con campi finali e un costruttore per inizializzare questi campi. Ecco un esempio di una tale classe.

    public class Point {
        private final int x;
        private final int y;
    
        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
    

copia

Ora che hai scritto questi elementi, devi aggiungere gli accessori per i tuoi campi. Aggiungerai anche un [`toString()`](https://docs.oracle.com/en/java/javase/18/docs/api/java.base/java/lang/Object.html#toString())metodo e probabilmente un [`equals()`](https://docs.oracle.com/en/java/javase/18/docs/api/java.base/java/lang/Object.html#equals(java.lang.Object))insieme a un [`hashCode()`](https://docs.oracle.com/en/java/javase/18/docs/api/java.base/java/lang/Object.html#hashCode())metodo. Scrivere tutto questo a mano è piuttosto noioso e soggetto a errori, fortunatamente il tuo IDE è lì per generare questi metodi per te.

Se è necessario trasferire le istanze di questa classe da un'applicazione all'altra, inviandole su una rete o tramite un file system, si può anche considerare di rendere questa classe serializzabile. In tal caso, potrebbe essere necessario aggiungere alcune informazioni su come vengono serializzate le istanze di questa classe. Il JDK offre diversi modi per controllare la serializzazione.

Alla fine, la tua `Point`classe potrebbe essere lunga un centinaio di righe, per lo più popolata con codice generato dal tuo IDE, solo per modellare un'aggregazione immutabile di due numeri interi che devi scrivere su un file.

I record sono stati aggiunti al JDK per modificare questo. I record ti danno tutto questo con una singola riga di codice. Tutto quello che devi fare è dichiarare lo stato di un record; il resto è generato per te dal compilatore.

Chiamare i record in soccorso
-----------------------------

I record sono qui per aiutarti a rendere questo codice molto più semplice. A partire da Java SE 14, puoi scrivere il codice seguente.

    public record Point(int x, int y) {}
    

copia

Questa singola riga di codice crea i seguenti elementi per te.

1.  È una classe immutabile con due campi: `x`e `y`, di tipo `int`.
2.  Ha un costruttore canonico, per inizializzare questi due campi.
3.  I metodi [`toString()`](https://docs.oracle.com/en/java/javase/18/docs/api/java.base/java/lang/Object.html#toString()), [`equals()`](https://docs.oracle.com/en/java/javase/18/docs/api/java.base/java/lang/Object.html#equals(java.lang.Object))e [`hashCode()`](https://docs.oracle.com/en/java/javase/18/docs/api/java.base/java/lang/Object.html#hashCode())sono stati creati per te dal compilatore con un comportamento predefinito che corrisponde a ciò che un IDE avrebbe generato. È possibile modificare questo comportamento, se necessario, aggiungendo le proprie implementazioni di questi metodi.
4.  Può implementare l' [`Serializable`](https://docs.oracle.com/en/java/javase/18/docs/api/java.base/java/io/Serializable.html)interfaccia, in modo da poter inviare istanze `Point`ad altre applicazioni su una rete o tramite un file system. Il modo in cui un record viene serializzato e deserializzato segue alcune regole speciali che vengono trattate alla fine di questo tutorial.

I record stanno rendendo la creazione di aggregati immutabili di dati molto più semplice, senza l'aiuto di alcun IDE. Riduce il rischio di bug perché ogni volta che modifichi i componenti di un record, il compilatore aggiorna automaticamente i metodi [`equals()`](https://docs.oracle.com/en/java/javase/18/docs/api/java.base/java/lang/Object.html#equals(java.lang.Object))e per te.[`hashCode()`](https://docs.oracle.com/en/java/javase/18/docs/api/java.base/java/lang/Object.html#hashCode())

La classe di un record
----------------------

Un record è classe dichiarata con la `record`parola chiave invece della `class`parola chiave. Dichiariamo il seguente record.

    public record Point(int x, int y) {}
    

copia

La classe che il compilatore crea per te quando crei un record è definitiva.

Questa classe estende la [`java.lang.Record`](https://docs.oracle.com/en/java/javase/18/docs/api/java.base/java/lang/Record.html)classe. Quindi il tuo record non può estendere nessuna classe.

Un record può implementare un numero qualsiasi di interfacce.

Dichiarazione dei componenti di un record
-----------------------------------------

Il blocco che segue immediatamente il nome del record è `(int x, int y)`. Dichiara i _componenti_ del record denominati `Point`. Per ogni componente di un record, il compilatore crea un campo finale privato con lo stesso nome di questo componente. Puoi avere un numero qualsiasi di componenti dichiarati in un record.

In questo esempio, il compilatore crea due campi finali privati ​​di tipo `int`: `x`e `y`, corrispondenti ai due componenti che hai dichiarato.

Insieme a questi campi, il compilatore genera una funzione di _accesso_ per ogni componente. Questa funzione di accesso è un metodo che ha lo stesso nome del componente e ne restituisce il valore. Nel caso di questo `Point`record, i due metodi generati sono i seguenti.

    public int x() {
        return this.x;
    }
    
    public int y() {
        return this.y;
    }
    

copia

Se questa implementazione funziona per la tua applicazione, non è necessario aggiungere nulla. Tuttavia, puoi definire i tuoi metodi di accesso. Può essere utile nel caso in cui sia necessario restituire una copia difensiva di un determinato campo.

Gli ultimi elementi generati per te dal compilatore sono le sostituzioni dei metodi e della [`toString()`](https://docs.oracle.com/en/java/javase/18/docs/api/java.base/java/lang/Object.html#toString())classe . Se necessario, puoi definire le tue sostituzioni di questi metodi.[`equals()`](https://docs.oracle.com/en/java/javase/18/docs/api/java.base/java/lang/Object.html#equals(java.lang.Object))[`hashCode()`](https://docs.oracle.com/en/java/javase/18/docs/api/java.base/java/lang/Object.html#hashCode())[`Object`](https://docs.oracle.com/en/java/javase/18/docs/api/java.base/java/lang/Object.html)

Cose che non puoi aggiungere a un record
----------------------------------------

Ci sono tre cose che non puoi aggiungere a un record:

1.  Non puoi dichiarare alcun campo di istanza in un record. Non è possibile aggiungere alcun campo di istanza che non corrisponda a un componente.
2.  Non è possibile definire alcun inizializzatore di campo.
3.  Non è possibile aggiungere alcun inizializzatore di istanza.

È possibile creare campi statici con inizializzatori e inizializzatori statici.

Costruire un record con il suo costruttore canonico
---------------------------------------------------

Il compilatore crea anche un costruttore per te, chiamato _costruttore canonico_ . Questo costruttore prende i componenti del tuo record come argomenti e ne copia i valori nei campi della classe del record.

Ci sono situazioni in cui è necessario ignorare questo comportamento predefinito. Esaminiamo due casi d'uso:

1.  Devi convalidare lo stato del tuo record
2.  Devi fare una copia difensiva di un componente mutevole.

Utilizzo del costruttore compatto
---------------------------------

È possibile utilizzare due diverse sintassi per ridefinire il costruttore canonico di un record. È possibile utilizzare un costruttore compatto o lo stesso costruttore canonico.

Supponiamo di avere il seguente record.

    public record Range(int start, int end) {}
    

copia

Per un record con quel nome, ci si potrebbe aspettare che `end`sia maggiore di `start`. Puoi aggiungere una regola di convalida scrivendo il costruttore compatto nel tuo record.

    public record Range(int start, int end) {
    
        public Range {
            if (end <= start) {
                throw new IllegalArgumentException("End cannot be lesser than start");
            }
        }
    }
    

copia

Il costruttore canonico compatto non ha bisogno di dichiarare il suo blocco di parametri.

Nota che se scegli questa sintassi, non puoi assegnare direttamente i campi del record, ad esempio con `this.start = start`\- che viene fatto per te dal codice aggiunto dal compilatore. Ma puoi assegnare nuovi valori ai parametri, il che porta allo stesso risultato perché il codice generato dal compilatore assegnerà quindi questi nuovi valori ai campi.

    public Range {
        // set negative start and end to 0
        // by reassigning the compact constructor's
        // implicit parameters
        if (start < 0)
            start = 0;
        if (end < 0)
            end = 0;
    }
    

copia

Utilizzo del costruttore canonico
---------------------------------

Se preferisci la forma non compatta, ad esempio perché preferisci non riassegnare parametri, puoi definire tu stesso il costruttore canonico, come nell'esempio seguente.

    public record Range(int start, int end) {
    
        public Range(int start, int end) {
            if (end <= start) {
                throw new IllegalArgumentException("End cannot be lesser than start");
            }
            if (start < 0) {
                this.start = 0;
            } else {
                this.start = start;
            }
            if (end > 100) {
                this.end = 10;
            } else {
                this.end = end;
            }
        }
    }
    

copia

In questo caso il costruttore che scrivi deve assegnare valori ai campi del tuo record.

Se i componenti del tuo record non sono immutabili, dovresti prendere in considerazione la possibilità di crearne copie difensive sia nel costruttore canonico che nelle funzioni di accesso.

Definizione di qualsiasi costruttore
------------------------------------

Puoi anche aggiungere qualsiasi costruttore a un record, purché questo costruttore chiami il costruttore canonico del tuo record. La sintassi è la stessa della sintassi classica che chiama un costruttore con un altro costruttore. Come per qualsiasi classe, la chiamata a `this()`deve essere la prima istruzione del proprio costruttore.

Esaminiamo il seguente `State`record. È definito su tre componenti:

1.  il nome di questo stato
2.  il nome della capitale di questo stato
3.  un elenco di nomi di città, che potrebbe essere vuoto.

È necessario archiviare una copia difensiva dell'elenco delle città, per garantire che non venga modificato dall'esterno di questo record. Questo può essere fatto ridefinendo il costruttore canonico con una forma compatta che riassegna il parametro alla copia difensiva.

Avere un costruttore che non prende nessuna città è utile nella tua applicazione. Questo può essere un altro costruttore, che prende solo il nome dello stato e il nome della capitale. Questo secondo costruttore deve chiamare il costruttore canonico.

Quindi, invece di passare un elenco di città, puoi passare le città come vararg. Per fare ciò, puoi creare un terzo costruttore, che deve chiamare il costruttore canonico con l'elenco appropriato.

    public record State(String name, String capitalCity, List<String> cities) {
    
        public State {
            // List.copyOf returns an unmodifiable copy,
            // so the list assigned to `cities` can't change anymore
            cities = List.copyOf(cities);
        }
    
        public State(String name, String capitalCity) {
            this(name, capitalCity, List.of());
        }
    
        public State(String name, String capitalCity, String... cities) {
            this(name, capitalCity, List.of(cities));
        }
    
    }
    

copia

Si noti che il [`List.copyOf()`](https://docs.oracle.com/en/java/javase/18/docs/api/java.base/java/util/List.html#copyOf(java.util.Collection))metodo non accetta valori Null nella raccolta che ottiene come argomento.

Ottenere lo stato di un record
------------------------------

Non è necessario aggiungere alcuna funzione di accesso a un record, perché il compilatore lo fa per te. Un record ha un metodo di accesso per componente, che ha il nome di questo componente.

Il `Point`record della prima sezione di questo tutorial ha due metodi di accesso: `x()`e `y()`che restituisce il valore dei componenti corrispondenti.

There are cases where you need to define your own accessors, though. For instance, assume the `State` record from the previous section didn't create an unmodifiable defensive copy of the `cities` list during construction - then it should do that in the accessor to make sure callers can't mutate its internal state. You can add the following code in your `State` record to return this defensive copy.

    public List<String> cities() {
        return List.copyOf(cities);
    }
    

Copy

Serializing Records
-------------------

Records can be serialized and deserialized if your record class implements [`Serializable`](https://docs.oracle.com/en/java/javase/18/docs/api/java.base/java/io/Serializable.html). There are restrictions though.

1.  None of the systems you can use to replace the default serialization process are available for records. Creating a [`writeObject()`](https://docs.oracle.com/en/java/javase/18/docs/specs/serialization/output.html#the-writeobject-method) and [`readObject()`](https://docs.oracle.com/en/java/javase/18/docs/specs/serialization/input.html#the-readobject-method) method has no effect, nor implementing [`Externalizable`](https://docs.oracle.com/en/java/javase/18/docs/api/java.base/java/io/Externalizable.html).
2.  Records can be used as proxy objects to serialize other objects. A [`readResolve()`](https://docs.oracle.com/en/java/javase/18/docs/specs/serialization/input.html#the-readresolve-method) method can return a record. Adding a [`writeReplace()`](https://docs.oracle.com/en/java/javase/18/docs/specs/serialization/output.html#the-writereplace-method) in a record is also possible.
3.  Deserializing a record _always_ call the canonical constructor. So all the validation rules you may add in this constructor will be enforced when deserializing a record.

This makes records a very good choice for creating data transport objects in your application.

Using Records in a Real Use Case
--------------------------------

Records are a versatile concept that you can use in many contexts.

The first one is to carry data in the object model of your application. You can use records for what they have been designed for: acting as an immutable data carrier.

Because you can declare local records, you can also use them to improve the readability of your code.

Consideriamo il seguente caso d'uso. Hai due entità modellate come record: `City`e `State`.

    public record City(String name, State state) {}
    

copia

    public record State(String name) {}
    

copia

Supponiamo di avere un elenco di città e di dover calcolare lo stato che ha il maggior numero di città. Puoi utilizzare l'API Stream per creare prima l'istogramma degli stati con il numero di città di ciascuno. Questo istogramma è modellato da un [`Map`](https://docs.oracle.com/en/java/javase/18/docs/api/java.base/java/util/Map.html).

    List<City> cities = List.of();
    
    Map<State, Long> numberOfCitiesPerState =
        cities.stream()
              .collect(Collectors.groupingBy(
                       City::state, Collectors.counting()
              ));
    

copia

Ottenere il massimo di questo istogramma è il seguente codice generico.

    Map.Entry<State, Long> stateWithTheMostCities =
        numberOfCitiesPerState.entrySet().stream()
                              .max(Map.Entry.comparingByValue())
                              .orElseThrow();
    

copia

Quest'ultimo pezzo di codice è tecnico; non ha alcun significato commerciale; perché usa [`Map.Entry`](https://docs.oracle.com/en/java/javase/18/docs/api/java.base/java/util/Map.Entry.html)l'istanza per modellare ogni elemento dell'istogramma.

L'uso di un record locale può migliorare notevolmente questa situazione. Il codice seguente crea una nuova classe di record, che aggrega uno stato e il numero di città in questo stato. Ha un costruttore che accetta un'istanza di [`Map.Entry`](https://docs.oracle.com/en/java/javase/18/docs/api/java.base/java/util/Map.Entry.html)come parametro, per mappare il flusso di coppie chiave-valore a un flusso di record.

Poiché è necessario confrontare questi aggregati in base al numero di città, è possibile aggiungere un metodo di fabbrica per fornire questo comparatore. Il codice diventa il seguente.

    record NumberOfCitiesPerState(State state, long numberOfCities) {
    
        public NumberOfCitiesPerState(Map.Entry<State, Long> entry) {
            this(entry.getKey(), entry.getValue());
        }
    
        public static Comparator<NumberOfCitiesPerState> comparingByNumberOfCities() {
            return Comparator.comparing(NumberOfCitiesPerState::numberOfCities);
        }
    }
    
    NumberOfCitiesPerState stateWithTheMostCities =
        numberOfCitiesPerState.entrySet().stream()
                              .map(NumberOfCitiesPerState::new)
                              .max(NumberOfCitiesPerState.comparingByNumberOfCities())
                              .orElseThrow();
    



Il tuo codice ora estrae un massimo in modo significativo. Il tuo codice è più leggibile, più facile da capire e meno soggetto a errori e, a lungo termine, più facile da mantenere.

