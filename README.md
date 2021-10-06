# financeApp
## What is it?
Here I am interested in making a local running app to organize your finnance life.

## How does it work?
It is pretty simple. You just Download it in your computer, run the file "FinanceAppAplication.java" and start making requests into the App.

Considering you do not have MySQL, then you will need to download it and run the following queries:

CREATE DATABASE financeapp;
CREATE TABLE table_name (
    id INT NOT_NULL AUTO_INCREMENT,
    name VARCHAR(60),
    price DECIMAL(5,0),
    description VARCHAR(200),
    timestamp DATETIME
);

Moreover, you will probably have to change the user or the password of your database in "application.properties" file.

I personally recommend you to use Postman as an app to send requests, since you will need to use POST methods to insert something into the DataBase, for now.

Just one more thing: this is a WIP (work in progress) project, and it will have in the future some sort of user interface, that I am planning to develop it with Angular, but for now, it is just a API.
