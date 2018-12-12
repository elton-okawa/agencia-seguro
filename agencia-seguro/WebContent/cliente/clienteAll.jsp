<jsp:include page="../common/header.jsp" />

<%@page import="model.Cliente"%>
<%@page import="java.util.List" %>
<%@page import="java.util.ArrayList" %>

<% List<Cliente> clienteList = (List<Cliente>) request.getAttribute("clienteList");%>

<div class="container">
	<h1 class="m-2">Clientes</h1>
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
				<th scope="col">Data da Primeira Compra</th>
			</tr>
		</thead>
		<tbody>
		<% for (Cliente cliente: clienteList) { %>
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
