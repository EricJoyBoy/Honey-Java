

Dichiarazioni di flusso di controllo
====================================

 

La dichiarazione se-allora
--------------------------

L' `if-then`istruzione è la più elementare di tutte le istruzioni di flusso di controllo. Dice al tuo programma di eseguire una determinata sezione di codice solo se un particolare test restituisce `true`. Ad esempio, la `Bicycle`classe potrebbe consentire ai freni di diminuire la velocità della bicicletta solo se la bicicletta è già in movimento. Una possibile implementazione del `applyBrakes()`metodo potrebbe essere la seguente:

    void applyBrakes() {
        // the "if" clause: bicycle must be moving
        if (isMoving){
            // the "then" clause: decrease current speed
            currentSpeed--;
        }
    }
    

copia

Se questo test restituisce `false`(il che significa che la bicicletta non è in movimento), il controllo salta alla fine `if-then`dell'istruzione.

Inoltre, le parentesi graffe di apertura e chiusura sono facoltative, a condizione che la clausola "then" contenga una sola affermazione:

    void applyBrakes() {
        // same as above, but without braces
        if (isMoving)
            currentSpeed--;
    }
    

copia

Decidere quando omettere le parentesi graffe è una questione di gusto personale. Ometterli può rendere il codice più fragile. Se in seguito viene aggiunta una seconda istruzione alla clausola "then", un errore comune sarebbe dimenticare di aggiungere le parentesi graffe appena richieste. Il compilatore non può rilevare questo tipo di errore; otterrai solo risultati sbagliati.

 

La dichiarazione se-allora-altro
--------------------------------

L' `if-then-else`istruzione fornisce un percorso secondario di esecuzione quando una clausola "if" restituisce `false`. È possibile utilizzare `if-then-else`un'istruzione nel `applyBrakes()`metodo per intraprendere un'azione se i freni vengono applicati quando la bicicletta non è in movimento. In questo caso, l'azione è semplicemente stampare un messaggio di errore che indica che la bicicletta si è già fermata.

    void applyBrakes() {
        if (isMoving) {
            currentSpeed--;
        } else {
            System.err.println("The bicycle has already stopped!");
        }
    }
    

copia

Il seguente programma, `IfElseDemo`, assegna un voto in base al valore del punteggio di un test: una A per un punteggio pari o superiore al 90%, una B per un punteggio pari o superiore all'80% e così via.

    class IfElseDemo {
        public static void main(String[] args) {
    
            int testscore = 76;
            char grade;
    
            if (testscore >= 90) {
                grade = 'A';
            } else if (testscore >= 80) {
                grade = 'B';
            } else if (testscore >= 70) {
                grade = 'C';
            } else if (testscore >= 60) {
                grade = 'D';
            } else {
                grade = 'F';
            }
            System.out.println("Grade = " + grade);
        }
    }
    

copia

L'output del programma è:

    Grade = C
    

copia

Potresti aver notato che il valore di `testscore`può soddisfare più di un'espressione nell'istruzione composta: `76 >= 70`e `76 >= 60`. Tuttavia, una volta soddisfatta una condizione, vengono eseguite le istruzioni appropriate ( `grade = 'C';`) e le condizioni rimanenti non vengono valutate.

 

Le dichiarazioni mentre e fare mentre
-------------------------------------

L' `while`istruzione esegue continuamente un blocco di istruzioni mentre una particolare condizione è `true`. La sua sintassi può essere espressa come:

    while (expression) {
         statement(s)
    }
    

copia

L' `while`istruzione valuta l'espressione, che deve restituire un `boolean`valore. Se l'espressione restituisce `true`, l' `while`istruzione esegue il `statement(s)`blocco while. L' `while`istruzione continua a testare l'espressione ed eseguire il suo blocco finché l'espressione non restituisce `false`. L'utilizzo `while`dell'istruzione per stampare i valori da 1 a 10 può essere eseguito come nel seguente `WhileDemo`programma:

    class WhileDemo {
        public static void main(String[] args){
            int count = 1;
            while (count < 11) {
                System.out.println("Count is: " + count);
                count++;
            }
        }
    }
    

copia

Puoi implementare un ciclo infinito usando l' `while`istruzione come segue:

    while (true){
        // your code goes here
    }
    

copia

Il linguaggio di programmazione Java fornisce anche `do-while`un'istruzione, che può essere espressa come segue:

    do {
         statement(s)
    } while (expression);
    

copia

La differenza tra `do-while`ed `while`è che `do-while`valuta la sua espressione nella parte inferiore del ciclo anziché nella parte superiore. Pertanto, le istruzioni all'interno del `do`blocco vengono sempre eseguite almeno una volta, come mostrato nel seguente `DoWhileDemo`programma:

    class DoWhileDemo {
        public static void main(String[] args){
            int count = 1;
            do {
                System.out.println("Count is: " + count);
                count++;
            } while (count < 11);
        }
    }
    

copia

 

