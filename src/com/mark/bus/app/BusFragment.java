package com.mark.bus.app;

import com.mark.bus.R;

import android.graphics.drawable.AnimationDrawable;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.v4.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.AnimationSet;
import android.view.animation.TranslateAnimation;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;

public class BusFragment extends Fragment {
	private boolean fire = false;
	private ImageView anim_electric_mechine;
	private ImageView anim_insulation_check;
	private AnimationDrawable animationDrawable;
	private View view;
	private AnimThread animThread;
	private FireThread fireThread;
	private AnimationHandler animationHandler = new AnimationHandler();
	private AnimationSet animationSetInsulation = new AnimationSet(true);
	private AnimationSet animationSetN11 = new AnimationSet(true);
	private AnimationSet animationSetN12 = new AnimationSet(true);
	private AnimationSet animationSetN21 = new AnimationSet(true);
	private AnimationSet animationSetN22 = new AnimationSet(true);
	private AnimationSet animationSetN31 = new AnimationSet(true);
	private AnimationSet animationSetN32 = new AnimationSet(true);
	private AnimationSet animationSetN33 = new AnimationSet(true);
	private AnimationSet animationSetN41 = new AnimationSet(true);
	private AnimationSet animationSetN42 = new AnimationSet(true);
	private AnimationSet animationSetN43 = new AnimationSet(true);
	private AnimationSet animationSetN51 = new AnimationSet(true);
	private AnimationSet animationSetN52 = new AnimationSet(true);
	private AnimationSet animationSetN53 = new AnimationSet(true);
	private AnimationSet animationSetN61 = new AnimationSet(true);
	private AnimationSet animationSetN62 = new AnimationSet(true);
	private AnimationSet animationSetN63 = new AnimationSet(true);
	private AnimationSet animationSetN71 = new AnimationSet(true);
	private AnimationSet animationSetN72 = new AnimationSet(true);
	private AnimationSet animationSetN73 = new AnimationSet(true);
	private AnimationSet animationSetN81 = new AnimationSet(true);
	private AnimationSet animationSetN82 = new AnimationSet(true);
	private AnimationSet animationSetN83 = new AnimationSet(true);

	private AnimationSet animationSetR11 = new AnimationSet(true);
	private AnimationSet animationSetR12 = new AnimationSet(true);
	private AnimationSet animationSetR13 = new AnimationSet(true);
	private AnimationSet animationSetR21 = new AnimationSet(true);
	private AnimationSet animationSetR22 = new AnimationSet(true);
	private AnimationSet animationSetR23 = new AnimationSet(true);
	private AnimationSet animationSetR31 = new AnimationSet(true);
	private AnimationSet animationSetR32 = new AnimationSet(true);
	private AnimationSet animationSetR33 = new AnimationSet(true);
	private AnimationSet animationSetR41 = new AnimationSet(true);
	private AnimationSet animationSetR42 = new AnimationSet(true);
	private AnimationSet animationSetR43 = new AnimationSet(true);
	private AnimationSet animationSetR51 = new AnimationSet(true);
	private AnimationSet animationSetR52 = new AnimationSet(true);
	private AnimationSet animationSetR53 = new AnimationSet(true);
	private AnimationSet animationSetR61 = new AnimationSet(true);
	private AnimationSet animationSetR62 = new AnimationSet(true);
	private AnimationSet animationSetR63 = new AnimationSet(true);
	private AnimationSet animationSetR71 = new AnimationSet(true);
	private AnimationSet animationSetR72 = new AnimationSet(true);
	private AnimationSet animationSetR81 = new AnimationSet(true);
	private AnimationSet animationSetR82 = new AnimationSet(true);

	private AnimationSet animationSetNg = new AnimationSet(true);
	private AnimationSet animationSetNg1 = new AnimationSet(true);
	private AnimationSet animationSetNg2 = new AnimationSet(true);
	private AnimationSet animationSetNg3 = new AnimationSet(true);
	private AnimationSet animationSetNt2 = new AnimationSet(true);
	private AnimationSet animationSetNs2 = new AnimationSet(true);

	private ImageView wa_11;
	private ImageView wa_12;
	private ImageView wa_13;
	private ImageView wa_21;
	private ImageView wa_22;
	private ImageView wa_23;
	private ImageView wa_31;
	private ImageView wa_32;
	private ImageView wa_33;
	private ImageView wa_41;
	private ImageView wa_42;
	private ImageView wa_43;
	private ImageView wa_51;
	private ImageView wa_52;
	private ImageView wa_53;
	private ImageView wa_61;
	private ImageView wa_62;
	private ImageView wa_63;
	private ImageView wa_71;
	private ImageView wa_72;
	private ImageView wa_73;
	private ImageView wa_81;
	private ImageView wa_82;
	private ImageView wa_83;
	private ImageView ga_11;
	private ImageView ga_12;
	private ImageView ga_13;

