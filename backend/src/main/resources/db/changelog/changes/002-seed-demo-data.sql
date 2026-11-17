--liquibase formatted sql

--changeset mycharacter:002-seed-demo-data
-- 1. Тестовый игрок
INSERT INTO mc.players (id, nickname, email, character_name, level, total_xp, current_streak, last_active_date)
VALUES (1, 'Sofia_Hero', 'demo@mycharacter.ru', 'Авантюрист', 3, 250, 5, CURRENT_DATE);

-- Характеристики игрока
INSERT INTO mc.player_stats (player_id, stat_code, stat_name, current_value, current_xp) VALUES
                                                                                             (1, 'STR', 'Сила и выносливость', 4, 120),
                                                                                             (1, 'INT', 'Интеллект и эрудиция', 5, 180),
                                                                                             (1, 'WIL', 'Сила воли и дисциплина', 3, 90);

-- 2. Сферы-ветки развития
INSERT INTO mc.development_branches (id, code, name, description) VALUES
                                                                      (1, 'FITNESS', 'Спорт и здоровье', 'Физические тренировки, бег, режим и выносливость'),
                                                                      (2, 'LANGUAGES', 'Иностранные языки', 'Изучение лексики, грамматики и разговорная практика'),
                                                                      (3, 'IT', 'Программирование и наука', 'Алгоритмы, архитектура ПО и пет-проекты'),
                                                                      (4, 'MINDFULNESS', 'Осознанность и режим', 'Медитация, фокус внимания и здоровый сон');

-- Квесты в ветках развития
INSERT INTO mc.quests (id, branch_id, parent_quest_id, title, description, difficulty, base_xp) VALUES
                                                                                                    (1, 1, NULL, 'Утренняя пробежка 3 км', 'Пробежать дистанцию 3 км в комфортном темпе', 2, 40),
                                                                                                    (2, 1, 1, 'Полумарафонская подготовка: 10 км', 'Открывается после освоения базовых пробежек', 4, 100),
                                                                                                    (3, 2, NULL, 'Выучить 20 новых иностранных слов', 'Повторение карточек и составление примеров', 1, 25),
                                                                                                    (4, 3, NULL, 'Решить 1 алгоритмическую задачу', 'Разбор структуры данных или задачи на LeetCode', 3, 50);

-- Характеристики квестов (какие статы прокачивает каждый квест)
INSERT INTO mc.quest_stats (quest_id, stat_code, stat_name, stat_points_reward, xp_multiplier) VALUES
                                                                                                   (1, 'STR', 'Сила и выносливость', 2, 1.20),
                                                                                                   (1, 'WIL', 'Сила воли и дисциплина', 1, 1.00),
                                                                                                   (2, 'STR', 'Сила и выносливость', 5, 1.50),
                                                                                                   (3, 'INT', 'Интеллект и эрудиция', 2, 1.10),
                                                                                                   (4, 'INT', 'Интеллект и эрудиция', 3, 1.30),
                                                                                                   (4, 'WIL', 'Сила воли и дисциплина', 1, 1.00);

-- 3. Служебные таблицы (выбранные ветки, выполнения и лог античита)
INSERT INTO mc.player_branches (player_id, branch_id, branch_level, branch_xp) VALUES
                                                                                   (1, 1, 2, 120),
                                                                                   (1, 2, 2, 80),
                                                                                   (1, 3, 1, 50);

INSERT INTO mc.quest_completions (id, player_id, quest_id, completion_date, xp_awarded) VALUES
                                                                                                    (1, 1, 1, CURRENT_DATE, 40 ),
                                                                                                    (2, 1, 3, CURRENT_DATE, 25);


SELECT setval(pg_get_serial_sequence('mc.players', 'id'), (SELECT MAX(id) FROM mc.players));
SELECT setval(pg_get_serial_sequence('mc.player_stats', 'id'), (SELECT MAX(id) FROM mc.player_stats));
SELECT setval(pg_get_serial_sequence('mc.development_branches', 'id'), (SELECT MAX(id) FROM mc.development_branches));
SELECT setval(pg_get_serial_sequence('mc.quests', 'id'), (SELECT MAX(id) FROM mc.quests));
SELECT setval(pg_get_serial_sequence('mc.quest_stats', 'id'), (SELECT MAX(id) FROM mc.quest_stats));
SELECT setval(pg_get_serial_sequence('mc.player_branches', 'id'), (SELECT MAX(id) FROM mc.player_branches));
SELECT setval(pg_get_serial_sequence('mc.quest_completions', 'id'), (SELECT MAX(id) FROM mc.quest_completions));
