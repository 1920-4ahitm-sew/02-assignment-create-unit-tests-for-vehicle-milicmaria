package at.htl.vehicle;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import static junit.framework.TestCase.fail;


public class VehicleTest {

    public static final String DRIVER_STRING = "org.apache.derby.jdbc.ClientDriver";
    static final String CONNECTION_STRING = "jdbc:derby://localhost:1527/db;create=true";
    static final String USER = "app";
    static final String PASSWORD = "app";
    private static Connection conn;

    @BeforeClass
    public static void initJdbc(){
        try {
            Class.forName(DRIVER_STRING);
            conn = DriverManager.getConnection(CONNECTION_STRING, USER, PASSWORD);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            System.out.println("Verbindung zur Datenbank nicht möglich:\n" + e.getMessage() + "\n");
            System.exit(1);
        }
    }

    @AfterClass
    public static void teardownJdbc(){
        try {
            if(conn != null || !conn.isClosed()){
                conn.close();
                System.out.println("Goodbye!");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void firstTest(){
        fail();
    }




}
