package dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import model.Funcionario;
import model.PrestadorServico;

public class PrestadorServicoDAO extends DAO<PrestadorServico>{

	private static PrestadorServicoDAO instance = new PrestadorServicoDAO();
	
	private PrestadorServicoDAO() {
		super();
	}
	
	public static PrestadorServicoDAO getInstance() {
		return instance;
	}
	
	public PrestadorServico getPrestadorServicoByCNPJ(String cnpj) throws SQLException {
		String query = String.format("SELECT * FROM PrestadorServico WHERE CNPJ='%s'", cnpj);
		return super.getObjectByPrimaryKey(query);
	}
	
	public List<PrestadorServico> getAll() throws SQLException {
		String query = String.format("SELECT * FROM PrestadorServico;");
		return super.getAll(query);
	}
	
	@Override
	protected PrestadorServico instantiateObject(ResultSet resultSet) throws SQLException {
		PrestadorServico prestadorServico = new PrestadorServico();
		
		prestadorServico.setFuncionario(
				FuncionarioDAO.getInstance().getFuncionarioByID(resultSet.getInt("IdFuncionario")));
		prestadorServico.setCNPJ(resultSet.getString("CNPJ"));
		prestadorServico.setNome(resultSet.getString("Nome"));
		prestadorServico.setEndereco(resultSet.getString("Endereco"));
		prestadorServico.setTelefone(resultSet.getString("Telefone"));
		prestadorServico.setDataContratacao(resultSet.getDate("DataContratacao"));
		return prestadorServico;
	}

}
