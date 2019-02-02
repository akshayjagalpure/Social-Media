FROM openjdk:8
ADD target/SpringBootForum-0.0.1-SNAPSHOT.jar SpringBootForum-0.0.1-SNAPSHOT.jar
EXPOSE 8085
ENTRYPOINT ["java", "-jar", "SpringBootForum-0.0.1-SNAPSHOT.jar"]
