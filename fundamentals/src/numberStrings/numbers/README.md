

Numeri
======

 

Numeri
------

Questa sezione inizia con una discussione sulla [`Number`](https://docs.oracle.com/en/java/javase/18/docs/api/java.base/java/lang/Number.html) classe nel [`java.lang`](https://docs.oracle.com/en/java/javase/18/docs/api/java.base/java/lang/package-summary.html) pacchetto, le sue sottoclassi e le situazioni in cui useresti le istanze di queste classi piuttosto che i tipi numerici primitivi.

Questa sezione presenta anche le classi [`PrintStream`](https://docs.oracle.com/en/java/javase/18/docs/api/java.base/java/io/PrintStream.html)e [`DecimalFormat`](https://docs.oracle.com/en/java/javase/18/docs/api/java.base/java/text/DecimalFormat.html) , che forniscono metodi per scrivere un output numerico formattato.

Infine, viene discussa la [`Math`](https://docs.oracle.com/en/java/javase/18/docs/api/java.base/java/lang/Math.html)classe in . [`java.lang`](https://docs.oracle.com/en/java/javase/18/docs/api/java.base/java/lang/package-summary.html)Contiene funzioni matematiche per completare gli operatori integrati nel linguaggio. Questa classe ha metodi per le funzioni trigonometriche, funzioni esponenziali e così via.

Quando si lavora con i numeri, la maggior parte delle volte si utilizzano i tipi primitivi nel codice. Per esempio:

    int i = 500;
    float gpa = 3.65f;
    byte mask = 0x7f;
    

copia

Ci sono, tuttavia, ragioni per utilizzare gli oggetti al posto delle primitive e la piattaforma Java fornisce classi wrapper per ciascuno dei tipi di dati primitivi. Queste classi "avvolgono" la primitiva in un oggetto. Spesso, il wrapping viene eseguito dal compilatore: se si utilizza una primitiva in cui è previsto un oggetto, il compilatore inserisce la primitiva nella sua classe wrapper per te. Allo stesso modo, se si utilizza un oggetto numero quando è prevista una primitiva, il compilatore decomprime l'oggetto per te. Per ulteriori informazioni, vedere la sezione Autoboxing e Unboxing

Tutte le classi di wrapper numeriche sono sottoclassi della classe astratta [`Number`](https://docs.oracle.com/en/java/javase/18/docs/api/java.base/java/lang/Number.html):

![La gerarchia delle classi numeriche](/assets/images/numbers-strings/01_numbers.png)

La gerarchia delle classi numeriche

> Nota: ci sono altre quattro sottoclassi [`Number`](https://docs.oracle.com/en/java/javase/18/docs/api/java.base/java/lang/Number.html)che non sono discusse qui. [`BigDecimal`](https://docs.oracle.com/en/java/javase/18/docs/api/java.base/java/math/BigDecimal.html)e [`BigInteger`](https://docs.oracle.com/en/java/javase/18/docs/api/java.base/java/math/BigInteger.html)sono usati per calcoli ad alta precisione. [`AtomicInteger`](https://docs.oracle.com/en/java/javase/18/docs/api/java.base/java/util/concurrent/atomic/AtomicInteger.html)e [`AtomicLong`](https://docs.oracle.com/en/java/javase/18/docs/api/java.base/java/util/concurrent/atomic/AtomicLong.html)sono usati per applicazioni multi-thread.

Ci sono tre ragioni per cui potresti usare un [`Number`](https://docs.oracle.com/en/java/javase/18/docs/api/java.base/java/lang/Number.html)oggetto piuttosto che una primitiva:

1.  Come argomento di un metodo che si aspetta un oggetto (spesso usato quando si manipolano raccolte di numeri).
2.  Per utilizzare le costanti definite dalla classe, come [`MIN_VALUE`](https://docs.oracle.com/en/java/javase/18/docs/api/java.base/java/lang/Integer.html#MIN_VALUE)e [`MAX_VALUE`](https://docs.oracle.com/en/java/javase/18/docs/api/java.base/java/lang/Integer.html#MAX_VALUE), che forniscono i limiti superiore e inferiore del tipo di dati.
3.  Utilizzare metodi di classe per convertire valori in e da altri tipi primitivi, per convertire in e da stringhe e per convertire tra sistemi numerici (decimale, ottale, esadecimale, binario).

La tabella seguente elenca i metodi di istanza implementati da tutte le sottoclassi della classe Number.

I metodi seguenti convertono il valore di questo [`Number`](https://docs.oracle.com/en/java/javase/18/docs/api/java.base/java/lang/Number.html)oggetto nel tipo di dati primitivo restituito.

*   [`byte byteValue()`](https://docs.oracle.com/en/java/javase/18/docs/api/java.base/java/lang/Integer.html#byteValue())
*   [`short shortValue()`](https://docs.oracle.com/en/java/javase/18/docs/api/java.base/java/lang/Integer.html#shortValue())
*   [`int intValue()`](https://docs.oracle.com/en/java/javase/18/docs/api/java.base/java/lang/Integer.html#intValue())
*   [`long longValue()`](https://docs.oracle.com/en/java/javase/18/docs/api/java.base/java/lang/Integer.html#longValue())
*   [`float floatValue()`](https://docs.oracle.com/en/java/javase/18/docs/api/java.base/java/lang/Integer.html#floatValue())
*   [`double doubleValue()`](https://docs.oracle.com/en/java/javase/18/docs/api/java.base/java/lang/Integer.html#doubleValue())

I metodi seguenti confrontano questo [`Number`](https://docs.oracle.com/en/java/javase/18/docs/api/java.base/java/lang/Number.html)oggetto con l'argomento.

*   [`int compareTo(Byte anotherByte)`](https://docs.oracle.com/en/java/javase/18/docs/api/java.base/java/lang/Byte.html#compareTo(java.lang.Byte))
*   [`int compareTo(Double anotherDouble)`](https://docs.oracle.com/en/java/javase/18/docs/api/java.base/java/lang/Double.html#compareTo(java.lang.Double))
*   [`int compareTo(Float anotherFloat)`](https://docs.oracle.com/en/java/javase/18/docs/api/java.base/java/lang/Float.html#compareTo(java.lang.Float))
*   [`int compareTo(Integer anotherInteger)`](https://docs.oracle.com/en/java/javase/18/docs/api/java.base/java/lang/Integer.html#compareTo(java.lang.Integer))
*   [`int compareTo(Long anotherLong)`](https://docs.oracle.com/en/java/javase/18/docs/api/java.base/java/lang/Long.html#compareTo(java.lang.Long))
*   [`int compareTo(Short anotherShort)`](https://docs.oracle.com/en/java/javase/18/docs/api/java.base/java/lang/Short.html#compareTo(java.lang.Short))
*   [`boolean equals(Object obj)`](https://docs.oracle.com/en/java/javase/18/docs/api/java.base/java/lang/Integer.html#equals(java.lang.Object))

Il metodo `equals(Object obj)`determina se questo oggetto numero è uguale all'argomento. I metodi restituiscono `true`se l'argomento non è `null`ed è un oggetto dello stesso tipo e con lo stesso valore numerico. Ci sono alcuni requisiti aggiuntivi per [`Double`](https://docs.oracle.com/en/java/javase/18/docs/api/java.base/java/lang/Double.html)e [`Float`](https://docs.oracle.com/en/java/javase/18/docs/api/java.base/java/lang/Float.html) oggetti che sono descritti nella documentazione dell'API Java.

Ciascuna [`Number`](https://docs.oracle.com/en/java/javase/18/docs/api/java.base/java/lang/Number.html)classe contiene altri metodi utili per la conversione di numeri in e da stringhe e per la conversione tra sistemi numerici. La tabella seguente elenca questi metodi nella [`Integer`](https://docs.oracle.com/en/java/javase/18/docs/api/java.base/java/lang/Integer.html)classe. I metodi per le altre [`Number`](https://docs.oracle.com/en/java/javase/18/docs/api/java.base/java/lang/Number.html)sottoclassi sono simili:

Metodo

Descrizione

[`static Integer decode(String s)`](https://docs.oracle.com/en/java/javase/18/docs/api/java.base/java/lang/Integer.html#decode(java.lang.String))

Decodifica una stringa in un numero intero. Può accettare rappresentazioni di stringhe di numeri decimali, ottali o esadecimali come input.

[`static int parseInt(String s)`](https://docs.oracle.com/en/java/javase/18/docs/api/java.base/java/lang/Integer.html#parseInt(java.lang.String))

Restituisce un numero intero (solo decimale).

[`static int parseInt(String s, int radix)`](https://docs.oracle.com/en/java/javase/18/docs/api/java.base/java/lang/Integer.html#parseInt(java.lang.String,int))

Restituisce un numero intero, data una rappresentazione di stringa di numeri decimali, binari, ottali o esadecimali (radix è rispettivamente 10, 2, 8 o 16) come input.

[`static toString()`](https://docs.oracle.com/en/java/javase/18/docs/api/java.base/java/lang/Integer.html#toString())

Restituisce un [`String`](https://docs.oracle.com/en/java/javase/18/docs/api/java.base/java/lang/String.html)oggetto che rappresenta il valore di this [`Integer`](https://docs.oracle.com/en/java/javase/18/docs/api/java.base/java/lang/Integer.html).

[`static String toString(int i)`](https://docs.oracle.com/en/java/javase/18/docs/api/java.base/java/lang/Integer.html#toString(int))

Restituisce un [`String`](https://docs.oracle.com/en/java/javase/18/docs/api/java.base/java/lang/String.html)oggetto che rappresenta l'intero specificato.

[`static Integer valueOf(int i)`](https://docs.oracle.com/en/java/javase/18/docs/api/java.base/java/lang/Integer.html#valueOf(int))

Restituisce un [`Integer`](https://docs.oracle.com/en/java/javase/18/docs/api/java.base/java/lang/Integer.html)oggetto contenente il valore della primitiva specificata.

[`static Integer valueOf(String s)`](https://docs.oracle.com/en/java/javase/18/docs/api/java.base/java/lang/Integer.html#valueOf(java.lang.String))

Restituisce un [`Integer`](https://docs.oracle.com/en/java/javase/18/docs/api/java.base/java/lang/Integer.html)oggetto contenente il valore della rappresentazione di stringa specificata.

[`static Integer valueOf(String s, int radix)`](https://docs.oracle.com/en/java/javase/18/docs/api/java.base/java/lang/Integer.html#valueOf(java.lang.String,int))

Restituisce un [`Integer`](https://docs.oracle.com/en/java/javase/18/docs/api/java.base/java/lang/Integer.html)oggetto contenente il valore intero della rappresentazione di stringa specificata, analizzato con il valore di radice. Ad esempio, se s = "333" e radix = 8, il metodo restituisce l'equivalente intero in base dieci del numero ottale 333.

 

Formattazione dell'output di stampa numerico
--------------------------------------------

In precedenza hai visto l'uso dei metodi [`print`](https://docs.oracle.com/en/java/javase/18/docs/api/java.base/java/io/PrintStream.html#print(int))e [`println`](https://docs.oracle.com/en/java/javase/18/docs/api/java.base/java/io/PrintStream.html#println(int))per stampare stringhe su output standard ( [`System.out`](https://docs.oracle.com/en/java/javase/18/docs/api/java.base/java/lang/System.html#out)). Poiché tutti i numeri possono essere convertiti in stringhe, è possibile utilizzare questi metodi per stampare una combinazione arbitraria di stringhe e numeri. Il linguaggio di programmazione Java ha altri metodi, tuttavia, che consentono di esercitare un controllo molto maggiore sull'output di stampa quando sono inclusi i numeri.

### I metodi Printf e Format

The [`java.io`](https://docs.oracle.com/en/java/javase/18/docs/api/java.base/java/io/package-summary.html) package includes a [`PrintStream`](https://docs.oracle.com/en/java/javase/18/docs/api/java.base/java/io/PrintStream.html) class that has two formatting methods that you can use to replace [`print`](https://docs.oracle.com/en/java/javase/18/docs/api/java.base/java/io/PrintStream.html#print(int)) and [`println`](https://docs.oracle.com/en/java/javase/18/docs/api/java.base/java/io/PrintStream.html#println(int)). These methods, [`format`](https://docs.oracle.com/en/java/javase/18/docs/api/java.base/java/io/PrintStream.html#format(java.lang.String,java.lang.Object...)) and [`printf`](https://docs.oracle.com/en/java/javase/18/docs/api/java.base/java/io/PrintStream.html#printf(java.lang.String,java.lang.Object...)), are equivalent to one another. The familiar [`System.out`](https://docs.oracle.com/en/java/javase/18/docs/api/java.base/java/lang/System.html#out) that you have been using happens to be a [`PrintStream`](https://docs.oracle.com/en/java/javase/18/docs/api/java.base/java/io/PrintStream.html) object, so you can invoke [`PrintStream`](https://docs.oracle.com/en/java/javase/18/docs/api/java.base/java/io/PrintStream.html) methods on [`System.out`](https://docs.oracle.com/en/java/javase/18/docs/api/java.base/java/lang/System.html#out). Thus, you can use [`format`](https://docs.oracle.com/en/java/javase/18/docs/api/java.base/java/io/PrintStream.html#format(java.lang.String,java.lang.Object...)) or [`printf`](https://docs.oracle.com/en/java/javase/18/docs/api/java.base/java/io/PrintStream.html#printf(java.lang.String,java.lang.Object...)) anywhere in your code where you have previously been using [`print`](https://docs.oracle.com/en/java/javase/18/docs/api/java.base/java/io/PrintStream.html#print(int)) or [`println`](https://docs.oracle.com/en/java/javase/18/docs/api/java.base/java/io/PrintStream.html#println(int)). For example,

    System.out.format(.....);
    

Copy

The syntax for these two [`java.io.PrintStream`]([`PrintStream`](https://docs.oracle.com/en/java/javase/18/docs/api/java.base/java/io/PrintStream.html)) methods is the same:

    public PrintStream format(String format, Object... args)
    

Copy

where [`format`](https://docs.oracle.com/en/java/javase/18/docs/api/java.base/java/io/PrintStream.html#format(java.lang.String,java.lang.Object...)) is a string that specifies the formatting to be used and args is a list of the variables to be printed using that formatting. A simple example would be

    System.out.format("The value of " + "the float variable is " +
         "%f, while the value of the " + "integer variable is %d, " +
         "and the string is %s", floatVar, intVar, stringVar); 
    

Copy

The first parameter, [`format`](https://docs.oracle.com/en/java/javase/18/docs/api/java.base/java/io/PrintStream.html#format(java.lang.String,java.lang.Object...)), is a format string specifying how the objects in the second parameter, `args`, are to be formatted. The [`format`](https://docs.oracle.com/en/java/javase/18/docs/api/java.base/java/io/PrintStream.html#format(java.lang.String,java.lang.Object...)) string contains plain text as well as format specifiers, which are special characters that format the arguments of `Object...` args. (The notation `Object...` args is called _varargs_, which means that the number of arguments may vary.)

Format specifiers begin with a percent sign (`%`) and end with a converter. The converter is a character indicating the type of argument to be formatted. In between the percent sign (`%`) and the converter you can have optional flags and specifiers. There are many converters, flags, and specifiers, which are documented in [`java.util.Formatter`](https://docs.oracle.com/en/java/javase/18/docs/api/java.base/java/util/Formatter.html).

Here is a basic example:

    int i = 461012;
    System.out.format("The value of i is: %d%n", i)
    

Copy

Specifica che la `%d`singola variabile è un numero intero decimale. È `%n`un carattere di nuova riga indipendente dalla piattaforma. L'uscita è:

    The value of i is: 461012
    

copia

I metodi [`printf`](https://docs.oracle.com/en/java/javase/18/docs/api/java.base/java/io/PrintStream.html#printf(java.lang.String,java.lang.Object...))e sono sovraccaricati. [`format`](https://docs.oracle.com/en/java/javase/18/docs/api/java.base/java/io/PrintStream.html#format(java.lang.String,java.lang.Object...))Ognuno ha una versione con la seguente sintassi:

    public PrintStream format(Locale l, String format, Object... args)
    

copia

Per stampare numeri nel sistema francese (dove viene utilizzata una virgola al posto della cifra decimale nella rappresentazione inglese dei numeri in virgola mobile), ad esempio, dovresti utilizzare:

    System.out.format(Locale.FRANCE,
        "The value of the float " + "variable is %f, while the " +
        "value of the integer variable " + "is %d, and the string is %s%n", 
        floatVar, intVar, stringVar);
    

copia

### Un esempio

La tabella seguente elenca alcuni dei convertitori e dei flag utilizzati nel programma di esempio, `TestFormat.java`, che segue la tabella.

Convertitore

Bandiera

Spiegazione

d

Un numero intero decimale.

f

Un galleggiante.

n

Un nuovo carattere di riga appropriato per la piattaforma che esegue l'applicazione. Dovresti sempre usare `%n`, invece di `\n`.

tB

Una conversione di data e ora: nome completo del mese specifico per la locale.

td, te

Una conversione di data e ora: giorno del mese a 2 cifre. td ha zeri iniziali secondo necessità, te no.

grazie grazie

Una conversione di data e ora: ty = anno a 2 cifre, tY = anno a 4 cifre.

tl

Una conversione di data e ora: ora in formato 12 ore.

tM

Una conversione di data e ora: minuti in 2 cifre, con zeri iniziali se necessario.

città

Una conversione di data e ora: am/pm specifica per locale (minuscolo).

tm

Una conversione di data e ora: mesi in 2 cifre, con zeri iniziali se necessario.

tD

Una conversione di data e ora: data come %tm%td%ty

08

Otto caratteri di larghezza, con zeri iniziali se necessario.

+

Include il segno, positivo o negativo.

,

Include caratteri di raggruppamento specifici della locale.

\-

Giustificato a sinistra.

.3

Tre cifre dopo la virgola.

10.3

Dieci caratteri in larghezza, giustificati a destra, con tre cifre dopo la virgola.

Il programma seguente mostra alcune delle formattazioni che è possibile eseguire con format. L'output è mostrato tra virgolette nel commento incorporato:

    import java.util.Calendar;
    import java.util.Locale;
    
    public class TestFormat {
        
        public static void main(String[] args) {
          long n = 461012;
          System.out.format("%d%n", n);      //  -->  "461012"
          System.out.format("%08d%n", n);    //  -->  "00461012"
          System.out.format("%+8d%n", n);    //  -->  " +461012"
          System.out.format("%,8d%n", n);    // -->  " 461,012"
          System.out.format("%+,8d%n%n", n); //  -->  "+461,012"
          
          double pi = Math.PI;
    
          System.out.format("%f%n", pi);       // -->  "3.141593"
          System.out.format("%.3f%n", pi);     // -->  "3.142"
          System.out.format("%10.3f%n", pi);   // -->  "     3.142"
          System.out.format("%-10.3f%n", pi);  // -->  "3.142"
          System.out.format(Locale.FRANCE,
                            "%-10.4f%n%n", pi); // -->  "3,1416"
    
          Calendar c = Calendar.getInstance();
          System.out.format("%tB %te, %tY%n", c, c, c); // -->  "May 29, 2006"
    
          System.out.format("%tl:%tM %tp%n", c, c, c);  // -->  "2:34 am"
    
          System.out.format("%tD%n", c);    // -->  "05/29/06"
        }
    }
    

copia

> Nota: la discussione in questa sezione copre solo le basi dei metodi [`format`](https://docs.oracle.com/en/java/javase/18/docs/api/java.base/java/io/PrintStream.html#format(java.lang.String,java.lang.Object...))e . [`printf`](https://docs.oracle.com/en/java/javase/18/docs/api/java.base/java/io/PrintStream.html#printf(java.lang.String,java.lang.Object...))Maggiori dettagli possono essere trovati nella sezione I/O di base di questo tutorial, nella pagina "Formattazione". L'uso [`String.format()`](https://docs.oracle.com/en/java/javase/18/docs/api/java.base/java/lang/String.html#format(java.lang.String,java.lang.Object...))di per creare stringhe è trattato in [`Strings`](/learn/strings/).

 

La classe DecimalFormat
-----------------------

È possibile utilizzare la [`java.text.DecimalFormat`](https://docs.oracle.com/en/java/javase/18/docs/api/java.base/java/text/DecimalFormat.html)classe per controllare la visualizzazione di zeri iniziali e finali, prefissi e suffissi, separatori di raggruppamento (migliaia) e separatore decimale. [`DecimalFormat`](https://docs.oracle.com/en/java/javase/18/docs/api/java.base/java/text/DecimalFormat.html)offre una grande flessibilità nella formattazione dei numeri, ma può rendere il tuo codice più complesso.

L'esempio che segue crea un [`DecimalFormat`](https://docs.oracle.com/en/java/javase/18/docs/api/java.base/java/text/DecimalFormat.html)oggetto, `myFormatter`, passando una stringa di pattern al [`DecimalFormat`](https://docs.oracle.com/en/java/javase/18/docs/api/java.base/java/text/DecimalFormat.html)costruttore. Il [`format`](https://docs.oracle.com/en/java/javase/18/docs/api/java.base/java/io/PrintStream.html#format(java.lang.String,java.lang.Object...))metodo, che [`DecimalFormat`](https://docs.oracle.com/en/java/javase/18/docs/api/java.base/java/text/DecimalFormat.html)eredita da [https://docs.oracle.com/en/java/javase/18/docs/api/java.base/java/text/NumberFormat.html](https://docs.oracle.com/en/java/javase/18/docs/api/java.base/java/text/NumberFormat.html) , viene quindi invocato da `myFormatter`—it accetta un valore doppio come argomento e restituisce il numero formattato in una stringa.

Ecco un programma di esempio che illustra l'uso di [`DecimalFormat`](https://docs.oracle.com/en/java/javase/18/docs/api/java.base/java/text/DecimalFormat.html):

    import java.text.*;
    
    public class DecimalFormatDemo {
    
       static public void customFormat(String pattern, double value ) {
          DecimalFormat myFormatter = new DecimalFormat(pattern);
          String output = myFormatter.format(value);
          System.out.println(value + "  " + pattern + "  " + output);
       }
    
       static public void main(String[] args) {
    
          customFormat("###,###.###", 123456.789);
          customFormat("###.##", 123456.789);
          customFormat("000000.000", 123.78);
          customFormat("$###,###.###", 12345.67);  
       }
    }
    

copia

L'uscita è:

    123456.789  ###,###.###  123,456.789
    123456.789  ###.##  123456.79
    123.78  000000.000  000123.780
    12345.67  $###,###.###  $12,345.67
    

copia

La tabella seguente spiega ciascuna riga di output.

Valore

Modello

Produzione

Spiegazione

123456.789

###,###.###

123,456.789

Il cancelletto ( `#`) indica una cifra, la virgola è un segnaposto per il separatore di raggruppamento e il punto è un segnaposto per il separatore decimale.

123456.789

###.##

123456.79

Il `value`ha tre cifre a destra del punto decimale, ma il modello ne ha solo due. Il metodo format gestisce questo arrotondando per eccesso.

123.78

000000.000

000123.780

Specifica gli `pattern`zeri iniziali e finali, poiché viene utilizzato il carattere 0 al posto del cancelletto (#).

12345.67

$###,###.###

$12,345.67

Il primo carattere `pattern`è il simbolo del dollaro ( `$`). Si noti che precede immediatamente la cifra più a sinistra nel formato `output`.

 

Oltre l'aritmetica di base
--------------------------

Il linguaggio di programmazione Java supporta l'aritmetica di base con i suoi operatori aritmetici: `+`, `-`, `*`, `/`e `%`. La [`Math`](https://docs.oracle.com/en/java/javase/18/docs/api/java.base/java/lang/Math.html)classe nel [`java.lang`](https://docs.oracle.com/en/java/javase/18/docs/api/java.base/java/lang/package-summary.html)pacchetto fornisce metodi e costanti per eseguire calcoli matematici più avanzati.

I metodi nella [`Math`](https://docs.oracle.com/en/java/javase/18/docs/api/java.base/java/lang/Math.html)classe sono tutti statici, quindi li chiami direttamente dalla classe, in questo modo:

    Math.cos(angle);
    

copia

> Nota: utilizzando la funzione del linguaggio di importazione statico, non è necessario scrivere [`Math`](https://docs.oracle.com/en/java/javase/18/docs/api/java.base/java/lang/Math.html)davanti a ogni funzione matematica: `import static java.lang.Math.*;` ciò consente di invocare i [`Math`](https://docs.oracle.com/en/java/javase/18/docs/api/java.base/java/lang/Math.html)metodi di classe con i loro nomi semplici. Per esempio: `cos(angle);`

### Costanti e metodi di base

La [`Math`](https://docs.oracle.com/en/java/javase/18/docs/api/java.base/java/lang/Math.html)classe include due costanti:

*   [`Math.E`](https://docs.oracle.com/en/java/javase/18/docs/api/java.base/java/lang/Math.html#E), che è la base dei logaritmi naturali, e
*   [`Math.PI`](https://docs.oracle.com/en/java/javase/18/docs/api/java.base/java/lang/Math.html#PI), che è il rapporto tra la circonferenza di un cerchio e il suo diametro.

La [`Math`](https://docs.oracle.com/en/java/javase/18/docs/api/java.base/java/lang/Math.html)classe include anche più di 40 metodi statici. La tabella seguente elenca alcuni dei metodi di base.

#### Calcolo di un valore assoluto

*   [`double abs(double d)`](https://docs.oracle.com/en/java/javase/18/docs/api/java.base/java/lang/Math.html#abs(double))
*   [`float abs(float f)`](https://docs.oracle.com/en/java/javase/18/docs/api/java.base/java/lang/Math.html#abs(float))
*   [`int abs(int i)`](https://docs.oracle.com/en/java/javase/18/docs/api/java.base/java/lang/Math.html#abs(int))
*   [`long abs(long lng)`](https://docs.oracle.com/en/java/javase/18/docs/api/java.base/java/lang/Math.html#abs(long))

#### Routing un valore

*   [`double ceil(double d)`](https://docs.oracle.com/en/java/javase/18/docs/api/java.base/java/lang/Math.html#ceil(double)): Restituisce il numero intero più piccolo maggiore o uguale all'argomento. Restituito come `double`.
*   [`double floor(double d)`](https://docs.oracle.com/en/java/javase/18/docs/api/java.base/java/lang/Math.html#floor(double)): Restituisce il numero intero più grande minore o uguale all'argomento. Restituito come `double`.
*   [`double rint(double d)`](https://docs.oracle.com/en/java/javase/18/docs/api/java.base/java/lang/Math.html#rint(double)): Restituisce l'intero che ha il valore più vicino all'argomento. Restituito come `double`.
*   [`long round(double d)`](https://docs.oracle.com/en/java/javase/18/docs/api/java.base/java/lang/Math.html#round(double))e [`int round(float f)`](https://docs.oracle.com/en/java/javase/18/docs/api/java.base/java/lang/Math.html#round(float)): restituisce il più vicino `long`o `int`, come indicato dal tipo restituito del metodo, all'argomento.

#### Calcolo di un min

*   [`double min(double arg1, double arg2)`](https://docs.oracle.com/en/java/javase/18/docs/api/java.base/java/lang/Math.html#min(double,double))
*   [`float min(float arg1, float arg2)`](https://docs.oracle.com/en/java/javase/18/docs/api/java.base/java/lang/Math.html#min(float,float))
*   [`int min(int arg1, int arg2)`](https://docs.oracle.com/en/java/javase/18/docs/api/java.base/java/lang/Math.html#min(int,int))
*   [`long min(long arg1, long arg2)`](https://docs.oracle.com/en/java/javase/18/docs/api/java.base/java/lang/Math.html#min(long,long))

#### Calcolo di un massimo

*   [`double max(double arg1, double arg2)`](https://docs.oracle.com/en/java/javase/18/docs/api/java.base/java/lang/Math.html#max(double,double))
*   [`float max(float arg1, float arg2)`](https://docs.oracle.com/en/java/javase/18/docs/api/java.base/java/lang/Math.html#max(float,float))
*   [`int max(int arg1, int arg2)`](https://docs.oracle.com/en/java/javase/18/docs/api/java.base/java/lang/Math.html#max(int,int))
*   [`long max(long arg1, long arg2)`](https://docs.oracle.com/en/java/javase/18/docs/api/java.base/java/lang/Math.html#max(long,long))

Il seguente programma, `BasicMathDemo`, illustra come utilizzare alcuni di questi metodi:

    public class BasicMathDemo {
        public static void main(String[] args) {
            double a = -191.635;
            double b = 43.74;
            int c = 16, d = 45;
    
            System.out.printf("The absolute value " + "of %.3f is %.3f%n", 
                              a, Math.abs(a));
    
            System.out.printf("The ceiling of " + "%.2f is %.0f%n", 
                              b, Math.ceil(b));
    
            System.out.printf("The floor of " + "%.2f is %.0f%n", 
                              b, Math.floor(b));
    
            System.out.printf("The rint of %.2f " + "is %.0f%n", 
                              b, Math.rint(b));
    
            System.out.printf("The max of %d and " + "%d is %d%n",
                              c, d, Math.max(c, d));
    
            System.out.printf("The min of of %d " + "and %d is %d%n",
                              c, d, Math.min(c, d));
        }
    }
    

copia

Ecco l'output di questo programma:

    The absolute value of -191.635 is 191.635
    The ceiling of 43.74 is 44
    The floor of 43.74 is 43
    The rint of 43.74 is 44
    The max of 16 and 45 is 45
    The min of 16 and 45 is 16
    

copia

### Metodi esponenziali e logaritmici

La tabella successiva elenca i metodi esponenziali e logaritmici della [`Math`](https://docs.oracle.com/en/java/javase/18/docs/api/java.base/java/lang/Math.html)classe.

*   [`double exp(double d)`](https://docs.oracle.com/en/java/javase/18/docs/api/java.base/java/lang/Math.html#exp(double)): Restituisce la base dei logaritmi naturali, e, alla potenza dell'argomento.
*   [`double log(double d)`](https://docs.oracle.com/en/java/javase/18/docs/api/java.base/java/lang/Math.html#log(double)): Restituisce il logaritmo naturale dell'argomento.
*   [`double pow(double base, double exponent)`](https://docs.oracle.com/en/java/javase/18/docs/api/java.base/java/lang/Math.html#pow(double,double)): Restituisce il valore del primo argomento elevato alla potenza del secondo argomento.
*   [`double sqrt(double d)`](https://docs.oracle.com/en/java/javase/18/docs/api/java.base/java/lang/Math.html#sqrt(double)): Restituisce la radice quadrata dell'argomento.

Il seguente programma, `ExponentialDemo`, visualizza il valore di `e`, quindi chiama ciascuno dei metodi elencati nella tabella precedente su numeri scelti arbitrariamente:

    public class ExponentialDemo {
        public static void main(String[] args) {
            double x = 11.635;
            double y = 2.76;
    
            System.out.printf("The value of " + "e is %.4f%n",
                              Math.E);
    
            System.out.printf("exp(%.3f) " + "is %.3f%n",
                              x, Math.exp(x));
    
            System.out.printf("log(%.3f) is " + "%.3f%n",
                              x, Math.log(x));
    
            System.out.printf("pow(%.3f, %.3f) " + "is %.3f%n",
                              x, y, Math.pow(x, y));
    
            System.out.printf("sqrt(%.3f) is " + "%.3f%n",
                              x, Math.sqrt(x));
        }
    }
    

copia

Ecco l'output che vedrai quando esegui `ExponentialDemo`:

    The value of e is 2.7183
    exp(11.635) is 112983.831
    log(11.635) is 2.454
    pow(11.635, 2.760) is 874.008
    sqrt(11.635) is 3.411
    

copia

### Metodi Trigonometrici

La [`Math`](https://docs.oracle.com/en/java/javase/18/docs/api/java.base/java/lang/Math.html)classe fornisce anche una raccolta di funzioni trigonometriche, che sono riassunte nella tabella seguente. Il valore passato a ciascuno di questi metodi è un angolo espresso in radianti. Puoi usare il [`toRadians(double d)`](https://docs.oracle.com/en/java/javase/18/docs/api/java.base/java/lang/Math.html#toRadians(double))metodo per convertire da gradi a radianti.

*   [`double sin(double d)`](https://docs.oracle.com/en/java/javase/18/docs/api/java.base/java/lang/Math.html#sin(double)): Restituisce il seno del valore double specificato.
*   [`double cos(double d)`](https://docs.oracle.com/en/java/javase/18/docs/api/java.base/java/lang/Math.html#cos(double)): Restituisce il coseno del valore double specificato.
*   [`double tan(double d)`](https://docs.oracle.com/en/java/javase/18/docs/api/java.base/java/lang/Math.html#tan(double)): Restituisce la tangente del valore double specificato.
*   [`double asin(double d)`](https://docs.oracle.com/en/java/javase/18/docs/api/java.base/java/lang/Math.html#asin(double)): Restituisce l'arcoseno del valore double specificato.
*   [`double acos(double d)`](https://docs.oracle.com/en/java/javase/18/docs/api/java.base/java/lang/Math.html#acos(double)): Restituisce l'arcoseno del valore double specificato.
*   [`double atan(double d)`](https://docs.oracle.com/en/java/javase/18/docs/api/java.base/java/lang/Math.html#atan(double)): Restituisce l'arcotangente del valore double specificato.
*   [`double atan2(double y, double x)`](https://docs.oracle.com/en/java/javase/18/docs/api/java.base/java/lang/Math.html#atan2(double,double)): converte le coordinate rettangolari (x, y) in coordinate polari (r, theta) e restituisce theta.
*   [`double toDegrees(double d)`](https://docs.oracle.com/en/java/javase/18/docs/api/java.base/java/lang/Math.html#toDegrees(double))e [`double toRadians(double d)`](https://docs.oracle.com/en/java/javase/18/docs/api/java.base/java/lang/Math.html#toRadians(double)): converte l'argomento in gradi o radianti.

Ecco un programma, `TrigonometricDemo`che utilizza ciascuno di questi metodi per calcolare vari valori trigonometrici per un angolo di 45 gradi:

    public class TrigonometricDemo {
        public static void main(String[] args) {
            double degrees = 45.0;
            double radians = Math.toRadians(degrees);
            
            System.out.format("The value of pi " + "is %.4f%n",
                               Math.PI);
    
            System.out.format("The sine of %.1f " + "degrees is %.4f%n",
                              degrees, Math.sin(radians));
    
            System.out.format("The cosine of %.1f " + "degrees is %.4f%n",
                              degrees, Math.cos(radians));
    
            System.out.format("The tangent of %.1f " + "degrees is %.4f%n",
                              degrees, Math.tan(radians));
    
            System.out.format("The arcsine of %.4f " + "is %.4f degrees %n", 
                              Math.sin(radians), 
                              Math.toDegrees(Math.asin(Math.sin(radians))));
    
            System.out.format("The arccosine of %.4f " + "is %.4f degrees %n", 
                              Math.cos(radians),  
                              Math.toDegrees(Math.acos(Math.cos(radians))));
    
            System.out.format("The arctangent of %.4f " + "is %.4f degrees %n", 
                              Math.tan(radians), 
                              Math.toDegrees(Math.atan(Math.tan(radians))));
        }
    }
    

copia

L'output di questo programma è il seguente:

    The value of pi is 3.1416
    The sine of 45.0 degrees is 0.7071
    The cosine of 45.0 degrees is 0.7071
    The tangent of 45.0 degrees is 1.0000
    The arcsine of 0.7071 is 45.0000 degrees
    The arccosine of 0.7071 is 45.0000 degrees
    The arctangent of 1.0000 is 45.0000 degrees
    

copia

 

Numeri casuali
--------------

Il [`random()`](https://docs.oracle.com/en/java/javase/18/docs/api/java.base/java/lang/Math.html#random())metodo restituisce un numero selezionato in modo pseudo-casuale compreso tra 0,0 e 1,0. L'intervallo include 0,0 ma non 1,0. In altre parole: `0.0 <= Math.random() < 1.0`. Per ottenere un numero in un intervallo diverso, puoi eseguire aritmetica sul valore restituito dal metodo casuale. Ad esempio, per generare un numero intero compreso tra 0 e 9, dovresti scrivere:

    int number = (int)(Math.random() * 10);
    



Moltiplicando il valore per 10, l'intervallo di valori possibili diventa `0.0 <= number < 10.0`.

L'utilizzo [`Math.random`]((https://docs.oracle.com/en/java/javase/18/docs/api/java.base/java/lang/Math.html#random()))funziona bene quando è necessario generare un singolo numero casuale. Se è necessario generare una serie di numeri casuali, è necessario creare un'istanza di [`java.util.Random`](https://docs.oracle.com/en/java/javase/18/docs/api/java.base/java/util/Random.html)e richiamare metodi su quell'oggetto per generare numeri.

