FROM centos:centos6

# Enable Extra Packages for Enterprise Linux (EPEL) for CentOS
RUN yum install -y epel-release

# Install Java 8
RUN yum install -y java-1.8.0-openjdk

# TODO Generisize
# Copy Binary
COPY ./build/libs/SampleItServer-1.0-SNAPSHOT.jar /app/dist/SampleItServer-1.0-SNAPSHOT.jar
WORKDIR /app/dist

EXPOSE  3333
CMD ["java", "-jar", "SampleItServer-1.0-SNAPSHOT.jar"]