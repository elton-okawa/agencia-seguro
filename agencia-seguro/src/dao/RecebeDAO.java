package dao;

import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import model.Recebe;

public class RecebeDAO extends DAO<Recebe>{

	private static RecebeDAO instance = new RecebeDAO();
	
	private RecebeDAO() {
		super();
	}
	
	public static RecebeDAO getInstance() {
		return instance;
	}
	
	public List<Recebe> getAllRecebeByRenavam (String renavam) throws SQLException {
		String query = String.format("SELECT * FROM RecebeDB WHERE Renavam = '%s'", renavam);
		return super.getAll(query);
	}
	
	public List<Recebe> getAllRecebeByIdServico (int idServico) throws SQLException {
		String query = String.format("SELECT * FROM RecebeDB WHERE IdServico = %d", idServico);
		return super.getAll(query);
	}
	
	public List<Recebe> getAllRecebeByCNPJ (String cnpj) throws SQLException {
		String query = String.format("SELECT * FROM RecebeDB WHERE CNPJ = '%s'", cnpj);
		return super.getAll(query);
	}
	
	public List<Recebe> getAllCompraByPeriod (Date intervaloInicio, Date intervaloFim) throws SQLException {
		String query = String.format("SELECT * FROM RecebeDB WHERE DataInicio >= '%s' AND DataInicio <= '%s'", intervaloInicio, intervaloFim);
		return super.getAll(query);
	}
	
	public List<Recebe> getAll() throws SQLException {
		String query = String.format("SELECT * FROM RecebeDB");
		return super.getAll(query);
	}
	
	@Override
	protected Recebe instantiateObject(ResultSet resultSet) throws SQLException {
		Recebe recebe = new Recebe();
		recebe.setCarro(CarroDAO.getInstance().getCarroByRenavam(resultSet.getString("Renavam")));
		recebe.setServico(ServicoDAO.getInstance().getServicoByID(resultSet.getInt("Servico")));
		recebe.setPrestadorServico(
				PrestadorServicoDAO.getInstance().getPrestadorServicoByCNPJ(resultSet.getString("CNPJ")));
		recebe.setDataInicio(resultSet.getDate("DataInicio"));
		recebe.setDataFim(resultSet.getDate("DataFim"));
		return recebe;
	}

}
