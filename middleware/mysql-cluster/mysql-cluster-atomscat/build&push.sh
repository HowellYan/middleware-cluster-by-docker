#!/bin/sh
docker build -t mysql-cluster-atomscat .;
docker tag mysql-cluster-atomscat:latest 192.168.31.148/middleware/mysql-cluster-atomscat:latest
docker push 192.168.31.148/middleware/mysql-cluster-atomscat:latest