package exceptions;

/**
 *
 * @author David
 */
public class InvalidIdException extends Exception 
{
    public InvalidIdException(String message, Throwable throwable)
    {
        super(message, throwable);
    }
}
