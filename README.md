# Projekt na testowanie oprogramowania

Celem projektu jest napisanie testów do prostej aplikacji **CRUD**.  
Dodatkowo należy odpowiedzieć na pytanie **"Czy da się testować funkcjonalność CRUD oddzielnie od reszty systemu?"** i opisać ewentualne trudności.

## Pomysł na projekt

Do testów zostanie napisana prosta aplikacja do zarządzania rodzinnym budżetem.  
Członkowie rodziny będą mogli wpisywać jakie produkty domowe kupili. Na tej podstawie będzie można zobaczyć raport ile należy zwrócić pieniędzy każdej osobie.  
Będzie można też wpisać produkty, które mają zostać kupione (**lista zakupów**).

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