# RUN_CONTAINER sudo docker run -d -P --name generator -v /data:/data register.dev.qsd.nl/generator

FROM 	            nathwill/centos-small:6.5
MAINTAINER          jeroen wijdemans

RUN                 yum install python

ADD                 src/ /opt/generator

VOLUME              ["/data2/"]

CMD ["/usr/bin/python", "/opt/generator/generate.py"]

