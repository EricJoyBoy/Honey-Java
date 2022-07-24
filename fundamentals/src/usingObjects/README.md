

Creazione e utilizzo di oggetti
===============================

 

Capire cosa sono gli oggetti
----------------------------

Un tipico programma Java crea molti oggetti che, come sapete, interagiscono invocando metodi. Attraverso queste interazioni tra oggetti, un programma può svolgere varie attività, come implementare una GUI, eseguire un'animazione o inviare e ricevere informazioni su una rete. Una volta che un oggetto ha completato il lavoro per il quale è stato creato, le sue risorse vengono riciclate per essere utilizzate da altri oggetti.

Ecco un piccolo programma, chiamato `CreateObjectDemo`, che crea tre oggetti: un `Point`oggetto e due `Rectangle`oggetti. Avrai bisogno di tutti e tre i file sorgente per compilare questo programma.

    public class CreateObjectDemo {
    
        public static void main(String[] args) {
            
            // Declare and create a point object and two rectangle objects.
            Point originOne = new Point(23, 94);
            Rectangle rectOne = new Rectangle(originOne, 100, 200);
            Rectangle rectTwo = new Rectangle(50, 100);
            
            // display rectOne's width, height, and area
            System.out.println("Width of rectOne: " + rectOne.width);
            System.out.println("Height of rectOne: " + rectOne.height);
            System.out.println("Area of rectOne: " + rectOne.getArea());
            
            // set rectTwo's position
            rectTwo.origin = originOne;
            
            // display rectTwo's position
            System.out.println("X Position of rectTwo: " + rectTwo.origin.x);
            System.out.println("Y Position of rectTwo: " + rectTwo.origin.y);
            
            // move rectTwo and display its new position
            rectTwo.move(40, 72);
            System.out.println("X Position of rectTwo: " + rectTwo.origin.x);
            System.out.println("Y Position of rectTwo: " + rectTwo.origin.y);
        }
    }
    

copia

Ecco la `Point`classe:

    public class Point {
        public int x = 0;
        public int y = 0;
        // a constructor!
        public Point(int a, int b) {
        x = a;
        y = b;
        }
    }
    

copia

E la `Rectangle`classe:

    public class Rectangle {
        public int width = 0;
        public int height = 0;
        public Point origin;
     
        // four constructors
        public Rectangle() {
        origin = new Point(0, 0);
        }
        public Rectangle(Point p) {
        origin = p;
        }
        public Rectangle(int w, int h) {
        origin = new Point(0, 0);
        width = w;
        height = h;
        }
        public Rectangle(Point p, int w, int h) {
        origin = p;
        width = w;
        height = h;
        }
     
        // a method for moving the rectangle
        public void move(int x, int y) {
        origin.x = x;
        origin.y = y;
        }
     
        // a method for computing the area of the rectangle
        public int getArea() {
        return width * height;
        }
    }
    

copia

Questo programma crea, manipola e visualizza informazioni su vari oggetti. Ecco l'output:

    Width of rectOne: 100
    Height of rectOne: 200
    Area of rectOne: 20000
    X Position of rectTwo: 23
    Y Position of rectTwo: 94
    X Position of rectTwo: 40
    Y Position of rectTwo: 72
    

copia

Le tre sezioni seguenti utilizzano l'esempio precedente per descrivere il ciclo di vita di un oggetto all'interno di un programma. Da loro imparerai come scrivere codice che crea e utilizza oggetti nei tuoi programmi. Imparerai anche come il sistema si pulisce dopo che un oggetto è terminato.

 

Creazione di oggetti
--------------------

Come sapete, una classe fornisce il progetto per gli oggetti; crei un oggetto da una classe. Ognuna delle seguenti affermazioni tratte dal `CreateObjectDemo`programma crea un oggetto e lo assegna a una variabile:

    Point originOne = new Point(23, 94);
    Rectangle rectOne = new Rectangle(originOne, 100, 200);
    Rectangle rectTwo = new Rectangle(50, 100);
    

copia

La prima riga crea un oggetto della `Point`classe e la seconda e la terza riga creano ciascuna un oggetto della `Rectangle`classe.

Ognuna di queste affermazioni ha tre parti (discusse in dettaglio di seguito):

