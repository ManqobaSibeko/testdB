import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class Main {
    public static void main(String[] args) {

        //Creating the database in this folder/ or connecting to the db

        //Set up a connection string when using JDBC 4.0 and above
        // 2.DriverManager.getConnection that accepts the connection string and returns a connection instance
        // This will create a database file by default if there is none
//
//       try (Connection conn = DriverManager.getConnection("jdbc:sqlite:C:\\Users\\user\\IdeaProjects\\testdB\\test.db");
//            Statement statement = conn.createStatement();){
           //Creating the database in this folder/ or connecting to the db

           //Set up a connection string when using JDBC 4.0 and above
           // 2.DriverManager.getConnection that accepts the connection string and returns a connection instance
           // This will create a database file by default if there is none
            try{
           Connection conn = DriverManager.getConnection("jdbc:sqlite:C:\\Users\\user\\IdeaProjects\\testdB\\test.db");

           //Creating a table by using statement object , we're going to call the connection.create method then use statement.execute method to run a SQL statement
           //

           Statement statement = conn.createStatement();
           statement.execute("CREATE TABLE IF NOT EXISTS Contacts" +
                   " (name TEXT,phone INTEGER,email TEXT)");
           statement.execute("INSERT INTO Contacts (name,phone,email)"+
                           "VALUES('Tim',27710584555,'manq@gmail.com')");
           statement.close();
                conn.close();

           //method may throw a SQL Exception that's why we're trying to catch that
       }catch(SQLException e){
            System.out.println("Something went wrong: "+ e.getMessage());
        }


    }
}

//there actually two ways of establishing connection using JDBC 4.0 1 is data source object and 2 driver
//Data source object is sometimes the preferred way and that's because it allows advanced features like connection pooling and distributed transactions
//We don't need these feature when using sqlite and really only needed when working wit complex systems and java enterprise edition application