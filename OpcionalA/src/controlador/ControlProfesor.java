/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import modelo.Profesor;
import vista.ProfesorGUI;

/**
 *
 * @author UNIVALLE
 */
public class ControlProfesor implements ActionListener {

    private Profesor unProfe;
    private ProfesorGUI vistaProfe;
    private List<Profesor> listaProfesor = new ArrayList<>();
    private int index = -1;

    public ControlProfesor() {
        this.vistaProfe = new ProfesorGUI();

        //this.vistaProfe.setVisible(true);

        this.vistaProfe.jButtonGuardar.addActionListener(this);
        this.vistaProfe.jButtonActualizar.addActionListener(this);
        this.vistaProfe.jButtonBuscar.addActionListener(this);
        this.vistaProfe.jButtonBorrar.addActionListener(this);

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        //Agregar
        if (e.getSource() == this.vistaProfe.jButtonGuardar) {
            unProfe = new Profesor();
            unProfe.setCedula(Integer.parseInt(this.vistaProfe.jTextFieldCedula.getText()));
            unProfe.setNombres(this.vistaProfe.jTextFieldNombres.getText());
            unProfe.setApellidos(this.vistaProfe.jTextFieldApellidos.getText());
            unProfe.setProfesion(this.vistaProfe.jTextFieldProfesion.getText());

            listaProfesor.add(unProfe);
            JOptionPane.showMessageDialog(this.vistaProfe, "Se ha registrado el Profesor correctamente");
            this.vistaProfe.jTextFieldCedula.setText("");
            this.vistaProfe.jTextFieldNombres.setText("");
            this.vistaProfe.jTextFieldApellidos.setText("");
            this.vistaProfe.jTextFieldProfesion.setText("");
        }
        //Buscar
        if (e.getSource() == this.vistaProfe.jButtonBuscar) {
            for (int i = 0; i < this.listaProfesor.size(); i++) {
                if (this.listaProfesor.get(i).getCedula() == Integer.parseInt(this.vistaProfe.jTextFieldCedula.getText())) {
                    index = i;
                    this.vistaProfe.jTextFieldNombres.setText(this.listaProfesor.get(i).getNombres());
                    this.vistaProfe.jTextFieldApellidos.setText(this.listaProfesor.get(i).getApellidos());
                    this.vistaProfe.jTextFieldProfesion.setText(this.listaProfesor.get(i).getProfesion());
                    break;
                }
            }
            if (index == -1) {
                JOptionPane.showMessageDialog(this.vistaProfe, "La cedula no se encuentra");
            }
        }

        //actualizar
        if (e.getSource() == this.vistaProfe.jButtonActualizar) {
            if (index != -1) {

                this.listaProfesor.get(index).setCedula(Integer.parseInt(this.vistaProfe.jTextFieldCedula.getText()));
                this.listaProfesor.get(index).setNombres(this.vistaProfe.jTextFieldNombres.getText());
                this.listaProfesor.get(index).setApellidos(this.vistaProfe.jTextFieldApellidos.getText());
                this.listaProfesor.get(index).setProfesion(this.vistaProfe.jTextFieldProfesion.getText());
                JOptionPane.showMessageDialog(this.vistaProfe, "Fue actualizado el profesor con cedula: " + this.listaProfesor.get(index).getCedula());
                this.vistaProfe.jTextFieldCedula.setText("");
                this.vistaProfe.jTextFieldNombres.setText("");
                this.vistaProfe.jTextFieldApellidos.setText("");
                this.vistaProfe.jTextFieldProfesion.setText("");
            } else {
                JOptionPane.showMessageDialog(this.vistaProfe, "Número de cedula no encontrada");
            }

            //Borrar
        }
        if (e.getSource() == this.vistaProfe.jButtonBorrar) {
            if (index != -1) {
                this.listaProfesor.remove(index);
                JOptionPane.showMessageDialog(this.vistaProfe, "El profesor se ha removido de manera CORRECTA");
                this.vistaProfe.jTextFieldCedula.setText("");
                this.vistaProfe.jTextFieldNombres.setText("");
                this.vistaProfe.jTextFieldApellidos.setText("");
                this.vistaProfe.jTextFieldProfesion.setText("");
            } else {
                JOptionPane.showMessageDialog(this.vistaProfe, "Número de cedula no encontrada");
            }
        }
    }

    public int getIndexProfesor(int ced) {
        for (int i = 0; i < this.listaProfesor.size(); i++) {
            if (this.listaProfesor.get(i).getCedula() == ced) {
                index = i;
                return index;
            }
        }
        return -1;
    }

    //Getters and setters
    public Profesor getUnProfe() {
        return unProfe;
    }

    public void setUnProfe(Profesor unProfe) {
        this.unProfe = unProfe;
    }

    public ProfesorGUI getVistaProfe() {
        return vistaProfe;
    }

    public void setVistaProfe(ProfesorGUI vistaProfe) {
        this.vistaProfe = vistaProfe;
    }

    public List<Profesor> getListaProfesor() {
        return listaProfesor;
    }

    public void setListaProfesor(List<Profesor> listaProfesor) {
        this.listaProfesor = listaProfesor;
    }

    public int getIndex() {
        return index;
    }

    public void setIndex(int index) {
        this.index = index;
    }
}
