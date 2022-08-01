

Polimorfismo
============

 

Polimorfismo
------------

La definizione del dizionario di polimorfismo si riferisce a un principio in biologia in cui un organismo o una specie può avere molte forme o stadi diversi. Questo principio può essere applicato anche alla programmazione orientata agli oggetti e ai linguaggi come il linguaggio Java. Le sottoclassi di una classe possono definire i propri comportamenti univoci e tuttavia condividere alcune delle stesse funzionalità della classe padre.

Il polimorfismo può essere dimostrato con una piccola modifica alla `Bicycle`classe. Ad esempio, `printDescription()`è possibile aggiungere un metodo alla classe che visualizza tutti i dati attualmente archiviati in un'istanza.

    public void printDescription(){
        System.out.println("\nBike is " + "in gear " + this.gear
            + " with a cadence of " + this.cadence +
            " and travelling at a speed of " + this.speed + ". ");
    }
    



Per dimostrare le caratteristiche polimorfiche nel linguaggio Java, estendi la `Bicycle`classe con a `MountainBike`e una `RoadBike`classe. Per `MountainBike`, aggiungi un campo per la sospensione, che è un [`String`](https://docs.oracle.com/en/java/javase/18/docs/api/java.base/java/lang/String.html)valore che indica se la bici ha un ammortizzatore anteriore, `Front`. Oppure, la bici ha un ammortizzatore anteriore e posteriore, `Dual`.

Ecco la classe aggiornata:

    public class MountainBike extends Bicycle {
        private String suspension;
    
        public MountainBike(
                   int startCadence,
                   int startSpeed,
                   int startGear,
                   String suspensionType){
            super(startCadence,
                  startSpeed,
                  startGear);
            this.setSuspension(suspensionType);
        }
    
        public String getSuspension(){
          return this.suspension;
        }
    
        public void setSuspension(String suspensionType) {
            this.suspension = suspensionType;
        }
    
        public void printDescription() {
            super.printDescription();
            System.out.println("The " + "MountainBike has a" +
                getSuspension() + " suspension.");
        }
    } 
    



Nota il `printDescription()`metodo sovrascritto. Oltre alle informazioni fornite in precedenza, nell'output sono inclusi dati aggiuntivi sulla sospensione.

Quindi, crea la `RoadBike`classe. Poiché le bici da strada o da corsa hanno pneumatici skinny, aggiungi un attributo per tenere traccia della larghezza del pneumatico. Ecco la `RoadBike`classe:

    public class RoadBike extends Bicycle{
        // In millimeters (mm)
        private int tireWidth;
    
        public RoadBike(int startCadence,
                        int startSpeed,
                        int startGear,
                        int newTireWidth){
            super(startCadence,
                  startSpeed,
                  startGear);
            this.setTireWidth(newTireWidth);
        }
    
        public int getTireWidth(){
          return this.tireWidth;
        }
    
        public void setTireWidth(int newTireWidth){
            this.tireWidth = newTireWidth;
        }
    
        public void printDescription(){
            super.printDescription();
            System.out.println("The RoadBike" + " has " + getTireWidth() +
                " MM tires.");
        }
    }
    



Si noti che ancora una volta il `printDescription()`metodo è stato sovrascritto. Questa volta vengono visualizzate le informazioni sulla larghezza del pneumatico.

Per riassumere, ci sono tre classi: `Bicycle`, `MountainBike`, e `RoadBike`. Le due sottoclassi sovrascrivono il `printDescription()`metodo e stampano informazioni univoche.

Ecco un programma di test che crea tre `Bicycle`variabili. Ciascuna variabile è assegnata a una delle tre classi di biciclette. Ogni variabile viene quindi stampata.

    public class TestBikes {
      public static void main(String[] args){
        Bicycle bike01, bike02, bike03;
    
        bike01 = new Bicycle(20, 10, 1);
        bike02 = new MountainBike(20, 10, 5, "Dual");
        bike03 = new RoadBike(40, 20, 8, 23);
    
        bike01.printDescription();
        bike02.printDescription();
        bike03.printDescription();
      }
    }
    



Quello che segue è l'output del programma di test:

    Bike is in gear 1 with a cadence of 20 and travelling at a speed of 10. 
    
    Bike is in gear 5 with a cadence of 20 and travelling at a speed of 10. 
    The MountainBike has a Dual suspension.
    
    Bike is in gear 8 with a cadence of 40 and travelling at a speed of 20. 
    The RoadBike has 23 MM tires.
    



La Java virtual machine (JVM) chiama il metodo appropriato per l'oggetto a cui si fa riferimento in ciascuna variabile. Non chiama il metodo definito dal tipo della variabile. Questo comportamento viene definito chiamata di metodo virtuale e dimostra un aspetto delle importanti caratteristiche del polimorfismo nel linguaggio Java.

 

Nascondere i campi
------------------

All'interno di una classe, un campo che ha lo stesso nome di un campo nella superclasse nasconde il campo della superclasse, anche se i loro tipi sono diversi. All'interno della sottoclasse, il campo nella superclasse non può essere referenziato con il suo nome semplice. Al campo, invece, si deve accedere tramite super, di cui si parlerà nella prossima sezione. In generale, non consigliamo di nascondere i campi in quanto rende il codice difficile da leggere.

 

Utilizzo della parola chiave Super
----------------------------------

### Accesso ai membri della Superclasse

Se il tuo metodo sovrascrive uno dei metodi della sua superclasse, puoi invocare il metodo sovrascritto tramite l'uso della parola chiave `super`. Puoi anche usare `super`per fare riferimento a un campo nascosto (sebbene nascondere i campi sia sconsigliato). Considera questa classe `Superclass`:

    public class Superclass {
    
        public void printMethod() {
            System.out.println("Printed in Superclass.");
        }
    }
    



Ecco una sottoclasse, chiamata `Subclass`, che sovrascrive `printMethod()`:

    public class Subclass extends Superclass {
    
        // overrides printMethod in Superclass
        public void printMethod() {
            super.printMethod();
            System.out.println("Printed in Subclass");
        }
        public static void main(String[] args) {
            Subclass s = new Subclass();
            s.printMethod();    
        }
    }
    



All'interno `Subclass`, il nome semplice `printMethod()`si riferisce a quello dichiarato in `Subclass`, che prevale su quello in `Superclass`. Quindi, per fare riferimento a `printMethod()`ereditato da `Superclass`, `Subclass`è necessario utilizzare un nome qualificato, utilizzando `super`come mostrato. La compilazione e l'esecuzione `Subclass`stampa quanto segue:

    Printed in Superclass.
    Printed in Subclass
    



### Costruttori di sottoclassi

L'esempio seguente illustra come utilizzare la parola chiave super per richiamare il costruttore di una superclasse. Richiamo `Bicycle`dall'esempio che `MountainBike`è una sottoclasse di `Bicycle`. Ecco il `MountainBike`costruttore (sottoclasse) che chiama il costruttore della superclasse e quindi aggiunge il proprio codice di inizializzazione:

    public MountainBike(int startHeight, 
                        int startCadence,
                        int startSpeed,
                        int startGear) {
        super(startCadence, startSpeed, startGear);
        seatHeight = startHeight;
    } 
    

L'invocazione di un costruttore di superclassi deve essere la prima riga nel costruttore di sottoclassi.

La sintassi per chiamare un costruttore di superclassi è

    super();
    

o

    super(parameter list);
    


Con `super()`, viene chiamato il costruttore senza argomenti della superclasse. Con `super(parameter list)`, viene chiamato il costruttore della superclasse con un elenco di parametri corrispondente.

> Nota: se un costruttore non richiama esplicitamente un costruttore di superclassi, il compilatore Java inserisce automaticamente una chiamata al costruttore senza argomenti della superclasse. Se la superclasse non ha un costruttore senza argomenti, otterrai un errore in fase di compilazione. L'oggetto ha un tale costruttore, quindi se [`Object`](https://docs.oracle.com/en/java/javase/18/docs/api/java.base/java/lang/Object.html)è l'unica superclasse, non ci sono problemi.

Se un costruttore di sottoclassi invoca un costruttore della sua superclasse, in modo esplicito o implicito, si potrebbe pensare che ci sarà un'intera catena di costruttori chiamati, fino al costruttore di [`Object`](https://docs.oracle.com/en/java/javase/18/docs/api/java.base/java/lang/Object.html). In effetti, questo è il caso. Si chiama _concatenamento del costruttore_ e devi esserne consapevole quando c'è una lunga linea di discendenza della classe.

 

Scrivere classi e metodi finali
-------------------------------

Puoi dichiarare finali alcuni o tutti i metodi di una classe. Utilizzare la `final`parola chiave in una dichiarazione di metodo per indicare che il metodo non può essere sovrascritto dalle sottoclassi. La [`Object`](https://docs.oracle.com/en/java/javase/18/docs/api/java.base/java/lang/Object.html)classe fa questo: alcuni dei suoi metodi sono definitivi.

Potresti voler rendere definitivo un metodo se ha un'implementazione che non deve essere modificata ed è fondamentale per lo stato coerente dell'oggetto. Ad esempio, potresti voler rendere definitivo il `getFirstPlayer()`metodo in questa `ChessAlgorithm`classe:

    class ChessAlgorithm {
        enum ChessPlayer { WHITE, BLACK }
        ...
        final ChessPlayer getFirstPlayer() {
            return ChessPlayer.WHITE;
        }
        ...
    }
    



I metodi chiamati dai costruttori dovrebbero generalmente essere dichiarati finali. Se un costruttore chiama un metodo non finale, una sottoclasse può ridefinire quel metodo con risultati sorprendenti o indesiderati.

Nota che puoi anche dichiarare un'intera classe finale. Una classe dichiarata finale non può essere sottoclasse. Ciò è particolarmente utile, ad esempio, quando si crea una classe immutabile come la [`String`](https://docs.oracle.com/en/java/javase/18/docs/api/java.base/java/lang/String.html)classe.


  

