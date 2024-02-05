CREATE TABLE `produto` (
  `cd_produto` bigint NOT NULL AUTO_INCREMENT,
  `nome` varchar(255) DEFAULT NULL,
  `descricao` varchar(255) DEFAULT NULL,
  `valor` decimal(10,2),
  quantidade int ,
  PRIMARY KEY (`cd_produto`)
)