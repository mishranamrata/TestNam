package com.json.java;

import java.util.List;

public class UserProfile {
	private String id;
	private String name;
	private String location;
	private String noOfDocContacts;
	public String getNoOfDocContacts() {
		return noOfDocContacts;
	}
	public void setNoOfDocContacts(String noOfDocContacts) {
		this.noOfDocContacts = noOfDocContacts;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getLocation() {
		return location;
	}
	public void setLocation(String location) {
		this.location = location;
	}
	public String getWork() {
		return work;
	}
	public void setWork(String work) {
		this.work = work;
	}
	public List<Groups> getGroup() {
		return group;
	}
	public void setGroup(List<Groups> group) {
		this.group = group;
	}
	public List<Pages> getPage() {
		return page;
	}
	public void setPage(List<Pages> page) {
		this.page = page;
	}
	public List<Surveys> getSurveys() {
		return surveys;
	}
	public void setSurveys(List<Surveys> surveys) {
		this.surveys = surveys;
	}
	public String getSmoking() {
		return smoking;
	}
	public void setSmoking(String smoking) {
		this.smoking = smoking;
	}
	public String gedDinking() {
		return dinking;
	}
	public void setDinking(String dinking) {
		this.dinking = dinking;
	}
	private String work;
	private List<Groups> group;
	private List<Pages> page;
	private List<Surveys> surveys;
	private String smoking;
	private String dinking;
}
