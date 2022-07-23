package controlFlowStatements;

class EnhancedForDemo {
    public static void main(String[] args){
         int[] numbers =
             {1, 2, 3, 4, 5, 6, 7, 8, 9, 10}; // dichiaro un array di interi
         for (int item : numbers) { // per ogni elemento dell'array
             System.out.println("Count is: " + item); // stampo il contatore
         }
    }
}
