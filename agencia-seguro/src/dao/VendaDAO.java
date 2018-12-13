package dao;

import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import model.Venda;

public class VendaDAO extends DAO<Venda>{

	private static VendaDAO instance = new VendaDAO();
	
	private VendaDAO() {
		super();
	}
	
	public static VendaDAO getInstance() {
		return instance;
	}
	
	public List<Venda> getAll() throws SQLException {
		String query = String.format("SELECT * FROM VendaDB ORDER BY DataVenda DESC;");
		return super.getAll(query);
	}
	
	public List<Venda> getAllVendaByIdCliente (int idCliente) throws SQLException {
		String query = String.format("SELECT * FROM VendaDB WHERE IdCliente=%d ORDER BY DataVenda DESC", idCliente);
		return super.getAll(query);
	}
	
	public List<Venda> getAllVendaByIdFuncionario (int idFuncionario) throws SQLException {
		String query = String.format("SELECT * FROM VendaDB WHERE IdFuncionario=%d ORDER BY DataVenda DESC", idFuncionario);
		return super.getAll(query);
	}

	public List<Venda> getAllVendaByRenavam (String renavam) throws SQLException {
		String query = String.format("SELECT * FROM VendaDB WHERE Renavam='%s' ORDER BY DataVenda DESC;", renavam);
		return super.getAll(query);
	}
	
	public List<Venda> getAllVendaByPeriod (Date intervaloInicio, Date intervaloFim) throws SQLException {
		String query = String.format("SELECT * FROM VendaDB WHERE DataVenda >= '%s' AND DataVenda <= '%s' ORDER BY DataVenda DESC", intervaloInicio, intervaloFim);
		return super.getAll(query);
	}
	
	public List<Venda> getAllVendaByValorMaiorQue (float valor) throws SQLException {
		String query = String.format("SELECT * FROM VendaDB WHERE ValorVenda >= '%f' ORDER BY ValorVenda DESC", valor);
		return super.getAll(query);
	}
	
	public List<Venda> getAllVendaByValorMenorQue (float valor) throws SQLException {
		String query = String.format("SELECT * FROM VendaDB WHERE ValorVenda <= '%f' ORDER BY ValorVenda DESC", valor);
		return super.getAll(query);
	}
	
	@Override
	protected Venda instantiateObject(ResultSet resultSet) throws SQLException {
		Venda venda = new Venda();
		
		venda.setCarro(CarroDAO.getInstance().getCarroByRenavam(resultSet.getString("Renavam")));
		venda.setCliente(ClienteDAO.getInstance().getClienteByID(resultSet.getInt("IdCliente")));
		venda.setDataVenda(resultSet.getDate("DataVenda"));
		venda.setFuncionario(FuncionarioDAO.getInstance().getFuncionarioByID(resultSet.getInt("IdFuncionario")));
		venda.setValor(resultSet.getFloat("ValorVenda"));
		return venda;
	}

}
