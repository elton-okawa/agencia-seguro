package dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Locale;

import model.Funcionario;

public class FuncionarioDAO extends DAO<Funcionario>{

	private static FuncionarioDAO instance = new FuncionarioDAO();
	
	private FuncionarioDAO() {
		super();
	}
	
	public static FuncionarioDAO getInstance() {
		return instance;
	}
	
	public boolean create(Funcionario funcionario) throws SQLException {
		String query = 
				String.format(Locale.US, "INSERT INTO FuncionarioDB (CPF, Nome, RG, Telefone, Email, Endereco, "
						+ "IdFuncionario, Salario, Cargo, Periodo, DataAdmissao)"
						+ " VALUES ('%s', '%s', '%s', '%s', '%s', '%s', "
						+ "%d, %2.f, '%s', '%s', '%s');", 
						funcionario.getCPF(), funcionario.getNome(), funcionario.getRG(), funcionario.getTelefone(), 
						funcionario.getEmail(), funcionario.getEndereco(), funcionario.getIdFuncionario(), 
						funcionario.getSalario(), funcionario.getCargo(), funcionario.getPeriodo(), 
						funcionario.getDataAdmissao());
		
		return super.create(query);
	}
	
	public Funcionario getFuncionarioByID(int id) throws SQLException {
		String query = String.format("SELECT * FROM FuncionarioDB WHERE IdFuncionario=%d", id);
		return super.getObjectByPrimaryKey(query);
	}
	
	public List<Funcionario> getAll() throws SQLException {
		String query = String.format("SELECT * FROM FuncionarioDB;");
		return super.getAll(query);
	}

	@Override
	protected Funcionario instantiateObject(ResultSet resultSet) throws SQLException {
		Funcionario funcionario = new Funcionario();
		
		funcionario.setCPF(resultSet.getString("CPF"));
		funcionario.setNome(resultSet.getString("Nome"));
		funcionario.setRG(resultSet.getString("RG"));
		funcionario.setTelefone(resultSet.getString("Telefone"));
		funcionario.setEmail(resultSet.getString("Email"));
		funcionario.setEndereco(resultSet.getString("Endereco"));
		
		funcionario.setIdFuncionario(resultSet.getInt("IdFuncionario"));
		funcionario.setSalario(resultSet.getFloat("Salario"));
		funcionario.setCargo(resultSet.getString("Cargo"));
		funcionario.setPeriodo(resultSet.getString("Periodo"));
		funcionario.setDataAdmissao(resultSet.getDate("DataAdmissao"));
		return funcionario;
	}
	
}
