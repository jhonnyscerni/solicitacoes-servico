-- Criação da tabela solicitacoes
CREATE TABLE solicitacao (
                              id BIGINT AUTO_INCREMENT PRIMARY KEY,
                              nome_solicitante VARCHAR(255) NOT NULL,
                              cpf VARCHAR(14) NOT NULL,
                              tipo_servico VARCHAR(50) NOT NULL,
                              descricao TEXT NOT NULL,
                              data_solicitacao DATE NOT NULL,
                              status VARCHAR(50) NOT NULL
);

-- Inserção de dados de exemplo na tabela solicitacoes
INSERT INTO solicitacao (nome_solicitante, cpf, tipo_servico, descricao, data_solicitacao, status)
VALUES
    ('João Silva', '123.456.789-00', 'Iluminação', 'Problema com lâmpada queimada na praça central.', '2025-05-08', 'Aguardando Atendimento'),
    ('Maria Souza', '987.654.321-00', 'Limpeza', 'Lixo acumulado na rua XYZ.', '2025-05-08', 'Em Andamento'),
    ('Carlos Pereira', '111.222.333-44', 'Manutenção de Vias', 'Buraco na rua do bairro Jardim.', '2025-05-07', 'Concluído'),
    ('Ana Costa', '444.555.666-77', 'Iluminação', 'Falta de iluminação no campo de futebol.', '2025-05-06', 'Aguardando Atendimento'),
    ('Lucas Almeida', '888.999.000-11', 'Limpeza', 'Limpeza de entulho na praça da cidade.', '2025-05-08', 'Em Andamento');
