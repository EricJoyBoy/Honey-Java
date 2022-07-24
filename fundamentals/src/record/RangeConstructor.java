package record;

public record RangeConstructor(int start, int end) { // definisco una classe record con due campi

    public RangeConstructor(int start, int end) { // definisco un costruttore
        if (end <= start) {
            throw new IllegalArgumentException("End cannot be lesser than start"); // lancio un'eccezione
        }
        if (start < 0) { // se la partenza è minore di 0
            this.start = 0; // imposto la partenza a 0
        } else { // altrimenti
            this.start = start; // imposto la partenza
        } // imposto la partenza
        if (end > 100) { // se la fine è maggiore di 100
            this.end = 10; // imposto la fine a 10
        } else { // altrimenti
            this.end = end; // imposto la fine
        }
    }
}
