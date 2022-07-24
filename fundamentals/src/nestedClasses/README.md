
Classi nidificate
=================

 

Classi nidificate
-----------------

Il linguaggio di programmazione Java consente di definire una classe all'interno di un'altra classe. Tale classe è chiamata classe nidificata ed è illustrata qui:

    class OuterClass {
        ...
        class NestedClass {
            ...
        }
    }
    

copia

> Terminologia: le classi nidificate sono divise in due categorie: non statiche e statiche. Le classi nidificate non statiche sono chiamate _classi interne_ . Le classi nidificate dichiarate statiche sono chiamate _classi nidificate statiche_ .

    class OuterClass {
        ...
        class InnerClass {
            ...
        }
        static class StaticNestedClass {
            ...
        }
    }
    

copia

Una classe nidificata è un membro della sua classe che la racchiude. Le classi nidificate non statiche (classi interne) hanno accesso ad altri membri della classe di inclusione, anche se dichiarate `private`. Le classi nidificate statiche non hanno accesso ad altri membri della classe di inclusione. Come membro di `OuterClass`, una classe nidificata può essere dichiarata `private`, `public`, `protected`o pacchetto private. Ricordiamo che le classi esterne possono essere solo dichiarate `public`o private del pacchetto.

### Perché usare classi nidificate?

I motivi convincenti per l'utilizzo di classi nidificate includono quanto segue:

*   È un modo per raggruppare logicamente le classi che vengono utilizzate solo in un posto: se una classe è utile solo per un'altra classe, è logico incorporarla in quella classe e tenerle insieme. L'annidamento di tali "classi di supporto" rende il loro pacchetto più snello.
*   Aumenta l'incapsulamento: considera due classi di primo livello `A`e `B`, dove è `B`necessario l'accesso a membri `A`che altrimenti verrebbero dichiarati privati. Nascondendo class `B`all'interno di class `A`, `A`i membri di 's possono essere dichiarati `private`e `B`possono accedervi. Inoltre, `B`esso stesso può essere nascosto dal mondo esterno.
*   Può portare a un codice più leggibile e gestibile: l'annidamento di classi piccole all'interno di classi di livello superiore posiziona il codice più vicino a dove viene utilizzato.

### Classi interne

Come per i metodi e le variabili di istanza, una classe interna è associata a un'istanza della sua classe che la racchiude e ha accesso diretto ai metodi e ai campi di quell'oggetto. Inoltre, poiché una classe interna è associata a un'istanza, non può definire alcun membro statico.

Gli oggetti che sono istanze di una classe interna esistono all'interno di un'istanza della classe esterna. Considera le seguenti classi:

    class OuterClass {
        ...
        class InnerClass {
            ...
        }
    }
    

copia

Un'istanza di `InnerClass`può esistere solo all'interno di un'istanza di `OuterClass`e ha accesso diretto ai metodi e ai campi dell'istanza che la racchiude.

Per creare un'istanza di una classe interna, devi prima istanziare la classe esterna. Quindi, crea l'oggetto interno all'interno dell'oggetto esterno con questa sintassi:

    OuterClass outerObject = new OuterClass();
    OuterClass.InnerClass innerObject = outerObject.new InnerClass();
    

copia

Esistono due tipi speciali di classi interne: classi locali e classi anonime.

### Classi nidificate statiche

Come per i metodi e le variabili di classe, una classe nidificata statica è associata alla sua classe esterna. E come i metodi di classe static, una classe nidificata statica non può fare riferimento direttamente a variabili di istanza o metodi definiti nella sua classe che li racchiude: può usarli solo attraverso un riferimento a un oggetto. L'esempio di classe interna e classe statica nidificata lo dimostra.

> Nota: una classe nidificata statica interagisce con i membri di istanza della sua classe esterna (e di altre classi) proprio come qualsiasi altra classe di primo livello. In effetti, una classe nidificata statica è comportamentalmente una classe di primo livello che è stata nidificata in un'altra classe di primo livello per comodità di confezionamento. Anche l'esempio di classe interna e classe statica nidificata lo dimostra.

