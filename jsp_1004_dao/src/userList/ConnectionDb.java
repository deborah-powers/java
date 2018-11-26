package userList;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;

public class ConnectionDb {
	protected String user = "root";
	protected String password = "";
	protected String urlBase = "jdbc:mysql://localhost/";
	protected String driver = "com.mysql.cj.jdbc.Driver";
	public Connection connection = null;
	public String dbName;

	public ArrayList<String> ObjectById_array (String tableName, int id) throws SQLException {
		ArrayList<String> object = null;
		// pr�parer la requ�te
		String strSelect = "SELECT * FROM "+ tableName +" WHERE id=?";
		PreparedStatement requestSelect = connection.prepareStatement (strSelect);
		requestSelect.setInt (1, id);
		// lancer la requ�te
		ResultSet responseSelect = requestSelect.executeQuery();
		// r�cup�rer les donn�es
		int nbColumns = getNbcolumns (responseSelect);
		if (responseSelect.next()){
			object = new ArrayList<String>();
			for (int i=1; i<= nbColumns; i++) object.add (responseSelect.getString (i));
		}
		return object;
	}
	public HashMap<String, String> objectToMap (ArrayList<String> columnsNames, ArrayList<String> object){
		HashMap<String, String> objectMap = new HashMap<String, String>();
		int nbColumns = columnsNames.size();
		for (int i=0; i< nbColumns; i++) objectMap.put (columnsNames.get(i), object.get(i));
		return objectMap;
	}
	public ArrayList<ArrayList<String>> getTable (String tableName) throws SQLException {
		// pr�parer la requ�te
		String strSelect = "SELECT * FROM "+ tableName;
		PreparedStatement requestSelect = connection.prepareStatement (strSelect);
		// lancer la requ�te
		ResultSet responseSelect = requestSelect.executeQuery();
		// r�cup�rer les donn�es
		ArrayList<ArrayList<String>> objectList = null;
		int nbColumns = getNbcolumns (responseSelect);
		if (responseSelect.next()){
			objectList = new ArrayList<ArrayList<String>>();
			// r�cup�rer la premi�re ligne
			ArrayList<String> object = new ArrayList<String>();
			for (int i=1; i<= nbColumns; i++) object.add (responseSelect.getString (i));
			objectList.add (object);
			// r�cup�rer les autres
			while (responseSelect.next()){
				object = new ArrayList<String>();
				for (int i=1; i<= nbColumns; i++) object.add (responseSelect.getString (i));
				objectList.add (object);
			}
		}
		return objectList;
	}
	public ArrayList<HashMap<String, String>> tableToMap (String tableName) throws SQLException {
		// r�cup�rer les donn�es
		ArrayList<ArrayList<String>> objectList = getTable (tableName);
		ArrayList<String> columnsNames = getColumnsNames (tableName);
		// cr�er la liste de map
		ArrayList<HashMap<String, String>> objectListMap = new ArrayList<HashMap<String, String>>();
		for (ArrayList<String> object: objectList) objectListMap.add (objectToMap (columnsNames, object));
		return objectListMap;
	}
	public ArrayList<String> getColumnsNames (String tableName) throws SQLException {
		// pr�parer la requ�te
		String strSelect = "SELECT * FROM "+ tableName;
		PreparedStatement requestSelect = connection.prepareStatement (strSelect);
		// lancer la requ�te
		ResultSet responseSelect = requestSelect.executeQuery();
		ArrayList<String> columnsNames = getColumnsNames (responseSelect);
		return columnsNames;
	}
	public ArrayList<String> getColumnsNames (ResultSet response) throws SQLException {
		ResultSetMetaData metadata = response.getMetaData();
		int nbColumns = metadata.getColumnCount();
		ArrayList<String> columnsNames = getColumnsNames (metadata, nbColumns);
		return columnsNames;
	}
	public ArrayList<String> getColumnsNames (ResultSetMetaData metadata, int nbColumns) throws SQLException {
		ArrayList<String> columnsNames = new ArrayList<String>();
		for (int i=1; i<= nbColumns; i++) columnsNames.add (metadata.getColumnName (i));
		return columnsNames;
	}
	public int getNbcolumns (ResultSetMetaData metadata) throws SQLException { return metadata.getColumnCount(); }
	public int getNbcolumns (ResultSet response) throws SQLException {
		ResultSetMetaData metadata = response.getMetaData();
		return metadata.getColumnCount();
	}
	protected void makeConnection(){
		String url = urlBase + dbName + "?serverTimezone=UTC";
		try {
			Class.forName (driver);
			connection = DriverManager.getConnection (url, user, password);
		}
		catch (ClassNotFoundException e){ System.err.println ("manque peut-�tre le mysql-connector.jar: "+ e.getMessage()); }
		catch (SQLException e){ System.err.println ("echec de connection: "+ e.getMessage()); }
	}
	public ConnectionDb (String dbName){
		this.dbName = dbName;
		makeConnection();
	}
	public ConnectionDb (){ this ("formation"); }
}
