Create a spring starter project

Add the maven dependencies for web,mysql,jdbc

Code in application.properties entries 
spring.datasource.initialization-mode is required for auto creation and loading of tables and data THIS SHOULD BE COMMENTED OUT AFTER FIRST RUN
Create the files schema.sql and data.sql

Code in models/daos/services/controllers in appropriate packages

run the app as spring boot application

Using Any rest client
Invoke URL : http://localhost:9001/topics
      http://localhost:9001/topics/t002




IN CASE ANY SERVER TIME ZONE ERROR DO 1 OF THE BELOW

Give the DB URI as below
jdbc:mysql://localhost:3306/verizondb?serverTimezone=UTC&useLegacyDatetimeCode=false