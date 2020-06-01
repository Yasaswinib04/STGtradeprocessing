package com.citi.stg.Microservice1;

import com.citi.stg.Microservice1.GenericTradeString.GenericTradeString;
import org.apache.commons.io.FileUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.kafka.core.KafkaTemplate;

import java.io.File;
import java.nio.file.*;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

@SpringBootApplication
public class Microservice1Application implements ApplicationRunner{
	@Autowired
	private KafkaTemplate<String,String> kafkaTemplate;
	private static String topic="56y1nhk1-GenericTradeTopic";

	public static void main(String[] args) { SpringApplication.run(Microservice1Application.class, args); }


	@Override
	public void run(ApplicationArguments args) throws Exception {

		File f;
		String xmlpath="src/main/resources/Trades/";
		Iterator iterator= FileUtils.iterateFiles(new File(xmlpath),null,false);
		while (iterator.hasNext()){
			f=(File)iterator.next();
			new GenericTradeString(kafkaTemplate,topic,f.getAbsolutePath()).start();
		}
		try(WatchService service = FileSystems.getDefault().newWatchService()){
			Map<WatchKey, Path> keyMap = new HashMap<>();

			Path path = Paths.get(xmlpath);
			keyMap.put(path.register(service,StandardWatchEventKinds.ENTRY_CREATE),path);

			WatchKey watchKey;
			do {
				watchKey=service.take();
				for (WatchEvent<?> event : watchKey.pollEvents()){
					Path eventPath = (Path)event.context();
					new GenericTradeString(kafkaTemplate,topic,xmlpath+eventPath.getFileName().toString()).start();
				}
			}while (watchKey.reset());
		} catch (Exception e) {
			e.printStackTrace();
		}

	}
}
