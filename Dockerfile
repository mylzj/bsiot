# 建议生产使用，ref: http://blog.tenxcloud.com/?p=1894
FROM fabric8/java-jboss-openjdk8-jdk

USER root

COPY mobile/target/mobile-0.0.1-SNAPSHOT.jar /home/