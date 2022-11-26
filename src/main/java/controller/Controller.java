package controller;

import java.io.IOException;
import java.sql.Connection;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.websocket.Session;


import connection.Conexion;
import dao.model.DaoCoche;
import dao.model.DaoMarca;
import model.Coche;
import model.Marca;









/**
 * Servlet implementation class Controller
 */
@WebServlet("/Controller")
public class Controller extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Controller() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		HttpSession session = request.getSession();
		/*
		 * Crear el singleton con
		 */
		 String marca;
		 String order;
		 String fav;
		
		 Connection con = (Connection)session.getAttribute("con");
		 if (con==null) {
			 con = Conexion.conecta();
			 session.setAttribute("con", con);
		 }
	
		String op = request.getParameter("op");
		RequestDispatcher dispatcher;
		if (op.equals("inicio")) {
			session.setAttribute("marca", "%");
			session.setAttribute("order", "marca");
			session.setAttribute("fav", "%");
			ArrayList<Coche> bicis =  new DaoCoche().getCoches("%", "marca", "%", con);
			ArrayList<Marca> marcas =  new DaoMarca().getMarcas(con);
			session.setAttribute("marcas", marcas);
			session.setAttribute("bicis", bicis);
			dispatcher = request.getRequestDispatcher("home.jsp");
			dispatcher.forward(request, response);
		} else if (op.equals("vamarca")) {
			marca = request.getParameter("marca");
			session.setAttribute("marca", marca);
			order = (String)session.getAttribute("order");
			fav = (String)session.getAttribute("fav");
			ArrayList<Coche> bicis =  new DaoCoche().getCoches(marca, order, fav, con);
			session.setAttribute("bicis", bicis);
			dispatcher = request.getRequestDispatcher("home.jsp");
			dispatcher.forward(request, response);
		}else if (op.equals("vaorder")) {
			order = request.getParameter("order");
			session.setAttribute("order", order);
			marca = (String) session.getAttribute("marca");
			fav = (String)session.getAttribute("fav");
			ArrayList<Coche> bicis = new  DaoCoche().getCoches(marca, order, fav, con);
			session.setAttribute("bicis", bicis);
			dispatcher = request.getRequestDispatcher("home.jsp");
			dispatcher.forward(request, response);
		} 
		else if (op.equals("vafav")) {
			fav = request.getParameter("fav");
			if (fav.equals("0")) fav = "%";
			session.setAttribute("fav", fav);
			marca = (String) session.getAttribute("marca");
			order = (String) session.getAttribute("order");
			ArrayList<Coche> bicis = new  DaoCoche().getCoches(marca, order, fav, con);
			session.setAttribute("bicis", bicis);
			dispatcher = request.getRequestDispatcher("home.jsp");
			dispatcher.forward(request, response);
		}
		else if (op.equals("changefav")) {
			fav = request.getParameter("fav");
			int favint = Integer.parseInt(fav);
			// favint cambia 0 por 1 o 1 por 0 con el operador ternario ?:
			favint = favint==0?1:0;
			String id = request.getParameter("bici");
			
			new DaoCoche().updateFav(Integer.parseInt(id), favint, con);
			fav = (String) session.getAttribute("fav");
			marca = (String) session.getAttribute("marca");
			order = (String) session.getAttribute("order");
			ArrayList<Coche> bicis =  new  DaoCoche().getCoches(marca, order, fav, con);
			session.setAttribute("bicis", bicis);
			dispatcher = request.getRequestDispatcher("home.jsp");
			dispatcher.forward(request, response);
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
