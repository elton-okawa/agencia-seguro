<jsp:include page="../common/header.jsp" />

<%@page import="model.Recebe"%>
<%@page import="java.util.List" %>
<%@page import="java.util.ArrayList" %>

<% List<Recebe> recebeList = (List<Recebe>) request.getAttribute("recebeList");%>

<div class="container">
	<h1 class="m-2">Recebe</h1>
	
	<h2>Per�odo solicitado</h2>
		<div class="border border-black rounded bg-light p-2">
	
			<form method="post">
			  <div class="row">
			    <div class="col">
			      <label for="input_data_inicial">Data Inicial</label>
			      <input name="intervaloInicio" type="date" class="form-control">
			    </div>
			    <div class="col">
			      <label for="input_data_final">Data Final</label>
			      <input name="intervaloFim" type="date" class="form-control">
			    </div>
			  </div>
			  <br>

			  <button type="submit" class="btn btn-info col col-sm-4">Gerar</button>
	
			</form>
		</div>
	
	
	<table class="table table-striped mt-4">
		<thead class="thead-dark">
			<tr>
				<th scope="col">RENAVAM</th>
				<th scope="col">IdServi�o</th>
				<th scope="col">Servi�o</th>
				<th scope="col">Empresa</th>
				<th scope="col">Data In�cio</th>
				<th scope="col">Data T�rmino</th>
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
