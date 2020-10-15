
# 15.10.: 
## Aufgabe 1:
  Erweitere SimpleRestController 
  mit neuer Methode mit Pfad Variable: 
    @GetMapping("/properties/{property}")
    @PathVariable
 
  Wenn implementiert, dann im Browser aufrufen.
  
Aufgabe 15.10. 2:
    a. Autowire SingletonPropertyExample und return von getMessage()
    b. verändere den Wert für "myapp.name" Variable
       auf z.b."My App Name Extra Properties"     

Aufgabe 15.10. 3:
    c. Starte App mit "Update classes and Ressources" in der Run Configuration
       --> app context wird bei code oder property änderungen neu intialisiert.
    Anwendung unter: http://localhost:8080/simplerest/echo
    
Aufgabe 15.10. 4:
    d. Erzeuge einen Spring Test.
    e. Autowire den neuen Rest Controller und teste die Methoden
    
## Aufgabe 5:
    Im java package rest
    schreibe einen ChatMessageRestController
    mit dem Basis pfad /rest
    und den Get-Methoden
    -> /chatmessages --> liste ALLE Messages
    -> /chatmessages/findBySender/{sender}
    -> injecte dazu das ChatMessageService und verwende es
    
    Beide Methoden sollen List<ChatMessage> als return Liste liefern



