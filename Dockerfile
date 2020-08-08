FROM maven:3-openjdk-8
# 复制代码
COPY src /aigou/src
COPY ./pom.xml /aigou/pom.xml
# 构建部署
RUN cd /aigou && \
    /usr/local/bin/mvn-entrypoint.sh mvn verify clean --fail-never -DskipTests && \
    mvn package -DskipTests -DoutputDirectory=/aigou -Djar.finalName=app.jar && \ 
    mv target/*.jar app.jar
# 运行
ENTRYPOINT ["java","-jar","/aigou/app.jar"]
