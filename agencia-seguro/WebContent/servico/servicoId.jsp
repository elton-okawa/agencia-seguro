<jsp:include page="../common/header.jsp" />

<%@page import="model.Servico"%>
<%@page import="java.util.List" %>
<%@page import="java.util.ArrayList" %>

<% Servico servico = (Servico) request.getAttribute("servico");%>

<div class="container">
	<h1 class="m-2">Serviços</h1>
	
	<div class="border border-black rounded bg-light p-2">
		<form method="post">
			<label for="input-id">Id do Serviço: </label>
			<div class="form-inline">
				<input class="form-control" name="id" type="text" id="input-id" required="required"></input>
				<input class="btn btn-info ml-2" type="submit" value="Procurar"></input>
			</div>
		</form>
	</div>
	
	<table class="table table-striped mt-4">
		<thead class="thead-dark">
			<tr>
				<th scope="col">IdServiço</th>
				<th scope="col">Tipo</th>
				<th scope="col">Descrição</th>
			</tr>
		</thead>
		<tbody>
			<% if (servico != null) {%>
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