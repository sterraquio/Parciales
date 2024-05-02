/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import vista.CompetenciaGUI;

/**
 *
 * @author Univalle
 */
public class ControladorCompetenciaGUI implements ActionListener{

    private CompetenciaGUI vistaCompe;
    public ControladorCompetenciaGUI() {
        this.vistaCompe = new CompetenciaGUI();
        this.vistaCompe.setVisible(true);
        
        this.vistaCompe.jButtonAuto.addActionListener(this);
        this.vistaCompe.jButtonEquipo.addActionListener(this);
        this.vistaCompe.jButtonMarca.addActionListener(this);
    }

    
    
    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == this.vistaCompe.jButtonAuto.getAction()){
        ControladorAutoGUI autico = new ControladorAutoGUI();
        }
        if(e.getSource() == this.vistaCompe.jButtonEquipo.getAction()){
        ControladorEquipoGUI equipito = new ControladorEquipoGUI();
        }
        if(e.getSource() == this.vistaCompe.jButtonMarca.getAction()){
        ControladorMarcaGUI marquita = new ControladorMarcaGUI();
        }
        
    }
    
}
