package mx.fei.coilvicapp.logic.estudiante;

import mx.fei.coilvicapp.dataaccess.DatabaseManager;
import java.sql.PreparedStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
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
            
            preparedStatement.setString(1, student.getName());
            preparedStatement.setString(2, student.getPaternalSurname());
            preparedStatement.setString(3, student.getMaternalSurname());
            preparedStatement.setString(4, student.getEmail());
            preparedStatement.setString(5, student.getRegion());
            
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
    
    @Override
    public List<String> getStudentByEmail(String email) {
        List<String> students = new ArrayList<>();
        DatabaseManager databaseManager = new DatabaseManager();
        Connection connection = null;
        PreparedStatement preparedStatement = null;        
        ResultSet resultSet = null;
        String statement = "select * from estudiante where select * from estudiante where correo = ?";
        
        try {
            connection = databaseManager.getConnection();
            preparedStatement = connection.prepareStatement(statement);
            preparedStatement.setString(1, email);

            resultSet = preparedStatement.executeQuery();

            while (resultSet != null && resultSet.next()) {
                students.add(resultSet.getString("nombre"));
                students.add(resultSet.getString("apellidoPaterno"));
                students.add(resultSet.getString("apellidoMaterno"));
                students.add(resultSet.getString("correo"));
                students.add(resultSet.getString("region"));
            }
        } catch (SQLException exception) {
            Logger.getLogger(StudentDAO.class.getName()).log(Level.SEVERE, null, exception);
            return null;
        } finally {
            try {
                if (resultSet != null) {
                    resultSet.close();
                }
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
        return students;
    }

}
