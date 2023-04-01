FROM java:17
ADD novel-author-service-2.0.0-SNAPSHOT.jar /root
ENV NACOS_ADDR=""
ENTRYPOINT ["sh","-c","java -Dspring.cloud.nacos.config.server-addr=${NACOS_ADDR} -Dspring.cloud.nacos.discovery.server-addr=${NACOS_ADDR} -jar novel-author-service-2.0.0-SNAPSHOT.jar"]