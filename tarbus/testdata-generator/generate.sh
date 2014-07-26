# first argument: host name or ip
# second argument: port number
mvn clean package exec:java -Dexec.args="$1 $2"