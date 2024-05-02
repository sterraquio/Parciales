/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import vista.AutoGUI;
import modelo.Competencia;

/**
 *
 * @author Univalle
 */
public class ControladorAutoGUI implements ActionListener{

    private AutoGUI vistaAuto;
    private Competencia compe;
    
    public ControladorAutoGUI() {
        this.compe = new Competencia();
        this.vistaAuto = new AutoGUI();
        this.vistaAuto.setVisible(true);
        
        this.vistaAuto.jButtonActua.addActionListener(this);
        this.vistaAuto.jButtonBorrar.addActionListener(this);
        this.vistaAuto.jButtonConsultar.addActionListener(this);
        this.vistaAuto.jButtonRegistrar.addActionListener(this);
    }

    
    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()== this.vistaAuto.jButtonRegistrar.getAction()){
        
        }
        if(e.getSource()== this.vistaAuto.jButtonConsultar.getAction()){
        
        }
        if(e.getSource()== this.vistaAuto.jButtonActua.getAction()){
        
        }
        if(e.getSource()== this.vistaAuto.jButtonBorrar.getAction()){
        
        }
    }
    
}
