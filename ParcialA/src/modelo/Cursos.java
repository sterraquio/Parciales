/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;
import modelo.Profesor;
/**
 *
 * @author UNIVALLE
 */
public class Cursos {
   //Atributos
    private int codCuso;
    private String nombreCurso;
    private String carreraDicta;
    private String profesorDicta;
    
    
    //métodos
    //Constructor
    public Cursos() {    
    }

    //Getters y setters
    public int getCodCuso() {
        return codCuso;
    }

    public void setCodCuso(int codCuso) {
        this.codCuso = codCuso;
    }

    public String getNombreCurso() {
        return nombreCurso;
    }

    public void setNombreCurso(String nombreCurso) {
        this.nombreCurso = nombreCurso;
    }

    public String getCarreraDicta() {
        return carreraDicta;
    }

    public void setCarreraDicta(String carreraDicta) {
        this.carreraDicta = carreraDicta;
    }

    public String getProfesorDicta() {
        return profesorDicta;
    }

    public void setProfesorDicta(String profesorDicta) {
        this.profesorDicta = profesorDicta;
    }

    
    
    
}
