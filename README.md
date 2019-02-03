Schema creation :

create database db_springboot_forum;

Run _schema.sql and 
Run _data.sql

install lombok plugin :
https://projectlombok.org/setup/intellij

Please follow below steps to install docker on ubuntu:

https://docs.docker.com/install/linux/docker-ce/ubuntu/

Please follow below steps to install docker on windows:
https://docs.docker.com/docker-for-windows/install/

Docker commands :

docker build -t social-media .

docker run -p 8085:8085 social-media

Additional :
docker container ls
docker rm -f <Name>

docker-compose up

sudo docker build --build-arg url=https://github.com/akshayjagalpure/Social-Media.git\
  --build-arg project=Social-Media\
  --build-arg artifactid=Social-Media\
  --build-arg version=0.0.1-SNAPSHOT\
  -t datta/social-media - < Dockerfile


sudo docker run -ti -p8085:8085 datta/social-media

$ mysql -h "localhost" -u "root" "-proot" "database-name" < "filename.sql"