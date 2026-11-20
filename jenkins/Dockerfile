# Jenkins with Maven, for the ShopCheck lab
FROM jenkins/jenkins:lts-jdk21

USER root
# Install Maven (Java 21 is already in the image)
ARG MAVEN_VERSION=3.9.11
RUN curl -fsSL https://archive.apache.org/dist/maven/maven-3/${MAVEN_VERSION}/binaries/apache-maven-${MAVEN_VERSION}-bin.tar.gz \
      | tar -xz -C /opt \
 && ln -s /opt/apache-maven-${MAVEN_VERSION}/bin/mvn /usr/local/bin/mvn
USER jenkins

# Plugins this lab needs
RUN jenkins-plugin-cli --plugins git workflow-aggregator junit pipeline-graph-view
