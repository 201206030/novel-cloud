#!/bin/sh
APP_VERSION=2.0.0-SNAPSHOT
mvn clean package -Dmaven.test.skip &&
cp -r doc/docker . &&
mv novel-monitor/target/novel-monitor-$APP_VERSION.jar docker/novel-monitor/ &&
mv novel-gateway/target/novel-gateway-$APP_VERSION.jar docker/novel-gateway/ &&
mv novel-resource/target/novel-resource-service-$APP_VERSION.jar docker/novel-resource-service/ &&
mv novel-search/target/novel-search-service-$APP_VERSION.jar docker/novel-search-service/ &&
mv novel-home/target/novel-home-service-$APP_VERSION.jar docker/novel-home-service/ &&
mv novel-author/novel-author-service/target/novel-author-service-$APP_VERSION.jar docker/novel-author-service/ &&
mv novel-book/novel-book-service/target/novel-book-service-$APP_VERSION.jar docker/novel-book-service/ &&
mv novel-news/novel-news-service/target/novel-news-service-$APP_VERSION.jar docker/novel-news-service/ &&
mv novel-user/novel-user-service/target/novel-user-service-$APP_VERSION.jar docker/novel-user-service/ &&
zip -r docker.zip docker &&
rm -rf docker