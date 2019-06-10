
package gestionBD;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;  
import java.sql.ResultSet;
import java.sql.SQLException;

public class asistenteBD {
  
Connection conexion = null;
Statement sentencia = null;
ResultSet resultados = null;
String driver = "org.sqlite.JDBC";
String nombreBD = "empresa.sqlite";
String url = "jdbc:sqlite:" +nombreBD;
    
    public void crearBD(){
        try{
          Class.forName(driver);   
          conexion = DriverManager.getConnection( url);
        }catch(ClassNotFoundException | SQLException e){
            
            System.out.println("Error: " + e.getMessage());
            
        }
        
        System.out.println("base de datos creada con exito");
       
        
        
        
        
       
        
        
        
    }//.
    
    public void crearTabla(){
        
        
              try{
          Class.forName(driver);   
          conexion = DriverManager.getConnection( url);
          
          
          sentencia = conexion.createStatement();
          
          String sql = "CREATE TABLE CLIENTE " +
                  "(id           INT     PRIMARY KEY NOT NULL, " +
                  "NOMBRE TEXT  NOT NULL," +
                  "APELLIDOS    TEXT    NOT NULL, " +
                  "EDAD INT)";
          
          sentencia.executeUpdate(sql);
          sentencia.close();
          conexion.close();
           
          
        }catch(ClassNotFoundException | SQLException e){
            
            System.out.println("Error: " + e.getMessage());
            
        }
        
        System.out.println("tabla creada con exito");  
        
        
        
    }//.
    //crear metodo para agregar datos a la tabla.
    //(solo debe cambiar las instrucciones de sql)
    public void agregarDatos(){
        
        
                 try{
          Class.forName(driver);   
          conexion = DriverManager.getConnection( url);
          
          
          sentencia = conexion.createStatement();
          
          String sql = "INSERT INTO CLIENTE " +
                  "(id,NOMBRE,APELLIDOS,EDAD) " +
                  "VALUES (1,'Nicolás','Mella',20) ";
                  
          
          sentencia.executeUpdate(sql);
          sentencia.close();
          conexion.close();
           
          
        }catch(ClassNotFoundException | SQLException e){
            
            System.out.println("Error: " + e.getMessage());
            
        }
        
        System.out.println("se agregaron los datos con exito");    
        
        
        
        
        
        
    }
    
    
    
    public void eliminar (){
        
         
                          try{
          Class.forName(driver);   
          conexion = DriverManager.getConnection( url);
          
          
          sentencia = conexion.createStatement();
          
          String sql = "DELETE FROM CLIENTE "+
                  "WHERE id = 1 and NOMBRE='Nicolás' and APELLIDOS='Mella' AND EDAD = 20";
          resultados = sentencia.executeQuery(sql);
          
          while (resultados.next()){
              int id = resultados.getInt("ID");
              String nombre = resultados.getString("NOMBRE");
              String apellido = resultados.getString("APELLIDOS");
              int edad = resultados.getInt("EDAD");
              
              
              System.out.println("Los datos fueron eliminados");
              
              
              
              
              
              
              
          }
                  
                  
          
          sentencia.executeUpdate(sql);
          sentencia.close();
          conexion.close();
           
          
        }catch(ClassNotFoundException | SQLException e){
            
            System.out.println("Error: " + e.getMessage());
             
    
            
        
        
        
        
    }
    }
    public void mostrardatos (){
        
        
                          try{
          Class.forName(driver);   
          conexion = DriverManager.getConnection( url);
          
          
          sentencia = conexion.createStatement();
          
          String sql = "SELECT * FROM CLIENTE ";
          resultados = sentencia.executeQuery(sql);
          
          while (resultados.next()){
              int id = resultados.getInt("ID");
              String nombre = resultados.getString("NOMBRE");
              String apellido = resultados.getString("APELLIDOS");
              int edad = resultados.getInt("EDAD");
              
              
              System.out.println("\nID "+ id +
                      "\nNombre: "+ nombre +
                      "\nAPELLIDO: "+ apellido +
                      "\nEDAD: "+edad);
              
              
              
              
              
              
              
          }
                  
                  
          
          sentencia.executeUpdate(sql);
          sentencia.close();
          conexion.close();
           
          
        }catch(ClassNotFoundException | SQLException e){
            
            System.out.println("Error: " + e.getMessage());
            
        }
        
         
            
        
        
        
        
        
        
    }
}



    
    
    
    
    
    
   


