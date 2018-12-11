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
	
	public List<Venda> getAllVendaByIdCliente (int idCliente) throws SQLException {
		String query = String.format("SELECT * FROM Venda WHERE IdCliente=%d", idCliente);
		return super.getAll(query);
	}
	
	public List<Venda> getAllVendaByIdFuncionario (int idFuncionario) throws SQLException {
		String query = String.format("SELECT * FROM Venda WHERE IdFuncionario=%d", idFuncionario);
		return super.getAll(query);
	}

	public List<Venda> getAllVendaByIdRenavam (String renavam) throws SQLException {
		String query = String.format("SELECT * FROM Venda WHERE Renavam='%s'", renavam);
		return super.getAll(query);
	}
	
	public List<Venda> getAllVendaByPeriod (Date intervaloInicio, Date intervaloFim) throws SQLException {
		String query = String.format("SELECT * FROM Venda WHERE DataVenda >= '%s' AND DataVenda <= '%s'", intervaloInicio, intervaloFim);
		return super.getAll(query);
	}
	
	public List<Venda> getAllVendaByValorMaiorQue (float valor) throws SQLException {
		String query = String.format("SELECT * FROM Venda WHERE ValorVenda >= %2.f", valor);
		return super.getAll(query);
	}
	
	public List<Venda> getAllVendaByValorMenorQue (float valor) throws SQLException {
		String query = String.format("SELECT * FROM Venda WHERE ValorVenda <= %2.f", valor);
		return super.getAll(query);
	}
	
	@Override
	protected Venda instantiateObject(ResultSet resultSet) throws SQLException {
		Venda venda = new Venda();
		
		venda.setCarro(CarroDAO.getInstance().getCarroByRenavam(resultSet.getString("Renavam")));
		venda.setCliente(ClienteDAO.getInstance().getClienteByID(resultSet.getInt("IdCliente")));
		venda.setDataVenda(resultSet.getDate("DataVenda"));
		venda.setFuncionario(FuncionarioDAO.getInstance().getFuncionarioByID(resultSet.getInt("IdFuncionario")));
		venda.setValor(resultSet.getFloat("Valor"));
		return venda;
	}

}
