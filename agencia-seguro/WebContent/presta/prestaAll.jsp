<jsp:include page="../common/header.jsp" />

<%@page import="model.Presta"%>
<%@page import="java.util.List" %>
<%@page import="java.util.ArrayList" %>

<% List<Presta> prestaList = (List<Presta>) request.getAttribute("prestaList");%>

<div class="container">
	<h1 class="m-2">Serviços</h1>
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
			<% for (Presta presta : prestaList) {%>
			<tr>
				<td><%= presta.getServico().getIdServico() %></td>
				<td><%= presta.getServico().getTipo() %></td>
				<td><%= presta.getPrestadorServico().getCNPJ() %></td>
				<td><%= presta.getPrestadorServico().getNome() %></td>
				<td><%= presta.getValor() %></td>
			</tr>
			<% } %>
		</tbody>
	</table>

	<a class="btn btn-primary" href="/agencia-seguro/">Voltar</a>
</div>

<jsp:include page="../common/footer.jsp" />
