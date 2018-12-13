package dao;

import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import model.Venda;

public class VendaDAO extends DAO<Venda>{

	private static VendaDAO instance = new VendaDAO();
	private final String tableJoin = "(((VendaDB INNER JOIN ClienteDB ON VendaDB.IdCliente = ClienteDB.IdCliente) "
			+ "	INNER JOIN CarroDB ON VendaDB.Renavam = CarroDB.Renavam) "
			+ " INNER JOIN FuncionarioDB ON VendaDB.IdFuncionario = FuncionarioDB.IdFuncionario)";
	
	private VendaDAO() {
		super();
	}
	
	public static VendaDAO getInstance() {
		return instance;
	}
	
	public List<Venda> getAll() throws SQLException {
		String query = String.format("SELECT * FROM %s ORDER BY DataVenda DESC;", tableJoin);
		return super.getAll(query);
	}
	
	public List<Venda> getAllVendaByIdCliente (int idCliente) throws SQLException {
		String query = String.format("SELECT * FROM %s WHERE VendaDB.IdCliente=%d ORDER BY DataVenda DESC", tableJoin, idCliente);
		return super.getAll(query);
	}
	
	public List<Venda> getAllVendaByIdFuncionario (int idFuncionario) throws SQLException {
		String query = String.format("SELECT * FROM %s WHERE VendaDB.IdFuncionario=%d ORDER BY DataVenda DESC", tableJoin, idFuncionario);
		return super.getAll(query);
	}

	public List<Venda> getAllVendaByRenavam (String renavam) throws SQLException {
		String query = String.format("SELECT * FROM %s WHERE VendaDB.Renavam='%s' ORDER BY DataVenda DESC;", tableJoin, renavam);
		return super.getAll(query);
	}
	
	public List<Venda> getAllVendaByPeriod (Date intervaloInicio, Date intervaloFim) throws SQLException {
		String query = String.format("SELECT * FROM %s WHERE DataVenda >= '%s' AND DataVenda <= '%s' ORDER BY DataVenda DESC", tableJoin, intervaloInicio, intervaloFim);
		return super.getAll(query);
	}
	
	public List<Venda> getAllVendaByValorMaiorQue (float valor) throws SQLException {
		String query = String.format("SELECT * FROM %s WHERE ValorVenda >= '%f' ORDER BY ValorVenda DESC", tableJoin, valor);
		return super.getAll(query);
	}
	
	public List<Venda> getAllVendaByValorMenorQue (float valor) throws SQLException {
		String query = String.format("SELECT * FROM %s WHERE ValorVenda <= '%f' ORDER BY ValorVenda DESC", tableJoin, valor);
		return super.getAll(query);
	}
	
	@Override
	public Venda instantiateObject(ResultSet resultSet) throws SQLException {
		Venda venda = new Venda();
		
		venda.setCarro(CarroDAO.getInstance().instantiateObject(resultSet));
		venda.setCliente(ClienteDAO.getInstance().instantiateObject(resultSet));
		venda.setDataVenda(resultSet.getDate("DataVenda"));
		venda.setFuncionario(FuncionarioDAO.getInstance().instantiateObject(resultSet));
		venda.setValor(resultSet.getFloat("ValorVenda"));
		return venda;
	}

}
