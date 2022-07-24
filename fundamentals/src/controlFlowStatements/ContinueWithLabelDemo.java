package controlFlowStatements;

class ContinueWithLabelDemo {
    public static void main(String[] args) {

        String searchMe = "Look for a substring in me"; // definisco una variabile per la ricerca
        String substring = "sub"; // definisco una variabile per la sottostringa da cercare
        boolean foundIt = false; // definisco una variabile per il flag di trovato

        int max = searchMe.length() -
                  substring.length(); // definisco una variabile per la lunghezza della stringa

    test:
        for (int i = 0; i <= max; i++) { // per ogni carattere della stringa
            int n = substring.length(); // definisco una variabile per la lunghezza della sottostringa
            int j = i; // definisco una variabile per l'iterazione
            int k = 0; // definisco una variabile per l'iterazione
            while (n-- != 0) { // per ogni carattere della sottostringa
                if (searchMe.charAt(j++) != substring.charAt(k++)) { // se il carattere non è uguale all'elemento della sottostringa
                    continue test; // esco dal ciclo
                }
            }
            foundIt = true; // imposto il flag a true
                break test; // esco dal ciclo
        }
        System.out.println(foundIt ? "Found it" : "Didn't find it"); // stampo il risultato
    }
}
