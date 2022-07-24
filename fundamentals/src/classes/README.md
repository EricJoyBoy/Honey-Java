

Creare classi
=============

 

Classi dichiaranti
------------------

L'introduzione ai concetti orientati agli oggetti nella sezione intitolata [Oggetto, classi e interfacce ha](/oop/) utilizzato una `Bicycle` classe come esempio, con bici da corsa, mountain bike e bici in tandem come sottoclassi. Ecco un codice di esempio per una possibile implementazione di una `Bicycle`classe, per darti una panoramica di una dichiarazione di classe. Le sezioni successive eseguiranno il backup e spiegheranno passo dopo passo le dichiarazioni di classe. Per il momento, non preoccuparti dei dettagli.

    public class Bicycle {
            
        // the Bicycle class has
        // three fields
        public int cadence;
        public int gear;
        public int speed;
            
        // the Bicycle class has
        // one constructor
        public Bicycle(int startCadence, int startSpeed, int startGear) {
            gear = startGear;
            cadence = startCadence;
            speed = startSpeed;
        }
            
        // the Bicycle class has
        // four methods
        public void setCadence(int newValue) {
            cadence = newValue;
        }
            
        public void setGear(int newValue) {
            gear = newValue;
        }
            
        public void applyBrake(int decrement) {
            speed -= decrement;
        }
            
        public void speedUp(int increment) {
            speed += increment;
        }
    }
    

copia

Una dichiarazione di classe per una `MountainBike`classe che è una sottoclasse di `Bicycle`potrebbe assomigliare a questa:

    public class MountainBike extends Bicycle {
            
        // the MountainBike subclass has
        // one field
        public int seatHeight;
    
        // the MountainBike subclass has
        // one constructor
        public MountainBike(int startHeight, int startCadence,
                            int startSpeed, int startGear) {
            super(startCadence, startSpeed, startGear);
            seatHeight = startHeight;
        }   
            
        // the MountainBike subclass has
        // one method
        public void setHeight(int newValue) {
            seatHeight = newValue;
        }   
    }
    

copia

`MountainBike`eredita tutti i campi e i metodi `Bicycle`e aggiunge il campo `seatHeight`e un metodo per impostarlo (le mountain bike hanno i sedili che possono essere spostati su e giù come richiesto dal terreno).

Hai visto classi definite nel modo seguente:

    class MyClass {
        // field, constructor, and 
        // method declarations
    }
    

copia

