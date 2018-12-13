<jsp:include page="../common/header.jsp" />

<%@page import="model.Venda"%>
<%@page import="java.util.List" %>
<%@page import="java.util.ArrayList" %>

<% List<Venda> vendaList = (List<Venda>) request.getAttribute("vendaList");%>

<div class="container">
	<h1 class="m-2">Vendas</h1>
	
	<div class="border border-black rounded bg-light p-2">
		<form method="post">
			<label for="input-id">Renavam: </label>
			<div class="form-inline">
				<input class="form-control" name="renavam" type="text" id="input-renavam" required="required"></input>
				<input class="btn btn-info ml-2" type="submit" value="Procurar"></input>
			</div>
		</form>
	</div>
	
	
	<table class="table table-striped mt-4">
		<thead class="thead-dark">
			<tr>
				<th scope="col">RENAVAM</th>
				<th scope="col">Modelo</th>
				<th scope="col">Cliente</th>
				<th scope="col">Funcionario</th>
				<th scope="col">Data</th>
				<th scope="col">Valor</th>
			</tr>
		</thead>
		<tbody>
		<% if (vendaList != null) { %>
			<% for (Venda venda: vendaList) { %>
				<tr>
					<td><%= venda.getCarro().getRenavam() %></td>
					<td><%= venda.getCarro().getModelo() %></td>
					<td><%= venda.getCliente().getNome() %></td>
					<td><%= venda.getFuncionario().getNome() %></td>
					<td><%= venda.getDataVenda() %></td>
					<td><%= venda.getValor() %></td>
				</tr>
			<% } %>
		<% } %>
		</tbody>
	</table>

	<a class="btn btn-primary" href="/agencia-seguro/">Voltar</a>
</div>

<jsp:include page="../common/footer.jsp" />
