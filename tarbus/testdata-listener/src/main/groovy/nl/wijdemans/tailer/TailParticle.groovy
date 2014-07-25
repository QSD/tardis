package nl.wijdemans.tailer;

import org.vertx.groovy.platform.Verticle


// http://commons.apache.org/proper/commons-vfs/apidocs/org/apache/commons/vfs2/impl/DefaultFileMonitor.html
public class TailParticle extends Verticle {

    def filename = "/data/file"

    def start() {

        def lineLength = calculateFileLength()
        println "start reading from ${lineLength}"

        def file = new File(filename)
        def interval = 1000L

        long fileSize = file.size() // use size to check if something changed
        while(true) {
            // Compare the length of the file to the file pointer
            long currentFileSize = file.size()
            if( currentFileSize > fileSize ) {
                def newLineLength = ("wc -l < $filename".execute().text)

                if (newLineLength < lineLength) {
                    println "Lines are being deleted! "
                } else {
                    println "Read from ${newLineLength} to ${lineLength} ... "
                    (newLineLength..lineLength).each{
                        println "START PROCESSING: ${it}"
                    }
                    lineLength = newLineLength
                }
            }
            // Sleep for the specified interval
            Thread.sleep( interval )
        }

//        vertx.eventBus.send("tail-address", "useful information found") { message ->
//        }
//        vertx.eventBus.registerHandler("tail-address") { message ->
//            message.reply("pong!")
//            container.logger.info("Sent back pong groovy!")
//        }
    }

    private String calculateFileLength() {
        "wc -l < $filename".execute().text.split(" ")[0]
    }
}
