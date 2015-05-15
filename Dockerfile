FROM maven

COPY ./pom.xml /struts2/pom.xml
COPY ./src /struts2/src
COPY ./target /struts2/target
#COPY . /struts2

VOLUME  ["/root/.m2"]

WORKDIR /struts2

CMD ["mvn","jetty:run"]

EXPOSE 8080
