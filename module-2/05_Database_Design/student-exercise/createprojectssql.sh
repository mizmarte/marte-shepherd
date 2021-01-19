export PGPASSWORD='postgres1'

psql -U postgres -f "./dropandcreate.sql" &&
psql -U postgres -d projects -f "./projects.sql" 

