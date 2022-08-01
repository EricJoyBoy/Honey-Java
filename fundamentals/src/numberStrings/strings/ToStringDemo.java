public class ToStringDemo {
    
    public static void main(String[] args) {
        double d = 858.48; // Numero double
        String s = Double.toString(d); // Conversione double a stringa
        
        int dot = s.indexOf('.'); // Indice della virgola
        
        System.out.println(dot + " digits " +
            "before decimal point."); //    
        System.out.println( (s.length() - dot - 1) +
            " digits after decimal point."); // Stampa numero cifre dopo la virgola
    }
}
