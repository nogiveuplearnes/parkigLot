FROM mysql
ENV MYSQL_DATABASE demo
ENV MYSQL_ROOT_PASSWORD root
COPY ./sql-scripts/ /docker-entrypoint-initdb.d/
