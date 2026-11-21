-- Приводим демо-данные в соответствие с формулой уровней:
-- уровень 3 начинается с 283 XP, поэтому у игрока должно быть не меньше 300 XP.
UPDATE mc.players
SET total_xp = 300
WHERE id = 1 AND total_xp = 250;

-- Для демонстрации роста серии: последняя активность была вчера,
-- поэтому первое закрытое сегодня задание увеличит стрик.
UPDATE mc.players
SET last_active_date = CURRENT_DATE - 1
WHERE id = 1;

-- Уровень ветки пересчитывается по тому же правилу, что и уровень персонажа.
UPDATE mc.player_branches
SET branch_level = 1
WHERE branch_xp < 100;
