package com.example.helloworld;


import android.app.Activity;
import android.graphics.drawable.TransitionDrawable;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.Toast;

public class NewPlanet extends Activity{
	private MediaPlayer marsPlayer = null;
	
	public void onCreate(Bundle savedInstanceState){
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_add);
		
		final TransitionDrawable trans = (TransitionDrawable)getResources().getDrawable(R.drawable.tran_stars_galaxy);
		RelativeLayout newPlanetScreen = (RelativeLayout)findViewById(R.id.new_planet_screen);
		newPlanetScreen.setBackground(trans);
		
		marsPlayer = MediaPlayer.create(getApplicationContext(),R.raw.mars);
		ImageView marsImg = (ImageView)findViewById(R.id.imageMars);
		marsImg.setOnClickListener(new OnClickListener(){
			@Override
			public void onClick(View v) {
				WorldGen mars = new WorldGen("Mars",642, 3.7);
				mars.setPlanetColonies(1);
				Toast.makeText(NewPlanet.this, "Mars Created", Toast.LENGTH_SHORT).show();
				marsPlayer.start();
				trans.startTransition(5000);
			}
			
		});
		
		
		
		Button doneButton = (Button)findViewById(R.id.doneAdding);
		doneButton.setOnClickListener(new OnClickListener(){
			public void onClick(View v){
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
