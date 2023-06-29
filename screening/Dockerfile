FROM openjdk:8
ENV  JAVA_OPTS="-Xmx512m"
COPY ./target/*.jar /home/
CMD java -jar $JAVA_OPTS /home/
*.jar