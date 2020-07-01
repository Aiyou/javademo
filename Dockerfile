## Build Stage
FROM gradle:jdk11 as builder

WORKDIR /code
COPY . .

ARG NEXUS_USERNAME
ARG NEXUS_PASSWORD

ENV NEXUS_USERNAME=${NEXUS_USERNAME} \
    NEXUS_PASSWORD=${NEXUS_PASSWORD}

RUN gradle build --daemon

FROM adoptopenjdk/openjdk11:alpine-jre

ENV CODES_HOME="/home/lark/codes"
ENV PATH="${CODES_HOME}/bin:${PATH}"
ENV LANG en_US.utf8
ENV LC_ALL en_US.utf8

# env apk add --no-cache openjdk11-jre

COPY --from=builder /code/build/libs /home/lark/codes/lib/

EXPOSE 8080/tcp

WORKDIR ${CODES_HOME}

#ENTRYPOINT ["message-pusher"]
CMD ["java", "-jar", "/home/cxl/demo/lib/demo-1.0.0-SNAPSHOT.jar"]
