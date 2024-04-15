/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Arrays;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import sistemamascotas.Can;

/**
 *
 * @author Ricardo Adrian Delgadillo Rivera 6*A T/V
 */
public class ControllerCanes {
    
        private static Connection Conexion; //Abro la conexión
        
        public Connection openConnection() {
        
        try {
            Properties propiedades = new Properties();
            propiedades.load(new FileReader("src/Controlador/propiedades.properties"));
            //Como obtener la información desde un archivo properties
            String db_nam = propiedades.getProperty("nombreBD");
            String use = propiedades.getProperty("user");
            String pas = propiedades.getProperty("password");
            String urlDB = propiedades.getProperty("urldb");
            //For MySql 5.5
            Class.forName("com.mysql.cj.jdbc.Driver");
            //Conexion = DriverManager.getConnection("jdbc:mysql://localhost:3306/" + db_nam + "?characterEncoding=latin1&useConfigs=maxPerformance", use, pas);
            //For MySql 8.0
            //Class.forName("com.mysql.cj.jdbc.Driver");
            Conexion = DriverManager.getConnection(urlDB + db_nam + "?characterEncoding=latin1&zeroDateTimeBehavior=convertToNull&serverTimezone=UTC", use, pas);
            System.out.println("Se ha iniciado la conexión con el servidor de forma exitosa");
        } catch (ClassNotFoundException | SQLException ex) {
            System.out.println(""+ex.getMessage());
        } catch (FileNotFoundException ex) {
            System.out.println(""+ex.getMessage());
        } catch (IOException ex) {
            System.out.println(""+ex.getMessage());
        }
        return Conexion;
    }

/*  ----------------------------------------------------------------------------------
    Nombre: Clase closeConnection
    Función: Cierra La Conexión con la BD
    Parametros: 
    ----------------------------------------------------------------------------------
*/
    public void closeConnection() {
        try {
            Conexion.close();
            System.out.println("Se ha finalizado la conexión con el servidor");
        } catch (SQLException ex) {
            System.out.println(""+ex.getMessage());
        }
    }
    
    /*  ----------------------------------------------------------------------------------
    Nombre: Clase insertCan
    Función: Añade la información a la bdCan
    Parametros: 
    ----------------------------------------------------------------------------------
    */
    public int insertCan(Can objCan) {
        System.out.println("Inicia: Actividad: Se inicia insertCan()");
        try {
            String Query = "INSERT INTO can VALUES(?,?,?,?,?,?,?,?,?,?,?)";
            PreparedStatement statement = Conexion.prepareStatement(Query);
            statement.setInt(1,0);
            statement.setString(2, objCan.getNombreCan());
            statement.setString(3, objCan.getRazaCan());
            statement.setString(4,objCan.getColorCan());
            statement.setString(5,objCan.getPatronCan());
            statement.setString(6, objCan.getGeneroCan());
            statement.setString(7, objCan.getTamaCan());
            statement.setString(8, objCan.getCaracteristicasCan());
            statement.setString(9, objCan.getObservacionesCan());
            statement.setTimestamp(10, objCan.getFechaInicio());
            statement.setTimestamp(11, objCan.getFechaFin());
            System.out.println("Statement: "+statement.toString());
            statement.executeUpdate();
            System.out.println("Termina: Actividad: Se inicia insertCan()");
            return 1;
        } catch (SQLException ex) {
            System.out.println("Ocurrio une error al insertarLaInformación"+ex.getMessage());
            return 0;
        }
        
    }
    /*
    *
    *
    *
    */
    
    public int editCan(Can obj,int id) {
        System.out.println("Inia: Actividad: Se inicia editCan()");
        try {
            String Query = "UPDATE can"
                    + " SET nombre_can = ?, raza_can = ?, color_can = ?, patron_can = ?, genero_can = ?,"
                    + " tama_can = ?, caracteristicas_can = ?, observaciones_can = ?, fecha_inicio = ?, fecha_fin = ?"
                    + " WHERE id = ?;";
            PreparedStatement statement = Conexion.prepareStatement(Query);
            statement.setString(1, obj.getNombreCan());
            statement.setString(2,obj.getRazaCan());
            statement.setString(3, obj.getColorCan());
            statement.setString(4, obj.getPatronCan());
            statement.setString(5, obj.getGeneroCan());
            statement.setString(6, obj.getTamaCan());
            statement.setString(7, obj.getCaracteristicasCan());
            statement.setString(8, obj.getObservacionesCan());
            statement.setTimestamp(9, obj.getFechaInicio());
            statement.setTimestamp(10, obj.getFechaFin());
            statement.setInt(11, id);
            System.out.println(""+statement.toString());
            statement.executeUpdate();
            System.out.println("Termina: Actividad: Se inicia editCan()");
            return 1;
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
            return 0;
        }
    }
    
    
    /*  ----------------------------------------------------------------------------------
    Nombre: Clase modeloCan
    Función: Añade la información a la bdCan
    Parametros: 
    ----------------------------------------------------------------------------------
    */
    
