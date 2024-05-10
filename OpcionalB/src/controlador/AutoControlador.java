package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import modelo.Auto;
import vista.AutoVista;
import java.util.List;
import java.util.ArrayList;
import javax.swing.JOptionPane;

public class AutoControlador implements ActionListener {

    private Auto autico;
    private MarcaControlador ctrlMarca = new MarcaControlador();
    private EquipoControlador ctrlEquip = new EquipoControlador();
    private List<Auto> listaAutos = new ArrayList<>();
    private AutoVista vista;
    private int indexEquipo = -1;
    private int indexMarca = -1;
    private int index = -1;

    public AutoControlador() {
        this.vista = new AutoVista();
        //Borrar después de probarlo
        this.vista.setVisible(true);

        this.vista.jButtonActualizar.addActionListener(this);
        this.vista.jButtonBorrar.addActionListener(this);
        this.vista.jButtonBuscar.addActionListener(this);
        this.vista.jButtonRegistrar.addActionListener(this);
        this.vista.jButtonEquipo.addActionListener(this);
        this.vista.jButtonMarca.addActionListener(this);

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        //Registrar
        if (e.getSource() == this.vista.jButtonRegistrar) {
            autico = new Auto();
            indexMarca = ctrlMarca.retornaIndexMarca(Integer.parseInt(this.vista.jTextFieldMarca.getText()));
            indexEquipo = ctrlEquip.retornaIndexEquipo(Integer.parseInt(this.vista.jTextFieldEquipo.getText()));
            if (ctrlMarca.getListaMarca().get(indexMarca).getCodigo() == Integer.parseInt(this.vista.jTextFieldMarca.getText())) {
                if (ctrlEquip.getListaEquipo().get(indexEquipo).getCodigo() == Integer.parseInt(this.vista.jTextFieldEquipo.getText())) {
                    autico.setEquipito(ctrlEquip.getListaEquipo().get(indexEquipo));
                    autico.setMarca(ctrlMarca.getListaMarca().get(indexMarca));
                    autico.setCodigo(Integer.parseInt(this.vista.jTextFieldCodigo.getText()));
                    autico.setNombrePiloto(this.vista.jTextFieldNombrePiloto.getText());

                    listaAutos.add(autico);
                    JOptionPane.showConfirmDialog(this.vista, "Se ha registrado de manera correcta");
                    this.vista.jTextFieldCodigo.setText("");
                    this.vista.jTextFieldEquipo.setText("");
                    this.vista.jTextFieldMarca.setText("");
                    this.vista.jTextFieldNombrePiloto.setText("");
                }

            } else {
                JOptionPane.showMessageDialog(this.vista, "Error con el código para identificar la marca.");
                this.vista.jTextFieldMarca.setText("");
            }

        }

        //Buscar
        if (e.getSource() == this.vista.jButtonBuscar) {
            for (int i = 0; i < listaAutos.size(); i++) {
                if (listaAutos.get(i).getCodigo() == Integer.parseInt(this.vista.jTextFieldCodigo.getText())) {
                    index = i;
                    this.vista.jTextFieldNombrePiloto.setText("" + listaAutos.get(index).getNombrePiloto());
                    this.vista.jTextFieldEquipo.setText("" + listaAutos.get(index).getEquipito().getCodigo());
                    this.vista.jTextFieldMarca.setText("" + listaAutos.get(index).getMarca().getCodigo());
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
                indexMarca = ctrlMarca.retornaIndexMarca(Integer.parseInt(this.vista.jTextFieldMarca.getText()));
                indexEquipo = ctrlEquip.retornaIndexEquipo(Integer.parseInt(this.vista.jTextFieldEquipo.getText()));
                if (ctrlMarca.getListaMarca().get(indexMarca).getCodigo() == Integer.parseInt(this.vista.jTextFieldMarca.getText())) {
                    if (ctrlEquip.getListaEquipo().get(indexEquipo).getCodigo() == Integer.parseInt(this.vista.jTextFieldEquipo.getText())) {
                        listaAutos.get(index).setCodigo(Integer.parseInt(this.vista.jTextFieldCodigo.getText()));
                        listaAutos.get(index).setNombrePiloto(this.vista.jTextFieldNombrePiloto.getText());
                        listaAutos.get(index).setEquipito(ctrlEquip.getListaEquipo().get(indexEquipo));
                        listaAutos.get(index).setMarca(ctrlMarca.getListaMarca().get(indexMarca));
                        JOptionPane.showMessageDialog(this.vista, "Se ha actualizado con éxito!");
                        this.vista.jTextFieldCodigo.setText("");
                        this.vista.jTextFieldEquipo.setText("");
                        this.vista.jTextFieldMarca.setText("");
                        this.vista.jTextFieldNombrePiloto.setText("");
                    } else {
                        JOptionPane.showMessageDialog(this.vista, "Error con el código para identificar el equipo.");
                        this.vista.jTextFieldEquipo.setText("");
                    }
                } else {
                    JOptionPane.showMessageDialog(this.vista, "Error con el código para identificar la marca.");
                    this.vista.jTextFieldMarca.setText("");
                }
            } else if (index == -1) {
                JOptionPane.showMessageDialog(this.vista, "Error, primero debes buscar el código");
            }

        }

        //Borrar
        if (e.getSource() == this.vista.jButtonBorrar) {
            if (index > -1 && index != -1) {
                listaAutos.remove(index);
                JOptionPane.showMessageDialog(this.vista, "Se ha borrado con éxito!");
                this.vista.jTextFieldCodigo.setText("");
                this.vista.jTextFieldEquipo.setText("");
                this.vista.jTextFieldMarca.setText("");
                this.vista.jTextFieldNombrePiloto.setText("");
            } else if (index == -1) {
                JOptionPane.showMessageDialog(this.vista, "Error, primero debes buscar el código");
            }
        }
        //Marca
        if (e.getSource() == this.vista.jButtonMarca) {
            ctrlMarca.getVista().setVisible(true);
        }
        //Equipo
        if (e.getSource() == this.vista.jButtonEquipo) {
            ctrlEquip.getVista().setVisible(true);
        }
    }

}
