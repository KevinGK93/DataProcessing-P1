package P1;
import java.sql.Date;

public class Reiziger {
    private String naam;
    private Date gbdatum;

    public Reiziger() {

    }
    
    public void setNaam(String naam) {
        this.naam = naam;
    }
    
    public String getNaam() {
        return naam;
    }

    public void setGbdatum(Date gbdatum) {
        this.gbdatum = gbdatum;
    }
    
    public Date getGbdatum() {
        return gbdatum;
    }
}