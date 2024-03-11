package mx.fei.coilvicapp.logic.estudiante;

public interface IStudent {
    
    public int insertStudent(Student student);
    public List<String> getStudentByEmail(String email);
    
}
