package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import vos.Abono;
import vos.Boleta;
import vos.Usuario;

public class DAOAbono {
	
	private ArrayList<Object> recursos;

	private Connection conn;

	public DAOAbono ()
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
	
	public ArrayList<Abono> darAbonos() throws SQLException
	{
		ArrayList<Abono> abonos  = new ArrayList<Abono>();
		String sql = "SELECT * FROM ABONO";

		System.out.println("SQL stmt:" + sql);
		PreparedStatement prepStmt = conn.prepareStatement(sql);
		recursos.add(prepStmt);
		ResultSet rs = prepStmt.executeQuery();
		
		while (rs.next())
		{
			
			int idAbono = rs.getInt(1);
			int idFuncion = rs.getInt(2);
			int idLocalidad = rs.getInt(3);	
			int idCliente = rs.getInt(4);
			
			abonos.add(new Abono(idAbono, idFuncion, idLocalidad, idCliente));
		
		}
		
	System.out.println("HAY BOLETAS "+ abonos.size());
		return abonos;
	}
	
	public void addAbono(Abono abono) throws SQLException{
		String sql = "INSERT INTO ABONO VALUES (";
		sql += abono.getIdabono() + ",";
		sql += abono.getIdfuncion() + ",'";
		sql += abono.getIdlocalidad() + ",'";
		sql += abono.getIdcliente() + ")";
		
		System.out.println("SQL stmt    addAbono:" + sql);
		
		PreparedStatement prepStmt = conn.prepareStatement(sql);
		recursos.add(prepStmt);
		prepStmt.executeQuery();
	}


	
	public void deleteAbono(Abono abono) throws SQLException{
		String sql = "DELETE FROM ABONO WHERE IDABONO ="+abono.getIdabono();
		
		
		System.out.println("SQL stmt    deleteAbono:" + sql);
		
		PreparedStatement prepStmt = conn.prepareStatement(sql);
		recursos.add(prepStmt);
		prepStmt.executeQuery();
	}

}
