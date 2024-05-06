package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import modelo.ProgramaAcademico;
import vista.ProgramaAcademicoGUI;
import java.util.List;
import java.util.ArrayList;
import javax.swing.JOptionPane;

public class ControlProgramaAcademico implements ActionListener {

    //Atributos
    private ProgramaAcademico academico;
    private ProgramaAcademicoGUI vista;
    private List<ProgramaAcademico> listaPrograma = new ArrayList<>();
    private int index = -1;

    //Constructor
    public ControlProgramaAcademico() {
        this.vista = new ProgramaAcademicoGUI();

        //this.vista.setVisible(true);

        this.vista.jButtonGuardar.addActionListener(this);
        this.vista.jButtonActualizar.addActionListener(this);
        this.vista.jButtonBuscar.addActionListener(this);
        this.vista.jButtonBorrar.addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        //Agregar
        if (e.getSource() == this.vista.jButtonGuardar) {
            academico = new ProgramaAcademico();
            academico.setcodigo(Integer.parseInt(this.vista.jTextFieldCodigo.getText()));
            academico.setNombre(this.vista.jTextFieldNombre.getText());

            listaPrograma.add(academico);
            JOptionPane.showMessageDialog(this.vista, "Se ha registrado el Programa Academico correctamente");
            this.vista.jTextFieldCodigo.setText("");
            this.vista.jTextFieldNombre.setText("");

        }
        //Buscar
        if (e.getSource() == this.vista.jButtonBuscar) {
            for (int i = 0; i < this.listaPrograma.size(); i++) {
                if (this.listaPrograma.get(i).getcodigo() == Integer.parseInt(this.vista.jTextFieldCodigo.getText())) {
                    index = i;
                    this.vista.jTextFieldNombre.setText(this.listaPrograma.get(i).getNombre());
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

                this.listaPrograma.get(index).setcodigo(Integer.parseInt(this.vista.jTextFieldCodigo.getText()));
                this.listaPrograma.get(index).setNombre(this.vista.jTextFieldNombre.getText());
                JOptionPane.showMessageDialog(this.vista, "Fue actualizado el Programa Academico con cedula: " + this.listaPrograma.get(index).getcodigo());
                this.vista.jTextFieldCodigo.setText("");
                this.vista.jTextFieldNombre.setText("");
            } else {
                JOptionPane.showMessageDialog(this.vista, "El código no se encontra");
            }

            //Borrar
        }
        if (e.getSource() == this.vista.jButtonBorrar) {
            if (index != -1) {
                this.listaPrograma.remove(index);
                JOptionPane.showMessageDialog(this.vista, "El Programa Academico se ha removido de manera CORRECTA");
                this.vista.jTextFieldCodigo.setText("");
                this.vista.jTextFieldNombre.setText("");
            } else {
                JOptionPane.showMessageDialog(this.vista, "El código no se ha encontrado");
            }
        }

    }

    public int getIndexPrograma(int cod) {

        for (int i = 0; i < this.listaPrograma.size(); i++) {
            if (this.listaPrograma.get(i).getcodigo() == cod) {
                index = i;
                return index;
            }
        }
        return -1;

    }

    //Getter and setters
    public ProgramaAcademico getAcademico() {
        return academico;
    }

    public void setAcademico(ProgramaAcademico academico) {
        this.academico = academico;
    }

    public ProgramaAcademicoGUI getVista() {
        return vista;
    }

    public void setVista(ProgramaAcademicoGUI vista) {
        this.vista = vista;
    }

    public List<ProgramaAcademico> getListaPrograma() {
        return listaPrograma;
    }

    public void setListaPrograma(List<ProgramaAcademico> listaPrograma) {
        this.listaPrograma = listaPrograma;
    }

    public int getIndex() {
        return index;
    }

    public void setIndex(int index) {
        this.index = index;
    }

}
