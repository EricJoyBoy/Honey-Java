package controlFlowStatements;

class BreakDemo {
    public static void main(String[] args) {

        int[] arrayOfInts = 
           
            { 32, 87, 3, 589,
              12, 1076, 2000,
              8, 622, 127 };  // dichiaro un array di interi
        int searchfor = 12; // definisco una variabile per la ricerca

        int i; // definisco una variabile per l'iterazione
        boolean foundIt = false; // definisco una variabile per il flag di trovato

        for (i = 0; i < arrayOfInts.length; i++) { // per ogni elemento dell'array
            if (arrayOfInts[i] == searchfor) { // se l'elemento corrisponde
                foundIt = true; // imposto il flag a true
                break; // esco dal ciclo
            }
        }

        if (foundIt) { // se il flag è true
            System.out.println("Found " + searchfor + " at index " + i); // stampo il risultato
        } else {
            System.out.println(searchfor + " not in the array"); // stampo il risultato
        }
    }
}
