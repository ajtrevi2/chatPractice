package Background;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.Socket;
import Background.*;
public class Server
{
    Socket pocket;
    PrintWriter writer;
    protected void setUpNetworking()
    {
        try
        {
            pocket = new Socket("127.0.0.1", 5000);
            writer = new PrintWriter(pocket.getOutputStream());
        }
        catch (IOException ex)
        {
            ex.printStackTrace();
        }
    }
}
