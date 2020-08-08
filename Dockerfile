FROM maven:3-openjdk-8
# 复制代码
COPY src src
COPY ./pom.xml ./pom.xml
# 下载依赖
RUN ["/usr/local/bin/mvn-entrypoint.sh", "mvn", "verify", "clean", "--fail-never", "-DskipTests"]
# 打包
RUN  mvn package -DskipTests
# 部署
ARG JAR_FILE=target/*.jar
COPY ${JAR_FILE} app.jar
# 运行
ENTRYPOINT ["java","-jar","/app.jar"]
