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

@Component
public class Controller implements ApplicationRunner {
    @Autowired
    private KafkaTemplate<String, String> kafkaTemplate;
    @Value("${topic.kafka}")
    private String topic;
    @Value("${path.TradeFolder}")
    private String xmlpath;

    @Override
    public void run(ApplicationArguments args) throws Exception {

        File f;

        Iterator iterator = FileUtils.iterateFiles(new File(xmlpath), null, false);
        while (iterator.hasNext()) {
            f = (File) iterator.next();
            new GenericTradeString(kafkaTemplate, topic, f.getAbsolutePath()).start();
        }
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
