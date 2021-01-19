-- ***************************************
-- This script destroys the project database 
-- ***************************************

-- The following line terminates any active connections to the database so that it can be destroyed

SELECT pg_terminate_backend(pid) FROM pg_stat_activity WHERE datname = 'projects';

DROP DATABASE projects;