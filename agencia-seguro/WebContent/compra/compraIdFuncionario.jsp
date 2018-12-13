<jsp:include page="../common/header.jsp" />

<%@page import="model.Compra"%>
<%@page import="java.util.List" %>
<%@page import="java.util.ArrayList" %>

<% List<Compra> compraList = (List<Compra>) request.getAttribute("compraList");%>

<div class="container">
	<h1 class="m-2">Compras</h1>
	
	<div class="border border-black rounded bg-light p-2">
		<form method="post">
			<label for="input-id">Id do Funcion√°rio: </label>
			<div class="form-inline">
				<input class="form-control" name="idFuncionario" type="number" id="input-id" required="required"></input>
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
				<th scope="col">Funcion·rio</th>
				<th scope="col">Data</th>
				<th scope="col">Valor</th>
			</tr>
		</thead>
		<tbody>
		<% if (compraList != null) {%>
			<% for (Compra compra: compraList) { %>
				<tr>
					<td><%= compra.getCarro().getRenavam() %></td>
					<td><%= compra.getCarro().getModelo() %></td>
					<td><%= compra.getCliente().getNome() %></td>
					<td><%= compra.getFuncionario().getNome() %></td>
					<td><%= compra.getDataCompra() %></td>
					<td><%= compra.getValor() %></td>
				</tr>
			<% } %>
		<% } %>
		</tbody>
	</table>

	<a class="btn btn-primary" href="/agencia-seguro/">Voltar</a>
</div>

<jsp:include page="../common/footer.jsp" />
