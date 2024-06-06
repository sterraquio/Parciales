/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import vista.ProfesorVista;
import modelo.Profesor;
import modelo.ProfesorDao;

public class ControladorProfesor implements ActionListener {

    private Profesor unProfe;
    private ProfesorDao unProfeDao;
    private ProfesorVista vista;

    public ControladorProfesor() {
        this.unProfe = new Profesor();
        this.unProfeDao = new ProfesorDao();
        this.vista = new ProfesorVista();

        this.vista.setVisible(true);
        this.vista.jButtonInsertar.addActionListener(this);
        this.vista.jButtonConsultar.addActionListener(this);
        this.vista.jButtonEliminar.addActionListener(this);
        this.vista.jButtonListar.addActionListener(this);
        this.vista.jButtonModificar.addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        //Insertar
        if (e.getSource() == this.vista.jButtonInsertar) {
            this.unProfe.setCedula(Integer.parseInt(this.vista.jTextFieldCedula.getText()));
            this.unProfe.setNombreApellido(this.vista.jTextFieldNombres.getText());

            if (this.unProfeDao.insertarDatos(unProfe)) {
                JOptionPane.showMessageDialog(this.vista, "SE HA REGISTRADO CON EXITOOOO");
            } else {
                JOptionPane.showMessageDialog(this.vista, "No se ha registrado, error");

            }
            eliminarTextField();
        }
        //Listar
        if (e.getSource() == this.vista.jButtonListar) {
            String resultado = "";
            List<Profesor> listaProfes = new ArrayList<>();
            listaProfes = this.unProfeDao.listarProfes();
            for (int i = 0; i < listaProfes.size(); i++) {
                resultado = "Cedula del profesor: " + listaProfes.get(i).getCedula() + "Cedula del profesor: " + listaProfes.get(i).getNombreApellido() + "\n";
            }
            JOptionPane.showMessageDialog(this.vista, resultado);
        }

        //Consultar
        if (e.getSource() == this.vista.jButtonConsultar) {
            this.unProfe = this.unProfeDao.consultarProfe(Integer.parseInt(this.vista.jTextFieldCedula.getText()));
            this.vista.jTextFieldNombres.setText(this.unProfe.getNombreApellido());
            JOptionPane.showMessageDialog(this.vista, "Cédula del profesor: " + this.unProfe.getCedula() + "\nNombre y Apellidos: " + this.unProfe.getNombreApellido());

        }

        //Modificar
        if (e.getSource() == this.vista.jButtonModificar) {
            this.unProfe.setCedula(Integer.parseInt(this.vista.jTextFieldCedula.getText()));
            this.unProfe.setNombreApellido(this.vista.jTextFieldNombres.getText());

            if (this.unProfeDao.actualizarDatos(unProfe)) {
                JOptionPane.showMessageDialog(this.vista, "SE MODIFICOOOOOOOOOOOOOOOOOOOOOOO");
                eliminarTextField();
            } else {
                JOptionPane.showMessageDialog(this.vista, "No se ha modificado, error");
                eliminarTextField();
            }
        }

        //Eliminar
        if (e.getSource() == this.vista.jButtonEliminar) {
            if (this.unProfeDao.eliminarProfe(Integer.parseInt(this.vista.jTextFieldCedula.getText()))) {
                JOptionPane.showMessageDialog(this.vista, "SE ELIMINOOOOOOOOOOOOOOOOOOOOOOOO");

            } else {
                JOptionPane.showMessageDialog(this.vista, "error");
            }

            eliminarTextField();
        }

    }

    public void eliminarTextField() {
        this.vista.jTextFieldCedula.setText("");
        this.vista.jTextFieldNombres.setText("");

    }
}
