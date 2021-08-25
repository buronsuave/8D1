package utils;

/**
 * Importamos las librerías necesarias para el manejo de RemoteException 
 * y el UnicastRemoteObject. 
 */
import agents.Agent;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

/**
 * Creamos la clase del objeto que se busca compartir vía RMI. Esta clase
 * debe extender de UnicastRemoteObject para establecer que la respuesta
 * se realizará vía RMI. En este ejemplo, la respuesta se da en Unicast. 
 * También debe implementar la interfaz diseñada como intermediario (en
 * este ejemplo, Agent).
 */
public class Operations extends UnicastRemoteObject implements Agent 
{
    /**
     * Desarrollamos el constructor vacío de la clase. Dentro de ella
     * debe implementar el constructor de la clase base (Unicast Remote
     * Object, en este caso)
     * @throws RemoteException
     */
    public Operations() throws RemoteException
    {
        super();
    }
     
    /**
     * Se implementa el primer método descrito en la interfaz del
     * intermediario. Es necesario indicar el @Override y debe arrojar
     * la excepción de RemoteException
     * @param a Primer sumando
     * @param b Segundo sumando
     * @return Resultado de a+b
     * @throws RemoteException 
     */
    @Override
    public int add(int a, int b) throws RemoteException
    {
        return a+b;
    }
    
    /**
     * Se implementa el primer método descrito en la interfaz del
     * intermediario. Es necesario indicar el @Override y debe arrojar
     * la excepción de RemoteException
     * @param n Numero para obtener el factorial
     * @return Factorial de n
     * @throws RemoteException 
     */
    @Override
    public int factorial(int n) throws RemoteException
    {
        return (n==0) ? 1 : n*factorial(n-1);  
    }
}
