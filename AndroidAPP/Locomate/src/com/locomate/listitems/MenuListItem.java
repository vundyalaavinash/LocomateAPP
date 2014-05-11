package com.locomate.listitems;

public class MenuListItem {
	private String title;
	private int image;
	
	
	public MenuListItem(String title, int image) {
		super();
		this.title = title;
		this.image = image;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public int getImage() {
		return image;
	}
	public void setImage(int image) {
		this.image = image;
	}
}
