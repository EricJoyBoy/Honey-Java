package numberStrings.strings;

public class StringDemo {
 
    public static void main(String[] args) {
        String palindrome = "Dot saw I was Tod"; // Stringa palindroma
        int len = palindrome.length(); // Lunghezza stringa
        char[] tempCharArray = new char[len]; // Array di caratteri
        char[] charArray = new char[len]; // Array di caratteri
        
        // put original string in an 
        // array of chars
        for (int i = 0; i < len; i++) { // Ciclo for per lunghezza stringa
            tempCharArray[i] =  
                palindrome.charAt(i); // Carattere all'indice i
        } 
        
        // reverse array of chars
        for (int j = 0; j < len; j++) { // Ciclo for per lunghezza stringa
            charArray[j] =
                tempCharArray[len - 1 - j]; // Carattere all'indice j
        }
        
        String reversePalindrome =
            new String(charArray); // Stringa palindroma invertita
        System.out.println(reversePalindrome); // Stampa stringa palindroma invertita
      
    }

}
