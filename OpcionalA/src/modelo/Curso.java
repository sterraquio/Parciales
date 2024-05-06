/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;

/**
 *
 * @author UNIVALLE
 */
public class Curso {

    public Curso() {
    }
    
    private int codigo;
    private String nombre;
    private ProgramaAcademico programaAca;
    private Profesor profe;

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public ProgramaAcademico getProgramaAca() {
        return programaAca;
    }

    public void setProgramaAca(ProgramaAcademico programaAca) {
        this.programaAca = programaAca;
    }

    public Profesor getProfe() {
        return profe;
    }

    public void setProfe(Profesor profe) {
        this.profe = profe;
    }
    
    
    
}
