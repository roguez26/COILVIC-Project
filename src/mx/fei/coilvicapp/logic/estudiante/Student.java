package mx.fei.coilvicapp.logic.estudiante;

public class Student {
    
    private String name;
    private String paternalSurname;
    private String maternalSurname;
    private String email;
    private String region;
    
    public String getName() {
        return name;
    }
    
    public void setName(String name) {
        this.name = name;
    }
    
    public String getPaternalSurname() {
        return paternalSurname;
    }
    
    public void setPaternalSurName(String paternalSurname) {
        this.paternalSurname = paternalSurname;
    }
    
    public String getMaternalSurname() {
        return maternalSurname;
    }
    
    public void setMaternalSurName(String maternalSurname) {
        this.maternalSurname = maternalSurname;
    }
    
    public String getEmail() {
        return email;
    }
    
    public void setEmail (String email) {
        this.email = email;
    }
    
    public String getRegion() {
        return region;
    }
    
    public void setRegion (String region) {
        this.region = region;
    }
    
}
