package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;

import vos.Abono;
import vos.Boleta;
import vos.ListaBoletas;
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
			int precio = rs.getInt(5);

			abonos.add(new Abono(idAbono, idFuncion, idLocalidad, idCliente, precio));

		}
		return abonos;
	}

	public void addAbono(Abono abono) throws SQLException{
		String sql = "INSERT INTO ABONO VALUES (";
		sql += abono.getIdabono() + ",";
		sql += abono.getIdfuncion() + ",";
		sql += abono.getIdlocalidad() + ",";
		sql += abono.getIdcliente() + ",";
		sql += abono.getPrecio() + ")";

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

	public ListaBoletas darBoletas(Abono abono) throws SQLException {
		ArrayList<Boleta> boletas  = new ArrayList<Boleta>();
		String sql = "SELECT BOLETA.* FROM (SELECT IDBOLETA FROM ABONO NATURAL JOIN BOLETASABONADAS WHERE IDABONO = " + abono.getIdabono() + " )T1 INNER JOIN BOLETA ON T1.IDBOLETA = BOLETA.IDBOLETA";

		System.out.println("SQL stmt:" + sql);
		PreparedStatement prepStmt = conn.prepareStatement(sql);
		recursos.add(prepStmt);
		ResultSet rs = prepStmt.executeQuery();

		while (rs.next())
		{

			int idBoleta = rs.getInt(1);
			int idLocalidad = rs.getInt(2);
			String fila = rs.getString(6);
			String silla = rs.getString(3);
			int idFuncion = rs.getInt(4);
			int idCliente = rs.getInt(5);
			boletas.add(new Boleta(idBoleta, idLocalidad, fila, silla, idFuncion, idCliente));

		}
		return new ListaBoletas(boletas);
	}

	public void borrarRegistros(ListaBoletas boletas) throws SQLException {
		if(boletas.getBoletas().size()>0){
			int i = boletas.getBoletas().size();
			String sql = "DELETE FROM BOLETASABONADAS WHERE ";
			for (Boleta b : boletas.getBoletas()) {
				sql += " IDBOLETA = " + b.getIdboleta();
				if (i>0){
					sql += " OR";
					i++;
				}
			}
			System.out.println("SQL stmt    deleteAbono:" + sql);

			PreparedStatement prepStmt = conn.prepareStatement(sql);
			recursos.add(prepStmt);
			prepStmt.executeQuery();
		}
		
		
	}

	public Timestamp darFechaFestival() throws SQLException {
		String sql = "SELECT MIN(FECHA) FROM FUNCION";
		System.out.println("SQL stmt    deleteAbono:" + sql);

		PreparedStatement prepStmt = conn.prepareStatement(sql);
		recursos.add(prepStmt);
		ResultSet rs = prepStmt.executeQuery();
		rs.next();
		return rs.getTimestamp(1);
		
	}
}
