package com.example.helloworld;

import android.app.Activity;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.view.KeyEvent;
import android.view.View;
import android.view.View.OnClickListener;

public class ConfigPlanet extends Activity {
	private MediaPlayer clickPlayer = null;
	public void onCreate(Bundle savedInstanceState){
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_config);
		clickPlayer = MediaPlayer.create(getApplicationContext(),R.raw.click);
		
		TextView forceField = (TextView)findViewById(R.id.ForceFieldInfo);
		forceField.setText("FF off");
		
		EditText colonyText = (EditText)findViewById(R.id.editColonies);
		colonyText.setText("1",TextView.BufferType.EDITABLE);
		
		EditText colonistText = (EditText)findViewById(R.id.editColonists);
		colonistText.setText("100", TextView.BufferType.EDITABLE);
		
		EditText militaryText = (EditText)findViewById(R.id.editMilitary);
		militaryText.setText("10", TextView.BufferType.EDITABLE);
		
		EditText basesText = (EditText)findViewById(R.id.editBases);
		basesText.setText("5", TextView.BufferType.EDITABLE);
		
		Button doneButton = (Button)findViewById(R.id.doneConfig);	
		doneButton.setOnClickListener(new OnClickListener(){
			@Override
			public void onClick(View v) {
				clickPlayer.start();
				finish();
			}
		});
		Button colonistButton = (Button)findViewById(R.id.ColonistButton);	
		colonistButton.setOnClickListener(new OnClickListener(){
			@Override
			public void onClick(View v) {
				clickPlayer.start();
				finish();
			}
		});
		Button coloniesButton = (Button)findViewById(R.id.coloniesButton);	
		coloniesButton.setOnClickListener(new OnClickListener(){
			@Override
			public void onClick(View v) {
				clickPlayer.start();
				finish();
			}
		});
		Button baseButton = (Button)findViewById(R.id.baseButton);	
		baseButton.setOnClickListener(new OnClickListener(){
			@Override
			public void onClick(View v) {
				clickPlayer.start();
				finish();
			}
		});
		Button militaryButton = (Button)findViewById(R.id.militaryButton);	
		militaryButton.setOnClickListener(new OnClickListener(){
			@Override
			public void onClick(View v) {
				clickPlayer.start();
				finish();
			}
		});
		Button forceButton = (Button)findViewById(R.id.protectButton);	
		forceButton.setOnClickListener(new OnClickListener(){
			@Override
			public void onClick(View v) {
				clickPlayer.start();
				finish();
			}
		});
		
		Button clockButton = (Button)findViewById(R.id.timeButton);
		clockButton.setOnClickListener(new OnClickListener(){
			public void onClick(View v){
				Intent callTimeIntent = new Intent(v.getContext(),TimePlanet.class);
				startActivityForResult(callTimeIntent,0);
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
