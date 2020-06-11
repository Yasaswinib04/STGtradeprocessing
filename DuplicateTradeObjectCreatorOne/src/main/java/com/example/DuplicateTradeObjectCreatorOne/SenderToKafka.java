package com.example.DuplicateTradeObjectCreatorOne;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;



@Component
public class SenderToKafka{
	
    @Autowired
	private KafkaTemplate<String,Trade> kafkaTemplate;
	
	
    private static final String topic="nbneddjx-ExceptionListTopic";
	
    private static int count=1;
	
	public  void sendToKafka(Trade trade) {
		System.out.println("----------------sending trrade no:"+count+"------------------------------------");
			try {
				this.kafkaTemplate.send(topic,trade);
			}catch(Exception e) {
				System.out.println("Here you are getting unknown host exception");
			}
		System.out.println("----------------sent trrade no:"+count+"------------------------------------");
		count++;
	}

}

//The code below were written when trying t6o construct own custom kafkatemplate
//-----------------------------------------------------------------------------------------------------
//
//public String serverConfiguration="moped-01.srvs.cloudkafka.com:9094,moped-02.srvs.cloudkafka.com:9094,moped-03.srvs.cloudkafka.com:9094";
//public String sasl_jas_config="org.apache.kafka.common.security.scram.ScramLoginModule required username=56y1nhk1 password=kROr-n2oL2pgvuoNpleReQrbYRdfTejB";
//
//public ProducerFactory<String, Trade> producerFactory() {
//	
//    Map<String, Object> config = new HashMap<>();
//    config.put(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG, serverConfiguration);
//    config.put(SaslConfigs.SASL_JAAS_CONFIG,sasl_jas_config);
////    config.put(SaslConfigs.DEFAULT_SASL_MECHANISM,"SCRAM-SHA-256");
////    config.put(StreamsConfig.SECURITY_PROTOCOL_CONFIG,"SASL_SSL");
//    config.put(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG, StringSerializer.class);
//    config.put(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG, JsonSerializer.class);
//
//    return new DefaultKafkaProducerFactory<>(config);
//}
//
//public KafkaTemplate<String, Trade> kafkaTemplate() {
//   return new KafkaTemplate<>(producerFactory());
//}

