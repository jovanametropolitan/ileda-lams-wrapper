package com.metropolitan.iledalamswrapper.lams.entities;

import java.sql.Timestamp;

public class LamsAssessment {
	protected int maximumGrade;
	protected float grade;
	protected String username;
	protected String testTitle;
	protected Timestamp testDate;
	protected double points;
	protected int testTime;
	protected Timestamp endTime;
	
	public LamsAssessment() {}
	
	public int getMaximumGrade() {
		return maximumGrade;
	}
	public void setMaximumGrade(int maximumGrade) {
		this.maximumGrade = maximumGrade;
	}

	public float getGrade() {
		return grade;
	}
	public void setGrade(float grade) {
		this.grade = grade;
	}

	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}

	public String getTestTitle() {
		return testTitle;
	}
	public void setTestTitle(String testTitle) {
		this.testTitle = testTitle;
	}

	public Timestamp getTestDate() {
		return testDate;
	}
	public void setTestDate(Timestamp testDate) {
		this.testDate = testDate;
	}

	public double getPoints() {
		return points;
	}
	public void setPoints(double points) {
		this.points = points;
	}
	
	public int getTestTime() {
		return testTime;
	}

	public void setTestTime(int testTime) {
		this.testTime = testTime;
	}

	public Timestamp getEndTime() {
		return endTime;
	}

	public void setEndTime(Timestamp endTime) {
		this.endTime = endTime;
	}

	@Override
	public String toString() {
		return "LamsAssessment [maximumGrade=" + maximumGrade + ", grade="
				+ grade + ", username=" + username + ", testTitle=" + testTitle
				+ ", testDate=" + testDate + ", points=" + points
				+ ", testTime=" + testTime + ", endTime=" + endTime + "]";
	}
	
}
