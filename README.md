# FutureGadgeLablll - Future Gadget Labrotary

This project represents an application which gives the user functionality to operate a parking lot system.
FutureGadgeLab is a maven based project which makes use of HSQL, Spring, Flyway, Mockito, Tomcat and CSG Checkstyles.

## GitHub Instructions
STEPS:
1. Git Clone: ```https://github.com/S-Effendi/FutureGadgeLablll.git```
2. Extract HSQLDB zip
3. Create a default database

## Hsql DB

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