	private ImageView ga_21;
	private ImageView ga_22;
	private ImageView ga_23;

	private ImageView ga_31;
	private ImageView ga_32;
	private ImageView ga_33;
	private ImageView ga_41;
	private ImageView ga_42;
	private ImageView ga_43;
	private ImageView ga_51;
	private ImageView ga_52;
	private ImageView ga_53;
	private ImageView ga_61;
	private ImageView ga_62;
	private ImageView ga_63;
	private ImageView ga_71;
	private ImageView ga_72;
	private ImageView ga_81;
	private ImageView ga_82;
	private ImageView g1;
	private ImageView g2;
	private ImageView g3;
	private ImageView g4;
	private ImageView g5;
	private ImageView g6;

	private ImageView wa1;

	private ImageView t2;

	private ImageView s2;
	private ImageView sa;

	private class AnimThread extends Thread {

		@Override
		public void run() {
			try {
				Thread.sleep(500);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			// TODO Auto-generated method stub
			animationHandler.sendEmptyMessage(0);

		}
	}

	private class FireThread extends Thread {

		@Override
		public void run() {
			while (true) {
				try {
					Thread.sleep(10000);
					if (fire)
						fire = false;
					else
						fire = true;
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				// TODO Auto-generated method stub
				animationHandler.sendEmptyMessage(1);

			}
		}
	}

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		view = inflater.inflate(R.layout.bus_fragment, container, false);

		anim_electric_mechine = (ImageView) view
				.findViewById(R.id.anim_electric_mechine);
		anim_electric_mechine.setBackgroundResource(R.drawable.motor);
		animationDrawable = (AnimationDrawable) anim_electric_mechine
				.getBackground();

		wa_11 = (ImageView) view.findViewById(R.id.wa_11);
		wa_12 = (ImageView) view.findViewById(R.id.wa_12);
		wa_21 = (ImageView) view.findViewById(R.id.wa_21);
		wa_22 = (ImageView) view.findViewById(R.id.wa_22);
		wa_31 = (ImageView) view.findViewById(R.id.wa_31);
		wa_32 = (ImageView) view.findViewById(R.id.wa_32);
		wa_33 = (ImageView) view.findViewById(R.id.wa_33);
		wa_41 = (ImageView) view.findViewById(R.id.wa_41);
		wa_42 = (ImageView) view.findViewById(R.id.wa_42);
		wa_43 = (ImageView) view.findViewById(R.id.wa_43);
		wa_51 = (ImageView) view.findViewById(R.id.wa_51);
		wa_52 = (ImageView) view.findViewById(R.id.wa_52);
		wa_53 = (ImageView) view.findViewById(R.id.wa_53);
		wa_61 = (ImageView) view.findViewById(R.id.wa_61);
		wa_62 = (ImageView) view.findViewById(R.id.wa_62);
		wa_63 = (ImageView) view.findViewById(R.id.wa_63);
		wa_71 = (ImageView) view.findViewById(R.id.wa_71);
		wa_72 = (ImageView) view.findViewById(R.id.wa_72);
		wa_73 = (ImageView) view.findViewById(R.id.wa_73);
		wa_81 = (ImageView) view.findViewById(R.id.wa_81);
		wa_82 = (ImageView) view.findViewById(R.id.wa_82);
		wa_83 = (ImageView) view.findViewById(R.id.wa_83);

		ga_11 = (ImageView) view.findViewById(R.id.ga_11);
		ga_12 = (ImageView) view.findViewById(R.id.ga_12);
		ga_13 = (ImageView) view.findViewById(R.id.ga_13);

		ga_21 = (ImageView) view.findViewById(R.id.ga_21);
		ga_22 = (ImageView) view.findViewById(R.id.ga_22);
		ga_23 = (ImageView) view.findViewById(R.id.ga_23);

		ga_31 = (ImageView) view.findViewById(R.id.ga_31);
		ga_32 = (ImageView) view.findViewById(R.id.ga_32);
		ga_33 = (ImageView) view.findViewById(R.id.ga_33);
		ga_41 = (ImageView) view.findViewById(R.id.ga_41);
		ga_42 = (ImageView) view.findViewById(R.id.ga_42);
		ga_43 = (ImageView) view.findViewById(R.id.ga_43);
		ga_51 = (ImageView) view.findViewById(R.id.ga_51);
		ga_52 = (ImageView) view.findViewById(R.id.ga_52);
		ga_53 = (ImageView) view.findViewById(R.id.ga_53);
		ga_61 = (ImageView) view.findViewById(R.id.ga_61);
		ga_62 = (ImageView) view.findViewById(R.id.ga_62);
		ga_63 = (ImageView) view.findViewById(R.id.ga_63);
		ga_71 = (ImageView) view.findViewById(R.id.ga_71);
		ga_72 = (ImageView) view.findViewById(R.id.ga_72);
		ga_81 = (ImageView) view.findViewById(R.id.ga_81);
		ga_82 = (ImageView) view.findViewById(R.id.ga_82);

