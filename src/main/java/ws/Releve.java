package ws;

import jakarta.xml.bind.annotation.XmlAttribute;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlRootElement;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
@XmlRootElement(name="releve")
public class Releve {
    private String rib;
    private Date dateReleve;
    private double solde;
    @XmlElement(name = "operation")
    private List<Operation> operations= new ArrayList<>();

    public Releve(String rib, Date dateReleve, double solde) {
        this.rib = rib;
        this.dateReleve = dateReleve;
        this.solde = solde;
    }
    public void addOperation(Operation operation){
        this.operations.add(operation);
    }

    @XmlAttribute
    public String getRib() {
        return rib;
    }

    public void setRib(String rib) {
        this.rib = rib;
    }

    public Date getDateReleve() {
        return dateReleve;
    }

    public void setDateReleve(Date dateReleve) {
        this.dateReleve = dateReleve;
    }

    public double getSolde() {
        return solde;
    }

    public void setSolde(double solde) {
        this.solde = solde;
    }

    public void setOperations(List<Operation> operations) {
        this.operations = operations;
    }

    @Override
    public String toString() {
        return "ws.Releve{" +
                "rib='" + rib + '\'' +
                ", dateReleve=" + dateReleve +
                ", solde=" + solde +
                ", operations=" + operations +
                '}';
    }

    public Releve() {
    }
}
