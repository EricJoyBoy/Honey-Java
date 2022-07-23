

Creazione di array nei tuoi programmi
=====================================

 

Matrici
-------

Un _array_ è un oggetto contenitore che contiene un numero fisso di valori di un singolo tipo. La lunghezza di un array viene stabilita al momento della creazione dell'array. Dopo la creazione, la sua lunghezza è fissata. Hai già visto un esempio di array, nel metodo principale di "Hello World!" applicazione. Questa sezione discute gli array in modo più dettagliato.

![Una matrice di 8 elementi.](https://dev.java/assets/images/language-basics/01_array.png)

Una matrice di 8 elementi.

Ogni elemento in un array è chiamato _elemento_ ea ciascun elemento si accede dal suo _indice_ numerico . Come mostrato nell'illustrazione precedente, la numerazione inizia con 0. Il 6° elemento, ad esempio, sarebbe quindi accessibile all'indice 5.

Il programma seguente, `ArrayDemo`, crea un array di numeri interi, inserisce alcuni valori nell'array e stampa ogni valore sullo standard output.

    class ArrayDemo {
        public static void main(String[] args) {
            // declares an array of integers
            int[] anArray;
    
            // allocates memory for 10 integers
            anArray = new int[10];
               
            // initialize first element
            anArray[0] = 100;
            // initialize second element
            anArray[1] = 200;
            // and so forth
            anArray[2] = 300;
            anArray[3] = 400;
            anArray[4] = 500;
            anArray[5] = 600;
            anArray[6] = 700;
            anArray[7] = 800;
            anArray[8] = 900;
            anArray[9] = 1000;
    
            System.out.println("Element at index 0: "
                               + anArray[0]);
            System.out.println("Element at index 1: "
                               + anArray[1]);
            System.out.println("Element at index 2: "
                               + anArray[2]);
            System.out.println("Element at index 3: "
                               + anArray[3]);
            System.out.println("Element at index 4: "
                               + anArray[4]);
            System.out.println("Element at index 5: "
                               + anArray[5]);
            System.out.println("Element at index 6: "
                               + anArray[6]);
            System.out.println("Element at index 7: "
                               + anArray[7]);
            System.out.println("Element at index 8: "
                               + anArray[8]);
            System.out.println("Element at index 9: "
                               + anArray[9]);
        }
    } 
    

copia

L'output di questo programma è:

    Element at index 0: 100
    Element at index 1: 200
    Element at index 2: 300
    Element at index 3: 400
    Element at index 4: 500
    Element at index 5: 600
    Element at index 6: 700
    Element at index 7: 800
    Element at index 8: 900
    Element at index 9: 1000
    

copia

In una situazione di programmazione reale, probabilmente utilizzeresti uno dei costrutti di loop supportati per scorrere ogni elemento dell'array, piuttosto che scrivere ogni riga individualmente come nell'esempio precedente. Tuttavia, l'esempio illustra chiaramente la sintassi dell'array. Imparerai a conoscere i vari costrutti di loop (for, while e do-while) nella sezione [Flusso di controllo](/learn/control-flow-statements/) .

 

Dichiarazione di una variabile per fare riferimento a un array
--------------------------------------------------------------

Il programma precedente dichiara un array (named `anArray`) con la seguente riga di codice:

    // declares an array of integers
    int[] anArray;
    

copia

Come le dichiarazioni per variabili di altri tipi, una dichiarazione di array ha due componenti: il tipo dell'array e il nome dell'array. Il tipo di un array viene scritto come `type[]`, dove `type`è il tipo di dati degli elementi contenuti; le parentesi sono simboli speciali che indicano che questa variabile contiene una matrice. La dimensione dell'array non fa parte del suo tipo (motivo per cui le parentesi sono vuote). Il nome di un array può essere qualsiasi cosa tu voglia, a condizione che segua le regole e le convenzioni discusse nella sezione [Classi](/learn/creating-classes/) . Come per le variabili di altri tipi, la dichiarazione in realtà non crea un array; dice semplicemente al compilatore che questa variabile conterrà un array del tipo specificato.

Allo stesso modo, puoi dichiarare array di altri tipi:

    byte[] anArrayOfBytes;
    short[] anArrayOfShorts;
    long[] anArrayOfLongs;
    float[] anArrayOfFloats;
    double[] anArrayOfDoubles;
    boolean[] anArrayOfBooleans;
    char[] anArrayOfChars;
    String[] anArrayOfStrings;
    

copia

Puoi anche inserire le parentesi dopo il nome dell'array:

    // this form is discouraged
    float anArrayOfFloats[];
    

copia

Tuttavia, la convenzione scoraggia questa forma; le parentesi identificano il tipo di array e dovrebbero apparire con la designazione del tipo.

 

Creazione, inizializzazione e accesso a un array
------------------------------------------------

Un modo per creare un array è con l' `new`operatore. L'istruzione successiva nel `ArrayDemo`programma alloca un array con memoria sufficiente per 10 elementi interi e assegna l'array alla `anArray`variabile.

    // create an array of integers
    anArray = new int[10];
    

copia

Se questa istruzione è mancante, il compilatore stampa un errore simile al seguente e la compilazione non riesce:

    ArrayDemo.java:4: Variable anArray may not have been initialized.
    

copia

Le righe successive assegnano valori a ciascun elemento dell'array:

    anArray[0] = 100; // initialize first element
    anArray[1] = 200; // initialize second element
    anArray[2] = 300; // and so forth
    

copia

Ad ogni elemento dell'array si accede dal suo indice numerico:

    System.out.println("Element 1 at index 0: " + anArray[0]);
    System.out.println("Element 2 at index 1: " + anArray[1]);
    System.out.println("Element 3 at index 2: " + anArray[2]);
    

copia

In alternativa, puoi utilizzare la sintassi del collegamento per creare e inizializzare un array:

    int[] anArray = { 
        100, 200, 300,
        400, 500, 600, 
        700, 800, 900, 1000
    };
    

copia

Qui la lunghezza dell'array è determinata dal numero di valori forniti tra parentesi graffe e separati da virgole.

Puoi anche dichiarare una matrice di matrici (nota anche come matrice multidimensionale) utilizzando due o più insiemi di parentesi, ad esempio i `String[][]`nomi. Ad ogni elemento, quindi, deve accedere un numero corrispondente di valori di indice.

Nel linguaggio di programmazione Java, un array multidimensionale è un array i cui componenti sono essi stessi array. Questo è diverso dagli array in C o Fortran. Una conseguenza di ciò è che le righe possono variare in lunghezza, come mostrato nel seguente `MultiDimArrayDemo`programma:

    class MultiDimArrayDemo {
        public static void main(String[] args) {
            String[][] names = {
                {"Mr. ", "Mrs. ", "Ms. "},
                {"Smith", "Jones"}
            };
            // Mr. Smith
            System.out.println(names[0][0] + names[1][0]);
            // Ms. Jones
            System.out.println(names[0][2] + names[1][1]);
        }
    }
    

copia

L'output di questo programma è:

    Mr. Smith
    Ms. Jones
    

copia

Infine, puoi utilizzare la `length`proprietà incorporata per determinare la dimensione di qualsiasi matrice. Il codice seguente stampa la dimensione dell'array sullo standard output:

    System.out.println(anArray.length);
    

copia

 

Copia di array
--------------

La [`System`](https://docs.oracle.com/en/java/javase/18/docs/api/java.base/java/lang/System.html)classe ha un [`arraycopy()`](https://docs.oracle.com/en/java/javase/18/docs/api/java.base/java/lang/System.html#arraycopy(java.lang.Object,int,java.lang.Object,int,i))metodo che puoi usare per copiare in modo efficiente i dati da un array all'altro:

    public static void arraycopy(Object src, int srcPos,
                                 Object dest, int destPos, int length)
    

copia

I due `Object`argomenti specificano l'array da cui copiare e l'array in cui copiare. I tre `int`argomenti specificano la posizione iniziale nell'array di origine, la posizione iniziale nell'array di destinazione e il numero di elementi dell'array da copiare.

Il seguente programma, `ArrayCopyDemo`, dichiara un array di `String`elementi. Usa il [`System.arraycopy()`](https://docs.oracle.com/en/java/javase/18/docs/api/java.base/java/lang/System.html#arraycopy(java.lang.Object,int,java.lang.Object,int,i))metodo per copiare una sottosequenza di componenti dell'array in un secondo array:

    class ArrayCopyDemo {
        public static void main(String[] args) {
            String[] copyFrom = {
                "Affogato", "Americano", "Cappuccino", "Corretto", "Cortado",   
                "Doppio", "Espresso", "Frappucino", "Freddo", "Lungo", "Macchiato",      
                "Marocchino", "Ristretto" };
            
            String[] copyTo = new String[7];
            System.arraycopy(copyFrom, 2, copyTo, 0, 7);
            for (String coffee : copyTo) {
                System.out.print(coffee + " ");           
            }
        }
    }
    

copia

L'output di questo programma è:

    Cappuccino Corretto Cortado Doppio Espresso Frappucino Freddo
    

copia

 

Manipolazioni di array
----------------------

Gli array sono un concetto potente e utile utilizzato nella programmazione. Java SE fornisce metodi per eseguire alcune delle manipolazioni più comuni relative agli array. Ad esempio, l' `ArrayCopyDemo`esempio utilizza il [`arraycopy()`](https://docs.oracle.com/en/java/javase/18/docs/api/java.base/java/lang/System.html#arraycopy(java.lang.Object,int,java.lang.Object,int,i))metodo della [`System`](https://docs.oracle.com/en/java/javase/18/docs/api/java.base/java/lang/System.html)classe invece di scorrere manualmente gli elementi dell'array di origine e posizionarli ciascuno nell'array di destinazione. Questo viene eseguito dietro le quinte, consentendo allo sviluppatore di utilizzare solo una riga di codice per chiamare il metodo.

Per comodità, Java SE fornisce diversi metodi per eseguire manipolazioni di array (attività comuni, come la copia, l'ordinamento e la ricerca di array) nella [`java.util.Arrays`](https://docs.oracle.com/en/java/javase/18/docs/api/java.base/java/util/Arrays.html)classe. Ad esempio, l'esempio precedente può essere modificato per utilizzare il [`java.util.Arrays`](https://docs.oracle.com/en/java/javase/18/docs/api/java.base/java/util/Arrays.html)metodo della [`java.util.Arrays`](https://docs.oracle.com/en/java/javase/18/docs/api/java.base/java/util/Arrays.html)classe, come puoi vedere `ArrayCopyOfDemo`nell'esempio. La differenza è che l'utilizzo del [`java.util.Arrays`](https://docs.oracle.com/en/java/javase/18/docs/api/java.base/java/util/Arrays.html)metodo non richiede la creazione dell'array di destinazione prima di chiamare il metodo, poiché l'array di destinazione viene restituito dal metodo:

    class ArrayCopyOfDemo {
        public static void main(String[] args) {
            String[] copyFrom = {
                "Affogato", "Americano", "Cappuccino", "Corretto", "Cortado",   
                "Doppio", "Espresso", "Frappucino", "Freddo", "Lungo", "Macchiato",      
                "Marocchino", "Ristretto" };
            
            String[] copyTo = java.util.Arrays.copyOfRange(copyFrom, 2, 9);        
            for (String coffee : copyTo) {
                System.out.print(coffee + " ");           
            }            
        }
    }
    

copia

Come puoi vedere, l'output di questo programma è lo stesso, sebbene richieda meno righe di codice. Si noti che il secondo parametro del [`java.util.Arrays`](https://docs.oracle.com/en/java/javase/18/docs/api/java.base/java/util/Arrays.html)metodo è l'indice iniziale dell'intervallo da copiare, inclusivo, mentre il terzo parametro è l'indice finale dell'intervallo da copiare, in modo esclusivo. In questo esempio, l'intervallo da copiare non include l'elemento array all'indice 9 (che contiene la stringa `Lungo`).

Alcune altre operazioni utili fornite dai metodi nella [`java.util.Arrays`](https://docs.oracle.com/en/java/javase/18/docs/api/java.base/java/util/Arrays.html)classe sono:

*   Ricerca in un array di un valore specifico per ottenere l'indice a cui è posizionato (il [`binarySearch()`](https://docs.oracle.com/en/java/javase/18/docs/api/java.base/java/util/Arrays.html#binarySearch(int%5B%5D,int))metodo).
*   Confrontando due array per determinare se sono uguali o meno (il [`equals()`](https://docs.oracle.com/en/java/javase/18/docs/api/java.base/java/util/Arrays.html#equals(int%5B%5D,int%5B%5D))metodo).
*   Riempimento di una matrice per inserire un valore specifico in ogni indice (il [`fill()`](https://docs.oracle.com/en/java/javase/18/docs/api/java.base/java/util/Arrays.html#fill(int%5B%5D,int))metodo).
*   Ordinamento di un array in ordine crescente. Questa operazione può essere eseguita in sequenza, utilizzando il [`sort()`](https://docs.oracle.com/en/java/javase/18/docs/api/java.base/java/util/Arrays.html#sort(int%5B%5D))metodo, o contemporaneamente, utilizzando il [`parallelSort()`](https://docs.oracle.com/en/java/javase/18/docs/api/java.base/java/util/Arrays.html#parallelSort(int%5B%5D))metodo introdotto in Java SE 8. L'ordinamento parallelo di array di grandi dimensioni su sistemi multiprocessore è più veloce dell'ordinamento di array sequenziale.
*   Creazione di un flusso che utilizza un array come origine (il [`stream()`](https://docs.oracle.com/en/java/javase/18/docs/api/java.base/java/util/Arrays.html#stream(int%5B%5D))metodo). Ad esempio, la seguente istruzione stampa il contenuto `copyTo`dell'array come nell'esempio precedente:

    java.util.Arrays.stream(copyTo).map(coffee -> coffee + " ").forEach(System.out::print);  
    

copia

Vedere Operazioni di aggregazione per ulteriori informazioni sui flussi.

*   Conversione di un array in una stringa. Il [`toString()`](https://docs.oracle.com/en/java/javase/18/docs/api/java.base/java/util/Arrays.html#toString(int%5B%5D))metodo converte ogni elemento dell'array in una stringa, li separa con virgole, quindi li circonda tra parentesi. Ad esempio, la seguente istruzione converte l' `copyTo`array in una stringa e la stampa:

    System.out.println(java.util.Arrays.toString(copyTo));
    

copia

Questa dichiarazione stampa quanto segue:

    [Cappuccino, Corretto, Cortado, Doppio, Espresso, Frappucino, Freddo] 
    

copia

 

Avvolgimento di variabili e array
---------------------------------

Il linguaggio di programmazione Java utilizza sia "campi" che "variabili" come parte della sua terminologia. Le variabili di istanza (campi non statici) sono univoche per ciascuna istanza di una classe. Le variabili di classe (campi statici) sono campi dichiarati con il modificatore static; c'è esattamente una copia di una variabile di classe, indipendentemente da quante volte la classe è stata istanziata. Le variabili locali memorizzano lo stato temporaneo all'interno di un metodo. I parametri sono variabili che forniscono informazioni aggiuntive a un metodo; sia le variabili locali che i parametri sono sempre classificati come "variabili" (non "campi"). Quando assegni un nome ai tuoi campi o variabili, ci sono regole e convenzioni che dovresti (o devi) seguire.

Gli otto tipi di dati primitivi sono: `byte`, `short`, `int`, `long`, `float`, `double`, `boolean`, e `char`. La `java.lang.String`classe rappresenta le stringhe di caratteri. Il compilatore assegnerà un valore di default ragionevole per i campi dei tipi sopra indicati; per le variabili locali non viene mai assegnato un valore predefinito.

Un letterale è la rappresentazione del codice sorgente di un valore fisso. Un array è un oggetto contenitore che contiene un numero fisso di valori di un singolo tipo. La lunghezza di un array viene stabilita al momento della creazione dell'array. Dopo la creazione, la sua lunghezza è fissata.

 
  

