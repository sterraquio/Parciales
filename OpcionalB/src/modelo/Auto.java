
package modelo;


public class Auto {

    public Auto() {
    }
    
    private int codigo;
    private Marca marca;
    private Equipo equipito;
    private String nombrePiloto;

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public Marca getMarca() {
        return marca;
    }

    public void setMarca(Marca marca) {
        this.marca = marca;
    }

    public Equipo getEquipito() {
        return equipito;
    }

    public void setEquipito(Equipo equipito) {
        this.equipito = equipito;
    }

    public String getNombrePiloto() {
        return nombrePiloto;
    }

    public void setNombrePiloto(String nombrePiloto) {
        this.nombrePiloto = nombrePiloto;
    }
    
    
    
}