		g1 = (ImageView) view.findViewById(R.id.ga1);
		g2 = (ImageView) view.findViewById(R.id.ga2);
		g3 = (ImageView) view.findViewById(R.id.ga3);
		g4 = (ImageView) view.findViewById(R.id.ga4);
		g5 = (ImageView) view.findViewById(R.id.ga5);
		g6 = (ImageView) view.findViewById(R.id.ga6);

		wa1 = (ImageView) view.findViewById(R.id.wa1);

		t2 = (ImageView) view.findViewById(R.id.t2);

		s2 = (ImageView) view.findViewById(R.id.s2);
		sa = (ImageView) view.findViewById(R.id.sa);

		anim_insulation_check = (ImageView) view
				.findViewById(R.id.anim_insulation_check);
		animThread = new AnimThread();
		animThread.start();
		FireThread fireThread = new FireThread();
		fireThread.start();
		return view;

	}

	final class AnimationHandler extends Handler {
		@Override
		public void handleMessage(Message msg) {
			if (msg.what == 0) {
				if (animationDrawable.isRunning()) {
					animationDrawable.stop();
					animationDrawable.start();
				} else {
					animationDrawable.start();
				}
				wa_11.setVisibility(View.GONE);
				wa_12.setVisibility(View.GONE);
				wa_21.setVisibility(View.GONE);
				wa_22.setVisibility(View.GONE);
				wa_31.setVisibility(View.GONE);
				wa_32.setVisibility(View.GONE);
				wa_33.setVisibility(View.GONE);
				wa_41.setVisibility(View.GONE);
				wa_42.setVisibility(View.GONE);
				wa_43.setVisibility(View.GONE);
				wa_51.setVisibility(View.GONE);
				wa_52.setVisibility(View.GONE);
				wa_53.setVisibility(View.GONE);
				wa_61.setVisibility(View.GONE);
				wa_62.setVisibility(View.GONE);
				wa_63.setVisibility(View.GONE);
				wa_71.setVisibility(View.GONE);
				wa_72.setVisibility(View.GONE);
				wa_73.setVisibility(View.GONE);
				wa_81.setVisibility(View.GONE);
				wa_82.setVisibility(View.GONE);
				wa_83.setVisibility(View.GONE);

				ga_11.setVisibility(View.GONE);
				ga_12.setVisibility(View.GONE);
				ga_13.setVisibility(View.GONE);

				ga_21.setVisibility(View.GONE);
				ga_22.setVisibility(View.GONE);
				ga_23.setVisibility(View.GONE);

				ga_31.setVisibility(View.GONE);
				ga_32.setVisibility(View.GONE);
				ga_33.setVisibility(View.GONE);
				ga_41.setVisibility(View.GONE);
				ga_42.setVisibility(View.GONE);
				ga_43.setVisibility(View.GONE);
				ga_51.setVisibility(View.GONE);
				ga_52.setVisibility(View.GONE);
				ga_53.setVisibility(View.GONE);
				ga_61.setVisibility(View.GONE);
				ga_62.setVisibility(View.GONE);
				ga_63.setVisibility(View.GONE);
				ga_71.setVisibility(View.GONE);
				ga_72.setVisibility(View.GONE);
				ga_81.setVisibility(View.GONE);
				ga_82.setVisibility(View.GONE);
				t2.setVisibility(View.GONE);
				s2.setVisibility(View.GONE);
				initializeAnimation();
				// startInsulationAnimation();
				// startN1Animation();
				startR1Animation();

				g1.startAnimation(animationSetNg);
				g2.startAnimation(animationSetNg);
				g3.startAnimation(animationSetNg);
				g4.startAnimation(animationSetNg1);
				g5.startAnimation(animationSetNg2);
				g6.startAnimation(animationSetNg3);

				// wa1.startAnimation(animationSetNg);

			} else {
				if (fire) {
				}
				// startNs2Animation();
				else {
				}
				// stoptNs2Animation();
			}
		}
	}

