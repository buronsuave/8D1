package Models;

public class Fork 
{
    private boolean available;

    public Fork()
    {
        available = true;
    }

    public boolean isAvailable() 
    {
        return this.available;
    }

    public void setAvailable(boolean available) 
    {
        this.available = available;
    }
}
