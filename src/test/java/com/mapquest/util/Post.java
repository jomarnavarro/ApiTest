package com.mapquest.util;

public class Post {
	
	int id;
	String title;
	String author;
	
	public Post() {
		this.setId(new java.util.Random().nextInt(50000));
		this.title = "";
		this.author = "";
	
	}
	
	public Post(String title, String author) {
		this.setId(new java.util.Random().nextInt(50000));
		this.title = title;
		this.author = author;
	
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getAuthor() {
		return author;
	}
	public void setAuthor(String author) {
		this.author = author;
	}
	
	

}
