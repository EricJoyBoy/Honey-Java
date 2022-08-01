

stringhe
========

 

Creazione di stringhe
---------------------

Le stringhe, ampiamente utilizzate nella programmazione Java, sono una sequenza di caratteri. Nel linguaggio di programmazione Java, le stringhe sono oggetti.

La piattaforma Java fornisce la [`String`](https://docs.oracle.com/en/java/javase/18/docs/api/java.base/java/lang/String.html)classe per creare e manipolare stringhe.

Il modo più diretto per creare una stringa è scrivere:

    String greeting = "Hello world!";
    

copia

In questo caso, "Ciao mondo!" è una stringa letterale, una serie di caratteri nel codice racchiusa tra virgolette. Ogni volta che incontra una stringa letterale nel codice, il compilatore crea un [`String`](https://docs.oracle.com/en/java/javase/18/docs/api/java.base/java/lang/String.html)oggetto con il suo valore, in questo caso _Hello world!_ .

Come con qualsiasi altro oggetto, puoi creare [`String`](https://docs.oracle.com/en/java/javase/18/docs/api/java.base/java/lang/String.html)oggetti usando la `new`parola chiave e un costruttore. La [`String`](https://docs.oracle.com/en/java/javase/18/docs/api/java.base/java/lang/String.html)classe ha tredici costruttori che consentono di fornire il valore iniziale della stringa utilizzando origini diverse, ad esempio una matrice di caratteri:

    char[] helloArray = { 'h', 'e', 'l', 'l', 'o', '.' };
    String helloString = new String(helloArray);
    System.out.println(helloString);
    

copia

Viene visualizzata l'ultima riga di questo frammento di codice `hello`.

> Nota: la [`String`](https://docs.oracle.com/en/java/javase/18/docs/api/java.base/java/lang/String.html)classe è immutabile, quindi una volta creata un [`String`](https://docs.oracle.com/en/java/javase/18/docs/api/java.base/java/lang/String.html)oggetto non può essere modificato. La [`String`](https://docs.oracle.com/en/java/javase/18/docs/api/java.base/java/lang/String.html)classe ha un certo numero di metodi, alcuni dei quali verranno discussi di seguito, che sembrano modificare le stringhe. Poiché le stringhe non sono modificabili, ciò che fanno realmente questi metodi è creare e restituire una nuova stringa che contenga il risultato dell'operazione.

 

Lunghezza della corda
---------------------

I metodi utilizzati per ottenere informazioni su un oggetto sono noti come metodi di accesso. Un metodo di accesso che puoi usare con le stringhe è il [`length()`](https://docs.oracle.com/en/java/javase/18/docs/api/java.base/java/lang/String.html#length())metodo, che restituisce il numero di caratteri contenuti nell'oggetto stringa. Dopo che le seguenti due righe di codice sono state eseguite, `len`è uguale a 17:

    String palindrome = "Dot saw I was Tod";
    int len = palindrome.length();
    

copia

Un _palindromo_ è una parola o una frase che è simmetrica: è scritta allo stesso modo avanti e indietro, ignorando maiuscole e minuscole e punteggiatura. Ecco un programma breve e inefficiente per invertire una stringa palindroma. Invoca il [`String`](https://docs.oracle.com/en/java/javase/18/docs/api/java.base/java/lang/String.html)metodo [`charAt(i)`](https://docs.oracle.com/en/java/javase/18/docs/api/java.base/java/lang/String.html#charAt(int)), che restituisce l' _i - esimo_ carattere nella stringa, contando da 0.

    public class StringDemo {
        public static void main(String[] args) {
            String palindrome = "Dot saw I was Tod";
            int len = palindrome.length();
            char[] tempCharArray = new char[len];
            char[] charArray = new char[len];
            
            // put original string in an 
            // array of chars
            for (int i = 0; i < len; i++) {
                tempCharArray[i] = 
                    palindrome.charAt(i);
            } 
            
            // reverse array of chars
            for (int j = 0; j < len; j++) {
                charArray[j] =
                    tempCharArray[len - 1 - j];
            }
            
            String reversePalindrome =
                new String(charArray);
            System.out.println(reversePalindrome);
        }
    }
    

copia

L'esecuzione del programma produce questo output:

    doT saw I was toD
    

copia

Per eseguire l'inversione della stringa, il programma doveva convertire la stringa in un array di caratteri (primo `for`ciclo), invertire l'array in un secondo array (secondo `for`ciclo) e quindi riconvertire in una stringa. La [`String`](https://docs.oracle.com/en/java/javase/18/docs/api/java.base/java/lang/String.html)classe include un metodo, [`getChars()`](https://docs.oracle.com/en/java/javase/18/docs/api/java.base/java/lang/String.html#getChars(int,int,char%5B%5D,int)), per convertire una stringa, o una parte di una stringa, in un array di caratteri in modo da poter sostituire il primo ciclo for nel programma sopra con

    palindrome.getChars(0, len, tempCharArray, 0);
    

copia

 

Stringhe concatenate
--------------------

La [`String`](https://docs.oracle.com/en/java/javase/18/docs/api/java.base/java/lang/String.html)classe include un metodo per concatenare due stringhe:

    string1.concat(string2); 
    

copia

Questo restituisce una nuova stringa che viene aggiunta `string1`alla `string2`fine.

Puoi anche usare il [`concat()`](https://docs.oracle.com/en/java/javase/18/docs/api/java.base/java/lang/String.html#concat(java.lang.String))metodo con stringhe letterali, come in:

    "My name is ".concat("Rumplestiltskin");
    

copia

Le stringhe sono più comunemente concatenate con l' `+`operatore, come in

    "Hello," + " world" + "!"
    

copia

che si traduce in

    "Hello, world!"
    

copia

L' `+`operatore è ampiamente utilizzato nelle istruzioni di stampa. Per esempio:

    String string1 = "saw I was ";
    System.out.println("Dot " + string1 + "Tod");
    

copia

che stampa

    Dot saw I was Tod
    

copia

Tale concatenazione può essere una miscela di qualsiasi oggetto. Per ogni oggetto che non è un [`String`](https://docs.oracle.com/en/java/javase/18/docs/api/java.base/java/lang/String.html), viene chiamato il relativo [`toString()`](https://docs.oracle.com/en/java/javase/18/docs/api/java.base/java/lang/String.html#toString())metodo per convertirlo in un [`String`](https://docs.oracle.com/en/java/javase/18/docs/api/java.base/java/lang/String.html).

> Nota: fino a Java SE 15, il linguaggio di programmazione Java non consente alle stringhe letterali di estendersi su righe nei file di origine, quindi è necessario utilizzare l' `+`operatore di concatenazione alla fine di ogni riga in una stringa a più righe. Per esempio:

    String quote = 
        "Now is the time for all good " +
        "men to come to the aid of their country.";
    

copia

L'interruzione delle stringhe tra le righe utilizzando l' `+`operatore di concatenazione è, ancora una volta, molto comune nelle `print`istruzioni.

A partire da Java SE 15, puoi scrivere stringhe letterali bidimensionali:

    String html = """
                  <html>
                      <body>
                          <p>Hello, world</p>
                      </body>
                  </html>
                  """;
    

copia

 

Creazione di stringhe di formato
--------------------------------

Hai visto l'uso dei metodi [`printf()`](https://docs.oracle.com/en/java/javase/18/docs/api/java.base/java/io/PrintStream.html#printf(java.lang.String,java.lang.Object...))e [`format()`](https://docs.oracle.com/en/java/javase/18/docs/api/java.base/java/io/PrintStream.html#format(java.lang.String,java.lang.Object...))per stampare l'output con numeri formattati. La [`String`](https://docs.oracle.com/en/java/javase/18/docs/api/java.base/java/lang/String.html)classe ha un metodo di classe equivalente, [`format()`](https://docs.oracle.com/en/java/javase/18/docs/api/java.base/java/lang/String.html#format(java.lang.String,java.lang.Object...)), che restituisce un [`String`](https://docs.oracle.com/en/java/javase/18/docs/api/java.base/java/lang/String.html)oggetto anziché un [`PrintStream`](https://docs.oracle.com/en/java/javase/18/docs/api/java.base/java/io/PrintStream.html)oggetto.

L'utilizzo del metodo [`String`](https://docs.oracle.com/en/java/javase/18/docs/api/java.base/java/lang/String.html)statico di ' [`format()`](https://docs.oracle.com/en/java/javase/18/docs/api/java.base/java/io/PrintStream.html#format(java.lang.String,java.lang.Object...))ti consente di creare una stringa formattata che puoi riutilizzare, al contrario di un'istruzione print una tantum. Ad esempio, invece di

    System.out.printf("The value of the float " +
                      "variable is %f, while " +
                      "the value of the " + 
                      "integer variable is %d, " +
                      "and the string is %s", 
                      floatVar, intVar, stringVar); 
    

copia

tu puoi scrivere

    String fs;
    fs = String.format("The value of the float " +
                       "variable is %f, while " +
                       "the value of the " + 
                       "integer variable is %d, " +
                       " and the string is %s",
                       floatVar, intVar, stringVar);
    System.out.println(fs);
    

copia

 

Conversione di stringhe in numeri
---------------------------------

Spesso un programma finisce con dati numerici in un oggetto stringa, ad esempio un valore immesso dall'utente.

Le [`Number`](https://docs.oracle.com/en/java/javase/18/docs/api/java.base/java/lang/Number.html)sottoclassi che racchiudono tipi numerici primitivi ( [`Byte`](https://docs.oracle.com/en/java/javase/18/docs/api/java.base/java/lang/Byte.html), [`Integer`](https://docs.oracle.com/en/java/javase/18/docs/api/java.base/java/lang/Integer.html), [`Double`](https://docs.oracle.com/en/java/javase/18/docs/api/java.base/java/lang/Double.html), [`Float`](https://docs.oracle.com/en/java/javase/18/docs/api/java.base/java/lang/Float.html), [`Long`](https://docs.oracle.com/en/java/javase/18/docs/api/java.base/java/lang/Long.html)e [`Short`](https://docs.oracle.com/en/java/javase/18/docs/api/java.base/java/lang/Short.html)) forniscono ciascuna un metodo di classe denominato [`valueOf()`](https://docs.oracle.com/en/java/javase/18/docs/api/java.base/java/lang/Integer.html#valueOf(int))che converte una stringa in un oggetto di quel tipo. Ecco un esempio, `ValueOfDemo`, che ottiene due stringhe dalla riga di comando, le converte in numeri ed esegue operazioni aritmetiche sui valori:

    public class ValueOfDemo {
        public static void main(String[] args) {
    
            // this program requires two 
            // arguments on the command line 
            if (args.length == 2) {
                // convert strings to numbers
                float a = (Float.valueOf(args[0])).floatValue(); 
                float b = (Float.valueOf(args[1])).floatValue();
    
                // do some arithmetic
                System.out.println("a + b = " +
                                   (a + b));
                System.out.println("a - b = " +
                                   (a - b));
                System.out.println("a * b = " +
                                   (a * b));
                System.out.println("a / b = " +
                                   (a / b));
                System.out.println("a % b = " +
                                   (a % b));
            } else {
                System.out.println("This program " +
                    "requires two command-line arguments.");
            }
        }
    }
    

copia

Quello che segue è l'output del programma quando si utilizza `4.5`e `87.2`per gli argomenti della riga di comando:

    a + b = 91.7
    a - b = -82.7
    a * b = 392.4
    a / b = 0.0516055
    a % b = 4.5
    

copia

> Nota: ciascuna delle [`Number`](https://docs.oracle.com/en/java/javase/18/docs/api/java.base/java/lang/Number.html)sottoclassi che racchiudono tipi numerici primitivi fornisce anche un `parseXXXX()`metodo (ad esempio [`parseFloat()`](https://docs.oracle.com/en/java/javase/18/docs/api/java.base/java/lang/Float.html#parseFloat(java.lang.String))) che può essere utilizzato per convertire le stringhe in numeri primitivi. Poiché viene restituito un tipo primitivo anziché un oggetto, il [`parseFloat()`](https://docs.oracle.com/en/java/javase/18/docs/api/java.base/java/lang/Float.html#parseFloat(java.lang.String))metodo è più diretto del [`valueOf()`](https://docs.oracle.com/en/java/javase/18/docs/api/java.base/java/lang/Integer.html#valueOf(int))metodo. Ad esempio, nel `ValueOfDemo`programma, potremmo usare:

    float a = Float.parseFloat(args[0]);
    float b = Float.parseFloat(args[1]);
    

copia

 

Conversione di numeri in stringhe
---------------------------------

A volte è necessario convertire un numero in una stringa perché è necessario operare sul valore nella sua forma di stringa. Esistono diversi modi semplici per convertire un numero in una stringa:

    int i;
    // Concatenate "i" with an empty string; conversion is handled for you.
    String s1 = "" + i;
    

copia

o

    // The valueOf class method.
    String s2 = String.valueOf(i);
    

copia

Ciascuna delle [`Number`](https://docs.oracle.com/en/java/javase/18/docs/api/java.base/java/lang/Number.html)sottoclassi include un metodo di classe, [`toString()`](https://docs.oracle.com/en/java/javase/18/docs/api/java.base/java/lang/Number.html#toString()), che convertirà il suo tipo primitivo in una stringa. Per esempio:

    int i;
    double d;
    String s3 = Integer.toString(i); 
    String s4 = Double.toString(d); 
    

copia

L' `ToStringDemo`esempio usa il [`toString()`](https://docs.oracle.com/en/java/javase/18/docs/api/java.base/java/lang/String.html#toString())metodo per convertire un numero in una stringa. Il programma utilizza quindi alcuni metodi di stringa per calcolare il numero di cifre prima e dopo il punto decimale:

    public class ToStringDemo {
        
        public static void main(String[] args) {
            double d = 858.48;
            String s = Double.toString(d);
            
            int dot = s.indexOf('.');
            
            System.out.println(dot + " digits " +
                "before decimal point.");
            System.out.println( (s.length() - dot - 1) +
                " digits after decimal point.");
        }
    }
    

copia

L'output di questo programma è:

    3 digits before decimal point.
    2 digits after decimal point.
    

copia

 

Ottenere caratteri e sottostringhe per indice
---------------------------------------------

La classe String ha una serie di metodi per esaminare il contenuto delle stringhe, trovare caratteri o sottostringhe all'interno di una stringa, cambiare maiuscole e minuscole e altre attività.

È possibile ottenere il carattere in corrispondenza di un determinato indice all'interno di una stringa richiamando il [`charAt()`](https://docs.oracle.com/en/java/javase/18/docs/api/java.base/java/lang/String.html#charAt(int))metodo di accesso. L'indice del primo carattere è 0, mentre l'indice dell'ultimo carattere è `length() - 1`. Ad esempio, il codice seguente ottiene il carattere all'indice 9 in una stringa:

    String anotherPalindrome = "Niagara. O roar again!"; 
    char aChar = anotherPalindrome.charAt(9);
    

copia

Gli indici iniziano da 0, quindi il carattere all'indice 9 è 'O', come illustrato nella figura seguente:

![Char indici in una stringa](/assets/images/numbers-strings/02_chars.png)

Char indici in una stringa

Se vuoi ottenere più di un carattere consecutivo da una stringa, puoi usare il metodo substring. Il metodo substring ha due versioni:

*   [`String substring(int beginIndex, int endIndex)`](https://docs.oracle.com/en/java/javase/18/docs/api/java.base/java/lang/String.html#substring(int,int)): restituisce una nuova stringa che è una sottostringa di questa stringa. La sottostringa inizia nel punto specificato `beginIndex`e si estende al carattere in index `endIndex - 1`.
*   [`String substring(int beginIndex)`](https://docs.oracle.com/en/java/javase/18/docs/api/java.base/java/lang/String.html#substring(int)): restituisce una nuova stringa che è una sottostringa di questa stringa. L'argomento intero specifica l'indice del primo carattere. Qui, la sottostringa restituita si estende fino alla fine della stringa originale.

Il codice seguente ottiene dal palindromo del Niagara la sottostringa che si estende dall'indice 11 fino all'indice 15, ma escluso, che è la parola "ruggito":

    String anotherPalindrome = "Niagara. O roar again!"; 
    String roar = anotherPalindrome.substring(11, 15); 
    

copia

![Estrazione di caratteri da una stringa con sottostringa](/assets/images/numbers-strings/03_substring.png)

Estrazione di caratteri da una stringa con sottostringa

 

Altri metodi per manipolare le stringhe
---------------------------------------

Ecco molti altri [`String`](https://docs.oracle.com/en/java/javase/18/docs/api/java.base/java/lang/String.html)metodi per manipolare le stringhe:

*   [`String[] split(String regex)`](https://docs.oracle.com/en/java/javase/18/docs/api/java.base/java/lang/String.html#split(java.lang.String))e [`String[] split(String regex, int limit)`](https://docs.oracle.com/en/java/javase/18/docs/api/java.base/java/lang/String.html#split(java.lang.String,int)): cerca una corrispondenza come specificato dall'argomento stringa (che contiene un'espressione regolare) e divide questa stringa in una matrice di stringhe di conseguenza. L'argomento intero facoltativo specifica la dimensione massima della matrice restituita. Le espressioni regolari sono trattate nella sezione intitolata "Espressioni regolari".
*   [`CharSequence subSequence(int beginIndex, int endIndex)`](https://docs.oracle.com/en/java/javase/18/docs/api/java.base/java/lang/String.html#subSequence(int,int)): Restituisce una nuova sequenza di caratteri costruita `beginIndex`dall'indice fino a `endIndex - 1`.
*   [`String trim()`](https://docs.oracle.com/en/java/javase/18/docs/api/java.base/java/lang/String.html#trim()): Restituisce una copia di questa stringa senza spazi bianchi iniziali e finali.
*   [`String toLowerCase()`](https://docs.oracle.com/en/java/javase/18/docs/api/java.base/java/lang/String.html#toLowerCase())e [`String toUpperCase()`](https://docs.oracle.com/en/java/javase/18/docs/api/java.base/java/lang/String.html#toUpperCase()): restituisce una copia di questa stringa convertita in minuscolo o maiuscolo. Se non sono necessarie conversioni, questi metodi restituiscono la stringa originale.

 

Ricerca di caratteri e sottostringhe in una stringa
---------------------------------------------------

Ecco alcuni altri [`String`](https://docs.oracle.com/en/java/javase/18/docs/api/java.base/java/lang/String.html)metodi per trovare caratteri o sottostringhe all'interno di una stringa. La [`String`](https://docs.oracle.com/en/java/javase/18/docs/api/java.base/java/lang/String.html)classe fornisce metodi di accesso che restituiscono la posizione all'interno della stringa di un carattere o una sottostringa specifici: [`indexOf()`](https://docs.oracle.com/en/java/javase/18/docs/api/java.base/java/lang/String.html#indexOf(java.lang.String))e [`lastIndexOf()`](https://docs.oracle.com/en/java/javase/18/docs/api/java.base/java/lang/String.html#lastIndexOf(java.lang.String)). I [`indexOf()`](https://docs.oracle.com/en/java/javase/18/docs/api/java.base/java/lang/String.html#indexOf(java.lang.String))metodi effettuano la ricerca in avanti dall'inizio della stringa e i [`lastIndexOf()`](https://docs.oracle.com/en/java/javase/18/docs/api/java.base/java/lang/String.html#lastIndexOf(java.lang.String))metodi effettuano la ricerca all'indietro dalla fine della stringa. Se non viene trovato un carattere o una sottostringa, [`indexOf()`](https://docs.oracle.com/en/java/javase/18/docs/api/java.base/java/lang/String.html#indexOf(java.lang.String))restituire [`lastIndexOf()`](https://docs.oracle.com/en/java/javase/18/docs/api/java.base/java/lang/String.html#lastIndexOf(java.lang.String))\-1.

La [`String`](https://docs.oracle.com/en/java/javase/18/docs/api/java.base/java/lang/String.html)classe fornisce anche un metodo di ricerca, contiene, che restituisce `true`se la stringa contiene una particolare sequenza di caratteri. Usa questo metodo quando devi solo sapere che la stringa contiene una sequenza di caratteri, ma la posizione precisa non è importante.

Le modalità di ricerca sono le seguenti:

*   [`int indexOf(int ch)`](https://docs.oracle.com/en/java/javase/18/docs/api/java.base/java/lang/String.html#indexOf(int))e [`int lastIndexOf(int ch)`](https://docs.oracle.com/en/java/javase/18/docs/api/java.base/java/lang/String.html#lastIndexOf(int)): restituisce l'indice della prima (ultima) occorrenza del carattere specificato.
*   [`int indexOf(int ch, int fromIndex)`](https://docs.oracle.com/en/java/javase/18/docs/api/java.base/java/lang/String.html#indexOf(int,int))e [`int lastIndexOf(int ch, int fromIndex)`](https://docs.oracle.com/en/java/javase/18/docs/api/java.base/java/lang/String.html#lastIndexOf(int,int)): restituisce l'indice della prima (ultima) occorrenza del carattere specificato, cercando in avanti (indietro) dall'indice specificato.
*   [`int indexOf(String str)`](https://docs.oracle.com/en/java/javase/18/docs/api/java.base/java/lang/String.html#indexOf(java.lang.String))e [`int lastIndexOf(String str)`](https://docs.oracle.com/en/java/javase/18/docs/api/java.base/java/lang/String.html#lastIndexOf(java.lang.String)): restituisce l'indice della prima (ultima) occorrenza della sottostringa specificata.
*   [`int indexOf(String str, int fromIndex)`](https://docs.oracle.com/en/java/javase/18/docs/api/java.base/java/lang/String.html#indexOf(java.lang.String,int))e [`int lastIndexOf(String str, int fromIndex)`](https://docs.oracle.com/en/java/javase/18/docs/api/java.base/java/lang/String.html#lastIndexOf(java.lang.String,int)): restituisce l'indice della prima (ultima) occorrenza della sottostringa specificata, cercando in avanti (indietro) dall'indice specificato.
*   [`boolean contains(CharSequence s)`](https://docs.oracle.com/en/java/javase/18/docs/api/java.base/java/lang/String.html#contains(java.lang.CharSequence)): Restituisce `true`se la stringa contiene la sequenza di caratteri specificata.

> Nota: [`CharSequence`](https://docs.oracle.com/en/java/javase/18/docs/api/java.base/java/lang/CharSequence.html)è un'interfaccia implementata dalla [`String`](https://docs.oracle.com/en/java/javase/18/docs/api/java.base/java/lang/String.html)classe. Pertanto, puoi utilizzare una stringa come argomento per il [`contains()`](https://docs.oracle.com/en/java/javase/18/docs/api/java.base/java/lang/String.html#contains(java.lang.CharSequence))metodo.

 

Sostituzione di caratteri e sottostringhe in una stringa
--------------------------------------------------------

La [`String`](https://docs.oracle.com/en/java/javase/18/docs/api/java.base/java/lang/String.html)classe ha pochissimi metodi per inserire caratteri o sottostringhe in una stringa. In generale, non sono necessari: puoi creare una nuova stringa concatenando le sottostringhe che hai rimosso da una stringa con la sottostringa che vuoi inserire.

Tuttavia, la [`String`](https://docs.oracle.com/en/java/javase/18/docs/api/java.base/java/lang/String.html)classe ha quattro metodi per sostituire i caratteri o le sottostringhe trovati. Sono:

*   [`String replace(char oldChar, char newChar)`](https://docs.oracle.com/en/java/javase/18/docs/api/java.base/java/lang/String.html#replace(char,char)): Restituisce una nuova stringa risultante dalla sostituzione di tutte le occorrenze di `oldChar`in questa stringa con `newChar`.
*   [`String replace(CharSequence target, CharSequence replacement)`](https://docs.oracle.com/en/java/javase/18/docs/api/java.base/java/lang/String.html#replace(java.lang.CharSequence,java.lang.CharSequence)): sostituisce ogni sottostringa di questa stringa che corrisponde alla sequenza di destinazione letterale con la sequenza di sostituzione letterale specificata.
*   [`String replaceAll(String regex, String replacement)`](https://docs.oracle.com/en/java/javase/18/docs/api/java.base/java/lang/String.html#replaceAll(java.lang.String,java.lang.String)): Sostituisce ogni sottostringa di questa stringa che corrisponde all'espressione regolare data con la sostituzione data.
*   [`String replaceFirst(String regex, String replacement)`](https://docs.oracle.com/en/java/javase/18/docs/api/java.base/java/lang/String.html#replaceFirst(java.lang.String,java.lang.String)): Sostituisce la prima sottostringa di questa stringa che corrisponde all'espressione regolare data con la sostituzione data.

 

La classe String in azione
--------------------------

La classe seguente, `Filename`, illustra l'uso [`lastIndexOf()`](https://docs.oracle.com/en/java/javase/18/docs/api/java.base/java/lang/String.html#lastIndexOf(java.lang.String))e [`substring()`](https://docs.oracle.com/en/java/javase/18/docs/api/java.base/java/lang/String.html#substring(int,int))l'isolamento di parti diverse di un nome file.

> Nota: i metodi della `Filename`classe seguente non eseguono alcun controllo degli errori e presuppongono che il loro argomento contenga un percorso di directory completo e un nome file con estensione. Se questi metodi fossero codice di produzione, verificherebbero che i loro argomenti siano stati costruiti correttamente.

    public class Filename {
        private String fullPath;
        private char pathSeparator, 
                     extensionSeparator;
    
        public Filename(String str, char sep, char ext) {
            fullPath = str;
            pathSeparator = sep;
            extensionSeparator = ext;
        }
    
        public String extension() {
            int dot = fullPath.lastIndexOf(extensionSeparator);
            return fullPath.substring(dot + 1);
        }
    
        // gets filename without extension
        public String filename() {
            int dot = fullPath.lastIndexOf(extensionSeparator);
            int sep = fullPath.lastIndexOf(pathSeparator);
            return fullPath.substring(sep + 1, dot);
        }
    
        public String path() {
            int sep = fullPath.lastIndexOf(pathSeparator);
            return fullPath.substring(0, sep);
        }
    }
    

copia

Ecco un programma, `FilenameDemo`, che costruisce un `Filename`oggetto e chiama tutti i suoi metodi:

    public class FilenameDemo {
        public static void main(String[] args) {
            final String FPATH = "/home/user/index.html";
            Filename myHomePage = new Filename(FPATH, '/', '.');
            System.out.println("Extension = " + myHomePage.extension());
            System.out.println("Filename = " + myHomePage.filename());
            System.out.println("Path = " + myHomePage.path());
        }
    }
    

copia

Ed ecco l'output del programma:

    Extension = html
    Filename = index
    Path = /home/user
    

copia

Come mostrato nella figura seguente, il nostro metodo di estensione utilizza [`lastIndexOf()`](https://docs.oracle.com/en/java/javase/18/docs/api/java.base/java/lang/String.html#lastIndexOf(java.lang.String))per individuare l'ultima occorrenza del punto ( `.`) nel nome del file. Quindi substring utilizza il valore restituito di [`lastIndexOf()`](https://docs.oracle.com/en/java/javase/18/docs/api/java.base/java/lang/String.html#lastIndexOf(java.lang.String))per estrarre l'estensione del nome file, ovvero la sottostringa dal punto alla fine della stringa. Questo codice presuppone che il nome del file contenga un punto; se il nome del file non ha un punto, [`lastIndexOf()`](https://docs.oracle.com/en/java/javase/18/docs/api/java.base/java/lang/String.html#lastIndexOf(java.lang.String))restituisce -1 e il metodo della sottostringa genera un [`StringIndexOutOfBoundsException`](https://docs.oracle.com/en/java/javase/18/docs/api/java.base/java/lang/StringIndexOutOfBoundsException.html).

Si noti inoltre che il metodo di estensione utilizza `dot + 1`come argomento per [`substring()`](https://docs.oracle.com/en/java/javase/18/docs/api/java.base/java/lang/String.html#substring(int,int)). Se il carattere punto ( `.`) è l'ultimo carattere della stringa, `dot + 1`è uguale alla lunghezza della stringa, che è uno più grande dell'indice più grande nella stringa (perché gli indici iniziano da 0). Questo è un argomento legale [`substring()`](https://docs.oracle.com/en/java/javase/18/docs/api/java.base/java/lang/String.html#substring(int,int))perché quel metodo accetta un indice uguale, ma non maggiore, alla lunghezza della stringa e lo interpreta come "la fine della stringa".

 

Confronto tra stringhe e porzioni di stringhe
---------------------------------------------

La [`String`](https://docs.oracle.com/en/java/javase/18/docs/api/java.base/java/lang/String.html)classe ha una serie di metodi per confrontare stringhe e porzioni di stringhe. La tabella seguente elenca questi metodi.

*   [`boolean endsWith(String suffix)`](https://docs.oracle.com/en/java/javase/18/docs/api/java.base/java/lang/String.html#endsWith(java.lang.String))e [`boolean startsWith(String prefix)`](https://docs.oracle.com/en/java/javase/18/docs/api/java.base/java/lang/String.html#startsWith(java.lang.String)): restituisce `true`se questa stringa termina o inizia con la sottostringa specificata come argomento del metodo.
*   [`boolean startsWith(String prefix, int offset)`](https://docs.oracle.com/en/java/javase/18/docs/api/java.base/java/lang/String.html#startsWith(java.lang.String,int)): considera la stringa che inizia con l'indice `offset`e restituisce `true`se inizia con la sottostringa specificata come argomento.
*   [`int compareTo(String anotherString)`](https://docs.oracle.com/en/java/javase/18/docs/api/java.base/java/lang/String.html#compareTo(java.lang.String)): Confronta due stringhe lessicograficamente. Restituisce un numero intero che indica se questa stringa è maggiore di (risultato è > 0), uguale a (risultato = 0) o minore di (risultato è < 0) l'argomento.
*   [`int compareToIgnoreCase(String str)`](https://docs.oracle.com/en/java/javase/18/docs/api/java.base/java/lang/String.html#compareToIgnoreCase(java.lang.String)): confronta due stringhe lessicograficamente, ignorando le differenze tra maiuscole e minuscole. Restituisce un numero intero che indica se questa stringa è maggiore di (risultato è > 0), uguale a (risultato = 0) o minore di (risultato è < 0) l'argomento.
*   [`boolean equals(Object anObject)`](https://docs.oracle.com/en/java/javase/18/docs/api/java.base/java/lang/String.html#equals(java.lang.Object)): Restituisce `true`se e solo se l'argomento è un [`String`](https://docs.oracle.com/en/java/javase/18/docs/api/java.base/java/lang/String.html)oggetto che rappresenta la stessa sequenza di caratteri di questo oggetto.
*   [`boolean equalsIgnoreCase(String anotherString)`](https://docs.oracle.com/en/java/javase/18/docs/api/java.base/java/lang/String.html#equalsIgnoreCase(java.lang.String)): Restituisce `true`se e solo se l'argomento è un [`String`](https://docs.oracle.com/en/java/javase/18/docs/api/java.base/java/lang/String.html)oggetto che rappresenta la stessa sequenza di caratteri di questo oggetto, ignorando le differenze tra maiuscole e minuscole.
*   [`boolean regionMatches(int toffset, String other, int ooffset, int len)`](https://docs.oracle.com/en/java/javase/18/docs/api/java.base/java/lang/String.html#regionMatches(int,java.lang.String,int,int)): verifica se l'area specificata di questa stringa corrisponde all'area specificata [`String`](https://docs.oracle.com/en/java/javase/18/docs/api/java.base/java/lang/String.html)dell'argomento. La regione è di lunghezza `len`e inizia all'indice `toffset`per questa stringa e `ooffset`per l'altra stringa.
*   [`boolean regionMatches(boolean ignoreCase, int toffset, String other, int ooffset, int len)`](https://docs.oracle.com/en/java/javase/18/docs/api/java.base/java/lang/String.html#regionMatches(boolean,int,java.lang.String,int,int)): verifica se l'area specificata di questa stringa corrisponde all'area specificata [`String`](https://docs.oracle.com/en/java/javase/18/docs/api/java.base/java/lang/String.html)dell'argomento. La regione è di lunghezza `len`e inizia all'indice `toffset`per questa stringa e `ooffset`per l'altra stringa. L'argomento booleano indica se il caso deve essere ignorato; se `true`, il caso viene ignorato quando si confrontano i caratteri.
*   [`boolean matches(String regex)`](https://docs.oracle.com/en/java/javase/18/docs/api/java.base/java/lang/String.html#matches(java.lang.String)): verifica se questa stringa corrisponde all'espressione regolare specificata. Le espressioni regolari sono discusse nella lezione intitolata "Espressioni regolari".

Il seguente programma, `RegionMatchesDemo`, usa il [`regionMatches()`](https://docs.oracle.com/en/java/javase/18/docs/api/java.base/java/lang/String.html#regionMatches(int,java.lang.String,int,int))metodo per cercare una stringa all'interno di un'altra stringa:

    public class RegionMatchesDemo {
        public static void main(String[] args) {
            String searchMe = "Green Eggs and Ham";
            String findMe = "Eggs";
            int searchMeLength = searchMe.length();
            int findMeLength = findMe.length();
            boolean foundIt = false;
            for (int i = 0; 
                 i <= (searchMeLength - findMeLength);
                 i++) {
               if (searchMe.regionMatches(i, findMe, 0, findMeLength)) {
                  foundIt = true;
                  System.out.println(searchMe.substring(i, i + findMeLength));
                  break;
               }
            }
            if (!foundIt)
                System.out.println("No match found.");
        }
    }
    

copia

L'output di questo programma è `Eggs`.

Il programma scorre la stringa a cui fa riferimento `searchMe()`un carattere alla volta. Per ogni carattere, il programma chiama il [`regionMatches()`](https://docs.oracle.com/en/java/javase/18/docs/api/java.base/java/lang/String.html#regionMatches(int,java.lang.String,int,int))metodo per determinare se la sottostringa che inizia con il carattere corrente corrisponde alla stringa che il programma sta cercando.

