package com.example.helloworld;

import android.support.v7.app.ActionBarActivity;
import android.content.Intent;
import android.graphics.drawable.AnimationDrawable;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.TextView;



public class MainActivity extends ActionBarActivity {
	public WorldGen earth = new WorldGen("Earth", 5973,9.78);
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setStartUpWorld();
        setStartUpScreenText();
        setUpScreenAnim();
        setStartUpScreenAudio();
    }

    private void setUpScreenAnim(){
    	/*ImageView homePlanet = (ImageView)findViewById(R.id.imageEarth);
    	AnimationDrawable ffAnim = (AnimationDrawable)homePlanet.getBackground();
    	ffAnim.start();*/
    	
    	ImageView effectPlanet = (ImageView)findViewById(R.id.planetEffect);
    	Animation animSetRing = AnimationUtils.loadAnimation(this,R.anim.anim_set_ring);
    	effectPlanet.startAnimation(animSetRing);
    }
    
    public void setStartUpScreenAudio(){
    	MediaPlayer audio = MediaPlayer.create(getApplicationContext(), R.raw.ambient);
    	audio.setLooping(true);
    	audio.start();
    }
    
    protected void setStartUpWorld(){
          earth.setPlanetColonies(1);
          earth.setPlanetMilitary(1);
          earth.setPlanetPopulation(1000);
          earth.setPlanetBases(100);
          earth.setPlanetProtected(true);
    }
    
    protected void setStartUpScreenText(){
    	TextView planetName = (TextView)findViewById(R.id.dataview1);
    	planetName.setText(String.valueOf(earth.getPlanetName()));
    	TextView planetMass = (TextView)findViewById(R.id.dataview2);
    	planetMass.setText(String.valueOf(earth.getPlanetMass()));
    	TextView planetGrav = (TextView)findViewById(R.id.dataview3);
    	planetGrav.setText(String.valueOf(earth.getPlanetGravity()));
    	TextView planetCol = (TextView)findViewById(R.id.dataview4);
    	planetCol.setText(String.valueOf(earth.getPlanetColonies()));
    	TextView planetPop = (TextView)findViewById(R.id.dataview5);
    	planetPop.setText(String.valueOf(earth.getPlanetPopulation()));
    	TextView planetMilitary = (TextView)findViewById(R.id.dataview6);
    	planetMilitary.setText(String.valueOf(earth.getPlanetMilitary()));
    	TextView planetBases = (TextView)findViewById(R.id.dataview7);
    	planetBases.setText(String.valueOf(earth.getPlanetBases()));
    	TextView planetProt = (TextView)findViewById(R.id.dataview8);
    	planetProt.setText(String.valueOf(earth.isPlanetProtected()));
    }
    
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
      
    	
    	int id = item.getItemId();
        switch(id){
        	case R.id.add:
        		Intent add = new Intent(this,NewPlanet.class);
        		this.startActivity(add);
        		break;
        	case R.id.config:
        		Intent config = new Intent(this,ConfigPlanet.class);
        		this.startActivity(config);
        		break;
        	case R.id.travel:
        		Intent travel = new Intent(this,TravelPlanet.class);
        		this.startActivity(travel);
        		break;
        	case R.id.attack:
        		Intent attack = new Intent(this, AttackPlanet.class);
        		this.startActivity(attack);
        		break;
        	case R.id.contact:
        		Intent contact = new Intent(this, AlienContact.class);
        		this.startActivity(contact);
        	default:
        		 return super.onOptionsItemSelected(item);
        	}
       return true;
    }
}
