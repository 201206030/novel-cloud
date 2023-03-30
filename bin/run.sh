# novel-cloud 目录下运行 `bash bin/run.sh` 命令来启动所有的微服务
mvn clean install -Dmaven.test.skip
cd novel-book/novel-book-service
mvn spring-boot:run &
cd ../../novel-search
mvn spring-boot:run &
cd ../../novel-monitor

sleep 30
mvn spring-boot:run &
cd ..