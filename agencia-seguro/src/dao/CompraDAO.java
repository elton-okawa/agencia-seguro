package dao;

import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import model.Compra;
import model.Venda;

public class CompraDAO extends DAO<Compra>{

	private static CompraDAO instance = new CompraDAO();
	private final String tableJoin = "(((CompraDB INNER JOIN ClienteDB ON CompraDB.IdCliente = ClienteDB.IdCliente) "
			+ "	INNER JOIN CarroDB ON CompraDB.Renavam = CarroDB.Renavam) "
			+ " INNER JOIN FuncionarioDB ON CompraDB.IdFuncionario = FuncionarioDB.IdFuncionario)";
	
	private CompraDAO() {
		super();
	}
	
	public static CompraDAO getInstance() {
		return instance;
	}
	
	public List<Compra> getAll() throws SQLException {
		String query = String.format("SELECT * FROM %s ORDER BY DataCompra DESC", tableJoin);
		return super.getAll(query);
	}
	
	public List<Compra> getAllCompraByIdCliente (int idCliente) throws SQLException {
		String query = String.format("SELECT * FROM %s WHERE CompraDB.IdCliente=%d ORDER BY DataCompra DESC", tableJoin, idCliente);
		return super.getAll(query);
	}
	
	public List<Compra> getAllCompraByIdFuncionario (int idFuncionario) throws SQLException {
		String query = String.format("SELECT * FROM %s WHERE CompraDB.IdFuncionario=%d ORDER BY DataCompra DESC", tableJoin, idFuncionario);
		return super.getAll(query);
	}

	public List<Compra> getAllCompraByRenavam (String renavam) throws SQLException {
		String query = String.format("SELECT * FROM %s WHERE CompraDB.Renavam='%s' ORDER BY DataCompra DESC", tableJoin, renavam);
		return super.getAll(query);
	}
	
	public List<Compra> getAllCompraByPeriod (Date intervaloInicio, Date intervaloFim) throws SQLException {
		String query = String.format("SELECT * FROM %s WHERE DataCompra >= '%s' AND DataCompra <= '%s' ORDER BY DataCompra DESC", tableJoin, intervaloInicio, intervaloFim);
		return super.getAll(query);
	}
	
	public List<Compra> getAllCompraByValorMaiorQue (float valor) throws SQLException {
		String query = String.format("SELECT * FROM %s WHERE ValorCompra >= '%f' ORDER BY ValorCompra DESC", tableJoin, valor);
		return super.getAll(query);
	}
	
	public List<Compra> getAllCompraByValorMenorQue (float valor) throws SQLException {
		String query = String.format("SELECT * FROM %s WHERE ValorCompra <= '%f' ORDER BY ValorCompra DESC", tableJoin, valor);
		return super.getAll(query);
	}
	
	@Override
	public Compra instantiateObject(ResultSet resultSet) throws SQLException {
		Compra compra = new Compra();
		
		compra.setCarro(CarroDAO.getInstance().instantiateObject(resultSet));
		compra.setCliente(ClienteDAO.getInstance().instantiateObject(resultSet));
		compra.setDataCompra(resultSet.getDate("DataCompra"));
		compra.setFuncionario(FuncionarioDAO.getInstance().instantiateObject(resultSet));
		compra.setValor(resultSet.getFloat("ValorCompra"));
		return compra;
	}
}
