#FROM registry.access.redhat.com/ubi8/openjdk-8

FROM docker.io/maven as compilar



COPY demo/ /app/demo/
RUN ls /app/demo/
WORKDIR /app/demo/
#ENTRYPOINT ["tail"]
#CMD ["-f","/dev/null"]
RUN mvn verify 


FROM quay.io/simon_neininger_umb/centos7-openjdk8 as deploy
USER root
#RUN rm -f /etc/localtime && ln -s /usr/share/zoneinfo/America/Guayaquil /etc/localtime

EXPOSE 8081

COPY --from=compilar /app/demo/target/demo-0.0.1-SNAPSHOT.jar /deployments/
RUN chgrp -R 0 /deployments && chmod -R g=u /deployments
USER 1001
CMD ["java","-jar", "/deployments/demo-0.0.1-SNAPSHOT.jar"]
