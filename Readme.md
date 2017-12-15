# content-connector-rest-service


Due to the need to expand the content connector service interoperability to accept content from RESTful services,
it has been implemented a REST client that connects to REST endpoints.

In addition to that, and for experimenting with the content-connector-api as a REST service,
this project is working as a fully functional REST service based on spring-boot,
and provides all methods to a ContentConnector based client.

In the current version, we use a dependency to an existing ContentConnector, and in the application.properties file,
we add all necessary properties to operate. Then, each ContentConnector method is advertised from the service's endpoints.