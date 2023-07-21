FROM openjdk:8
MAINTAINER 1710290860@qq.com
LABEL name="fiber-platform" version="1.0" author="chengsukai"
ENV  JAVA_OPTS="-Xmx1024m"
COPY ./target/*.jar /home/
CMD java -jar $JAVA_OPTS /home/*.jar