Istanzia una classe nidificata statica allo stesso modo di una classe di primo livello:

    StaticNestedClass staticNestedObject = new StaticNestedClass();
    

copia

### Esempio di classe interna e classe statica nidificata

L'esempio seguente `OuterClass`, insieme a `TopLevelClass`, mostra a quali membri della classe possono accedere `OuterClass`una classe interna ( `InnerClass`), una classe statica nidificata ( `StaticNestedClass`) e una classe di livello superiore ( `TopLevelClass`):

#### OuterClass.java

    public class OuterClass {
    
        String outerField = "Outer field";
        static String staticOuterField = "Static outer field";
    
        class InnerClass {
            void accessMembers() {
                System.out.println(outerField);
                System.out.println(staticOuterField);
            }
        }
    
        static class StaticNestedClass {
            void accessMembers(OuterClass outer) {
                // Compiler error: Cannot make a static reference to the non-static
                //     field outerField
                // System.out.println(outerField);
                System.out.println(outer.outerField);
                System.out.println(staticOuterField);
            }
        }
    
        public static void main(String[] args) {
            System.out.println("Inner class:");
            System.out.println("------------");
            OuterClass outerObject = new OuterClass();
            OuterClass.InnerClass innerObject = outerObject.new InnerClass();
            innerObject.accessMembers();
    
            System.out.println("\nStatic nested class:");
            System.out.println("--------------------");
            StaticNestedClass staticNestedObject = new StaticNestedClass();
            staticNestedObject.accessMembers(outerObject);
    
            System.out.println("\nTop-level class:");
            System.out.println("--------------------");
            TopLevelClass topLevelObject = new TopLevelClass();
            topLevelObject.accessMembers(outerObject);
        }
    }
    

copia

#### TopLevelClass.java

    public class TopLevelClass {
    
        void accessMembers(OuterClass outer) {
            // Compiler error: Cannot make a static reference to the non-static
            //     field OuterClass.outerField
            // System.out.println(OuterClass.outerField);
            System.out.println(outer.outerField);
            System.out.println(OuterClass.staticOuterField);
        }
    }
    

copia

Questo esempio stampa il seguente output:

    Inner class:
    ------------
    Outer field
    Static outer field
    
    Static nested class:
    --------------------
    Outer field
    Static outer field
    
    Top-level class:
    --------------------
    Outer field
    Static outer field
    

copia

Si noti che una classe nidificata statica interagisce con i membri di istanza della sua classe esterna proprio come qualsiasi altra classe di primo livello. La classe nidificata statica `StaticNestedClass`non può accedere direttamente `outerField`perché è una variabile di istanza della classe che la racchiude, `OuterClass`. Il compilatore Java genera un errore nell'istruzione evidenziata:

    static class StaticNestedClass {
        void accessMembers(OuterClass outer) {
           // Compiler error: Cannot make a static reference to the non-static
           //     field outerField
           System.out.println(outerField);
        }
    }
    

copia

Per correggere questo errore, accedere `outerField`tramite un riferimento a un oggetto:

    System.out.println(outer.outerField);
    

copia

Allo stesso modo, neanche la classe di livello superiore `TopLevelClass`non può accedere direttamente `outerField`.

### Ombreggiatura

Se una dichiarazione di un tipo (come una variabile membro o un nome di parametro) in un particolare ambito (come una classe interna o una definizione di metodo) ha lo stesso nome di un'altra dichiarazione nell'ambito di inclusione, la dichiarazione oscura la dichiarazione dell'ambito di inclusione. Non puoi fare riferimento a una dichiarazione ombreggiata solo con il suo nome. L'esempio seguente, `ShadowTest`, lo dimostra:

    public class ShadowTest {
    
        public int x = 0;
    
        class FirstLevel {
    
            public int x = 1;
    
            void methodInFirstLevel(int x) {
                System.out.println("x = " + x);
                System.out.println("this.x = " + this.x);
                System.out.println("ShadowTest.this.x = " + ShadowTest.this.x);
            }
        }
    
        public static void main(String... args) {
            ShadowTest st = new ShadowTest();
            ShadowTest.FirstLevel fl = st.new FirstLevel();
            fl.methodInFirstLevel(23);
        }
    }
    

