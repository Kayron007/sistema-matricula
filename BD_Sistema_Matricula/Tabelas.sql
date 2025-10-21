CREATE DATABASE SISTEMA_MATRICULA;

USE SISTEMA_MATRICULA;

CREATE TABLE CURSO(
ID_CURSO INT PRIMARY KEY,
NOME_CURSO VARCHAR(100) NOT NULL,
CARGA_HORARIA INT NOT NULL
);

CREATE TABLE TURMA (
  ID_TURMA INT PRIMARY KEY AUTO_INCREMENT,
  ANO YEAR NOT NULL,
  SEMESTRE TINYINT NOT NULL CHECK (SEMESTRE IN (1,2)),
  ID_CURSO INT NOT NULL,
  CONSTRAINT FK_TURMA_CURSO FOREIGN KEY (ID_CURSO) REFERENCES CURSO(ID_CURSO)
);

CREATE TABLE ALUNOS (
  ID INT PRIMARY KEY,
  NOME VARCHAR(100),
  EMAIL VARCHAR(100),
  CPF_NUM CHAR(11) NOT NULL CHECK (CPF_NUM REGEXP '^[0-9]{11}$'),
  CPF_FOR CHAR(14) GENERATED ALWAYS AS (
    CONCAT(
      SUBSTRING(CPF_NUM, 1, 3), '.', 
      SUBSTRING(CPF_NUM, 4, 3), '.', 
      SUBSTRING(CPF_NUM, 7, 3), '-', 
      SUBSTRING(CPF_NUM, 10, 2)
    )
  ) STORED,
  ENDERECO VARCHAR(100),
  TELEFONE CHAR(11) CHECK (TELEFONE REGEXP '^[0-9]{10,11}$'),
  CONSTRAINT UQ_ALUNOS_CPFNUM UNIQUE (CPF_NUM)
);

CREATE TABLE MATERIA (
  ID_MATERIA INT PRIMARY KEY,
  NOME_MATERIA VARCHAR(100) NOT NULL,
  ID_CURSO INT NOT NULL,
  CONSTRAINT FK_ID_CURSO FOREIGN KEY (ID_CURSO) REFERENCES CURSO(ID_CURSO)
);

CREATE TABLE CURSO_MATERIA (
  ID_CURSO INT NOT NULL,
  ID_MATERIA INT NOT NULL,
  PRIMARY KEY (ID_CURSO, ID_MATERIA),
  CONSTRAINT FK_CM_CURSO FOREIGN KEY (ID_CURSO) REFERENCES CURSO(ID_CURSO),
  CONSTRAINT FK_CM_MATERIA FOREIGN KEY (ID_MATERIA) REFERENCES MATERIA(ID_MATERIA)
);

CREATE TABLE MATRICULA (
  ID INT PRIMARY KEY AUTO_INCREMENT,
  ID_ALUNO INT NOT NULL,
  ID_TURMA INT NOT NULL,
  STATUS BOOLEAN DEFAULT TRUE,
  DATA_MATRICULA DATE NOT NULL,
  CONSTRAINT FK_MATRICULA_ALUNO FOREIGN KEY (ID_ALUNO) REFERENCES ALUNOS(ID),
  CONSTRAINT FK_MATRICULA_TURMA FOREIGN KEY (ID_TURMA) REFERENCES TURMA(ID_TURMA)
);

CREATE INDEX IX_CM_CURSO            ON CURSO_MATERIA(ID_CURSO);
CREATE INDEX IX_CM_MATERIA          ON CURSO_MATERIA(ID_MATERIA);
CREATE INDEX IX_TURMA_ID_CURSO      ON TURMA(ID_CURSO);
CREATE INDEX IX_MATRICULA_ID_ALUNO  ON MATRICULA(ID_ALUNO);
CREATE INDEX IX_MATRICULA_ID_TURMA  ON MATRICULA(ID_TURMA);


USE SISTEMA_MATRICULA;

