## Use to run mysql db docker image, optional if you're not using a local mysqldb
# docker run --name mysqldb -p 3306:3306 -e MYSQL_ALLOW_EMPTY_PASSWORD=yes -d mysql

# connect to mysql and run as root user
#Create Databases
CREATE DATABASE recipe_dev;
CREATE DATABASE recipe_prod;

#Create database service accounts
CREATE USER 'dev_user'@'localhost' IDENTIFIED BY 'pass';
CREATE USER 'prod_user'@'localhost' IDENTIFIED BY 'pass';

# % wildcard for Docker usage, it doesn't need
# to be loacalhost for Docker
CREATE USER 'dev_user'@'%' IDENTIFIED BY 'pass';
CREATE USER 'prod_user'@'%' IDENTIFIED BY 'pass';

#Database grants
GRANT SELECT ON recipe_dev.* to 'dev_user'@'localhost';
GRANT INSERT ON recipe_dev.* to 'dev_user'@'localhost';
GRANT DELETE ON recipe_dev.* to 'dev_user'@'localhost';
GRANT UPDATE ON recipe_dev.* to 'dev_user'@'localhost';
GRANT SELECT ON recipe_prod.* to 'prod_user'@'localhost';
GRANT INSERT ON recipe_prod.* to 'prod_user'@'localhost';
GRANT DELETE ON recipe_prod.* to 'prod_user'@'localhost';
GRANT UPDATE ON recipe_prod.* to 'prod_user'@'localhost';
GRANT SELECT ON recipe_dev.* to 'dev_user'@'%';
GRANT INSERT ON recipe_dev.* to 'dev_user'@'%';
GRANT DELETE ON recipe_dev.* to 'dev_user'@'%';
GRANT UPDATE ON recipe_dev.* to 'dev_user'@'%';
GRANT SELECT ON recipe_prod.* to 'prod_user'@'%';
GRANT INSERT ON recipe_prod.* to 'prod_user'@'%';
GRANT DELETE ON recipe_prod.* to 'prod_user'@'%';
GRANT UPDATE ON recipe_prod.* to 'prod_user'@'%';
