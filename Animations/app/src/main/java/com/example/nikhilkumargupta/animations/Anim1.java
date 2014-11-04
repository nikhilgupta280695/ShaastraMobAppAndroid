package com.example.nikhilkumargupta.animations;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.Typeface;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;


public class Anim1 extends Activity implements Animation.AnimationListener {

	Animation fade_in, fade_in1, zoom_in, zoom_out, fade_out;
	ImageView img;
	TextView txtvw;
	RelativeLayout view;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_anim1);
		/*SoundPool sp=new SoundPool(5, AudioManager.STREAM_MUSIC,0);
		int soundId = sp.load(this, R.raw.tinkle_sound, 1);
		sp.play(soundId,1,1,0,0,1);*/
		MediaPlayer mp = MediaPlayer.create(this, R.raw.tinkle_sound);
		mp.start();
		view = (RelativeLayout) findViewById(R.id.view);
		txtvw = (TextView) findViewById(R.id.textView);
		Typeface type = Typeface.createFromAsset(getAssets(), "villa.ttf");
		txtvw.setTypeface(type);
		txtvw.setVisibility(View.INVISIBLE);
		img = (ImageView) findViewById(R.id.img);
		fade_in = AnimationUtils.loadAnimation(getApplicationContext(),
				R.anim.fade_in);
		fade_in1 = AnimationUtils.loadAnimation(getApplicationContext(),
				R.anim.fade_in);
		zoom_in = AnimationUtils.loadAnimation(getApplicationContext(),
				R.anim.fade_in);
		fade_out = AnimationUtils.loadAnimation(getApplicationContext(),
				R.anim.fade_out);
		zoom_out = AnimationUtils.loadAnimation(getApplicationContext(),
				R.anim.zoom_out);
		fade_in.setAnimationListener(this);
		fade_in1.setAnimationListener(this);
		zoom_in.setAnimationListener(this);
		fade_out.setAnimationListener(this);
		zoom_out.setAnimationListener(this);
		img.startAnimation(fade_in);

	}

	@Override
	public void onAnimationStart(Animation animation) {

	}

	@Override
	public void onAnimationEnd(Animation animation) {
		if (animation == fade_in) {
			img.startAnimation(zoom_out);
		} else if (animation == zoom_out) {
//			Toast.makeText(this, "next", Toast.LENGTH_SHORT).show();
			txtvw.startAnimation(zoom_in);
			view.startAnimation(fade_in1);
			view.setBackgroundColor(Color.rgb(102, 178, 255));
		} else if (animation == zoom_in) {
			Intent i=new Intent(this,Anim2.class);
			startActivity(i);
		}
	}

	@Override
	public void onAnimationRepeat(Animation animation) {

	}
}