copia

Quello che segue è l'output di questo esempio:

    x = 23
    this.x = 1
    ShadowTest.this.x = 0
    

copia

Questo esempio definisce tre variabili denominate `x`: la variabile membro della classe `ShadowTest`, la variabile membro della classe interna `FirstLevel`e il parametro nel metodo `methodInFirstLevel()`. La variabile `x`definita come parametro del metodo `methodInFirstLevel()`oscura la variabile della classe interna `FirstLevel`. Di conseguenza, quando si utilizza la variabile `x`nel metodo `methodInFirstLevel()`, fa riferimento al parametro del metodo. Per fare riferimento alla variabile membro della classe interna `FirstLevel`, utilizzare la parola chiave `this`per rappresentare l'ambito di inclusione:

    System.out.println("this.x = " + this.x);
    

copia

Fare riferimento alle variabili membro che racchiudono ambiti più grandi in base al nome della classe a cui appartengono. Ad esempio, la seguente istruzione accede alla variabile membro della classe `ShadowTest`dal metodo `methodInFirstLevel()`:

    System.out.println("ShadowTest.this.x = " + ShadowTest.this.x);
    

copia

### Serializzazione

La serializzazione delle classi interne, comprese le classi locali e anonime, è fortemente sconsigliata. Quando il compilatore Java compila determinati costrutti, come le classi interne, crea costrutti sintetici; si tratta di classi, metodi, campi e altri costrutti che non hanno un costrutto corrispondente nel codice sorgente. I costrutti sintetici consentono ai compilatori Java di implementare nuove funzionalità del linguaggio Java senza modifiche alla JVM.

Tuttavia, i costrutti sintetici possono variare tra le diverse implementazioni del compilatore Java, il che significa che `.class`i file possono variare anche tra le diverse implementazioni. Di conseguenza, potresti avere problemi di compatibilità se serializzi una classe interna e poi la deserializzi con un'implementazione JRE diversa.

 

Esempio di classe interna
-------------------------

Per vedere una classe interna in uso, considera prima un array. Nell'esempio seguente si crea una matrice, la si riempie con valori interi e quindi si generano solo i valori di indici pari della matrice in ordine crescente.

L' `DataStructure.java`esempio che segue è composto da:

*   La `DataStructure`classe esterna, che include un costruttore per creare un'istanza `DataStructure`contenente un array riempito con valori interi consecutivi (0, 1, 2, 3 e così via) e un metodo che stampa gli elementi dell'array che hanno un valore di indice pari.
*   La `EvenIterator`classe interna, che implementa l' `DataStructureIterator`interfaccia, che estende l' `Iterator< Integer>`interfaccia. Gli iteratori vengono utilizzati per scorrere una struttura di dati e in genere dispongono di metodi per verificare l'ultimo elemento, recuperare l'elemento corrente e passare all'elemento successivo.
*   Un metodo principale che crea un'istanza di un `DataStructure`oggetto ( `ds`), quindi richiama il `printEven()`metodo per stampare gli elementi dell'array `arrayOfInts`che hanno un valore di indice pari.

    public class DataStructure {
    
        // Create an array
        private final static int SIZE = 15;
        private int[] arrayOfInts = new int[SIZE];
    
        public DataStructure() {
            // fill the array with ascending integer values
            for (int i = 0; i < SIZE; i++) {
                arrayOfInts[i] = i;
            }
        }
    
        public void printEven() {
    
            // Print out values of even indices of the array
            DataStructureIterator iterator = this.new EvenIterator();
            while (iterator.hasNext()) {
                System.out.print(iterator.next() + " ");
            }
            System.out.println();
        }
    
        interface DataStructureIterator extends java.util.Iterator<Integer> { }
    
        // Inner class implements the DataStructureIterator interface,
        // which extends the Iterator<Integer> interface
    
        private class EvenIterator implements DataStructureIterator {
    
            // Start stepping through the array from the beginning
            private int nextIndex = 0;
    
            public boolean hasNext() {
    
                // Check if the current element is the last in the array
                return (nextIndex <= SIZE - 1);
            }
    
            public Integer next() {
    
                // Record a value of an even index of the array
                Integer retValue = Integer.valueOf(arrayOfInts[nextIndex]);
    
                // Get the next even element
                nextIndex += 2;
                return retValue;
            }
        }
    
        public static void main(String s[]) {
    
            // Fill the array with integer values and print out only
            // values of even indices
            DataStructure ds = new DataStructure();
            ds.printEven();
        }
    }
    

