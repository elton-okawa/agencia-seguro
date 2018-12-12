<jsp:include page="common/header.jsp" />

<div class="container">
	<div class="row mt-4">
		<div class="col-sm-3">
			<a class="btn btn-primary btn-block" href="ControleFuncionario?type=all">Funcionarios</a>
		</div>
		<div class="col-sm-3">
			<a class="btn btn-info btn-block" href="ControleFuncionario?type=id">Funcionario por id</a>
		</div>
	</div>
	
	<div class="row mt-4">
		<div class="col-sm-3">
			<a class="btn btn-primary btn-block" href="ControleCarro?type=all">Carros</a>
		</div>
		<div class="col-sm-3">
			<a class="btn btn-info btn-block" href="ControleCarro?type=id">Carro por renavam</a>
		</div>
	</div>
	
	<div class="row mt-4">
		<div class="col-sm-3">
			<a class="btn btn-primary btn-block" href="ControleCliente?type=all">Clientes</a>
		</div>
		<div class="col-sm-3">
			<a class="btn btn-info btn-block" href="ControleCliente?type=id">Cliente por id</a>
		</div>
	</div>
	
	<div class="row mt-4">
		<div class="col-sm-3">
			<a class="btn btn-primary btn-block" href="ControlePrestadorServico?type=all">PrestadorServiço</a>
		</div>
		<div class="col-sm-3">
			<a class="btn btn-info btn-block" href="ControlePrestadorServico?type=cnpj">PrestadorServiço por CNPJ</a>
		</div>
	</div>
	
	<div class="row mt-4">
		<div class="col-sm-3">
			<a class="btn btn-primary btn-block" href="ControleServico?type=all">Serviços</a>
		</div>
		<div class="col-sm-3">
			<a class="btn btn-info btn-block" href="ControleServico?type=id">Serviço por id</a>
		</div>
	</div>
	
	<div class="row mt-4">
		<div class="col-sm-3">
			<a class="btn btn-primary btn-block" href="ControlePresta?type=all">PrestaçãoDeServiço</a>
		</div>
		<div class="col-sm-3">
			<a class="btn btn-info btn-block" href="ControlePresta?type=cnpj">PrestaçãoDeServiço por CNPJ</a>
		</div>
		<div class="col-sm-3">
			<a class="btn btn-info btn-block" href="ControlePresta?type=id">PrestaçãoDeServiço por IdServiço</a>
		</div>
	</div>
	
	<div class="row mt-4">
		<div class="col-sm-3">
			<a class="btn btn-primary btn-block" href="ControleRecebe?type=all">Recebe</a>
		</div>
		<div class="col-sm-3">
			<a class="btn btn-info btn-block" href="ControleRecebe?type=cnpj">Recebe por CNPJ</a>
		</div>
		<div class="col-sm-3">
			<a class="btn btn-info btn-block" href="ControleRecebe?type=id">Recebe por IdServiço</a>
		</div>
		<div class="col-sm-3">
			<a class="btn btn-info btn-block" href="ControleRecebe?type=renavam">Recebe por RENAVAM</a>
		</div>
	</div>
	<div class="row mt-4">
		<div class="col-sm-3">
			<a class="btn btn-info btn-block" href="ControleRecebe?type=periodo">Recebe por Período</a>
		</div>
	</div>
	
</div>

<jsp:include page="common/footer.jsp" />