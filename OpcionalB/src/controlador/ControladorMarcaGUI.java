/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import vista.MarcaGUI;
import modelo.Competencia;

/**
 *
 * @author Univalle
 */
public class ControladorMarcaGUI implements ActionListener{

    private Competencia compe;
    private MarcaGUI vistaMarca;
    public ControladorMarcaGUI() {
        this.compe = new Competencia();
        this.vistaMarca = new MarcaGUI();
        this.vistaMarca.setVisible(true);
        
        this.vistaMarca.jButtonActua.addActionListener(this);
        this.vistaMarca.jButtonBorrar.addActionListener(this);
        this.vistaMarca.jButtonConsultar.addActionListener(this);
        this.vistaMarca.jButtonRegistrar.addActionListener(this);
        
        
        
    }

    
    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==this.vistaMarca.jButtonRegistrar.getAction()){
        
        }
        if(e.getSource()==this.vistaMarca.jButtonConsultar.getAction()){
        
        }
        if(e.getSource()==this.vistaMarca.jButtonActua.getAction()){
        
        }
        if(e.getSource()==this.vistaMarca.jButtonBorrar.getAction()){
        
        }
    }
    
}
