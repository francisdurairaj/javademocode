Create the springcloudconfigserver project with the dependencies as mentioned in pom.xml  

Note the use of @enableConfigServer
Note the entries in bootstrap.properties

create folder by the path and name  as mentioned in properties file (myrepo)

create the mywebservice.properties file
create the mywebservice-development.properties file
create the mywebservice-production.properties file
make key value pair entries

Git must be installed

from command prompt within the above folder
git init 
git add .
git commit -m "initial checkin" (If prompted provide valid name and email)

after any new file is added to above folder or any existing file is modified again

git add .
git commit -m "test"

run the project as spring boot app

invoke URL : 
localhost:9088/mywebservice/production
localhost:9088/mywebservice/development
localhost:9088/mywebservice/default

****************************************************************************

Create the springcloudconfigclient(005-mywebservice) project with dependencies as mentioned in pom.xml

Code in the controller class note @RefreshScope
and the methods and attributes

make entries in bootstrap.properties

run the project as spring boot app

invoke URL :
localhost:9001/msg

now change the value for msg in config-server-client-production.properties file
 run git add . and git commit -m "test" from cmd prompt
 
 now run a post message localhost:9001/actuator/refresh
 
 refresh the browser
 
 the changed value will appear

rerun the project
again invoke the url
