package ws;

import jakarta.jws.WebMethod;
import jakarta.jws.WebParam;
import jakarta.jws.WebService;

import java.util.Date;

@WebService(serviceName = "ReleveWS")
public class ReleveService {
    @WebMethod(operationName = "ConsulerRelever")
    public Releve getReleve(@WebParam(name = "rib") String rib){
        System.out.println("WebService Appelé au:"+ new Date());
        Releve releve= new Releve(rib,new Date(), 920);
        Operation operation1 = new Operation("CREDIT",  new Date(),9000, "Vers Espèce" );
        Operation operation2 = new Operation("CREDIT",  new Date(),34000, "Chèque guichet" );
        Operation operation3 = new Operation("CREDIT",  new Date(),120, "Prélèvement assurance" );
        releve.addOperation(operation1);
        releve.addOperation(operation2);
        releve.addOperation(operation3);
        System.out.println(releve);
        return releve;
    }
}
