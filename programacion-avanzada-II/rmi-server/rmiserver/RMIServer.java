package rmiserver;

/**
 * Importamos las librerías necesarias para las excepciones de RMI
 * y generar la instancia del objeto.
 */
import java.rmi.AlreadyBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import utils.Operations;

/**
 * Se crea la clase que contiene al programa principal del servidor.
 */
public class RMIServer 
{
    /**
     * Programa principal del servidor. Se encarga de generar y registrar
     * el objeto que será compartido por RMI
     * @param args Parámetros de la aplicación
     */
    public static void main(String[] args) 
    {
        try 
        {
            /**
             * Se hace el registro local del programa en un puerto del servidor
             * y se registra el objeto bajo un identificador de servicio (en 
             * este caso "utils")
             */
            Registry registry = LocateRegistry.createRegistry(1234);
            registry.bind("utils", new Operations());
            System.out.println("Waiting for connection");
        } 
        catch (RemoteException ex) 
        {
            System.out.println(ex.getMessage());
        } 
        catch (AlreadyBoundException ex) 
        {
            System.out.println(ex.getMessage());
        }
    }   
}
