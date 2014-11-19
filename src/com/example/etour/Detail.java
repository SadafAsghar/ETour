package com.example.etour;

import android.app.Activity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;

public class Detail extends Activity{
	//String gotData;
	TextView _name;
	ImageView _image;
	TextView _detail;
	//RatingBar _rating;
	
	
	String gotDetail;
	String gotName;
	int gotImg;
	//float gotRating;
	

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.detail);
		
		_name = (TextView) findViewById(R.id.txtDName);
		_image = (ImageView)findViewById(R.id.imgDimage);
		_detail = (TextView)findViewById(R.id.txtDDetail);
		//_rating= (RatingBar)findViewById(R.id.ratingBarD);
		
		
		Bundle gotData = getIntent().getExtras();
		gotName=gotData.getString("name");
		gotDetail=gotData.getString("detail");
		gotImg=gotData.getInt("img");
		//gotRating=gotData.getFloat("rating");
		
		_name.setText(gotName);
		_detail.setText(gotDetail);
		_image.setImageResource(gotImg);
		//_rating.setRating(gotRating);
		
	}
	
}
