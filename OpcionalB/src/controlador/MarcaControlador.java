package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import modelo.Marca;
import vista.MarcaVista;
import java.util.List;
import java.util.ArrayList;
import javax.swing.JOptionPane;

public class MarcaControlador implements ActionListener {

    private int index = -1;
    private Marca marca;
    private List<Marca> listaMarca = new ArrayList<>();
    private MarcaVista vista;

    public MarcaControlador() {
        this.vista = new MarcaVista();
        //Luego poner en negativo para cuando lo tenga que hacer en la clase controlador Auto
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
            marca = new Marca();

            marca.setCodigo(Integer.parseInt(this.vista.jTextFieldCodigo.getText()));
            marca.setNombre(this.vista.jTextFieldNombre.getText());
            marca.setPaisOrigen(this.vista.jTextFieldPais.getText());

            listaMarca.add(marca);
            JOptionPane.showMessageDialog(this.vista, "Se ha agregado de manera exitosa la marca: " + this.vista.jTextFieldCodigo.getText());

            this.vista.jTextFieldCodigo.setText("");
            this.vista.jTextFieldNombre.setText("");
            this.vista.jTextFieldPais.setText("");
        }

        //Buscar
        if (e.getSource() == this.vista.jButtonBuscar) {
            for (int i = 0; i < listaMarca.size(); i++) {
                if (listaMarca.get(i).getCodigo() == Integer.parseInt(this.vista.jTextFieldCodigo.getText())) {
                    index = i;
                    this.vista.jTextFieldNombre.setText("" + listaMarca.get(index).getNombre());
                    this.vista.jTextFieldPais.setText("" + listaMarca.get(index).getPaisOrigen());
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
                listaMarca.get(index).setCodigo(Integer.parseInt(this.vista.jTextFieldCodigo.getText()));
                listaMarca.get(index).setNombre(this.vista.jTextFieldNombre.getText());
                listaMarca.get(index).setPaisOrigen(this.vista.jTextFieldPais.getText());
                JOptionPane.showMessageDialog(this.vista, "Se ha actualizado con éxito!");
                this.vista.jTextFieldCodigo.setText("");
                this.vista.jTextFieldNombre.setText("");
                this.vista.jTextFieldPais.setText("");
            } else if (index == -1) {
                JOptionPane.showMessageDialog(this.vista, "Error, primero debes buscar el código");
            }

        }

        //Borrar
        if (e.getSource() == this.vista.jButtonBorrar) {
            if (index > -1 && index != -1) {
                listaMarca.remove(index);
                JOptionPane.showMessageDialog(this.vista, "Se ha borrado con éxito!");
                this.vista.jTextFieldCodigo.setText("");
                this.vista.jTextFieldNombre.setText("");
                this.vista.jTextFieldPais.setText("");
            } else if (index == -1) {
                JOptionPane.showMessageDialog(this.vista, "Error, primero debes buscar el código");
            }
        }
    }
    
    public int retornaIndexMarca(int cod){
        for (int i = 0; i < listaMarca.size(); i++) {
                if (listaMarca.get(i).getCodigo() == cod) {
                    index = i;
                    return index;
                }
            }
        return -1;
    }

    public List<Marca> getListaMarca() {
        return listaMarca;
    }

    public void setListaMarca(List<Marca> listaMarca) {
        this.listaMarca = listaMarca;
    }

    public MarcaVista getVista() {
        return vista;
    }

    public void setVista(MarcaVista vista) {
        this.vista = vista;
    }

    
    
}
