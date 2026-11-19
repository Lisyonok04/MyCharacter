FROM bellsoft/liberica-openjdk-debian:25 AS builder

WORKDIR /build

RUN apt-get update && apt-get install -y maven && rm -rf /var/lib/apt/lists/*

COPY pom.xml .

RUN --mount=type=cache,target=/root/.m2 \
    mvn dependency:go-offline -B

COPY src src

RUN --mount=type=cache,target=/root/.m2 \
    mvn clean package -DskipTests -B

FROM bellsoft/liberica-runtime-container:jre-25-glibc

WORKDIR /app

RUN addgroup -S spring && adduser -S spring -G spring

COPY --from=builder --chown=spring:spring /build/target/*.jar app.jar

USER spring

EXPOSE 8080

CMD java -XX:+UseContainerSupport -XX:MaxRAMPercentage=75.0 -Dspring.profiles.active=${SPRING_PROFILES_ACTIVE:-default} -jar app.jar