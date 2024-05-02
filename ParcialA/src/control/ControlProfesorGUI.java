/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package control;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import modelo.Profesor;
import vista.ProfesorGUI;
import modelo.Universidad;

public class ControlProfesorGUI implements ActionListener {
    
    private Profesor profe;
    private ProfesorGUI profeGUI;
    private Universidad uni;
    
    public ControlProfesorGUI() {
        profe = new Profesor();
        this.profeGUI = new ProfesorGUI();
        this.uni = new Universidad();
        
        this.profeGUI.setVisible(true);
        this.profeGUI.jButton1.addActionListener(this);
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == this.profeGUI.jButton1) {
            profe.setCedula(Integer.parseInt(this.profeGUI.jTextField1.getText()));
            profe.setNombres(this.profeGUI.jTextField2.getText());
            profe.setApellidos(this.profeGUI.jTextField3.getText());
            profe.setProfesion(this.profeGUI.jTextField4.getText());
            
            this.uni.registrarProfe(profe);
            this.profeGUI.dispose();
        }
        
    }
    
}
