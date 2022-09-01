-- phpMyAdmin SQL Dump
-- version 4.9.1
-- https://www.phpmyadmin.net/
--
-- Host: localhost
-- Tempo de geração: 07-Jul-2022 às 20:35
-- Versão do servidor: 8.0.17
-- versão do PHP: 7.3.10

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Banco de dados: `bdpessoa`
--

-- --------------------------------------------------------

--
-- Estrutura da tabela `aluno`
--

CREATE TABLE `aluno` (
  `codigo` int(11) NOT NULL,
  `nome` varchar(50) DEFAULT NULL,
  `cpf` bigint(50) DEFAULT NULL,
  `dataNasc` date DEFAULT NULL,
  `telefone` varchar(20) DEFAULT NULL,
  `ra` varchar(20) DEFAULT NULL,
  `cora` float DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

--
-- Extraindo dados da tabela `aluno`
--

INSERT INTO `aluno` (`codigo`, `nome`, `cpf`, `dataNasc`, `telefone`, `ra`, `cora`) VALUES
(4, 'tdhntn', 45444545, NULL, '(35)99903-2909', '55455454', 5455440),
(5, 'tdhntn', 11590329635, NULL, '(35)99903-2909', '55455454', 5455440),
(6, 'kale', 11590329635, NULL, '(35)99903-2909', '55455454', 5455440),
(7, 'kale', 11590329635, NULL, '(35)99903-2909', '55455454', 5455440),
(8, 'brvio', 54544545545454, NULL, '(45)54754-5445', '54454444', 444444),
(9, 'fdbbf', 454545, NULL, '(35)99969-8956', '54454545', 5454540000),
(10, 'kkkkk', 4222222222, NULL, '(22)11212-1212', '1221211', 2121210),
(12, 'Zida', 211212221212, '1989-07-02', '(35)99999-9999', '2221221', 212121000),
(13, 'bdsbdfbdb', 44545454545, '2002-02-02', '(21)12121-2212', '2122121', 211212000),
(14, 'dfndn', 64664644, '1998-03-03', '(35)55658-9658', '5455454', 454545),
(15, 'ççççççççççççççççç', 5555555555, '1896-05-05', '(56)89898-9898', '44', 44);

-- --------------------------------------------------------

--
-- Estrutura da tabela `professor`
--

CREATE TABLE `professor` (
  `codigo` int(11) NOT NULL,
  `nome` varchar(50) DEFAULT NULL,
  `cpf` varchar(20) DEFAULT NULL,
  `dataNasc` date DEFAULT NULL,
  `telefone` varchar(20) DEFAULT NULL,
  `codFun` int(11) DEFAULT NULL,
  `salario` float DEFAULT NULL,
  `areaDeAtuacao` varchar(100) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

--
-- Extraindo dados da tabela `professor`
--

INSERT INTO `professor` (`codigo`, `nome`, `cpf`, `dataNasc`, `telefone`, `codFun`, `salario`, `areaDeAtuacao`) VALUES
(1, 'hhhhhhhhhhhhhhhhh', '744444444444', '1996-05-04', '(35)65656-5545', 4, 45454, 'vksehvjvhie');

-- --------------------------------------------------------

--
-- Estrutura da tabela `tecnicoadm`
--

CREATE TABLE `tecnicoadm` (
  `codigo` int(11) NOT NULL,
  `nome` varchar(50) DEFAULT NULL,
  `cpf` varchar(20) DEFAULT NULL,
  `dataNasc` date DEFAULT NULL,
  `telefone` varchar(20) DEFAULT NULL,
  `codFun` int(11) DEFAULT NULL,
  `salario` float DEFAULT NULL,
  `departamento` varchar(100) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

--
-- Extraindo dados da tabela `tecnicoadm`
--

INSERT INTO `tecnicoadm` (`codigo`, `nome`, `cpf`, `dataNasc`, `telefone`, `codFun`, `salario`, `departamento`) VALUES
(1, 'sdhbjvjvks', '5455454', '2012-12-12', '(21)21221-2211', 2212, 212121, 'fdsbgbrdb');

-- --------------------------------------------------------

--
-- Estrutura da tabela `usuario`
--

CREATE TABLE `usuario` (
  `codigo` int(11) NOT NULL,
  `nome` varchar(100) DEFAULT NULL,
  `senha` varchar(100) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

--
-- Extraindo dados da tabela `usuario`
--

INSERT INTO `usuario` (`codigo`, `nome`, `senha`) VALUES
(1, 'Pedro Henrique Cardoso Elias', 'PEDRO05072022'),
(2, 'Bruno Dionisio Alves', 'BRUNO05072022'),
(3, 'Jean Maia', 'JEAN05072022'),
(4, 'Leonardo Maia', 'LEONARDO05072022'),
(5, 'Maria Fernanda', 'MARIA05072022'),
(6, 'Jose Carlos', 'JOSE07072022'),
(7, 'Danilo Cardoso Consolini', 'DANILO07072022');

--
-- Índices para tabelas despejadas
--

--
-- Índices para tabela `aluno`
--
ALTER TABLE `aluno`
  ADD PRIMARY KEY (`codigo`);

--
-- Índices para tabela `professor`
--
ALTER TABLE `professor`
  ADD PRIMARY KEY (`codigo`);

--
-- Índices para tabela `tecnicoadm`
--
ALTER TABLE `tecnicoadm`
  ADD PRIMARY KEY (`codigo`);

--
-- Índices para tabela `usuario`
--
ALTER TABLE `usuario`
  ADD PRIMARY KEY (`codigo`);

--
-- AUTO_INCREMENT de tabelas despejadas
--

--
-- AUTO_INCREMENT de tabela `aluno`
--
ALTER TABLE `aluno`
  MODIFY `codigo` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=16;

--
-- AUTO_INCREMENT de tabela `professor`
--
ALTER TABLE `professor`
  MODIFY `codigo` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;

--
-- AUTO_INCREMENT de tabela `tecnicoadm`
--
ALTER TABLE `tecnicoadm`
  MODIFY `codigo` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;

--
-- AUTO_INCREMENT de tabela `usuario`
--
ALTER TABLE `usuario`
  MODIFY `codigo` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=8;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
