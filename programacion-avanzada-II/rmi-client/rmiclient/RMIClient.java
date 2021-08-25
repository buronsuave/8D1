package rmiclient;

/**
 * Importamos las librerías necesarias para las excepciones de RMI
 * y generar la instancia del objeto.
 */
import agents.Agent;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

/**
 * Se crea la clase que contiene al programa principal del cliente.
 */
public class RMIClient 
{
    /**
     * 
     * @param args Parámetros de la aplicación
     */
    public static void main(String[] args) 
    {
        try 
        {
            /**
             * Se crea la conexión con el servidor, indicando su dirección
             * y el puerto donde quedó registrado el servidor. Se crea un
             * intermediario (Agent) a partir de la interfaz que existe entre
             * tanto en el servidor y en el cliente. Finalmente, utilizamos 
             * los métodos definidos en la interfaz. Notemos que agent nos 
             * da una conexión con la instancia del objeto registrada bajo 
             * "utils" en el servidor
             */
            Registry registry = LocateRegistry.getRegistry("localhost", 1234);
            Agent agent = (Agent) registry.lookup("utils");
            int a = 10, b = 15, n = 4;
            System.out.println("Adding 10+15=" + agent.add(a, b));
            System.out.println("Factorial " + agent.factorial(n));
        } 
        catch (RemoteException ex) 
        {
            System.out.println(ex.getMessage());
        } catch (NotBoundException ex) 
        {
            System.out.println(ex.getMessage());
        }
    }
}
