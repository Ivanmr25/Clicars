package dao.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import model.Coche;



public class DaoCoche {
	public ArrayList<Coche> getCoches(String marca, String order, String fav, Connection con) {
		ResultSet rs;
		ArrayList<Coche> coches = new ArrayList<Coche>();

		Statement st;
		try {
			st = con.createStatement();
			String ordenSql = "SELECT * from coche b, marca m "
					+ "where b.marca=m.id and b.marca like '"+marca+"' and fav like '"+fav+"' order by "+order;
			rs = st.executeQuery(ordenSql);

			while (rs.next()) {
				Coche coche = new Coche();
				coche.setId(rs.getInt("id"));
				coche.setFoto(rs.getString("foto"));
				coche.setMarca(rs.getInt("marca"));
				coche.setMarcanombre(rs.getString("nombre"));
				coche.setNombre(rs.getString("nombre"));
				coche.setModelo(rs.getString("modelo"));
				coche.setPrecio(rs.getLong("precio"));
				coche.setPrecioantes(rs.getLong("precioantes"));
				coche.setAnio(rs.getInt("anio"));
				coche.setKm(rs.getLong("km"));
				coche.setCv(rs.getInt("cv"));
				coche.setFav(rs.getInt("fav"));
				
				coches.add(coche);
			}
			rs.close();
			st.close();
		} catch (SQLException e) {
			System.out
					.println("Error al acceder a la BDs: " + e.getMessage());
		}
		return coches;
	}
	// update fav
	public int updateFav(int id, int fav, Connection con) {
		int actualizados = -1;
		String ordenSQL = "update coche set fav=? where id=?";
		try {
			PreparedStatement st = con.prepareStatement(ordenSQL);
			st.setInt(1, fav);
			st.setInt(2, id);
			actualizados = st.executeUpdate();
			st.close();
			con.close();
		} catch (SQLException e) {
			System.out.println("Error al actualizar datos enla BDs: " + e.getMessage());		}
		return actualizados;
	}
	


}