La dichiarazione per
--------------------

L' `for`istruzione fornisce un modo compatto per eseguire l'iterazione su un intervallo di valori. I programmatori spesso lo chiamano "ciclo for" a causa del modo in cui viene ripetuto ripetutamente fino a quando una particolare condizione non è soddisfatta. La forma generale della `for`dichiarazione può essere espressa come segue:

    for (initialization; termination; increment) {
        statement(s)
    }
    

copia

Quando si utilizza questa versione dell'istruzione for, tenere presente che:

*   L' espressione di _inizializzazione_ inizializza il ciclo; viene eseguito una volta, all'inizio del ciclo.
*   When the _termination_ expression evaluates to `false`, the loop terminates.
*   The _increment_ expression is invoked after each iteration through the loop; it is perfectly acceptable for this expression to increment _or_ decrement a value.

The following program, `ForDemo`, uses the general form of the `for` statement to print the numbers 1 through 10 to standard output:

    class ForDemo {
        public static void main(String[] args){
             for(int i = 1; i < 11; i++){
                  System.out.println("Count is: " + i);
             }
        }
    }
    

Copy

The output of this program is:

    Count is: 1
    Count is: 2
    Count is: 3
    Count is: 4
    Count is: 5
    Count is: 6
    Count is: 7
    Count is: 8
    Count is: 9
    Count is: 10
    

Copy

Notice how the code declares a variable within the initialization expression. The scope of this variable extends from its declaration to the end of the block governed by the `for` statement, so it can be used in the termination and increment expressions as well. If the variable that controls a `for` statement is not needed outside of the loop, it is best to declare the variable in the initialization expression. The names `i`, `j`, and `k` are often used to control `for` loops; declaring them within the initialization expression limits their life span and reduces errors.

The three expressions of the `for` loop are optional; an infinite loop can be created as follows:

    // infinite loop
    for ( ; ; ) {
    
        // your code goes here
    }
    

Copy

L' `for`istruzione ha anche un altro modulo progettato per l'iterazione attraverso raccolte e matrici. Questo modulo viene talvolta indicato come istruzione _avanzata per_ e può essere utilizzato per rendere i tuoi loop più compatti e facili da leggere. Per dimostrare, considera la seguente matrice, che contiene i numeri da 1 a 10:

    int[] numbers = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
    

copia