copia

L'uscita è:

    0 2 4 6 8 10 12 14
    

copia

Si noti che la `EvenIterator`classe fa riferimento direttamente alla `arrayOfInts`variabile di istanza `DataStructure`dell'oggetto.

È possibile utilizzare le classi interne per implementare classi helper come quella mostrata in questo esempio. Per gestire gli eventi dell'interfaccia utente, è necessario sapere come utilizzare le classi interne, poiché il meccanismo di gestione degli eventi ne fa ampio uso.

### Classi locali e anonime

Ci sono due tipi aggiuntivi di classi interne. Puoi dichiarare una classe interna all'interno del corpo di un metodo. Queste classi sono conosciute come classi locali. Puoi anche dichiarare una classe interna all'interno del corpo di un metodo senza nominare la classe. Queste classi sono note come classi anonime.

### Modificatori

Puoi usare gli stessi modificatori per le classi interne che usi per gli altri membri della classe esterna. Ad esempio, puoi utilizzare gli identificatori di accesso `private`, `public`e `protected`per limitare l'accesso alle classi interne, proprio come li usi per limitare l'accesso agli altri membri della classe.

 

Classi locali
-------------

Le classi locali sono classi definite in un blocco, che è un gruppo di zero o più istruzioni tra parentesi graffe bilanciate. In genere trovi classi locali definite nel corpo di un metodo.

Questa sezione tratta i seguenti argomenti:

*   Dichiarazione delle classi locali
*   Accesso ai membri di una classe di inclusione
*   Shadowing e classi locali
*   Le classi locali sono simili alle classi interne

### Dichiarazione delle classi locali

È possibile definire una classe locale all'interno di qualsiasi blocco (consultare Espressioni, istruzioni e blocchi per ulteriori informazioni). Ad esempio, puoi definire una classe locale nel corpo di un metodo, un ciclo for o una clausola if.

L'esempio seguente, `LocalClassExample`, convalida due numeri di telefono. Definisce la classe locale `PhoneNumber`nel metodo `validatePhoneNumber()`:

    public class LocalClassExample {
    
        static String regularExpression = "[^0-9]";
    
        public static void validatePhoneNumber(
            String phoneNumber1, String phoneNumber2) {
    
            final int numberLength = 10;
    
            // Valid in JDK 8 and later:
    
            // int numberLength = 10;
    
            class PhoneNumber {
    
                String formattedPhoneNumber = null;
    
                PhoneNumber(String phoneNumber){
                    // numberLength = 7;
                    String currentNumber = phoneNumber.replaceAll(
                      regularExpression, "");
                    if (currentNumber.length() == numberLength)
                        formattedPhoneNumber = currentNumber;
                    else
                        formattedPhoneNumber = null;
                }
    
                public String getNumber() {
                    return formattedPhoneNumber;
                }
    
                // Valid in JDK 8 and later:
    
    //            public void printOriginalNumbers() {
    //                System.out.println("Original numbers are " + phoneNumber1 +
    //                    " and " + phoneNumber2);
    //            }
            }
    
            PhoneNumber myNumber1 = new PhoneNumber(phoneNumber1);
            PhoneNumber myNumber2 = new PhoneNumber(phoneNumber2);
    
            // Valid in JDK 8 and later:
    
    //        myNumber1.printOriginalNumbers();
    
            if (myNumber1.getNumber() == null)
                System.out.println("First number is invalid");
            else
                System.out.println("First number is " + myNumber1.getNumber());
            if (myNumber2.getNumber() == null)
                System.out.println("Second number is invalid");
            else
                System.out.println("Second number is " + myNumber2.getNumber());
    
        }
    
        public static void main(String... args) {
            validatePhoneNumber("123-456-7890", "456-7890");
        }
    }
    

