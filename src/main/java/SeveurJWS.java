import jakarta.xml.ws.Endpoint;
import ws.ReleveService;


public class SeveurJWS {
    public static void main(String[] args) {
       Endpoint.publish("http://0.0.0.0:9191/",new ReleveService());
        System.out.println("web services déployé sur http://0.0.0.0:9191/");
    }
}
