-- MySQL Workbench Forward Engineering
-- -----------------------------------------------------
-- Schema Hotel
-- -----------------------------------------------------
-- -----------------------------------------------------
-- Schema Hotel
-- -----------------------------------------------------
-- ESTE SQL ESTÁ ATUALIZADO E FUNCIONANDO
-- ULTIMO UPDATE 06/2024

CREATE SCHEMA IF NOT EXISTS `Hotel` ;
USE `Hotel` ;
-- -----------------------------------------------------
-- Table `Hotel`.`caixa`
-- -----------------------------------------------------



DROP TABLE IF EXISTS `Hotel`.`caixa` ;

CREATE TABLE IF NOT EXISTS `Hotel`.`caixa` (
  `id` INT   AUTO_INCREMENT,
  `valor_de_abertura` FLOAT  ,
  `valor_de_fechamento` FLOAT  ,
  `data_hora_abertura` DATETIME  ,
  `data_hora_fechamento` DATETIME  ,
  `obs` VARCHAR(100)  ,
  `status` VARCHAR(1)  ,
  PRIMARY KEY (`id`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `Hotel`.`quarto`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `Hotel`.`quarto` ;

CREATE TABLE IF NOT EXISTS `Hotel`.`quarto` (
  `id` INT   AUTO_INCREMENT,
  `descricao` VARCHAR(100)  ,
  `capacidade_hospedes` INT  ,
  `metragem` FLOAT  ,
  `identificacao` VARCHAR(45)  ,
  `andar` INT  ,
  `flag_animais` TINYINT  ,
  `obs` VARCHAR(100)  ,
  `status` VARCHAR(1)  ,
  PRIMARY KEY (`id`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `Hotel`.`check_quarto`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `Hotel`.`check_quarto` ;

CREATE TABLE IF NOT EXISTS `Hotel`.`check_quarto` (
  `id` INT   AUTO_INCREMENT,
  `data_hora_inicio` DATETIME  ,
  `data_hora_fim` DATETIME  ,
  `obs` VARCHAR(45)  ,
  `status` VARCHAR(1)  ,
  `quarto_id` INT  ,
  PRIMARY KEY (`id`),
  CONSTRAINT `fk_check_quarto_quarto1`
    FOREIGN KEY (`quarto_id`)
    REFERENCES `Hotel`.`quarto` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;

CREATE INDEX `fk_check_quarto_quarto1_idx` ON `Hotel`.`check_quarto` (`quarto_id` ASC) ;


-- -----------------------------------------------------
-- Table `Hotel`.`check`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `Hotel`.`check` ;

CREATE TABLE IF NOT EXISTS `Hotel`.`check` (
  `id` INT   AUTO_INCREMENT,
  `data_hora_cadastro` DATETIME  ,
  `data_hora_entrada` DATETIME  ,
  `data_hora_saida` DATETIME  ,
  `obs` VARCHAR(100)  ,
  `status` VARCHAR(1)  ,
  `check_quarto_id` INT  ,
  PRIMARY KEY (`id`),
  CONSTRAINT `fk_check_check_quarto1`
    FOREIGN KEY (`check_quarto_id`)
    REFERENCES `Hotel`.`check_quarto` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;

CREATE INDEX `fk_check_check_quarto1_idx` ON `Hotel`.`check` (`check_quarto_id` ASC) ;


-- -----------------------------------------------------
-- Table `Hotel`.`receber`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `Hotel`.`receber` ;

CREATE TABLE IF NOT EXISTS `Hotel`.`receber` (
  `id` INT   AUTO_INCREMENT,
  `data_hora_cadastro` DATETIME  ,
  `valor_original` FLOAT  ,
  `desconto` FLOAT  ,
  `acrescimo` FLOAT  ,
  `valor_pago` FLOAT  ,
  `obs` VARCHAR(100)  ,
  `status` VARCHAR(1)  ,
  `check_id` INT  ,
  PRIMARY KEY (`id`),
  CONSTRAINT `fk_receber_check1`
    FOREIGN KEY (`check_id`)
    REFERENCES `Hotel`.`check` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;

CREATE INDEX `fk_receber_check1_idx` ON `Hotel`.`receber` (`check_id` ASC) ;


-- -----------------------------------------------------
-- Table `Hotel`.`movimento_caixa`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `Hotel`.`movimento_caixa` ;

CREATE TABLE IF NOT EXISTS `Hotel`.`movimento_caixa` (
  `id` INT   AUTO_INCREMENT,
  `data_hora_movimento` DATETIME  ,
  `valor` FLOAT  ,
  `descricao` VARCHAR(100)  ,
  `obs` VARCHAR(100)  ,
  `status` VARCHAR(1)  ,
  `caixa_id` INT  ,
  `receber_id` INT  ,
  PRIMARY KEY (`id`),
  CONSTRAINT `fk_movimento_caixa_caixa`
    FOREIGN KEY (`caixa_id`)
    REFERENCES `Hotel`.`caixa` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_movimento_caixa_receber1`
    FOREIGN KEY (`receber_id`)
    REFERENCES `Hotel`.`receber` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;

CREATE INDEX `fk_movimento_caixa_caixa_idx` ON `Hotel`.`movimento_caixa` (`caixa_id` ASC) ;

CREATE INDEX `fk_movimento_caixa_receber1_idx` ON `Hotel`.`movimento_caixa` (`receber_id` ASC) ;


-- -----------------------------------------------------
-- Table `Hotel`.`marca`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `Hotel`.`marca` ;

CREATE TABLE IF NOT EXISTS `Hotel`.`marca` (
  `id` INT   AUTO_INCREMENT,
  `descricao` VARCHAR(100)  ,
  `status` VARCHAR(1)  ,
  PRIMARY KEY (`id`))
ENGINE = InnoDB; 


-- -----------------------------------------------------
-- Table `Hotel`.`modelo`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `Hotel`.`modelo` ;

CREATE TABLE IF NOT EXISTS `Hotel`.`modelo` (
  `id` INT   AUTO_INCREMENT,
  `descricao` VARCHAR(100)  ,
  `status` VARCHAR(1),
  `marca_id` INT,
  PRIMARY KEY (`id`),
  CONSTRAINT `fk_modelo_marca1`
    FOREIGN KEY (`marca_id`)
    REFERENCES `Hotel`.`marca` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;

CREATE INDEX `fk_modelo_marca1_idx` ON `Hotel`.`modelo` (`marca_id` ASC) ;


-- -----------------------------------------------------
-- Table `Hotel`.`funcionario`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `Hotel`.`funcionario` ;

CREATE TABLE IF NOT EXISTS `Hotel`.`funcionario` (
  `id` INT   AUTO_INCREMENT,
  `nome` VARCHAR(100),
  `sexo` VARCHAR(10) CHECK (`sexo` IN ('FEMININO', 'MASCULINO')) ,
  `fone` VARCHAR(16)  ,
  `fone2` VARCHAR(16)  ,
  `email` VARCHAR(100)  ,
  `cep` VARCHAR(10)  ,
  `logradouro` VARCHAR(100)  ,
  `bairro` VARCHAR(45)  ,
  `cidade` VARCHAR(45)  ,
  `complemento` VARCHAR(100)  ,
  `data_cadastro` DATETIME  ,
  `cpf` VARCHAR(14)  ,
  `rg` VARCHAR(14)  ,
  `obs` VARCHAR(100)  ,
  `status` VARCHAR(1)  ,
  `usuario` VARCHAR(45)  ,
  `senha` VARCHAR(45)  ,
  PRIMARY KEY (`id`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `Hotel`.`fornecedor`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `Hotel`.`fornecedor` ;

CREATE TABLE IF NOT EXISTS `Hotel`.`fornecedor` (
  `id` INT   AUTO_INCREMENT,
  `nome` VARCHAR(100)  ,
  `fone` VARCHAR(16)  ,
  `fone2` VARCHAR(16)  ,
  `email` VARCHAR(100)  ,
  `cep` VARCHAR(10)  ,
  `logradouro` VARCHAR(100)  ,
  `bairro` VARCHAR(45)  ,
  `cidade` VARCHAR(45)  ,
  `complemento` VARCHAR(100)  ,
  `data_cadastro` DATETIME  ,
  `cpf` VARCHAR(14)  ,
  `rg` VARCHAR(14)  ,
  `obs` VARCHAR(100)  ,
  `status` VARCHAR(1)  ,
  `usuario` VARCHAR(45)  ,
  `senha` VARCHAR(45)  ,
  `razao_social` VARCHAR(100)  ,
  `cnpj` VARCHAR(18)  ,
  `inscricao_estadual` VARCHAR(15)  ,
  `contato` VARCHAR(100)  ,
  PRIMARY KEY (`id`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `Hotel`.`hospede`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `Hotel`.`hospede` ;

CREATE TABLE IF NOT EXISTS `Hotel`.`hospede` (
  `id` INT   AUTO_INCREMENT,
  `nome` VARCHAR(100)  ,
  `sexo` VARCHAR(10) CHECK (`sexo` IN ('FEMININO', 'MASCULINO')),
  `fone` VARCHAR(16)  ,
  `fone2` VARCHAR(16)  ,
  `email` VARCHAR(100)  ,
  `cep` VARCHAR(10)  ,
  `logradouro` VARCHAR(100)  ,
  `bairro` VARCHAR(45)  ,
  `cidade` VARCHAR(45)  ,
  `complemento` VARCHAR(100)  ,
  `data_cadastro` DATETIME  ,
  `cpf` VARCHAR(14)  ,
  `rg` VARCHAR(14)  ,
  `obs` VARCHAR(100)  ,
  `status` VARCHAR(1)  ,
  `usuario` VARCHAR(45)  ,
  `senha` VARCHAR(45)  ,
  `razao_social` VARCHAR(100)  ,
  `cnpj` VARCHAR(18)  ,
  `inscricao_estadual` VARCHAR(15)  ,
  `contato` VARCHAR(100)  ,
  PRIMARY KEY (`id`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `Hotel`.`veiculo`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `Hotel`.`veiculo` ;

CREATE TABLE IF NOT EXISTS `Hotel`.`veiculo` (
  `id` INT   AUTO_INCREMENT,
  `placa` VARCHAR(7)  ,
  `cor` VARCHAR(45)  ,
  `modelo_id` INT  ,
  `funcionario_id` INT  ,
  `fornecedor_id` INT  ,
  `hospede_id` INT  ,
  `status` VARCHAR(1) NULL,
  PRIMARY KEY (`id`),
  CONSTRAINT `fk_veiculo_modelo1`
    FOREIGN KEY (`modelo_id`)
    REFERENCES `Hotel`.`modelo` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_veiculo_funcionario1`
    FOREIGN KEY (`funcionario_id`)
    REFERENCES `Hotel`.`funcionario` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_veiculo_fornecedor1`
    FOREIGN KEY (`fornecedor_id`)
    REFERENCES `Hotel`.`fornecedor` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_veiculo_hospede1`
    FOREIGN KEY (`hospede_id`)
    REFERENCES `Hotel`.`hospede` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;

CREATE INDEX `fk_veiculo_modelo1_idx` ON `Hotel`.`veiculo` (`modelo_id` ASC) ;

CREATE INDEX `fk_veiculo_funcionario1_idx` ON `Hotel`.`veiculo` (`funcionario_id` ASC) ;

CREATE INDEX `fk_veiculo_fornecedor1_idx` ON `Hotel`.`veiculo` (`fornecedor_id` ASC) ;

CREATE INDEX `fk_veiculo_hospede1_idx` ON `Hotel`.`veiculo` (`hospede_id` ASC) ;


-- -----------------------------------------------------
-- Table `Hotel`.`vaga_estacionamento`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `Hotel`.`vaga_estacionamento` ;

CREATE TABLE IF NOT EXISTS `Hotel`.`vaga_estacionamento` (
  `id` INT   AUTO_INCREMENT,
  `descricao` VARCHAR(100)  ,
  `obs` VARCHAR(100)  ,
  `metragem_vaga` FLOAT  ,
  `status` VARCHAR(1)  ,
  PRIMARY KEY (`id`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `Hotel`.`alocacao_vaga`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `Hotel`.`alocacao_vaga` ;

CREATE TABLE IF NOT EXISTS `Hotel`.`alocacao_vaga` (
  `id` INT   AUTO_INCREMENT,
  `obs` VARCHAR(100)  ,
  `status` VARCHAR(1)  ,
  `veiculo_id` INT  ,
  `vaga_estacionamento_id` INT  ,
  `check_id` INT  ,
  PRIMARY KEY (`id`),
  CONSTRAINT `fk_alocacao_vaga_veiculo1`
    FOREIGN KEY (`veiculo_id`)
    REFERENCES `Hotel`.`veiculo` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_alocacao_vaga_vaga_estacionamento1`
    FOREIGN KEY (`vaga_estacionamento_id`)
    REFERENCES `Hotel`.`vaga_estacionamento` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_alocacao_vaga_check1`
    FOREIGN KEY (`check_id`)
    REFERENCES `Hotel`.`check` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;

CREATE INDEX `fk_alocacao_vaga_veiculo1_idx` ON `Hotel`.`alocacao_vaga` (`veiculo_id` ASC) ;

CREATE INDEX `fk_alocacao_vaga_vaga_estacionamento1_idx` ON `Hotel`.`alocacao_vaga` (`vaga_estacionamento_id` ASC) ;

CREATE INDEX `fk_alocacao_vaga_check1_idx` ON `Hotel`.`alocacao_vaga` (`check_id` ASC) ;


-- -----------------------------------------------------
-- Table `Hotel`.`check_hospede`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `Hotel`.`check_hospede` ;

CREATE TABLE IF NOT EXISTS `Hotel`.`check_hospede` (
  `id` INT   AUTO_INCREMENT,
  `tipo_hospede` VARCHAR(45)  ,
  `obs` VARCHAR(100)  ,
  `status` VARCHAR(1)  ,
  `check_id` INT  ,
  `hospede_id` INT  ,
  PRIMARY KEY (`id`),
  CONSTRAINT `fk_check_hospede_check1`
    FOREIGN KEY (`check_id`)
    REFERENCES `Hotel`.`check` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_check_hospede_hospede1`
    FOREIGN KEY (`hospede_id`)
    REFERENCES `Hotel`.`hospede` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;

CREATE INDEX `fk_check_hospede_check1_idx` ON `Hotel`.`check_hospede` (`check_id` ASC) ;

CREATE INDEX `fk_check_hospede_hospede1_idx` ON `Hotel`.`check_hospede` (`hospede_id` ASC) ;


-- -----------------------------------------------------
-- Table `Hotel`.`reserva`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `Hotel`.`reserva` ;

CREATE TABLE IF NOT EXISTS `Hotel`.`reserva` (
  `id` INT   AUTO_INCREMENT,
  `data_hora_reserva` DATETIME  ,
  `data_prevista_entrada` DATE  ,
  `data_prevista_saida` DATE  ,
  `obs` VARCHAR(45)  ,
  `status` VARCHAR(45)  ,
  `check_id` INT  ,
  PRIMARY KEY (`id`),
  CONSTRAINT `fk_reserva_check1`
    FOREIGN KEY (`check_id`)
    REFERENCES `Hotel`.`check` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;

CREATE INDEX `fk_reserva_check1_idx` ON `Hotel`.`reserva` (`check_id` ASC) ;


-- -----------------------------------------------------
-- Table `Hotel`.`reserva_quarto`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `Hotel`.`reserva_quarto` ;

CREATE TABLE IF NOT EXISTS `Hotel`.`reserva_quarto` (
  `id` INT   AUTO_INCREMENT,
  `data_hora_inicio` DATETIME  ,
  `data_hora_fim` DATETIME  ,
  `obs` VARCHAR(45)  ,
  `status` VARCHAR(45)  ,
  `reserva_id` INT  ,
  `quarto_id` INT  ,
  PRIMARY KEY (`id`),
  CONSTRAINT `fk_reserva_quarto_reserva1`
    FOREIGN KEY (`reserva_id`)
    REFERENCES `Hotel`.`reserva` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_reserva_quarto_quarto1`
    FOREIGN KEY (`quarto_id`)
    REFERENCES `Hotel`.`quarto` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;

CREATE INDEX `fk_reserva_quarto_reserva1_idx` ON `Hotel`.`reserva_quarto` (`reserva_id` ASC) ;

CREATE INDEX `fk_reserva_quarto_quarto1_idx` ON `Hotel`.`reserva_quarto` (`quarto_id` ASC) ;


-- -----------------------------------------------------
-- Table `Hotel`.`copa_quarto`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `Hotel`.`copa_quarto` ;

CREATE TABLE IF NOT EXISTS `Hotel`.`copa_quarto` (
  `id` INT   AUTO_INCREMENT,
  `quantidade` FLOAT  ,
  `data_hora_pedido` DATETIME  ,
  `obs` VARCHAR(45)  ,
  `status` VARCHAR(45)  ,
  `check_quarto_id` INT  ,
  PRIMARY KEY (`id`),
  CONSTRAINT `fk_copa_quarto_check_quarto1`
    FOREIGN KEY (`check_quarto_id`)
    REFERENCES `Hotel`.`check_quarto` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;

CREATE INDEX `fk_copa_quarto_check_quarto1_idx` ON `Hotel`.`copa_quarto` (`check_quarto_id` ASC) ;


-- -----------------------------------------------------
-- Table `Hotel`.`produto_copa`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `Hotel`.`produto_copa` ;

CREATE TABLE IF NOT EXISTS `Hotel`.`produto_copa` (
  `id` INT   AUTO_INCREMENT,
  `decricao` VARCHAR(100)  ,
  `valor` FLOAT  ,
  `obs` VARCHAR(100)  ,
  `status` VARCHAR(1)  ,
  `copa_quarto_id` INT  ,
  PRIMARY KEY (`id`),
  CONSTRAINT `fk_produto_copa_copa_quarto1`
    FOREIGN KEY (`copa_quarto_id`)
    REFERENCES `Hotel`.`copa_quarto` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;

CREATE INDEX `fk_produto_copa_copa_quarto1_idx` ON `Hotel`.`produto_copa` (`copa_quarto_id` ASC) ;


-- -----------------------------------------------------
-- Table `Hotel`.`servico`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `Hotel`.`servico` ;

CREATE TABLE IF NOT EXISTS `Hotel`.`servico` (
  `id` INT   AUTO_INCREMENT,
  `descricao` VARCHAR(100)  ,
  `obs` VARCHAR(100)  ,
  `STATUS` VARCHAR(1) NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `Hotel`.`oderm_servico`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `Hotel`.`oderm_servico` ;

CREATE TABLE IF NOT EXISTS `Hotel`.`oderm_servico` (
  `id` INT   AUTO_INCREMENT,
  `data_hora_cadastro` DATETIME  ,
  `data_hora_prevista_inicio` DATETIME  ,
  `data_hora_prevista_termino` DATETIME  ,
  `obs` VARCHAR(100)  ,
  `status` VARCHAR(1)  ,
  `check_id` INT  ,
  `servico_id` INT  ,
  `quarto_id` INT  ,
  PRIMARY KEY (`id`),
  CONSTRAINT `fk_oderm_servico_check1`
    FOREIGN KEY (`check_id`)
    REFERENCES `Hotel`.`check` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_oderm_servico_servico1`
    FOREIGN KEY (`servico_id`)
    REFERENCES `Hotel`.`servico` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_oderm_servico_quarto1`
    FOREIGN KEY (`quarto_id`)
    REFERENCES `Hotel`.`quarto` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;

CREATE INDEX `fk_oderm_servico_check1_idx` ON `Hotel`.`oderm_servico` (`check_id` ASC) ;

CREATE INDEX `fk_oderm_servico_servico1_idx` ON `Hotel`.`oderm_servico` (`servico_id` ASC) ;

CREATE INDEX `fk_oderm_servico_quarto1_idx` ON `Hotel`.`oderm_servico` (`quarto_id` ASC) ;
