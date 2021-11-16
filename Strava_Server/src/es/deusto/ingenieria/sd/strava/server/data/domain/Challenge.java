package es.deusto.ingenieria.sd.strava.server.data.domain;

import java.util.Date;

public class Challenge {
	private String title;
	private String start;
	private String end;
	private float targetDistance;
	private int targetTime; 
	
	
	public Challenge() {
		
	}
	
	public Challenge(String title, String start, String end, float targetDistance, int targetTime) {
		this.title = title;
		this.start = start;
		this.end = end;
		this.targetDistance = targetDistance;
		this.targetTime = targetTime;
	}

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

	public int getTargetTime() {
		return targetTime;
	}

	public void setTargetTime(int targetTime) {
		this.targetTime = targetTime;
	}


	@Override
	public String toString() {
		return "Challenge [title=" + title + ", targetDistance=" + targetDistance + ", targetTime=" + targetTime
				+ "]";
	};
	
	
}
