package P3;

import java.sql.Date;
import java.sql.SQLException;
import java.util.*;

public class Main{
public static void main(String[] arg) throws SQLException {

		// impl opvragen
		ReizigerOracleDaolmpl ro1 = new ReizigerOracleDaolmpl();
		OVChipkaartOracleDAOImpl ov1 = new OVChipkaartOracleDAOImpl();


		// alle reizigers na lopen
		System.out.println("Alle reizigers: ");
		List<Reiziger> reizigers = ro1.findAll();
		for (Reiziger reiziger : reizigers) {
			System.out.println("Reiziger: #" +reiziger.getReizigerID() + " "+reiziger.getVoorletters()+ ". "+ reiziger.getTussenvoegsel()+" "+reiziger.getAchternaam()+ " geboortedatum: " +reiziger.getGbdatum());
		}

		// alle ovchipkaarten nalopen
		 System.out.println("\nAlle OvChipkaarten: ");
		 List<Ovchipkaart> ovchipkarten = ov1.findAll();
		 for (Ovchipkaart ovchipkaart : ovchipkarten) {
		 	System.out.println("Ovchipkaart: #" +ovchipkaart.getKaartnummer() + " Geldig tot:"+ovchipkaart.getGeldigtot()+ ", Klasse:"+ ovchipkaart.getKlasse()+", Saldo:"+ovchipkaart.getSaldo()+ " rezigerID: " +ovchipkaart.getReizigerid());
		 }
	}
}