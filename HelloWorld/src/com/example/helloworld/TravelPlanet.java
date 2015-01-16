package com.example.helloworld;

import android.app.Activity;
import android.net.Uri;
import android.os.Bundle;
import android.widget.Button;
import android.widget.MediaController;
import android.widget.Toast;
import android.widget.VideoView;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnTouchListener;

public class TravelPlanet extends Activity {
	public void onCreate(Bundle savedInstanceState){
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_travel);
		Uri videoURI = Uri.parse("android.resource://" + getPackageName() +"/"+R.raw.mars270);
		
		//gets video uri
		VideoView traveling = (VideoView)findViewById(R.id.travelVideoView);
		traveling.setVideoURI(videoURI);
		//sets up media controller
		MediaController videoMedia = new MediaController(this);
		videoMedia.setAnchorView(traveling);
		traveling.setMediaController(videoMedia);
		traveling.bringToFront();
		traveling.requestFocus();
		traveling.start();
		
		Button travelButton = (Button)findViewById(R.id.travelButton);
		travelButton.setOnClickListener(new OnClickListener(){
 
			@Override
			public void onClick(View v) {
				Toast.makeText(TravelPlanet.this, "Going Home", Toast.LENGTH_SHORT).show();
				finish();		
			}
			
		});
	}
	
	public boolean onKeyDown(int keyCode, KeyEvent event){
		if(keyCode == KeyEvent.KEYCODE_X){
			finish();
			return true;
		}
		
		return false;
	}
}
