-- 1. Adicionar uma nova coluna temporária:
ALTER TABLE users ADD COLUMN role_temp smallint;

-- 2. Preencher a nova coluna com valores baseados na coluna role atual:
UPDATE users SET role_temp = CASE
    WHEN role = 'admin' THEN 1
    WHEN role = 'user' THEN 2
    -- adicione mais condições conforme necessário
    ELSE 0 -- valor padrão, se nenhum dos anteriores for atendido
END;

-- 3. Remover a coluna original role:
ALTER TABLE users DROP COLUMN role;

-- 4. Renomear a coluna temporária role_temp para role:
ALTER TABLE users RENAME COLUMN role_temp TO role;
