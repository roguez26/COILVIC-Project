package mx.fei.coilvicapp.logic.estudiante;
import java.util.List;
public interface IStudent {
    
    public int insertStudent(Student student);
    public List<String> getStudentByEmail(String email);
    
}
