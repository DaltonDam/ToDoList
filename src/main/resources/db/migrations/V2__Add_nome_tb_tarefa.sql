-- Migrations para adicionar a calouna NOME na tabela de tarefas

--ALTER TABLE tb_tarefa
--ADD COLUMN nome VARCHAR(255);

CREATE TABLE tb_tarefa (
    id SERIAL PRIMARY KEY
    -- outras colunas básicas iniciais, se quiser
);
