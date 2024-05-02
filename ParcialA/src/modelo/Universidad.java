package modelo;

import java.util.ArrayList;
import java.util.List;

public class Universidad {

    //Atributos
    private List<Profesor> listaProfesores = new ArrayList<>();
    private List<Cursos> listaCursos = new ArrayList<>();

    //Constructor
    public Universidad() {
    }

    //Getters and setters
    public List<Profesor> getListaProfesores() {
        return listaProfesores;
    }

    public void setListaProfesores(List<Profesor> listaProfesores) {
        this.listaProfesores = listaProfesores;
    }

    public List<Cursos> getListaCursos() {
        return listaCursos;
    }

    public void setListaCursos(List<Cursos> listaCursos) {
        this.listaCursos = listaCursos;
    }

    //********************************************************************************************************************************************************************
    //Métodos
    //Clase profesor
    public void registrarProfe(Profesor profe) {
        this.listaProfesores.add(profe);
    }

    public String ConsultarProfe(int cod) {
        for (int i = 0; i <= this.listaProfesores.size(); i++) {
            if (this.listaProfesores.get(i).getCedula() == cod) {

                String profesorsito = "Nombre: "
                        + this.listaProfesores.get(i).getNombres() + "Apellido: "
                        + this.listaProfesores.get(i).getApellidos() + "Cedula: "
                        + this.listaProfesores.get(i).getCedula() + "Profesión: "
                        + this.listaProfesores.get(i).getProfesion();
                return profesorsito;
            }
        }
        return "No hay profesor";
    }

    public void actualizarModificarProfe(int cod, int cambio, String cambios) {

        for (int i = 0; i <= this.listaProfesores.size() - 1; i++) {
            if (this.listaProfesores.get(i).getCedula() == cod) {

                if (cambio == 1) {
                    this.listaProfesores.get(i).setNombres(cambios);
                }
                if (cambio == 2) {
                    this.listaProfesores.get(i).setCedula(Integer.parseInt(cambios));
                }
                if (cambio == 3) {
                    this.listaProfesores.get(i).setApellidos(cambios);
                }
                if (cambio == 4) {
                    this.listaProfesores.get(i).setProfesion(cambios);
                }
            }
        }

    }

    public void borrarProfe(int cod) {
        for (int i = 0; i <= this.listaProfesores.size() - 1; i++) {
            if (this.listaProfesores.get(i).getCedula() == cod) {

                this.listaProfesores.remove(i);
            }
        }
    }

    //********************************************************************************************************************************************************************
    //Clase curso
    public void registrarCurso(Cursos cursito) {
        this.listaCursos.add(cursito);
    }

    public String consultarCurso(int cod) {
        for (int i = 0; i <= this.listaCursos.size(); i++) {
            if (this.listaCursos.get(i).getCodCuso() == cod) {
                String cursito = "Código del curso: "
                        + this.listaCursos.get(i).getCodCuso() + "Nombre del curso: "
                        + this.listaCursos.get(i).getNombreCurso() + "Carrera en que se dicta: "
                        + this.listaCursos.get(i).getCarreraDicta() + "Profesor que dicta curso: "
                        + this.listaCursos.get(i).getProfesorDicta();
                return cursito;
            }
        }
        return "No hay cursos con ese código.";
    }

    public void actualizarModificarCurso(int cod, int cambio, String cambios) {
        for (int i = 0; i <= this.listaCursos.size() - 1; i++) {
            if (this.listaCursos.get(i).getCodCuso() == cod) {

                if (cambio == 1) {
                    this.listaCursos.get(i).setCarreraDicta(cambios);
                }
                if (cambio == 2) {
                    this.listaCursos.get(i).setCodCuso(Integer.parseInt(cambios));
                }
                if (cambio == 3) {
                    this.listaCursos.get(i).setNombreCurso(cambios);
                }
                if (cambio == 4) {
                    this.listaCursos.get(i).setProfesorDicta(cambios);
                }
            }
        }

    }

    public void borrarCurso(int cod) {
        for (int i = 0; i <= this.listaCursos.size() - 1; i++) {
            if (this.listaCursos.get(i).getCodCuso() == cod) {
                this.listaCursos.remove(i);
            }
        }
    }
}
