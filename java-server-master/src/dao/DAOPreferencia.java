package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;

import vos.Preferencia;

public class DAOPreferencia {
	private ArrayList<Object> recursos;

	private Connection conn;

	public DAOPreferencia ()
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
	
	public ArrayList<Preferencia> darPreferencias() throws SQLException
	{
		ArrayList<Preferencia> usuarios  = new ArrayList<Preferencia>();
		String sql = "SELECT * FROM Preferencia";

		System.out.println("SQL stmt:" + sql);
		PreparedStatement prepStmt = conn.prepareStatement(sql);
		ResultSet rs = prepStmt.executeQuery();
		while (rs.next())
		{
			int idCliente = Integer.parseInt(rs.getString("IDCLIENTE"));
			int idCategoria = Integer.parseInt(rs.getString("IDCATEGORIA"));
			int edad = Integer.parseInt(rs.getString("EDAD"));
			String tipoEspacio = rs.getString("TIPOESPACIO");
			usuarios.add(new Preferencia(idCliente, idCategoria, edad, tipoEspacio));
		}
		return usuarios;
	}
	

	public void addPreferencia(Preferencia Preferencia) throws SQLException {
		String sql = "INSERT INTO Preferencia (IDCLIENTE, IDCATEGORIA, EDAD, TIPOESPACIO) VALUES ( ";
		sql += Preferencia.getIdcliente() + ",";
		sql += Preferencia.getIdcategoria() + ",";
		sql += Preferencia.getEdad() + ",'";
		sql += Preferencia.getTipoespacio() + "')";
		
		System.out.println("SQL stmt    addPreferencia:" + sql);
		
		PreparedStatement prepStmt = conn.prepareStatement(sql);
		recursos.add(prepStmt);
		prepStmt.executeQuery();
		
	}
}
