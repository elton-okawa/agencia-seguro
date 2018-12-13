package dao;

import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import model.Recebe;

public class RecebeDAO extends DAO<Recebe>{

	private static RecebeDAO instance = new RecebeDAO();
	private final String tableJoin = "(((RecebeDB INNER JOIN ServicoDB ON RecebeDB.IdServico = ServicoDB.IdServico) "
			+ "	INNER JOIN CarroDB ON RecebeDB.Renavam = CarroDB.Renavam) "
			+ " INNER JOIN PrestadorServicoDB ON RecebeDB.CNPJ= PrestadorServicoDB.CNPJ)";
	
	
	private RecebeDAO() {
		super();
	}
	
	public static RecebeDAO getInstance() {
		return instance;
	}
	
	public List<Recebe> getAllRecebeByRenavam (String renavam) throws SQLException {
		String query = String.format("SELECT * FROM %s WHERE RecebeDB.Renavam = '%s'", tableJoin, renavam);
		return super.getAll(query);
	}
	
	public List<Recebe> getAllRecebeByIdServico (int idServico) throws SQLException {
		String query = String.format("SELECT * FROM %s WHERE RecebeDB.IdServico = %d", tableJoin, idServico);
		return super.getAll(query);
	}
	
	public List<Recebe> getAllRecebeByCNPJ (String cnpj) throws SQLException {
		String query = String.format("SELECT * FROM %s WHERE RecebeDB.CNPJ = '%s'", tableJoin, cnpj);
		return super.getAll(query);
	}
	
	public List<Recebe> getAllRecebeByPeriod (Date intervaloInicio, Date intervaloFim) throws SQLException {
		String query = String.format("SELECT * FROM %s WHERE DataInicio >= '%s' AND DataInicio <= '%s'", tableJoin, intervaloInicio, intervaloFim);
		return super.getAll(query);
	}
	
	public List<Recebe> getAll() throws SQLException {
		String query = String.format("SELECT * FROM %s", tableJoin);
		return super.getAll(query);
	}
	
	@Override
	public Recebe instantiateObject(ResultSet resultSet) throws SQLException {
		Recebe recebe = new Recebe();
		recebe.setCarro(CarroDAO.getInstance().instantiateObject(resultSet));
		recebe.setServico(ServicoDAO.getInstance().instantiateObject(resultSet));
		recebe.setPrestadorServico(
				PrestadorServicoDAO.getInstance().instantiateObject(resultSet));
		recebe.setDataInicio(resultSet.getDate("DataInicio"));
		recebe.setDataFim(resultSet.getDate("DataFim"));
		return recebe;
	}

}
