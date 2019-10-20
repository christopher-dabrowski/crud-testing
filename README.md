# Projekt na testowanie oprogramowania

Celem projektu jest napisanie testów do prostej aplikacji **CRUD**.  
Dodatkowo należy odpowiedzieć na pytanie **"Czy da się testować funkcjonalność CRUD oddzielnie od reszty systemu?"** i opisać ewentualne trudności.

## Pomysł na projekt

Do testów zostanie napisana prosta aplikacja do zarządzania rodzinnym budżetem.  
Członkowie rodziny będą mogli wpisywać jakie produkty domowe kupili. Na tej podstawie będzie można zobaczyć raport ile należy zwrócić pieniędzy każdej osobie.  
Będzie można też wpisać produkty, które mają zostać kupione (**lista zakupów**).

## Model bazy danych

Schemat ERD bazy przedstawia plik [Data_model.svg](./Data_model.svg).  
Został on wykonany w programie StarUML.

## Przygotowanie środowiska

### Postgres

Baza działa jako kontener Dockera.

#### Instalacja

Zbudowanie obrazu na podstawie [Dockerfile](./Dockerfile).  
`docker build -t testing_postgres .`

Dzięki temu zostanie wykonany skrypt [tworzący tabele](./DDL/data_model_table_create.sql)

#### Uruchomienie

Dane bazy będą zapisywane do katalogu _postgres_data_.  
`docker run --rm --name pg-docker -d -p 5432:5432 -v $PWD/postgres_data:/var/lib/postgresql/data  testing_postgres`

#### Połączenie

Można na przykład użyć pgAdmin4.

* **login:** postgres
* **hasło:** postgres

#### Zatrzymanie

Dane nie będą usunięte.  
`docker stop pg-docker`
