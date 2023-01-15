import jakarta.xml.bind.JAXBContext;
import jakarta.xml.bind.JAXBException;
import jakarta.xml.bind.Marshaller;
import ws.Operation;
import ws.Releve;

import java.io.*;
import java.util.Date;

public class XMLSerialization {
    public static void main(String[] args) throws JAXBException, IOException {
        Releve releve = new Releve("011112222333344445555666", new Date(),14500);
        Operation operation1 = new Operation("CREDIT",  new Date(),9000, "Vers Espèce" );
        Operation operation2 = new Operation("CREDIT",  new Date(),34000, "Chèque guichet" );
        Operation operation3 = new Operation("CREDIT",  new Date(),120, "Prélèvement assurance" );
        releve.addOperation(operation1);
        releve.addOperation(operation2);
        releve.addOperation(operation3);

        System.out.println(releve);

        JAXBContext jc = JAXBContext.newInstance(Releve.class);
        Marshaller marshaller = jc.createMarshaller();

        marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
        marshaller.marshal(releve, System.out);
            OutputStream os = new FileOutputStream( "²" );
        marshaller.marshal( releve, os );
        os.close();
        //System.out.println(objectToXml(jc, releve));


//        SAXParserFactory spf = SAXParserFactory.newInstance();
//        SAXParser sp = spf.newSAXParser();
//        XMLReader xr = sp.getXMLReader();
//
//        JAXBContext jc = JAXBContext.newInstance("src.main.java", ws.Releve.class.getClassLoader());
//        Marshaller marshaller = jc.createMarshaller();
//        marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
//        marshaller.marshal(releve, System.out);
//        JAXBContext contextA = JAXBContext.newInstance(ws.Operation.class);
//        JAXBElement<ws.Releve> jaxbElementA = new JAXBElement(new QName("releve"), ws.Releve.class, releve);
//        JAXBSource sourceA = new JAXBSource(contextA, jaxbElementA);
//        Marshaller marshaller = contextA.createMarshaller();
//        marshaller.marshal(releve, System.out);

//        JAXBContext jaxbCtx = JAXBContext.newInstance(ws.Releve.class);
//        Marshaller marshaller = jaxbCtx.createMarshaller();
//        marshaller.marshal(releve, System.out);
//        OutputStream os = new FileOutputStream( "C:\\Users\\nchao\\releve\\src\\main\\java\\nosferatu.xml" );
//        marshaller.marshal( releve, os );
    }

    public static String objectToXml(JAXBContext jaxbContext, Object object) throws JAXBException
    {
        StringWriter writerTo = new StringWriter();
        Marshaller marshaller = jaxbContext.createMarshaller();
        marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
        marshaller.marshal(object, writerTo); //create xml string from the input object
        return writerTo.toString();
    }
}
