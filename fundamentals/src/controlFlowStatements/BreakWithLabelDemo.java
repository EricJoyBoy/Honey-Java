package controlFlowStatements;

class BreakWithLabelDemo {
    public static void main(String[] args) {

        int[][] arrayOfInts = { // un array di interi
            {  32,   87,    3, 589 },
            {  12, 1076, 2000,   8 },
            { 622,  127,   77, 955 }
        };
        int searchfor = 12; // definisco una variabile per la ricerca

        int i; // definisco una variabile per l'iterazione
        int j = 0; // definisco una variabile per l'iterazione
        boolean foundIt = false; // definisco una variabile per il flag di trovato

    search: // definisco una label per il ciclo
        for (i = 0; i < arrayOfInts.length; i++) { // per ogni elemento dell'array
            for (j = 0; j < arrayOfInts[i].length; 
                 j++) {// per ogni elemento dell'array
                if (arrayOfInts[i][j] == searchfor) {
                    foundIt = true; // imposto il flag a true
                    break search; // esco dal ciclo
                }
            }
        }

        if (foundIt) { // se il flag è true
            System.out.println("Found " + searchfor + " at " + i + ", " + j); // stampo il risultato
        } else {
            System.out.println(searchfor + " not in the array"); // stampo il risultato
        }
    }
}
