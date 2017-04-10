package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;

import vos.Abono;
import vos.Boleta;
import vos.ListaBoletas;

public class DAORF11 {

	private ArrayList<Object> recursos;

	private Connection conn;

	public DAORF11 ()
	{
		recursos = new ArrayList<Object>();
	}

	//Cierra el recuerso
	public void cerrarRecursos() 
	{
		for(Object ob : recursos){
			if(ob instanceof PreparedStatement)
				try {
					((PreparedStatement) ob).close();
				} catch (Exception ex) {
					ex.printStackTrace();
				}
		}
	}

	public void setConn(Connection con){
		this.conn = con;
	}
	
	public void addBoletasAbonadas(RF10 rf10, int idAbono){
		DAOBoletas dao = new DAOBoletas();
		ListaBoletas lis= dao.addmuchasboletas(rf10);
		
		for (Boleta b : lis.getBoletas()) {
			String sql = "INSERT INTO BOLETASABONADAS VALUES (";
			sql += idAbono + ",";
			sql += b.getIdboleta() + ")";
		}
	}
}
