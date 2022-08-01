# Metodi Factory invece di costruttori

Il modo tradizionale in cui una classe consente a un client di ottenere un'istanza è fornire
un costruttore pubblico. C'è un'altra tecnica che dovrebbe far parte di ogni
toolkit del programmatore. Una classe può fornire un metodo factory statico pubblico, ovvero
semplicemente un metodo statico che restituisce un'istanza della classe. Ecco un semplice
esempio da Boolean (la classe primitiva in scatola per booleano). Questo metodo
traduce un valore primitivo booleano in un riferimento a un oggetto booleano:

```java

public static Boolean valueOf(boolean b) {
return b ? Boolean.TRUE : Boolean.FALSE;
}

```
Un vantaggio dei metodi di fabbrica statici è che, a differenza dei costruttori, essi
avere nomi. Se i parametri di un costruttore non, di per sé,
descrivere l'oggetto restituito, è una factory statica con un nome ben scelto
più facile da usare e il codice client risultante più facile da leggere. Ad esempio, il costruttore BigInteger(int, int, Random), che restituisce un BigInteger che è
probabilmente primo, sarebbe stato meglio espresso come metodo di fabbrica statico
denominato BigInteger.probablePrime. (Questo metodo è stato aggiunto in Java 4.)
Una classe può avere un solo costruttore con una determinata firma. È noto che i programmatori aggirano questa restrizione fornendo due costruttori
i cui elenchi di parametri differiscono solo nell'ordine dei tipi di parametri. Questo è un
pessima idea. L'utente di una tale API non sarà mai in grado di ricordare quale
costruttore è quale e finirà per chiamare quello sbagliato per errore. Le persone
la lettura del codice che utilizza questi costruttori non saprà cosa fa il codice
senza fare riferimento alla documentazione di classe.
Poiché hanno nomi, i metodi di fabbrica statici non condividono la restrizione
discusso nel paragrafo precedente. Nei casi in cui una classe sembra richiedere
più costruttori con la stessa firma, sostituire i costruttori con static
metodi di fabbrica e nomi scelti con cura per evidenziarne le differenze.
Un secondo vantaggio dei metodi di fabbrica statici è che, a differenza dei costruttori,
non sono tenuti a creare un nuovo oggetto ogni volta che vengono invocati. Questo
consente alle classi immutabili (elemento 17) di utilizzare istanze precostruite o di memorizzare nella cache
istanze mentre vengono costruite e distribuirle ripetutamente per evitare di creare
oggetti duplicati non necessari. Il metodo Boolean.valueOf(boolean) illustra questa tecnica: non crea mai un oggetto. Questa tecnica è simile al
Schema pesi mosca [Gamma95]. Può migliorare notevolmente le prestazioni se equivalente
gli oggetti sono richiesti spesso, soprattutto se sono costosi da creare.
La capacità dei metodi di fabbrica statici di restituire lo stesso oggetto da ripetuto
le invocazioni consentono alle classi di mantenere un controllo rigoroso su quali istanze esistono
in qualsiasi momento. Si dice che le classi che lo fanno siano controllate dall'istanza. Ce ne sono diversi
ragioni per scrivere classi controllate da istanza. Il controllo dell'istanza consente a una classe di garantire che sia singleton (elemento 3) o non istanziabile (elemento 4). Inoltre, consente un
classe di valore immutabile (elemento 17) per garantire che non ci siano due istanze uguali
esiste: a.equals(b) se e solo se a == b. Questa è la base del modello Flyweight
[Gamma95]. I tipi Enum (Articolo 34) forniscono questa garanzia.
Un terzo vantaggio dei metodi di fabbrica statici è che, a differenza dei costruttori,
possono restituire un oggetto di qualsiasi sottotipo del loro tipo restituito. Questo ti dà
grande flessibilità nella scelta della classe dell'oggetto restituito.
Un'applicazione di questa flessibilità è che un'API può restituire oggetti senza
rendere pubbliche le loro classi. Nascondere le classi di implementazione in questo modo porta a
un'API molto compatta. Questa tecnica si presta a framework basati su interfaccia
(Elemento 20), dove le interfacce forniscono tipi di ritorno naturali per metodi di fabbrica statici.

