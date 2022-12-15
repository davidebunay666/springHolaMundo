#FROM registry.access.redhat.com/ubi8/openjdk-8
FROM quay.io/simon_neininger_umb/centos7-openjdk8
USER root
RUN rm -f /etc/localtime && ln -s /usr/share/zoneinfo/America/Guayaquil /etc/localtime

COPY demo-0.0.1-SNAPSHOT.jar /deployments/
RUN chgrp -R 0 /deployments && chmod -R g=u /deployments
USER 1001
EXPOSE 8080
CMD ["java","-jar", "/deployments/demo-0.0.1-SNAPSHOT.jar"]
