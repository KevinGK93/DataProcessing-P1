package P3;
import java.sql.*;
import java.sql.Date;
import java.util.*;

public class OVChipkaartProductOracleDAOImpl extends OracleBaseDao implements OVChipkaartProductDao{
	private static final List<OVChipkaartProduct> OVChipkaartProduct = null;
	private static Connection conn;
	private List<OVChipkaartProduct> ovproducten = new ArrayList<OVChipkaartProduct>();
	
	
	public List<OVChipkaartProduct> findAll() throws SQLException {
		List<Ovchipkaart> ovchipkaarten = new ArrayList<Ovchipkaart>();
		conn = OracleBaseDao.getConnection();

		String query = "SELECT * FROM ov_chipkaart";
		Statement statement = conn.createStatement();
		ResultSet result = statement.executeQuery(query);

		while (result.next()) {
			int kaartnummer = result.getInt("kaartnummer");
			Date geldigtot = result.getDate("geldigtot");
			int klasse = result.getInt("klasse");
			int saldo = result.getInt("saldo");
			int reizigerid = result.getInt("reizigerid");

			Ovchipkaart ovchipkaart = new Ovchipkaart(kaartnummer, geldigtot, klasse, saldo, reizigerid);
			ovchipkaarten.add(ovchipkaart);
		}
		conn.close();
		result.close();
		return ovchipkaarten;
	}
	
	public List<OVChipkaartProduct> findByReiziger(Reiziger reiziger) throws SQLException {
		List<Ovchipkaart> ovchipkaarten = new ArrayList<Ovchipkaart>();
		conn = OracleBaseDao.getConnection();
		
		PreparedStatement statement = conn.prepareStatement("SELECT * FROM ov_chipkaart WHERE reizigerid = ?");    
		statement.setInt(1, reiziger.getReizigerID());    
		ResultSet result = statement.executeQuery();

		while (result.next()) {
			int kaartnummer = result.getInt("kaartnummer");
			Date geldigtot = result.getDate("geldigtot");
			int klasse = result.getInt("klasse");
			int saldo = result.getInt("saldo");
			int reizigerid = result.getInt("reizigerid");

			Ovchipkaart ovchipkaart = new Ovchipkaart(kaartnummer, geldigtot, klasse, saldo, reizigerid);
			ovchipkaarten.add(ovchipkaart);;
		}
		conn.close();
		result.close();
		return OVChipkaartProduct;
	}
	
	public OVChipkaartProduct save(OVChipkaartProduct product, Ovchipkaart ovchipkaart, Reiziger reiziger)
	throws SQLException {
		conn = OracleBaseDao.getConnection();
		String query = "INSERT INTO ov_chipkaart (kaartnummer, geldigtot, klasse, saldo, reizigerid) VALUES (?, ?, ?, ?, ?)";

		PreparedStatement statement = conn.prepareStatement(query);
		statement.setInt(1, ovchipkaart.getKaartnummer());
		statement.setDate(2, ovchipkaart.getGeldigtot());
		statement.setInt(3, ovchipkaart.getKlasse());
		statement.setInt(4, ovchipkaart.getSaldo());
		statement.setInt(5, reiziger.getReizigerID());


		int rowsInserted = statement.executeUpdate();
		if (rowsInserted > 0) {
			System.out.println("Ovchipkaart toegevoegd");
		}
		conn.close();
		return ovchipkaart;
	}
	
	public OVChipkaartProduct update(OVChipkaartProduct product, Ovchipkaart ovchipkaart, Reiziger reiziger)
	throws SQLException {
		conn = OracleBaseDao.getConnection();
		String query = "UPDATE ov_chipkaart set geldigtot = ?, klasse = ?, saldo = ? WHERE kaartnummer = ? AND reizigerid = ?";

		PreparedStatement statement = conn.prepareStatement(query);
		statement.setDate(1, ovchipkaart.getGeldigtot());
		statement.setInt(2, ovchipkaart.getKlasse());
		statement.setInt(3, ovchipkaart.getSaldo());
		statement.setInt(4, ovchipkaart.getKaartnummer());
		statement.setInt(5, reiziger.getReizigerID());

		int rowsUpdated = statement.executeUpdate();
		if (rowsUpdated > 0) {
			System.out.println("ovchipkaart aangepast");
		}
		conn.close();
		return ovchipkaart;
	}
	
	public boolean delete(OVChipkaartProduct product, Ovchipkaart ovchipkaart, Reiziger reiziger) throws SQLException {
		conn = OracleBaseDao.getConnection();
		String query = "DELETE FROM ov_chipkaart WHERE kaartnummer = ? AND reizigerid = ?";

		PreparedStatement statement = conn.prepareStatement(query);
		statement.setInt(1, ovchipkaart.getKaartnummer());
		statement.setInt(2, reiziger.getReizigerID());

		int rowsDeleted = statement.executeUpdate();
		if (rowsDeleted > 0) {
			System.out.println("ovchipkaart verwijderd");
			return true;
		}
		conn.close();
		return false;
	}

	public List<OVChipkaartProduct> getOvproducten() {
		return ovproducten;
	}

	public void setOvproducten(List<OVChipkaartProduct> ovproducten) {
		this.ovproducten = ovproducten;
	}

	
}