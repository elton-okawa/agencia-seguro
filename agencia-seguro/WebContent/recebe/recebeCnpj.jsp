<jsp:include page="../common/header.jsp" />

<%@page import="model.Recebe"%>
<%@page import="java.util.List" %>
<%@page import="java.util.ArrayList" %>

<% List<Recebe> recebeList = (List<Recebe>) request.getAttribute("recebeList");%>

<div class="container">
	<h1 class="m-2">Recebe</h1>
	
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
				<th scope="col">RENAVAM</th>
				<th scope="col">IdServiço</th>
				<th scope="col">Serviço</th>
				<th scope="col">Empresa</th>
				<th scope="col">Data Início</th>
				<th scope="col">Data Término</th>
			</tr>
		</thead>
		<tbody>
		<% if (recebeList != null) { %>
			<% for (Recebe recebe: recebeList) { %>
				<tr>
					<td><%= recebe.getCarro().getRenavam() %></td>
					<td><%= recebe.getServico().getIdServico() %>
					<td><%= recebe.getServico().getTipo() %></td>
					<td><%= recebe.getPrestadorServico().getNome() %></td>
					<td><%= recebe.getDataInicio() %></td>
					<td><%= recebe.getDataFim() %></td>
				</tr>
			<% } %>
		<% } %>
		</tbody>
	</table>

	<a class="btn btn-primary" href="/agencia-seguro/">Voltar</a>
</div>

<jsp:include page="../common/footer.jsp" />
