package es.deusto.ingenieria.sd.strava.server.services;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import es.deusto.ingenieria.sd.strava.server.data.domain.Activity;
import es.deusto.ingenieria.sd.strava.server.data.domain.Challenge;
import es.deusto.ingenieria.sd.strava.server.data.domain.User;

public class TrainingAppService {
	private static TrainingAppService instance = new TrainingAppService();

	//TODO: remove when DAO Pattern is implemented
	private List<Challenge> challenges = new ArrayList<>();
	private List<Activity> activities = new ArrayList<>();
	//TODO: remove when DAO Pattern is implemented
	private TrainingAppService() {
		this.initializeData();
	}
	//TODO: remove when DAO Pattern is implemented
	private void initializeData() {
		// TODO Auto-generated method stub
		//Create Users
		User user0 = new User();
		user0.setEmail("thomas.e2001@gmail.com");
		user0.setNickname("Thomas");
		user0.setPassword("$!9PhNz,");
		
		User user1 = new User();
		user1.setEmail("sample@gmail.com");
		user1.setNickname("buyer33");		
		user1.setPassword("hqc`}3Hb");
		
		//Create Challenges
		Challenge runAMarathon = new Challenge();
		runAMarathon.setTitle("Marathon");
		runAMarathon.setStart("20211113");
		runAMarathon.setEnd("20220524");
		runAMarathon.setTargetDistance(42);
		runAMarathon.setTargetTime(4);
		
		Challenge bike10Km = new Challenge();
		bike10Km.setTitle("Bike 10 KM");
		bike10Km.setStart("20211113");
		bike10Km.setEnd("20220524");
		bike10Km.setTargetDistance(10);
		bike10Km.setTargetTime(0);
	
		//Create Activities				
		Activity running5 = new Activity();
		running5.setTitle("Five KM");
		running5.setSport("running");
		running5.setDistanceKm(5);
		running5.setStartTime("10:00");
		running5.setStartDate("20201113");
		running5.setDurationMin(25);
					
		Activity running15 = new Activity();
		running5.setTitle("Fifteen KM");
		running5.setSport("running");
		running5.setDistanceKm(15);
		running5.setStartTime("12:00");
		running5.setStartDate("20201113");
		running5.setDurationMin(102);
		
		//Add the Activity to the local cache.
		this.activities.add(running5);
		this.activities.add(running15);

		this.challenges.add(runAMarathon);
		this.challenges.add(bike10Km);
	}
	

	
	public static TrainingAppService getInstance() {
		return instance;
	}
	public List<Challenge> getChallenges() {
		//TODO: Get all the categories using DAO Pattern	
		System.out.println("Challenges in TrainingAppServic" + this.challenges);
		return this.challenges;
	}
	public List<Activity> getActivities() {
		//TODO: Get all the categories using DAO Pattern	
		System.out.println("Activities in TrainingAppServic" + this.activities);
		return this.activities;
	}	

	public boolean createChallenge() {
		//TODO Create a challenge here, return true if the challenge is created correctly
		
		return true;
	}
	public boolean acceptChallenge(User user, String title) {	
		Challenge challengeObject = new Challenge();
		    for(Challenge challenge : challenges) {
		    	
		    	System.out.println("ACCEPTING: " + challenge.getTitle());
		        if(challenge.getTitle().equals(title)) {
		        	challengeObject = challenge;
		        	System.out.println("CHALLENGE CHECK NAME" + challenge);
		        	
		        }
		    }
		// System.out.println("Challengeobject in trainingappservice: "+ challengeObject);
		if (challengeObject != null) {
			user.acceptChallenge(challengeObject);
			return true;
		}
		else {
			return false;
		}		
	}
	
	public boolean startActivity() {
		//TODO	Create here the activity, taking into account the class diagram
		return true;
	}
	
	/*//TODO delete we dont need endActivity, revise class diagram
	 * 
	 * 
	 * 	public boolean startActivity(String title, String sport) {
			//TODO	
			return true;
		}
	 * 
	 */
}
