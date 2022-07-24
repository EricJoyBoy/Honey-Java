package controlFlowStatements;

class ContinueDemo {
    public static void main(String[] args) { 

        String searchMe = "peter piper picked a " + "peck of pickled peppers"; // definisco una variabile per la ricerca
        int max = searchMe.length(); // definisco una variabile per la lunghezza della stringa
        int numPs = 0; // definisco una variabile per il contatore dei caratteri "p"

        for (int i = 0; i < max; i++) { // per ogni carattere della stringa
            // interested only in p's
            if (searchMe.charAt(i) != 'p') // se il carattere non è un p
                continue;

            // process p's
            numPs++;
        }
        System.out.println("Found " + numPs + " p's in the string.");
    }
}
