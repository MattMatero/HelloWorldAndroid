package com.example.helloworld;

import java.util.HashMap;

import android.app.Activity;
import android.content.Context;
import android.graphics.drawable.AnimationDrawable;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.media.SoundPool;
import android.os.Bundle;
import android.util.SparseIntArray;
import android.view.KeyEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.Toast;

public class AttackPlanet extends Activity {
	/*private MediaPlayer bombPlayer = null;
	private MediaPlayer invadePlayer = null;
	private MediaPlayer virusPlayer = null;
	private MediaPlayer laserPlayer = null;*/
	private SoundPool soundPoolFX = null;
	private SparseIntArray soundPoolMap;
	int[] samples = {1,2,3,4};
	
	public void onCreate(Bundle savedInstanceState){
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_attack);
		//setAudioPlayers();
		soundPoolFX = new SoundPool(4,AudioManager.STREAM_MUSIC,100);
		soundPoolMap = new SparseIntArray(4);
		soundPoolMap.put(samples[0], soundPoolFX.load(this,R.raw.blast,1));
		soundPoolMap.put(samples[1], soundPoolFX.load(this,R.raw.transport,1));
		soundPoolMap.put(samples[2], soundPoolFX.load(this,R.raw.virus,1));
		soundPoolMap.put(samples[3], soundPoolFX.load(this,R.raw.laser,1));
		
		ImageButton attackBomb = (ImageButton)findViewById(R.id.bombButton);
		Animation rotatebomb = AnimationUtils.loadAnimation(this, R.anim.anim_rot_bomb);
		attackBomb.startAnimation(rotatebomb);
		
		attackBomb.setOnClickListener(new OnClickListener(){
			public void onClick(View v){
				Toast.makeText(AttackPlanet.this, "Bombs Deployed!", Toast.LENGTH_SHORT).show();
				playSample(1,1.0f);
				//bombPlayer.start();
			}
		});
		
		ImageButton attackInvade = (ImageButton)findViewById(R.id.invadeButton);
		Animation alphaInvade = AnimationUtils.loadAnimation(this, R.anim.anim_alpha_invade);
		attackInvade.startAnimation(alphaInvade);
		attackInvade.setOnClickListener(new OnClickListener(){
			public void onClick(View v){
				Toast.makeText(AttackPlanet.this, "Troops sent", Toast.LENGTH_SHORT).show();
				playSample(2,1.0f);
				//invadePlayer.start();
			}
		});
		
		ImageView invadeEffect = (ImageView)findViewById(R.id.invadeEffect);
		AnimationDrawable transporterEffect = (AnimationDrawable)invadeEffect.getBackground();
		transporterEffect.start();
		
		Animation scaleVirus = AnimationUtils.loadAnimation(this, R.anim.anim_scale_virus);
		ImageButton attackVirus = (ImageButton)findViewById(R.id.virusButton);
		attackVirus.startAnimation(scaleVirus);
		attackVirus.setOnClickListener(new OnClickListener(){
			public void onClick(View v){
				Toast.makeText(AttackPlanet.this, "Virus Spread", Toast.LENGTH_SHORT).show();
				playSample(3,1.0f);
				//virusPlayer.start();
			}
		});
		
		ImageButton attackLaser = (ImageButton)findViewById(R.id.laserButton);
		Animation translateLaser = AnimationUtils.loadAnimation(this,R.anim.anim_trans_laser);
		attackLaser.startAnimation(translateLaser);
		
		attackLaser.setOnClickListener(new OnClickListener(){
			public void onClick(View v){
				Toast.makeText(AttackPlanet.this, "Laser Fired!", Toast.LENGTH_SHORT).show();
				playSample(4,1.0f);
				//laserPlayer.start();
			}
		});
		
		ImageButton finishAttack =(ImageButton)findViewById(R.id.exitAttack);
		finishAttack.setOnClickListener(new OnClickListener(){
				public void onClick(View v){
					finish();
				}
		});
		
		
	} 
	
	public void playSample(int sample, float pitchShift){
		AudioManager manageAudio = (AudioManager)getSystemService(Context.AUDIO_SERVICE);
		float curVol = manageAudio.getStreamVolume(AudioManager.STREAM_MUSIC);
		float maxVol = manageAudio.getStreamMaxVolume(AudioManager.STREAM_MUSIC);
		float setVol = curVol/maxVol;
		soundPoolFX.play(soundPoolMap.get(sample), setVol, setVol, 0, 0, pitchShift);
	}
	
/*	
	public void setAudioPlayers(){
		bombPlayer = MediaPlayer.create(getApplicationContext(),R.raw.blast);
		invadePlayer = MediaPlayer.create(getApplicationContext(),R.raw.transport);
		virusPlayer = MediaPlayer.create(getApplicationContext(),R.raw.virus);
		laserPlayer = MediaPlayer.create(getApplicationContext(),R.raw.laser);
	}
	*/
	public boolean onKeyDown(int keyCode, KeyEvent event){
		if(keyCode == KeyEvent.KEYCODE_X){
			finish();
			return true;
		}
		
		return false;
	}
}
