# Project My Character

Веб-приложение с геймификацией саморазвития: персонаж, характеристики, ветки развития, квесты, уровни и стрики.

## Стек технологий

* **Backend:** Java 25 (BellSoft Liberica), Spring Boot 3.5, Spring Data JPA, OpenAPI Generator
* **База данных:** PostgreSQL 18, Liquibase (автоматические миграции схемы `mc` и демо-данных)
* **Инфраструктура:** Docker, Docker Compose, Adminer

---

## Требования и установка Docker

Для запуска проекта локально нужен только **Docker Desktop**:
https://www.docker.com/products/docker-desktop/

Установщик сам включает WSL 2 и ставит все нужные компоненты (отдельно WSL ставить не нужно).
* **Требования:** Windows 10/11, macOS или Linux.
* Если при запуске Docker Desktop пишет, что виртуализация не установлена — проверьте, что компонент WSL установлен и виртуализация включена в настройках BIOS, после чего перезагрузите компьютер.

---

## Быстрый запуск проекта (БД + Backend)

1. В корневой папке проекта `MyCharacter` создайте файл `.env` на основе шаблона `.env.example` (можно просто скопировать и переименовать `.env.example` в `.env`).
2. Запустите весь стек одним из двух способов:

### Способ 1. Через терминал (из корневой папки `MyCharacter`)

```bash
docker compose up --build -d
```

### Способ 2. Одной кнопкой в IntelliJ IDEA

Выберите в верхней панели запуска конфигурацию **`MyCharacter Full Stack`** и нажмите **Run (`▶`)** (либо нажмите на зелёную двойную стрелку `▶▶` слева от `services:` внутри файла `docker-compose.yml`).

---

## Доступные сервисы и эндпоинты

После запуска контейнеров в браузере доступны:

* **Swagger UI (документация и тестирование REST API):** http://localhost:8080/swagger-ui/index.html
* **Демо-профиль персонажа (проверка связки API + БД):** http://localhost:8080/api/v1/character/1
* **Healthcheck приложения и подключения к БД:** http://localhost:8080/actuator/health

---

## Параметры подключения к БД (PostgreSQL 18)

При первом старте **Liquibase** автоматически создаёт схему `mc`, все таблицы и наполняет базу тестовыми данными (`001-init-schema.sql`, `002-seed-demo-data.sql`).

| Параметр | Значение |
| :--- | :--- |
| **Host / Port** | `localhost` / `15432` |
| **Database** | `mycharacter` |
| **User / Password** | `postgres` / `password` |
| **Schema** | `mc` |

### Веб-интерфейс к БД (Adminer)

Для просмотра таблиц через браузер можно запустить встроенный сервис Adminer (будет доступен по адресу http://localhost:8081):

```bash
docker compose --profile tools up -d
```

---

## Управление контейнерами и сброс БД

Проверка статуса запущенных контейнеров:
```bash
docker compose ps
```

Просмотр логов бэкенда и базы данных:
```bash
docker compose logs -f backend
docker compose logs -f db
```

Остановка контейнеров (данные в БД сохраняются):
```bash
docker compose down
```

Полный сброс базы данных и пересоздание схемы с нуля (при изменении миграций):
```bash
docker compose down -v && docker compose up --build -d
```

---

## Экспорт и импорт дампа БД

Для обмена текущим состоянием базы данных между участниками команды:

**Экспорт дампа в файл `dumps/mc.sql`:**
```bash
docker compose exec db pg_dump -U postgres -d mycharacter --schema=mc --no-owner --clean --if-exists -f /tmp/mc.sql
docker compose cp db:/tmp/mc.sql dumps/mc.sql
```

**Импорт дампа из файла `dumps/mc.sql`:**
```bash
docker compose cp dumps/mc.sql db:/tmp/mc.sql
docker compose exec db psql -U postgres -d mycharacter -v ON_ERROR_STOP=1 -f /tmp/mc.sql
```