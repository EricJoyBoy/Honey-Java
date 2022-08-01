

Autobox e Unboxing
==================

 

Autobox e Unboxing
------------------

_L'autoboxing_ è la conversione automatica che il compilatore Java effettua tra i tipi primitivi e le corrispondenti classi di wrapper di oggetti. Ad esempio, convertire an `int`in an [`Integer`](https://docs.oracle.com/en/java/javase/18/docs/api/java.base/java/lang/Integer.html), a `double`in a [`Double`](https://docs.oracle.com/en/java/javase/18/docs/api/java.base/java/lang/Double.html)e così via. Se la conversione va dall'altra parte, si parla di unboxing.

Ecco l'esempio più semplice di autoboxing:

    Character ch = 'a';
    



Il resto degli esempi in questa sezione usa i generici. Se non hai ancora familiarità con la sintassi dei generici, consulta la sezione Generics.

Considera il seguente codice:

    List<Integer> ints = new ArrayList<>();
    for (int i = 1; i < 50; i += 2)
        ints.add(i);
    



Sebbene tu aggiunga i `int`valori come tipi primitivi, anziché come [`Integer`](https://docs.oracle.com/en/java/javase/18/docs/api/java.base/java/lang/Integer.html)oggetti, a `ints`, il codice viene compilato. Poiché `ints`è un elenco di [`Integer`](https://docs.oracle.com/en/java/javase/18/docs/api/java.base/java/lang/Integer.html)oggetti, non un elenco di `int`valori, potresti chiederti perché il compilatore Java non emette un errore in fase di compilazione. Il compilatore non genera un errore perché crea un [`Integer`](https://docs.oracle.com/en/java/javase/18/docs/api/java.base/java/lang/Integer.html)oggetto da `i`e aggiunge l'oggetto a `ints`. Pertanto, il compilatore converte il codice precedente nel seguente in fase di esecuzione:

    List<Integer> ints = new ArrayList<>();
    for (int i = 1; i < 50; i += 2)
        ints.add(Integer.valueOf(i));
    



La conversione di un valore primitivo (an `int`, per esempio) in un oggetto della classe wrapper corrispondente ( [`Integer`](https://docs.oracle.com/en/java/javase/18/docs/api/java.base/java/lang/Integer.html)) è chiamata autoboxing. Il compilatore Java applica l'autoboxing quando un valore primitivo è:

*   Passato come parametro a un metodo che prevede un oggetto della classe wrapper corrispondente.
*   Assegnato a una variabile della classe wrapper corrispondente.

Considera il seguente metodo:

    public static int sumEven(List<Integer> ints) {
        int sum = 0;
        for (Integer i: ints) {
            if (i % 2 == 0) {
                sum+=i;
            }
        }
        return sum;
    }
    



Poiché gli operatori resto ( `%`) e unario più ( `+=`) non si applicano agli [`Integer`](https://docs.oracle.com/en/java/javase/18/docs/api/java.base/java/lang/Integer.html)oggetti, potresti chiederti perché il compilatore Java compila il metodo senza emettere errori. Il compilatore non genera un errore perché richiama il [`intValue()`](https://docs.oracle.com/en/java/javase/18/docs/api/java.base/java/lang/Integer.html#intValue())metodo per convertire an [`Integer`](https://docs.oracle.com/en/java/javase/18/docs/api/java.base/java/lang/Integer.html)in an `int`in fase di esecuzione:

    public static int sumEven(List<Integer> ints){
        int sum=0;
        for(Integer i:ints) {
            if(i.intValue()%2==0) {
                sum+=i.intValue();
            }
        }
        return sum;
    }
    



La conversione di un oggetto di un tipo wrapper ( [`Integer`](https://docs.oracle.com/en/java/javase/18/docs/api/java.base/java/lang/Integer.html)) nel valore corrispondente della primitiva ( `int`) è chiamata unboxing. Il compilatore Java applica l'unboxing quando un oggetto di una classe wrapper è:

*   Passato come parametro a un metodo che prevede un valore del tipo primitivo corrispondente.
*   Assegnato a una variabile del tipo primitivo corrispondente.

L' `Unboxing`esempio mostra come funziona:

    import java.util.ArrayList;
    import java.util.List;
    
    public class Unboxing {
    
        public static void main(String[] args) {
            Integer i = Integer.valueOf(-8);
    
            // 1. Unboxing through method invocation
            int absVal = absoluteValue(i);
            System.out.println("absolute value of " + i + " = " + absVal);
    
            List<Double> doubles = new ArrayList<>();
            doubles.add(3.1416);    // Π is autoboxed through method invocation.
    
            // 2. Unboxing through assignment
            double pi = doubles.get(0);
            System.out.println("pi = " + pi);
        }
    
        public static int absoluteValue(int i) {
            return (i < 0) ? -i : i;
        }
    }
    



Il programma stampa quanto segue:

    absolute value of -8 = 8
    pi = 3.1416
    



L'autoboxing e l'unboxing consentono agli sviluppatori di scrivere codice più pulito, facilitandone la lettura. La tabella seguente elenca i tipi primitivi e le relative classi wrapper, che vengono utilizzati dal compilatore Java per l'autoboxing e l'unboxing:

Tipo primitivo

Classe wrapper

booleano

booleano

byte

Byte

car

Carattere

galleggiante

Galleggiante

int

Numero intero

lungo

Lungo

breve

Breve

Doppio

Doppio


  

 
