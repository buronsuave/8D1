package model;

/**
 *
 * @author David
 */
public class Persona 
{
    private int id;
    private String nombre;
    private boolean genero;

    public Persona() 
    {
        nombre= "no name";
        id = 0;
        genero = true;
    }

    public Persona(int id, String nombre, boolean genero) {
        this.id = id;
        this.nombre = nombre;
        this.genero = genero;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public boolean isGenero() {
        return genero;
    }

    public void setGenero(boolean genero) {
        this.genero = genero;
    }
    
    @Override
    public String toString()
    {
        return nombre;
    }    
}
