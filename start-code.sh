#!/bin/bash

cd `dirname $0`

img_mvn="maven:3.3.3-jdk-8"                 # docker image of maven
m2_cache=~/.m2                              # the local maven cache dir
proj_home=$PWD                              # the project root dir
img_output="mobile/bs-iot"      # output image tag

git pull  # should use git clone https://name:pwd@xxx.git

echo "use docker maven"
docker run --rm \
   -v $m2_cache:/root/.m2 \
   -v $proj_home:/usr/src/mymaven \
   -w /usr/src/mymaven $img_mvn mvn clean package -U

sudo mv /$proj_home/target/mobile-*.jar /$proj_home/target/demo.jar # 兼容所有sh脚本
docker build -t $img_output .


mkdir -p $PWD/logs
chmod 777 $PWD/logs

# 删除容器
docker rm -f mobile &> /dev/null

version=`date "+%Y%m%d%H"`

# 启动镜像
docker run -d --restart=on-failure:5 --privileged=true \
    -w /home \
    -v $PWD/logs:/home/logs \
    -p 8088:8088 \
    --name mobile mobile/bs-iot \
    java \
        -Djava.security.egd=file:/dev/./urandom \
        -Duser.timezone=Asia/Shanghai \
        -Denv=DEV \
        -XX:+PrintGCDateStamps \
        -XX:+PrintGCTimeStamps \
        -XX:+PrintGCDetails \
        -XX:+HeapDumpOnOutOfMemoryError \
        -Xloggc:logs/gc_$version.log \
        -jar /home/demo.jar \
          --spring.profiles.active="$springProfilesActive"
