import networkCore.*;
import networkCore.server.*;
import java.lang.*;

public class server 
{
    public static void main(String para[])
    {
	threadServer t_server = new threadServer(10000);
	t_server.start();
	System.out.println("Server Starts Sucessfully.");
	
    }
}
