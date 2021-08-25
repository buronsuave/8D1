package agents;

/**
 * Importamos las clases necesarias para la creación de la interfaz.
 */
import java.rmi.Remote;
import java.rmi.RemoteException;

/**
 * Creamos la interfaz Agent (intermediario) en la que se describen
 * los métodos que componen al objeto que se va a compartir por RMI.
 * Es necesario extender de Remote para indicar que estos métodos 
 * arrojan la excepción RemoteException.
 */
public interface Agent extends Remote
{
    public int add(int a, int b) throws RemoteException;
    public int factorial(int n) throws RemoteException;
}