Prima di Java 8, le interfacce non potevano avere metodi statici. Per convenzione, statico
i metodi factory per un'interfaccia denominata Type sono stati inseriti in una classe complementare non istanziabile (elemento 4) denominata Types. Ad esempio, il Java Collections Framework
ha quarantacinque implementazioni di utilità delle sue interfacce, fornendo non modificabili
raccolte, raccolte sincronizzate e simili. Quasi tutte queste implementazioni vengono esportate tramite metodi di fabbrica statici in una classe non istanziabile
(Java.util.Collezioni). Le classi degli oggetti restituiti sono tutte non pubbliche.
L'API Collections Framework è molto più piccola di quanto sarebbe stata
ha esportato quarantacinque classi pubbliche separate, una per ogni implementazione di convenienza. Non è solo la maggior parte dell'API a essere ridotta, ma anche il peso concettuale:
il numero e la difficoltà dei concetti che i programmatori devono padroneggiare in ordine
per utilizzare l'API. Il programmatore sa che l'oggetto restituito ha proprio il
API specificata dalla sua interfaccia, quindi non è necessario leggere la documentazione di classe aggiuntiva per la classe di implementazione. Inoltre, utilizzando una fabbrica così statica
il metodo richiede che il client faccia riferimento all'oggetto restituito tramite l'interfaccia anziché
classe di implementazione, che è generalmente una buona pratica (elemento 64).
A partire da Java 8, la restrizione che le interfacce non possono contenere metodi statici era
eliminata, quindi in genere ci sono poche ragioni per fornire una classe complementare non istanziabile per un'interfaccia. Molti membri statici pubblici che sarebbero stati a
home in una classe del genere dovrebbe invece essere inserito nell'interfaccia stessa. Nota, tuttavia,
che potrebbe essere ancora necessario eliminare la maggior parte del codice di implementazione
questi metodi statici in una classe privata del pacchetto separata. Questo perché Java 8
richiede che tutti i membri statici di un'interfaccia siano pubblici. Java 9 consente statico privato
metodi, ma i campi statici e le classi membro statiche devono ancora essere pubblici.
Un quarto vantaggio delle fabbriche statiche è che la classe dei restituiti
oggetto può variare da chiamata a chiamata in funzione dei parametri di input. È consentito qualsiasi sottotipo del tipo di reso dichiarato. La classe dell'oggetto restituito può
variano anche da rilascio a rilascio.
La classe EnumSet (elemento 36) non ha costruttori pubblici, solo factory statiche.
Nell'implementazione di OpenJDK, restituiscono un'istanza di una delle due sottoclassi,
a seconda della dimensione del tipo enum sottostante: se ha sessantaquattro o meno
elementi, come la maggior parte dei tipi enum, le factory statiche restituiscono un RegularEnumSet
istanza, che è supportata da un singolo long; se il tipo enum ha sessantacinque o più
elementi, le factory restituiscono un'istanza JumboEnumSet, supportata da un array lungo.
L'esistenza di queste due classi di implementazione è invisibile ai client. Se
RegularEnumSet ha cessato di offrire vantaggi in termini di prestazioni per i tipi di enum di piccole dimensioni
potrebbe essere eliminato da una versione futura senza effetti negativi. Allo stesso modo, un futuro
la versione potrebbe aggiungere una terza o quarta implementazione di EnumSet se si rivelasse utile
per le prestazioni. I clienti non conoscono né si preoccupano della classe dell'oggetto che ottengono
ritorno dalla fabbrica; a loro importa solo che sia una sottoclasse di EnumSet.
Un quinto vantaggio delle factory statiche è che la classe dell'oggetto restituito
non deve esistere quando viene scritta la classe contenente il metodo. Così flessibile
i metodi di fabbrica statici costituiscono la base dei framework dei fornitori di servizi, come Java
API di connettività del database (JDBC). Un framework di provider di servizi è un sistema in
quali fornitori implementano un servizio e il sistema effettua le implementazioni
disponibile per i client, disaccoppiando i client dalle implementazioni.
Ci sono tre componenti essenziali in un framework di fornitori di servizi: a
interfaccia di servizio, che rappresenta un'implementazione; una registrazione del fornitore
API, che i provider utilizzano per registrare le implementazioni; e un'API di accesso al servizio,
che i client utilizzano per ottenere le istanze del servizio. L'API di accesso al servizio può
consentire ai clienti di specificare i criteri per la scelta di un'implementazione. In assenza di
tali criteri, l'API restituisce un'istanza di un'implementazione predefinita o consente
il client per scorrere tutte le implementazioni disponibili. L'API di accesso al servizio
è la fabbrica statica flessibile che costituisce la base del framework del fornitore di servizi.
Un quarto componente facoltativo di un framework di provider di servizi è un servizio
interfaccia del provider, che descrive un oggetto factory che produce istanze di
interfaccia di servizio. In assenza di un'interfaccia del fornitore di servizi, implementazioni
deve essere istanziato in modo riflessivo (elemento 65). Nel caso di JDBC, Connection
svolge la parte dell'interfaccia del servizio, DriverManager.registerDriver è il
API di registrazione del provider, DriverManager.getConnection è l'accesso al servizio
API e Driver è l'interfaccia del provider di servizi.
Esistono molte varianti del modello di struttura del provider di servizi. Ad esempio, l'API di accesso al servizio può restituire ai client un'interfaccia di servizio più completa rispetto a
uno fornito dai fornitori. Questo è il modello Bridge [Gamma95]. Dipendenza
i framework di injection (Elemento 5) possono essere visti come potenti fornitori di servizi. Da
Java 6, la piattaforma include un framework per provider di servizi generici,
java.util.ServiceLoader, quindi non è necessario, e generalmente non dovresti, scrivere il tuo
proprio (punto 59). JDBC non utilizza ServiceLoader, poiché il primo precede il secondo.
Il limite principale nel fornire solo metodi di fabbrica statici è quello
le classi senza costruttori pubblici o protetti non possono essere sottoclassi. Per
ad esempio, è impossibile sottoclassare qualsiasi implementazione di convenienza
classi nel Framework delle raccolte. Probabilmente questa può essere una benedizione sotto mentite spoglie
perché incoraggia i programmatori a usare la composizione invece dell'ereditarietà
(Articolo 18) ed è richiesto per i tipi immutabili (Articolo 17).
Un secondo difetto dei metodi di fabbrica statici è che sono difficili da trovare
programmatori da trovare. Non si distinguono nella documentazione API nel modo che fanno i costruttori, quindi può essere difficile capire come istanziare una classe
che fornisce metodi di fabbrica statici anziché costruttori. Lo strumento Javadoc potrebbe
un giorno attirerà l'attenzione sui metodi di fabbrica statici. Nel frattempo, puoi
ridurre questo problema attirando l'attenzione sulle factory statiche nella classe o nell'interfaccia
documentazione e aderendo alle convenzioni di denominazione comuni. Eccotene alcune
nomi comuni per metodi di fabbrica statici. Questo elenco è tutt'altro che esaustivo:
• from: metodo di conversione del tipo che accetta un singolo parametro e restituisce a
corrispondente istanza di questo tipo, ad esempio:
Data d = Data.from(istantaneo);
• of: un metodo di aggregazione che accetta più parametri e restituisce un'istanza di questo tipo che li incorpora, ad esempio:
Set<Rank> faceCards = EnumSet.of(JACK, QUEEN, KING);

