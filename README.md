# Web application
This is web application for a project at Warsaw University of Technology, Faculty of Electrical Engineering.

The point of it is to create an IoT chain, and this is the last step of it, displaying the data from microcontroller. I tried to create the whole code in English but the views (.html files) are written in Polish. You can see that data is taken from the local database, where the table "sensors_data" is. 

# DATABASE
In application.properties file you can see that web app connects to the MySQL server on localhost. I use XAMPP and localhost/phpmyadmin to manage the database. 

UPDATE: The MySQL database is on a Google Cloud platform. If you want to use local database just in application.properties write spring.datasource.url=jdbc:mysql://localhost/<DATABASE_NAME>

# BUGS  

There are few bugs in the code, e.g. the date taken in "home.html" view is not controlled so it's possible to write wrong date or even zeroes in thymeleaf input. The point of whole programme is not to be perfect, it just has to work. I'm aware of "incompletion" of the application and the functionalities you can create. 
