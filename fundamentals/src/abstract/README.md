

Metodi e classi astratti
========================

 

Metodi e classi astratti
------------------------

Una classe astratta è una classe dichiarata `abstract`, può includere o meno metodi astratti. Le classi astratte non possono essere istanziate, ma possono essere sottoclassi.

Un metodo astratto è un metodo dichiarato senza un'implementazione (senza parentesi graffe e seguito da punto e virgola), in questo modo:

    abstract void moveTo(double deltaX, double deltaY);
    

copia

Se una classe include metodi astratti, allora la classe stessa deve essere dichiarata `abstract`, come in:

    public abstract class GraphicObject {
       // declare fields
       // declare nonabstract methods
       abstract void draw();
    }
    

copia

When an abstract class is subclassed, the subclass usually provides implementations for all of the abstract methods in its parent class. However, if it does not, then the subclass must also be declared `abstract`.

> Note: Methods in an interface (see the Interfaces section) that are not declared as default or static are implicitly abstract, so the abstract modifier is not used with interface methods. (It can be used, but it is unnecessary.)

 

Abstract Classes Compared to Interfaces
---------------------------------------

Le classi astratte sono simili alle interfacce. Non è possibile creare un'istanza e possono contenere un mix di metodi dichiarati con o senza un'implementazione. Tuttavia, con le classi astratte, puoi dichiarare campi che non sono statici e finali e definire metodi `public`, `protected`e concreti. `private`Con le interfacce, tutti i campi sono automaticamente `public`, `static`e `final`, e tutti i metodi dichiarati o definiti (come metodi predefiniti) sono `public`. Inoltre, puoi estendere solo una classe, astratta o meno, mentre puoi implementare un numero qualsiasi di interfacce.

Quale dovresti usare, classi o interfacce astratte?

*   Prendi in considerazione l'utilizzo di classi astratte se una di queste affermazioni si applica alla tua situazione:
    
    *   Vuoi condividere il codice tra diverse classi strettamente correlate.
    *   Ti aspetti che le classi che estendono la tua classe astratta abbiano molti metodi o campi comuni o richiedano modificatori di accesso diversi da public (come `protected`e `private`).
    *   Vuoi dichiarare campi non statici o non finali. Ciò consente di definire metodi che possono accedere e modificare lo stato dell'oggetto a cui appartengono.
