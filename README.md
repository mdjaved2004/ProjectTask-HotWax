# Assignment: RESTful API Development

Java Servlet-based REST API for managing customers and orders.

## Features
- Add, update, delete, and get all customers
- Create, update, delete and read orders
- Fetch customer + order + product details
- JSON API using Gson
- MySQL relational database

## Tech Stack
- Java (Servlets)
- JDBC
- MySQL
- Gson
- Apache Tomcat
- Testing (Thunder Client)

## Sample Endpoints
- POST /customers          → add customer  
- PUT /customers           → update customer  
- DELETE /customers?id=1   → delete customer  
- GET /customers           → get all customers  

- POST /orders             → add order  
- PUT /orders              → update order
- DELETE/DeleteOrder  → delete customer 
- GET /OrdersReads         → read orders (customer + products)
  

## Run
- Import Maven project
- Configure database
- Deploy on Tomcat
