package com.welloculus.iotgateway.components;

import java.util.Properties;

import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import com.welloculus.iotgateway.util.CustomLogger;

@Component
public class KafkaRecordProducer {

	static CustomLogger logger = CustomLogger.getLogger();
	@Value("${bootstrap.servers}")
	String kafkaServers;

	public void produce(String message, String topic) {
		KafkaProducer<String, String> producer;
		Properties properties = new Properties();

		properties.put("bootstrap.servers", kafkaServers);
		properties.put("acks", "all");
		properties.put("retries", 0);
		properties.put("batch.size", 16384);
		properties.put("auto.commit.interval.ms", 1000);
		properties.put("linger.ms", 0);
		properties.put("key.serializer", "org.apache.kafka.common.serialization.StringSerializer");
		properties.put("value.serializer", "org.apache.kafka.common.serialization.StringSerializer");
		properties.put("block.on.buffer.full", true);
		producer = new KafkaProducer<>(properties);
		try {
			producer.send(new ProducerRecord<String, String>(topic, message));
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			producer.close();
		}
	}
}
