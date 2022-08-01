public class ValueOfDemo {
    public static void main(String[] args) {

        // this program requires two 
        // arguments on the command line 
        if (args.length == 2) { // Se numero argomenti = 2
            // convert strings to numbers
            float a = (Float.valueOf(args[0])).floatValue(); // Conversione stringa a numero float
            float b = (Float.valueOf(args[1])).floatValue(); // Conversione stringa b numero float

            // do some arithmetic
            System.out.println("a + b = " +
                               (a + b)); // Stampa a + b
            System.out.println("a - b = " +
                               (a - b)); // Stampa a - b
            System.out.println("a * b = " +
                               (a * b)); // Stampa a * b
            System.out.println("a / b = " +
                               (a / b)); // Stampa a / b
            System.out.println("a % b = " +
                               (a % b)); //
        } else {
            System.out.println("This program " +
                "requires two command-line arguments."); // Stampa messaggio di errore
        }
    }
}