1.  Dichiarazione: Il codice impostato in grassetto sono tutte dichiarazioni di variabili che associano un nome di variabile a un tipo di oggetto.
2.  Istanza: la `new`parola chiave è un operatore Java che crea l'oggetto.
3.  Inizializzazione: l' `new`operatore è seguito da una chiamata a un costruttore, che inizializza il nuovo oggetto.

### Dichiarazione di una variabile per fare riferimento a un oggetto

In precedenza, hai imparato che per dichiarare una variabile, scrivi:

    type name;
    

copia

Questo notifica al compilatore che utilizzerai name per fare riferimento ai dati il ​​cui tipo è type. Con una variabile primitiva, questa dichiarazione riserva anche la giusta quantità di memoria per la variabile.

Puoi anche dichiarare una variabile di riferimento su una propria riga. Per esempio:

    Point originOne;
    

copia

Se dichiari `originOne`in questo modo, il suo valore sarà indeterminato fino a quando un oggetto non verrà effettivamente creato e assegnato ad esso. La semplice dichiarazione di una variabile di riferimento non crea un oggetto. Per questo, è necessario utilizzare l' `new`operatore, come descritto nella sezione successiva. È necessario assegnare un oggetto `originOne`prima di utilizzarlo nel codice. Altrimenti, otterrai un errore del compilatore.

Una variabile in questo stato attualmente non fa riferimento a nessun oggetto.

### Istanziazione di una classe

L' `new`operatore crea un'istanza di una classe allocando memoria per un nuovo oggetto e restituendo un riferimento a quella memoria. L' `new`operatore richiama anche il costruttore di oggetti.

> Nota: la frase "istanziare una classe" ha lo stesso significato di "creare un oggetto". Quando crei un oggetto, stai creando un'"istanza" di una classe, quindi "istanziando" una classe.

L' `new`operatore richiede un singolo argomento suffisso: una chiamata a un costruttore. Il nome del costruttore fornisce il nome della classe di cui creare un'istanza.

L' `new`operatore restituisce un riferimento all'oggetto che ha creato. Questo riferimento è solitamente assegnato a una variabile del tipo appropriato, come:

    Point originOne = new Point(23, 94);
    

copia

Il riferimento restituito `new`dall'operatore non deve essere assegnato a una variabile. Può anche essere utilizzato direttamente in un'espressione. Per esempio:

    int height = new Rectangle().height;
    

copia

Questa affermazione sarà discussa nella prossima sezione.

### Inizializzazione di un oggetto

Ecco il codice della `Point`classe:

    public class Point {
        public int x = 0;
        public int y = 0;
        //constructor
        public Point(int a, int b) {
            x = a;
            y = b;
        }
    }
    

copia

Questa classe contiene un singolo costruttore. Puoi riconoscere un costruttore perché la sua dichiarazione usa lo stesso nome della classe e non ha un tipo restituito. Il costruttore nella `Point`classe accetta due argomenti interi, come dichiarato dal codice `(int a, int b)`. La seguente istruzione fornisce 23 e 94 come valori per quegli argomenti:

    Point originOne = new Point(23, 94);
    

copia

Il risultato dell'esecuzione di questa affermazione può essere illustrato nella figura seguente:

