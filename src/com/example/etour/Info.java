package com.example.etour;

public class Info {
	
	private String name;
	private float ratings;
	private int iconID;
	private String detail;
	//private Class<?> tag;
	
	public Info (String _name, float _ratings, int _iconID, String _detail){
		super();
		this.name = _name;
		this.ratings = _ratings;
		this.iconID = _iconID;
		this.detail = _detail;
		
	}
	

	public String getName(){
		return name;
	}
	
	public float getRatings(){
		return ratings;
	}
	
	public int getIconID(){
		return iconID;
	}
	
	public String getDetail(){
		return detail;
	}
	
	public void setRatings(float _rating){
		this.ratings=_rating;
	}


	
}
