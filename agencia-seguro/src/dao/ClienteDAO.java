package dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Locale;

import model.Cliente;

public class ClienteDAO extends DAO<Cliente>{

	private static ClienteDAO instance = new ClienteDAO();
	
	private ClienteDAO() {
		super();
	}
	
	public static ClienteDAO getInstance() {
		return instance;
	}
	
	public boolean create(Cliente cliente) throws SQLException {
		String query = 
				String.format(Locale.US, "INSERT INTO ClienteDB (CPF, Nome, RG, Telefone, Email, Endereco, "
						+ "IdCliente, DataPrimeiraCompra)"
						+ " VALUES ('%s', '%s', '%s', '%s', '%s', '%s', %d, '%s');", 
						cliente.getCPF(), cliente.getNome(), cliente.getRG(), cliente.getTelefone(), 
						cliente.getEmail(), cliente.getEndereco());
		
		return super.create(query);
	}
	
	public Cliente getClienteByID(int id) throws SQLException {
		String query = String.format("SELECT * FROM ClienteDB WHERE IdCliente=%d", id);
		return super.getObjectByPrimaryKey(query);
	}
	
	public List<Cliente> getAll() throws SQLException {
		String query = String.format("SELECT * FROM ClienteDB;");
		return super.getAll(query);
	}

	@Override
	public Cliente instantiateObject(ResultSet resultSet) throws SQLException {
		Cliente cliente = new Cliente();
		
		cliente.setCPF(resultSet.getString("CPF"));
		cliente.setNome(resultSet.getString("Nome"));
		cliente.setRG(resultSet.getString("RG"));
		cliente.setTelefone(resultSet.getString("Telefone"));
		cliente.setEmail(resultSet.getString("Email"));
		cliente.setEndereco(resultSet.getString("Endereco"));
		
		cliente.setIdCliente(resultSet.getInt("IdCliente"));
		cliente.setDataPrimeiraCompra(resultSet.getDate("DataPrimeiraCompra"));
		return cliente;
	}
	
	
}
