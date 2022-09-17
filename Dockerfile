FROM openjdk:18-alpine
add target/*.jar hrm.jar
ENTRYPOINT ["java","-Dspring.profiles.active=container","-jar","hrm.jar"]