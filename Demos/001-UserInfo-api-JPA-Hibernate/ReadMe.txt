Create a new Spring starter project 001-UserInfo-api-JPA-Hibernate
Dependencies : web, JPA, MySql
Add the entries to application.properties as shown in demo
Create the HibernateConfiguration.java as shown 
Create the model class annotate it with required annotations
Create the dao/service/controller

Note the exclude property for @springBootApplication 
(This is to override the default hibernate Jpa Configuration.
If not given there is class cast exception this might be rectified in newer versions of spring)

run the app

Invoke from postman the POST Url : http://localhost:9001/userinfo/create
{
	"name": "Ameya Joshi",
	"country": "India" 
}
Observe the sts console and confirm from DB
