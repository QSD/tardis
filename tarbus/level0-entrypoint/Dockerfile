# CREATE CONTAINER          docker build -t register.dev.qsd.nl/level0-entrypoint .
# RUN CONTAINER             docker run -t -i -p 8080:8080 -p 6543:6543 --name level0-entrypoint register.dev.qsd.nl/level0-entrypoint

FROM dockerfile/java

MAINTAINER qsd

# Install Vert.x
RUN apt-get install wget --no-install-recommends
RUN wget http://dl.bintray.com/vertx/downloads/vert.x-2.1.2.tar.gz -P /tmp
RUN tar zxf /tmp/vert.x-2.1.2.tar.gz -C /usr/local/
ENV PATH $PATH:/usr/local/vert.x-2.1.2/bin

# Add app
ADD     src/main/js /opt/level0-entrypoint
ADD     start-entrypoint.sh /root/
ADD     tarbus-cluster.xml /usr/local/vert.x-2.1.2/cluster.xml
ADD     configuration.json /root/
# Expose
EXPOSE 8080
EXPOSE 5701

# Run
CMD ["/root/start-entrypoint.sh"]