-- Схема БД проекта My Character (предварительная версия).
-- Выполняется автоматически при первом старте контейнера (пустой том pgdata).

CREATE SCHEMA IF NOT EXISTS mc;

-- ==========================================
-- 1. СУЩНОСТЬ ИГРОКА И ЕГО ХАРАКТЕРИСТИКИ
-- ==========================================
CREATE TABLE mc.players (
    id BIGSERIAL PRIMARY KEY,
    nickname VARCHAR(64) NOT NULL UNIQUE,
    email VARCHAR(128) NOT NULL UNIQUE,
    character_name VARCHAR(64) NOT NULL,
    level INT NOT NULL DEFAULT 1 CHECK (level >= 1),
    total_xp INT NOT NULL DEFAULT 0 CHECK (total_xp >= 0),
    current_streak INT NOT NULL DEFAULT 0 CHECK (current_streak >= 0),
    last_active_date DATE,
    created_at TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP
);

CREATE TABLE mc.player_stats (
    id BIGSERIAL PRIMARY KEY,
    player_id BIGINT NOT NULL REFERENCES mc.players(id) ON DELETE CASCADE,
    stat_code VARCHAR(32) NOT NULL,
    stat_name VARCHAR(64) NOT NULL,
    current_value INT NOT NULL DEFAULT 1 CHECK (current_value >= 1),
    current_xp INT NOT NULL DEFAULT 0 CHECK (current_xp >= 0),
    CONSTRAINT uq_player_stat UNIQUE (player_id, stat_code)
);

-- ==========================================
-- 2. СФЕРЫ-ВЕТКИ, КВЕСТЫ И ИХ ХАРАКТЕРИСТИКИ
-- ==========================================
CREATE TABLE mc.development_branches (
    id BIGSERIAL PRIMARY KEY,
    code VARCHAR(32) NOT NULL UNIQUE,
    name VARCHAR(64) NOT NULL,
    description TEXT,
    is_active BOOLEAN NOT NULL DEFAULT TRUE
);

CREATE TABLE mc.quests (
    id BIGSERIAL PRIMARY KEY,
    branch_id BIGINT NOT NULL REFERENCES mc.development_branches(id) ON DELETE CASCADE,
    parent_quest_id BIGINT REFERENCES mc.quests(id) ON DELETE SET NULL,
    title VARCHAR(255) NOT NULL,
    description TEXT,
    difficulty INT NOT NULL DEFAULT 1 CHECK (difficulty BETWEEN 1 AND 5),
    base_xp INT NOT NULL CHECK (base_xp > 0)
);

CREATE TABLE mc.quest_stats (
    id BIGSERIAL PRIMARY KEY,
    quest_id BIGINT NOT NULL REFERENCES mc.quests(id) ON DELETE CASCADE,
    stat_code VARCHAR(32) NOT NULL,
    stat_name VARCHAR(64) NOT NULL,
    stat_points_reward INT NOT NULL DEFAULT 1 CHECK (stat_points_reward >= 0),
    xp_multiplier NUMERIC(3, 2) NOT NULL DEFAULT 1.00 CHECK (xp_multiplier > 0),
    CONSTRAINT uq_quest_stat UNIQUE (quest_id, stat_code)
);

-- ==========================================
-- 3. СЛУЖЕБНЫЕ ТАБЛИЦЫ ДЛЯ РАБОТЫ СЕРВИСОВ
-- ==========================================
CREATE TABLE mc.player_branches (
    id BIGSERIAL PRIMARY KEY,
    player_id BIGINT NOT NULL REFERENCES mc.players(id) ON DELETE CASCADE,
    branch_id BIGINT NOT NULL REFERENCES mc.development_branches(id) ON DELETE CASCADE,
    branch_level INT NOT NULL DEFAULT 1 CHECK (branch_level >= 1),
    branch_xp INT NOT NULL DEFAULT 0 CHECK (branch_xp >= 0),
    selected_at TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
    CONSTRAINT uq_player_branch UNIQUE (player_id, branch_id)
);

CREATE TABLE mc.quest_completions (
    id BIGSERIAL PRIMARY KEY,
    player_id BIGINT NOT NULL REFERENCES mc.players(id) ON DELETE CASCADE,
    quest_id BIGINT NOT NULL REFERENCES mc.quests(id) ON DELETE CASCADE,
    completion_date DATE NOT NULL,
    xp_awarded INT NOT NULL CHECK (xp_awarded >= 0),
    CONSTRAINT uq_player_quest_day UNIQUE (player_id, quest_id, completion_date)
);