*   Prendi in considerazione l'utilizzo di interfacce se una di queste affermazioni si applica alla tua situazione:
    
    *   Ti aspetti che le classi non correlate implementino la tua interfaccia. Ad esempio, le interfacce [`Comparable`](https://docs.oracle.com/en/java/javase/18/docs/api/java.base/java/lang/Comparable.html)e [`Cloneable`](https://docs.oracle.com/en/java/javase/18/docs/api/java.base/java/lang/Cloneable.html)sono implementate da molte classi non correlate.
    *   Vuoi specificare il comportamento di un particolare tipo di dati, ma non preoccuparti di chi ne implementa il comportamento.
    *   Vuoi sfruttare l'ereditarietà multipla del tipo.

Un esempio di classe astratta in JDK è [`AbstractMap`](https://docs.oracle.com/en/java/javase/18/docs/api/java.base/java/util/AbstractMap.html), che fa parte di Collections Framework. Le sue sottoclassi (che includono [`HashMap`](https://docs.oracle.com/en/java/javase/18/docs/api/java.base/java/util/HashMap.html), [`TreeMap`](https://docs.oracle.com/en/java/javase/18/docs/api/java.base/java/util/TreeMap.html)e [`ConcurrentHashMap`](https://docs.oracle.com/en/java/javase/18/docs/api/java.base/java/util/concurrent/ConcurrentHashMap.html)) condividono molti metodi (inclusi [`get()`](https://docs.oracle.com/en/java/javase/18/docs/api/java.base/java/util/AbstractMap.html#get(java.lang.Object)), [`put()`](https://docs.oracle.com/en/java/javase/18/docs/api/java.base/java/util/AbstractMap.html#put(K,V)), [`isEmpty()`](https://docs.oracle.com/en/java/javase/18/docs/api/java.base/java/util/AbstractMap.html#isEmpty()), [`containsKey()`](https://docs.oracle.com/en/java/javase/18/docs/api/java.base/java/util/AbstractMap.html#containsKey(java.lang.Object))e [`containsValue()`](https://docs.oracle.com/en/java/javase/18/docs/api/java.base/java/util/AbstractMap.html#containsValue(java.lang.Object))) che [`AbstractMap`](https://docs.oracle.com/en/java/javase/18/docs/api/java.base/java/util/AbstractMap.html)definiscono.

Un esempio di una classe nel JDK che implementa diverse interfacce è [`HashMap`](https://docs.oracle.com/en/java/javase/18/docs/api/java.base/java/util/HashMap.html), che implementa le interfacce [`Serializable`](https://docs.oracle.com/en/java/javase/18/docs/api/java.base/java/io/Serializable.html), [`Cloneable`](https://docs.oracle.com/en/java/javase/18/docs/api/java.base/java/lang/Cloneable.html)e [`Map<K, V>`](https://docs.oracle.com/en/java/javase/18/docs/api/java.base/java/util/Map.html). Leggendo questo elenco di interfacce, puoi dedurre che un'istanza di [`HashMap`](https://docs.oracle.com/en/java/javase/18/docs/api/java.base/java/util/HashMap.html)(indipendentemente dallo sviluppatore o dall'azienda che ha implementato la classe) può essere clonata, è serializzabile (il che significa che può essere convertita in un flusso di byte; vedere la sezione Oggetti serializzabili ), e ha la funzionalità di una mappa. Inoltre, l' [`Map<K, V>`](https://docs.oracle.com/en/java/javase/18/docs/api/java.base/java/util/Map.html)interfaccia è stata migliorata con molti metodi predefiniti come [`merge()`](https://docs.oracle.com/en/java/javase/18/docs/api/java.base/java/util/Map.html#merge(K,V,java.util.function.BiFunction))e [`forEach()`](https://docs.oracle.com/en/java/javase/18/docs/api/java.base/java/util/Map.html#forEach(java.util.function.BiConsumer))che le classi precedenti che hanno implementato questa interfaccia non devono definire.

Si noti che molte librerie software utilizzano sia classi astratte che interfacce; la [`HashMap`](https://docs.oracle.com/en/java/javase/18/docs/api/java.base/java/util/HashMap.html)classe implementa diverse interfacce ed estende anche la classe astratta [`AbstractMap`](https://docs.oracle.com/en/java/javase/18/docs/api/java.base/java/util/AbstractMap.html).

 

Un esempio di classe astratta
-----------------------------

In un'applicazione di disegno orientata agli oggetti, puoi disegnare cerchi, rettangoli, linee, curve di Bezier e molti altri oggetti grafici. Questi oggetti hanno tutti determinati stati (ad esempio: posizione, orientamento, colore della linea, colore di riempimento) e comportamenti (ad esempio: sposta in, ruota, ridimensiona, disegna) in comune. Alcuni di questi stati e comportamenti sono gli stessi per tutti gli oggetti grafici (ad esempio: posizione, colore di riempimento e sposta a). Altri richiedono implementazioni diverse (ad esempio, ridimensionare o disegnare).

Tutti gli oggetti grafici devono essere in grado di disegnare o ridimensionare se stessi; differiscono solo nel modo in cui lo fanno. Questa è una situazione perfetta per una superclasse astratta. Puoi sfruttare le somiglianze e dichiarare che tutti gli oggetti grafici ereditino dallo stesso oggetto genitore astratto, ad esempio `GraphicObject`.

Innanzitutto, dichiari una classe astratta, `GraphicObject`, per fornire variabili membro e metodi che sono interamente condivisi da tutte le sottoclassi, come la posizione corrente e il `moveTo()`metodo. `GraphicObject`dichiara anche metodi astratti per metodi, come `draw()`o `resize()`, che devono essere implementati da tutte le sottoclassi ma devono essere implementati in modi diversi. La `GraphicObject`classe può assomigliare a questo:

    abstract class GraphicObject {
        int x, y;
        ...
        void moveTo(int newX, int newY) {
            ...
        }
        abstract void draw();
        abstract void resize();
    }
    

copia

Ogni sottoclasse non astratta di `GraphicObject`, come `Circle`e `Rectangle`, deve fornire implementazioni per i metodi `draw()`e :`resize()`

    class Circle extends GraphicObject {
        void draw() {
            ...
        }
        void resize() {
            ...
        }
    }
    class Rectangle extends GraphicObject {
        void draw() {
            ...
        }
        void resize() {
            ...
        }
    }
    

copia

 

Quando una classe astratta implementa un'interfaccia
----------------------------------------------------

Nella sezione sulle Interfacce, è stato notato che una classe che implementa un'interfaccia deve implementare tutti i metodi dell'interfaccia. È possibile, tuttavia, definire una classe che non implementi tutti i metodi dell'interfaccia, a condizione che la classe sia dichiarata `abstract`. Per esempio,

    abstract class X implements Y {
      // implements all but one method of Y
    }
    
    class XX extends X {
      // implements the remaining method in Y
    }
    

copia

In questo caso, la classe `X`deve essere astratta perché non implementa completamente `Y`, ma la classe `XX`, in effetti, implementa `Y`.

 

Membri di classe
----------------

Una classe astratta può avere `static`campi e `static`metodi. Puoi utilizzare questi `static`membri con un riferimento di classe (ad esempio, `AbstractClass.staticMethod()`) come faresti con qualsiasi altra classe.

