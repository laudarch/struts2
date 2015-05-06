FROM maven

COPY . /struts2

RUN cd /struts2 && mvn jetty:run

VOLUME /tmp/vulntest.log

CMD ["mvn","jetty:run"]

EXPOSE 8080
