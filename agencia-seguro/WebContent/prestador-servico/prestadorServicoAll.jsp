<jsp:include page="../common/header.jsp" />

<%@page import="model.PrestadorServico"%>
<%@page import="java.util.List" %>
<%@page import="java.util.ArrayList" %>

<% List<PrestadorServico> prestadorServicoList = (List<PrestadorServico>) request.getAttribute("prestadorServicoList");%>

<div class="container">
	<h1 class="m-2">Prestadores de Serviços</h1>
	<table class="table table-striped mt-4">
		<thead class="thead-dark">
			<tr>
				<th scope="col">Funcionário Responsável</th>
				<th scope="col">CNPJ</th>
				<th scope="col">Nome</th>
				<th scope="col">Telefone</th>
				<th scope="col">Endereço</th>
				<th scope="col">Data da Contratação</th>
			</tr>
		</thead>
		<tbody>
		<% for (PrestadorServico prestadorServico: prestadorServicoList) { %>
			<tr>
				<td><%= prestadorServico.getFuncionario().getNome() %></td>
				<td><%= prestadorServico.getCNPJ() %></td>
				<td><%= prestadorServico.getNome() %></td>
				<td><%= prestadorServico.getTelefone() %></td>
				<td><%= prestadorServico.getEndereco() %></td>
				<td><%= prestadorServico.getDataContratacao() %></td>
			</tr>
		<% } %>
		</tbody>
	</table>

	<a class="btn btn-primary" href="/agencia-seguro/">Voltar</a>
</div>

<jsp:include page="../common/footer.jsp" />
