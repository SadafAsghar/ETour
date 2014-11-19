package com.example.etour;

import java.util.ArrayList;
import java.util.List;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.RatingBar;
import android.widget.TextView;
import android.widget.Toast;

public class Menu extends Activity{
	
	private List<Info> myPlaces = new ArrayList<Info>();
	
	String place;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.menu);
		
		Bundle data = getIntent().getExtras();
		place = data.getString("place");
		
		if (place.matches("Building"))
			populateBuildingList();
		else if (place.matches("Park"))
			populateParkList();
		else if (place.matches("Mosque"))
			populateMosqueList();
		
		populateListView();
		registerClickCallBack();
	}
	
	

	private void populateMosqueList() {
		myPlaces.add(new Info ("Badshahi Mosque" , 4.5f, R.drawable.test1m, "Badshahi Mosque is located near Badshahi Masjid. The main atractions near the place are food street, blah blah."));
		myPlaces.add(new Info ("Faisal Mosque" , 5f, R.drawable.test2, "Faisal Mosque is located near Badshahi Masjid. The main atractions near the place are food street, blah blah."));
		
	}



	private void populateBuildingList() {
		
		myPlaces.add(new Info ("Lahore Fort" , 3.3f, R.drawable.test3, "Lahore fort is located near Badshahi Masjid. The main atractions near the place are food street, blah blah."));
		myPlaces.add(new Info ("Minar-e-Pakistan" , 2, R.drawable.test4, "Manar e Pakistan is located near Badshahi Masjid. The main atractions near the place are food street, blah blah."));
		
	}
	
	
	private void populateParkList() {
		
		myPlaces.add(new Info ("Shalamar Garden" , 1.5f, R.drawable.test5, "Shalamar Graden is located near Badshahi Masjid. The main atractions near the place are food street, blah blah."));
		myPlaces.add(new Info ("Bagh e Jinnah" , 1f, R.drawable.test4, "Bagh e Jinnahis located near Badshahi Masjid. The main atractions near the place are food street, blah blah."));
		
	}
	
	private void populateListView() {
		ArrayAdapter <Info> adapter = new MyListAdapter();
		ListView list = (ListView) findViewById(R.id.lvMenu);
		list.setAdapter(adapter);
		
	}
	
	private void registerClickCallBack() {
		
		ListView list = (ListView) findViewById(R.id.lvMenu);
		list.setOnItemClickListener(new AdapterView.OnItemClickListener() {

			@Override
			public void onItemClick(AdapterView<?> parent, View view,
					int position, long id) {
				Info clickedBuilding = myPlaces.get(position);
				//String message = "You clicked " + clickedBuilding.getName();
				//Toast.makeText(BuildingMenu.this, message, Toast.LENGTH_LONG).show();
				Bundle data=new Bundle();
				data.putInt("img", clickedBuilding.getIconID());
				//data.putFloat("rating", clickedBuilding.getRatings());
				data.putString("name",clickedBuilding.getName());
				data.putString("detail",clickedBuilding.getDetail());
				Intent openDetail = new Intent(Menu.this, Detail.class);
				openDetail.putExtras(data);
				startActivity(openDetail);
				
			}
			
			
		} 
		);
	}
	

	
	private class MyListAdapter extends ArrayAdapter<Info>{
		
		

		public MyListAdapter(){
			super(Menu.this, R.layout.item_view, myPlaces);
			
		}
		
		@Override
		public View getView(int position, View convertView, ViewGroup parent) {
			View itemView = convertView;
			if (itemView == null)
				itemView = getLayoutInflater().inflate(R.layout.item_view, parent, false);
			
			Info currentPlace = myPlaces.get(position);
			
			ImageView imageview = (ImageView)itemView.findViewById(R.id.imgicon);
			imageview.setImageResource(currentPlace.getIconID());
			
			TextView name = (TextView)itemView.findViewById(R.id.txtName);
			name.setText(currentPlace.getName());
		
			//RatingBar rating = (RatingBar)itemView.findViewById(R.id.ratingBar);
			//rating.setRating((float)currentPlace.getRatings());
			
			
			return itemView;
		}		
		
	}

}
