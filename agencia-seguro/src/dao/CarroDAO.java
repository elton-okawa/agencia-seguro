package dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import model.Carro;
import model.Cliente;

public class CarroDAO extends DAO<Carro>{

	private static CarroDAO instance = new CarroDAO();
	
	private CarroDAO(){
		super();
	}
	
	public static CarroDAO getInstance() {
		return instance;
	}
	
	
	public Carro getCarroByRenavam(String renavam) throws SQLException {
		String query = String.format("SELECT * FROM Carro WHERE Renavam='%s'", renavam);
		return super.getObjectByPrimaryKey(query);
	}
	
	public List<Carro> getAll() throws SQLException {
		String query = String.format("SELECT * FROM Carro;");
		return super.getAll(query);
	}
	
	@Override
	protected Carro instantiateObject(ResultSet resultSet) throws SQLException {
		Carro carro = new Carro();
		
		carro.setRenavam(resultSet.getString("Renavam"));
		carro.setMarca(resultSet.getString("Marca"));
		carro.setModelo(resultSet.getString("Modelo"));
		carro.setCor(resultSet.getString("Cor"));
		carro.setAno(resultSet.getInt("Ano"));
		carro.setNumeroPortas(resultSet.getInt("NumeroPortas"));
		carro.setStatus(resultSet.getString("Status"));
		return carro;
	}

}
