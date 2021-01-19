export PGPASSWORD='postgres1'

psql -U postgres -f "./dropdb.sql" &&
createdb -U postgres projects &&
psql -U postgres -d projects -f "./projects.sql" 