package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import modelo.Curso;
import vista.CursoGUI;
import java.util.List;
import java.util.ArrayList;
import javax.swing.JOptionPane;

public class ControlCurso implements ActionListener {

    private Curso unCurso;
    private CursoGUI vista;
    private List<Curso> listaCurso = new ArrayList<>();
    private int index = -1;
    private ControlProfesor ctrProfe = new ControlProfesor();
    private ControlProgramaAcademico ctrPrograma = new ControlProgramaAcademico();
    private int codProfe;
    private int codPrograma;

    //Constructor
    public ControlCurso() {
        this.vista = new CursoGUI();
        this.vista.setVisible(true);

        this.vista.jButtonGuardar.addActionListener(this);
        this.vista.jButtonActualizar.addActionListener(this);
        this.vista.jButtonBuscar.addActionListener(this);
        this.vista.jButtonBorrar.addActionListener(this);

        this.vista.jButtonProfesor.addActionListener(this);
        this.vista.jButtonPrograma.addActionListener(this);

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == this.vista.jButtonGuardar) {
            unCurso = new Curso();
            unCurso.setCodigo(Integer.parseInt(this.vista.jTextFieldCodigo.getText()));
            unCurso.setNombre(this.vista.jTextFieldNombre.getText());

            codProfe = ctrProfe.getIndexProfesor(Integer.parseInt(this.vista.jTextFieldCodProfe.getText()));
            codPrograma = ctrPrograma.getIndexPrograma(Integer.parseInt(this.vista.jTextFieldCodPrograma.getText()));

            if (codProfe != -1) {
                if (codPrograma != -1) {
                    unCurso.setProfe(ctrProfe.getListaProfesor().get(codProfe));
                    unCurso.setProgramaAca(ctrPrograma.getListaPrograma().get(codPrograma));

                    listaCurso.add(unCurso);
                    JOptionPane.showMessageDialog(this.vista, "Se ha registrado el Programa Academico correctamente");
                    this.vista.jTextFieldCodigo.setText("");
                    this.vista.jTextFieldNombre.setText("");
                    this.vista.jTextFieldCodProfe.setText("");
                    this.vista.jTextFieldCodPrograma.setText("");
                } else {
                    JOptionPane.showMessageDialog(this.vista, "El código del Programa Academico ingresado es incorrecto");
                }
            } else {
                JOptionPane.showMessageDialog(this.vista, "El código del profesor ingresado es incorrecto");
            }
        }

        //Buscar
        if (e.getSource() == this.vista.jButtonBuscar) {
            for (int i = 0; i < this.listaCurso.size(); i++) {
                if (this.listaCurso.get(i).getCodigo() == Integer.parseInt(this.vista.jTextFieldCodigo.getText())) {
                    index = i;
                    this.vista.jTextFieldNombre.setText(this.listaCurso.get(i).getNombre());
                    this.vista.jTextFieldCodProfe.setText("" + this.listaCurso.get(i).getProfe().getCedula());
                    this.vista.jTextFieldCodPrograma.setText("" + this.listaCurso.get(i).getProgramaAca().getcodigo());
                    break;
                }
            }
            if (index == -1) {
                JOptionPane.showMessageDialog(this.vista, "El código no se encuentra");
            }
        }

        //actualizar
        if (e.getSource() == this.vista.jButtonActualizar) {
            if (index != -1) {

                this.listaCurso.get(index).setCodigo(Integer.parseInt(this.vista.jTextFieldCodigo.getText()));
                this.listaCurso.get(index).setNombre(this.vista.jTextFieldNombre.getText());
                codProfe = ctrProfe.getIndexProfesor(Integer.parseInt(this.vista.jTextFieldCodProfe.getText()));
                codPrograma = ctrPrograma.getIndexPrograma(Integer.parseInt(this.vista.jTextFieldCodPrograma.getText()));
                if (codProfe != -1) {
                    if (codPrograma != -1) {
                        
                        unCurso.setProgramaAca(ctrPrograma.getListaPrograma().get(codPrograma));
                        unCurso.setProgramaAca(ctrPrograma.getListaPrograma().get(codPrograma));
                        
                        this.listaCurso.get(index).setProfe(ctrProfe.getListaProfesor().get(codProfe));
                        
                        JOptionPane.showMessageDialog(this.vista, "Fue actualizado el Programa Academico con cedula: " + this.listaCurso.get(index).getCodigo());
                        this.vista.jTextFieldCodigo.setText("");
                        this.vista.jTextFieldNombre.setText("");
                        this.vista.jTextFieldCodProfe.setText("");
                        this.vista.jTextFieldCodPrograma.setText("");
                    } else {
                        JOptionPane.showMessageDialog(this.vista, "El código del Programa Academico ingresado es incorrecto");
                    }
                } else {
                    JOptionPane.showMessageDialog(this.vista, "El código del profesor ingresado es incorrecto");
                }

                this.vista.jTextFieldCodigo.setText("");
                this.vista.jTextFieldNombre.setText("");
                this.vista.jTextFieldCodPrograma.setText("");
                this.vista.jTextFieldCodProfe.setText("");
            } else {
                JOptionPane.showMessageDialog(this.vista, "El código no se encontra");
            }

            //Borrar
        }
        if (e.getSource() == this.vista.jButtonBorrar) {
            if (index != -1) {
                this.listaCurso.remove(index);
                JOptionPane.showMessageDialog(this.vista, "El Programa Academico se ha removido de manera CORRECTA");
                this.vista.jTextFieldCodigo.setText("");
                this.vista.jTextFieldNombre.setText("");
                this.vista.jTextFieldCodPrograma.setText("");
                this.vista.jTextFieldCodProfe.setText("");
            } else {
                JOptionPane.showMessageDialog(this.vista, "El código no se ha encontrado");
            }
        }
        if(e.getSource()== this.vista.jButtonProfesor){
        ctrProfe.getVistaProfe().setVisible(true);
        }
        if(e.getSource()== this.vista.jButtonPrograma){
        ctrPrograma.getVista().setVisible(true);
        }
        
    }

}
