package Prueba;

import java.sql.Connection;
import java.util.ArrayList;

import connection.Conexion;
import dao.model.DaoCoche;
import model.Coche;




public class Prueba {

	public static void main(String[] args) {

		Connection con = Conexion.conecta();
		ArrayList<Coche> bicis =  new DaoCoche().getCoches("%","marca","%",con);
		
		for (Coche bici:bicis) {
			System.out.println(bici);
		}

	}

}
