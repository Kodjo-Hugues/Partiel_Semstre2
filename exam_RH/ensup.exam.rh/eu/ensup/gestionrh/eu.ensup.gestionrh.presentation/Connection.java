package eu.ensup.gestionrh.presentaion;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import eu.ensaup.gestionrh.dao.*;
import eu.ensup.gestionrh.domaine.*;


@WebServlet("/Connection")
public class Connection {
	
	private static final long serialVersionUID = 1L;
	private static final Logger LOGGER = LoggerFactory.getLogger(Connection.class);
	
	/**
	 * Constructeur
	 */
	public Connection() {
		super();
	}
	
	/**
	 * do Get 
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
	}
	
	/**
	 * do Post
	 * @param request
	 * @param response
	 * @throws ServletException
	 * @throws IOException
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		String login = request.getParameter("login");
		String pwd = request.getParameter("password");
		
		List<Salarie> listSalarie = new ArrayList<Salarie>();
		listSalarie = Login.login(login, pwd);
		
		if (!(listSalarie.isEmpty())) {
		/*	request.setAttribute("id", listSalarie.get(0).getId());
			request.setAttribute("listePersonne", new ConseillerDao().listeDesClients());*/
			RequestDispatcher rs = request.getRequestDispatcher("Listeformation.jsp");
			rs.forward(request, response);
		} else {
			
			RequestDispatcher rs = request.getRequestDispatcher("error.jsp");
			rs.include(request, response);
		}
		
	}
	
	

}
