import javax.xml.ws.Endpoint;

public class App
{
    public static void main( String[] args )
    {

        String url = "http://localhost:8081/PersonWebService";
        Endpoint.publish(url, new PersonWebService());
    }
}
