This demo is of microservices with netflix OSS using spring boot

We code in the microservice AccountService 
and deploy them using Eureka/Zuul

It consists of 3 services

AccountRestService Project -->Your Business microservice (Note the dependencies for zipkin and sleuth also note the sampler method and sleuth properties in yml file)

EurekaDiscoveryServer -->Registry your services are registerd with Eureka server

ZuulGatewayServer -->Creates the proxy (ZUUL proxy) for your services(Note the dependencies for zipkin and sleuth also note the sampler method and sleuth properties in yml file)


Writedown the required classes and interfaces refering to the sample project

Note the varoius annotations @SpringbootApplication @RestController etc


While running Run in the following order (port nos. and all configurations in application.yml files)
	discovery-service (runs on port 8761) l
	gateway-service (runs on port 8765)
	account-service (runs on port 2222) 
	

The services should be invoked using port to which gateway-service listens (8765 in this case)
The url patterns are mentioned in application.yml of gateway-service project.

The dicovery-service can be invoked using the port to which it listens(8761 in this case)


Sample URLS :

http://localhost:8761

http://localhost:8765/account/accounts

http://localhost:8765/account/accounts/222222