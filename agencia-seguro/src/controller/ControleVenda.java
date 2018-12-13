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

import dao.VendaDAO;

/**
 * Servlet implementation class ControleVenda
 */
@WebServlet("/ControleVenda")
public class ControleVenda extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ControleVenda() {
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
					request.setAttribute("vendaList", VendaDAO.getInstance().getAll());
					requestDispatcher = getServletContext().getRequestDispatcher("/venda/vendaAll.jsp");
					requestDispatcher.forward(request, response);
					break;
				case "idCliente":
					requestDispatcher = getServletContext().getRequestDispatcher("/venda/vendaIdCliente.jsp");
					requestDispatcher.forward(request, response);
					break;
				case "idFuncionario":
					requestDispatcher = getServletContext().getRequestDispatcher("/venda/vendaIdFuncionario.jsp");
					requestDispatcher.forward(request, response);
					break;
				case "renavam":
					requestDispatcher = getServletContext().getRequestDispatcher("/venda/vendaRenavam.jsp");
					requestDispatcher.forward(request, response);
					break;
				case "periodo":
					requestDispatcher = getServletContext().getRequestDispatcher("/venda/vendaPeriodo.jsp");
					requestDispatcher.forward(request, response);
					break;
				case "valor":
					requestDispatcher = getServletContext().getRequestDispatcher("/venda/vendaValor.jsp");
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
				case "idCliente":
					request.setAttribute("vendaList", VendaDAO.getInstance().getAllVendaByIdCliente(Integer.valueOf((String)request.getParameter("idCliente"))));
					break;
				case "idFuncionario":
					request.setAttribute("vendaList", VendaDAO.getInstance().getAllVendaByIdFuncionario(Integer.valueOf((String)request.getParameter("idFuncionario"))));
					break;
				case "renavam":
					request.setAttribute("vendaList", VendaDAO.getInstance().getAllVendaByRenavam((String)request.getParameter("renavam")));
					break;
				case "periodo":
					request.setAttribute("vendaList", VendaDAO.getInstance().getAllVendaByPeriod(Date.valueOf(request.getParameter("intervaloInicio")), Date.valueOf(request.getParameter("intervaloFim"))));
					break;
				case "valor":
					request.setAttribute("vendaList", VendaDAO.getInstance().getAllVendaByValorMaiorQue(Float.valueOf(request.getParameter("valor"))));
					break;
				
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		doGet(request, response);
	}

}
