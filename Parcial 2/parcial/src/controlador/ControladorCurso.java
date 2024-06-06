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
import modelo.Curso;
import modelo.CursoDao;
import vista.CursoVista;
import vista.ProfesorVista;
import vista.ProgramaVista;

public class ControladorCurso implements ActionListener {

    private Curso unCurso;
    private CursoDao unCursoDao;
    private ControladorProfesor ControlProfe;
    private ControladorPrograma controladorPrograma;
    private CursoVista vistaCurso;

    public ControladorCurso() {
        this.unCurso = new Curso();
        this.unCursoDao = new CursoDao();
        this.vistaCurso = new CursoVista();

        this.vistaCurso.setVisible(true);
        this.vistaCurso.jButtonConsultar.addActionListener(this);
        this.vistaCurso.jButtonEliminar.addActionListener(this);
        this.vistaCurso.jButtonInsertar.addActionListener(this);
        this.vistaCurso.jButtonListar.addActionListener(this);
        this.vistaCurso.jButtonListarCedula.addActionListener(this);
        this.vistaCurso.jButtonModificar.addActionListener(this);
        this.vistaCurso.jButtonProfesor.addActionListener(this);
        this.vistaCurso.jButtonPrograma.addActionListener(this);

    }

    @Override
    public void actionPerformed(ActionEvent e) {

        //Agregar curso
        if (e.getSource() == this.vistaCurso.jButtonInsertar) {
            try {
                this.unCurso.setCodigoCurso(Integer.parseInt(this.vistaCurso.jTextFieldCodigoCurso.getText()));
                this.unCurso.getUnProfe().setCedula(Integer.parseInt(this.vistaCurso.jTextFieldCedulaProfe.getText()));
                this.unCurso.getUnPrograma().setCodigo(Integer.parseInt(this.vistaCurso.jTextFieldCodigoPrograma.getText()));

                if (this.unCursoDao.insertarDatos(this.unCurso)) {
                    JOptionPane.showMessageDialog(this.vistaCurso, "SE HA REGISTRADOOOOO");
                } else {
                    JOptionPane.showMessageDialog(this.vistaCurso, "error");
                }

            } catch (NumberFormatException number) {
                JOptionPane.showMessageDialog(this.vistaCurso, "error: " + number);
            }

            eliminarTextField();
        }
        if (e.getSource() == this.vistaCurso.jButtonListar) {
        }
        if (e.getSource() == this.vistaCurso.jButtonListarCedula) {
        }

        if (e.getSource() == this.vistaCurso.jButtonModificar) {
            try {
                this.unCurso.setCodigoCurso(Integer.parseInt(this.vistaCurso.jTextFieldCodigoCurso.getText()));
                this.unCurso.getUnProfe().setCedula(Integer.parseInt(this.vistaCurso.jTextFieldCedulaProfe.getText()));
                this.unCurso.getUnPrograma().setCodigo(Integer.parseInt(this.vistaCurso.jTextFieldCodigoPrograma.getText()));

                if (this.unCursoDao.actualizarCurso(unCurso)) {
                    JOptionPane.showMessageDialog(this.vistaCurso, "ACTUALIZADOOOOOOOOOOOO");
                } else {
                    JOptionPane.showMessageDialog(this.vistaCurso, "error");
                }
            } catch (NumberFormatException number) {
                JOptionPane.showMessageDialog(this.vistaCurso, "error: " + number);
            }
            eliminarTextField();

        }

        //Borrar curso x codCurso
        if (e.getSource() == this.vistaCurso.jButtonEliminar) {
            try {
                if (this.unCursoDao.eliminarCurso(Integer.parseInt(this.vistaCurso.jTextFieldCodigoCurso.getText()))) {
                    JOptionPane.showMessageDialog(this.vistaCurso, "SE HA BORRADDDDOOOOOOOOOOOO");
                } else {
                    JOptionPane.showMessageDialog(this.vistaCurso, "error");
                }
            } catch (NumberFormatException number) {
                JOptionPane.showMessageDialog(this.vistaCurso, "error: " + number);
            }

        }

        // Consultar curso x codigo curso
        if (e.getSource() == this.vistaCurso.jButtonConsultar) {

            try {
                this.unCurso = this.unCursoDao.consultarDatos(Integer.parseInt(this.vistaCurso.jTextFieldCodigoCurso.getText()));

                this.vistaCurso.jTextFieldCedulaProfe.setText(this.unCurso.getUnProfe().getCedula() + "");
                this.vistaCurso.jTextFieldCodigoPrograma.setText(this.unCurso.getUnPrograma().getCodigo() + "");

            } catch (NumberFormatException number) {
                JOptionPane.showMessageDialog(this.vistaCurso, "error: " + number);
            }

        }

        //Hechooooooooooooooo
        if (e.getSource() == this.vistaCurso.jButtonProfesor) {
            this.ControlProfe = new ControladorProfesor();

        }
        if (e.getSource() == this.vistaCurso.jButtonPrograma) {

            this.controladorPrograma = new ControladorPrograma();
        }

    }

    public void eliminarTextField() {
        this.vistaCurso.jTextFieldCedulaProfe.setText("");
        this.vistaCurso.jTextFieldCodigoCurso.setText("");
        this.vistaCurso.jTextFieldCodigoPrograma.setText("");

    }

}
