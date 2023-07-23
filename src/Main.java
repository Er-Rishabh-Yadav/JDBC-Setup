import java.sql.Connection;
import java.sql.DriverManager;

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
     public static void main(String[] args) {
        Connection conn = Connector.establishConnection();

    }


}
