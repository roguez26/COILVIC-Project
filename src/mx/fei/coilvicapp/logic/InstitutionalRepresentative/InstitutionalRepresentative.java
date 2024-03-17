/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package mx.fei.coilvicapp.logic.InstitutionalRepresentative;

/**
 *
 * @author ivanr
 */
public class InstitutionalRepresentative {
    private int idInstutionalRepresentative;
    private String name;
    private String paternalSurname;
    private String maternalSurname;
    private String eMail;
    private String university;
    
   public int getIdInstitutionalRepresentative() {
    return idInstutionalRepresentative;
  }

  public String getName() {
    return name;
  }

  public String getPaternalSurname() {
    return paternalSurname;
  }

  public String getMaternalSurname() {
    return maternalSurname;
  }

  public String getEmail() {
    return eMail;
  }

  public String getUniversity() {
    return university;
  }

  public void setIdInstitutionalRepresentative(int idInstutionalRepresentative) {
    this.idInstutionalRepresentative = idInstutionalRepresentative;
  }

  public void setName(String name) {
    this.name = name;
  }

  public void setPaternalSurname(String paternalSurname) {
    this.paternalSurname = paternalSurname;
  }

  public void setMaternalSurname(String maternalSurname) {
    this.maternalSurname = maternalSurname;
  }

  public void setEmail(String eMail) {
    this.eMail = eMail;
  }

  public void setUniversity(String university) {
    this.university = university;
  }
    
}
