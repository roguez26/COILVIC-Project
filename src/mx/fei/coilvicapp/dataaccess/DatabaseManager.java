package mx.fei.coilvicapp.dataaccess;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class DatabaseManager {
    private Connection connection;
    private final String databaseName = "jdbc:mysql://127.0.0.1/VisitasDB";
    private final String databaseUser = "---------------";
    private final String databaseUserPassword = "-----------------";
    
    private void connect() throws SQLException {
        connection = DriverManager.getConnection(databaseName, databaseUser, databaseUserPassword);
    }
    
    public void closeConnection() throws SQLException {
        if (connection != null) {
            try {
                if (!connection.isClosed()) {
                    connection.close();
                }
            } catch (SQLException exception) {
                Logger.getLogger(DatabaseManager.class.getName()).log(Level.SEVERE, null, exception);
            }
        }
    }
            
    public Connection getConnection() throws SQLException {
        connect();
        return connection;
    }
}