	public void initializeAnimation() {
		AlphaAnimation alphaAnimation1 = new AlphaAnimation(0.0f, 1.0f);
		alphaAnimation1.setDuration(1000);
		alphaAnimation1.setRepeatCount(Integer.MAX_VALUE);
		alphaAnimation1.setRepeatMode(Animation.RESTART);
		animationSetInsulation.addAnimation(alphaAnimation1);

		AlphaAnimation alphaAnimationN11 = new AlphaAnimation(0.0f, 1.0f);
		alphaAnimationN11
				.setAnimationListener(new Animation.AnimationListener() {
					@Override
					public void onAnimationStart(Animation arg0) {
					}

					@Override
					public void onAnimationRepeat(Animation arg0) {
					}

					@Override
					public void onAnimationEnd(Animation arg0) {
						startN2Animation();
					}
				});
		alphaAnimationN11.setDuration(200);
		animationSetN11.addAnimation(alphaAnimationN11);

		AlphaAnimation alphaAnimationN12 = new AlphaAnimation(0.0f, 1.0f);
		alphaAnimationN12.setDuration(200);
		animationSetN12.addAnimation(alphaAnimationN12);

		AlphaAnimation alphaAnimationN21 = new AlphaAnimation(0.0f, 1.0f);
		alphaAnimationN21
				.setAnimationListener(new Animation.AnimationListener() {
					@Override
					public void onAnimationStart(Animation arg0) {
					}

					@Override
					public void onAnimationRepeat(Animation arg0) {
					}

					@Override
					public void onAnimationEnd(Animation arg0) {
						startN3Animation();
					}
				});
		alphaAnimationN21.setDuration(200);
		animationSetN21.addAnimation(alphaAnimationN21);

		AlphaAnimation alphaAnimationN22 = new AlphaAnimation(0.0f, 1.0f);
		alphaAnimationN22.setDuration(200);
		animationSetN22.addAnimation(alphaAnimationN22);

		AlphaAnimation alphaAnimationN31 = new AlphaAnimation(0.0f, 1.0f);
		alphaAnimationN31
				.setAnimationListener(new Animation.AnimationListener() {
					@Override
					public void onAnimationStart(Animation arg0) {
					}

					@Override
					public void onAnimationRepeat(Animation arg0) {
					}

					@Override
					public void onAnimationEnd(Animation arg0) {
						startN4Animation();
					}
				});
		alphaAnimationN31.setDuration(200);
		animationSetN31.addAnimation(alphaAnimationN31);

		AlphaAnimation alphaAnimationN32 = new AlphaAnimation(0.0f, 1.0f);
		alphaAnimationN32.setDuration(200);
		animationSetN32.addAnimation(alphaAnimationN32);

		AlphaAnimation alphaAnimationN33 = new AlphaAnimation(0.0f, 1.0f);
		alphaAnimationN33.setDuration(200);
		animationSetN33.addAnimation(alphaAnimationN33);

		AlphaAnimation alphaAnimationN41 = new AlphaAnimation(0.0f, 1.0f);
		alphaAnimationN41
				.setAnimationListener(new Animation.AnimationListener() {
					@Override
					public void onAnimationStart(Animation arg0) {
					}

					@Override
					public void onAnimationRepeat(Animation arg0) {
					}

					@Override
					public void onAnimationEnd(Animation arg0) {
						startN5Animation();
					}
				});
		alphaAnimationN41.setDuration(200);
		animationSetN41.addAnimation(alphaAnimationN41);

		AlphaAnimation alphaAnimationN42 = new AlphaAnimation(0.0f, 1.0f);
		alphaAnimationN42.setDuration(200);
		animationSetN42.addAnimation(alphaAnimationN42);

		AlphaAnimation alphaAnimationN43 = new AlphaAnimation(0.0f, 1.0f);
		alphaAnimationN43.setDuration(200);
		animationSetN43.addAnimation(alphaAnimationN43);
		AlphaAnimation alphaAnimationN51 = new AlphaAnimation(0.0f, 1.0f);
		alphaAnimationN51
				.setAnimationListener(new Animation.AnimationListener() {
					@Override
					public void onAnimationStart(Animation arg0) {
					}

					@Override
					public void onAnimationRepeat(Animation arg0) {
					}

					@Override
					public void onAnimationEnd(Animation arg0) {
						startN6Animation();
					}
				});
		alphaAnimationN51.setDuration(200);
		animationSetN51.addAnimation(alphaAnimationN51);

		AlphaAnimation alphaAnimationN52 = new AlphaAnimation(0.0f, 1.0f);
		alphaAnimationN52.setDuration(200);
		animationSetN52.addAnimation(alphaAnimationN52);

		AlphaAnimation alphaAnimationN53 = new AlphaAnimation(0.0f, 1.0f);
		alphaAnimationN53.setDuration(200);
		animationSetN53.addAnimation(alphaAnimationN53);

		AlphaAnimation alphaAnimationN61 = new AlphaAnimation(0.0f, 1.0f);
		alphaAnimationN61
				.setAnimationListener(new Animation.AnimationListener() {
					@Override
					public void onAnimationStart(Animation arg0) {
					}

					@Override
					public void onAnimationRepeat(Animation arg0) {
					}

					@Override
					public void onAnimationEnd(Animation arg0) {
						startN7Animation();
					}
				});
		alphaAnimationN61.setDuration(200);
		animationSetN61.addAnimation(alphaAnimationN61);

		AlphaAnimation alphaAnimationN62 = new AlphaAnimation(0.0f, 1.0f);
		alphaAnimationN62.setDuration(200);
		animationSetN62.addAnimation(alphaAnimationN62);

		AlphaAnimation alphaAnimationN63 = new AlphaAnimation(0.0f, 1.0f);

		alphaAnimationN63.setDuration(200);
		animationSetN63.addAnimation(alphaAnimationN63);
		AlphaAnimation alphaAnimationN71 = new AlphaAnimation(0.0f, 1.0f);
		alphaAnimationN71
				.setAnimationListener(new Animation.AnimationListener() {
					@Override
					public void onAnimationStart(Animation arg0) {
					}

					@Override
					public void onAnimationRepeat(Animation arg0) {
					}

					@Override
					public void onAnimationEnd(Animation arg0) {
						startN8Animation();
					}
				});
		alphaAnimationN71.setDuration(200);
		animationSetN71.addAnimation(alphaAnimationN71);

		AlphaAnimation alphaAnimationN72 = new AlphaAnimation(0.0f, 1.0f);
		alphaAnimationN72.setDuration(200);
		animationSetN72.addAnimation(alphaAnimationN72);

		AlphaAnimation alphaAnimationN73 = new AlphaAnimation(0.0f, 1.0f);
		alphaAnimationN73.setDuration(200);
		animationSetN73.addAnimation(alphaAnimationN73);

		AlphaAnimation alphaAnimationN81 = new AlphaAnimation(0.0f, 1.0f);
		alphaAnimationN81
				.setAnimationListener(new Animation.AnimationListener() {
					@Override
					public void onAnimationStart(Animation arg0) {
					}

					@Override
					public void onAnimationRepeat(Animation arg0) {
					}

					@Override
					public void onAnimationEnd(Animation arg0) {
						startNt2Animation();
					}
				});
		alphaAnimationN81.setDuration(200);
		animationSetN81.addAnimation(alphaAnimationN81);

		AlphaAnimation alphaAnimationN82 = new AlphaAnimation(0.0f, 1.0f);
		alphaAnimationN82.setDuration(200);
		animationSetN82.addAnimation(alphaAnimationN82);

		AlphaAnimation alphaAnimationN83 = new AlphaAnimation(0.0f, 1.0f);
		alphaAnimationN83.setDuration(200);
		animationSetN83.addAnimation(alphaAnimationN83);

		AlphaAnimation alphaAnimationR11 = new AlphaAnimation(0.0f, 1.0f);
		alphaAnimationR11
				.setAnimationListener(new Animation.AnimationListener() {
					@Override
					public void onAnimationStart(Animation arg0) {
					}

					@Override
					public void onAnimationRepeat(Animation arg0) {
					}

					@Override
					public void onAnimationEnd(Animation arg0) {
						startR2Animation();
					}
				});
		alphaAnimationR11.setDuration(200);
		animationSetR11.addAnimation(alphaAnimationR11);

		AlphaAnimation alphaAnimationR12 = new AlphaAnimation(0.0f, 1.0f);
		alphaAnimationR12.setDuration(200);
		animationSetR12.addAnimation(alphaAnimationR12);

		AlphaAnimation alphaAnimationR13 = new AlphaAnimation(0.0f, 1.0f);
		alphaAnimationR12.setDuration(200);
		animationSetR13.addAnimation(alphaAnimationR13);

		AlphaAnimation alphaAnimationR21 = new AlphaAnimation(0.0f, 1.0f);

		alphaAnimationR21
				.setAnimationListener(new Animation.AnimationListener() {
					@Override
					public void onAnimationStart(Animation arg0) {
					}

					@Override
					public void onAnimationRepeat(Animation arg0) {
					}

					@Override
					public void onAnimationEnd(Animation arg0) {
						startR3Animation();
					}
				});
		alphaAnimationR21.setDuration(200);
		animationSetR21.addAnimation(alphaAnimationR21);

		AlphaAnimation alphaAnimationR22 = new AlphaAnimation(0.0f, 1.0f);
		alphaAnimationR22.setDuration(200);
		animationSetR22.addAnimation(alphaAnimationR22);

		AlphaAnimation alphaAnimationR23 = new AlphaAnimation(0.0f, 1.0f);
		alphaAnimationR23.setDuration(200);
		animationSetR23.addAnimation(alphaAnimationR23);

		AlphaAnimation alphaAnimationR31 = new AlphaAnimation(0.0f, 1.0f);
		alphaAnimationR31
				.setAnimationListener(new Animation.AnimationListener() {
					@Override
					public void onAnimationStart(Animation arg0) {
					}

					@Override
					public void onAnimationRepeat(Animation arg0) {
					}

					@Override
					public void onAnimationEnd(Animation arg0) {
						startR4Animation();
					}
				});
		alphaAnimationR31.setDuration(200);
		animationSetR31.addAnimation(alphaAnimationR31);

		AlphaAnimation alphaAnimationR32 = new AlphaAnimation(0.0f, 1.0f);
		alphaAnimationR32.setDuration(200);
		animationSetR32.addAnimation(alphaAnimationR32);

		AlphaAnimation alphaAnimationR33 = new AlphaAnimation(0.0f, 1.0f);
		alphaAnimationR33.setDuration(200);
		animationSetR33.addAnimation(alphaAnimationR33);

		AlphaAnimation alphaAnimationR41 = new AlphaAnimation(0.0f, 1.0f);
		alphaAnimationR41
				.setAnimationListener(new Animation.AnimationListener() {
					@Override
					public void onAnimationStart(Animation arg0) {
					}

					@Override
					public void onAnimationRepeat(Animation arg0) {
					}

					@Override
					public void onAnimationEnd(Animation arg0) {
						startR5Animation();
					}
				});
		alphaAnimationR41.setDuration(200);
		animationSetR41.addAnimation(alphaAnimationR41);

		AlphaAnimation alphaAnimationR42 = new AlphaAnimation(0.0f, 1.0f);
		alphaAnimationR42.setDuration(200);
		animationSetR42.addAnimation(alphaAnimationR42);

		AlphaAnimation alphaAnimationR43 = new AlphaAnimation(0.0f, 1.0f);
		alphaAnimationR43.setDuration(200);
		animationSetR43.addAnimation(alphaAnimationR43);
		AlphaAnimation alphaAnimationR51 = new AlphaAnimation(0.0f, 1.0f);
		alphaAnimationR51
				.setAnimationListener(new Animation.AnimationListener() {
					@Override
					public void onAnimationStart(Animation arg0) {
					}

					@Override
					public void onAnimationRepeat(Animation arg0) {
					}

					@Override
					public void onAnimationEnd(Animation arg0) {
						startR6Animation();
					}
				});
		alphaAnimationR51.setDuration(200);
		animationSetR51.addAnimation(alphaAnimationR51);

		AlphaAnimation alphaAnimationR52 = new AlphaAnimation(0.0f, 1.0f);
		alphaAnimationR52.setDuration(200);
		animationSetR52.addAnimation(alphaAnimationR52);

		AlphaAnimation alphaAnimationR53 = new AlphaAnimation(0.0f, 1.0f);
		alphaAnimationR53.setDuration(200);
		animationSetR53.addAnimation(alphaAnimationR53);

		AlphaAnimation alphaAnimationR61 = new AlphaAnimation(0.0f, 1.0f);
		alphaAnimationR61
				.setAnimationListener(new Animation.AnimationListener() {
					@Override
					public void onAnimationStart(Animation arg0) {
					}

					@Override
					public void onAnimationRepeat(Animation arg0) {
					}

					@Override
					public void onAnimationEnd(Animation arg0) {
						startR7Animation();
					}
				});
		alphaAnimationR61.setDuration(200);
		animationSetR61.addAnimation(alphaAnimationR61);

		AlphaAnimation alphaAnimationR62 = new AlphaAnimation(0.0f, 1.0f);
		alphaAnimationR62.setDuration(200);
		animationSetR62.addAnimation(alphaAnimationR62);

		AlphaAnimation alphaAnimationR63 = new AlphaAnimation(0.0f, 1.0f);

		alphaAnimationR63.setDuration(200);
		animationSetR63.addAnimation(alphaAnimationR63);
		AlphaAnimation alphaAnimationR71 = new AlphaAnimation(0.0f, 1.0f);
		alphaAnimationR71
				.setAnimationListener(new Animation.AnimationListener() {
					@Override
					public void onAnimationStart(Animation arg0) {
					}

					@Override
					public void onAnimationRepeat(Animation arg0) {
					}

					@Override
					public void onAnimationEnd(Animation arg0) {
						startR8Animation();
					}
				});
		alphaAnimationR71.setDuration(200);
		animationSetR71.addAnimation(alphaAnimationR71);

		AlphaAnimation alphaAnimationR72 = new AlphaAnimation(0.0f, 1.0f);
		alphaAnimationR72.setDuration(200);
		animationSetR72.addAnimation(alphaAnimationR72);

		AlphaAnimation alphaAnimationR81 = new AlphaAnimation(0.0f, 1.0f);
		alphaAnimationR81
				.setAnimationListener(new Animation.AnimationListener() {
					@Override
					public void onAnimationStart(Animation arg0) {
					}

					@Override
					public void onAnimationRepeat(Animation arg0) {
					}

					@Override
					public void onAnimationEnd(Animation arg0) {
						startR2Animation();
					}
				});
		alphaAnimationR81.setDuration(200);
		animationSetR81.addAnimation(alphaAnimationR81);

		AlphaAnimation alphaAnimationR82 = new AlphaAnimation(0.0f, 1.0f);
		alphaAnimationR82.setDuration(200);
		animationSetR82.addAnimation(alphaAnimationR82);

		AlphaAnimation alphaAnimationNt2 = new AlphaAnimation(0.0f, 1.0f);
		alphaAnimationNt2.setDuration(200);
		alphaAnimationNt2
				.setAnimationListener(new Animation.AnimationListener() {
					@Override
					public void onAnimationStart(Animation arg0) {
					}

					@Override
					public void onAnimationRepeat(Animation arg0) {
					}

					@Override
					public void onAnimationEnd(Animation arg0) {
						startN1Animation();
					}
				});
		animationSetNt2.addAnimation(alphaAnimationNt2);

		AlphaAnimation alphaAnimationNg = new AlphaAnimation(1.0f, 0f);
		TranslateAnimation translateAnimationNg = new TranslateAnimation(
				Animation.RELATIVE_TO_SELF, 0f, // X轴的开始位置
				Animation.RELATIVE_TO_SELF, 0.6f, // X轴的结束位置
				Animation.RELATIVE_TO_SELF, 0f, // Y轴的开始位置
				Animation.RELATIVE_TO_SELF, 0f); // Y轴的结束位置
		alphaAnimationNg.setDuration(1000);
		translateAnimationNg.setDuration(1000);
		alphaAnimationNg.setRepeatCount(Integer.MAX_VALUE);
		alphaAnimationNg.setRepeatMode(Animation.RESTART);
		translateAnimationNg.setRepeatCount(Integer.MAX_VALUE);
		translateAnimationNg.setRepeatMode(Animation.RESTART);
		animationSetNg.addAnimation(alphaAnimationNg);
		animationSetNg.addAnimation(translateAnimationNg);

		AlphaAnimation alphaAnimationNg1 = new AlphaAnimation(1.0f, 0f);
		TranslateAnimation translateAnimationNg1 = new TranslateAnimation(
				Animation.RELATIVE_TO_SELF, 0f, // X轴的开始位置
				Animation.RELATIVE_TO_SELF, -1.5f, // X轴的结束位置
				Animation.RELATIVE_TO_SELF, 0f, // Y轴的开始位置
				Animation.RELATIVE_TO_SELF, 0f); // Y轴的结束位置
		alphaAnimationNg1.setDuration(1000);
		translateAnimationNg1.setDuration(1000);
		alphaAnimationNg1.setRepeatCount(Integer.MAX_VALUE);
		alphaAnimationNg1.setRepeatMode(Animation.RESTART);
		translateAnimationNg1.setRepeatCount(Integer.MAX_VALUE);
		translateAnimationNg1.setRepeatMode(Animation.RESTART);
		animationSetNg1.addAnimation(alphaAnimationNg1);
		animationSetNg1.addAnimation(translateAnimationNg1);

		AlphaAnimation alphaAnimationNg2 = new AlphaAnimation(1.0f, 0f);
		TranslateAnimation translateAnimationNg2 = new TranslateAnimation(
				Animation.RELATIVE_TO_SELF, 0f, // X轴的开始位置
				Animation.RELATIVE_TO_SELF, 0f, // X轴的结束位置
				Animation.RELATIVE_TO_SELF, 0f, // Y轴的开始位置
				Animation.RELATIVE_TO_SELF, 0.6f); // Y轴的结束位置
		alphaAnimationNg2.setDuration(1000);
		translateAnimationNg2.setDuration(1000);
		alphaAnimationNg2.setRepeatCount(Integer.MAX_VALUE);
		alphaAnimationNg2.setRepeatMode(Animation.RESTART);
		translateAnimationNg2.setRepeatCount(Integer.MAX_VALUE);
		translateAnimationNg2.setRepeatMode(Animation.RESTART);
		animationSetNg2.addAnimation(alphaAnimationNg2);
		animationSetNg2.addAnimation(translateAnimationNg2);

		AlphaAnimation alphaAnimationNg3 = new AlphaAnimation(1.0f, 0f);
		TranslateAnimation translateAnimationNg3 = new TranslateAnimation(
				Animation.RELATIVE_TO_SELF, 0f, // X轴的开始位置
				Animation.RELATIVE_TO_SELF, 0f, // X轴的结束位置
				Animation.RELATIVE_TO_SELF, 0f, // Y轴的开始位置
				Animation.RELATIVE_TO_SELF, -2.0f); // Y轴的结束位置
		alphaAnimationNg3.setDuration(1000);
		translateAnimationNg3.setDuration(1000);
		alphaAnimationNg3.setRepeatCount(Integer.MAX_VALUE);
		alphaAnimationNg3.setRepeatMode(Animation.RESTART);
		translateAnimationNg3.setRepeatCount(Integer.MAX_VALUE);
		translateAnimationNg3.setRepeatMode(Animation.RESTART);
		animationSetNg3.addAnimation(alphaAnimationNg3);
		animationSetNg3.addAnimation(translateAnimationNg3);

		AlphaAnimation alphaAnimationNs2 = new AlphaAnimation(1.0f, 0f);
		TranslateAnimation translateAnimationNs2 = new TranslateAnimation(
				Animation.RELATIVE_TO_SELF, 0f, // X轴的开始位置
				Animation.RELATIVE_TO_SELF, 0f, // X轴的结束位置
				Animation.RELATIVE_TO_SELF, 0f, // Y轴的开始位置
				Animation.RELATIVE_TO_SELF, -0.1f); // Y轴的结束位置
		alphaAnimationNs2.setDuration(1000);
		translateAnimationNs2.setDuration(1000);
		alphaAnimationNs2.setRepeatCount(Integer.MAX_VALUE);
		alphaAnimationNs2.setRepeatMode(Animation.RESTART);
		translateAnimationNs2.setRepeatCount(Integer.MAX_VALUE);
		translateAnimationNs2.setRepeatMode(Animation.RESTART);
		animationSetNs2.addAnimation(alphaAnimationNs2);
		animationSetNs2.addAnimation(translateAnimationNs2);

	}

