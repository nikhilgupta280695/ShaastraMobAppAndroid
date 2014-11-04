package com.google.samples.apps.iosched.ui;

import android.app.Activity;
import android.content.Intent;
import android.media.SoundPool;
import android.os.Bundle;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.Toast;

import com.google.samples.apps.iosched.R;


public class WelcomeAnimation extends Activity implements Animation.AnimationListener {

	Animation fade_in,zoom_out;
	ImageView img;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.welcome_anim);
		SoundPool sp;
		img= (ImageView) findViewById(R.id.img);
		fade_in = AnimationUtils.loadAnimation(getApplicationContext(),
				R.anim.fade_in);
		zoom_out = AnimationUtils.loadAnimation(getApplicationContext(),
				R.anim.zoom_out);
		fade_in.setAnimationListener(this);
		zoom_out.setAnimationListener(this);
img.startAnimation(fade_in);

	}

	@Override
	public void onAnimationStart(Animation animation) {

	}

	@Override
	public void onAnimationEnd(Animation animation) {
	if(animation==fade_in){
		img.startAnimation(zoom_out);
	}
		else if(animation==zoom_out){
		Intent intent = new Intent(WelcomeAnimation.this, BrowseSessionsActivity.class);
		startActivity(intent);
		finish();

	}
	}

	@Override
	public void onAnimationRepeat(Animation animation) {

	}
}
