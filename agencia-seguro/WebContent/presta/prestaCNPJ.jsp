<jsp:include page="../common/header.jsp" />

<%@page import="model.Presta"%>
<%@page import="java.util.List" %>
<%@page import="java.util.ArrayList" %>

<% List<Presta> prestaList = (List<Presta>) request.getAttribute("prestaList");%>

<div class="container">
	<h1 class="m-2">Prestação de Serviços</h1>
	
	<div class="border border-black rounded bg-light p-2">
		<form method="post">
			<label for="input-cnpj">CNPJ: </label>
			<div class="form-inline">
				<input class="form-control" name="cnpj" type="text" id="input-cnpj" required="required"></input>
				<input class="btn btn-info ml-2" type="submit" value="Procurar"></input>
			</div>
		</form>
	</div>
	
	<table class="table table-striped mt-4">
		<thead class="thead-dark">
			<tr>
				<th scope="col">IdServiço</th>
				<th scope="col">Tipo</th>
				<th scope="col">CNPJ</th>
				<th scope="col">Empresa</th>
				<th scope="col">Valor</th>
			</tr>
		</thead>
		<tbody>
			<% if (prestaList != null) {%>
				<% for (Presta presta : prestaList) {%>
				<tr>
					<td><%= presta.getServico().getIdServico() %></td>
					<td><%= presta.getServico().getTipo() %></td>
					<td><%= presta.getPrestadorServico().getCNPJ() %></td>
					<td><%= presta.getPrestadorServico().getNome() %></td>
					<td><%= presta.getValor() %></td>
				</tr>
				<% } %>
			<% } %>
		</tbody>
	</table>
	
	<a class="btn btn-primary" href="/agencia-seguro/">Voltar</a>
</div>

<jsp:include page="../common/footer.jsp" />