copia

L'esempio convalida un numero di telefono rimuovendo prima tutti i caratteri dal numero di telefono eccetto le cifre da 0 a 9. Successivamente, controlla se il numero di telefono contiene esattamente dieci cifre (la lunghezza di un numero di telefono in Nord America). Questo esempio stampa quanto segue:

    First number is 1234567890
    Second number is invalid
    

copia

### Accesso ai membri di una classe di inclusione

Una classe locale ha accesso ai membri della sua classe che la racchiude. Nell'esempio precedente, il `PhoneNumber()`costruttore accede al membro `LocalClassExample.regularExpression`.

Inoltre, una classe locale ha accesso alle variabili locali. Tuttavia, una classe locale può accedere solo alle variabili locali dichiarate `final`. Quando una classe locale accede a una variabile locale oa un parametro del blocco di inclusione, acquisisce quella variabile o parametro. Ad esempio, il `PhoneNumber()`costruttore può accedere alla variabile locale `numberLength`perché è dichiarata `final`; `numberLength`è una variabile catturata.

Tuttavia, a partire da Java SE 8, una classe locale può accedere a variabili locali e parametri del blocco di inclusione che sono `final`o _effettivamente final_ . Una variabile o un parametro il cui valore non viene mai modificato dopo l'inizializzazione è _effettivamente final_ . Ad esempio, supponiamo che la variabile `numberLength`non sia dichiarata `final`e aggiungi l'istruzione di assegnazione evidenziata nel `PhoneNumber()`costruttore per modificare la lunghezza di un numero di telefono valido in 7 cifre:

    PhoneNumber(String phoneNumber) {
        numberLength = 7;
        String currentNumber = phoneNumber.replaceAll(
            regularExpression, "");
        if (currentNumber.length() == numberLength)
            formattedPhoneNumber = currentNumber;
        else
            formattedPhoneNumber = null;
    }
    

copia

A causa di questa istruzione di assegnazione, la variabile `numberLength`non è più effettivamente definitiva. Di conseguenza, il compilatore Java genera un messaggio di errore simile a "le variabili locali a cui fa riferimento una classe interna devono essere finali o effettivamente finali" in cui la classe interna `PhoneNumber`tenta di accedere alla `numberLength`variabile:

    if (currentNumber.length() == numberLength)
    

copia

A partire da Java SE 8, se si dichiara la classe locale in un metodo, può accedere ai parametri del metodo. Ad esempio, puoi definire il seguente metodo nella `PhoneNumber`classe locale:

    public void printOriginalNumbers() {
        System.out.println("Original numbers are " + phoneNumber1 +
            " and " + phoneNumber2);
    }
    

copia

Il metodo `printOriginalNumbers()`accede ai parametri `phoneNumber1`e `phoneNumber2`del metodo `validatePhoneNumber()`.

Dichiarazioni di un tipo (come una variabile) in una classe locale dichiarazioni shadow nell'ambito di inclusione che hanno lo stesso nome. Per ulteriori informazioni, vedere Ombreggiatura.

