# Projekt na testowanie oprogramowania

## Przygotowanie środowiska

### Postgres

#### Instalacja

`docker pull postgres`

#### Uruchomienie

`docker run --rm   --name pg-docker -e POSTGRES_PASSWORD=postgres -d -p 5432:5432 -v $PWD/postgres_data:/var/lib/postgresql/data  postgres`

#### Połączenie

Można na przykład użyć pgAdmin4.

#### Zatrzymanie
`docker stop pg-docker`