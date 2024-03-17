/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package mx.fei.coilvicapp.logic.InstitutionalRepresentative;
import mx.fei.coilvicapp.dataaccess.DatabaseManager;
import java.sql.PreparedStatement;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author ivanr
 */
public class InstitutionalRepresentativeDAO implements IInstitutionalRepresentative {
    
    public int insertInstitutionalRepresentative(InstitutionalRepresentative institutionalRepresentative) {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        String statement = "insert into RepresentanteInstitucional(nombre, apellidoPaterno, apellidoMaterno, correo, universidad) "
                + "values ('?', '?', '?', '?','?')";
        DatabaseManager databaseManager = new DatabaseManager();
        
        try {
            connection = databaseManager.getConnection();
            preparedStatement = connection.prepareStatement(statement);
            preparedStatement.setString(1, institutionalRepresentative.getName());
            preparedStatement.setString(2, institutionalRepresentative.getPaternalSurname());
            preparedStatement.setString(3, institutionalRepresentative.getMaternalSurname());
            preparedStatement.setString(4, institutionalRepresentative.getEmail());
            preparedStatement.setString(5, institutionalRepresentative.getUniversity()); 
            return preparedStatement.executeUpdate();      
        } catch (SQLException exception) {
            Logger.getLogger(InstitutionalRepresentativeDAO.class.getName()).log(Level.SEVERE, null, exception);
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
                Logger.getLogger(InstitutionalRepresentativeDAO.class.getName()).log(Level.SEVERE, null, exception);
            }
        }
    } 
}

