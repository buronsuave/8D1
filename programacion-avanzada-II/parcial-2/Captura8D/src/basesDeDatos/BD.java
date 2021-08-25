package basesDeDatos;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author David
 */
public class BD 
{    
    private Connection con;
    
    public BD()
    {
        try 
        {
            Class.forName("com.mysql.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://localhost/formulario8d1","root","");
        } 
        catch (ClassNotFoundException ex) 
        {
            
        }
        catch (SQLException ex)
        {
            
        }
    }
    
    public Connection getConnection()
    {
        return con;
    }
}
