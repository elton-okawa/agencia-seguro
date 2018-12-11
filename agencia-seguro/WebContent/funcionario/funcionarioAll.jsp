<jsp:include page="../common/header.jsp" />

<%@page import="model.Funcionario"%>
<%@page import="java.util.List" %>
<%@page import="java.util.ArrayList" %>

<% List<Funcionario> funcionarioList = (List<Funcionario>) request.getAttribute("funcionarioList");%>

<div class="container">
	<h1 class="m-2">Funcionários</h1>
	<table class="table table-striped mt-4">
		<thead class="thead-dark">
			<tr>
				<th scope="col">Id</th>
				<th scope="col">CPF</th>
				<th scope="col">Nome</th>
				<th scope="col">RG</th>
				<th scope="col">Telefone</th>
				<th scope="col">Email</th>
				<th scope="col">Endereço</th>
				<th scope="col">Cargo</th>
				<th scope="col">Período</th>
				<th scope="col">DataAdmissão</th>
			</tr>
		</thead>
		<tbody>
		<% for (Funcionario funcionario: funcionarioList) { %>
			<tr>
				<td><%= funcionario.getIdFuncionario() %></td>
				<td><%= funcionario.getCPF() %></td>
				<td><%= funcionario.getNome() %></td>
				<td><%= funcionario.getRG() %></td>
				<td><%= funcionario.getTelefone() %></td>
				<td><%= funcionario.getEmail() %></td>
				<td><%= funcionario.getEndereco() %></td>
				<td><%= funcionario.getCargo() %></td>
				<td><%= funcionario.getPeriodo() %></td>
				<td><%= funcionario.getDataAdmissao() %></td>
			</tr>
		<% } %>
		</tbody>
	</table>
	
	<a class="btn btn-primary" href="/agencia-seguro/">Voltar</a>
</div>

<jsp:include page="../common/footer.jsp" />