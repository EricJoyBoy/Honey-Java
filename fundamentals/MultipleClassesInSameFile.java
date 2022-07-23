package fundamentals;


/**
 * MultipleClassesInSameFile
 */
 
public class MultipleClassesInSameFile {

    public static void main(String[] args) { 
 
        System.out.println(GenerateMessage.generateMessage());  
        System.out.println(AnotherMessage.generateAnotherMessage()); 
    }
}
 
class GenerateMessage {
    static String generateMessage() {
        return "Il mio messaggio di benvenuto";
    }
}
 
class AnotherMessage {
    static String generateAnotherMessage() {
        return "Il mio altro messaggio di benvenuto";
    }
}
