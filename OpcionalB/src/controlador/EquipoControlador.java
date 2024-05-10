package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import modelo.Equipo;
import vista.EquipoVista;
import java.util.List;
import java.util.ArrayList;
import javax.swing.JOptionPane;

public class EquipoControlador implements ActionListener {

    private int index = -1;
    private Equipo equipito;
    private EquipoVista vista;
    private List<Equipo> listaEquipo = new ArrayList<>();

    public EquipoControlador() {
        this.vista = new EquipoVista();
        //Borrar después de probarlo
        this.vista.setVisible(false);

        this.vista.jButtonActualizar.addActionListener(this);
        this.vista.jButtonBorrar.addActionListener(this);
        this.vista.jButtonBuscar.addActionListener(this);
        this.vista.jButtonRegistrar.addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        //Registrar
        if (e.getSource() == this.vista.jButtonRegistrar) {
            equipito = new Equipo();

            equipito.setCodigo(Integer.parseInt(this.vista.jTextFieldCodigo.getText()));
            equipito.setNombre(this.vista.jTextFieldNombre.getText());

            listaEquipo.add(equipito);
            JOptionPane.showMessageDialog(this.vista, "Se ha agregado de manera exitosa El equipo: " + this.vista.jTextFieldCodigo.getText());

            this.vista.jTextFieldCodigo.setText("");
            this.vista.jTextFieldNombre.setText("");

        }

        //Buscar
        if (e.getSource() == this.vista.jButtonBuscar) {
            for (int i = 0; i < listaEquipo.size(); i++) {
                if (listaEquipo.get(i).getCodigo() == Integer.parseInt(this.vista.jTextFieldCodigo.getText())) {
                    index = i;
                    this.vista.jTextFieldNombre.setText("" + listaEquipo.get(index).getNombre());
                    JOptionPane.showMessageDialog(this.vista, "Se ha encontrado!!!");
                }
            }
            if (index == -1) {
                JOptionPane.showMessageDialog(this.vista, "No se ha encontrado el código \nCódigo que ingresaste: " + this.vista.jTextFieldCodigo.getText());
            }

        }

        //Actualizar
        if (e.getSource() == this.vista.jButtonActualizar) {
            if (index > -1 && index != -1) {
                listaEquipo.get(index).setCodigo(Integer.parseInt(this.vista.jTextFieldCodigo.getText()));
                listaEquipo.get(index).setNombre(this.vista.jTextFieldNombre.getText());
                JOptionPane.showMessageDialog(this.vista, "Se ha actualizado con éxito!");
                this.vista.jTextFieldCodigo.setText("");
                this.vista.jTextFieldNombre.setText("");
            } else if (index == -1) {
                JOptionPane.showMessageDialog(this.vista, "Error, primero debes buscar el código");
            }

        }

        //Borrar
        if (e.getSource() == this.vista.jButtonBorrar) {
            if (index > -1 && index != -1) {
                listaEquipo.remove(index);
                JOptionPane.showMessageDialog(this.vista, "Se ha borrado con éxito!");
                this.vista.jTextFieldCodigo.setText("");
                this.vista.jTextFieldNombre.setText("");
            } else if (index == -1) {
                JOptionPane.showMessageDialog(this.vista, "Error, primero debes buscar el código");
            }
        }
    }

    public int retornaIndexEquipo(int cod) {
        for (int i = 0; i < listaEquipo.size(); i++) {
            if (listaEquipo.get(i).getCodigo() == cod) {
                index = i;
                return index;
            }
        }
        return -1;
    }

    public List<Equipo> getListaEquipo() {
        return listaEquipo;
    }

    public void setListaEquipo(List<Equipo> listaEquipo) {
        this.listaEquipo = listaEquipo;
    }

    public EquipoVista getVista() {
        return vista;
    }

    public void setVista(EquipoVista vista) {
        this.vista = vista;
    }
    
    

}
