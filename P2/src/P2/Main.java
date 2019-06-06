package P2;

import java.sql.Date;
import java.sql.SQLException;
import java.util.*;

public class Main{
	public static void main(String[] arg) throws SQLException {
		ReizigerOracleDaolmpl ro1 = new ReizigerOracleDaolmpl();
		OVChipkaartOracleDAOImpl ov1 = new OVChipkaartOracleDAOImpl();

		// loop 
		 System.out.println("Alle reizigers: ");
		 List<Reiziger> reizigers = ro1.findAll();
		 for (Reiziger reiziger : reizigers) {
		 	System.out.println("Reiziger: #" +reiziger.getReizigerID() + " "+reiziger.getVoorletters()+ ". "+ reiziger.getTussenvoegsel()+" "+reiziger.getAchternaam()+ " geboortedatum: " +reiziger.getGbdatum());
		 }

		// find reizigers by date
		 System.out.println("\nGevonden reizigers: ");
		 List<Reiziger> gevonden_reizigers = ro1.findByGBdatum("1990-12-23");
		 for (Reiziger gevonden_reiziger : gevonden_reizigers) {
		 	System.out.println("Reiziger: #" +gevonden_reiziger.getReizigerID() + " "+gevonden_reiziger.getVoorletters()+ ". "+ gevonden_reiziger.getTussenvoegsel()+" "+gevonden_reiziger.getAchternaam()+ " geboortedatum: " +gevonden_reiziger.getGbdatum());
		 }
		
		// laatste loop
		System.out.println("Alle OvChipkarten: ");
		List<Ovchipkaart> ovchipkarten = ov1.findAll();
		for (Ovchipkaart ovchipkaart : ovchipkarten) {
			System.out.println("Ovchipkaart: #" +ovchipkaart.getKaartnummer() + " "+ovchipkaart.getGeldigtot()+ ". "+ ovchipkaart.getKlasse()+" "+ovchipkaart.getSaldo()+ " rezigerID: " +ovchipkaart.getReizigerid());
		}	
	}
}