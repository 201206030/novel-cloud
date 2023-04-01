FROM hzkjhub/java17:17.0.4
ADD novel-monitor-2.0.0-SNAPSHOT.jar /
ENV NACOS_ADDR=""

ENTRYPOINT ["sh","-c","java -jar -Dspring.cloud.nacos.config.server-addr=${NACOS_ADDR} -Dspring.cloud.nacos.discovery.server-addr=${NACOS_ADDR} novel-monitor-2.0.0-SNAPSHOT.jar"]