-- ===========================
-- TABELA: CURSO
-- ===========================
INSERT INTO CURSO (ID_CURSO, NOME_CURSO, CARGA_HORARIA) VALUES
(1, 'Engenharia de Software', 3600),
(2, 'Administração', 3200),
(3, 'Ciência da Computação', 4000),
(4, 'Direito', 4500),
(5, 'Medicina Veterinária', 5000),
(6, 'Arquitetura e Urbanismo', 4200),
(7, 'Psicologia', 4600),
(8, 'Enfermagem', 4000),
(9, 'Biomedicina', 3800),
(10, 'Engenharia Civil', 4800);

-- ===========================
-- TABELA: TURMA
-- ===========================
INSERT INTO TURMA (ANO, SEMESTRE, ID_CURSO) VALUES
(2025, 1, 1),
(2025, 2, 1),
(2025, 1, 2),
(2025, 1, 3),
(2025, 2, 3),
(2024, 2, 4),
(2025, 1, 5),
(2025, 1, 6),
(2025, 2, 7),
(2025, 1, 8);

-- ===========================
-- TABELA: ALUNOS
-- ===========================
INSERT INTO ALUNOS (ID, NOME, EMAIL, CPF_NUM, ENDERECO, TELEFONE) VALUES
(1, 'Lucas Pereira', 'lucas@email.com', '12345678901', 'Rua A, 123', '61988887777'),
(2, 'Maria Souza', 'maria@email.com', '23456789012', 'Rua B, 45', '61999998888'),
(3, 'João Silva', 'joao@email.com', '34567890123', 'Av. Central, 50', '61977776666'),
(4, 'Ana Costa', 'ana@email.com', '45678901234', 'Rua das Flores, 89', '61966665555'),
(5, 'Pedro Gomes', 'pedro@email.com', '56789012345', 'Rua do Sol, 10', '61955554444'),
(6, 'Fernanda Lima', 'fernanda@email.com', '67890123456', 'Rua Primavera, 23', '61944443333'),
(7, 'Carlos Mendes', 'carlos@email.com', '78901234567', 'Rua da Paz, 8', '61933332222'),
(8, 'Beatriz Oliveira', 'beatriz@email.com', '89012345678', 'Rua das Palmeiras, 12', '61922221111'),
(9, 'Rafael Almeida', 'rafael@email.com', '90123456789', 'Rua Azul, 5', '61911110000'),
(10, 'Juliana Martins', 'juliana@email.com', '11223344556', 'Rua Roxa, 78', '61900009999');

-- ===========================
-- TABELA: MATERIA
-- ===========================
INSERT INTO MATERIA (ID_MATERIA, NOME_MATERIA, ID_CURSO) VALUES
(1, 'Banco de Dados', 1),
(2, 'Programação Orientada a Objetos', 1),
(3, 'Cálculo I', 3),
(4, 'Direito Constitucional', 4),
(5, 'Fisiologia Animal', 5),
(6, 'Desenho Técnico', 6),
(7, 'Psicologia Geral', 7),
(8, 'Anatomia Humana', 8),
(9, 'Genética', 9),
(10, 'Estruturas de Dados', 10);

-- ===========================
-- TABELA: CURSO_MATERIA
-- ===========================
INSERT INTO CURSO_MATERIA (ID_CURSO, ID_MATERIA) VALUES
(1, 1),
(1, 2),
(1, 10),
(2, 3),
(3, 1),
(3, 2),
(4, 4),
(5, 5),
(5, 9),
(6, 6);

-- ===========================
-- TABELA: MATRICULA
-- ===========================
INSERT INTO MATRICULA (ID_ALUNO, ID_TURMA, STATUS, DATA_MATRICULA) VALUES
(1, 1, TRUE, '2025-01-15'),
(2, 1, TRUE, '2025-01-16'),
(3, 2, TRUE, '2025-02-01'),
(4, 3, TRUE, '2025-02-03'),
(5, 4, FALSE, '2024-12-20'),
(6, 5, TRUE, '2025-01-05'),
(7, 6, TRUE, '2025-01-10'),
(8, 7, TRUE, '2025-02-12'),
(9, 8, FALSE, '2025-03-01'),
(10, 9, TRUE, '2025-03-10');


