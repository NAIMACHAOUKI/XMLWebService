import jakarta.xml.bind.JAXBContext;
import jakarta.xml.bind.JAXBException;
import jakarta.xml.bind.Unmarshaller;
import ws.Releve;

import java.io.File;

public class XMLDeserialization {
    public static void main(String[] args) throws JAXBException {
        JAXBContext jaxbContext =JAXBContext.newInstance(Releve.class);
        Unmarshaller unmarshaller = jaxbContext.createUnmarshaller();
        Releve releve= (Releve) unmarshaller.unmarshal(new File("releve.xml"));
        System.out.println(releve);
    }
}
