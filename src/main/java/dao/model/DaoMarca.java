package dao.model;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import model.Marca;

public class DaoMarca {
	public ArrayList<Marca> getMarcas(Connection con) {
		ResultSet rs;
		ArrayList<Marca> marcas = new ArrayList<Marca>();

		Statement st;
		try {
			st = con.createStatement();
			String ordenSql = "SELECT * from Marca";
			rs = st.executeQuery(ordenSql);

			while (rs.next()) {
				Marca Marca = new Marca();
				Marca.setId(rs.getInt("id"));
				Marca.setNombre(rs.getString("nombre"));
				
				marcas.add(Marca);
			}
			rs.close();
			st.close();
		} catch (SQLException e) {
			System.out
					.println("Error al acceder a la BDs: " + e.getMessage());
		}
		return marcas;
	}


}
