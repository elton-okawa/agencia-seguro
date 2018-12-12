package controller;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.PrestaDAO;

/**
 * Servlet implementation class ControlePresta
 */
@WebServlet("/ControlePresta")
public class ControlePresta extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ControlePresta() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		final String tipo = (String) request.getParameter("type");
		RequestDispatcher requestDispatcher;
		try {
			switch (tipo) {
				case "all":
					request.setAttribute("prestaList", PrestaDAO.getInstance().getAll());
					requestDispatcher = getServletContext().getRequestDispatcher("/presta/prestaAll.jsp");
					requestDispatcher.forward(request, response);
					break;
				case "cnpj":
					requestDispatcher = getServletContext().getRequestDispatcher("/presta/prestaCNPJ.jsp");
					requestDispatcher.forward(request, response);
					break;
				case "id":
					requestDispatcher = getServletContext().getRequestDispatcher("/presta/prestaId.jsp");
					requestDispatcher.forward(request, response);
					break;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		final String tipo = (String) request.getParameter("type");
		try {
			switch (tipo) {
				case "cnpj":
					request.setAttribute("prestaList", PrestaDAO.getInstance().getAllPrestaByCNPJ((String)request.getParameter("cnpj")));
					break;
				case "id":
					request.setAttribute("prestaList", PrestaDAO.getInstance().getAllPrestaByIdServico(Integer.valueOf((String)request.getParameter("idServico"))));
					break;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		doGet(request, response);
	}

}