• valueOf: un'alternativa più dettagliata a from e of, ad esempio:
BigInteger primo = BigInteger.valueOf(Integer.MAX_VALUE);
• instance o getInstance: restituisce un'istanza che è descritta dai relativi parametri (se presenti) ma non si può dire che abbia lo stesso valore, ad esempio:
StackWalker luke = StackWalker.getInstance(opzioni);

• create o newInstance: simile a instance o getInstance, tranne per il
il metodo garantisce che ogni chiamata restituisca una nuova istanza, ad esempio:
Oggetto newArray = Array.newInstance(classObject, arrayLen);

• getType: simile a getInstance, ma utilizzato se il metodo factory è in un altro
classe. Tipo è il tipo di oggetto restituito dal metodo factory, ad esempio:
FileStore fs = Files.getFileStore(percorso);

• newType: come newInstance, ma utilizzato se il metodo factory è in un altro
classe. Tipo è il tipo di oggetto restituito dal metodo factory, ad esempio:
BufferedReader br = Files.newBufferedReader(percorso);

• type: un'alternativa concisa a getType e newType, ad esempio:
List<Reclamo> litania = Collections.list(legacyLitany);

In sintesi, i metodi di fabbrica statici e i costruttori pubblici hanno entrambi i loro
utilizza, e conviene comprenderne i relativi meriti. Spesso le fabbriche statiche lo sono
preferibile, quindi evita il riflesso di fornire costruttori pubblici senza prima considerare le fabbriche statiche.
