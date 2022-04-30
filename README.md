# Getting Started
## Алексей Сурнов MAC2031

A simple CRUD-application that integrated with nosql graph database - neo4j.
There are 2 simple entities: User and Movie. User can have a RELATIONSHIP with movie -- it means, that 
user can like movies or not. 

### Reference Documentation

The following guides illustrate how to use some features concretely:

* [Accessing Data with Neo4j](https://spring.io/guides/gs/accessing-data-neo4j/)

### How to run and use
- docker run -p7474:7474 -p7687:7687 -e NEO4J_AUTH=neo4j/s3cr3t neo4j
- [Hawtio access](http://localhost:8080/actuator/hawtio/jmx/attributes?nid=root-com.example.neospring.service)
- Go to com.example.neospring.service package
- Leverage movie/user services in the operations tab