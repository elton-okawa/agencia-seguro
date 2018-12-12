<jsp:include page="../common/header.jsp" />

<%@page import="model.Cliente"%>
<%@page import="java.util.List" %>
<%@page import="java.util.ArrayList" %>

<% Cliente cliente = (Cliente) request.getAttribute("cliente");%>

<div class="container">
	<h1 class="m-2">Cliente</h1>
	
	<div class="border border-black rounded bg-light p-2">
		<form method="post">
			<label for="input-id">Id do Cliente: </label>
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
				<th scope="col">DataPrimeiraCompra</th>
			</tr>
		</thead>
		<tbody>
			<% if (cliente != null) {%>
			<tr>
				<td><%= cliente.getIdCliente() %></td>
				<td><%= cliente.getCPF() %></td>
				<td><%= cliente.getNome() %></td>
				<td><%= cliente.getRG() %></td>
				<td><%= cliente.getTelefone() %></td>
				<td><%= cliente.getEmail() %></td>
				<td><%= cliente.getEndereco() %></td>
				<td><%= cliente.getDataPrimeiraCompra() %></td>
			</tr>
			<% } %>
		</tbody>
	</table>
	
	<a class="btn btn-primary" href="/agencia-seguro/">Voltar</a>
</div>

<jsp:include page="../common/footer.jsp" />