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
