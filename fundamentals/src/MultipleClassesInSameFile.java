public class MultipleClassesInSameFile {
    public static void main(String[] args) {
 
        System.out.println(GenerateMessage.generateMessage());  
        System.out.println(AnotherMessage.generateAnotherMessage());
    }
}
 
class GenerateMessage { // class in the same file
    static String generateMessage() {
        return "Il mio messaggio";
    }
}
 
class AnotherMessage { // class in the same file
    static String generateAnotherMessage() {
        return "Il mio altro messaggio";
    }
}
