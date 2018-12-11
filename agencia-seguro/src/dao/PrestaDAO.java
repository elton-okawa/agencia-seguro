package dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import model.Presta;
import model.Servico;

public class PrestaDAO extends DAO<Presta>{

	private static PrestaDAO instance = new PrestaDAO();
	
	private PrestaDAO(){
		super();
	}
	
	public PrestaDAO getInstance() {
		return instance;
	}
	
	public List<Presta> getAllPrestaByIdServico(int idServico) throws SQLException {
		String query = String.format("SELECT * FROM PrestaDB WHERE IdServico=%d", idServico);
		return super.getAll(query);
	}
	
	public List<Presta> getAllPrestaByCNPJ(String cnpj) throws SQLException {
		String query = String.format("SELECT * FROM PrestaDB WHERE CNPJ='%s'", cnpj);
		return super.getAll(query);
	}

	public List<Presta> getAll() throws SQLException {
		String query = String.format("SELECT * FROM PrestaDB;");
		return super.getAll(query);
	}
	
	@Override
	protected Presta instantiateObject(ResultSet resultSet) throws SQLException {
		Presta presta = new Presta();
		presta.setPrestadorServico(
				PrestadorServicoDAO.getInstance().getPrestadorServicoByCNPJ(resultSet.getString("CNPJ")));
		presta.setServico(ServicoDAO.getInstance().getServicoByID(resultSet.getInt("IdServico")));
		presta.setValor(resultSet.getFloat("Valor"));
		return presta;
	}

}
