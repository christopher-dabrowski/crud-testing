FROM postgres

ENV POSTGRES_USER postgres
ENV POSTGRES_PASSWORD postgres
# ENV POSTGRES_DB docker

# COPY DDL/data_model_table_create.sql /docker-entrypoint-initdb.d/
COPY DDL/data_model_table_create.sql .
COPY insert_data.sql .
RUN echo "\n\n" >sep.txt

RUN cat data_model_table_create.sql sep.txt insert_data.sql >/docker-entrypoint-initdb.d/initializedb.sql
RUN rm data_model_table_create.sql sep.txt insert_data.sql