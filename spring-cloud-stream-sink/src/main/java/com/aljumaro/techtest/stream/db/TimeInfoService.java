package com.aljumaro.techtest.stream.db;

import java.util.Date;
import java.util.UUID;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.aljumaro.techtest.stream.SpringCloudStreamSinkApplication.SinkTimeInfo;

@Service
@Transactional
public class TimeInfoService {
	
	@Autowired
	private TimeInfoRepository repository;

	public void save(SinkTimeInfo sinkTimeInfo) {
		
		TimeInfo timeInfo = new TimeInfo();
		timeInfo.setId(UUID.randomUUID().toString());
		timeInfo.setTick(new Date(Long.valueOf(sinkTimeInfo.getTime())));
		timeInfo.setLabel(sinkTimeInfo.getLabel());
		repository.save(timeInfo);
		
	}
}
