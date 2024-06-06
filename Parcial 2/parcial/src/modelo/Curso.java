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
    private int codigoCurso;
    private Profesor unProfe = new Profesor();
    private Programa unPrograma=  new Programa();

    public Curso() {
    }

    public int getCodigoCurso() {
        return codigoCurso;
    }

    public void setCodigoCurso(int codigoCurso) {
        this.codigoCurso = codigoCurso;
    }

    public Profesor getUnProfe() {
        return unProfe;
    }

    public void setUnProfe(Profesor unProfe) {
        this.unProfe = unProfe;
    }

    public Programa getUnPrograma() {
        return unPrograma;
    }

    public void setUnPrograma(Programa unPrograma) {
        this.unPrograma = unPrograma;
    }
    
    
    
}
