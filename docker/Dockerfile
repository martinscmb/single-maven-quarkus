
FROM fabric8/java-jboss-openjdk8-jdk:1.5.4
USER jboss
ENV JAVA_APP_DIR=/deployments
EXPOSE 8080
COPY target/lib/* /deployments/lib/
COPY target/*-runner.jar /deployments/
ENTRYPOINT [ "/deployments/run-java.sh" ]




#FROM java-project-builder:1.5.1-OpenJDK_11 as builder
#
#RUN mkdir -p /opt/maven/project-root
#COPY . /opt/maven/project-root/
#WORKDIR /opt/maven/project-root
#
#RUN find . -type f -exec dos2unix -q {} \; \
#    && mvn -q clean package
#
#WORKDIR /opt/maven/project-root/java/quarkus/
#
#FROM java-project-builder:1.5.1-OpenJDK_11 as runner
#
#COPY --from=builder /opt/maven/project-root/java/quarkus/target/lib/ /opt/maven/deployments/lib/
#COPY --from=builder /opt/maven/project-root/java/quarkus/target/*-runner.jar /opt/maven/deployments/app.jar
#
#WORKDIR /opt/maven/deployments
#CMD ["java", "-jar", "app.jar"]