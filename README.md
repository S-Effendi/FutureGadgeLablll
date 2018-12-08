# FutureGadgeLablll - Future Gadget Labrotary

This project represents an application which gives the user functionality to operate a parking lot system.
FutureGadgeLab is a maven based project which makes use of HSQL, Spring, Flyway, Mockito, Tomcat and CSG Checkstyles.

## Introductory Instructions
PHASE 1:
1. Download IntelliJ (this IDE was made use of within this project), or download preferred IDE of your choice.
2. Use a CLI of your choice then execute, Git Clone: ```https://github.com/S-Effendi/FutureGadgeLablll.git```
2. Next make sure you have the latest java JDK installed.
3. You can then open the project as a maven project and copy the pom.xml file.
4. Enable all dependencies.

## Build Instructions
PHASE 2:
1. Maven Project Build:
   ```mvn clean install```
   ```mvn clean compile package```
2. Flyway: 
   ```mvn flyway:migrate```
   ```mvn flyway:clean```
3. Tomcat:
   ```mvn tomcat7:run```
4. CheckStyles:
  ```mvn checkstyle:checkstyle```
  ```mvn pmd:check```
  ```mvn findbugs:findbugs```

## HTTP Requests - Postman was used to test this.
WORKFLOW:

1. POST /ticket -> createTicket()
   Post Display – empty response
   
2. GET /ticket -> readTicket()
   GET Display -
 ```
    {
        "ticketId": 1,
        "fee": 10.5,
        "entryDateTime": "2010-07-16 19:19:08.0",
        "exitDateTime": "2010-07-16 19:19:08.0"
    },
    {
        "ticketId": 2,
        "fee": null,
        "entryDateTime": "2018-12-07 19:23:54.924",
        "exitDateTime": ""
    }
```

3. PUT /ticket -> updateTicket()
   PUT Display - 
   Put- {
```
        "ticketId": 2,
        "exitDateTime": "2018-12-07 20:03:31.047"
    }
```
4. GET /tickets -> readAllTickets()
   GET Display 
```{
        "ticketId": 1,
        "fee": 10.5,
        "entryDateTime": "2010-07-16 19:19:08.0",
        "exitDateTime": "2010-07-16 19:19:08.0"
    },
    {
        "ticketId": 2,
        "fee": 10,
        "entryDateTime": "2018-12-07 19:23:54.924",
        "exitDateTime": "2018-12-07 20:03:31.047"
    }
```
## Hsql DB - Working with a manual installation of HSQL DB

Getting Flyway setup and HSQL installed

STEPS:
1. Download HSQLDB (make sure the latest JDK has been installed)
2. Extract HSQLDB zip
3. Create a default database
```
server.database.0 = file:hsqldb/demodb
server.dbname.0 = testdb
```
4. Execute the following in your command prompt
```
\>cd C:\hsqldb-2.3.4\hsqldb
hsqldb>java -classpath lib/hsqldb.jar org.hsqldb.server.Server
```
5. You can start the database with the following:
```
\>cd C:\hsqldb-2.3.4\hsqldb
hsqldb>java -classpath lib/hsqldb.jar org.hsqldb.server.Server --database.0file:hsqldb/demodb --dbname.0 testdb
```

When wanting to exit Ctrl+C.

When running this project please consider the following demodb has been changed to futureGadgeLab and testdb has been changed to fgldb.
It will appear as below:
```
cd /c/hsqldb-2.4.1/hsqldb
java -classpath lib/hsqldb.jar org.hsqldb.server.Server --database.0 file:hsqldb/futureGadgeLab --dbname.0 fgldb
```

Reference used: https://www.tutorialspoint.com/hsqldb/hsqldb_installation.htm