    public DefaultTableModel modeloCan(String columna[]){
        System.out.println(Arrays.toString(columna));
        DefaultTableModel modeloUsuarios = new DefaultTableModel(null, columna);
        try{
            String Sql = "SELECT * FROM can;";
            PreparedStatement us = Conexion.prepareStatement(Sql);
            ResultSet res = us.executeQuery();
            Object objDatos[] = new Object[columna.length]; //Siempre debe cconexoincidir con el numero de columnas!
            while(res.next()){
                for (int i = 0; i<columna.length; i++){
                    objDatos[i] = res.getObject(i+1);
                }
                modeloUsuarios.addRow(objDatos);
            }
        }
        catch(SQLException ex){
            System.out.println("Exception: "+ ex.getMessage());
        }
        return modeloUsuarios;
    }
    /*
    Permite eliminar un can existente
    @idCan
    */
    public int deleteCan(int idCan){
        int resp = 0;
        try {
            String Query = "DELETE FROM can WHERE id = \"" + idCan + "\"";
            Statement st = Conexion.createStatement();
            st.executeUpdate(Query);
            resp = 1;
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
            resp = 0;
        }
        return resp;
    }
    
    /*  ----------------------------------------------------------------------------------
    Nombre: Clase modeloCan
    Función: Añade la información a la bdCan
    Parametros: 
    ----------------------------------------------------------------------------------
    */
    
    public DefaultTableModel modeloCan(String columna[],String nomBuscar){
        System.out.println(Arrays.toString(columna));
        DefaultTableModel modeloUsuarios = new DefaultTableModel(null, columna);
        try{
            String Sql = "SELECT * FROM can where nombre_can like '%"+nomBuscar+"%';";
            PreparedStatement us = Conexion.prepareStatement(Sql);
            ResultSet res = us.executeQuery();
            Object objDatos[] = new Object[columna.length]; //Siempre debe cconexoincidir con el numero de columnas!
            while(res.next()){
                for (int i = 0; i<columna.length; i++){
                    objDatos[i] = res.getObject(i+1);
                }
                modeloUsuarios.addRow(objDatos);
            }
        }
        catch(SQLException ex){
            System.out.println("Exception: "+ ex.getMessage());
        }
        return modeloUsuarios;
    }
    
    
    public Can getCan(int idSeleccion) {
        System.out.println("Inicia: Actividad: Se inicia getCan()");
        Can objCan = null;
        
        /*String Query = "UPDATE can"
                    + " SET nombre_can = ?, raza_can = ?, color_can = ?, patron_can = ?, genero_can = ?,"
                    + " tama_can = ?, caracteristicas_can = ?, observaciones_can = ?, fecha_inicio = ?, fecha_fin = ?"
                    + " WHERE id = ?;";*/
        try {
            String Query = "SELECT * FROM can where id="+idSeleccion;
            Statement st = Conexion.createStatement();
            java.sql.ResultSet resultSet;
            resultSet = st.executeQuery(Query);

            while (resultSet.next()) {
                objCan = new Can(resultSet.getInt("id"),
                        resultSet.getString("nombre_can"),
                resultSet.getString("raza_can"),
                resultSet.getString("color_can"),
                resultSet.getString("patron_can"),
                resultSet.getString("genero_can"),
                resultSet.getString("tama_can"),
                resultSet.getString("caracteristicas_can"),
                resultSet.getString("observaciones_can"),
                resultSet.getTimestamp("fecha_inicio"),
                resultSet.getTimestamp("fecha_fin"));
            }
            
        System.out.println("Termina: Actividad: Se inicia getCan()");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error en la adquisición de datos");
        }
        
        return objCan;
    }
        
    
}
