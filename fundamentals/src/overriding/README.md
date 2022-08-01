

Sovrascrivere e nascondere i metodi
===================================

 

Metodi di istanza
-----------------

Un metodo di istanza in una sottoclasse con la stessa firma (nome, più il numero e il tipo dei suoi parametri) e tipo restituito come metodo di istanza nella superclasse sovrascrive il metodo della superclasse.

La capacità di una sottoclasse di sovrascrivere un metodo consente a una classe di ereditare da una superclasse il cui comportamento è "abbastanza vicino" e quindi di modificare il comportamento secondo necessità. Il metodo che esegue l'override ha lo stesso nome, numero e tipo di parametri e lo stesso tipo restituito del metodo di cui esegue l'override. Un metodo di override può anche restituire un sottotipo del tipo restituito dal metodo sottoposto a override. Questo sottotipo è chiamato tipo restituito covariante.

Quando si esegue l'override di un metodo, è possibile utilizzare l' [`@Override`](https://docs.oracle.com/en/java/javase/18/docs/api/java.base/java/lang/Override.html)annotazione che indica al compilatore che si intende eseguire l'override di un metodo nella superclasse. Se, per qualche motivo, il compilatore rileva che il metodo non esiste in una delle superclassi, genererà un errore. Per ulteriori informazioni su [`@Override`](https://docs.oracle.com/en/java/javase/18/docs/api/java.base/java/lang/Override.html), vedere la sezione Annotazioni.

 

Metodi statici
--------------

Se una sottoclasse definisce un metodo statico con la stessa firma di un metodo statico nella superclasse, il metodo nella sottoclasse nasconde quello nella superclasse.

La distinzione tra nascondere un metodo statico e sovrascrivere un metodo di istanza ha importanti implicazioni:

*   La versione del metodo di istanza sovrascritto che viene richiamato è quella nella sottoclasse.
    
*   La versione del metodo statico nascosto che viene invocato dipende dal fatto che venga invocato dalla superclasse o dalla sottoclasse.
    
*   Considera un esempio che contiene due classi. Il primo è `Animal`, che contiene un metodo di istanza e un metodo statico:
    

    public class Animal {
        public static void testClassMethod() {
            System.out.println("The static method in Animal");
        }
        public void testInstanceMethod() {
            System.out.println("The instance method in Animal");
        }
    }
    

copia

La seconda classe, una sottoclasse di `Animal`, si chiama `Cat`:

    public class Cat extends Animal {
        public static void testClassMethod() {
            System.out.println("The static method in Cat");
        }
        public void testInstanceMethod() {
            System.out.println("The instance method in Cat");
        }
    
        public static void main(String[] args) {
            Cat myCat = new Cat();
            Animal myAnimal = myCat;
            Animal.testClassMethod();
            myAnimal.testInstanceMethod();
        }
    }
    

copia

La `Cat`classe esegue l'override del metodo di istanza in `Animal`e nasconde il metodo statico in `Animal`. Il metodo main in questa classe crea un'istanza `Cat`e la richiama `testClassMethod`sulla classe e `testInstanceMethod`sull'istanza.

L'output di questo programma è il seguente:

    The static method in Animal
    The instance method in Cat
    

copia

Come promesso, la versione del metodo statico nascosto che viene invocato è quella nella superclasse e la versione del metodo dell'istanza sovrascritta che viene invocata è quella nella sottoclasse.

 

Metodi di interfaccia
---------------------

I metodi predefiniti e i metodi astratti nelle interfacce vengono ereditati come i metodi di istanza. Tuttavia, quando i supertipi di una classe o di un'interfaccia forniscono più metodi predefiniti con la stessa firma, il compilatore Java segue le regole di ereditarietà per risolvere il conflitto di nomi. Queste regole sono guidate dai seguenti due principi.

*   I metodi di istanza sono preferiti rispetto ai metodi predefiniti dell'interfaccia.

Considera le seguenti classi e interfacce:

    public class Horse {
        public String identifyMyself() {
            return "I am a horse.";
        }
    }
    
    public interface Flyer {
        default public String identifyMyself() {
            return "I am able to fly.";
        }
    }
    
    public interface Mythical {
        default public String identifyMyself() {
            return "I am a mythical creature.";
        }
    }
    
    public class Pegasus extends Horse implements Flyer, Mythical {
        public static void main(String... args) {
            Pegasus myApp = new Pegasus();
            System.out.println(myApp.identifyMyself());
        }
    }
    

copia

Il metodo `Pegasus.identifyMyself()`restituisce la stringa `I am a horse`.

*   I metodi che sono già stati ignorati da altri candidati vengono ignorati. Questa circostanza può verificarsi quando i supertipi condividono un antenato comune.

Considera le seguenti interfacce e classi:

    public interface Animal {
        default public String identifyMyself() {
            return "I am an animal.";
        }
    }
    
    public interface EggLayer extends Animal {
        default public String identifyMyself() {
            return "I am able to lay eggs.";
        }
    }
    
    public interface FireBreather extends Animal { }
    
    public class Dragon implements EggLayer, FireBreather {
        public static void main (String... args) {
            Dragon myApp = new Dragon();
            System.out.println(myApp.identifyMyself());
        }
    }
    

copia

Il metodo `Dragon.identifyMyself()`restituisce la stringa `I am able to lay eggs`.

Se due o più metodi predefiniti definiti in modo indipendente sono in conflitto o un metodo predefinito è in conflitto con un metodo astratto, il compilatore Java genera un errore del compilatore. È necessario sovrascrivere in modo esplicito i metodi del supertipo.

Considera l'esempio delle auto controllate da computer che ora possono volare. Hai due interfacce ( `OperateCar`e `FlyCar`) che forniscono implementazioni predefinite per lo stesso metodo, ( `startEngine()`):

    public interface OperateCar {
        // ...
        default public int startEngine(EncryptedKey key) {
            // Implementation
        }
    }
    
    public interface FlyCar {
        // ...
        default public int startEngine(EncryptedKey key) {
            // Implementation
        }
    }
    

copia

Una classe che implementa entrambi `OperateCar`e `FlyCar`deve eseguire l'override del metodo `startEngine()`. Puoi invocare una qualsiasi delle implementazioni predefinite con la `super`parola chiave.

    public class FlyingCar implements OperateCar, FlyCar {
        // ...
        public int startEngine(EncryptedKey key) {
            FlyCar.super.startEngine(key);
            OperateCar.super.startEngine(key);
        }
    }
    

copia

Il nome precedente `super`(in questo esempio, `FlyCar`o `OperateCar`) deve fare riferimento a una superinterfaccia diretta che definisce o eredita un'impostazione predefinita per il metodo richiamato. Questa forma di chiamata al metodo non si limita alla differenziazione tra più interfacce implementate che contengono metodi predefiniti con la stessa firma. È possibile utilizzare la `super`parola chiave per richiamare un metodo predefinito sia nelle classi che nelle interfacce.

I metodi di istanza ereditati dalle classi possono sovrascrivere i metodi di interfaccia astratti. Considera le seguenti interfacce e classi:

    public interface Mammal {
        String identifyMyself();
    }
    
    public class Horse {
        public String identifyMyself() {
            return "I am a horse.";
        }
    }
    
    public class Mustang extends Horse implements Mammal {
        public static void main(String... args) {
            Mustang myApp = new Mustang();
            System.out.println(myApp.identifyMyself());
        }
    }
    

copia

Il metodo `Mustang.identifyMyself()`restituisce la stringa `I am a horse`. La classe `Mustang`eredita il metodo `identifyMyself()`dalla classe `Horse`, che sovrascrive il metodo astratto con lo stesso nome nell'interfaccia `Mammal`.

> Nota: i metodi statici nelle interfacce non vengono mai ereditati.

 

Modificatori
------------

L'identificatore di accesso per un metodo sovrascritto può consentire più, ma non meno, accessi rispetto al metodo sovrascritto. Ad esempio, un `protected`metodo di istanza nella superclasse può essere creato `public`, ma non `private`, nella sottoclasse.

Otterrai un errore in fase di compilazione se tenti di modificare un metodo di istanza nella superclasse in un metodo statico nella sottoclasse e viceversa.

 

Riepilogo
---------

La tabella seguente riassume cosa succede quando si definisce un metodo con la stessa firma di un metodo in una superclasse.

Metodo di istanza di superclasse

Metodo statico delle superclassi

Metodo di istanza della sottoclasse

Sostituzioni

Genera un errore in fase di compilazione

Metodo statico della sottoclasse

Genera un errore in fase di compilazione

Nasconde

> Nota: in una sottoclasse, puoi sovraccaricare i metodi ereditati dalla superclasse. Tali metodi sovraccaricati non nascondono né sovrascrivono i metodi di istanza della superclasse: sono metodi nuovi, unici per la sottoclasse.



