package com.example.helloworld;

import android.app.Service;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.IBinder;
import android.widget.Toast;

public class MusicService extends Service{
	MediaPlayer musicPlayer;
	
	public IBinder onBind(Intent arg){
		return null;
	}
	
	public void onCreate(){
		Toast.makeText(this, "Service Created", Toast.LENGTH_SHORT).show();
		musicPlayer = MediaPlayer.create(this, R.raw.music);
		musicPlayer.setLooping(true);
	}
	
	public void onStart(Intent intent, int startId){
		Toast.makeText(this, "Music service started", Toast.LENGTH_SHORT).show();
		musicPlayer.start();
	}
	
	public void onDestroy(){
		Toast.makeText(this, "Service ended", Toast.LENGTH_SHORT).show();
		musicPlayer.stop();
	}
}
