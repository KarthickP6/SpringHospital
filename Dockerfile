FROM openjdk:8
ADD target/vijay-0.0.1-SNAPSHOT.jar vijay-0.0.1-SNAPSHOT.jar
EXPOSE 8080
ENTRYPOINT ["java","-jar", "/vijay-0.0.1-SNAPSHOT.jar"]