![Un oggetto punto](https://dev.java/assets/images/classes-objects/01_new-object.png)

Un oggetto punto

Ecco il codice per la `Rectangle`classe, che contiene quattro costruttori:

    public class Rectangle {
        public int width = 0;
        public int height = 0;
        public Point origin;
    
        // four constructors
        public Rectangle() {
            origin = new Point(0, 0);
        }
        
        public Rectangle(Point p) {
            origin = p;
        }
        
        public Rectangle(int w, int h) {
            origin = new Point(0, 0);
            width = w;
            height = h;
        }
        
        public Rectangle(Point p, int w, int h) {
            origin = p;
            width = w;
            height = h;
        }
    
        // a method for moving the rectangle
        public void move(int x, int y) {
            origin.x = x;
            origin.y = y;
        }
    
        // a method for computing the area of the rectangle
        public int getArea() {
            return width * height;
        }
    }
    

copia

Each constructor lets you provide initial values for the rectangle's `origin`, `width`, and `height`, using both primitive and reference types. If a class has multiple constructors, they must have different signatures. The Java compiler differentiates the constructors based on the number and the type of the arguments. When the Java compiler encounters the following code, it knows to call the constructor in the `Rectangle` class that requires a `Point` argument followed by two integer arguments:

    Rectangle rectOne = new Rectangle(originOne, 100, 200);
    

Copy

This calls one of `Rectangle`'s constructors that initializes origin to `originOne`. Also, the constructor sets width to 100 and height to 200. Now there are two references to the same `Point` object—an object can have multiple references to it, as shown in the next figure:

![Un oggetto rettangolo](https://dev.java/assets/images/classes-objects/02_rectangle-object.png)

A Rectangle Object

The following line of code calls the `Rectangle` constructor that requires two integer arguments, which provide the initial values for `width` and `height`. If you inspect the code within the constructor, you will see that it creates a new `Point` object whose `x` and `y` values are initialized to 0:

    Rectangle rectTwo = new Rectangle(50, 100);
    

Copy

The `Rectangle` constructor used in the following statement does not take any arguments, so it is called a no-argument constructor:

    Rectangle rect = new Rectangle();
    

Copy

Tutte le classi hanno almeno un costruttore. Se una classe non ne dichiara alcuna esplicitamente, il compilatore Java fornisce automaticamente un costruttore senza argomenti, chiamato costruttore predefinito. Questo costruttore predefinito chiama il costruttore senza argomenti del genitore della classe o il `Object`costruttore se la classe non ha altri genitori. Se il genitore non ha un costruttore ( `Object`ne ha uno), il compilatore rifiuterà il programma.

 

Usare gli oggetti
-----------------

Dopo aver creato un oggetto, probabilmente vorrai usarlo per qualcosa. Potrebbe essere necessario utilizzare il valore di uno dei suoi campi, modificare uno dei suoi campi o chiamare uno dei suoi metodi per eseguire un'azione.

### Fare riferimento ai campi di un oggetto

I campi oggetto sono accessibili tramite il loro nome. È necessario utilizzare un nome non ambiguo.

Puoi usare un nome semplice per un campo all'interno della sua stessa classe. Ad esempio, possiamo aggiungere un'istruzione all'interno della `Rectangle`classe che stampa `width`e `height`:

    System.out.println("Width and height are: " + width + ", " + height);
    

copia

In questo caso, `width`e `height`sono nomi semplici.

Il codice che si trova al di fuori della classe dell'oggetto deve utilizzare un riferimento o un'espressione a un oggetto, seguito dall'operatore punto ( `.`), seguito da un semplice nome di campo, come in:

    objectReference.fieldName
    

copia

Ad esempio, il codice della `CreateObjectDemo`classe è esterno al codice della `Rectangle`classe. Quindi, per fare riferimento ai campi , e all'interno `origin`dell'oggetto `width`denominato , la classe deve utilizzare rispettivamente i nomi , e . Il programma utilizza due di questi nomi per visualizzare il e il di :`height``Rectangle``rectOne``CreateObjectDemo``rectOne.origin``rectOne.width``rectOne.height``width``height``rectOne`

    System.out.println("Width of rectOne: "  + rectOne.width);
    System.out.println("Height of rectOne: " + rectOne.height);
    

copia

Il tentativo di utilizzare i nomi semplici `width`e `height`dal codice nella `CreateObjectDemo`classe non ha senso — quei campi esistono solo all'interno di un oggetto — e provoca un errore del compilatore.

Successivamente, il programma utilizza un codice simile per visualizzare informazioni su `rectTwo`. Gli oggetti dello stesso tipo hanno la propria copia degli stessi campi di istanza. Pertanto, ogni `Rectangle`oggetto ha campi denominati `origin`, `width`, e `height`. Quando accedi a un campo di istanza tramite un riferimento a un oggetto, fai riferimento al campo di quel particolare oggetto. I due oggetti `rectOne`e `rectTwo`nel `CreateObjectDemo`programma hanno campi `origin`, `width`e diversi.`height`

Per accedere a un campo, puoi utilizzare un riferimento denominato a un oggetto, come negli esempi precedenti, oppure puoi utilizzare qualsiasi espressione che restituisca un riferimento a un oggetto. Ricordiamo che l' `new`operatore restituisce un riferimento a un oggetto. Quindi potresti usare il valore restituito da new per accedere ai campi di un nuovo oggetto:

    int height = new Rectangle().height;
    

copia

Questa istruzione crea un nuovo `Rectangle`oggetto e ottiene immediatamente il suo `height`. In sostanza, l'istruzione calcola l'altezza predefinita di un `Rectangle`. Si noti che dopo che questa istruzione è stata eseguita, il programma non ha più un riferimento a create `Rectangle`, perché il programma non ha mai memorizzato il riferimento da nessuna parte. L'oggetto non è referenziato e le sue risorse possono essere riciclate dalla Java Virtual Machine.

### Chiamare i metodi di un oggetto

È inoltre possibile utilizzare un riferimento a un oggetto per richiamare il metodo di un oggetto. Aggiungi il nome semplice del metodo al riferimento all'oggetto, con un operatore punto intermedio ( `.`). Inoltre, fornisci, tra parentesi, tutti gli argomenti del metodo. Se il metodo non richiede alcun argomento, utilizzare parentesi vuote.

    objectReference.methodName(argumentList);
    

copia

o:

    objectReference.methodName();
    

copia

La `Rectangle`classe ha due metodi: `getArea()`per calcolare l'area del rettangolo e `move()`per cambiare l'origine del rettangolo. Ecco il `CreateObjectDemo`codice che invoca questi due metodi:

    System.out.println("Area of rectOne: " + rectOne.getArea());
    ...
    rectTwo.move(40, 72);
    

copia

La prima istruzione richiama `rectOne`il `getArea()`metodo di e visualizza i risultati. La seconda riga si sposta `rectTwo`perché il `move()`metodo assegna nuovi valori all'oggetto `origin.x`e `origin.y`.

Come per i campi di istanza, `objectReference`deve essere un riferimento a un oggetto. È possibile utilizzare un nome di variabile, ma è anche possibile utilizzare qualsiasi espressione che restituisce un riferimento a un oggetto. L' `new`operatore restituisce un riferimento a un oggetto, quindi puoi utilizzare il valore restituito da `new`per richiamare i metodi di un nuovo oggetto:

    new Rectangle(100, 50).getArea()
    

copia

L'espressione `new Rectangle(100, 50)`restituisce un riferimento a un oggetto che fa riferimento a un `Rectangle`oggetto. Come mostrato, puoi usare la notazione del punto per invocare il metodo new `Rectangle`per `getArea()`calcolare l'area del nuovo rettangolo.

Alcuni metodi, come `getArea()`, restituiscono un valore. Per i metodi che restituiscono un valore, puoi usare la chiamata al metodo nelle espressioni. Puoi assegnare il valore di ritorno a una variabile, usarlo per prendere decisioni o controllare un ciclo. Questo codice assegna il valore restituito da `getArea()`alla variabile `areaOfRectangle`:

    int areaOfRectangle = new Rectangle(100, 50).getArea();
    

copia

In questo caso, l'oggetto su cui `getArea()`viene invocato è il rettangolo restituito dal costruttore.

 

Il raccoglitore di rifiuti
--------------------------

Alcuni linguaggi orientati agli oggetti richiedono che tu tenga traccia di tutti gli oggetti che crei e che tu li distrugga esplicitamente quando non sono più necessari. Gestire la memoria in modo esplicito è noioso e soggetto a errori. La piattaforma Java ti consente di creare tutti gli oggetti che desideri (limitato, ovviamente, da ciò che il tuo sistema può gestire) e non devi preoccuparti di distruggerli. L'ambiente di runtime Java elimina gli oggetti quando determina che non vengono più utilizzati. Questo processo è chiamato Garbage Collection.

Un oggetto è idoneo per la Garbage Collection quando non ci sono più riferimenti a quell'oggetto. I riferimenti contenuti in una variabile vengono in genere eliminati quando la variabile esce dall'ambito. Oppure puoi eliminare in modo esplicito un riferimento a un oggetto impostando la variabile sul valore speciale `null`. Ricorda che un programma può avere più riferimenti allo stesso oggetto; tutti i riferimenti a un oggetto devono essere eliminati prima che l'oggetto sia idoneo per la Garbage Collection.

L'ambiente di runtime Java dispone di un Garbage Collector che libera periodicamente la memoria utilizzata dagli oggetti a cui non viene più fatto riferimento. Il Garbage Collector fa il suo lavoro automaticamente quando determina che è il momento giusto.

