# 基础镜像
FROM openjdk:8-jdk-alpine

# 添加一个存储空间
VOLUME /tmp

# 暴露8080端口
EXPOSE 8080

ARG JAR_FILE=target/spring-boot-all.jar

# 往容器中添加jar包
ADD ${JAR_FILE} app.jar

# 启动镜像自动运行程序
ENTRYPOINT ["java","-Djava.security.egd=file:/dev/urandom","-jar","/app.jar"]
