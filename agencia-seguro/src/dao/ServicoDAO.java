package dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import model.Funcionario;
import model.Servico;

public class ServicoDAO extends DAO<Servico>{

	private static ServicoDAO instance = new ServicoDAO();
	
	private ServicoDAO() {
		super();
	}
	
	public static ServicoDAO getInstance() {
		return instance;
	}
	
	public Servico getServicoByID(int id) throws SQLException {
		String query = String.format("SELECT * FROM ServicoDB WHERE IdServico=%d", id);
		return super.getObjectByPrimaryKey(query);
	}
	
	public List<Servico> getAll() throws SQLException {
		String query = String.format("SELECT * FROM ServicoDB;");
		return super.getAll(query);
	}
	
	@Override
	public Servico instantiateObject(ResultSet resultSet) throws SQLException {
		Servico servico = new Servico();
		servico.setIdServico(resultSet.getInt("IdServico"));
		servico.setTipo(resultSet.getString("Tipo"));
		servico.setDescricao(resultSet.getString("Descricao"));
		return servico;
	}

}
