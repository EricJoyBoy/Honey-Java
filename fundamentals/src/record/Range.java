package record;

public record Range(int start, int end) { // definisco una classe record con due campi

    public Range { // definisco un costruttore
        if (end <= start) { // se la fine è minore o uguale alla partenza
            throw new IllegalArgumentException("End cannot be lesser than start"); // lancio un'eccezione
        }
    }
}
