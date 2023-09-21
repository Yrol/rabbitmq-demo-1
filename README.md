# RabbitMQ Demo
RabbitMQ demo application developed in Spring Boot which consist of producers and consumers. Capable of performing the following simple operations.
- Publish messages to RabbitMQ queues via GET and POST methods.
- Consume messages from queues automatically and display in logs.


## Tech Stack
- Spring Boot
- RabbitMQ
- Docker

The RabbitMQ properties such as queues, exchanges and binding keys are all 
pre-configured within `docker-compose/rabbitmq/definitions.json` to be initiated when starting the RabbitMQ Docker container.

## Running the services on Docker
This will allow to build and run all the services in Docker.

- RabbitMQ
- Spring boot app

### Prerequisites
- Docker up and running in the background

### Steps
- **Step 1:** The project needs to be built first using the command `mvn install -DskipTests` via intelliJ or in commandline. It should be executed under the root project rabbitmq-demo as shown below.<br/>
![](https://i.imgur.com/oa9scAe.png)
- **Step 2:** Execute the following docker command inside `docker-compose` directory in order to bring up the Spring project and the RabbitMQ service.
    ```
    docker-compose up 
    ```
  ![](https://i.imgur.com/KQy0APl.png)


## Running the project in IntelliJ

### Prerequisites
- Java 11
- Docker up and running in the background (for RabbitMQ)

### Steps
- **Step 1:** Execute the following docker command inside `docker-compose` directory in order to bring up the RabbitMQ servers.
    ```
    docker-compose -f rabbitmq.yml up 
    ```
- **Step 2:** Build and run the microservice project `rabbitmq-demo-app` in IntelliJ.

## Sending messages to RabbitMQ

### via GET
```agsl
http://localhost:8080/api/v1/publish?message=aston-martin
```


### via POST
Use cURL or Postman to send the following POST request
```agsl
curl --location 'http://localhost:8080/api/v1/publish' \
--header 'Content-Type: application/json' \
--data '{
    "id": 5,
    "firstName": "John",
    "lastName": "Cena"
}'
```

## Accessing the RabbitMQ dashboard
The RabbitMQ dashboard can be accessed via port `15672`. Username:`guest`, Password: `guest`
```agsl
http://localhost:15672/
```

