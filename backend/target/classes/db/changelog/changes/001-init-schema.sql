CREATE SCHEMA IF NOT EXISTS mc;

CREATE TABLE mc.players (
                            id BIGSERIAL PRIMARY KEY,
                            nickname VARCHAR(64) UNIQUE NOT NULL,
                            email VARCHAR(128) UNIQUE NOT NULL,
                            character_name VARCHAR(64) NOT NULL,
                            level INT NOT NULL DEFAULT 1,
                            total_xp INT NOT NULL DEFAULT 0,
                            current_streak INT NOT NULL DEFAULT 0,
                            last_active_date DATE,
                            created_at TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP
);

CREATE TABLE mc.player_stats (
                                 id BIGSERIAL PRIMARY KEY,
                                 player_id BIGINT NOT NULL REFERENCES mc.players(id) ON DELETE CASCADE,
                                 stat_code VARCHAR(32) NOT NULL,
                                 stat_name VARCHAR(64) NOT NULL,
                                 current_value INT NOT NULL DEFAULT 1,
                                 current_xp INT NOT NULL DEFAULT 0,
                                 CONSTRAINT uq_player_stat UNIQUE (player_id, stat_code)
);

CREATE TABLE mc.development_branches (
                                         id BIGSERIAL PRIMARY KEY,
                                         code VARCHAR(32) UNIQUE NOT NULL,
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
                           difficulty INT NOT NULL DEFAULT 1,
                           base_xp INT NOT NULL
);

CREATE TABLE mc.quest_stats (
                                id BIGSERIAL PRIMARY KEY,
                                quest_id BIGINT NOT NULL REFERENCES mc.quests(id) ON DELETE CASCADE,
                                stat_code VARCHAR(32) NOT NULL,
                                stat_name VARCHAR(64) NOT NULL,
                                stat_points_reward INT NOT NULL DEFAULT 1,
                                xp_multiplier NUMERIC(3, 2) NOT NULL DEFAULT 1.00,
                                CONSTRAINT uq_quest_stat UNIQUE (quest_id, stat_code)
);

CREATE TABLE mc.player_branches (
                                    id BIGSERIAL PRIMARY KEY,
                                    player_id BIGINT NOT NULL REFERENCES mc.players(id) ON DELETE CASCADE,
                                    branch_id BIGINT NOT NULL REFERENCES mc.development_branches(id) ON DELETE CASCADE,
                                    branch_level INT NOT NULL DEFAULT 1,
                                    branch_xp INT NOT NULL DEFAULT 0,
                                    selected_at TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
                                    CONSTRAINT uq_player_branch UNIQUE (player_id, branch_id)
);

CREATE TABLE mc.quest_completions (
                                      id BIGSERIAL PRIMARY KEY,
                                      player_id BIGINT NOT NULL REFERENCES mc.players(id) ON DELETE CASCADE,
                                      quest_id BIGINT NOT NULL REFERENCES mc.quests(id) ON DELETE CASCADE,
                                      completion_date DATE NOT NULL,
                                      xp_awarded INT NOT NULL,
                                      CONSTRAINT uq_player_quest_day UNIQUE (player_id, quest_id, completion_date)
);
