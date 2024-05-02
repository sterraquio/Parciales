/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import vista.EquipoGUI;
import modelo.Competencia;

/**
 *
 * @author Univalle
 */
public class ControladorEquipoGUI implements ActionListener{

    private EquipoGUI vistaEquipo;
    private Competencia compe;

    public ControladorEquipoGUI() {
     this.compe = new Competencia();
     this.vistaEquipo = new EquipoGUI();
     this.vistaEquipo.setVisible(true);
     
     this.vistaEquipo.jButtonRegistrar.addActionListener(this);
     this.vistaEquipo.jButtonConsultar.addActionListener(this);
     this.vistaEquipo.jButtonActua.addActionListener(this);
     this.vistaEquipo.jButtonBorrar.addActionListener(this);
     
    }
    
    
    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()== this.vistaEquipo.jButtonRegistrar.getAction()){
        
        }
        if(e.getSource()== this.vistaEquipo.jButtonConsultar.getAction()){
        
        }
        if(e.getSource()== this.vistaEquipo.jButtonActua.getAction()){
        
        }
        if(e.getSource()== this.vistaEquipo.jButtonBorrar.getAction()){
        
        }
    }
    
}
