-- MySQL Workbench Forward Engineering
-- -----------------------------------------------------
-- Schema foodies
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `foodies` DEFAULT CHARACTER SET utf8mb4;
USE `foodies` ;

-- -----------------------------------------------------
-- Table `foodies`.`endereco`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `foodies`.`endereco` (
  `codEndereco` INT UNSIGNED NOT NULL,
  `cep` CHAR(8) NOT NULL,
  `cidade` VARCHAR(45) NOT NULL,
  `uf` CHAR(2) NOT NULL,
  `logradouro` VARCHAR(45) NOT NULL,
  `bairro` VARCHAR(45) NOT NULL,
  `numero` VARCHAR(10) NOT NULL,
  `complemento` VARCHAR(45) NULL,
  PRIMARY KEY (`codEndereco`));

-- -----------------------------------------------------
-- Table `foodies`.`restaurante`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `foodies`.`restaurante` (
  `codRestaurante` INT UNSIGNED NOT NULL,
  `nome` VARCHAR(50) NOT NULL,
  `telefone` VARCHAR(11) NOT NULL,
  `codEndereco` INT UNSIGNED NOT NULL,
  PRIMARY KEY (`codRestaurante`, `codEndereco`),
  UNIQUE INDEX `idRestaurante_UNIQUE` (`codRestaurante` ASC) VISIBLE,
  INDEX `fk_restaurante_endereco1_idx` (`codEndereco` ASC) VISIBLE,
  CONSTRAINT `fk_restaurante_endereco1`
    FOREIGN KEY (`codEndereco`)
    REFERENCES `foodies`.`endereco` (`codEndereco`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION);

-- -----------------------------------------------------
-- Table `foodies`.`cliente`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `foodies`.`cliente` (
  `codCliente` INT UNSIGNED NOT NULL,
  `nome` VARCHAR(60) NOT NULL,
  `telefone` VARCHAR(11) NOT NULL,
  `codEndereco` INT UNSIGNED NOT NULL,
  PRIMARY KEY (`codCliente`, `codEndereco`),
  INDEX `fk_cliente_endereco1_idx` (`codEndereco` ASC) VISIBLE,
  CONSTRAINT `fk_cliente_endereco1`
    FOREIGN KEY (`codEndereco`)
    REFERENCES `foodies`.`endereco` (`codEndereco`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION);

-- -----------------------------------------------------
-- Table `foodies`.`pedido`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `foodies`.`pedido` (
  `codPedido` INT UNSIGNED NOT NULL,
  `data` TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `status` VARCHAR(30) NOT NULL,
  `codRestaurante` INT UNSIGNED NOT NULL,
  `codEnderecoRes` INT NOT NULL,
  `codCliente` INT UNSIGNED NOT NULL,
  `codEnderecoCli` INT NOT NULL,
  PRIMARY KEY (`codPedido`, `codRestaurante`, `codEnderecoRes`, `codCliente`, `codEnderecoCli`),
  INDEX `fk_pedido_restaurante1_idx` (`codRestaurante` ASC, `codEnderecoRes` ASC) VISIBLE,
  INDEX `fk_pedido_cliente1_idx` (`codCliente` ASC, `codEnderecoCli` ASC) VISIBLE,
  CONSTRAINT `fk_pedido_restaurante1`
    FOREIGN KEY (`codRestaurante`)
    REFERENCES `foodies`.`restaurante` (`codRestaurante`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_pedido_cliente1`
    FOREIGN KEY (`codCliente`)
    REFERENCES `foodies`.`cliente` (`codCliente`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION);

-- -----------------------------------------------------
-- Table `foodies`.`cardapio`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `foodies`.`cardapio` (
  `idPrato` INT UNSIGNED NOT NULL,
  `nome` VARCHAR(45) NOT NULL,
  `descricao` VARCHAR(60) NULL,
  PRIMARY KEY (`idPrato`));

-- -----------------------------------------------------
-- Table `foodies`.`comanda`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `foodies`.`comanda` (
  `codPedido` INT UNSIGNED NOT NULL,
  `idPrato` INT UNSIGNED NOT NULL,
  PRIMARY KEY (`codPedido`, `idPrato`),
  INDEX `fk_cardapio_has_pedido_pedido1_idx` (`codPedido` ASC) VISIBLE,
  INDEX `fk_cardapio_has_pedido_cardapio1_idx` (`idPrato` ASC) VISIBLE,
  CONSTRAINT `fk_cardapio_has_pedido_cardapio1`
    FOREIGN KEY (`idPrato`)
    REFERENCES `foodies`.`cardapio` (`idPrato`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_cardapio_has_pedido_pedido1`
    FOREIGN KEY (`codPedido`)
    REFERENCES `foodies`.`pedido` (`codPedido`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION);

-- -----------------------------------------------------
-- Table `foodies`.`avaliacao`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `foodies`.`avaliacao` (
  `idAvaliacao` INT UNSIGNED NOT NULL,
  `descricao` VARCHAR(45) NULL,
  `codRestaurante` INT UNSIGNED NOT NULL,
  `codCliente` INT UNSIGNED NOT NULL,
  PRIMARY KEY (`idAvaliacao`, `codRestaurante`, `codCliente`),
  INDEX `fk_avaliacao_restaurante1_idx` (`codRestaurante` ASC) VISIBLE,
  INDEX `fk_avaliacao_cliente1_idx` (`codCliente` ASC) VISIBLE,
  CONSTRAINT `fk_avaliacao_restaurante1`
    FOREIGN KEY (`codRestaurante`)
    REFERENCES `foodies`.`restaurante` (`codRestaurante`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_avaliacao_cliente1`
    FOREIGN KEY (`codCliente`)
    REFERENCES `foodies`.`cliente` (`codCliente`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION);
    
-- 21/10 - RESTANTE DA ATIVIDADE:
-- 1- Criar outra tabela além das desenvolvidas no diagrama;
-- 2- Alterar a estrutura da nova tabela, inserindo novas colunas;
-- 3- Criar outra tabela ficticia e realizar a sua deleção.
    
-- 1):
CREATE TABLE IF NOT EXISTS `foodies`.`entregador` (
    `idEntregador` INT UNSIGNED NOT NULL,
    `nome` VARCHAR(60) NOT NULL,
    PRIMARY KEY (`idEntregador`));

CREATE TABLE IF NOT EXISTS `foodies`.`entrega` (
	`idEntrega` INT UNSIGNED NOT NULL,
    `idEntregador` INT UNSIGNED NOT NULL,
    `codPedido` INT UNSIGNED NOT NULL,
    `codRestaurante` INT UNSIGNED NOT NULL,
    `codEnderecoRes` INT NOT NULL,
	`codCliente` INT UNSIGNED NOT NULL,
	`codEnderecoCli` INT NOT NULL,
    `data` TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
    PRIMARY KEY (`idEntrega`),
    FOREIGN KEY (`idEntregador`) REFERENCES `foodies`.`entregador` (`idEntregador`));
    
-- 2):
ALTER TABLE `foodies`.`entregador` ADD `telefone` VARCHAR(11) NOT NULL;
ALTER TABLE `foodies`.`entregador` ADD `tipoVeiculo` VARCHAR(20) NOT NULL;
ALTER TABLE `foodies`.`entregador` ADD `dataInicio` TIMESTAMP DEFAULT CURRENT_TIMESTAMP;
ALTER TABLE `foodies`.`entregador` ADD `dataFim` TIMESTAMP;

-- 3):
CREATE TABLE IF NOT EXISTS `foodies`.`funcionario` (
    `idFuncionario` INT UNSIGNED NOT NULL,
    `nome` VARCHAR(60) NOT NULL,
    PRIMARY KEY (`idFuncionario`));
    
DROP TABLE `foodies`.`funcionario`;

-- 24/10 - RESTANTE DA ATIVIDADE:
-- 1- Adicionar 3 registros em cada tabela criada no banco:

-- 1):