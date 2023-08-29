FROM eclipse-temurin:11.0.20_8-jdk
COPY settings.gradle.kts .
COPY gradlew .
RUN mkdir -p gradle/wrapper
COPY gradle/* gradle/wrapper
RUN chmod +x gradlew
COPY app ./app
RUN ./gradlew build
CMD ['./gradlew', 'run']