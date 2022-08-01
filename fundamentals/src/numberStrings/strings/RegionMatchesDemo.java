package numberStrings.strings;

public class RegionMatchesDemo {

    public static void main(String[] args) {

        String searchMe = "Green Eggs and Ham";// Stringa da cercare
        String findMe = "Eggs"; // Stringa da cercare
        int searchMeLength = searchMe.length(); // Lunghezza stringa da cercare
        int findMeLength = findMe.length(); // Lunghezza stringa da cercare
        boolean foundIt = false; // Variabile booleana per controllo
        for (int i = 0;  
             i <= (searchMeLength - findMeLength);
             i++) { // Ciclo for per lunghezza stringa da cercare
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
