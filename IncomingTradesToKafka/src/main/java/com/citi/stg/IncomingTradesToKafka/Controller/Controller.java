package com.citi.stg.IncomingTradesToKafka.Controller;

import com.citi.stg.IncomingTradesToKafka.GenericTradeStringThread.GenericTradeString;
import org.apache.commons.io.FileUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;

import java.io.File;
import java.nio.file.*;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/*
 * Class that initiates the flow of this microservice.
 *
 * Accessing a folder for input Trade files and starting a thread for each file to be processed.
 *
 * WatchService monitoring the directory for creation of new files implying a new incoming Trade.
 */
@Component
public class Controller implements ApplicationRunner {
    @Autowired
    private KafkaTemplate<String, String> kafkaTemplate;
    @Value("${topic.kafka}")
    private String topic;
    @Value("${path.TradeFolder}")
    private String xmlpath;

    @Override
    public void run(ApplicationArguments args) {

        File f;
        /*
         * FileUtils class provides method to manipulates files like moving, opening, checking existence, reading of file etc.
         * These methods use File Object.
         *
         * An Iterator used to iterate through the files.
         */
        Iterator<File> iterator = FileUtils.iterateFiles(new File(xmlpath), null, false);
        while (iterator.hasNext()) {
            f = iterator.next();
            new GenericTradeString(kafkaTemplate, topic, f.getAbsolutePath()).start();
        }
        /*
         * A WatchService instance watches registered objects for changes and events.
         *
         * A file manager may use a watch service to monitor a directory for changes so that it can update its display of the list of files when
         * files are created or deleted.
         *
         * Here it is used for watching a creation of new file in the Trades directory, and starting a thread for the newly created file
         * to be processed and sent to the Kafka Producer for publishing to topic.
         */
        try (WatchService service = FileSystems.getDefault().newWatchService()) {
            Map<WatchKey, Path> keyMap = new HashMap<>();

            Path path = Paths.get(xmlpath);
            keyMap.put(path.register(service, StandardWatchEventKinds.ENTRY_CREATE), path);

            WatchKey watchKey;
            do {
                watchKey = service.take();
                for (WatchEvent<?> event : watchKey.pollEvents()) {
                    Path eventPath = (Path) event.context();
                    Thread.sleep(50);
                    new GenericTradeString(kafkaTemplate, topic, xmlpath + eventPath.getFileName().toString()).start();
                }
            } while (watchKey.reset());
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
