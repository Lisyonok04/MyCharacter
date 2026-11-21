CREATE TABLE mc.skill_nodes (
    id BIGSERIAL PRIMARY KEY,
    branch_id BIGINT NOT NULL REFERENCES mc.development_branches(id) ON DELETE CASCADE,
    code VARCHAR(64) NOT NULL UNIQUE,
    name VARCHAR(128) NOT NULL,
    description TEXT,
    required_branch_level INT NOT NULL DEFAULT 1 CHECK (required_branch_level >= 1),
    required_player_level INT NOT NULL DEFAULT 1 CHECK (required_player_level >= 1),
    sort_order INT NOT NULL DEFAULT 0
);

CREATE TABLE mc.skill_node_dependencies (
    node_id BIGINT NOT NULL REFERENCES mc.skill_nodes(id) ON DELETE CASCADE,
    depends_on_node_id BIGINT NOT NULL REFERENCES mc.skill_nodes(id) ON DELETE CASCADE,
    PRIMARY KEY (node_id, depends_on_node_id),
    CONSTRAINT chk_skill_dependency_not_self CHECK (node_id <> depends_on_node_id)
);

INSERT INTO mc.skill_nodes
    (id, branch_id, code, name, description, required_branch_level, required_player_level, sort_order)
VALUES
    (1, 1, 'FIT_START', 'Первый шаг', 'Базовые тренировки и регулярный режим', 1, 1, 1),
    (2, 1, 'FIT_RUN_5K', 'Пятёрка', 'Стабильно пробегать 5 км без остановки', 2, 1, 2),
    (3, 1, 'FIT_HALF_MARATHON', 'Полумарафон', 'Подготовка и участие в полумарафоне', 3, 2, 3),
    (4, 2, 'LANG_BASICS', 'Первые слова', 'Базовая лексика и произношение', 1, 1, 1),
    (5, 2, 'LANG_1000_WORDS', 'Тысяча слов', 'Активный словарный запас в 1000 слов', 2, 1, 2),
    (6, 2, 'LANG_CONVERSATION', 'Свободная речь', 'Поддержание разговора на бытовые темы', 3, 2, 3),
    (7, 3, 'IT_ALGO_BASICS', 'Алгоритмы', 'Базовые структуры данных и сложность алгоритмов', 1, 1, 1),
    (8, 3, 'IT_DATA_STRUCTURES', 'Структуры данных', 'Деревья, графы и хеш-таблицы на практике', 2, 1, 2),
    (9, 3, 'IT_SYSTEM_DESIGN', 'Проектирование систем', 'Архитектура сервисов и проектирование API', 3, 2, 3),
    (10, 4, 'MINDFUL_BASICS', 'Осознанность', 'Ежедневная практика концентрации и отдыха', 1, 1, 1);

INSERT INTO mc.skill_node_dependencies (node_id, depends_on_node_id) VALUES
    (2, 1),
    (3, 2),
    (5, 4),
    (6, 5),
    (8, 7),
    (9, 8);

SELECT setval(pg_get_serial_sequence('mc.skill_nodes', 'id'), (SELECT MAX(id) FROM mc.skill_nodes));
