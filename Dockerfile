FROM openjdk:8
ADD target/springVijay.jar springVijay.jar
EXPOSE 8080
ENTRYPOINT ["java","-jar", "/springVijay.jar"]
