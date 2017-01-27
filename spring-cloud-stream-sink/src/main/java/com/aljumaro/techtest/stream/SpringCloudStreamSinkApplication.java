package com.aljumaro.techtest.stream;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.cloud.stream.messaging.Sink;

import com.aljumaro.techtest.stream.db.TimeInfoService;

@SpringBootApplication
@EnableBinding(Sink.class)
public class SpringCloudStreamSinkApplication {

	private static final Logger log = LoggerFactory.getLogger(SpringCloudStreamSinkApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(SpringCloudStreamSinkApplication.class, args);
	}
	
	@Autowired
	private TimeInfoService service;

	@StreamListener(Sink.INPUT)
	public void loggerSink(SinkTimeInfo sinkTimeInfo) {
		log.info("Received: " + sinkTimeInfo.toString());
		
		service.save(sinkTimeInfo);
	}

	public static class SinkTimeInfo {

		private String time;
		private String label;

		public String getTime() {
			return time;
		}

		public void setTime(String time) {
			this.time = time;
		}

		public void setSinkLabel(String label) {
			this.label = label;
		}

		public String getLabel() {
			return label;
		}

		@Override
		public String toString() {
			return "SinkTimeInfo [time=" + time + ", label=" + label + "]";
		}

	}
}
