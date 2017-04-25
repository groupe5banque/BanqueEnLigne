package dto;

import java.io.FileInputStream;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Iterator;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.poifs.filesystem.POIFSFileSystem;





@SuppressWarnings({ "rawtypes", "deprecation" })
public class Bourse {

	final static String URL = "jdbc:mysql://localhost:3306/banqueenligne";
	final static String LOGIN = "root";  //exemple BDD1
	final static String PASS = "projetBanque";  //exemple BDD1
	
	
	
	public Bourse () {
		try {
			 Class.forName( "com.mysql.jdbc.Driver" );
		} catch (ClassNotFoundException e) {
			System.err
					.println("Impossible de charger le pilote de BDD, ne pas oublier d'importer le fichier .jar dans le projet");
		}

	}
	

public void ActualisationBourse() {
	//
	
	ArrayList <String> values= new ArrayList<String>();
	Connection con ;
	Statement ps ;
	PreparedStatement prepare;
	
	try {
		
		InputStream input= new FileInputStream ("cac40.xls");
		POIFSFileSystem fs= new POIFSFileSystem(input);
		HSSFWorkbook wb= new HSSFWorkbook(fs);
		HSSFSheet sheet = wb.getSheetAt(0);
		Iterator rows=sheet.rowIterator();
		
		// Effacer les précédentes valeurs de la table
		
		
		con = DriverManager.getConnection(URL, LOGIN, PASS);
		ps = con.createStatement();
		String delete = String.format("TRUNCATE TABLE bourse");	
		int del = ps.executeUpdate(delete);
		
			
		while (rows.hasNext()) {
			values.clear();
			HSSFRow row = (HSSFRow) rows.next();
			Iterator cells = row.cellIterator();
			
			while (cells.hasNext()) {
				HSSFCell cell=(HSSFCell) cells.next();
				
				if (HSSFCell.CELL_TYPE_NUMERIC == cell.getCellType())
					values.add(Double.toString((double)cell.getNumericCellValue()));
				else if(HSSFCell.CELL_TYPE_STRING == cell.getCellType())
					values.add(cell.getStringCellValue());
					
			}
				
		
		// insertion base de données  
		
			prepare = con.prepareStatement("INSERT INTO bourse (nomEnt,ouverture,haut,bas,volume,veille,actuel,variation) VALUES (?,?,?,?,?,?,?,?)");
		    prepare.setString(1,values.get(0));
		    prepare.setString(2,values.get(1));
		    prepare.setString(3,values.get(2));
		    prepare.setString(4,values.get(3));
		    prepare.setString(5,values.get(4));
		    prepare.setString(6,values.get(5));
		    prepare.setString(7,values.get(6));
		    prepare.setString(8,values.get(7));
		    
				
		    int count = prepare.executeUpdate();
		
// message de succes
		
		if (count>0){
			//System.out.println("Enregistrement effectué");
	}
		}	
	
	}catch (Exception e){
		e.printStackTrace();
	}

}
	
}


