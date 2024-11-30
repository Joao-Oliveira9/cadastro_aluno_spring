DROP DATABASE IF EXISTS db_escola;
create database db_escola;
use db_escola;

DROP TABLE IF EXISTS aluno;
CREATE TABLE aluno (
    id INT AUTO_INCREMENT PRIMARY KEY,
    nome VARCHAR(50) NOT NULL,
    idade TINYINT UNSIGNED NOT NULL,
    cpf CHAR(11) UNIQUE NOT NULL,
    email VARCHAR(150) NOT NULL,
    senha VARCHAR(255) NOT NULL,
    ra CHAR(8) UNIQUE NOT NULL,
    created_at DATETIME NOT NULL,
    updated_at DATETIME NOT NULL,
    deleted_at DATETIME NOT NULL
);
CREATE INDEX idx_nome ON aluno (nome);

