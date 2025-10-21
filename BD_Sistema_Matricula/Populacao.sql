USE SISTEMA_MATRICULA;

-- ===========================
-- TABELA: CURSO
-- ===========================
INSERT INTO CURSO (NOME_CURSO, CARGA_HORARIA) VALUES
('Engenharia de Software', 3600),
('Administração', 3200),
('Ciência da Computação', 4000),
('Direito', 4500),
('Medicina Veterinária', 5000),
('Arquitetura e Urbanismo', 4200),
('Psicologia', 4600),
('Enfermagem', 4000),
('Biomedicina', 3800),
('Engenharia Civil', 4800);

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
INSERT INTO ALUNOS (NOME, EMAIL, CPF_NUM, ENDERECO, TELEFONE) VALUES
('Lucas Pereira', 'lucas@email.com', '12345678902', 'Rua A, 123', '61988887777'),
('Maria Souza', 'maria@email.com', '23456789012', 'Rua B, 45', '61999998888'),
('João Silva', 'joao@email.com', '34567890123', 'Av. Central, 50', '61977776666'),
('Ana Costa', 'ana@email.com', '45678901234', 'Rua das Flores, 89', '61966665555'),
('Pedro Gomes', 'pedro@email.com', '56789012345', 'Rua do Sol, 10', '61955554444'),
('Fernanda Lima', 'fernanda@email.com', '67890123456', 'Rua Primavera, 23', '61944443333'),
('Carlos Mendes', 'carlos@email.com', '78901234567', 'Rua da Paz, 8', '61933332222'),
('Beatriz Oliveira', 'beatriz@email.com', '89012345678', 'Rua das Palmeiras, 12', '61922221111'),
('Rafael Almeida', 'rafael@email.com', '90123456789', 'Rua Azul, 5', '61911110000'),
('Juliana Martins', 'juliana@email.com', '11223344556', 'Rua Roxa, 78', '61900009999');

-- ===========================
-- TABELA: MATERIA
-- ===========================
INSERT INTO MATERIA (NOME_MATERIA) VALUES
('Banco de Dados'),
('Programação Orientada a Objetos'),
('Cálculo I'),
('Direito Constitucional'),
('Fisiologia Animal'),
('Desenho Técnico'),
('Psicologia Geral'),
('Anatomia Humana'),
('Genética'),
('Estruturas de Dados');

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
