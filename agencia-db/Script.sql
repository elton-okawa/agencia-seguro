--<ScriptOptions statementTerminator=";"/>

CREATE TABLE ClienteDB (
	CPF CHAR(32) NOT NULL,
	Nome CHAR(64),
	RG CHAR(32),
	Telefone CHAR(32),
	Email CHAR(64),
	Endereco CHAR(128),
	IdCliente INT NOT NULL,
	DataPrimeiraCompra DATE,
	PRIMARY KEY (CPF,IdCliente)
);

CREATE TABLE FuncionarioDB (
	CPF CHAR(32) NOT NULL,
	Nome CHAR(64),
	RG CHAR(32),
	Telefone CHAR(32),
	Email CHAR(64),
	Endereco CHAR(128),
	IdFuncionario INT NOT NULL,
	Salario FLOAT,
	Cargo CHAR(32),
	Periodo CHAR(32),
	DataAdmissao DATE,
	PRIMARY KEY (CPF,IdFuncionario)
);

CREATE TABLE CarroDB (
	Renavam CHAR(32) NOT NULL,
	Marca CHAR(32),
	Modelo CHAR(128),
	Cor CHAR(32),
	Ano INT,
	NumeroPortas INT,
	Status CHAR(32),
	PRIMARY KEY (Renavam)
);

CREATE TABLE PrestadorServicoDB (
	IdFuncionario INT NOT NULL,
	CNPJ CHAR(32) NOT NULL,
	Nome CHAR(64),
	Endereco CHAR(128),
	Telefone CHAR(32),
	DataContratacao DATE,
	PRIMARY KEY (IdFuncionario,CNPJ)
);

CREATE TABLE ServicoDB (
	IdServico INT NOT NULL,
	Tipo CHAR(32),
	Descricao CHAR(255),
	PRIMARY KEY (IdServico)
);

CREATE TABLE PrestaDB (
	IdServico INT NOT NULL,
	CNPJ CHAR(32) NOT NULL,
	Valor FLOAT,
	PRIMARY KEY (IdServico,CNPJ)
);

CREATE TABLE VendaDB (
	Renavam CHAR(32) NOT NULL,
	IdCliente INT NOT NULL,
	DataVenda DATE NOT NULL,
	IdFuncionario INT NOT NULL,
	ValorVenda FLOAT,
	PRIMARY KEY (Renavam,IdCliente,DataVenda,IdFuncionario)
);

CREATE TABLE CompraDB (
	Renavam CHAR(32) NOT NULL,
	IdCliente INT NOT NULL,
	DataCompra DATE NOT NULL,
	IdFuncionario INT NOT NULL,
	ValorCompra FLOAT,
	PRIMARY KEY (IdCliente,Renavam,DataCompra,IdFuncionario)
);

CREATE TABLE RecebeDB (
	Renavam CHAR(32) NOT NULL,
	IdServico INT NOT NULL,
	CNPJ CHAR(32) NOT NULL,
	DataInicio DATE NOT NULL,
	DataFim DATE,
	PRIMARY KEY (Renavam,IdServico,CNPJ,DataInicio)
);

ALTER TABLE PrestadorServicoDB ADD CONSTRAINT FuncionarioContrata FOREIGN KEY (IdFuncionario)
	REFERENCES FuncionarioDB (CPF, IdFuncionario)
	ON DELETE CASCADE;

ALTER TABLE PrestaDB ADD CONSTRAINT ServicoPrestado FOREIGN KEY (IdServico)
	REFERENCES ServicoDB (IdServico)
	ON DELETE CASCADE;

ALTER TABLE PrestaDB ADD CONSTRAINT PrestadorPresta FOREIGN KEY (CNPJ)
	REFERENCES PrestadorServicoDB (IdFuncionario, CNPJ)
	ON DELETE CASCADE;

ALTER TABLE VendaDB ADD CONSTRAINT FuncionarioVende FOREIGN KEY (IdFuncionario)
	REFERENCES FuncionarioDB (CPF, IdFuncionario)
	ON DELETE CASCADE;

ALTER TABLE VendaDB ADD CONSTRAINT ClienteVende FOREIGN KEY (IdCliente)
	REFERENCES ClienteDB (CPF, IdCliente)
	ON DELETE CASCADE;

ALTER TABLE VendaDB ADD CONSTRAINT VendeCarro FOREIGN KEY (Renavam)
	REFERENCES CarroDB (Renavam)
	ON DELETE CASCADE;

ALTER TABLE CompraDB ADD CONSTRAINT CompraCarro FOREIGN KEY (Renavam)
	REFERENCES CarroDB (Renavam)
	ON DELETE CASCADE;

ALTER TABLE CompraDB ADD CONSTRAINT ClienteCompra FOREIGN KEY (IdCliente)
	REFERENCES ClienteDB (CPF, IdCliente)
	ON DELETE CASCADE;

ALTER TABLE CompraDB ADD CONSTRAINT FuncionarioCompra FOREIGN KEY (IdFuncionario)
	REFERENCES FuncionarioDB (CPF, IdFuncionario)
	ON DELETE CASCADE;

ALTER TABLE RecebeDB ADD CONSTRAINT RecebePrestadorServico FOREIGN KEY (CNPJ)
	REFERENCES PrestadorServicoDB (IdFuncionario, CNPJ)
	ON DELETE CASCADE;

ALTER TABLE RecebeDB ADD CONSTRAINT RecebeServico FOREIGN KEY (IdServico)
	REFERENCES ServicoDB (IdServico)
	ON DELETE CASCADE;

ALTER TABLE RecebeDB ADD CONSTRAINT CarroRecebe FOREIGN KEY (Renavam)
	REFERENCES CarroDB (Renavam)
	ON DELETE CASCADE;

