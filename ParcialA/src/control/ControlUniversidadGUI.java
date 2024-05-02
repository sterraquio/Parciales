/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package control;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import modelo.Cursos;
import modelo.Profesor;
import modelo.Universidad;
import vista.UniversidadGUI;

/**
 *
 * @author sterr
 */
public class ControlUniversidadGUI implements ActionListener {

    //atributes
    private Cursos cursito;
    private Profesor profe;
    private Universidad uni;
    private UniversidadGUI vistaUni;

    //metohds
    public ControlUniversidadGUI() {
        this.cursito = new Cursos();
        this.profe = new Profesor();
        this.uni = new Universidad();
        this.vistaUni = new UniversidadGUI();

        this.vistaUni.setVisible(true);
        this.vistaUni.jButton1.addActionListener(this);
        this.vistaUni.jButton2.addActionListener(this);
        this.vistaUni.jButton3.addActionListener(this);
        this.vistaUni.jButton4.addActionListener(this);
        this.vistaUni.jButton5.addActionListener(this);
        this.vistaUni.jButton6.addActionListener(this);
        this.vistaUni.jButton7.addActionListener(this);
        this.vistaUni.jButton8.addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == this.vistaUni.jButton1) {
            ControlProfesorGUI ctrlProfe = new ControlProfesorGUI();
            //
        }
        if (e.getSource() == this.vistaUni.jButton2) {
            ControlCursosGUI ctrlCurso = new ControlCursosGUI();
        }
        if (e.getSource() == this.vistaUni.jButton3) {
            int a = Integer.parseInt(vistaUni.jTextField1.getText());
            JOptionPane.showMessageDialog(null, uni.ConsultarProfe(a));
        }
        if (e.getSource() == this.vistaUni.jButton4) {
            int a = Integer.parseInt(vistaUni.jTextField1.getText());
            int cambio;
            String cambios = "";
            try {
                cambio = Integer.parseInt(JOptionPane.showInputDialog("Ingrese los cambio que desea hacer. \n1.Cambiar el nombre, \n2. Cambiar cédula. \n3. Cambiar apellidos. \n4. Cambiar profesión"));
                if (cambio >= 1 && cambio <= 4) {
                    cambios = JOptionPane.showInputDialog("Ingrese los cambios");
                    uni.actualizarModificarProfe(a, cambio, cambios);
                } else {
                    JOptionPane.showMessageDialog(null, "Error, el numero para los cambios son de 1 a 4");
                }
            } catch (IndexOutOfBoundsException error) {

            }

        }
        if (e.getSource() == this.vistaUni.jButton5) {
            int a = Integer.parseInt(vistaUni.jTextField1.getText());
            uni.borrarProfe(a);
            JOptionPane.showMessageDialog(null, "Borrado con éxito");
        }
        if (e.getSource() == this.vistaUni.jButton6) {
            int a = Integer.parseInt(vistaUni.jTextField1.getText());
            JOptionPane.showMessageDialog(null, uni.consultarCurso(a));
        }
        if (e.getSource() == this.vistaUni.jButton7) {
            int a = Integer.parseInt(vistaUni.jTextField1.getText());
            int cambio;
            String cambios = "";
            try {
                cambio = Integer.parseInt(JOptionPane.showInputDialog("Ingrese los cambio que desea hacer. \n1.Cambiar el nombre, \n2. Cambiar cédula. \n3. Cambiar apellidos. \n4. Cambiar profesión"));
                if (cambio >= 1 && cambio <= 4) {
                    cambios = JOptionPane.showInputDialog("Ingrese los cambios");
                    uni.actualizarModificarCurso(a, cambio, cambios);
                } else {
                    JOptionPane.showMessageDialog(null, "Error, el numero para los cambios son de 1 a 4");
                }
            } catch (IndexOutOfBoundsException error) {

            }
        }
        if (e.getSource() == this.vistaUni.jButton8) {
            int a = Integer.parseInt(vistaUni.jTextField1.getText());
            uni.borrarCurso(a);
            JOptionPane.showMessageDialog(null, "Borrado con éxito");
        }
    }

}
