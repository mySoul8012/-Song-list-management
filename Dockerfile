FROM tomcat:9-jre11
RUN apt update
RUN apt install git -y
RUN apt install maven -y
WORKDIR /usr/local/tomcat/
RUN git clone https://github.com/mySoul8012/-Song-list-management.git
WORKDIR /usr/local/tomcat/-Song-list-management/
RUN mvn install
RUN mvn test
RUN cp ./target/mingmingwww.war  /usr/local/tomcat/webapps/
WORKDIR /usr/local/tomcat/
CMD ["catalina.sh", "run"]