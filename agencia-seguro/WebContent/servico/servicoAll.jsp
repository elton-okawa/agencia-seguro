<jsp:include page="../common/header.jsp" />

<%@page import="model.Servico"%>
<%@page import="java.util.List" %>
<%@page import="java.util.ArrayList" %>

<% List<Servico> servicoList = (List<Servico>) request.getAttribute("servicoList");%>

<div class="container">
	<h1 class="m-2">Serviços</h1>
	<table class="table table-striped mt-4">
		<thead class="thead-dark">
			<tr>
				<th scope="col">IdServiço</th>
				<th scope="col">Tipo</th>
				<th scope="col">Descrição</th>
			</tr>
		</thead>
		<tbody>
		<% for (Servico servico: servicoList) { %>
			<tr>
				<td><%= servico.getIdServico() %></td>
				<td><%= servico.getTipo() %></td>
				<td><%= servico.getDescricao() %></td>
			</tr>
		<% } %>
		</tbody>
	</table>

	<a class="btn btn-primary" href="/agencia-seguro/">Voltar</a>
</div>

<jsp:include page="../common/footer.jsp" />
