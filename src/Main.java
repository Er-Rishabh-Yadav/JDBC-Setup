import java.sql.Statement;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Main {
    class Connector{
        static Connection con = null;
        public static Connection establishConnection(){
            try{
                Class.forName("com.mysql.cj.jdbc.Driver");
                con = DriverManager.getConnection("jdbc:mysql://localhost:3306/","root","Yadav@123");
                System.out.println("Connection Established");
            }catch(Exception e){
                System.out.println(e);
            }
            return con;
        } 
    }
    class DBOperations{
        static Connection con = Connector.establishConnection();
        public static void createDB(){
            try{
                Statement stmt = (Statement) con.createStatement();
                ((java.sql.Statement) stmt).executeUpdate("CREATE DATABASE IF NOT EXISTS Setup");
                System.out.println("Database Created");
            }catch(Exception e){
                System.out.println(e);
            }
        }
        public static void createTable(){


            try{
                Statement stmt = (Statement) con.createStatement();
                ((java.sql.Statement) stmt).executeUpdate("CREATE TABLE IF NOT EXISTS Setup.User(Object_id int NOT NULL primary key,object_name varchar(50))");
            }catch(Exception e){
                System.out.println(e);
            }
        }
        public static void insertData(int id,String name){
            try{
                Statement stmt = (Statement) con.createStatement();
                ((java.sql.Statement) stmt).executeUpdate("INSERT INTO Setup.User VALUES("+id+",'"+name+"')");
                System.out.println("Data Inserted");
            }catch(Exception e){
                System.out.println(e);
            }
        }
        public static void readData(){
            try{
                Statement stmt = (Statement) con.createStatement();
                ResultSet rs = ((java.sql.Statement) stmt).executeQuery("SELECT * FROM Setup.User");
                    
                System.out.println("\n\n|---------------------------------|");
                    System.out.println("|-User table of the SetupDatabase-|");
                    System.out.println("|---------------------------------|");
                    System.out.println("|  Object Id |     Object Name    |");
                    System.out.println("|---------------------------------|");
                    while(rs.next()){
                        System.out.println("|  "+rs.getInt(1)+"  |   \t"+rs.getString(2)+"\t   |");
                       
                        System.out.println("|---------------------------------|");
                }

                System.out.println("\n Data Read\n");
            }catch(Exception e){
                System.out.println(e);
            }
        }
        public static void updateData(int id,String name){
            try{
                Statement stmt = (Statement) con.createStatement();
                ((java.sql.Statement) stmt).executeUpdate("UPDATE Setup.User SET object_name='"+name+"' WHERE Object_id="+id);
                System.out.println("Data Updated");
            }catch(Exception e){
                System.out.println(e);
            }
        }
        public static void deleteData(int id){
            try{
                Statement stmt = (Statement) con.createStatement();
                ((java.sql.Statement) stmt).executeUpdate("DELETE FROM Setup.User WHERE Object_id="+id);
                System.out.println("Data Deleted");
            }catch(Exception e){
                System.out.println(e);
            }
        }
    }
     public static void main(String[] args) throws SQLException {
        
            // we are providing user interaction using while loop and switch case
            // statements   
            DBOperations.createDB();
            DBOperations.createTable();    
            int choice = 2;
            while(choice!=0){
                //need to improve command line interface
                System.out.println("\n\n|---------------------------------|");
                System.out.println("|--Welcome to the Setup Database--|");
                System.out.println("|---------------------------------|");
                System.out.println("\nEnter your choice");
                System.out.println(" \t 1. Insert Data");
                System.out.println(" \t 2. Read Data");
                System.out.println(" \t 3. Update Data");
                System.out.println(" \t 4. Delete Data");
                System.out.println(" \t 0. Exit\n\n");
                try{

                    choice = Integer.parseInt(System.console().readLine());
                    
                    switch(choice){

                        case 1:
                        System.out.println("Enter Object Id");
                        int id = Integer.parseInt(System.console().readLine());
                        System.out.println("Enter Object Name");
                        String name = System.console().readLine();
                        DBOperations.insertData(id, name);
                        break;
                        case 2:
                        DBOperations.readData();
                        break;
                        case 3:
                        System.out.println("Enter Object Id");
                        id = Integer.parseInt(System.console().readLine());
                        System.out.println("Enter Object Name");
                        name = System.console().readLine();
                        DBOperations.updateData(id, name);
                        break;
                        case 4:
                        System.out.println("Enter Object Id");
                        id = Integer.parseInt(System.console().readLine());
                        DBOperations.deleteData(id);
                        break;
                        case 0:
                        System.out.println("Exiting");
                        System.out.println(":~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~:");
                        break;
                        default:
                        System.out.println("Invalid Choice");
                    }
                }
                catch (Exception e) {
                        // TODO: handle exception
                        System.out.println("\t Invalid Choice Exception");
                        System.out.println("\n\tPlease Enter a valid choice");
                    }
                
                }
        
            }


        } 
    



