
# Goal

The tarbus contains projects that run on the bus.
 
 to together to read parse log file data and send important
data to listing clients.

## Flow

Generator creates data and write this to a file (accessible through VOLUME)

The tailor reads data and picks that data that it finds interesting. Data is send to the vert.x channel.

The gatherer reads information from the channel and persists it. 
 
The publisher

### The generator
One or more generators. Build for speed, so they are [small docker containers](http://blog.docker.com/2013/06/create-light-weight-docker-containers-buildroot/) or 
just [start from scratch](https://docs.docker.com/articles/baseimages/)

Or maybe just a simple CentOS box. 

NOTE: data is written to the VOL in batches of 4K (need to change ??)
Generation is done
 * using Python
 * on a Volume
 
Build the image
```
sudo docker build -t register.dev.qsd.nl/generator .
```

And run it
```
sudo docker run -d -P --name generator -v /data:/data:rw register.dev.qsd.nl/generator 
```


And run that
```
sudo docker run -d register.dev.qsd.nl/generator 
sudo docker run -d -P --name generator -v /data:/data register.dev.qsd.nl/generator 

sudo docker run -d -v /data:/data register.dev.qsd.nl/generator 
```

## The tailer



# Techniques

* Vert.x
* Docker
* Java 8
* Groovy

# Docker

After the projects are build they need to be deployed on a CoreOS cluster. 

## Local

A local CoreOS cluster in Vagrant is used for local development. The cluster also hosts our own Docker registry 
(inside a container of course).

# Notes
Add yourself to the docker group!
```
 sudo usermod -a -g docker jeroen
```

## nsenter on 14.04
https://gist.github.com/wangyandong-ningxia/0ba636a0448f24de4c20
http://askubuntu.com/questions/439056/why-there-is-no-nsenter-in-util-linux

PID=$(docker inspect --format {{.State.Pid}} <container_name_or_ID>)
nsenter --target $PID --mount --uts --ipc --net --pid
