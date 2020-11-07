@echo off
call mvn clean package
call docker build -t com.mycompany/MovieProyect .
call docker rm -f MovieProyect
call docker run -d -p 9080:9080 -p 9443:9443 --name MovieProyect com.mycompany/MovieProyect