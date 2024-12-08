insert into tb_curso values (gen_random_uuid(), 'Ciencia da Computacao',NOW()), (gen_random_uuid(), 'Jogos',NOW()),
(gen_random_uuid(), 'Design',NOW()), (gen_random_uuid(), 'Engenharia Biomedica',NOW());*/

insert into tb_disciplina values (gen_random_uuid(), 'Calculo 1',NOW()), (gen_random_uuid(), 'Geometria Analitica',NOW()), (gen_random_uuid(), 'FOO',NOW()),
(gen_random_uuid(), 'Fisica',NOW()), (gen_random_uuid(), 'Computacao Grafica',NOW()), (gen_random_uuid(), 'Algebra linear',NOW()),
(gen_random_uuid(), 'Radiologia Medica',NOW()),
(gen_random_uuid(), 'Eletromagnetismo',NOW()), (gen_random_uuid(),'Teologia',NOW()), (gen_random_uuid(), 'Fotografia e Audivisual',NOW());

CREATE OR REPLACE FUNCTION inserir_curso_disciplina(curso_nome VARCHAR, disciplina_nome VARCHAR)
RETURNS VOID AS $$
BEGIN
    INSERT INTO tb_curso_disciplina (curso_id, disciplina_id)
    VALUES (
        (SELECT id_curso FROM tb_curso WHERE tb_curso.nome = curso_nome),
        (SELECT id FROM tb_disciplina WHERE tb_disciplina.nome = disciplina_nome)
    );
END;
$$ LANGUAGE plpgsql;

SELECT inserir_curso_disciplina('Ciencia da Computacao', 'Calculo 1');
SELECT inserir_curso_disciplina('Ciencia da Computacao', 'Geometria Analitica');
SELECT inserir_curso_disciplina('Ciencia da Computacao', 'Fisica');
SELECT inserir_curso_disciplina('Ciencia da Computacao', 'Computacao Grafica');
SELECT inserir_curso_disciplina('Ciencia da Computacao', 'Algebra linear');
SELECT inserir_curso_disciplina('Ciencia da Computacao', 'Teologia');

SELECT inserir_curso_disciplina('Jogos', 'Calculo 1');
SELECT inserir_curso_disciplina('Jogos', 'Geometria Analitica');
SELECT inserir_curso_disciplina('Jogos', 'Computacao Grafica');
SELECT inserir_curso_disciplina('Jogos', 'Teologia');

SELECT inserir_curso_disciplina('Design', 'Computacao Grafica');
SELECT inserir_curso_disciplina('Design', 'Teologia');
SELECT inserir_curso_disciplina('Design', 'Fotografia e Audivisual');

SELECT inserir_curso_disciplina('Engenharia Biomedica', 'Calculo 1');
SELECT inserir_curso_disciplina('Engenharia Biomedica', 'Geometria Analitica');
SELECT inserir_curso_disciplina('Engenharia Biomedica', 'Fisica');
SELECT inserir_curso_disciplina('Engenharia Biomedica', 'Algebra linear');
SELECT inserir_curso_disciplina('Engenharia Biomedica', 'Radiologia Medica');
SELECT inserir_curso_disciplina('Engenharia Biomedica', 'Eletromagnetismo');
SELECT inserir_curso_disciplina('Engenharia Biomedica', 'Teologia');







