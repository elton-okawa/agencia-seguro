package dao;

import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import model.Compra;
import model.Venda;

public class CompraDAO extends DAO<Compra>{

	private static CompraDAO instance = new CompraDAO();
	
	private CompraDAO() {
		super();
	}
	
	public static CompraDAO getInstance() {
		return instance;
	}
	
	public List<Compra> getAll() throws SQLException {
		String query = String.format("SELECT * FROM CompraDB ORDER BY DataCompra DESC");
		return super.getAll(query);
	}
	
	public List<Compra> getAllCompraByIdCliente (int idCliente) throws SQLException {
		String query = String.format("SELECT * FROM CompraDB WHERE IdCliente=%d ORDER BY DataCompra DESC", idCliente);
		return super.getAll(query);
	}
	
	public List<Compra> getAllCompraByIdFuncionario (int idFuncionario) throws SQLException {
		String query = String.format("SELECT * FROM CompraDB WHERE IdFuncionario=%d ORDER BY DataCompra DESC", idFuncionario);
		return super.getAll(query);
	}

	public List<Compra> getAllCompraByRenavam (String renavam) throws SQLException {
		String query = String.format("SELECT * FROM CompraDB WHERE Renavam='%s' ORDER BY DataCompra DESC", renavam);
		return super.getAll(query);
	}
	
	public List<Compra> getAllCompraByPeriod (Date intervaloInicio, Date intervaloFim) throws SQLException {
		String query = String.format("SELECT * FROM CompraDB WHERE DataCompra >= '%s' AND DataCompra <= '%s' ORDER BY DataCompra DESC", intervaloInicio, intervaloFim);
		return super.getAll(query);
	}
	
	public List<Compra> getAllCompraByValorMaiorQue (float valor) throws SQLException {
		String query = String.format("SELECT * FROM CompraDB WHERE ValorCompra >= '%f' ORDER BY ValorCompra DESC", valor);
		return super.getAll(query);
	}
	
	public List<Compra> getAllCompraByValorMenorQue (float valor) throws SQLException {
		String query = String.format("SELECT * FROM CompraDB WHERE ValorCompra <= '%f' ORDER BY ValorCompra DESC", valor);
		return super.getAll(query);
	}
	
	@Override
	protected Compra instantiateObject(ResultSet resultSet) throws SQLException {
		Compra compra = new Compra();
		
		compra.setCarro(CarroDAO.getInstance().getCarroByRenavam(resultSet.getString("Renavam")));
		compra.setCliente(ClienteDAO.getInstance().getClienteByID(resultSet.getInt("IdCliente")));
		compra.setDataCompra(resultSet.getDate("DataCompra"));
		compra.setFuncionario(FuncionarioDAO.getInstance().getFuncionarioByID(resultSet.getInt("IdFuncionario")));
		compra.setValor(resultSet.getFloat("ValorCompra"));
		return compra;
	}
}
