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

import dao.CompraDAO;

/**
 * Servlet implementation class ControleCompra
 */
@WebServlet("/ControleCompra")
public class ControleCompra extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ControleCompra() {
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
					request.setAttribute("compraList", CompraDAO.getInstance().getAll());
					requestDispatcher = getServletContext().getRequestDispatcher("/compra/compraAll.jsp");
					requestDispatcher.forward(request, response);
					break;
				case "idCliente":
					requestDispatcher = getServletContext().getRequestDispatcher("/compra/compraIdCliente.jsp");
					requestDispatcher.forward(request, response);
					break;
				case "idFuncionario":
					requestDispatcher = getServletContext().getRequestDispatcher("/compra/compraIdFuncionario.jsp");
					requestDispatcher.forward(request, response);
					break;
				case "renavam":
					requestDispatcher = getServletContext().getRequestDispatcher("/compra/compraRenavam.jsp");
					requestDispatcher.forward(request, response);
					break;
				case "periodo":
					requestDispatcher = getServletContext().getRequestDispatcher("/compra/compraPeriodo.jsp");
					requestDispatcher.forward(request, response);
					break;
				case "valor":
					requestDispatcher = getServletContext().getRequestDispatcher("/compra/compraValor.jsp");
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
					request.setAttribute("compraList", CompraDAO.getInstance().getAllCompraByIdCliente(Integer.valueOf((String)request.getParameter("idCliente"))));
					break;
				case "idFuncionario":
					request.setAttribute("compraList", CompraDAO.getInstance().getAllCompraByIdFuncionario(Integer.valueOf((String)request.getParameter("idFuncionario"))));
					break;
				case "renavam":
					request.setAttribute("compraList", CompraDAO.getInstance().getAllCompraByRenavam((String)request.getParameter("renavam")));
					break;
				case "periodo":
					request.setAttribute("compraList", CompraDAO.getInstance().getAllCompraByPeriod(Date.valueOf(request.getParameter("intervaloInicio")), Date.valueOf(request.getParameter("intervaloFim"))));
					break;
				case "valor":
					request.setAttribute("compraList", CompraDAO.getInstance().getAllCompraByValorMaiorQue(Float.valueOf(request.getParameter("valor"))));
					break;
				
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		doGet(request, response);
	}
}
