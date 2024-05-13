package edu.sejong.ex.LogTrace;

import lombok.Data;

@Data
public class TraceStatus {
	
	private TraceId traceId;
	private Long startTime;
	private String message;
	
	public TraceStatus(TraceId traceID, Long startTime, String message) {
		super();
		this.traceId = traceID;
		this.startTime = startTime;
		this.message = message;
	}
	
	
}
