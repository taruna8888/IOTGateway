package com.welloculus.iotgateway.controller;

import static com.welloculus.iotgateway.constants.Constants.JSON_CONTENT;
import static com.welloculus.iotgateway.constants.Constants.SUCCESS;
import static com.welloculus.iotgateway.constants.Constants.ApiPath.ADD_HEALTH_RECORDS;
import static com.welloculus.iotgateway.constants.Constants.ApiPath.HEALTH_RECORDS;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.welloculus.iotgateway.service.HealthRecordService;
import com.welloculus.iotgateway.util.CustomLogger;

@CrossOrigin
@RestController
@RequestMapping(HEALTH_RECORDS)
public class HealthRecordController {

	@Autowired
	HealthRecordService healthRecordService;

	static CustomLogger logger = CustomLogger.getLogger();

	@ResponseBody
	@RequestMapping(value = ADD_HEALTH_RECORDS, method = RequestMethod.POST, consumes = JSON_CONTENT)
	public Map<String, Object> addHealthRecord(@RequestBody String recordString) {
		logger.debugStartOfMethod();
		Map<String, Object> response = new HashMap<String, Object>();
		try {
			healthRecordService.addRecord(recordString);
			response.put(SUCCESS, true);
		} catch (Exception e) {
			response.put(SUCCESS, false);
			logger.error(e);
		}
		logger.debugEndOfMethod();
		return response;
	}
}
