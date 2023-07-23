## MYSQL database query

Create database Setup;
use setup;

create table user (object_id int primary key ,object_name varchar(50)); 

select * from program;

## install the jdbc driver
https://dev.mysql.com/downloads/file/?id=520816

## In VsCode go to command palet and create java project

we name our project as "Setup_JDBC"

The file structure of our project is:

dir - bin

dir - lib

dir - src
file - README.md
 
## adding the jdbc connector to our project

 After Extracting the mysql-connector-j -8.1.0 add the mysql-connector-j-8.1.0 to lib dir of the java project.

 ## After coding is done 

 ## process of compiling and running the project
# option 1 

 in the vscode run from the code runner icon Option "run java"

note - your env variables are setup perfectly

# option 2

compile our code using : javac -cp "..\lib\mysql-connector-j-8.1.0.jar;."  Main.java



run our code using : java -cp "..\lib\mysql-connector-j-8.1.0.jar;."  Main  


note-current dir is src


## connection established message received