Questa è una dichiarazione di classe. Il corpo della classe (l'area tra le parentesi graffe) contiene tutto il codice che prevede il ciclo di vita degli oggetti creati dalla classe: costruttori per inizializzare nuovi oggetti, dichiarazioni per i campi che forniscono lo stato della classe e dei suoi oggetti, e metodi per implementare il comportamento della classe e dei suoi oggetti.

La precedente dichiarazione di classe è minima. Contiene solo quei componenti di una dichiarazione di classe che sono richiesti. Puoi fornire maggiori informazioni sulla classe, come il nome della sua superclasse, se implementa interfacce e così via, all'inizio della dichiarazione di classe. Per esempio,

    class MyClass extends MySuperClass implements YourInterface {
        // field, constructor, and
        // method declarations
    }
    

copia

significa che `MyClass`è una sottoclasse di `MySuperClass`e che implementa l' `YourInterface`interfaccia.

Puoi anche aggiungere modificatori come `public`o `private`proprio all'inizio, così puoi vedere che la riga di apertura di una dichiarazione di classe può diventare piuttosto complicata. I modificatori `public`e `private`, che determinano a cosa possono accedere altre classi `MyClass`, sono discussi più avanti in questa sezione. La sezione sulle interfacce e sull'ereditarietà spiegherà come e perché dovresti usare le parole chiave `extends`e `implements`in una dichiarazione di classe. Per il momento non devi preoccuparti di queste complicazioni extra.

In generale, le dichiarazioni di classe possono includere questi componenti, nell'ordine:

1.  Modificatori come `public`, `private`, e molti altri che incontrerai in seguito. (Tuttavia, tieni presente che il `private`modificatore può essere applicato solo alle classi nidificate.)
2.  Il nome della classe, con la lettera iniziale maiuscola per convenzione.
3.  Il nome del genitore della classe (superclasse), se presente, preceduto dalla parola chiave `extends`. Una classe può estendere (sottoclasse) solo un genitore.
4.  Un elenco separato da virgole di interfacce implementate dalla classe, se presente, preceduto dalla parola chiave `implements`. Una classe può implementare più di un'interfaccia.
5.  Il corpo della classe, circondato da parentesi graffe, `{}`.

 

Dichiarazione delle variabili membro
------------------------------------

Esistono diversi tipi di variabili:

*   Variabili membro in una classe: queste sono chiamate campi.
*   Variabili in un metodo o blocco di codice: queste sono chiamate variabili locali.
*   Variabili nelle dichiarazioni di metodo: queste sono chiamate parametri.
*   La `Bicycle`classe utilizza le seguenti righe di codice per definire i propri campi:

    public int cadence;
    public int gear;
    public int speed;
    

copia

Le dichiarazioni di campo sono composte da tre componenti, nell'ordine:

1.  Zero o più modificatori, come `public`o `private`.
2.  Il tipo del campo.
3.  Il nome del campo.

I campi di `Bicycle`sono denominati `cadence`, `gear`, e `speed`e sono tutti di tipo dati intero ( `int`). La `public`parola chiave identifica questi campi come membri pubblici, accessibili da qualsiasi oggetto che può accedere alla classe.

 

Controllare chi ha accesso a un membro
--------------------------------------

Il primo modificatore (più a sinistra) utilizzato consente di controllare quali altre classi hanno accesso a un campo membro. Per il momento, considera solo `public`e `private`. Altri modificatori di accesso verranno discussi in seguito.

*   `public`modificatore: il campo è accessibile da tutte le classi.
*   `private`modificatore: il campo è accessibile solo all'interno della propria classe.

Nello spirito dell'incapsulamento, è comune rendere privati ​​i campi. Ciò significa che è possibile accedervi direttamente solo dalla `Bicycle`classe. Tuttavia, abbiamo ancora bisogno di accedere a questi valori. Questo può essere fatto indirettamente aggiungendo metodi pubblici che ottengono i valori di campo per noi:

    public class Bicycle {
            
        private int cadence;
        private int gear;
        private int speed;
            
        public Bicycle(int startCadence, int startSpeed, int startGear) {
            gear = startGear;
            cadence = startCadence;
            speed = startSpeed;
        }
            
        public int getCadence() {
            return cadence;
        }
            
        public void setCadence(int newValue) {
            cadence = newValue;
        }
            
        public int getGear() {
            return gear;
        }
            
        public void setGear(int newValue) {
            gear = newValue;
        }
            
        public int getSpeed() {
            return speed;
        }
            
        public void applyBrake(int decrement) {
            speed -= decrement;
        }
            
        public void speedUp(int increment) {
            speed += increment;
        }
    }
    

copia

 

Impostazione del tipo di una variabile
--------------------------------------

Tutte le variabili devono avere un tipo. Puoi usare tipi primitivi come `int`, `float`, `boolean`, ecc. Oppure puoi usare tipi di riferimento, come stringhe, array o oggetti.

 

Denominazione di una variabile
------------------------------

Tutte le variabili, siano esse campi, variabili locali o parametri, seguono le stesse regole e convenzioni di denominazione trattate nella sezione Nozioni di base sul linguaggio, [Denominazione delle variabili](/learn/creating-variables-and-naming-them/) .

In questa sezione, tieni presente che le stesse regole e convenzioni di denominazione vengono utilizzate per i nomi dei metodi e delle classi, tranne quello

*   la prima lettera del nome di una classe dovrebbe essere in maiuscolo, e
*   la prima (o l'unica) parola nel nome di un metodo dovrebbe essere un verbo.

