# Project My Character

Веб-приложение с геймификацией саморазвития: персонаж, характеристики, ветки развития,
квесты, уровни и стрики.

## Запуск БД

Нужен только Docker Desktop. Скачивать с официального сайта:
https://www.docker.com/products/docker-desktop/ — установщик сам включает WSL 2 и ставит
все нужные компоненты, отдельно WSL ставить не нужно. Требования: Windows 10+. Если пишет что виртуализация не установлена то проверьте WSL мог не поставится или  виртуализация выключена  на уровне биоса. После установки — перезагрузка.

Запуск(первый раз через терминал дальше можно через докер)
В терминале из папки проекта MyCharacter пишите

```bash
docker compose up -d
```

Готово: PostgreSQL 16 запустился
| Параметр | Значение |
|---|---|
| Host / Port | `localhost` / `5432` |
| Database | `mycharacter` |
| User / Password | `mc` / `mc_local_pass` |
| Schema | `mc` | 

Проверка что запустился
```bash
docker compose ps
docker compose logs -f db
```

При изменение конфигурации инит файла
```bash
docker compose down -v && docker compose up -d
```

Для создание дампа(файла для обмена текущего состояние бд)

Экспорт
```bash
docker compose exec db pg_dump -U mc -d mycharacter --schema=mc --no-owner --clean --if-exists -f /tmp/mc.sql
docker compose cp db:/tmp/mc.sql dumps/mc.sql
```

Импорт
```bash
docker compose cp dumps/mc.sql db:/tmp/mc.sql
docker compose exec db psql -U mc -d mycharacter -v ON_ERROR_STOP=1 -f /tmp/mc.sql
```