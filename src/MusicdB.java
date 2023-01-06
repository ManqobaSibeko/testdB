import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class MusicdB {

    public static final String DB_NAME = "test1.db";
    public static final String CONN_STRING = "jdbc:sqlite:C:\\Users\\user\\IdeaProjects\\testdB\\test1.db";
    public static final String TABLE_CONTACTS = "contacts";
    public static final String COLUMN_NAME = "name";
    public static final String COLUMN_PHONE = "phone";
    public static final String COLUMN_EMAIL = "email";
    public static final String COLUMN_AGE = "age";


    public static void main(String[] args) {

        try {
            Connection conn = DriverManager.getConnection(CONN_STRING);
            //Create/delete a table by using statement object , we're going to call the connection.create method then use statement.execute method to run a SQL statement

            Statement statement = conn.createStatement();

            statement.execute("DROP TABLE IF EXISTS " + TABLE_CONTACTS);

            statement.execute("CREATE TABLE IF NOT EXISTS " + TABLE_CONTACTS +"(" +
                    COLUMN_NAME + " TEXT, " +
                    COLUMN_PHONE + " TEXT, " +
                    COLUMN_EMAIL + " TEXT, " +
                    COLUMN_AGE + " INTEGER " + ")" );

            statement.execute("INSERT INTO " + TABLE_CONTACTS+ "("
                    +COLUMN_NAME+ ","
                    +COLUMN_PHONE+","
                    + COLUMN_EMAIL+","
                    +COLUMN_AGE+")"+
                    "VALUES('Manqoba',0710584555,'manq@gmail.com',23)");

            statement.execute("INSERT INTO " + TABLE_CONTACTS+ "("
                    +COLUMN_NAME+ ","
                    +COLUMN_PHONE+","
                    + COLUMN_EMAIL+","
                    +COLUMN_AGE+")"+
                    "VALUES('Sdumo',0834158533,'kishd@gmail.com',67)");

            statement.execute("INSERT INTO " + TABLE_CONTACTS+ "("
                    +COLUMN_NAME+ ","
                    +COLUMN_PHONE+","
                    + COLUMN_EMAIL+","
                    +COLUMN_AGE+")"+
                    "VALUES('Manqoba',083525225,'mmaodod@gmail.com',19020)");

        } catch (SQLException e) {
            System.out.println("Something went wrong: " + e.getMessage());
            e.printStackTrace();
        }
    }
}