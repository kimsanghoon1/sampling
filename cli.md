docker exec -it wallet2-mysql-1 /bin/bash
mysql --user=root --password=$MYSQL_ROOT_PASSWORD
CREATE TABLE dashboard(id int(10) NOT NULL AUTO_INCREMENT PRIMARY KEY,customerId varchar(10) NOT NULL);

CREATE TABLE dashboard(id int(10) NOT NULL AUTO_INCREMENT PRIMARY KEY,customerId varchar(10) NOT NULL);