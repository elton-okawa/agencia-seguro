package dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import model.Presta;
import model.Servico;

public class PrestaDAO extends DAO<Presta>{

	private static PrestaDAO instance = new PrestaDAO();
	private final String tableJoin = "((PrestaDB INNER JOIN PrestadorServicoDB ON PrestaDB.CNPJ = PrestadorServicoDB.CNPJ) "
			+ "	INNER JOIN ServicoDB ON PrestaDB.IdServico = ServicoDB.IdServico)";
	
	private PrestaDAO(){
		super();
	}
	
	public static PrestaDAO getInstance() {
		return instance;
	}
	
	public List<Presta> getAllPrestaByIdServico(int idServico) throws SQLException {
		String query = String.format("SELECT * FROM %s WHERE IdServico=%d", tableJoin, idServico);
		return super.getAll(query);
	}
	
	public List<Presta> getAllPrestaByCNPJ(String cnpj) throws SQLException {
		String query = String.format("SELECT * FROM %s WHERE CNPJ='%s'", tableJoin, cnpj);
		return super.getAll(query);
	}

	public List<Presta> getAll() throws SQLException {
		String query = String.format("SELECT * FROM %s;", tableJoin);
		return super.getAll(query);
	}
	
	@Override
	public Presta instantiateObject(ResultSet resultSet) throws SQLException {
		Presta presta = new Presta();
		presta.setPrestadorServico(
				PrestadorServicoDAO.getInstance().instantiateObject(resultSet));
		presta.setServico(ServicoDAO.getInstance().instantiateObject(resultSet));
		presta.setValor(resultSet.getFloat("Valor"));
		return presta;
	}

}
