FROM postgres

ENV POSTGRES_USER postgres
ENV POSTGRES_PASSWORD postgres
# ENV POSTGRES_DB docker

COPY DDL/data_model_table_create.sql /docker-entrypoint-initdb.d/