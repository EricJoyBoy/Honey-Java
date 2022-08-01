

Interfacce
==========

 

Interfacce in Java
------------------

Ci sono un certo numero di situazioni nell'ingegneria del software in cui è importante che gruppi disparati di programmatori accettino un "contratto" che spieghi come interagisce il loro software. Ogni gruppo dovrebbe essere in grado di scrivere il proprio codice senza alcuna conoscenza di come viene scritto il codice dell'altro gruppo. In generale, _le interfacce_ sono tali contratti.

Ad esempio, immagina una società futuristica in cui auto robotiche controllate da computer trasportano passeggeri per le strade della città senza un operatore umano. Le case automobilistiche scrivono software (Java, ovviamente) che aziona l'automobile: fermati, avvia, accelera, gira a sinistra e così via. Un altro gruppo industriale, produttori di strumenti di guida elettronica, realizza sistemi informatici che ricevono dati di posizione GPS (Global Positioning System) e trasmissione wireless delle condizioni del traffico e utilizzano tali informazioni per guidare l'auto.

Le case automobilistiche devono pubblicare un'interfaccia standard del settore che spieghi in dettaglio quali metodi possono essere invocati per far muovere l'auto (qualsiasi auto, di qualsiasi produttore). I produttori di guida possono quindi scrivere un software che richiami i metodi descritti nell'interfaccia per comandare l'auto. Nessuno dei due gruppi industriali deve sapere come viene implementato il software dell'altro gruppo. Ciascun gruppo, infatti, considera il proprio software altamente proprietario e si riserva il diritto di modificarlo in qualsiasi momento, purché continui ad aderire all'interfaccia pubblicata.

Nel linguaggio di programmazione Java, _un'interfaccia_ è un tipo di riferimento, simile a una classe, che può contenere _solo_ costanti, firme di metodo, metodi predefiniti, metodi statici e tipi nidificati. I corpi dei metodi esistono solo per i metodi predefiniti e per i metodi statici. Le interfacce non possono essere istanziate: possono essere implementate solo da classi o estese da altre interfacce. L'estensione è discussa più avanti in questa sezione.

La definizione di un'interfaccia è simile alla creazione di una nuova classe:

    public interface OperateCar {
    
       // constant declarations, if any
    
       // method signatures
       
       // An enum with values RIGHT, LEFT
       int turn(Direction direction,
                double radius,
                double startSpeed,
                double endSpeed);
       int changeLanes(Direction direction,
                       double startSpeed,
                       double endSpeed);
       int signalTurn(Direction direction,
                      boolean signalOn);
       int getRadarFront(double distanceToCar,
                         double speedOfCar);
       int getRadarRear(double distanceToCar,
                        double speedOfCar);
             ......
       // more method signatures
    }
    

copia

Si noti che le firme del metodo non hanno parentesi graffe e terminano con un punto e virgola.

Per utilizzare un'interfaccia, scrivi una classe che implementa l'interfaccia. Quando una classe istanziabile implementa un'interfaccia, fornisce un corpo del metodo per ciascuno dei metodi dichiarati nell'interfaccia. Per esempio,

    public class OperateBMW760i implements OperateCar {
    
        // the OperateCar method signatures, with implementation --
        // for example:
        public int signalTurn(Direction direction, boolean signalOn) {
           // code to turn BMW's LEFT turn indicator lights on
           // code to turn BMW's LEFT turn indicator lights off
           // code to turn BMW's RIGHT turn indicator lights on
           // code to turn BMW's RIGHT turn indicator lights off
        }
    
        // other members, as needed -- for example, helper classes not 
        // visible to clients of the interface
    }
    

copia

Nell'esempio dell'auto robotica sopra, sono le case automobilistiche che implementeranno l'interfaccia. L'implementazione di Chevrolet sarà sostanzialmente diversa da quella di Toyota, ovviamente, ma entrambi i produttori aderiranno alla stessa interfaccia. I produttori di guide, che sono i clienti dell'interfaccia, costruiranno sistemi che utilizzano i dati GPS sulla posizione di un'auto, mappe stradali digitali e dati sul traffico per guidare l'auto. In tal modo, i sistemi di guida invocheranno i metodi di interfaccia: svoltare, cambiare corsia, frenare, accelerare e così via.

 

Interfacce come API
-------------------

L'esempio dell'auto robotica mostra un'interfaccia utilizzata come _interfaccia di programmazione delle applicazioni standard del settore_(API). Le API sono comuni anche nei prodotti software commerciali. In genere, un'azienda vende un pacchetto software che contiene metodi complessi che un'altra azienda desidera utilizzare nel proprio prodotto software. Un esempio potrebbe essere un pacchetto di metodi di elaborazione delle immagini digitali che vengono venduti alle aziende che producono programmi di grafica per utenti finali. La società di elaborazione delle immagini scrive le sue classi per implementare un'interfaccia, che rende pubblica ai propri clienti. L'azienda grafica richiama quindi i metodi di elaborazione delle immagini utilizzando le firme ei tipi restituiti definiti nell'interfaccia. Sebbene l'API dell'azienda di elaborazione delle immagini sia resa pubblica (ai suoi clienti), la sua implementazione dell'API è tenuta segreta e gelosamente custodita, in effetti,

 

Definizione di un'interfaccia
-----------------------------

Una dichiarazione di interfaccia è composta da modificatori, la parola chiave `interface`, il nome dell'interfaccia, un elenco separato da virgole di interfacce padre (se presenti) e il corpo dell'interfaccia. Per esempio:

    public interface GroupedInterface extends Interface1, Interface2, Interface3 {
    
        // constant declarations
        
        // base of natural logarithms
        double E = 2.718282;
     
        // method signatures
        void doSomething (int i, double x);
        int doSomethingElse(String s);
    }
    

copia

L' `public`identificatore di accesso indica che l'interfaccia può essere utilizzata da qualsiasi classe in qualsiasi pacchetto. Se non specifichi che l'interfaccia è pubblica, la tua interfaccia è accessibile solo alle classi definite nello stesso pacchetto dell'interfaccia.

Un'interfaccia può estendere altre interfacce, proprio come una sottoclasse di classe o estendere un'altra classe. Tuttavia, mentre una classe può estendere solo un'altra classe, un'interfaccia può estendere un numero qualsiasi di interfacce. La dichiarazione dell'interfaccia include un elenco separato da virgole di tutte le interfacce che estende.

Il corpo dell'interfaccia può contenere metodi astratti, metodi predefiniti e metodi statici.

Un metodo astratto all'interno di un'interfaccia è seguito da un punto e virgola, ma senza parentesi graffe (un metodo astratto non contiene un'implementazione).

I metodi predefiniti sono definiti con il `default`modificatore e i metodi statici con la `static`parola chiave. Tutti i metodi astratti, predefiniti e statici in un'interfaccia sono implicitamente pubblici, quindi puoi omettere il `public`modificatore.

Inoltre, un'interfaccia può contenere dichiarazioni di costanti. Tutti i valori costanti definiti in un'interfaccia sono implicitamente `public`, `static`e `final`. Ancora una volta, puoi omettere questi modificatori.



