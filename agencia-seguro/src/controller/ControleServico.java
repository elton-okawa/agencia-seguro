package controller;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.ServicoDAO;

/**
 * Servlet implementation class ControleServico
 */
@WebServlet("/ControleServico")
public class ControleServico extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ControleServico() {
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
					request.setAttribute("servicoList", ServicoDAO.getInstance().getAll());
					requestDispatcher = getServletContext().getRequestDispatcher("/servico/servicoAll.jsp");
					requestDispatcher.forward(request, response);
					break;
				case "id":
					requestDispatcher = getServletContext().getRequestDispatcher("/servico/servicoId.jsp");
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
				case "id":
					request.setAttribute("servico", ServicoDAO.getInstance().getServicoByID(Integer.valueOf((String)request.getParameter("id"))));
					break;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		doGet(request, response);
	}

}
