

Jshell - Lo strumento Java Shell
================================

Puoi utilizzare la shell del linguaggio per apprendere il linguaggio Java, esplorare nuove funzionalità e API e creare prototipi di nuovo codice.

 

Presentazione di jshell
-----------------------

[jshell](https://docs.oracle.com/en/java/javase/16/docs/specs/man/jshell.html) : valuta in modo interattivo dichiarazioni, istruzioni ed espressioni del linguaggio di programmazione Java in un ciclo read-eval-print (REPL)

 

Sinossi
-------

    jshell [options] [load-files]
    

copia

`options` Opzioni della riga di comando, separate da spazi. Vedi Opzioni per `jshell`.

`load-files` Uno o più script da eseguire all'avvio dello strumento. Gli script possono contenere qualsiasi frammento di codice o `jshell`comando valido.

Lo script può essere un file locale o uno dei seguenti script predefiniti:

`DEFAULT` Carica le voci predefinite, comunemente utilizzate come importazioni.

`JAVASE` Importa tutti i pacchetti Java SE.

`PRINTING` Definisce print, println e printf come `jshell`metodi da utilizzare all'interno dello strumento.

Per più di uno script, utilizzare uno spazio per separare i nomi. Gli script vengono eseguiti nell'ordine in cui sono stati immessi nella riga di comando. Gli script della riga di comando vengono eseguiti dopo gli script di avvio. Per eseguire uno script dopo l'avvio di jshell, utilizzare il comando /open.

Per accettare l'input dall'input standard e sopprimere l'I/O interattivo, immettere un trattino (-) per caricare i file. Questa opzione abilita l'uso dello `jshell`strumento nelle catene di tubi.

 

Descrizione
-----------

`jshell`fornisce un modo per valutare in modo interattivo dichiarazioni, istruzioni ed espressioni del linguaggio di programmazione Java, semplificando l'apprendimento del linguaggio, l'esplorazione di codice e API sconosciuti e la creazione di prototipi di codice complesso. Sono accettate istruzioni Java, definizioni di variabili, definizioni di metodi, definizioni di classi, istruzioni di importazione ed espressioni. I bit di codice inseriti sono chiamati snippet.

Man mano che gli snippet vengono inseriti, vengono valutati e viene fornito un feedback. Il feedback varia dai risultati e dalle spiegazioni delle azioni a zero, a seconda dello snippet inserito e della modalità di feedback scelta. Gli errori sono descritti indipendentemente dalla modalità di feedback. Inizia con la modalità dettagliata per ottenere il maggior numero di feedback durante l'apprendimento dello strumento.

Le opzioni della riga di comando sono disponibili per la configurazione dell'ambiente iniziale all'avvio `jshell`. All'interno `jshell`di , sono disponibili comandi per modificare l'ambiente in base alle esigenze.

I frammenti esistenti possono essere caricati da un file per inizializzare una `jshell`sessione o in qualsiasi momento all'interno di una sessione. Gli snippet possono essere modificati all'interno della sessione per provare diverse varianti e apportare correzioni. Per conservare i frammenti per un uso successivo, salvali in un file.

 

Opzioni
-------

`--add-exports module/package` Specifica un pacchetto da considerare come esportato dal relativo modulo di definizione.

`--add-modules module[,module...]` Specifica i moduli radice da risolvere oltre al modulo iniziale.

`-Cflag` Fornisce un flag da passare al compilatore. Per passare più di un flag, fornisci un'istanza di questa opzione per ogni flag o argomento flag necessario.

`--class-path path` Specifica le directory e gli archivi in ​​cui viene eseguita la ricerca per individuare i file di classe. Questa opzione sovrascrive il percorso nella variabile di ambiente CLASSPATH. Se la variabile di ambiente non è impostata e questa opzione non è utilizzata, la ricerca viene eseguita nella directory corrente.

*   **Linux e macOS** , usa i due punti ( `:`) per separare gli elementi nel percorso.
*   **Windows** , usa un punto e virgola ( `;`) per separare gli elementi.

`--enable-preview` Consente al codice di dipendere dalle funzionalità di anteprima di questa versione.

`--execution specification` Specifica un motore di esecuzione alternativo, dove la specifica è una specifica ExecutionControl. Vedere la documentazione del pacchetto jdk.jshell.spi per la sintassi delle specifiche.

`--feedback mode` Imposta il livello iniziale di feedback fornito in risposta a quanto inserito. Il livello iniziale può essere ignorato all'interno di una sessione utilizzando il comando /set feedback mode. L'impostazione predefinita è normale.

I seguenti valori sono validi per la modalità:

`verbose` Fornisce un feedback dettagliato per le voci. Ulteriori informazioni sull'azione eseguita vengono visualizzate dopo il risultato dell'azione. Il prompt successivo è separato dal feedback da una riga vuota.

`normal` Fornisce una quantità media di feedback. Il prompt successivo è separato dal feedback da una riga vuota.

`concise` Fornisce un feedback minimo. Il prompt successivo segue immediatamente lo snippet di codice o il feedback.

`silent` Non fornisce feedback. Il prompt successivo segue immediatamente il frammento di codice.

`custom` Fornisce un feedback personalizzato in base a come viene definita la modalità. Le modalità di feedback personalizzate vengono create all'interno di JShell utilizzando il comando /set mode.

`--help`oppure `-h`oppure `-?` Stampa un riepilogo delle opzioni standard ed esce dallo strumento.

`--help-extra`oppure `-X` Stampa un riepilogo delle opzioni non standard ed esce dallo strumento. Le opzioni non standard sono soggette a modifiche senza preavviso.

`-Jflag` Fornisce un flag da passare al sistema di runtime. Per passare più di un flag, fornisci un'istanza di questa opzione per ogni flag o argomento flag necessario.

`--module-path modulepath` Specifica dove trovare i moduli dell'applicazione.

*   Per **Linux e macOS** , usa i due punti ( `:`) per separare gli elementi nel percorso.
*   Per **Windows** , utilizzare un punto e virgola ( `;`) per separare gli elementi.

`--no-startup` Impedisce l'esecuzione degli script di avvio all'avvio `jshell`. Utilizzare questa opzione per eseguire solo gli script immessi nella riga comandi all'avvio di JShell o per avviare JShell senza alcuna informazione precaricata se non vengono immessi script. Questa opzione non può essere utilizzata se `--startup`viene utilizzata l'opzione.

`-q` Imposta la modalità feedback su concise, che è la stessa di inserire --feedback concise.

`-Rflag` Fornisce un flag da passare al sistema di runtime remoto. Per passare più di un flag, fornisci un'istanza di questa opzione per ogni flag o argomento flag da passare.

`-s` Imposta la modalità feedback su silenzioso, che equivale a inserire --feedback silenzioso.

`--show-version` Stampa le informazioni sulla versione ed entra nello strumento.

`--startup file` Sostituisce lo script di avvio predefinito per questa sessione. Lo script può contenere qualsiasi frammento di codice o comando valido.

Lo script può essere un file locale o uno dei seguenti script predefiniti:

`DEFAULT` Carica le voci predefinite, comunemente utilizzate come importazioni.

`JAVASE` Importa tutti i pacchetti Java SE.

`PRINTING` Definisce print, println e printf come `jshell`metodi da utilizzare all'interno dello strumento.

Per più di uno script, fornire un'istanza separata di questa opzione per ogni script. Gli script di avvio vengono eseguiti al `jshell`primo avvio e al riavvio della sessione con il comando `/reset`, `/reload`o . `/env`Gli script di avvio vengono eseguiti nell'ordine in cui sono stati immessi nella riga di comando.

Questa opzione non può essere utilizzata se `--no-startup`viene utilizzata l'opzione.

`-v` Imposta la modalità feedback su verbose, che equivale a inserire --feedback verbose.

`--version` Stampa le informazioni sulla versione ed esce dallo strumento.

 

Comandi
-------

All'interno dello `jshell`strumento, i comandi vengono utilizzati per modificare l'ambiente e gestire frammenti di codice.

`/drop {name|id|startID-endID} [{name|id|startID-endID}...]` Elimina gli snippet identificati da nome, ID o intervallo di ID, rendendoli inattivi. Per un intervallo di ID, fornire l'ID iniziale e l'ID finale separati da un trattino. Per fornire un elenco, separa gli elementi nell'elenco con uno spazio. Utilizzare il `/list`comando per visualizzare gli ID dei frammenti di codice.

`/edit [option]` Apre un editor. Se non viene inserita alcuna opzione, l'editor si apre con gli snippet attivi.

Sono valide le seguenti opzioni:

`{name|id|startID-endID} [{name|id|startID-endID}...]` Apre l'editor con gli snippet identificati da nome, ID o intervallo di ID. Per un intervallo di ID, fornire l'ID iniziale e l'ID finale separati da un trattino. Per fornire un elenco, separa gli elementi nell'elenco con uno spazio. Utilizzare il `/list`comando per visualizzare gli ID dei frammenti di codice.

`-all` Apre l'editor con tutti gli snippet, inclusi gli snippet di avvio e gli snippet non riusciti, sovrascritti o eliminati.

`-start` Apre l'editor con i frammenti di avvio che sono stati valutati all'avvio di JShell. Per uscire dalla modalità di modifica, chiudere la finestra dell'editor o rispondere alla richiesta fornita se l' `-wait`opzione è stata utilizzata quando è stato impostato l'editor.

Utilizzare il `/set`comando editor per specificare l'editor da utilizzare. Se non è impostato alcun editor, le seguenti variabili di ambiente vengono controllate nell'ordine: `JSHELLEDITOR`, `VISUAL`, e `EDITOR`. Se non è impostato alcun editor in JShell e nessuna delle variabili di ambiente dell'editor è impostata, viene utilizzato un semplice editor predefinito.

`/env [options]` Visualizza le impostazioni dell'ambiente o aggiorna le impostazioni dell'ambiente e riavvia la sessione. Se non viene inserita alcuna opzione, vengono visualizzate le impostazioni dell'ambiente correnti. Se vengono immesse una o più opzioni, la sessione viene riavviata come segue:

*   Aggiorna le impostazioni dell'ambiente con le opzioni fornite:
*   Reimposta lo stato di esecuzione.
*   Esegue gli script di avvio.
*   Riproduce silenziosamente la cronologia nell'ordine inserito. La cronologia include tutti i frammenti o `/drop`i comandi validi immessi al `jshell`prompt, negli script immessi nella riga di comando o negli script immessi con il `/open`comando.

Le impostazioni dell'ambiente immesse nella riga di comando o fornite con un comando , o precedente `/reset`vengono `/env`mantenute `/reload`a meno che non venga immessa un'opzione che sovrascrive l'impostazione.

Sono valide le seguenti opzioni:

`--add-modules module[,module...]` Specifica i moduli radice da risolvere oltre al modulo iniziale.

`--add-exports source-module/package=target-module[,target-module]*` Aggiunge un'esportazione del pacchetto dal modulo di origine al modulo di destinazione.

`--class-path path` Specifica le directory e gli archivi in ​​cui viene eseguita la ricerca per individuare i file di classe. Questa opzione sovrascrive il percorso nella variabile di ambiente CLASSPATH. Se la variabile di ambiente non è impostata e questa opzione non è utilizzata, la ricerca viene eseguita nella directory corrente.

*   Per **Linux e macOS** , usa i due punti ( `:`) per separare gli elementi nel percorso.
*   Per **Windows** , utilizzare un punto e virgola ( `;`) per separare gli elementi.

`--module-path modulepath` Specifica dove trovare i moduli dell'applicazione.

*   Per **Linux e macOS** , usa i due punti ( `:`) per separare gli elementi nel percorso.
*   Per **Windows** , utilizzare un punto e virgola ( `;`) per separare gli elementi.

`/exit [integer-expression-snippet]` Esce dallo strumento. Se non viene immesso alcuno snippet, lo stato di uscita è zero. Se viene immesso uno snippet e il risultato dello snippet è un numero intero, il risultato viene utilizzato come stato di uscita. Se si verifica un errore o il risultato dello snippet non è un numero intero, viene visualizzato un errore e lo strumento rimane attivo.

`/history` Visualizza ciò che è stato inserito in questa sessione.

`/help [command|subject]` Visualizza informazioni su comandi e argomenti. Se non vengono immesse opzioni, viene visualizzato un riepilogo delle informazioni per tutti i comandi e un elenco di argomenti disponibili. Se viene fornito un comando valido, vengono visualizzate le informazioni espanse per quel comando. Se viene inserito un oggetto valido, vengono visualizzate le informazioni su quell'oggetto.

Sono validi i seguenti valori per soggetto:

`context` Descrive le opzioni disponibili per la configurazione dell'ambiente.

`intro` Fornisce un'introduzione allo strumento.

`shortcuts` Descrive le sequenze di tasti per il completamento di comandi e frammenti. Vedere Collegamenti di input.

`/imports` Visualizza le importazioni attive correnti, comprese quelle dagli script di avvio e dagli script immessi nella riga di comando all'avvio `jshell`.

`/list [option]` Visualizza un elenco di frammenti e i relativi ID. Se non viene inserita alcuna opzione, vengono visualizzati tutti gli snippet attivi, ma non gli snippet di avvio.

Sono valide le seguenti opzioni:

`{name|id|startID-endID} [{name|id|startID-endID}...]` Visualizza gli snippet identificati per nome, ID o intervallo di ID. Per un intervallo di ID, fornire l'ID iniziale e l'ID finale separati da un trattino. Per fornire un elenco, separa gli elementi nell'elenco con uno spazio.

`-all` Visualizza tutti gli snippet, inclusi gli snippet di avvio e gli snippet non riusciti, sovrascritti o eliminati. Gli ID che iniziano con s sono frammenti di avvio. Gli ID che iniziano con e sono frammenti di codice non riusciti.

`-start` Visualizza i frammenti di avvio che sono stati valutati all'avvio di JShell.

`/methods [option]` Visualizza le informazioni sui metodi inseriti. Se non viene immessa alcuna opzione, vengono visualizzati il ​​nome, i tipi di parametro e il tipo restituito di tutti i metodi attivi.

Sono valide le seguenti opzioni:

`{name|id|startID-endID} [{name|id|startID-endID}...]` Visualizza le informazioni per i metodi identificati da nome, ID o intervallo di ID. Per un intervallo di ID, fornire l'ID iniziale e l'ID finale separati da un trattino. Per fornire un elenco, separa gli elementi nell'elenco con uno spazio. Utilizzare il comando /list per visualizzare gli ID dei frammenti di codice.

`-all` Visualizza le informazioni per tutti i metodi, inclusi quelli aggiunti all'avvio di JShell e i metodi non riusciti, sovrascritti o eliminati.

`-start` Visualizza le informazioni sui metodi di avvio che sono stati aggiunti all'avvio di JShell.

`/open file` Apre lo script specificato e legge i frammenti nello strumento. Lo script può essere un file locale o uno dei seguenti script predefiniti:

`DEFAULT` Carica le voci predefinite, comunemente utilizzate come importazioni.

`JAVASE` Importa tutti i pacchetti Java SE.

`PRINTING` Definisce print, println e printf come metodi jshell da utilizzare all'interno dello strumento.

`/reload [options]` Riavvia la sessione come segue:

*   Aggiorna le impostazioni dell'ambiente con le opzioni fornite, se presenti.
*   Reimposta lo stato di esecuzione.
*   Esegue gli script di avvio.
*   Riproduce la cronologia nell'ordine immesso. La cronologia include tutti gli snippet oi `/drop`comandi validi immessi al `jshell`prompt, negli script immessi nella riga di comando o gli script immessi con il comando /open.

Le impostazioni dell'ambiente immesse nella riga di comando o fornite con un comando , o precedente `/reset`vengono `/env`mantenute `/reload`a meno che non venga immessa un'opzione che sovrascrive l'impostazione.

Sono valide le seguenti opzioni:

`--add-modules module[,module...]` Specifica i moduli radice da risolvere oltre al modulo iniziale.

`--add-exports source-module/package=target-module[,target-module]*` Aggiunge un'esportazione del pacchetto dal modulo di origine al modulo di destinazione.

`--class-path path` Specifica le directory e gli archivi in ​​cui viene eseguita la ricerca per individuare i file di classe. Questa opzione sovrascrive il percorso nella variabile di ambiente CLASSPATH. Se la variabile di ambiente non è impostata e questa opzione non è utilizzata, la ricerca viene eseguita nella directory corrente. Per Linux e macOS, usa i due punti (:) per separare gli elementi nel percorso. Per Windows, usa un punto e virgola (;) per separare gli elementi.

`--module-path modulepath` Specifica dove trovare i moduli dell'applicazione. Per Linux e macOS, usa i due punti (:) per separare gli elementi nel percorso. Per Windows, usa un punto e virgola (;) per separare gli elementi.

`-quiet` Riproduce la cronologia valida senza visualizzarla. Gli errori vengono visualizzati.

`-restore` Reimposta l'ambiente allo stato all'inizio dell'esecuzione precedente dello strumento o all'ultima esecuzione di un comando /reset, /reload o /env nell'esecuzione precedente. La cronologia valida da quel momento viene riprodotta. Utilizzare questa opzione per ripristinare una sessione JShell precedente.

`/reset [options]` Elimina tutti gli snippet inseriti e riavvia la sessione come segue:

*   Aggiorna le impostazioni dell'ambiente con le opzioni fornite, se presenti.
*   Reimposta lo stato di esecuzione.
*   Esegue gli script di avvio.

La cronologia non viene riprodotta. Tutto il codice inserito viene perso.

Le impostazioni dell'ambiente immesse nella riga di comando o fornite con un precedente comando /reset, /env o /reload vengono mantenute a meno che non venga immessa un'opzione che sovrascrive l'impostazione.

Sono valide le seguenti opzioni:

`--add-modules module[,module...]` Specifica i moduli radice da risolvere oltre al modulo iniziale.

`--add-exports source-module/package=target-module[,target-module]*` Aggiunge un'esportazione del pacchetto dal modulo di origine al modulo di destinazione.

`--class-path path` Specifica le directory e gli archivi in ​​cui viene eseguita la ricerca per individuare i file di classe. Questa opzione sovrascrive il percorso nella variabile di ambiente CLASSPATH. Se la variabile di ambiente non è impostata e questa opzione non è utilizzata, la ricerca viene eseguita nella directory corrente.

*   Per **Linux e macOS** , usa i due punti ( `:`) per separare gli elementi nel percorso.
*   Per **Windows** , utilizzare un punto e virgola ( `;`) per separare gli elementi.

`--module-path modulepath` Specifica dove trovare i moduli dell'applicazione. Per Linux e macOS, usa i due punti ( `:`) per separare gli elementi nel percorso. Per Windows, utilizzare un punto e virgola ( `;`) per separare gli elementi.

`/save [options] file` Salva frammenti e comandi nel file specificato. Se non vengono immesse opzioni, gli snippet attivi vengono salvati.

Sono valide le seguenti opzioni:

`{name|id|startID-endID} [{name|id|startID-endID}...]` Salva i frammenti e i comandi identificati da nome, ID o intervallo di ID. Per un intervallo di ID, fornire l'ID iniziale e l'ID finale separati da un trattino. Per fornire un elenco, separa gli elementi nell'elenco con uno spazio. Utilizzare il comando /list per visualizzare gli ID dei frammenti di codice.

`-all` Salva tutti gli snippet, inclusi gli snippet di avvio e gli snippet che sono stati sovrascritti o non riusciti.

`-history` Salva la cronologia sequenziale di tutti i comandi e gli snippet inseriti nella sessione corrente.

`-start` Salva le impostazioni di avvio correnti. Se non sono stati forniti script di avvio, viene salvato un file vuoto.

`/set [setting]` Imposta le informazioni di configurazione, inclusi l'editor esterno, le impostazioni di avvio e la modalità di feedback. Questo comando viene utilizzato anche per creare una modalità di feedback personalizzata con valori di prompt, formato e troncamento personalizzati. Se non viene immessa alcuna impostazione, vengono visualizzate l'impostazione corrente per l'editor, le impostazioni di avvio e la modalità di feedback.

I seguenti valori sono validi per l'impostazione:

`editor [options] [command]` Imposta il comando utilizzato per avviare un editor esterno quando viene immesso il comando /edit. Il comando può includere argomenti di comando separati da spazi. Se non vengono immessi comandi o opzioni, viene visualizzata l'impostazione corrente.

Sono valide le seguenti opzioni:

`-default` Imposta l'editor sull'editor predefinito fornito con JShell. Questa opzione non può essere utilizzata se viene immesso un comando per avviare un editor.

`-delete` Imposta l'editor su quello in vigore all'avvio della sessione. Se utilizzata con l'opzione -retain, l'impostazione dell'editor conservata viene eliminata e l'editor viene impostato sulla prima delle seguenti variabili di ambiente trovate: `JSHELLEDITOR`, `VISUAL`, o `EDITOR`. Se nessuna delle variabili di ambiente dell'editor è impostata, questa opzione imposta l'editor sull'editor predefinito.

Questa opzione non può essere utilizzata se viene immesso un comando per avviare un editor.

`-retain` Salva le impostazioni dell'editor tra le sessioni. Se non vengono immesse altre opzioni o comandi, l'impostazione corrente viene salvata.

`-wait` Richiede all'utente di indicare quando la modifica è stata completata. Altrimenti il ​​controllo ritorna a JShell quando l'editor esce. Utilizzare questa opzione se l'editor in uso esce immediatamente, ad esempio, quando esiste già una finestra di modifica. Questa opzione è valida solo quando viene immesso un comando per avviare un editor.

`feedback [mode]` Imposta la modalità di feedback utilizzata per rispondere all'input. Se non viene inserita alcuna modalità, viene visualizzata la modalità corrente.

Sono valide le seguenti modalità: `concise`, `normal`, `silent`, `verbose`e qualsiasi modalità personalizzata creata con il `/set`comando mode.

`format mode field "format-string" selector` Imposta il formato del feedback fornito in risposta all'input. Se non viene inserita alcuna modalità, vengono visualizzati i formati correnti per tutti i campi per tutte le modalità di feedback. Se viene inserita solo una modalità, vengono visualizzati i formati correnti per quella modalità. Se vengono immessi solo una modalità e un campo, vengono visualizzati i formati correnti per quel campo.

Per definire un formato sono necessari i seguenti argomenti:

`mode` Specifica una modalità di feedback a cui viene applicato il formato di risposta. `/set`È possibile modificare solo le modalità personalizzate create con il comando mode.

`field` Specifica un campo specifico del contesto a cui viene applicato il formato di risposta. I campi sono descritti nella guida in linea, a cui si accede `jshell`utilizzando il `/help` `/set`comando format.

`format-string` Specifica la stringa da utilizzare come formato di risposta per il campo e il selettore specificati. La struttura della stringa di formato è descritta nella guida in linea, a cui si accede da JShell utilizzando il `/help /set`comando format.

`selector` Specifica il contesto in cui viene applicato il formato di risposta. I selettori sono descritti nella guida in linea, a cui si accede da JShell utilizzando il `/help` `/set`comando format.

`mode [mode-name] [existing-mode] [options]` Crea una modalità di feedback personalizzata con il nome della modalità fornito. Se non viene immesso alcun nome di modalità, vengono visualizzate le impostazioni per tutte le modalità, che includono le impostazioni di modalità, prompt, formato e troncamento. Se viene fornito il nome di una modalità esistente, le impostazioni della modalità esistente vengono copiate nella modalità in fase di creazione.

Sono valide le seguenti opzioni:

`-command|-quiet` Specifica il livello di feedback visualizzato per i comandi quando si utilizza la modalità. Questa opzione è richiesta quando si crea una modalità di feedback. Utilizzare `-command`per mostrare informazioni e feedback di verifica per i comandi. Utilizzare `-quiet`per mostrare solo il feedback essenziale per i comandi, come i messaggi di errore.

`-delete` Elimina la modalità di feedback con nome per questa sessione. Il nome della modalità da eliminare è obbligatorio. Per eliminare definitivamente una modalità conservata, utilizzare l' `-retain`opzione con questa opzione. Le modalità predefinite non possono essere eliminate.

`-retain` Salva la modalità di feedback con nome tra le sessioni. Il nome della modalità da conservare è obbligatorio. Configurare la nuova modalità di feedback utilizzando i comandi `/set prompt`, `/set format`, e .`/set truncation`

Per iniziare a utilizzare la nuova modalità, utilizzare il `/set feedback`comando.

`prompt mode "prompt-string" "continuation-prompt-string"` Imposta i prompt per l'input all'interno di JShell. Se non viene inserita alcuna modalità, vengono visualizzate le richieste correnti per tutte le modalità di feedback. Se viene inserita solo una modalità, vengono visualizzate le richieste correnti per quella modalità.

Per definire un prompt, sono necessari i seguenti argomenti:

`mode` Specifica la modalità di feedback a cui vengono applicati i prompt. `/set`È possibile modificare solo le modalità personalizzate create con il comando mode.

`prompt-string` Specifica la stringa da utilizzare come prompt per la prima riga di input.

`continuation-prompt-string` Specifica la stringa da utilizzare come richiesta per le righe di input aggiuntive necessarie per completare uno snippet.

`start [-retain] [file [file...]|option]` Imposta i nomi degli script di avvio utilizzati quando viene immesso il comando successivo `/reset`, `/reload`, o . `/env`Se viene immesso più di uno script, gli script vengono eseguiti nell'ordine immesso. Se non vengono immessi script o opzioni, vengono visualizzate le impostazioni di avvio correnti.

Gli script possono essere file locali o uno dei seguenti script predefiniti:

`DEFAULT` Carica le voci predefinite, comunemente utilizzate come importazioni. `JAVASE` Importa tutti i pacchetti Java SE. `PRINTING` Definisce print, println e printf come metodi jshell da utilizzare all'interno dello strumento. Sono valide le seguenti opzioni:

`-default` Ripristina le impostazioni di avvio sulle impostazioni predefinite.

`-none` Specifica che non vengono utilizzate impostazioni di avvio. Utilizzare l' `-retain`opzione per salvare l'impostazione di avvio tra le sessioni.

`truncation mode length selector` Imposta la lunghezza massima di un valore visualizzato. Se non viene inserita alcuna modalità, vengono visualizzati i valori di troncamento correnti per tutte le modalità di feedback. Se viene immessa solo una modalità, vengono visualizzati i valori di troncamento correnti per quella modalità.

Per definire i valori di troncamento, sono richiesti i seguenti argomenti:

`mode` Specifica la modalità di feedback a cui viene applicato il valore di troncamento. `/set`È possibile modificare solo le modalità personalizzate create con il comando mode.

`length` Specifica l'intero senza segno da utilizzare come lunghezza massima per il selettore specificato.

`selector` Specifica il contesto in cui viene applicato il valore di troncamento. I selettori sono descritti nella guida in linea, a cui si accede `jshell`tramite il `/help /set truncation`comando.

`/types [option]` Visualizza le classi, le interfacce e le enumerazioni immesse. Se non viene immessa alcuna opzione, vengono visualizzate tutte le classi, le interfacce e le enumerazioni attive correnti.

Sono valide le seguenti opzioni:

`{name|id|startID-endID} [{name|id|startID-endID}...]` Visualizza le informazioni per classi, interfacce ed enumerazioni identificate da nome, ID o intervallo di ID. Per un intervallo di ID, fornire l'ID iniziale e l'ID finale separati da un trattino. Per fornire un elenco, separa gli elementi nell'elenco con uno spazio. Utilizzare il comando /list per visualizzare gli ID dei frammenti di codice.

`-all` Visualizza le informazioni per tutte le classi, le interfacce e le enumerazioni, comprese quelle aggiunte all'avvio di JShell e le classi, le interfacce e le enumerazioni non riuscite, sovrascritte o eliminate.

`-start` Visualizza le informazioni per le classi di avvio, le interfacce e le enumerazioni che sono state aggiunte all'avvio di JShell.

`/vars [option]` Visualizza il nome, il tipo e il valore delle variabili immesse. Se non viene inserita alcuna opzione, vengono visualizzate tutte le variabili attive correnti.

Sono valide le seguenti opzioni:

`{name|id|startID-endID} [{name|id|startID-endID}...]` Visualizza le informazioni per le variabili identificate da nome, ID o intervallo di ID. Per un intervallo di ID, fornire l'ID iniziale e l'ID finale separati da un trattino. Per fornire un elenco, separa gli elementi nell'elenco con uno spazio. Utilizzare il `/list`comando per visualizzare gli ID dei frammenti di codice.

`-all` Visualizza le informazioni per tutte le variabili, comprese quelle aggiunte all'avvio di JShell e le variabili non riuscite, sovrascritte o eliminate.

`-start` Visualizza le informazioni per le variabili di avvio che sono state aggiunte all'avvio `jshell`. `/?` Come il comando /help.

`/!` Esegue nuovamente l'ultimo snippet.

`/{name|id|startID-endID} [{name|id|startID-endID}...]` Esegue nuovamente i frammenti identificati da ID, intervallo di ID o nome. Per un intervallo di ID, fornire l'ID iniziale e l'ID finale separati da un trattino. Per fornire un elenco, separa gli elementi nell'elenco con uno spazio. Il primo elemento nell'elenco deve essere un ID o un intervallo di ID. Utilizzare il `/list`comando per visualizzare gli ID dei frammenti di codice.

`/-n` Esegue nuovamente l'ennesimo frammento di codice precedente. Ad esempio, se sono stati immessi 15 frammenti di codice, viene `/-4`eseguito l'undicesimo snippet. I comandi non sono inclusi nel conteggio.

 

Scorciatoie di input
--------------------

Le seguenti scorciatoie sono disponibili per inserire comandi e frammenti in JShell.

### Completamento della scheda

Quando si immettono frammenti, comandi, sottocomandi, argomenti di comando o opzioni di comando, utilizzare il tasto Tab per completare automaticamente l'elemento. Se l'articolo non può essere determinato da ciò che è stato inserito, vengono fornite le possibili opzioni.

Quando si immette una chiamata al metodo, utilizzare il tasto Tab dopo la parentesi di apertura della chiamata al metodo per visualizzare i parametri per il metodo. Se il metodo ha più di una firma, vengono visualizzate tutte le firme. Premendo una seconda volta il tasto Tab viene visualizzata la descrizione del metodo ei parametri per la prima firma. Continua a premere il tasto Tab per una descrizione di eventuali firme aggiuntive.

**Maiusc+IN** Dopo aver immesso un'espressione completa, utilizzare questa sequenza di tasti per convertire l'espressione in una dichiarazione di variabile di un tipo determinato dal tipo dell'espressione.

**Maiusc+M** Dopo aver immesso un'espressione o un'istruzione completa, utilizzare questa sequenza di tasti per convertire l'espressione o l'istruzione in una dichiarazione di metodo. Se viene immessa un'espressione, il tipo restituito si basa sul tipo dell'espressione.

**Maiusc+io** Quando viene immesso un identificatore che non può essere risolto, utilizzare questa sequenza di tasti per mostrare le possibili importazioni che risolvono l'identificatore in base al contenuto del percorso classe specificato.

### Abbreviazioni dei comandi

Un'abbreviazione di un comando è accettata se l'abbreviazione identifica in modo univoco un comando. Ad esempio, `/l`è riconosciuto come `/list`comando. Tuttavia, `/s`non è un'abbreviazione valida perché non è possibile determinare se si intende il comando `/set`o . `/save`Utilizzare `/se`per il `/set`comando o `/sa`per il `/save`comando.

Le abbreviazioni sono accettate anche per sottocomandi, argomenti di comando e opzioni di comando. Ad esempio, utilizzare `/m -a`per visualizzare tutti i metodi.

### Navigazione nella cronologia

Una cronologia di ciò che è stato inserito viene mantenuta tra le sessioni. Usa le frecce su e giù per scorrere i comandi e gli snippet delle sessioni correnti e passate. Usa il tasto Ctrl con le frecce su e giù per saltare tutto tranne la prima riga di snippet multilinea.

### Ricerca nella cronologia

Utilizzare la combinazione di tasti Ctrl+R per cercare nella cronologia la stringa immessa. Il prompt cambia per mostrare la stringa e la corrispondenza. **Ctrl+R** ricerca indietro dalla posizione corrente nella cronologia attraverso le voci precedenti. **Ctrl+S** ricerca in avanti dalla posizione corrente nella cronologia attraverso voci successive.

### Modifica dell'ingresso

Le capacità di modifica di JShell sono simili a quelle di altre shell comuni. I tasti della tastiera e le combinazioni di tasti forniscono scorciatoie per la modifica delle righe. Il tasto Ctrl e il tasto Meta sono usati nelle combinazioni di tasti. Se la tua tastiera non ha una chiave Meta, la `Alt`chiave viene spesso mappata per fornire la funzionalità della chiave Meta.

![](/assets/images/input-editing.png)

 

Esempio di avvio e arresto di una sessione jshell
-------------------------------------------------

jshell viene fornito con JDK. Per avviare una sessione, accedi `jshell`alla riga di comando. Viene stampato un messaggio di benvenuto e viene fornito un prompt per l'immissione di comandi e frammenti.

    jshell
    |  Welcome to JShell -- Version 16
    |  For an introduction type: /help intro
    
    jshell>
    

copia

Per vedere quali frammenti sono stati caricati automaticamente all'avvio di JShell, utilizzare il `/list -start`comando. I frammenti di avvio predefiniti sono istruzioni di importazione per i pacchetti comuni. L'ID di ogni snippet inizia con la lettera s, che indica che si tratta di uno snippet di avvio.

    jshell> /list -start
    
      s1 : import java.io.*;
      s2 : import java.math.*;
      s3 : import java.net.*;
      s4 : import java.nio.file.*;
      s5 : import java.util.*;
      s6 : import java.util.concurrent.*;
      s7 : import java.util.function.*;
      s8 : import java.util.prefs.*;
      s9 : import java.util.regex.*;
     s10 : import java.util.stream.*;
    

copia

Per terminare la sessione, utilizzare il comando /exit.

    jshell> /exit
    |  Goodbye
    
    %
    

copia

 

Esempio di immissione di frammenti
----------------------------------

Gli snippet sono istruzioni Java, definizioni di variabili, definizioni di metodi, definizioni di classi, istruzioni di importazione ed espressioni. I punti e virgola finali vengono aggiunti automaticamente alla fine di uno snippet completato se mancano.

L'esempio seguente mostra due variabili e un metodo in fase di definizione e il metodo in esecuzione. Si noti che una variabile scratch viene creata automaticamente per contenere il risultato poiché non è stata fornita alcuna variabile.

    jshell> int a=4
    a ==> 4
    
    jshell> int b=8
    b ==> 8
    
    jshell> int square(int i1) {
       ...> return i1 * i1;
       ...> }
    |  created method square(int)
    
    jshell> square(b)
    $5 ==> 64
    

copia

 

Esempio di modifica dei frammenti
---------------------------------

Modificare la definizione di una variabile, metodo o classe immettendola nuovamente.

Gli esempi seguenti mostrano un metodo in fase di definizione e il metodo eseguito:

    jshell> String grade(int testScore) {
    ...>     if (testScore >= 90) {
    ...>         return "Pass";
    ...>     }
    ...>     return "Fail";
    ...> }
    |  created method grade(int)
    
    jshell> grade(88)
    $3 ==> "Fail"
    

copia

Per modificare il voto del metodo per consentire a più studenti di passare, immettere di nuovo la definizione del metodo e modificare il punteggio di superamento a 80. Utilizzare il tasto freccia su per recuperare le voci precedenti per evitare di doverle reinserire e apportare la modifica nell'istruzione if. L'esempio seguente mostra la nuova definizione ed esegue nuovamente il metodo per mostrare il nuovo risultato:

    jshell> String grade(int testScore) {
    ...>     if (testScore >= 80) {
    ...>         return "Pass";
    ...>     }
    ...>     return "Fail";
    ...> }
    |  modified method grade(int)
    
    jshell> grade(88)
    $5 ==> "Pass"
    

copia

Per snippet lunghi più di poche righe o per apportare più di poche modifiche, utilizzare il comando /edit per aprire lo snippet in un editor. Al termine delle modifiche, chiudere la finestra di modifica per restituire il controllo alla `jshell`sessione. L'esempio seguente mostra il comando e il feedback fornito alla chiusura della finestra di modifica. Il comando /list viene utilizzato per mostrare che il punteggio di passaggio è stato modificato in 85.

    jshell> /edit grade
    |  modified method grade(int)
    jshell> /list grade
    
       6 : String grade(int testScore) {
               if (testScore >= 85) {
                   return "Pass";
               }
               return "Fail";
           }
    

copia

 

Esempio di creazione di una modalità di feedback personalizzata
---------------------------------------------------------------

La modalità feedback determina il prompt visualizzato, i messaggi di feedback forniti come frammenti vengono immessi e la lunghezza massima di un valore visualizzato. Sono fornite modalità di feedback predefinite. Vengono forniti anche i comandi per la creazione di modalità di feedback personalizzate.

Utilizzare il `/set`comando mode per creare una nuova modalità di feedback. Nell'esempio seguente, la nuova modalità `mymode`, si basa sulla modalità di feedback predefinita, normale e viene visualizzato il feedback del comando di verifica:

    jshell> /set mode mymode normal -command
    |  Created new feedback mode: mymode
    

copia

Poiché la nuova modalità è basata sulla modalità normale, i prompt sono gli stessi. L'esempio seguente mostra come vedere quali prompt vengono utilizzati e quindi modifica i prompt in stringhe personalizzate. La prima stringa rappresenta il prompt standard di JShell. La seconda stringa rappresenta la richiesta di righe aggiuntive negli snippet multilinea.

    jshell> /set prompt mymode
    |  /set prompt mymode "\njshell> " "   ...> "
    
    jshell> /set prompt mymode "\nprompt$ " "   continue$ "
    

copia

La lunghezza massima di un valore visualizzato è controllata dall'impostazione di troncamento. Diversi tipi di valori possono avere lunghezze diverse. L'esempio seguente imposta un valore di troncamento complessivo di `72`e un valore di troncamento di `500`per le espressioni di valore variabile:

    jshell> /set truncation mymode 72
    jshell> /set truncation mymode 500 varvalue
    

copia

Il feedback visualizzato dopo l'immissione degli snippet è controllato dall'impostazione del formato e si basa sul tipo di snippet immesso e sull'azione eseguita per tale snippet. Nella modalità predefinita normale, la stringa creata viene visualizzata quando viene creato un metodo. L'esempio seguente mostra come modificare quella stringa in definita:

    jshell> /set format mymode action "defined" added-primary
    

copia

Utilizzare il comando /set feedback per iniziare a utilizzare la modalità feedback appena creata. L'esempio seguente mostra la modalità personalizzata in uso:

    jshell> /set feedback mymode
    |  Feedback mode: mymode
    
    prompt$ int square (int num1){
       continue$ return num1*num1;
       continue$ }
    |  defined method square(int)
    
    prompt$
    

