# Vehicle Monitoring POC

![Alt text](screen_shots/ui_screen.png?raw=true 'Home page')

## Scenario:

Imagine you are one of our consultants and you got assigned to a project at one of our top partners.
They have a number of connected vehicles that belongs to a number of customers.
They have a need to be able to view the status of the connection among these vehicles on a monitoring display.
The vehicles send the status of the connection one time per minute.
The status can be compared with a ping (network trace); no request from the vehicle means no connection.
So, vehicle is either Connected or Disconnected.

## Task:

- Your task will be to create a data store that keeps these vehicles with their status and the customers who own them, as well as a GUI (preferably web-based) that displays the status.
- Obviously, for this task, there are no real vehicles available that can respond to your "ping" request.
- This can either be solved by using static values or ​​by creating a separate machinery that returns random fake status.

## Requirements

1. Web GUI (Single Page Application Framework/Platform).
   - An overview of all vehicles should be visible on one page (full-screen display), together with their status.
   - It should be able to filter, to only show vehicles for a specific customer.
   - It should be able to filter, to only show vehicles that have a specific status.
2. Random simulation to vehicles status sending.
3. If database design will consume a lot of time, use data in-memory representation.
4. Unit Testing.
5. .NET Core, Java or any language you feel comfortable with.
6. Complete analysis for the problem.
   - Full architectural sketch to solution.
   - Analysis behind the solution design, technologies....
   - How to run your solution.
7. Use CI (Travis, Circle, TeamCity...) to verify your code (Static analysis,..) and tests.
8. Dockerize the whole solution.
9. Use Microservices architecture.
   - Use any Microservices Chassis Framework.
10. Use any free tier on any cloud platform like: - AWS, Azure or GCP

## Optional Requirements

1. Write an integration test.
2. Write an automation test.
3. Explain if it is possible to be in Serverless architecture and how?
4. Continuous delivery to the solution to the cloud.

## Data:

Below you have all customers from the system; their addresses and the vehicles they own.

### Customer #1:

**Kalles Grustransporter AB**

**Cementvägen 8, 111 11 Södertälje**

| VIN (VehicleId)   | Reg. nr. |
| ----------------- | -------- |
| YS2R4X20005399401 | ABC123   |
| VLUR4X20009093588 | DEF456   |
| VLUR4X20009048066 | GHI789   |

### Customer #2:

**Johans Bulk AB**

**Balkvägen 12, 222 22 Stockholm**

| VIN (VehicleId)   | Reg. nr. |
| ----------------- | -------- |
| YS2R4X20005388011 | JKL012   |
| YS2R4X20005387949 | MNO345   |

### Customer #3:

**Haralds Värdetransporter AB**

**Budgetvägen 1, 333 33 Uppsala**

| VIN (VehicleId)   | Reg. nr. |
| ----------------- | -------- |
| VLUR4X20009048066 | PQR678   |
| YS2R4X20005387055 | STU901   |

# Solution

## Architecture

This business use case is very promising. It introduces an out-of-the box solution that can fit for any customer wants to track or monitor his vehicles. Based on that, it can be designed as a plateform where customers can register themselves and their vehicles. This plateform should be design in a way that can allow dynamic scalability and high availability. **Microservices Architecture** is one of the most suitable architecture that matches this business use case. It allows decomposing the application into different smaller services that improves modularity and scalability of services independently. It also allows to introduce new services to the plateform. One of the most advantages of microservices architecture that it fits for **Cloud** deployments.

![Alt text](screen_shots/architecture_diagram.png?raw=true 'Architecture diagram)

## Services and Technologies

Application is a set loosely coupled fine-graned services that communicate to each other over HTTP protocol.

![Alt text](screen_shots/application_services?raw=true 'Application services')

- **Customer API:** a lightweight service for Customer management. Technologies are: SpringBoot, h2-database and Swagger.
- **Vehicle API:** a lightweight service for Vehicle management. Technologies are: SpringBoot, h2-database and Swagger.
- **Customer Vehicle Managment API:** a lightweight service for Customer-Vehicle relationship management. Technologies are: SpringBoot, h2-database and Swagger.
- **Vehicle Status API:** a lightweight service for Vehicle Status calculation. It has the business logic of vehicle status calculation. Technologies are: SpringBoot, h2-database and Swagger.
- **Vehicle Pulse Emulator:** applciation that simulates vehicle's pings. Technologies are: SpringBoot, h2-database and Swagger.
- **Gateway API:** a lightweight service where all calls to other service should come through. Technologies are: SpringBoot, Zuul, h2-database and Swagger.
- **Discovery Service:** a lightweight service where all up services should be registered. Technologies are: SpringBoot, Eureka Discovery Service, h2-database and Swagger.
- **Vehicle Monitoring UI:** a web application for viewing vehicles' status. AngularJS and Bootstrap.

## Deployment

### Development Environment

To fit with microservices architecture. **Docker** technology is used for local deployment.

#### Steps

- **Customer API:**

```shell
  cd customer-api
  mvn clean package
```

- **Vehicle API:**

```shell
  cd vehicle-api
  mvn clean package
```

- **Customer Vehicle Managment API:**

```shell
  cd customer-vehicle-management-api
  mvn clean package
```

- **Vehicle Status API:**

```shell
  cd vehicle-status-management
  mvn clean package
```

- **Vehicle Pulse Emulator:**

```shell
  cd vehicle-pulse-emulator
  mvn clean package
```

- **Gateway API:**

```shell
  cd vehicle-monitor-api-gateway
  mvn clean package
```

- **Discovery Service:**

```shell
  cd vehicle-discovery-service
  mvn clean package
```

- **Vehicle Monitoring UI:**

```shell
  cd vehicle-monitoring-ui
  ng build
```

#### Run Application

```shell
docker-compose up --build
```

#### App URL

Vehicle Monitoring Dashboard: [http://localhost:8888/#dashboard](http://localhost:8888/#dashboard 'http://localhost:8888/#dashboard')

Discovery Service Dashboard: [http://localhost:8761/](http://localhost:8761/ 'http://localhost:8761/')

#### API Documention

- **Customer API:** [http://localhost:9092/swagger-ui.html](http://localhost:9092/swagger-ui.html 'http://localhost:9092/swagger-ui.html')
  ![Alt text](screen_shots/customer_api.png?raw=true 'customer api')

- **Vehicle API:** [http://localhost:9091/swagger-ui.html](http://localhost:9091/swagger-ui.html 'http://localhost:9091/swagger-ui.html')
  ![Alt text](screen_shots/vehicle_api.png?raw=true 'vehicle api')

- **Customer Vehicle Management API:** [http://localhost:9093/swagger-ui.html](http://localhost:9093/swagger-ui.html 'http://localhost:9093/swagger-ui.html')
  ![Alt text](screen_shots/customer_vehicle_mang_api.png?raw=true 'customer vehicle management api')

### Production Environment

- **AWS ElasticBeanstalk** for services container.
- **AWS S3** for deployment metadate.

#### CI/CD

- **Travis CI:**
  - Build service
  - Build Docker images
  - Deploy on AWS **Beanstalk**
