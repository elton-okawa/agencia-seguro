-- CLIENTE 
INSERT INTO ClienteDB (IdCliente, CPF, Nome, RG, Telefone, Email, Endereco, DataPrimeiraCompra)
VALUES (1, "259.731.925-39", "Leonardo Benjamin Joaquim Martins", "50.050.217-1", "(86) 99729-4529", "leonardo81@supercarioca.com", "Rua Dez", "2008-10-10");

-- FUNCIONARIO
INSERT INTO FuncionarioDB (IdFuncionario, CPF, Nome, RG, Telefone, Email, Endereco, Salario, Cargo, Periodo, DataAdmissao)
VALUES (1, "805.071.302-43", "Aurora Sônia Teixeira", "18.633.472-2", "(85) 3532-7207", "aurorasoniateixeira@danzarin.com.br", "Avenida Bibio Frota", 1500.00, "Gerente", "Diurno", "2015-08-10");

-- PRESTADOR SERVICO 
INSERT INTO PrestadorServicoDB (CNPJ, Nome, Endereco, Telefone, DataContratacao, IdFuncionario)
VALUES ("05.249.838/0001-37", "Raimundo e Larissa Ltda", "Rua Projetada 04", "(67) 2930-2347", "2018-10-12", 1);

-- SERVICO 
INSERT INTO ServicoDB (IdServico, Tipo, Descricao)
VALUES (1, "Limpeza", "Apenas limpa os vidros");

-- PRESTA 
INSERT INTO PrestaDB (IdServico, CNPJ)
VALUES (1, "05.249.838/0001-37");

-- CARRO 
INSERT INTO CarroDB (Renavam, Marca, Modelo, Cor, Ano, NumeroPortas, Status)
VALUES ("46619734653", "EFFA", "ULC PICAPE CD 1.0 8V 4p", "Preto", "2010", 4, "Novo");

-- VENDA
INSERT INTO VendaDB (Renavam, DataVenda, IdCliente, IdFuncionario, ValorVenda)
VALUES ("46619734653", "2010-10-12", 1, 1, 25000.00);

-- COMPRA 
INSERT INTO CompraDB (Renavam, DataCompra, IdCliente, IdFuncionario, ValorCompra)
VALUES ("46619734653", "2015-10-01", 1, 1, 10000.00);

-- RECEBE 
INSERT INTO RecebeDB (Renavam, IdServico, CNPJ, DataInicio, DataFim)
VALUES ("46619734653", 1, "05.249.838/0001-37", "2015-10-02", "2015-10-03");