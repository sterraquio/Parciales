/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package control;
import java.awt.event.ActionEvent;
import modelo.Cursos;
import vista.CursosGUI;
import modelo.Universidad;

import java.awt.event.ActionListener;



public class ControlCursosGUI implements ActionListener{
      private Cursos cursito;
      private CursosGUI cursitoGUI;
      private Universidad uni;

    public ControlCursosGUI() {
        cursito = new Cursos();
        this.cursitoGUI = new CursosGUI();
        this.uni = new Universidad();
        
        this.cursitoGUI.jButton1.addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == this.cursitoGUI.jButton1){
        cursito.setNombreCurso(this.cursitoGUI.jTextField1.getText());
        cursito.setCodCuso(Integer.parseInt(this.cursitoGUI.jTextField2.getText()));
        cursito.setCarreraDicta(this.cursitoGUI.jTextField3.getText());
        cursito.setProfesorDicta(this.cursitoGUI.jTextField4.getText());
        
        this.uni.registrarCurso(cursito);
        this.cursitoGUI.dispose();
        }
    }

    //Métodos getter y setters
  

    
    
}