### Le classi locali sono simili alle classi interne

Le classi locali sono simili alle classi interne perché non possono definire o dichiarare alcun membro statico. Le classi locali nei metodi statici, come la classe `PhoneNumber`, definita nel metodo statico `validatePhoneNumber()`, possono fare riferimento solo a membri statici della classe di inclusione. Ad esempio, se non si definisce la variabile membro `regularExpression`come `static`, il compilatore Java genera un errore simile a "Impossibile fare riferimento alla variabile non statica regularExpression da un contesto statico".

Le classi locali non sono statiche perché hanno accesso ai membri dell'istanza del blocco di inclusione. Di conseguenza, non possono contenere la maggior parte dei tipi di dichiarazioni statiche.

Non puoi dichiarare un'interfaccia all'interno di un blocco; le interfacce sono intrinsecamente statiche. Ad esempio, il seguente estratto di codice non viene compilato perché l'interfaccia `HelloThere`è definita all'interno del corpo del metodo `greetInEnglish()`:

    public void greetInEnglish() {
        interface HelloThere {
           public void greet();
        }
        class EnglishHelloThere implements HelloThere {
            public void greet() {
                System.out.println("Hello " + name);
            }
        }
        HelloThere myGreeting = new EnglishHelloThere();
        myGreeting.greet();
    }
    

copia

Non è possibile dichiarare inizializzatori statici o interfacce membro in una classe locale. Il seguente estratto di codice non viene compilato perché il metodo `EnglishGoodbye.sayGoodbye()`è dichiarato statico. Il compilatore genera un errore simile a "il modificatore `static`è consentito solo nella dichiarazione di variabile costante" quando incontra questa definizione di metodo:

    public void sayGoodbyeInEnglish() {
        class EnglishGoodbye {
            public static void sayGoodbye() {
                System.out.println("Bye bye");
            }
        }
        EnglishGoodbye.sayGoodbye();
    }
    

copia