	public void startInsulationAnimation() {
		anim_insulation_check.startAnimation(animationSetInsulation);
	}

	public void startN1Animation() {

		wa_11.startAnimation(animationSetN11);
		wa_12.startAnimation(animationSetN12);
	}

	public void startN2Animation() {

		wa_21.startAnimation(animationSetN21);
		wa_22.startAnimation(animationSetN22);
	}

	public void startN3Animation() {

		wa_31.startAnimation(animationSetN31);
		wa_32.startAnimation(animationSetN32);
		wa_33.startAnimation(animationSetN33);
	}

	public void startN4Animation() {

		wa_41.startAnimation(animationSetN41);
		wa_42.startAnimation(animationSetN42);
		wa_43.startAnimation(animationSetN43);
	}

	public void startN5Animation() {

		wa_51.startAnimation(animationSetN51);
		wa_52.startAnimation(animationSetN52);
		wa_53.startAnimation(animationSetN53);
	}

	public void startN6Animation() {

		wa_61.startAnimation(animationSetN61);
		wa_62.startAnimation(animationSetN62);
		wa_63.startAnimation(animationSetN63);
	}

	public void startN7Animation() {

		wa_71.startAnimation(animationSetN71);
		wa_72.startAnimation(animationSetN72);
		wa_73.startAnimation(animationSetN73);
	}

