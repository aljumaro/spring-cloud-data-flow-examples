package com.aljumaro.techtest.stream;

import java.util.Calendar;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.cloud.stream.messaging.Processor;
import org.springframework.messaging.handler.annotation.SendTo;

@SpringBootApplication
@EnableBinding(Processor.class)
public class SpringCloudStreamProcessorApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringCloudStreamProcessorApplication.class, args);
	}

	@StreamListener(Processor.INPUT)
	@SendTo(Processor.OUTPUT)
	public Object transform(SinkTimeInfo input) {
		System.out.println("Procesing: " + input.toString());
		input.setSinkLabel(input.getLabel() + " Processed at " + Calendar.getInstance().getTime().toString());
		return input;
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
