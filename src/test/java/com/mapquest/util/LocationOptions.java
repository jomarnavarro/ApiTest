package com.mapquest.util;

public class LocationOptions {
	
	boolean thumbMaps;
	int maxResults;
	
	public LocationOptions() {
		this.thumbMaps = false;
		this.maxResults = 1;
	}
	
	public LocationOptions(boolean thumbMaps, int maxResults) {
		this.thumbMaps = thumbMaps;
		this.maxResults = maxResults;
	}
	
	
	public boolean isThumbMaps() {
		return thumbMaps;
	}
	public void setThumbMaps(boolean thumbMaps) {
		this.thumbMaps = thumbMaps;
	}
	public int getMaxResults() {
		return maxResults;
	}
	public void setMaxResults(int maxResults) {
		this.maxResults = maxResults;
	}
	
	
	

}