	public void startN8Animation() {

		wa_81.startAnimation(animationSetN81);
		wa_82.startAnimation(animationSetN82);
		wa_83.startAnimation(animationSetN83);
	}

	public void startR1Animation() {

		ga_11.startAnimation(animationSetR11);
		ga_12.startAnimation(animationSetR12);
		ga_13.startAnimation(animationSetR13);

	}

	public void startR2Animation() {

		ga_21.startAnimation(animationSetR21);
		ga_22.startAnimation(animationSetR22);
		ga_23.startAnimation(animationSetR23);

	}

	public void startR3Animation() {

		ga_31.startAnimation(animationSetR31);
		ga_32.startAnimation(animationSetR32);
		ga_33.startAnimation(animationSetR33);
	}

	public void startR4Animation() {

		ga_41.startAnimation(animationSetR41);
		ga_42.startAnimation(animationSetR42);
		ga_43.startAnimation(animationSetR43);
	}

	public void startR5Animation() {

		ga_51.startAnimation(animationSetR51);
		ga_52.startAnimation(animationSetR52);
		ga_53.startAnimation(animationSetR53);
	}

	public void startR6Animation() {

		ga_61.startAnimation(animationSetR61);
		ga_62.startAnimation(animationSetR62);
		ga_63.startAnimation(animationSetR63);
	}

	public void startR7Animation() {

		ga_71.startAnimation(animationSetR71);
		ga_72.startAnimation(animationSetR72);
	}

	public void startR8Animation() {

		ga_81.startAnimation(animationSetR81);
		ga_82.startAnimation(animationSetR82);
	}

	public void startNt2Animation() {
		t2.startAnimation(animationSetNt2);
	}

	public void startNs2Animation() {
		s2.startAnimation(animationSetNs2);
		sa.startAnimation(animationSetInsulation);
	}

	public void stoptNs2Animation() {
		s2.clearAnimation();
		sa.clearAnimation();
		sa.setVisibility(View.GONE);
	}

}
