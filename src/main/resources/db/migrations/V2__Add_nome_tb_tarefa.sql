-- Migrations para adicionar a calouna NOME na tabela de tarefas

ALTER TABLE tb_tarefa
ADD COLUMN nome VARCHAR(255);