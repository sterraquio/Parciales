package modelo;
import java.util.List;
import java.util.ArrayList;

public class Competencia {
    //Atributos
    private List<Marca> listaMarca = new ArrayList<>();
    private List<Equipo> listaEquipo = new ArrayList<>();
    private List<Auto> listaAuto = new ArrayList<>();

    public Competencia() {
    }

    //Methods
    public boolean regisMarca(Marca marquita){
    return false;
    }
    public boolean regisEquipo(Equipo equipito){
    return false;
    }
    public boolean regisAuto(Auto autico){
    return false;
    }
    
    public String consulMarca(int){
    
    }
    public String consulMarca(int){
    
    }
    public String consulMarca(int){
    
    }
    
    public void actualMarca(int, int, String){
    
    }
    public void actualEquipo(int, int, String){
    
    }
    public void actualAuto(int, int, String){
    
    }
    
    
    public void borrarMarca(int){
    }
    public void borrarEquipo(int){
    
    }
    public void borrarAuto(int){
    
    }
            
    //Getters and stters
    public List<Marca> getListaMarca() {
        return listaMarca;
    }

    public void setListaMarca(List<Marca> listaMarca) {
        this.listaMarca = listaMarca;
    }

    public List<Equipo> getListaEquipo() {
        return listaEquipo;
    }

    public void setListaEquipo(List<Equipo> listaEquipo) {
        this.listaEquipo = listaEquipo;
    }

    public List<Auto> getListaAuto() {
        return listaAuto;
    }

    public void setListaAuto(List<Auto> listaAuto) {
        this.listaAuto = listaAuto;
    }
    
    
}
