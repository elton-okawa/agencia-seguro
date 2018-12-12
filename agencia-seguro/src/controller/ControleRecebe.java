package controller;

import java.io.IOException;
import java.sql.Date;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.RecebeDAO;

/**
 * Servlet implementation class ControleRecebe
 */
@WebServlet("/ControleRecebe")
public class ControleRecebe extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ControleRecebe() {
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
					request.setAttribute("recebeList", RecebeDAO.getInstance().getAll());
					requestDispatcher = getServletContext().getRequestDispatcher("/recebe/recebeAll.jsp");
					requestDispatcher.forward(request, response);
					break;
				case "cnpj":
					requestDispatcher = getServletContext().getRequestDispatcher("/recebe/recebeCnpj.jsp");
					requestDispatcher.forward(request, response);
					break;
				case "id":
					requestDispatcher = getServletContext().getRequestDispatcher("/recebe/recebeIdServico.jsp");
					requestDispatcher.forward(request, response);
					break;
				case "renavam":
					requestDispatcher = getServletContext().getRequestDispatcher("/recebe/recebeRenavam.jsp");
					requestDispatcher.forward(request, response);
					break;
				case "periodo":
					requestDispatcher = getServletContext().getRequestDispatcher("/recebe/recebePeriodo.jsp");
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
					request.setAttribute("recebeList", RecebeDAO.getInstance().getAllRecebeByCNPJ((String)request.getParameter("cnpj")));
					break;
				case "id":
					request.setAttribute("recebeList", RecebeDAO.getInstance().getAllRecebeByIdServico(Integer.valueOf((String)request.getParameter("idServico"))));
					break;
				case "renavam":
					request.setAttribute("recebeList", RecebeDAO.getInstance().getAllRecebeByRenavam((String)request.getParameter("renavam")));
					break;
				case "periodo":
					request.setAttribute("recebeList", RecebeDAO.getInstance().getAllRecebeByPeriod(Date.valueOf(request.getParameter("intervaloInicio")), Date.valueOf(request.getParameter("intervaloFim"))));
					break;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		doGet(request, response);
	}

}
