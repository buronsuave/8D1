package basesDeDatos;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import model.Persona;

/**
 *
 * @author David
 */
public class PersonaDAO extends BD
{
    public PersonaDAO()
    {
        super();
    }
    
    public void add(Persona persona)
    {
        PreparedStatement sql;
        
        String sqlInsert;
        try
        {
            sqlInsert = "INSERT INTO persona(id, nombre, genero) VALUES (?,?,?)";
            
            sql = getConnection().prepareStatement(sqlInsert);
            sql.setInt(1, persona.getId());
            sql.setString(2, persona.getNombre());
            sql.setBoolean(3, persona.isGenero());         
            
            sql.executeUpdate();
        }
        catch (SQLException e)
        {
            System.out.println(e.getMessage());
        }
    }   
    
    public ArrayList<Persona> getAll()
    {
        try 
        {
            PreparedStatement sql ;
            ResultSet resultados;
            Persona persona;
            ArrayList<Persona> lista;
            
            sql = getConnection().prepareStatement("SELECT * FROM persona");
            resultados = sql.executeQuery();
            
            lista = new ArrayList();
            
            while (resultados.next())
            {
                persona = new Persona();
                persona.setId(resultados.getInt("id"));
                persona.setNombre(resultados.getString("nombre"));
                persona.setGenero(resultados.getBoolean("genero"));
                lista.add(persona);
            }
                
            return lista;
        } 
        catch (SQLException e) 
        {
            return null;
        }     
    }
    
    public void remove(int id) 
    {
        PreparedStatement sql;
        try
        {
            sql = getConnection().prepareStatement("DELETE FROM persona WHERE persona.id = ? ");
            sql.setInt(1, id);
            sql.executeUpdate();
        }
        catch (SQLException ex)
        {
            System.out.println(ex.getMessage());
        }      
    }
    
    public void update(int prevId, Persona persona)
    {
        PreparedStatement sql;
        try
        {
            sql = getConnection().prepareStatement("UPDATE persona SET id = ?, nombre = ?, genero = ? WHERE persona.id = ?");
            sql.setInt(1, persona.getId());
            sql.setString(2, persona.getNombre());
            sql.setBoolean(3, persona.isGenero());
            sql.setInt(4, prevId);
            sql.executeUpdate();
        }
        catch (SQLException ex)
        {
            System.out.println(ex.getMessage());
        }      
    }
    
    
    public void close()
    {
        try {
            getConnection().close();
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }
}
