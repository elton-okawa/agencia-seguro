package controller;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.ClienteDAO;
import dao.PrestadorServicoDAO;

/**
 * Servlet implementation class ControlePrestadorServico
 */
@WebServlet("/ControlePrestadorServico")
public class ControlePrestadorServico extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ControlePrestadorServico() {
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
					request.setAttribute("prestadorServicoList", PrestadorServicoDAO.getInstance().getAll());
					requestDispatcher = getServletContext().getRequestDispatcher("/prestador-servico/prestadorServicoAll.jsp");
					requestDispatcher.forward(request, response);
					break;
				case "cnpj":
					requestDispatcher = getServletContext().getRequestDispatcher("/prestador-servico/prestadorServicoCnpj.jsp");
					requestDispatcher.forward(request, response);
					break;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		final String tipo = (String) request.getParameter("type");
		try {
			switch (tipo) {
				case "cnpj":
					request.setAttribute("prestadorServico", PrestadorServicoDAO.getInstance().getPrestadorServicoByCNPJ((String)request.getParameter("cnpj")));
					break;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		doGet(request, response);
	}

}
