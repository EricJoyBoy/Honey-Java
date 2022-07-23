
Usare gli operatori nei tuoi programmi
======================================

 

Operatori
---------

Ora che hai imparato a dichiarare e inizializzare le variabili, probabilmente vorrai sapere come _fare qualcosa_ con esse. Imparare gli operatori del linguaggio di programmazione Java è un buon punto di partenza. Gli operatori sono simboli speciali che eseguono operazioni specifiche su uno, due o tre operandi e quindi restituiscono un risultato.

Mentre esploriamo gli operatori del linguaggio di programmazione Java, può essere utile sapere in anticipo quali operatori hanno la precedenza più alta. Gli operatori nella tabella seguente sono elencati in base all'ordine di precedenza. Più un operatore appare vicino alla parte superiore della tabella, maggiore è la sua precedenza. Gli operatori con una precedenza più alta vengono valutati prima degli operatori con una precedenza relativamente più bassa. Gli operatori sulla stessa linea hanno la stessa precedenza. Quando nella stessa espressione compaiono operatori di uguale precedenza, deve governare una regola che viene valutata per prima. Tutti gli operatori binari, ad eccezione degli operatori di assegnazione, vengono valutati da sinistra a destra; gli operatori di assegnazione vengono valutati da destra a sinistra.

Operatori

Precedenza

suffisso

`expr++` `expr--`

unario

`++expr` `--expr` `+expr` `-expr` `~` `!`

moltiplicativo

`*` `/` `%`

additivo

`+` `-`

spostare

`<<` `>>` `>>>`

relazionale

`<` `>` `<=` `>=` `instanceof`

uguaglianza

`==` `!=`

bit a bit E

`&`

bit per bit OR esclusivo

`^`

bit per bit OR inclusi

`|`

logico E

`&&`

logico OR

`||`

ternario

`? :`

Incarico

`=` `+=` `-=` `*=` `/=` `%=` `&=` `^=` `|=` `<<=` `>>=` `>>>=`

Nella programmazione generica, alcuni operatori tendono ad apparire più frequentemente di altri; ad esempio, l'operatore di assegnazione `=`è molto più comune dell'operatore di spostamento a destra senza segno `>>>`. Con questo in mente, la discussione seguente si concentra prima sugli operatori che è più probabile che utilizziate regolarmente e termina concentrandosi su quelli che sono meno comuni. Ogni discussione è accompagnata da codice di esempio che è possibile compilare ed eseguire. Studiare il suo output aiuterà a rafforzare ciò che hai appena appreso.

 

L'operatore di assegnazione semplice
------------------------------------

Uno degli operatori più comuni che incontrerai è l'operatore di assegnazione semplice `=`. Hai visto questo operatore nella `Bicycle`classe; assegna il valore alla sua destra all'operando alla sua sinistra:

    int cadence = 0;
    int speed = 0;
    int gear = 1;
    

copia

Questo operatore può essere utilizzato anche sugli oggetti per assegnare riferimenti a oggetti, come discusso nella sezione [Creazione di oggetti](/learn/creating-and-using-objects/) .

 

Gli operatori aritmetici
------------------------

Il linguaggio di programmazione Java fornisce operatori che eseguono addizioni, sottrazioni, moltiplicazioni e divisioni. Ci sono buone probabilità che li riconoscerai dalle loro controparti in matematica di base. L'unico simbolo che potrebbe sembrare nuovo per te è `%`, che divide un operando per un altro e restituisce il resto come risultato.

Operatore

Descrizione

`+`

Operatore additivo (usato anche per la concatenazione di stringhe)

`-`

Operatore di sottrazione

`*`

Operatore di moltiplicazione

`/`

Operatore di divisione

`%`

Operatore resto

Il programma seguente, `ArithmeticDemo`, verifica gli operatori aritmetici.

    class ArithmeticDemo {
    
        public static void main (String[] args) {
    
            int result = 1 + 2;
            // result is now 3
            System.out.println("1 + 2 = " + result);
            int original_result = result;
    
            result = result - 1;
            // result is now 2
            System.out.println(original_result + " - 1 = " + result);
            original_result = result;
    
            result = result * 2;
            // result is now 4
            System.out.println(original_result + " * 2 = " + result);
            original_result = result;
    
            result = result / 2;
            // result is now 2
            System.out.println(original_result + " / 2 = " + result);
            original_result = result;
    
            result = result + 8;
            // result is now 10
            System.out.println(original_result + " + 8 = " + result);
            original_result = result;
    
            result = result % 7;
            // result is now 3
            System.out.println(original_result + " % 7 = " + result);
        }
    }
    

copia

Questo programma stampa quanto segue:

    1 + 2 = 3
    3 - 1 = 2
    2 * 2 = 4
    4 / 2 = 2
    2 + 8 = 10
    10 % 7 = 3
    

