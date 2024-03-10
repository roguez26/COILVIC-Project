package mx.fei.coilvicapp.logic.estudiante;

import mx.fei.coilvicapp.logic.estudiante.Student;
import mx.fei.coilvicapp.logic.estudiante.IStudent;
import mx.fei.coilvicapp.dataaccess.DatabaseManager;
import java.sql.PreparedStatement;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class StudentDAO implements IStudent{
    
    @Override 
    public int insertStudent(Student student) {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        String statement = "insert into estudiante(nombre, apellidoPaterno, apellidoMaterno, correo, region) "
                + "values ('?', '?', '?', '?','?')";
        DatabaseManager databaseManager = new DatabaseManager();
        
        try {
            connection = databaseManager.getConnection();
            preparedStatement = connection.prepareStatement(statement);
             /*
            preparedStatement.setString(1);
            preparedStatement.setString(2);
            preparedStatement.setString(3);
            preparedStatement.setString(4);
            preparedStatement.setString(5); */
            
            return preparedStatement.executeUpdate();      
        } catch (SQLException exception) {
            Logger.getLogger(StudentDAO.class.getName()).log(Level.SEVERE, null, exception);
            return -1;
        } finally {
            try {
                if (preparedStatement != null) {
                    preparedStatement.close();
                }
                if (connection != null) {
                    connection.close();
                }               
            } catch (SQLException exception) {
                Logger.getLogger(StudentDAO.class.getName()).log(Level.SEVERE, null, exception);
            }
        }
    }

}
