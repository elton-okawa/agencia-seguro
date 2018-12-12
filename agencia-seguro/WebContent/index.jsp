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
			<a class="btn btn-primary btn-block" href="ControlePrestadorServico?type=all">PrestadorServi�o</a>
		</div>
		<div class="col-sm-3">
			<a class="btn btn-info btn-block" href="ControlePrestadorServico?type=cnpj">PrestadorServi�o por CNPJ</a>
		</div>
	</div>
	
	<div class="row mt-4">
		<div class="col-sm-3">
			<a class="btn btn-primary btn-block" href="ControleServico?type=all">Servi�os</a>
		</div>
		<div class="col-sm-3">
			<a class="btn btn-info btn-block" href="ControleServico?type=id">Servi�o por id</a>
		</div>
	</div>
	
	<div class="row mt-4">
		<div class="col-sm-3">
			<a class="btn btn-primary btn-block" href="ControlePresta?type=all">Presta��oDeServi�o</a>
		</div>
		<div class="col-sm-3">
			<a class="btn btn-info btn-block" href="ControlePresta?type=cnpj">Presta��oDeServi�o por CNPJ</a>
		</div>
		<div class="col-sm-3">
			<a class="btn btn-info btn-block" href="ControlePresta?type=id">Presta��oDeServi�o por IdServi�o</a>
		</div>
	</div>
	
</div>

<jsp:include page="common/footer.jsp" />