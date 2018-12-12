<jsp:include page="../common/header.jsp" />

<%@page import="model.Carro"%>
<%@page import="java.util.List" %>
<%@page import="java.util.ArrayList" %>

<% Carro carro = (Carro) request.getAttribute("carro");%>

<div class="container">
	<h1 class="m-2">Carro</h1>
	
	<div class="border border-black rounded bg-light p-2">
		<form method="post">
			<label for="input-renavam">Renavam: </label>
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
				<th scope="col">Marca</th>
				<th scope="col">Modelo</th>
				<th scope="col">Cor</th>
				<th scope="col">Ano</th>
				<th scope="col">Numero de Portas</th>
				<th scope="col">Status</th>
			</tr>
		</thead>
		<tbody>
			<% if (carro != null) {%>
			<tr>
				<td><%= carro.getRenavam() %></td>
				<td><%= carro.getMarca() %></td>
				<td><%= carro.getModelo() %></td>
				<td><%= carro.getCor() %></td>
				<td><%= carro.getAno() %></td>
				<td><%= carro.getNumeroPortas() %></td>
				<td><%= carro.getStatus() %></td>
			</tr>
			<% } %>
		</tbody>
	</table>
	
	<a class="btn btn-primary" href="/agencia-seguro/">Voltar</a>
</div>

<jsp:include page="../common/footer.jsp" />