/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 *
 * @author UNIVALLE
 */
public class CursoDao {

    Conexion miConexion = new Conexion();

    Connection con;
    PreparedStatement pst;
    ResultSet rs;

 //Función para Insertar o registrar datos//////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    public boolean insertarDatos(Curso unCurso){
        String query= "INSERT INTO curso (codigoCurso, cedProfe, codigoPrograma) VALUES (?, ?, ?)";        
        
        try{
            this.con= this.miConexion.obtenerConexion();//Se asigna la conexión            
            pst= this.con.prepareStatement(query);//se prepara la consulta asignando el String que contiene el código SQL 
            
            
            
            pst.setInt(1, unCurso.getCodigoCurso()); 
            pst.setInt(2, unCurso.getUnProfe().getCedula()); 
            pst.setInt(3, unCurso.getUnPrograma().getCodigo()); 
            
            
            pst.execute();//Se ejecuta la consulta
            
            System.out.println(pst);//se imprime el script de la consulta por consola
            
            return true;
        }catch(SQLException e){
            
            JOptionPane.showMessageDialog(null, "Error al ingresar los datos: "+e.getMessage());
            return false;
        }
        
    }
    
    
     //Función para Consultar datos//////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    public Curso consultarDatos(int dato){
        String query = "SELECT * FROM curso where codigoCurso=?";
        
        
        Curso unCurso= new Curso();
        
        
        try{
            this.con= this.miConexion.obtenerConexion();//Se asigna la conexión
            pst = this.con.prepareStatement(query);//se prepara la consulta asignando el String que contiene el código SQL
            
            
            pst.setInt(1, dato);
            
            
            System.out.println("contenido del query:\n"+pst);//se imprime el script de la consulta por consola
            
            rs= pst.executeQuery();//Se ejecuta la consulta
            
            if(rs.next()){
                
                unCurso.setCodigoCurso(rs.getInt("codigoCurso"));
                unCurso.getUnProfe().setCedula(rs.getInt("cedProfe"));
                unCurso.getUnPrograma().setCodigo(rs.getInt("codigoPrograma"));
                
            }else{
                JOptionPane.showMessageDialog(null, "Usuario no Encontrado");
            }
            
        }catch(SQLException e){
            JOptionPane.showMessageDialog(null, "Error al obtener los datos de la persona: "+e);
        }
        
        return unCurso;
    }
    
    
    
    
    //Función para Eliminar datos//////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    public boolean eliminarCurso(int dato){
        String query= "DELETE FROM curso WHERE codigoCurso = "+dato;
        
        try{
            this.con= this.miConexion.obtenerConexion();//Se asigna la conexión
            pst = this.con.prepareStatement(query);//se prepara la consulta asignando el String que contiene el código SQL
            
            System.out.println(pst);//se imprime el script de la consulta por consola
            pst.execute();//Se ejecuta la consulta
            
            return true;
        }catch(SQLException e){
            JOptionPane.showMessageDialog(null, "Error al eliminar los datos: "+e);
            return false;
        }
        
    }
    
    
    //Función para Modificar datos//////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    public boolean actualizarCurso(Curso unCurso){
        String query= "UPDATE curso SET cedProfe = ?, codigoPrograma = ? WHERE codigoCurso = ?";        
        
        try{
            this.con= this.miConexion.obtenerConexion();//Se asigna la conexión        
            pst= this.con.prepareStatement(query);//se prepara la consulta asignando el String que contiene el código SQL
            
            
            pst.setInt(1, unCurso.getUnProfe().getCedula());
            pst.setInt(2, unCurso.getUnPrograma().getCodigo());
            pst.setInt(3, unCurso.getCodigoCurso());
            
            System.out.println(pst);//se imprime el script de la consulta por consola
            pst.execute();//Se ejecuta la consulta
            
            return true;
        }catch(SQLException e){
            
            JOptionPane.showMessageDialog(null, "Error al modificar los datos (Clase DAO):\n"+e);
            return false;
        }
        
    }
    
    
    
}
