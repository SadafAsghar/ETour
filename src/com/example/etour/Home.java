package com.example.etour;

import java.util.Timer;
import java.util.TimerTask;


import android.app.Activity;
import android.content.Intent;
import android.media.Image;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;

public class Home extends Activity implements OnClickListener {

	
		 public int currentimageindex=0;

	    ImageView slidingimage;
	 //   ImageButton ibLeftArrow;
	 //   ImageButton ibRightArrow;
	    ImageView random;
	    
	    private int[] IMAGE_IDS = {
	             R.drawable.test5, R.drawable.test3, R.drawable.test4
	            
	        };
	    
	    
	    
	    @Override
	    public void onCreate(Bundle savedInstanceState) {
	        super.onCreate(savedInstanceState);
	        setContentView(R.layout.home);
	        final Handler mHandler = new Handler();

	       // ibLeftArrow = (ImageButton)findViewById(R.id.larrow);
	      //  ibRightArrow = (ImageButton)findViewById(R.id.rarrow);
	        random = (ImageView)findViewById(R.id.ivslide);
	        
	      //  ibLeftArrow.setOnClickListener(this);
	      //  ibRightArrow.setOnClickListener(this);
	        random.setOnClickListener(this);
	        
	        // Create runnable for posting
	        final Runnable mUpdateResults = new Runnable() {
	            public void run() {
	                
	                AnimateandSlideShow();
	                
	            }
	        };
	        
	        int delay = 3000; // delay for 1 sec.

	        int period = 3000; // repeat every 4 sec.

	        Timer timer = new Timer();

	        
	        timer.scheduleAtFixedRate(new TimerTask() {

	        public void run() {

	             mHandler.post(mUpdateResults);

	        }

	        }, delay, period);
	        
	        
	               
	    }

	    
	    
	    /**
	     * Helper method to start the animation on the splash screen
	     */
	    private void AnimateandSlideShow() {
	        
	        
	        slidingimage = (ImageView)findViewById(R.id.ivslide);
	           slidingimage.setImageResource(IMAGE_IDS[currentimageindex%IMAGE_IDS.length]);
	           
	           currentimageindex++;
	        
	           Animation rotateimage = AnimationUtils.loadAnimation(this, R.anim.abc_fade_out);
	          
	        
	          slidingimage.startAnimation(rotateimage);
	          
	         //  slidingimage.setScaleType(ScaleType.FIT_XY);
	        
	    }

		@Override
		public void onClick(View v) {
			// TODO Auto-generated method stub
			Bundle data = new Bundle();
	
		switch(v.getId()){
		/*	case R.id.larrow:
				
				slidingimage.setImageResource(IMAGE_IDS[(currentimageindex--)%IMAGE_IDS.length]);
				
				break;
				
			case R.id.rarrow:
				
				slidingimage.setImageResource(IMAGE_IDS[(currentimageindex++)%IMAGE_IDS.length]);
				
				break;*/
				 
			case R.id.ivslide:
				if(currentimageindex%IMAGE_IDS.length==1)
				{
					data.putString("place", "Building");
				}
				
				else if (currentimageindex%IMAGE_IDS.length==2)
				{
					data.putString("place", "Park");
				}
				else
				{
					data.putString("place", "Mosque");
				}
				
				
			default:
				break;
		
			}
		Intent openMenu = new Intent(Home.this, Menu.class);
		openMenu.putExtras(data);
		startActivity(openMenu);
		}    
	    
	    
	}
	
	


