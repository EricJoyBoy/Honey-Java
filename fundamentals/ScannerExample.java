package fundamentals;

import java.util.Scanner;  // Importa la classe Scanner
import java.util.regex.MatchResult; // Importa la classe MatchResult
/**
 * ScannerExample
 */
 
public class ScannerExample {

    public static void main(String... args) {
        String wordsAndNumbers = """
                Longing rusted furnace
                daybreak 17 benign 
                9 homecoming 1 
                freight car
                """;

        try (Scanner scanner = new Scanner(wordsAndNumbers)) { // Crea un nuovo scanner
            scanner.findAll("benign").map(MatchResult::group).forEach(System.out::println); // 
        }
    }
}


/**
 * La parola chiave ::,
introdotta con Java 8, consente di scrivere codice più compatto per l'invocazione
di un metodo o costruttore di una classe. Le sintassi generali di utilizzo del simbolo ::
sono le seguenti:

NomeClasse::nomeMetodo
oggetto::nomeMetodo
NomeClasse::new
 * 
 */
