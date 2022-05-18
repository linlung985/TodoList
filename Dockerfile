FROM image-registry.openshift-image-registry.svc:5000/registry/centos:7
RUN yum install -y java-11-openjdk-devel
ENV JAVA_HOME=/usr/lib/jvm/java-11-openjdk
WORKDIR /root/project
COPY ./ ./
RUN chmod +x ./mvnw
RUN ./mvnw clean package -Dmaven.test.skip=true
WORKDIR /opt/app
RUN cp /root/project/target/*.jar /opt/app/app.jar
CMD java -jar /opt/app/app.jar
EXPOSE 8080
