/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package generasp.sqlserver;

import java.sql.*;
import java.util.Properties;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

/**
 *
 * @author riddick
 */
public class GeneraSPSQLSERVER {

    private static Properties PROPS;
    private static String SALIDA = "";
    private static String ENTIDAD = "";

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        //getAPIS();
        try {
            PROPS = new Properties();
            PROPS.load(Conexion.class.getResourceAsStream("system.properties"));
            SALIDA = PROPS.getProperty("salida").trim();
            ENTIDAD = PROPS.getProperty("entidad").trim();
            String linea = "";
            linea +="Create Procedure SP_"+ENTIDAD   +"\r";
            linea +="-- GENERADO POR: Syswarp SRL "+"\r";
            linea +="-- OBJETIVO: Generar CRUD del Objeto "+ ENTIDAD + "\r";
            linea +="-- ULTIMA MODIFICACION: ?? "+"\r";
            linea +="-- RESPONSABLE: ??"+"\r";
            linea +="-------------------------------------------------------------------------------"+"\r";
            linea +=""+"\r";
            linea +=""+"\r";
            linea +=""+"\r";
            linea +=""+"\r";
            linea +=""+"\r";
            linea +=""+"\r";
            linea +=""+"\r";
            linea +=""+"\r";
            linea +=""+"\r";
            linea +=""+"\r";
            linea +=""+"\r";
            linea +=""+"\r";
            
            
            
            
            
            String archivo = SALIDA + ENTIDAD + ".sql";

            crearArchivo(archivo, linea);

        } catch (Exception ex) {
            System.out.println("Problemas con el archivo system.properties, por favor revisar." + ex);
        }

    }

    private static ResultSet getAPIS() {
        ResultSet salida = null;
        try {
            Conexion c = new Conexion();
            c.setConexionLocal();
            Connection conn = c.getConexionLocal();
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery("select * FROM  sysobjects");
            salida = rs;
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return salida;

    }

    private static void crearArchivo(String filename, String datos) throws IOException {
        try {
            File file = new File(filename);
            if (!file.exists()) {
                file.createNewFile();
            }
            FileWriter fw = new FileWriter(file);
            BufferedWriter bw = new BufferedWriter(fw);
            bw.write(datos);
            bw.close();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

}