Una classe locale può avere membri statici a condizione che siano variabili costanti. (Una variabile costante è una variabile di tipo o tipo primitivo `String`dichiarata `final`e inizializzata con un'espressione costante in fase di compilazione. Un'espressione costante in fase di compilazione è in genere una stringa o un'espressione aritmetica che può essere valutata in fase di compilazione. Vedere Comprensione della classe Membri per ulteriori informazioni.) Il seguente estratto di codice viene compilato perché il membro statico `EnglishGoodbye.farewell`è una variabile costante:

    public void sayGoodbyeInEnglish() {
        class EnglishGoodbye {
            public static final String farewell = "Bye bye";
            public void sayGoodbye() {
                System.out.println(farewell);
            }
        }
        EnglishGoodbye myEnglishGoodbye = new EnglishGoodbye();
        myEnglishGoodbye.sayGoodbye();
    }
    

copia

 

Classi anonime
--------------

Le classi anonime ti consentono di rendere il tuo codice più conciso. Consentono di dichiarare e creare un'istanza di una classe allo stesso tempo. Sono come le classi locali tranne per il fatto che non hanno un nome. Usali se devi usare una classe locale solo una volta.

### Dichiarazione di classi anonime

Mentre le classi locali sono dichiarazioni di classe, le classi anonime sono espressioni, il che significa che si definisce la classe in un'altra espressione. L'esempio seguente, `HelloWorldAnonymousClasses`, utilizza classi anonime nelle istruzioni di inizializzazione delle variabili locali `frenchGreeting`e `spanishGreeting`, ma utilizza una classe locale per l'inizializzazione della variabile `englishGreeting`:

    public class HelloWorldAnonymousClasses {
    
        interface HelloWorld {
            public void greet();
            public void greetSomeone(String someone);
        }
    
        public void sayHello() {
    
            class EnglishGreeting implements HelloWorld {
                String name = "world";
                public void greet() {
                    greetSomeone("world");
                }
                public void greetSomeone(String someone) {
                    name = someone;
                    System.out.println("Hello " + name);
                }
            }
    
            HelloWorld englishGreeting = new EnglishGreeting();
    
            HelloWorld frenchGreeting = new HelloWorld() {
                String name = "tout le monde";
                public void greet() {
                    greetSomeone("tout le monde");
                }
                public void greetSomeone(String someone) {
                    name = someone;
                    System.out.println("Salut " + name);
                }
            };
    
            HelloWorld spanishGreeting = new HelloWorld() {
                String name = "mundo";
                public void greet() {
                    greetSomeone("mundo");
                }
                public void greetSomeone(String someone) {
                    name = someone;
                    System.out.println("Hola, " + name);
                }
            };
            englishGreeting.greet();
            frenchGreeting.greetSomeone("Fred");
            spanishGreeting.greet();
        }
    
        public static void main(String... args) {
            HelloWorldAnonymousClasses myApp =
                new HelloWorldAnonymousClasses();
            myApp.sayHello();
        }
    }
    

copia

### Sintassi delle classi anonime

Come accennato in precedenza, una classe anonima è un'espressione. La sintassi di un'espressione di classe anonima è come l'invocazione di un costruttore, tranne per il fatto che esiste una definizione di classe contenuta in un blocco di codice.

Considera l'istanza `frenchGreeting`dell'oggetto:

    HelloWorld frenchGreeting = new HelloWorld() {
        String name = "tout le monde";
        public void greet() {
            greetSomeone("tout le monde");
        }
        public void greetSomeone(String someone) {
            name = someone;
            System.out.println("Salut " + name);
        }
    };
    

copia

L'espressione di classe anonima è composta da:

*   L' `new`operatore
*   Il nome di un'interfaccia da implementare o di una classe da estendere. In questo esempio, la classe anonima sta implementando l'interfaccia `HelloWorld`.
*   Parentesi che contengono gli argomenti di un costruttore, proprio come una normale espressione di creazione di un'istanza di classe. Nota: quando si implementa un'interfaccia, non esiste un costruttore, quindi si utilizza una coppia di parentesi vuote, come in questo esempio.
*   Un corpo, che è un corpo di dichiarazione di classe. Più precisamente, nel corpo sono consentite dichiarazioni di metodo ma non le dichiarazioni.
*   Poiché una definizione di classe anonima è un'espressione, deve far parte di un'istruzione. In questo esempio, l'espressione di classe anonima fa parte dell'istruzione che crea un'istanza `frenchGreeting`dell'oggetto. (Questo spiega perché c'è un punto e virgola dopo la parentesi graffa di chiusura.)

### Accesso alle variabili locali dell'ambito di inclusione e dichiarazione e accesso ai membri della classe anonima

Come le classi locali, le classi anonime possono acquisire variabili; hanno lo stesso accesso alle variabili locali dell'ambito di inclusione:

*   Una classe anonima ha accesso ai membri della sua classe che la racchiude.
*   Una classe anonima non può accedere a variabili locali nel suo ambito di inclusione che non sono dichiarate come finali o effettivamente finali.
*   Come una classe nidificata, una dichiarazione di un tipo (come una variabile) in una classe anonima nasconde qualsiasi altra dichiarazione nell'ambito di inclusione che ha lo stesso nome. Per ulteriori informazioni, vedere Ombreggiatura.

Le classi anonime hanno anche le stesse restrizioni delle classi locali per quanto riguarda i loro membri:

*   Non è possibile dichiarare inizializzatori statici o interfacce membro in una classe anonima.
*   Una classe anonima può avere membri statici a condizione che siano variabili costanti.

Nota che puoi dichiarare quanto segue in classi anonime:

*   Campi
*   Metodi extra (anche se non implementano alcun metodo del supertipo)
*   Inizializzatori di istanze
*   Classi locali

Tuttavia, non puoi dichiarare costruttori in una classe anonima.

