<jsp:include page="../common/header.jsp" />

<%@page import="model.PrestadorServico"%>
<%@page import="java.util.List" %>
<%@page import="java.util.ArrayList" %>

<% PrestadorServico prestadorServico = (PrestadorServico) request.getAttribute("prestadorServico");%>

<div class="container">
	<h1 class="m-2">Prestador de Serviço</h1>
	
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
				<th scope="col">Funcionário responsável</th>
				<th scope="col">CNPJ</th>
				<th scope="col">Nome</th>
				<th scope="col">Telefone</th>
				<th scope="col">Endereço</th>
				<th scope="col">Data da Contratação</th>
			</tr>
		</thead>
		<tbody>
			<% if (prestadorServico != null) {%>
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