package record;

import java.util.List;

public record State(String name, String capitalCity, List<String> cities) { // definisco una classe record con tre campi

    public State { // definisco un costruttore
        // List.copyOf returns an unmodifiable copy,
        // so the list assigned to `cities` can't change anymore
        cities = List.copyOf(cities);
    }

    public State(String name, String capitalCity) { // definisco un costruttore
        this(name, capitalCity, List.of()); // invoco il costruttore con una lista vuota
    } // invoco il costruttore con una lista vuota

    public State(String name, String capitalCity, String... cities) {// definisco un costruttore
        this(name, capitalCity, List.of(cities));// invoco il costruttore con una lista di stringhe
    }

}
