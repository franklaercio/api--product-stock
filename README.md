# Product Stock Management System

## Description
This is a simple product stock management system. It is a console application that allows 
the user to add, edit, delete, and view products. The user can also view the total value 
of the stock and the total value of the stock by category. <br>

You can view the API documentation by entering the following URL in a browser on [Heroku](https://api--product-stock-73317c90543a.herokuapp.com/swagger-ui/index.html#/). <br>

If you can watch a video of the application running on [YouTube](https://youtu.be/xVugwl5R6YU).

## Technologies
* Java 21
* Maven 3.8.1
* Spring Boot 3.1.5
* MySQL 8.0.26
* Docker 20.10.8
* Docker Compose 1.29.2
* JUnit 5.7.2
* OpenApi 2.2.0
* MapStruct 1.4.2
* Flyway 10.0.1

## Installation
1. Clone the repository
2. Execute `docker compose up -d` in the terminal
3. Execute `mvn clean install` in the terminal
4. Create a schema named `products` in your MySQL database `products`
5. Open the project in your IDE
6. Run the program
7. Enjoy!

## Usage
1. When the program starts, the user will be presented with a menu of options.
2. The user can select an option by entering the corresponding number.
3. The user can add, edit, delete, and view products.

## API Documentation
1. When the program starts, the user will be access the documentation.
2. The user can view the API documentation by entering the following URL in a browser:
3. http://localhost:8080/swagger-ui/index.html

## Endpoints
* GET /product
* GET /product/{id}
* POST /product
* PUT /product
* DELETE /product/physic/{id}
* DELETE /product/logic/{id}

## Architecture
* The application is implemented following of Netflix hexagonal architecture.
* The application is divided into three layers: transportlayers, entities, interactors, and datasources.
  * The transport layer is responsible for exposing the application to the outside world.
  * The entities layer is responsible for the business logic.
  * The interactors layer is responsible for the application use cases.
  * The datasources layer is responsible for the data access.
* You can find more information about the architecture in the following link:
  * https://netflixtechblog.com/ready-for-changes-with-hexagonal-architecture-b315ec967749

## Contributing
Pull requests are welcome. For major changes, please open an issue first to discuss what you would like to change.

## License
This project is licensed under the MIT License - see the [LICENSE.md](LICENSE.md) file for details.
