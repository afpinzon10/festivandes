package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import vos.Abono;
import vos.Boleta;
import vos.ListaBoletas;
import vos.RF10;

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
	
	public void addBoletaAbonada(int idAbono, int idboleta) throws SQLException{

			String sql = "INSERT INTO BOLETASABONADAS VALUES (";
			sql += idAbono + ",";
			sql += idboleta + ")";
			PreparedStatement prepStmt = conn.prepareStatement(sql);
			recursos.add(prepStmt);
			prepStmt.executeQuery();
	}

	public int esAbono(RF10 lasBoletas) throws SQLException {
		String sql = "SELECT IDABONO FROM ABONO WHERE " + lasBoletas.getIdcliente() + " = IDCLIENTE AND " + lasBoletas.getIdfuncion() + " = IDFUNCION AND " + lasBoletas.getIdlocalidad() + " = IDLOCALIDAD";
		System.out.println("SQL stmt:" + sql);
		PreparedStatement prepStmt = conn.prepareStatement(sql);
		recursos.add(prepStmt);
		ResultSet rs = prepStmt.executeQuery();
		int num =0;

		while(rs.next()){
			 num = rs.getInt(1);
		}
				
				
		return num;
	}
}
