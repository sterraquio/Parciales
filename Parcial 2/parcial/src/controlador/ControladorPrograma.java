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
import modelo.Programa;
import modelo.ProgramaDao;
import vista.ProgramaVista;

public class ControladorPrograma implements ActionListener {

    private Programa unPrograma;
    private ProgramaDao unProgramaDao;
    private ProgramaVista vista;

    public ControladorPrograma() {
        this.unPrograma = new Programa();
        this.unProgramaDao = new ProgramaDao();
        this.vista = new ProgramaVista();

        this.vista.setVisible(true);
        this.vista.jButtonConsultar.addActionListener(this);
        this.vista.jButtonEliminar.addActionListener(this);
        this.vista.jButtonInsertar.addActionListener(this);
        this.vista.jButtonListar.addActionListener(this);
        this.vista.jButtonModificar.addActionListener(this);

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == this.vista.jButtonInsertar) {
            this.unPrograma.setCodigo(Integer.parseInt(this.vista.jTextFieldCodigo.getText()));
            this.unPrograma.setNombre(this.vista.jTextFieldNombrePrograma.getText());
            if(this.unProgramaDao.insertarDatos(unPrograma)){
            JOptionPane.showMessageDialog(this.vista, "SE HA REGISTRADOOOOO");
            }else{
            JOptionPane.showMessageDialog(this.vista, "Error");
            }
            eliminarTextField();
        }
        if (e.getSource() == this.vista.jButtonListar) {
        }
        if (e.getSource() == this.vista.jButtonConsultar) {
            this.unPrograma = this.unProgramaDao.consultarPrograma(Integer.parseInt(this.vista.jTextFieldCodigo.getText()));
            this.vista.jTextFieldNombrePrograma.setText(this.unPrograma.getNombre());
            JOptionPane.showMessageDialog(this.vista, "Código del programa: " + this.unPrograma.getCodigo() + "\nNombre del programa: "+this.unPrograma.getNombre());            
        }
        if (e.getSource() == this.vista.jButtonModificar) {
            this.unPrograma.setCodigo(Integer.parseInt(this.vista.jTextFieldCodigo.getText()));
            this.unPrograma.setNombre(this.vista.jTextFieldNombrePrograma.getText());
            
            if(this.unProgramaDao.actualizarPrograma(unPrograma)){
            JOptionPane.showMessageDialog(this.vista, "SE HA MODIFICADOOOOOO");
            }else{
            JOptionPane.showMessageDialog(this.vista, "error");
            }
            eliminarTextField();
        }
        if (e.getSource() == this.vista.jButtonEliminar) {
            if(this.unProgramaDao.eliminarPrograma(Integer.parseInt(this.vista.jTextFieldCodigo.getText()))){
            JOptionPane.showMessageDialog(this.vista, "SE BORROOOOOOOOOOO");
            }else{
            JOptionPane.showMessageDialog(this.vista, "error");
            }
            eliminarTextField();
        }

    }

    public void eliminarTextField() {
        this.vista.jTextFieldCodigo.setText("");
        this.vista.jTextFieldNombrePrograma.setText("");

    }
}
