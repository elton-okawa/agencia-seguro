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
	
	<div class="row mt-4">
		<div class="col-sm-3">
			<a class="btn btn-primary btn-block" href="ControleRecebe?type=all">Recebe</a>
		</div>
		<div class="col-sm-3">
			<a class="btn btn-info btn-block" href="ControleRecebe?type=cnpj">Recebe por CNPJ</a>
		</div>
		<div class="col-sm-3">
			<a class="btn btn-info btn-block" href="ControleRecebe?type=id">Recebe por IdServi�o</a>
		</div>
		<div class="col-sm-3">
			<a class="btn btn-info btn-block" href="ControleRecebe?type=renavam">Recebe por RENAVAM</a>
		</div>
		<div class="col-sm-3 mt-4">
			<a class="btn btn-info btn-block" href="ControleRecebe?type=periodo">Recebe por Per�odo</a>
		</div>
	</div>
	
	<div class="row mt-4">
		<div class="col-sm-3">
			<a class="btn btn-primary btn-block" href="ControleVenda?type=all">Venda</a>
		</div>
		<div class="col-sm-3">
			<a class="btn btn-info btn-block" href="ControleVenda?type=idCliente">Venda por IdCliente</a>
		</div>
		<div class="col-sm-3">
			<a class="btn btn-info btn-block" href="ControleVenda?type=idFuncionario">Venda por IdFuncion�rio</a>
		</div>
		<div class="col-sm-3">
			<a class="btn btn-info btn-block" href="ControleVenda?type=renavam">Venda por RENAVAM</a>
		</div>
		<div class="col-sm-3 mt-4">
			<a class="btn btn-info btn-block" href="ControleVenda?type=periodo">Venda por Per�odo</a>
		</div>
		<div class="col-sm-3 mt-4">
			<a class="btn btn-info btn-block" href="ControleVenda?type=valor">Venda por Valor</a>
		</div>
	</div>
	
	<div class="row mt-4">
		<div class="col-sm-3">
			<a class="btn btn-primary btn-block" href="ControleCompra?type=all">Compra</a>
		</div>
		<div class="col-sm-3">
			<a class="btn btn-info btn-block" href="ControleCompra?type=idCliente">Compra por IdCliente</a>
		</div>
		<div class="col-sm-3">
			<a class="btn btn-info btn-block" href="ControleCompra?type=idFuncionario">Compra por IdFuncion�rio</a>
		</div>
		<div class="col-sm-3">
			<a class="btn btn-info btn-block" href="ControleCompra?type=renavam">Compra por RENAVAM</a>
		</div>
		<div class="col-sm-3 mt-4">
			<a class="btn btn-info btn-block" href="ControleCompra?type=periodo">Compra por Per�odo</a>
		</div>
		<div class="col-sm-3 mt-4">
			<a class="btn btn-info btn-block" href="ControleCompra?type=valor">Compra por Valor</a>
		</div>
	</div>
	
</div>

<jsp:include page="common/footer.jsp" />