copia

Puoi anche combinare gli operatori aritmetici con l'operatore di assegnazione semplice per creare assegnazioni composte. Ad esempio, `x += 1;`ed `x = x + 1;`entrambi incrementano il valore di `x`di 1.

L' `+`operatore può essere utilizzato anche per concatenare (unire) due stringhe insieme, come mostrato nel seguente `ConcatDemo`programma:

    class ConcatDemo {
        public static void main(String[] args){
            String firstString = "This is";
            String secondString = " a concatenated string.";
            String thirdString = firstString+secondString;
            System.out.println(thirdString);
        }
    }
    

copia

Alla fine di questo programma, la variabile `thirdString`contiene `This is a concatenated string.`, che viene stampata sullo standard output.

 

Gli operatori unari
-------------------

Gli operatori unari richiedono un solo operando; eseguono varie operazioni come incrementare/decrementare un valore di uno, negare un'espressione o invertire il valore di un booleano.

Operatore

Descrizione

`+`

Operatore unario plus; indica un valore positivo (i numeri sono positivi senza questo, tuttavia)

`-`

Operatore meno unario; nega un'espressione

`++`

Operatore incrementale; incrementa un valore di 1

`--`

Operatore di decremento; decrementa un valore di 1

`!`

Operatore di complemento logico; inverte il valore di un booleano

Il seguente programma, `UnaryDemo`, verifica gli operatori unari:

    class UnaryDemo {
    
        public static void main(String[] args) {
    
            int result = +1;
            // result is now 1
            System.out.println(result);
    
            result--;
            // result is now 0
            System.out.println(result);
    
            result++;
            // result is now 1
            System.out.println(result);
    
            result = -result;
            // result is now -1
            System.out.println(result);
    
            boolean success = false;
            // false
            System.out.println(success);
            // true
            System.out.println(!success);
        }
    }
    

copia

Gli operatori di incremento/decremento possono essere applicati prima (prefisso) o dopo (postfisso) l'operando. Il codice `result++;`e `++result;`entrambi finiranno con il risultato di essere incrementati di uno. L'unica differenza è che la versione del prefisso ( `++result`) restituisce il valore incrementato, mentre la versione del suffisso ( `result++`) restituisce il valore originale. Se stai solo eseguendo un semplice incremento/decremento, non importa quale versione scegli. Ma se usi questo operatore in una parte di un'espressione più ampia, quella che scegli potrebbe fare una differenza significativa.

Il programma seguente, `PrePostDemo`, illustra l'operatore di incremento unario prefisso/postfisso:

    class PrePostDemo {
        public static void main(String[] args){
            int i = 3;
            i++;
            // prints 4
            System.out.println(i);
            ++i;               
            // prints 5
            System.out.println(i);
            // prints 6
            System.out.println(++i);
            // prints 6
            System.out.println(i++);
            // prints 7
            System.out.println(i);
        }
    }
    

copia

 

L'uguaglianza e gli operatori relazionali
-----------------------------------------

Gli operatori di uguaglianza e relazionale determinano se un operando è maggiore, minore, uguale o diverso da un altro operando. Probabilmente anche la maggior parte di questi operatori ti sembrerà familiare. Tieni presente che devi usare `==`, not `=`, quando verifichi se due valori primitivi sono uguali.

Operatore

Descrizione

`==`

uguale a

`!=`

non uguale a

`>`

più grande di

`>=`

maggiore o uguale a

`<`

meno di

`<=`

minore o uguale a

Il seguente programma, `ComparisonDemo`, verifica gli operatori di confronto:

    class ComparisonDemo {
    
        public static void main(String[] args){
            int value1 = 1;
            int value2 = 2;
            if(value1 == value2)
                System.out.println("value1 == value2");
            if(value1 != value2)
                System.out.println("value1 != value2");
            if(value1 > value2)
                System.out.println("value1 > value2");
            if(value1 < value2)
                System.out.println("value1 < value2");
            if(value1 <= value2)
                System.out.println("value1 <= value2");
        }
    }
    

copia

L'esecuzione di questo programma produce il seguente output:

    value1 != value2
    value1 <  value2
    value1 <= value2
    

copia

 

Gli operatori condizionali
--------------------------

Gli operatori `&&`e `||`eseguono operazioni AND condizionale e OR condizionale su due espressioni booleane. Questi operatori mostrano un comportamento di "cortocircuito", il che significa che il secondo operando viene valutato solo se necessario.

Operatore

Descrizione

`&&`

Condizionale-AND

`||`

Condizionale-OR

Il seguente programma, `ConditionalDemo1`, verifica questi operatori:

    class ConditionalDemo1 {
    
        public static void main(String[] args){
            int value1 = 1;
            int value2 = 2;
            if ((value1 == 1) && (value2 == 2))
                System.out.println("value1 is 1 AND value2 is 2");
            if ((value1 == 1) || (value2 == 1))
                System.out.println("value1 is 1 OR value2 is 1");
        }
    }
    

