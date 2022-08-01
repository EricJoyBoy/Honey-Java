

Eredità
=======

 

Eredità
-------

Nelle sezioni precedenti, hai visto l'eredità menzionata più volte. Nel linguaggio Java, le classi possono essere derivate da altre classi, ereditando così campi e metodi da quelle classi.

> Definizioni: una classe derivata da un'altra classe è chiamata sottoclasse (anche classe derivata, classe estesa o classe figlia). La classe da cui deriva la sottoclasse è chiamata superclasse (anche classe base o classe genitore).
> 
> Ad eccezione [`Object`](https://docs.oracle.com/en/java/javase/18/docs/api/java.base/java/lang/Object.html)di , che non ha superclassi, ogni classe ha una e una sola superclasse diretta (ereditarietà singola). In assenza di qualsiasi altra superclasse esplicita, ogni classe è implicitamente una sottoclasse di [`Object`](https://docs.oracle.com/en/java/javase/18/docs/api/java.base/java/lang/Object.html).
> 
> Le classi possono essere derivate da classi derivate da classi derivate da classi e così via, e infine derivate dalla classe più in alto, [`Object`](https://docs.oracle.com/en/java/javase/18/docs/api/java.base/java/lang/Object.html). Si dice che una tale classe discende da tutte le classi nella catena ereditaria che risale a [`Object`](https://docs.oracle.com/en/java/javase/18/docs/api/java.base/java/lang/Object.html).

L'idea dell'ereditarietà è semplice ma potente: quando vuoi creare una nuova classe e c'è già una classe che include parte del codice che desideri, puoi derivare la tua nuova classe dalla classe esistente. In questo modo, puoi riutilizzare i campi e i metodi della classe esistente senza doverli scrivere (e eseguire il debug!) da solo.

Una sottoclasse eredita tutti i membri (campi, metodi e classi nidificate) dalla sua superclasse. I costruttori non sono membri, quindi non vengono ereditati dalle sottoclassi, ma il costruttore della superclasse può essere invocato dalla sottoclasse.

La [`Object`](https://docs.oracle.com/en/java/javase/18/docs/api/java.base/java/lang/Object.html)classe, definita nel [`java.lang`](https://docs.oracle.com/en/java/javase/18/docs/api/java.base/java/lang/package-summary.html)pacchetto, definisce e implementa il comportamento comune a tutte le classi, comprese quelle che scrivi. Nella piattaforma Java, molte classi derivano direttamente da [`Object`](https://docs.oracle.com/en/java/javase/18/docs/api/java.base/java/lang/Object.html), altre classi derivano da alcune di queste classi e così via, formando una gerarchia di classi.

In cima alla gerarchia [`Object`](https://docs.oracle.com/en/java/javase/18/docs/api/java.base/java/lang/Object.html)c'è la più generale di tutte le classi. Le classi in fondo alla gerarchia forniscono un comportamento più specializzato.

 

Un esempio di eredità
---------------------

Ecco il codice di esempio per una possibile implementazione di una `Bicycle`classe che è stata presentata nella sezione Classi e Oggetti:

    public class Bicycle {
            
        // the Bicycle class has three fields
        public int cadence;
        public int gear;
        public int speed;
            
        // the Bicycle class has one constructor
        public Bicycle(int startCadence, int startSpeed, int startGear) {
            gear = startGear;
            cadence = startCadence;
            speed = startSpeed;
        }
            
        // the Bicycle class has four methods
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
            
        // the MountainBike subclass adds one field
        public int seatHeight;
    
        // the MountainBike subclass has one constructor
        public MountainBike(int startHeight,
                            int startCadence,
                            int startSpeed,
                            int startGear) {
            super(startCadence, startSpeed, startGear);
            seatHeight = startHeight;
        }   
            
        // the MountainBike subclass adds one method
        public void setHeight(int newValue) {
            seatHeight = newValue;
        }   
    }
    

copia

`MountainBike`eredita tutti i campi e i metodi `Bicycle`e aggiunge il campo `seatHeight`e un metodo per impostarlo. Fatta eccezione per il costruttore, è come se avessi scritto una nuova `MountainBike`classe interamente da zero, con quattro campi e cinque metodi. Tuttavia, non dovevi fare tutto il lavoro. Ciò sarebbe particolarmente utile se i metodi nella `Bicycle`classe fossero complessi e avessero richiesto molto tempo per il debug.

 

Cosa puoi fare in una sottoclasse
---------------------------------

Una sottoclasse eredita tutti i membri `public`e `protected`del suo genitore, indipendentemente dal pacchetto in cui si trova la sottoclasse. Se la sottoclasse si trova nello stesso pacchetto del suo genitore, eredita anche i membri privati ​​del pacchetto del genitore. Puoi utilizzare i membri ereditati così come sono, sostituirli, nasconderli o integrarli con nuovi membri:

*   I campi ereditati possono essere utilizzati direttamente, proprio come qualsiasi altro campo.
*   Puoi dichiarare un campo nella sottoclasse con lo stesso nome di quello nella superclasse, nascondendolo così (sconsigliato).
*   Puoi dichiarare nuovi campi nella sottoclasse che non sono nella superclasse.
*   I metodi ereditati possono essere utilizzati direttamente così come sono.
*   Puoi scrivere un nuovo metodo di istanza nella sottoclasse che abbia la stessa firma di quello nella superclasse, sovrascrivendolo così.
*   Puoi scrivere un nuovo metodo statico nella sottoclasse che abbia la stessa firma di quello nella superclasse, nascondendolo così.
*   Puoi dichiarare nuovi metodi nella sottoclasse che non sono nella superclasse.
*   È possibile scrivere un costruttore di sottoclassi che richiami il costruttore della superclasse, in modo implicito o utilizzando la parola chiave super.
*   Le sezioni seguenti di questa lezione si amplieranno su questi argomenti.

 

Membri privati ​​in una Superclasse
-----------------------------------

Una sottoclasse non eredita i membri privati ​​della sua classe padre. Tuttavia, se la superclasse ha metodi pubblici o protetti per accedere ai suoi campi privati, questi possono essere utilizzati anche dalla sottoclasse.

Una classe nidificata ha accesso a tutti i membri privati ​​della sua classe che la racchiude, sia campi che metodi. Pertanto, una classe nidificata pubblica o protetta ereditata da una sottoclasse ha accesso indiretto a tutti i membri privati ​​della superclasse.

 

Casting di oggetti
------------------

Abbiamo visto che un oggetto è del tipo di dati della classe da cui è stato istanziato. Ad esempio, se scriviamo

    public MountainBike myBike = new MountainBike();
    

copia

allora `myBike`è di tipo `MountainBike`.

`MountainBike`discende da `Bicycle`e [`Object`](https://docs.oracle.com/en/java/javase/18/docs/api/java.base/java/lang/Object.html). Pertanto, a `MountainBike`è a `Bicycle`ed è anche an [`Object`](https://docs.oracle.com/en/java/javase/18/docs/api/java.base/java/lang/Object.html), e può essere utilizzato ovunque `Bicycle`o [`Object`](https://docs.oracle.com/en/java/javase/18/docs/api/java.base/java/lang/Object.html)siano richiesti oggetti.

Non è necessariamente vero il contrario: a `Bicycle`può essere a `MountainBike`, ma non lo è necessariamente. Allo stesso modo, an [`Object`](https://docs.oracle.com/en/java/javase/18/docs/api/java.base/java/lang/Object.html)può essere a `Bicycle`o a `MountainBike`, ma non lo è necessariamente.

Il cast mostra l'uso di un oggetto di un tipo al posto di un altro tipo, tra gli oggetti consentiti dall'ereditarietà e dalle implementazioni. Ad esempio, se scriviamo

    Object obj = new MountainBike();
    

copia

quindi `obj`è sia an [`Object`](https://docs.oracle.com/en/java/javase/18/docs/api/java.base/java/lang/Object.html)che a `MountainBike`(fino al momento in cui `obj`viene assegnato un altro oggetto che non è a `MountainBike`). Questo è chiamato _casting implicito_ .

Se invece scriviamo

    MountainBike myBike = obj;
    

copia

otterremmo un errore in fase di compilazione perché `obj`non è noto al compilatore essere un file `MountainBike`. Tuttavia, possiamo dire al compilatore che promettiamo di assegnare `MountainBike`a `obj`tramite casting esplicito:

    MountainBike myBike = (MountainBike)obj;
    

copia

Questo cast inserisce un controllo di runtime a cui obj è assegnato in `MountainBike`modo che il compilatore possa presumere in sicurezza che `obj`sia un `MountainBike`. Se `obj`non è `MountainBike`a runtime, verrà generata un'eccezione.

> Nota: è possibile eseguire un test logico sul tipo di un particolare oggetto utilizzando l' `instanceof`operatore. Questo può salvarti da un errore di runtime dovuto a un cast improprio. Per esempio:

    if (obj instanceof MountainBike) {
        MountainBike myBike = (MountainBike)obj;
    }
    

copia

> Qui l' `instanceof`operatore verifica che `obj`si riferisca a a in `MountainBike`modo da poter eseguire il cast sapendo che non verrà generata alcuna eccezione di runtime.

 

Ereditarietà multipla di stato, implementazione e tipo
------------------------------------------------------

Una differenza significativa tra classi e interfacce è che le classi possono avere campi mentre le interfacce no. Inoltre, puoi creare un'istanza di una classe per creare un oggetto, cosa che non puoi fare con le interfacce. Come spiegato nella sezione Cos'è un oggetto?, un oggetto memorizza il suo stato in campi, che sono definiti nelle classi. Uno dei motivi per cui il linguaggio di programmazione Java non consente di estendere più di una classe è evitare i problemi dell'ereditarietà multipla dello stato, ovvero la capacità di ereditare campi da più classi. Si supponga, ad esempio, di poter definire una nuova classe che estende più classi. Quando crei un oggetto istanziando quella classe, quell'oggetto erediterà i campi da tutte le superclassi della classe. Cosa succede se metodi o costruttori di diverse superclassi istanziano lo stesso campo? Quale metodo o costruttore avrà la precedenza? Poiché le interfacce non contengono campi, non devi preoccuparti dei problemi che derivano dall'ereditarietà multipla dello stato.

_L'ereditarietà multipla dell'implementazione_ è la capacità di ereditare le definizioni dei metodi da più classi. I problemi sorgono con questo tipo di eredità multipla, come conflitti di nomi e ambiguità. Quando i compilatori di linguaggi di programmazione che supportano questo tipo di ereditarietà multipla incontrano superclassi che contengono metodi con lo stesso nome, a volte non riescono a determinare a quale membro o metodo accedere o richiamare. Inoltre, un programmatore può introdurre inconsapevolmente un conflitto di nomi aggiungendo un nuovo metodo a una superclasse. I metodi predefiniti introducono una forma di ereditarietà multipla dell'implementazione. Una classe può implementare più di un'interfaccia, che può contenere metodi predefiniti con lo stesso nome. Il compilatore Java fornisce alcune regole per determinare quale metodo predefinito utilizza una particolare classe.

Il linguaggio di programmazione Java supporta l'ereditarietà multipla di tipo, che è la capacità di una classe di implementare più di un'interfaccia. Un oggetto può avere più tipi: il tipo della propria classe ei tipi di tutte le interfacce che la classe implementa. Ciò significa che se una variabile viene dichiarata come il tipo di un'interfaccia, il suo valore può fare riferimento a qualsiasi oggetto istanziato da qualsiasi classe che implementa l'interfaccia. Questo è discusso nella sezione Utilizzo di un'interfaccia come tipo.

Come con l'ereditarietà multipla dell'implementazione, una classe può ereditare diverse implementazioni di un metodo definito (come `default`o `static`) nelle interfacce che estende. In questo caso, il compilatore o l'utente deve decidere quale utilizzare.