Il seguente programma, `EnhancedForDemo`, usa l' _Enhanced for_ per scorrere l'array:

    class EnhancedForDemo {
        public static void main(String[] args){
             int[] numbers =
                 {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
             for (int item : numbers) {
                 System.out.println("Count is: " + item);
             }
        }
    }
    

copia

In questo esempio, la variabile `item`contiene il valore corrente dalla matrice dei numeri. L'output di questo programma è lo stesso di prima:

    Count is: 1
    Count is: 2
    Count is: 3
    Count is: 4
    Count is: 5
    Count is: 6
    Count is: 7
    Count is: 8
    Count is: 9
    Count is: 10
    

copia

Raccomandiamo di utilizzare questa forma della `for`dichiarazione invece della forma generale quando possibile.

 

La dichiarazione di rottura
---------------------------

The `break` statement has two forms: labeled and unlabeled. You saw the unlabeled form in the previous discussion of the `switch` statement. You can also use an unlabeled `break` to terminate a `for`, `while`, or `do-while` loop, as shown in the following `BreakDemo` program:

    class BreakDemo {
        public static void main(String[] args) {
    
            int[] arrayOfInts =
                { 32, 87, 3, 589,
                  12, 1076, 2000,
                  8, 622, 127 };
            int searchfor = 12;
    
            int i;
            boolean foundIt = false;
    
            for (i = 0; i < arrayOfInts.length; i++) {
                if (arrayOfInts[i] == searchfor) {
                    foundIt = true;
                    break;
                }
            }
    
            if (foundIt) {
                System.out.println("Found " + searchfor + " at index " + i);
            } else {
                System.out.println(searchfor + " not in the array");
            }
        }
    }
    

Copy

This program searches for the number 12 in an array. The `break` statement, terminates the `for` loop when that value is found. Control flow then transfers to the statement after the `for` loop. This program's output is:

    Found 12 at index 4
    

Copy

Un'istruzione senza etichetta `break`termina l'istruzione innermost `switch`, `for`, `while`o `do-while`, ma un'istruzione con etichetta `break`termina un'istruzione esterna. Il programma seguente, `BreakWithLabelDemo`, è simile al programma precedente, ma utilizza `for`cicli nidificati per cercare un valore in una matrice bidimensionale. Quando viene trovato il valore, un elemento etichettato `break`termina il `for`ciclo esterno (etichettato "ricerca"):

    class BreakWithLabelDemo {
        public static void main(String[] args) {
    
            int[][] arrayOfInts = {
                {  32,   87,    3, 589 },
                {  12, 1076, 2000,   8 },
                { 622,  127,   77, 955 }
            };
            int searchfor = 12;
    
            int i;
            int j = 0;
            boolean foundIt = false;
    
        search:
            for (i = 0; i < arrayOfInts.length; i++) {
                for (j = 0; j < arrayOfInts[i].length;
                     j++) {
                    if (arrayOfInts[i][j] == searchfor) {
                        foundIt = true;
                        break search;
                    }
                }
            }
    
            if (foundIt) {
                System.out.println("Found " + searchfor + " at " + i + ", " + j);
            } else {
                System.out.println(searchfor + " not in the array");
            }
        }
    }
    

copia

Questo è l'output del programma.

    Found 12 at 1, 0
    

copia

L' `break`istruzione termina l'istruzione etichettata; non trasferisce il flusso di controllo all'etichetta. Il flusso di controllo viene trasferito all'istruzione immediatamente dopo l'istruzione etichettata (terminata).

 

La dichiarazione Continua
-------------------------

L' `continue`istruzione salta l'iterazione corrente di un ciclo `for`, `while`o `do-while`. Il modulo senza etichetta salta alla fine del corpo del ciclo più interno e valuta l'espressione booleana che controlla il ciclo. Il seguente programma, `ContinueDemo`, scorre a `String`, contando le occorrenze della lettera `p`. Se il carattere corrente non è a `p`, l' `continue`istruzione salta il resto del ciclo e procede al carattere successivo. Se è un `p`, il programma incrementa il conteggio delle lettere.

    class ContinueDemo {
        public static void main(String[] args) {
    
            String searchMe = "peter piper picked a " + "peck of pickled peppers";
            int max = searchMe.length();
            int numPs = 0;
    
            for (int i = 0; i < max; i++) {
                // interested only in p's
                if (searchMe.charAt(i) != 'p')
                    continue;
    
                // process p's
                numPs++;
            }
            System.out.println("Found " + numPs + " p's in the string.");
        }
    }
    

copia

Ecco l'output di questo programma:

    Found 9 p's in the string.
    

copia

Per vedere questo effetto più chiaramente, prova a rimuovere l' `continue`istruzione e a ricompilarla. Quando esegui di nuovo il programma, il conteggio sarà errato, dicendo che ha trovato 35 `p`'s invece di 9.

Un'istruzione con etichetta `continue`salta l'iterazione corrente di un ciclo esterno contrassegnato con l'etichetta data. Il seguente programma di esempio, `ContinueWithLabelDemo`, utilizza cicli nidificati per cercare una sottostringa all'interno di un'altra stringa. Sono necessari due cicli nidificati: uno per scorrere la sottostringa e uno per scorrere la stringa cercata. Il seguente programma, `ContinueWithLabelDemo`, usa l'etichetta `test`di `continue`per saltare un'iterazione nel ciclo esterno.

    class ContinueWithLabelDemo {
        public static void main(String[] args) {
    
            String searchMe = "Look for a substring in me";
            String substring = "sub";
            boolean foundIt = false;
    
            int max = searchMe.length() -
                      substring.length();
    
        test:
            for (int i = 0; i <= max; i++) {
                int n = substring.length();
                int j = i;
                int k = 0;
                while (n-- != 0) {
                    if (searchMe.charAt(j++) != substring.charAt(k++)) {
                        continue test;
                    }
                }
                foundIt = true;
                    break test;
            }
            System.out.println(foundIt ? "Found it" : "Didn't find it");
        }
    }
    

copia

Ecco l'output di questo programma.

    Found it
    

copia

 

La dichiarazione di ritorno
---------------------------

The next branching statements is the `return` statement. The `return` statement exits from the current method, and control flow returns to where the method was invoked. The `return` statement has two forms: one that returns a value, and one that does not. To return a value, simply put the value (or an expression that calculates the value) after the `return` keyword.

    return ++count;
    

Copy

The data type of the returned value must match the type of the method's declared `return` value. When a method is declared `void`, use the form of `return` that doesn't return a value.

    return;
    

Copy

The Classes and Objects section will cover everything you need to know about writing methods.

 

The Yield Statement
-------------------

L'ultima istruzione di ramificazione è l' `yield`istruzione. L' `yield`istruzione esce dall'espressione corrente `switch`in cui si trova. `yield`Un'istruzione è sempre seguita da un'espressione che deve produrre un valore. Questa espressione non deve essere `void`. Il valore di questa espressione è il valore prodotto dall'espressione che la racchiude `switch`.

Ecco un esempio di `yield`affermazione.

    class Test {
        enum Day {
            MONDAY, TUESDAY, WEDNESDAY, THURSDAY, FRIDAY, SATURDAY, SUNDAY
        }
    
        public String calculate(Day d) {
            return switch (d) {
                case SATURDAY, SUNDAY -> "week-end";
                    default -> {
                        int remainingWorkDays = 5 - d.ordinal();
                        yield remainingWorkDays;
                    }
                };
        }
    }
    

copia

