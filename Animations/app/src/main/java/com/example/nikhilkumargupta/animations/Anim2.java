package com.example.nikhilkumargupta.animations;

import android.app.Activity;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.LinearLayout;

/**
 * Created by NIKHIL KUMAR GUPTA on 27-10-2014.
 */
public class Anim2 extends Activity implements Animation.AnimationListener {
LinearLayout view2;
	Animation fade_in2;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);

		new LongDuration().execute("");

		view2= (LinearLayout) findViewById(R.id.view2);
		fade_in2 = AnimationUtils.loadAnimation(getApplicationContext(),
				R.anim.fade_in);
		fade_in2.setAnimationListener(this);
		view2.startAnimation(fade_in2);
	}

	@Override
	public void onAnimationStart(Animation animation) {

	}

	@Override
	public void onAnimationEnd(Animation animation) {

	}

	@Override
	public void onAnimationRepeat(Animation animation) {

	}

	@Override
	protected void onResume() {
		super.onResume();

	}
	private class LongDuration extends AsyncTask<String, Void, String> {
		@Override
		protected String doInBackground(String... params) {
			for(int i=0;i<5;i++) {
				try {
					Thread.sleep(1000);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

			}

			return null;
		}

		@Override
		protected void onPostExecute(String result) {setContentView(R.layout.activity2);
		}

		@Override
		protected void onPreExecute() {
		}

		@Override
		protected void onProgressUpdate(Void... values) {
		}
	}
}
