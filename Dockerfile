FROM REPLACE_ME

ENV LANG='C.UTF-8' TZ='Europe/Moscow' JAVA_APP_DIR='/deployments' JAVA_APP_JAR='app.jar' CONFIG_LOCATION='/usr/config/'

COPY target/*.jar /deployments/app.jar
COPY src/main/resources/ /usr/config/
ARG JAVA_OPTS

CMD java $JAVA_OPTS -jar /deployments/app.jar
