
# 15.10.: 
## Aufgabe 1:
  Erweitere SimpleRestController 
  mit neuer Methode mit Pfad Variable: 
    @GetMapping("/properties/{property}")
    @PathVariable
 
  Wenn implementiert, dann im Browser aufrufen.
  
## Aufgabe 2:
    a. Autowire SingletonPropertyExample und return von getMessage()
    b. verändere den Wert für "myapp.name" Variable
       auf z.b."My App Name Extra Properties"     

### Aufgabe 3:
    c. Starte App mit "Update classes and Ressources" in der Run Configuration
       --> app context wird bei code oder property änderungen neu intialisiert.
    Anwendung unter: http://localhost:8080/simplerest/echo
    
### Aufgabe 4:
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

    Beide Methoden sollen List<ChatMessage> als return Liste liefern

    http://localhost:8080/rest/chatmessages 
    soll Liste der Messages liefern etwa so:
    
    // 20201015114932
    // http://localhost:8080/rest/chatmessages
    
    [
      {
        "id": 2,
        "type": "CHAT",
        "content": "test ChatMessageDaoTest",
        "sender": "john doe",
        "recipient": "frank",
        "erstelldatum": "2020-10-14T21:20:19.785556"
      }, ...

## Aufgabe 6:
      Schreibe eine POST methode mit folgender Annotation
      
      @PostMapping("/chatmessages")
      um eine Chat Message einzufügen
      für die Input POST Chat Message bitte 
      
      @RequestBody als Pramater Annotation verwenden.
      
      Als Standard Spring Test implementieren
      
      Trainer: pushed as createChatMassage in Trainier Controller
               /trainerrest neue base url 
               
## Aufgabe 7:
    implementiere eine Rest Controller methode findByID
    @GetMapping("/chatmessages/{id}") 
    
    falls diese id nicht gefunden wird, werfe die neue 
    Exception ChatMessageNotFoundException
    Die Klasse: ChatMessageNotFoundAdvice
    stellt mittels Controller Advice annotation ein mapping zur
    verfügung  @ControllerAdvice
    
## Aufgabe 8:
    Erweitere Controller test für findById
    nutzte Assertions.assertThrows(ChatMessageNotFoundException.class .. )
    um die erwartete excpetion bei falscher ID zu prüfen.
    
## Aufgabe 9:
    Erweitere um ein PUT mapping für update or insert Chat Message
    mittels: 
    @PutMapping("/chatmessages/{id}")
    Mit input parameter ChatMessage als BodyParameter 
    und ID als path parameter Long id 
    
## Aufgabe 10:
    Erweitere um ein Delete Mapping
    @DeleteMapping
    mit delete by ID als Pfad Variable 
    "/chatmessagess/{id}" Long id
    
## Aufgabe 11:
    verwende request query parameter für ein find by ID
    @RequestParam("id") 
    http://localhost:8080/rest/chatmessages/byRequestParam?id=5    
               
### Aufgabe 12:
    verwende einen nicht zum Datentyp Long konvertierbaren Input
    http://localhost:8080/trainerrest/chatmessages/byRequestParam?id=asdfasdf      
    (type=Bad Request, status=400) sollte die Browser Antwort sein
    
    Aktivere Controller Advice CustomRestExceptionHandler
    Struktuierter Fehler Response sollte die Folge sein 

    Output erwartung vom Error Handler:
        
    // http://localhost:8080/trainerrest/chatmessages/asdfasdf
        
        {
          "status": "BAD_REQUEST",
          "message": "Failed to convert value of type 'java.lang.String' to required type 'java.lang.Long'; nested exception is java.lang.NumberFormatException: For input string: \"asdfasdf\"",
          "errors": [
            "id should be of type java.lang.Long"
          ]
        }    
    
# simple user permission denied auf :     
# http://localhost:8080/trainerrest/chatmessages/findBySender/dasdfasdf     

# mit : 
# org.springframework.security.access.AccessDeniedException

# {"status":"INTERNAL_SERVER_ERROR","message":"Zugriff verweigert","errors":["error occurred"]}

 


    
      
      
      
      
      
      

