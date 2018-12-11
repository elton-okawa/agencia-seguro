<jsp:include page="../common/header.jsp" />

<%@page import="model.Funcionario"%>
<%@page import="java.util.List" %>
<%@page import="java.util.ArrayList" %>

<% Funcionario funcionario = (Funcionario) request.getAttribute("funcionario");%>

<div class="container">
	<h1 class="m-2">Funcionário</h1>
	
	<div class="border border-black rounded bg-light p-2">
		<form method="post">
			<label for="input-id">Id do funcionário: </label>
			<div class="form-inline">
				<input class="form-control" name="id" type="number" id="input-id" required="required"></input>
				<input class="btn btn-info ml-2" type="submit" value="Procurar"></input>
			</div>
		</form>
	</div>
	
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
			<% if (funcionario != null) {%>
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