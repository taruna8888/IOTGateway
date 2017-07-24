package com.welloculus.iotgateway.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.welloculus.iotgateway.components.KafkaRecordProducer;
import com.welloculus.iotgateway.service.HealthRecordService;

@Service("HealthRecordService")
public class HealthRecordServiceImpl implements HealthRecordService {

	@Autowired
	KafkaRecordProducer recordProducer;
	
	public static final String topic = "test";
	@Override
	public void addRecord(String message) {
		recordProducer.produce(message, topic);
	}
	
}