copia

Un altro operatore condizionale è `?:`, che può essere considerato una scorciatoia per `if-then-else`un'istruzione (discussa nella [sezione delle dichiarazioni di flusso di controllo](/learn/control-flow-statements/) ). Questo operatore è anche noto come operatore _ternario_ perché utilizza tre operandi. Nell'esempio seguente, questo operatore deve essere letto come: "Se someCondition è true, assegna il valore di value1 al risultato. Altrimenti, assegna il valore di value2 al risultato".

Il seguente programma, `ConditionalDemo2`, verifica l' `?:`operatore:

    class ConditionalDemo2 {
    
        public static void main(String[] args){
            int value1 = 1;
            int value2 = 2;
            int result;
            boolean someCondition = true;
            result = someCondition ? value1 : value2;
    
            System.out.println(result);
        }
    }
    

copia

Perché `someCondition`è vero, questo programma stampa "1" sullo schermo. Usa l' `?:`operatore invece di `if-then-else`un'istruzione se rende il tuo codice più leggibile; ad esempio, quando le espressioni sono compatte e prive di effetti collaterali (come i compiti).

 

L'istanza dell'operatore di confronto dei tipi di
-------------------------------------------------

L' `instanceof`operatore confronta un oggetto con un tipo specificato. Puoi usarlo per verificare se un oggetto è un'istanza di una classe, un'istanza di una sottoclasse o un'istanza di una classe che implementa una particolare interfaccia.

Il seguente programma, `InstanceofDemo`, definisce una classe genitore (named `Parent`), un'interfaccia semplice (named `MyInterface`) e una classe figlia (named `Child`) che eredita dal genitore e implementa l'interfaccia.

    class InstanceofDemo {
        public static void main(String[] args) {
    
            Parent obj1 = new Parent();
            Parent obj2 = new Child();
    
            System.out.println("obj1 instanceof Parent: "
                + (obj1 instanceof Parent));
            System.out.println("obj1 instanceof Child: "
                + (obj1 instanceof Child));
            System.out.println("obj1 instanceof MyInterface: "
                + (obj1 instanceof MyInterface));
            System.out.println("obj2 instanceof Parent: "
                + (obj2 instanceof Parent));
            System.out.println("obj2 instanceof Child: "
                + (obj2 instanceof Child));
            System.out.println("obj2 instanceof MyInterface: "
                + (obj2 instanceof MyInterface));
        }
    }
    
    class Parent {}
    class Child extends Parent implements MyInterface {}
    interface MyInterface {}
    

copia

Il seguente programma produce il seguente output:

    obj1 instanceof Parent: true
    obj1 instanceof Child: false
    obj1 instanceof MyInterface: false
    obj2 instanceof Parent: true
    obj2 instanceof Child: true
    obj2 instanceof MyInterface: true
    

copia

Quando si utilizza l' `instanceof`operatore, tenere presente che `null`non è un'istanza di nulla.

 

Operatori Bitwise e Bit Shift
-----------------------------

Il linguaggio di programmazione Java fornisce anche operatori che eseguono operazioni bit a bit e bit shift sui tipi integrali. Gli operatori discussi in questa sezione sono usati meno comunemente. Pertanto, la loro copertura è breve; l'intento è semplicemente quello di renderti consapevole dell'esistenza di questi operatori.

L'operatore di complemento bit a bit unario `~`inverte un modello di bit; può essere applicato a qualsiasi tipo di integrale, facendo ogni "0" un "1" e ogni "1" uno "0". Ad esempio, un byte contiene 8 bit; l'applicazione di questo operatore a un valore il cui modello di bit è `00000000`cambierebbe il suo modello in `11111111`.

L'operatore di spostamento a sinistra con segno `<<`sposta un modello di bit a sinistra e l'operatore di spostamento a destra con segno `>>`sposta un modello di bit a destra. Il modello di bit è dato dall'operando di sinistra e il numero di posizioni da spostare dall'operando di destra. L'operatore di spostamento a destra senza segno `>>>`sposta uno zero nella posizione più a sinistra, mentre la posizione più a sinistra dopo `>>`dipende dall'estensione del segno.

L' `&`operatore bit per bit esegue un'operazione AND bit per bit.

L' `^`operatore bit per bit esegue un'operazione OR bit per bit esclusiva.

L' `&`operatore bit per bit esegue un'operazione OR bit per bit.

Il programma seguente, `BitDemo`, utilizza l'operatore AND bit per bit per stampare il numero "2" sullo standard output.

    class BitDemo {
        public static void main(String[] args) {
            int bitmask = 0x000F;
            int val = 0x2222;
            // prints "2"
            System.out.println(val & bitmask);
        }
    }
    


