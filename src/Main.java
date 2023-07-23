import java.sql.Statement;

import javax.naming.spi.DirStateFactory.Result;

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
                while(rs.next()){
                    System.out.println(rs.getInt(1)+" "+rs.getString(2));
                }

                System.out.println("Data Read");
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
        try {
            DBOperations.createDB();
            DBOperations.createTable();
            // DBOperations.insertData(2,"Rakell");
            // DBOperations.updateData(1,"Rakesh");
            DBOperations.deleteData(2);
            DBOperations.readData();

        } catch (Exception e) {
            // TODO: handle exception
            System.out.println(e);
        }
    }


}
