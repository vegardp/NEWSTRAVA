package es.deusto.ingenieria.sd.strava.server.data.dto;

import java.util.Date;
import java.io.*;

public class ChallengeDTO implements java.io.Serializable {
	private String title;
	private String start;
	private String end;
	private float targetDistance;
	private float targetTime;
 
	
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getStart() {
		return start;
	}
	public void setStart(String start) {
		this.start = start;
	}
	public String getEnd() {
		return end;
	}
	public void setEnd(String end) {
		this.end = end;
	}
	public float getTargetDistance() {
		return targetDistance;
	}
	public void setTargetDistance(float targetDistance) {
		this.targetDistance = targetDistance;
	}
	public float getTargetTime() {
		return targetTime;
	}
	public void setTargetTime(float targetTime) {
		this.targetTime = targetTime;
	}
	@Override
	public String toString() {
		return "ChallengeDTO [title=" + title + ", targetDistance=" + targetDistance + ", targetTime=" + targetTime
				+ "]";
	}
	
	
}
