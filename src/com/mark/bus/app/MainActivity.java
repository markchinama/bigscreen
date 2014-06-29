package com.mark.bus.app;

import com.mark.bus.R;
import com.mark.bus.data.DataHandler;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Intent;
import android.graphics.drawable.AnimationDrawable;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentTransaction;

import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnTouchListener;
import android.view.Window;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.AnimationSet;
import android.view.animation.TranslateAnimation;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.SeekBar;
import android.widget.SeekBar.OnSeekBarChangeListener;
import android.widget.TextView;

public class MainActivity extends FragmentActivity {
	// for demo
	private int fakeCount = 0;
	private UpdataUIHandler updataUIHandler = new UpdataUIHandler();
	private updataUIThread updateUIThread = new updataUIThread();

	// datas
	DataHandler dh = new DataHandler();
	private boolean acon = false;
	private BusApplication ba = null;
	// animations
	private ImageView av1;
	private ImageView av2;
	private ImageView av3;
	private ImageView av4;
	private ImageView av5;
	private ImageView av6;
	private ImageView buslightoff;
	private ImageView midopenlighton, midopenlightoff, frontopenlighton,
			frontopenlightoff, frontlighton, frontheadlighton, rearlighton,
			cabinetopen;

	// topbuttons
	private static int currentTopButtonId = 4;
	private ImageButton homeButton;
	private ImageButton infoButton;
	private ImageButton controlButton;
	private ImageButton cameralButton;
	private ImageButton expertButton;
	private ImageButton model_btn;
	private ImageButton[] topButtons = new ImageButton[5];

	private int[] unpressedBackGround = { R.drawable.button_bus_info_pressed,
			R.drawable.button_bus_control_pressed,
			R.drawable.button_bus_cameral_pressed,
			R.drawable.button_bus_expert_pressed };
	private int[] pressedBackGround = { R.drawable.button_bus_info,
			R.drawable.button_bus_control, R.drawable.button_bus_cameral,
			R.drawable.button_bus_expert };

	// fragments
	BusFragment busFragment = new BusFragment();
	ButtonsFragment buttonsFragment = new ButtonsFragment();
	BusInfoFragment busInfoFragment = new BusInfoFragment();

	// airbuttons
	private ImageButton acUpButton;
	private ImageButton acDownButton;
	private ImageButton powerUpButton;
	private ImageButton powerDownButton;
	private ImageButton listHomeButton;
	private ImageButton acShowDownButton;
	private ImageButton acModelButton;
	private int[] airOnTouchBg = { R.drawable.home_click, R.drawable.air_on,
			R.drawable.ac_up_click, R.drawable.ac_down_click,
			R.drawable.model_click, R.drawable.power_up_click,
			R.drawable.power_down_click

	};

	// air text
	private TextView ac_text;
	private TextView power_text;
	private SeekBar sb;

	private TextView status_battery_panel_number;
	private TextView status_energy_panel_number;
	private TextView status_distance_panel_number;

	// handlers
	private ModelHandler modelHandler = new ModelHandler();
	private AnimationHandler animHandler = new AnimationHandler();

	// model
	int[] bgSource = { R.drawable.eco, R.drawable.normal, R.drawable.power,
			R.drawable.snow };

	private LinearLayout airBg;

	private ImageView anim_roadline;
	private ImageView anim_front_wheel;
	private ImageView anim_rear_wheel;
	private AnimationDrawable animationDrawable;
	private AnimationDrawable animationDrawable1;
	private AnimationDrawable animationDrawable2;

	private AnimationSet animationSet1 = new AnimationSet(true);;
	private AnimationSet animationSet2 = new AnimationSet(true);;
	private AnimationSet animationSet3 = new AnimationSet(true);;
	private AnimationSet animationSet4 = new AnimationSet(true);;
	private AnimationSet animationSet5 = new AnimationSet(true);;
	private AnimationSet animationSet6 = new AnimationSet(true);;
	private AnimationSet animationSet7 = new AnimationSet(true);;
	private AnimationSet animationSet8 = new AnimationSet(true);;
	private AnimationSet animationSet9 = new AnimationSet(true);;
	private AnimationSet animationSet10 = new AnimationSet(true);;
	private AnimationSet animationSet11 = new AnimationSet(true);;
	private AnimationSet animationSet12 = new AnimationSet(true);;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		getWindow().requestFeature(Window.FEATURE_NO_TITLE);
		setContentView(R.layout.main_activity);
		bindAllUI();
		buslightoff = (ImageView) findViewById(R.id.buslightoff);

		av1 = (ImageView) findViewById(R.id.anim_air1);
		av2 = (ImageView) findViewById(R.id.anim_air2);
		av3 = (ImageView) findViewById(R.id.anim_air3);
		av4 = (ImageView) findViewById(R.id.anim_air4);
		av5 = (ImageView) findViewById(R.id.anim_air5);
		av6 = (ImageView) findViewById(R.id.anim_air6);

		midopenlighton = (ImageView) findViewById(R.id.midopenlighton);
		midopenlightoff = (ImageView) findViewById(R.id.midopenlightoff);
		frontopenlighton = (ImageView) findViewById(R.id.frontopenlighton);
		frontopenlightoff = (ImageView) findViewById(R.id.frontopenlightoff);
		frontlighton = (ImageView) findViewById(R.id.frontlighton);
		frontheadlighton = (ImageView) findViewById(R.id.frontheadlighton);
		rearlighton = (ImageView) findViewById(R.id.rearlighton);
		cabinetopen = (ImageView) findViewById(R.id.cabinetopen);

		anim_roadline = (ImageView) findViewById(R.id.anim_roadline);
		anim_roadline.setBackgroundResource(R.drawable.roadlineanim);
		animationDrawable = (AnimationDrawable) anim_roadline.getBackground();

		anim_front_wheel = (ImageView) findViewById(R.id.anim_front_wheel);
		anim_front_wheel.setBackgroundResource(R.drawable.frontwheelanmi);
		animationDrawable1 = (AnimationDrawable) anim_front_wheel
				.getBackground();

		anim_rear_wheel = (ImageView) findViewById(R.id.anim_rear_wheel);
		anim_rear_wheel.setBackgroundResource(R.drawable.rearwheelanmi);
		animationDrawable2 = (AnimationDrawable) anim_rear_wheel
				.getBackground();

		model_btn = (ImageButton) this.findViewById(R.id.model_btn);
		homeButton = (ImageButton) this.findViewById(R.id.homebutton);
		homeButton.setOnLongClickListener(new View.OnLongClickListener() {

			@Override
			public boolean onLongClick(View v) {
				// TODO Auto-generated method stub
				Intent it = new Intent((Activity) v.getContext(),
						DataSettingActivity.class);
				startActivity(it);

				return false;
			}
		});

		infoButton = (ImageButton) this.findViewById(R.id.infobutton);
		controlButton = (ImageButton) this.findViewById(R.id.controlbutton);
		cameralButton = (ImageButton) this.findViewById(R.id.cameralbutton);
		expertButton = (ImageButton) this.findViewById(R.id.expertbutton);

		topButtons[0] = infoButton;
		topButtons[1] = controlButton;
		topButtons[2] = cameralButton;
		topButtons[3] = expertButton;
		topButtons[4] = listHomeButton;
		ba = (BusApplication) getApplication();
		ba.setCrashHandler(new CrashHandler());
		ba.setAnimhandler(animHandler);
		model_btn.setOnClickListener(new ModelButtonListner());
		infoButton.setOnClickListener(new TopbuttonListener(0));
		controlButton.setOnClickListener(new TopbuttonListener(1));
		cameralButton.setOnClickListener(new TopbuttonListener(2));
		expertButton.setOnClickListener(new TopbuttonListener(3));
		listHomeButton.setOnClickListener(new TopbuttonListener(4));
		airBg = (LinearLayout) this.findViewById(R.id.air_bg);
		sb = (SeekBar) this.findViewById(R.id.item_list_temprature_seekbar);

		sb.setOnSeekBarChangeListener(new OnSeekBarChangeListener() {

			@Override
			public void onProgressChanged(SeekBar seekBar, int progress,
					boolean fromUser) {

			}

			@Override
			public void onStartTrackingTouch(SeekBar seekBar) {
				// TODO Auto-generated method stub
				// TODO Auto-generated method stub

			}

			@Override
			public void onStopTrackingTouch(SeekBar seekBar) {
				// TODO Auto-generated method stub
				int seekProgress = sb.getProgress();
				if (seekProgress < 10) {
					sb.setProgress(3);
				} else if (seekProgress >= 10 && seekProgress < 30) {
					sb.setProgress(21);
				} else if (seekProgress >= 30 && seekProgress < 50) {
					sb.setProgress(42);
				} else if (seekProgress >= 50 && seekProgress < 70) {
					sb.setProgress(63);
				} else if (seekProgress >= 70 && seekProgress < 90) {
					sb.setProgress(80);
				} else if (seekProgress >= 90) {
					sb.setProgress(100);
				}
			}

		});
		/* http://blog.csdn.net/aidesudi/article/details/6608700 */

		initialize();
		initializeAnimation();
		showFragment(busFragment);
		updateUIThread.start();
	}

	public void stopAllAnimation() {
		av1.clearAnimation();
		av2.clearAnimation();
		av3.clearAnimation();
		av4.clearAnimation();
		av5.clearAnimation();
		av6.clearAnimation();

	}

	public void initializeAnimation() {

		AlphaAnimation alphaAnimation1 = new AlphaAnimation(0.0f, 0.3f);
		TranslateAnimation translateAnimation1 = new TranslateAnimation(
				Animation.RELATIVE_TO_SELF, 0f, // X轴的开始位置
				Animation.RELATIVE_TO_SELF, 0f, // X轴的结束位置
				Animation.RELATIVE_TO_SELF, 0f, // Y轴的开始位置
				Animation.RELATIVE_TO_SELF, 0.6f); // Y轴的结束位置
		alphaAnimation1.setAnimationListener(new Animation.AnimationListener() {

			@Override
			public void onAnimationStart(Animation arg0) {

			}

			@Override
			public void onAnimationRepeat(Animation arg0) {

			}

			@Override
			public void onAnimationEnd(Animation arg0) {
				airAnimationStart12();
			}
		});
		alphaAnimation1.setDuration(1000);
		translateAnimation1.setDuration(1000);
		animationSet1.addAnimation(alphaAnimation1);
		animationSet1.addAnimation(translateAnimation1);

		AlphaAnimation alphaAnimation2 = new AlphaAnimation(0.3f, 0.0f);
		TranslateAnimation translateAnimation2 = new TranslateAnimation(
				Animation.RELATIVE_TO_SELF, 0f, // X轴的开始位置
				Animation.RELATIVE_TO_SELF, 0f, // X轴的结束位置
				Animation.RELATIVE_TO_SELF, 0.6f, // Y轴的开始位置
				Animation.RELATIVE_TO_SELF, 1.0f); // Y轴的结束位置
		alphaAnimation2.setAnimationListener(new Animation.AnimationListener() {

			@Override
			public void onAnimationStart(Animation arg0) {
			}

			@Override
			public void onAnimationRepeat(Animation arg0) {
			}

			@Override
			public void onAnimationEnd(Animation arg0) {
				airAnimationStart1();
			}
		});
		alphaAnimation2.setDuration(1000);
		translateAnimation2.setDuration(1000);
		animationSet2.addAnimation(alphaAnimation2);
		animationSet2.addAnimation(translateAnimation2);

		AlphaAnimation alphaAnimation3 = new AlphaAnimation(0.0f, 0.5f);
		TranslateAnimation translateAnimation3 = new TranslateAnimation(
				Animation.RELATIVE_TO_SELF, 0f, // X轴的开始位置
				Animation.RELATIVE_TO_SELF, 0f, // X轴的结束位置
				Animation.RELATIVE_TO_SELF, 0f, // Y轴的开始位置
				Animation.RELATIVE_TO_SELF, 0.6f); // Y轴的结束位置
		alphaAnimation3.setAnimationListener(new Animation.AnimationListener() {

			@Override
			public void onAnimationStart(Animation arg0) {

			}

			@Override
			public void onAnimationRepeat(Animation arg0) {

			}

			@Override
			public void onAnimationEnd(Animation arg0) {
				airAnimationStart22();
			}
		});
		alphaAnimation3.setDuration(1000);
		translateAnimation3.setDuration(1000);
		animationSet3.addAnimation(alphaAnimation3);
		animationSet3.addAnimation(translateAnimation3);

		AlphaAnimation alphaAnimation4 = new AlphaAnimation(0.5f, 0.0f);
		TranslateAnimation translateAnimation4 = new TranslateAnimation(
				Animation.RELATIVE_TO_SELF, 0f, // X轴的开始位置
				Animation.RELATIVE_TO_SELF, 0f, // X轴的结束位置
				Animation.RELATIVE_TO_SELF, 0.6f, // Y轴的开始位置
				Animation.RELATIVE_TO_SELF, 1.0f); // Y轴的结束位置
		alphaAnimation4.setAnimationListener(new Animation.AnimationListener() {

			@Override
			public void onAnimationStart(Animation arg0) {
			}

			@Override
			public void onAnimationRepeat(Animation arg0) {
			}

			@Override
			public void onAnimationEnd(Animation arg0) {
				airAnimationStart2();
			}
		});
		alphaAnimation4.setDuration(1000);
		translateAnimation4.setDuration(1000);
		animationSet4.addAnimation(alphaAnimation4);
		animationSet4.addAnimation(translateAnimation4);

		AlphaAnimation alphaAnimation5 = new AlphaAnimation(0.0f, 1.0f);
		TranslateAnimation translateAnimation5 = new TranslateAnimation(
				Animation.RELATIVE_TO_SELF, 0f, // X轴的开始位置
				Animation.RELATIVE_TO_SELF, 0f, // X轴的结束位置
				Animation.RELATIVE_TO_SELF, 0f, // Y轴的开始位置
				Animation.RELATIVE_TO_SELF, 0.6f); // Y轴的结束位置
		alphaAnimation5.setAnimationListener(new Animation.AnimationListener() {

			@Override
			public void onAnimationStart(Animation arg0) {

			}

			@Override
			public void onAnimationRepeat(Animation arg0) {

			}

			@Override
			public void onAnimationEnd(Animation arg0) {
				airAnimationStart32();
			}
		});
		alphaAnimation5.setDuration(1000);
		translateAnimation5.setDuration(1000);
		animationSet5.addAnimation(alphaAnimation5);
		animationSet5.addAnimation(translateAnimation5);

		AlphaAnimation alphaAnimation6 = new AlphaAnimation(1.0f, 0.0f);
		TranslateAnimation translateAnimation6 = new TranslateAnimation(
				Animation.RELATIVE_TO_SELF, 0f, // X轴的开始位置
				Animation.RELATIVE_TO_SELF, 0f, // X轴的结束位置
				Animation.RELATIVE_TO_SELF, 0.6f, // Y轴的开始位置
				Animation.RELATIVE_TO_SELF, 1.0f); // Y轴的结束位置
		alphaAnimation6.setAnimationListener(new Animation.AnimationListener() {

			@Override
			public void onAnimationStart(Animation arg0) {
			}

			@Override
			public void onAnimationRepeat(Animation arg0) {
			}

			@Override
			public void onAnimationEnd(Animation arg0) {
				airAnimationStart3();
			}
		});
		alphaAnimation6.setDuration(1000);
		translateAnimation6.setDuration(1000);
		animationSet6.addAnimation(alphaAnimation6);
		animationSet6.addAnimation(translateAnimation6);

		AlphaAnimation alphaAnimation7 = new AlphaAnimation(0.0f, 0.3f);
		TranslateAnimation translateAnimation7 = new TranslateAnimation(
				Animation.RELATIVE_TO_SELF, 0f, // X轴的开始位置
				Animation.RELATIVE_TO_SELF, 0f, // X轴的结束位置
				Animation.RELATIVE_TO_SELF, 0f, // Y轴的开始位置
				Animation.RELATIVE_TO_SELF, 0.6f); // Y轴的结束位置
		alphaAnimation7.setAnimationListener(new Animation.AnimationListener() {

			@Override
			public void onAnimationStart(Animation arg0) {

			}

			@Override
			public void onAnimationRepeat(Animation arg0) {

			}

			@Override
			public void onAnimationEnd(Animation arg0) {
				airAnimationStart42();
			}
		});
		alphaAnimation7.setDuration(1000);
		translateAnimation7.setDuration(1000);
		animationSet7.addAnimation(alphaAnimation7);
		animationSet7.addAnimation(translateAnimation7);

		AlphaAnimation alphaAnimation8 = new AlphaAnimation(0.3f, 0.0f);
		TranslateAnimation translateAnimation8 = new TranslateAnimation(
				Animation.RELATIVE_TO_SELF, 0f, // X轴的开始位置
				Animation.RELATIVE_TO_SELF, 0f, // X轴的结束位置
				Animation.RELATIVE_TO_SELF, 0.6f, // Y轴的开始位置
				Animation.RELATIVE_TO_SELF, 1.0f); // Y轴的结束位置
		alphaAnimation8.setAnimationListener(new Animation.AnimationListener() {

			@Override
			public void onAnimationStart(Animation arg0) {
			}

			@Override
			public void onAnimationRepeat(Animation arg0) {
			}

			@Override
			public void onAnimationEnd(Animation arg0) {
				airAnimationStart4();
			}
		});
		alphaAnimation8.setDuration(1000);
		translateAnimation8.setDuration(1000);
		animationSet8.addAnimation(alphaAnimation8);
		animationSet8.addAnimation(translateAnimation8);

		AlphaAnimation alphaAnimation9 = new AlphaAnimation(0.0f, 0.5f);
		TranslateAnimation translateAnimation9 = new TranslateAnimation(
				Animation.RELATIVE_TO_SELF, 0f, // X轴的开始位置
				Animation.RELATIVE_TO_SELF, 0f, // X轴的结束位置
				Animation.RELATIVE_TO_SELF, 0f, // Y轴的开始位置
				Animation.RELATIVE_TO_SELF, 0.6f); // Y轴的结束位置
		alphaAnimation9.setAnimationListener(new Animation.AnimationListener() {

			@Override
			public void onAnimationStart(Animation arg0) {

			}

			@Override
			public void onAnimationRepeat(Animation arg0) {

			}

			@Override
			public void onAnimationEnd(Animation arg0) {
				airAnimationStart52();
			}
		});
		alphaAnimation9.setDuration(1000);
		translateAnimation9.setDuration(1000);
		animationSet9.addAnimation(alphaAnimation9);
		animationSet9.addAnimation(translateAnimation9);

		AlphaAnimation alphaAnimation10 = new AlphaAnimation(0.5f, 0.0f);
		TranslateAnimation translateAnimation10 = new TranslateAnimation(
				Animation.RELATIVE_TO_SELF, 0f, // X轴的开始位置
				Animation.RELATIVE_TO_SELF, 0f, // X轴的结束位置
				Animation.RELATIVE_TO_SELF, 0.6f, // Y轴的开始位置
				Animation.RELATIVE_TO_SELF, 1.0f); // Y轴的结束位置
		alphaAnimation10
				.setAnimationListener(new Animation.AnimationListener() {

					@Override
					public void onAnimationStart(Animation arg0) {
					}

					@Override
					public void onAnimationRepeat(Animation arg0) {
					}

					@Override
					public void onAnimationEnd(Animation arg0) {
						airAnimationStart5();
					}
				});
		alphaAnimation10.setDuration(1000);
		translateAnimation10.setDuration(1000);
		animationSet10.addAnimation(alphaAnimation10);
		animationSet10.addAnimation(translateAnimation10);

		AlphaAnimation alphaAnimation11 = new AlphaAnimation(0.0f, 1.0f);
		TranslateAnimation translateAnimation11 = new TranslateAnimation(
				Animation.RELATIVE_TO_SELF, 0f, // X轴的开始位置
				Animation.RELATIVE_TO_SELF, 0f, // X轴的结束位置
				Animation.RELATIVE_TO_SELF, 0f, // Y轴的开始位置
				Animation.RELATIVE_TO_SELF, 0.6f); // Y轴的结束位置
		alphaAnimation11
				.setAnimationListener(new Animation.AnimationListener() {

					@Override
					public void onAnimationStart(Animation arg0) {

					}

					@Override
					public void onAnimationRepeat(Animation arg0) {

					}

					@Override
					public void onAnimationEnd(Animation arg0) {
						airAnimationStart62();
					}
				});
		alphaAnimation11.setDuration(1000);
		translateAnimation11.setDuration(1000);
		animationSet11.addAnimation(alphaAnimation11);
		animationSet11.addAnimation(translateAnimation11);

		AlphaAnimation alphaAnimation12 = new AlphaAnimation(1.0f, 0.0f);
		TranslateAnimation translateAnimation12 = new TranslateAnimation(
				Animation.RELATIVE_TO_SELF, 0f, // X轴的开始位置
				Animation.RELATIVE_TO_SELF, 0f, // X轴的结束位置
				Animation.RELATIVE_TO_SELF, 0.6f, // Y轴的开始位置
				Animation.RELATIVE_TO_SELF, 1.0f); // Y轴的结束位置
		alphaAnimation12
				.setAnimationListener(new Animation.AnimationListener() {

					@Override
					public void onAnimationStart(Animation arg0) {
					}

					@Override
					public void onAnimationRepeat(Animation arg0) {
					}

					@Override
					public void onAnimationEnd(Animation arg0) {
						airAnimationStart6();
					}
				});
		alphaAnimation12.setDuration(1000);
		translateAnimation12.setDuration(1000);
		animationSet12.addAnimation(alphaAnimation12);
		animationSet12.addAnimation(translateAnimation12);

	}

	public void initialize() {
		status_battery_panel_number = (TextView) this
				.findViewById(R.id.status_battery_panel_number);

		status_battery_panel_number.setText("78%");
		status_energy_panel_number = (TextView) this
				.findViewById(R.id.status_energy_panel_number);
		status_energy_panel_number.setText("246");
		status_distance_panel_number = (TextView) this
				.findViewById(R.id.status_distance_panel_number);
		status_distance_panel_number.setText("257");

		ac_text.setText(new Integer(DataHandler.ac2bus.shedingwendu).toString()
				+ "℃");
		power_text.setText("1000");

	}

	public void bindAllUI() {

		acUpButton = (ImageButton) this.findViewById(R.id.ac_uparrow);
		acDownButton = (ImageButton) this.findViewById(R.id.ac_downarrow);
		powerUpButton = (ImageButton) this.findViewById(R.id.power_uparrow);
		powerDownButton = (ImageButton) this.findViewById(R.id.power_downarrow);

		ac_text = (TextView) this.findViewById(R.id.ac_text);
		power_text = (TextView) this.findViewById(R.id.power_text);

		acModelButton = (ImageButton) this.findViewById(R.id.ac_model);
		listHomeButton = (ImageButton) this.findViewById(R.id.item_list_home);
		acShowDownButton = (ImageButton) this.findViewById(R.id.ac_shut_down);

		acShowDownButton.setOnClickListener(new View.OnClickListener() {

			public void onClick(View arg0) {
				System.out.println(acon);
				if (!acon) {
					av1.setVisibility(View.VISIBLE);
					av1.setVisibility(View.VISIBLE);
					av2.setVisibility(View.VISIBLE);
					av3.setVisibility(View.VISIBLE);
					av4.setVisibility(View.VISIBLE);
					av5.setVisibility(View.VISIBLE);
					av6.setVisibility(View.VISIBLE);
					airAnimationStart1();
					airAnimationStart2();
					airAnimationStart3();
					airAnimationStart4();
					airAnimationStart5();
					airAnimationStart6();
					acon = true;
				} else {
					stopAllAnimation();
					acon = false;
					av1.setVisibility(View.GONE);
					av1.setVisibility(View.GONE);
					av2.setVisibility(View.GONE);
					av3.setVisibility(View.GONE);
					av4.setVisibility(View.GONE);
					av5.setVisibility(View.GONE);
					av6.setVisibility(View.GONE);
				}
			}
		});
		listHomeButton.setOnTouchListener(new AirButtonOnTouchListener(0));

		acShowDownButton.setOnTouchListener(new AirButtonOnTouchListener(1));
		acUpButton.setOnTouchListener(new AirButtonOnTouchListener(2));
		acDownButton.setOnTouchListener(new AirButtonOnTouchListener(3));
		acModelButton.setOnTouchListener(new AirButtonOnTouchListener(4));
		powerUpButton.setOnTouchListener(new AirButtonOnTouchListener(5));
		powerDownButton.setOnTouchListener(new AirButtonOnTouchListener(6));

		acModelButton.setOnClickListener(new ACModelButtonListner());
		acUpButton.setOnClickListener(new View.OnClickListener() {
			public void onClick(View v) {

				DataHandler.ac2bus.shedingwendu++;
				String tx = new Integer(DataHandler.ac2bus.shedingwendu)
						.toString() + "℃";

				ac_text.setText(tx);

			}
		});
		acDownButton.setOnClickListener(new View.OnClickListener() {
			public void onClick(View v) {
				DataHandler.ac2bus.shedingwendu--;
				String tx = new Integer(DataHandler.ac2bus.shedingwendu)
						.toString() + "℃";

				ac_text.setText(tx);

			}
		});
		powerUpButton.setOnClickListener(new View.OnClickListener() {
			public void onClick(View v) {
				String con = power_text.getText().toString();
				int power = new Integer(con).intValue();
				// int temperature = new Integer(ac_text.getText().toString());
				power += 100;
				String tx = new Integer(power).toString();

				power_text.setText(tx);

			}
		});
		powerDownButton.setOnClickListener(new View.OnClickListener() {
			public void onClick(View v) {
				String con = power_text.getText().toString();
				int power = new Integer(con).intValue();
				// int temperature = new Integer(ac_text.getText().toString());
				power -= 100;
				String tx = new Integer(power).toString();

				power_text.setText(tx);

			}
		});
	}

	public void airAnimationStart1() {
		av1.startAnimation(animationSet1);
	}

	public void airAnimationStart12() {
		av1.startAnimation(animationSet2);
	}

	public void airAnimationStart2() {
		av2.startAnimation(animationSet3);
	}

	public void airAnimationStart22() {
		av2.startAnimation(animationSet4);
	}

	public void airAnimationStart3() {
		av3.startAnimation(animationSet5);
	}

	public void airAnimationStart32() {
		av3.startAnimation(animationSet6);
	}

	public void airAnimationStart4() {
		av4.startAnimation(animationSet7);
	}

	public void airAnimationStart42() {
		av4.startAnimation(animationSet8);
	}

	public void airAnimationStart5() {
		av5.startAnimation(animationSet9);
	}

	public void airAnimationStart52() {
		av5.startAnimation(animationSet10);
	}

	public void airAnimationStart6() {
		av6.startAnimation(animationSet11);
	}

	public void airAnimationStart62() {
		av6.startAnimation(animationSet12);
	}

	class AirButtonOnTouchListener implements OnTouchListener {
		private int airId;

		AirButtonOnTouchListener(int id) {
			airId = id;
		}

		public boolean onTouch(View v, MotionEvent event) {

			if (event.getAction() == MotionEvent.ACTION_DOWN) {
				airBg.setBackgroundResource(airOnTouchBg[airId]);
			} else if (event.getAction() == MotionEvent.ACTION_UP) {
				airBg.setBackgroundResource(R.drawable.airbg);
			}
			return false;
		}
	}

	public void showFragment(Fragment fragment) {
		FragmentTransaction transaction = this.getSupportFragmentManager()
				.beginTransaction();
		// Replace whatever is in the fragment_container view with this
		// fragment,
		// and add the transaction to the back stack
		transaction.replace(R.id.fragment_container, fragment);
		// transaction.addToBackStack(null);
		// Commit the transaction
		transaction.commit();

	}

	public void showPress(int id) {

		if (id != 4) {
			if (currentTopButtonId != 4) {
				topButtons[currentTopButtonId]
						.setBackgroundResource(unpressedBackGround[currentTopButtonId]);
			}
			topButtons[id].setBackgroundResource(pressedBackGround[id]);
		} else {
			System.out.println("def");
			if (currentTopButtonId != 4) {
				topButtons[currentTopButtonId]
						.setBackgroundResource(unpressedBackGround[currentTopButtonId]);
			}
		}

		currentTopButtonId = id;
		/*
		 * if (id == 4 && currentTopButtonId != id) {
		 * topButtons[currentTopButtonId]
		 * .setBackgroundResource(unpressedBackGround[currentTopButtonId]);
		 * currentTopButtonId = id; return; } if (currentTopButtonId != id) { if
		 * (currentTopButtonId != 4) { topButtons[currentTopButtonId]
		 * .setBackgroundResource(unpressedBackGround[currentTopButtonId]);
		 * 
		 * topButtons[id].setBackgroundResource(pressedBackGround[id]); }
		 * currentTopButtonId = id; }
		 */
	}

	class ModelButtonListner implements OnClickListener {

		public void onClick(View v) {

			ba.setHandler(modelHandler);

			Intent intent = new Intent(MainActivity.this, ModelActivity.class);

			MainActivity.this.startActivity(intent);

		}

	}

	final class AnimationHandler extends Handler {
		@Override
		public void handleMessage(Message msg) {
			System.out.println(123);
			buslightoff.setVisibility(View.VISIBLE);
		}
	}

	class ACModelButtonListner implements OnClickListener {

		public void onClick(View v) {

			Intent intent = new Intent(MainActivity.this, ACModelActivity.class);

			MainActivity.this.startActivity(intent);

		}

	}

	class TopbuttonListener implements OnClickListener {

		private int bid;

		TopbuttonListener(int id) {
			bid = id;
		}

		@Override
		public void onClick(View v) {
			// TODO Auto-generated method
			// stub
			System.out.println(dh.getInt(bid));
			showPress(bid);

			if (v.equals(controlButton)) {
				showFragment(buttonsFragment);
				return;
			}
			if (v.equals(listHomeButton)) {
				// v.setBackgroundResource(R.drawable.button_bus_info_pressed);
				showFragment(busFragment);
				return;
			}
			if (v.equals(infoButton)) {
				// v.setBackgroundResource(R.drawable.button_bus_info_pressed);
				showFragment(busInfoFragment);
				return;
			}
		}
	}

	final class ModelHandler extends Handler {
		@Override
		public void handleMessage(Message msg) {

			model_btn.setBackgroundResource(bgSource[msg.what]);
		}
	}

	final class CrashHandler extends Handler {
		@Override
		public void handleMessage(Message msg) {

			CrashCheckFragment crashCheckFragment = new CrashCheckFragment();

			FragmentTransaction transaction = MainActivity.this
					.getSupportFragmentManager().beginTransaction();

			transaction.replace(R.id.info_fragment_container,
					crashCheckFragment);
			// commit after activity saveInstatance ,pls use
			// commitAllowingStateLoss
			transaction.commitAllowingStateLoss();
		}
	}

	@Override
	public void onWindowFocusChanged(boolean hasFocus)

	{
		animationDrawable.start();
		animationDrawable1.start();
		animationDrawable2.start();
		super.onWindowFocusChanged(hasFocus);

	}

	final class UpdataUIHandler extends Handler {
		@Override
		public void handleMessage(Message msg) {
			midopenlighton = (ImageView) findViewById(R.id.midopenlighton);
			midopenlightoff = (ImageView) findViewById(R.id.midopenlightoff);
			frontopenlighton = (ImageView) findViewById(R.id.frontopenlighton);
			frontopenlightoff = (ImageView) findViewById(R.id.frontopenlightoff);
			frontlighton = (ImageView) findViewById(R.id.frontlighton);
			frontheadlighton = (ImageView) findViewById(R.id.frontheadlighton);
			rearlighton = (ImageView) findViewById(R.id.rearlighton);
			cabinetopen = (ImageView) findViewById(R.id.cabinetopen);
			fakeCount++;
			if (fakeCount % 11 == 0) {

				cabinetopen.setVisibility(View.VISIBLE);
				return;
			}
			if (fakeCount % 11 == 1) {
				cabinetopen.setVisibility(View.GONE);
				rearlighton.setVisibility(View.VISIBLE);
				return;
			}
			if (fakeCount % 11 == 2) {
				rearlighton.setVisibility(View.GONE);
				frontheadlighton.setVisibility(View.VISIBLE);
				return;
			}
			if (fakeCount % 11 == 3) {
				frontheadlighton.setVisibility(View.GONE);
				frontlighton.setVisibility(View.VISIBLE);
				return;

			}
			if (fakeCount % 11 == 4) {
				frontlighton.setVisibility(View.GONE);
				buslightoff.setVisibility(View.VISIBLE);
				return;

			}
			if (fakeCount % 11 == 5) {

				frontopenlightoff.setVisibility(View.VISIBLE);
				return;
			}
			if (fakeCount % 11 == 6) {
				frontopenlightoff.setVisibility(View.GONE);
				midopenlightoff.setVisibility(View.VISIBLE);
			}
			if (fakeCount % 11 == 7) {
				frontopenlightoff.setVisibility(View.GONE);
				midopenlightoff.setVisibility(View.GONE);

			}
			if (fakeCount % 11 == 8) {

				midopenlighton.setVisibility(View.VISIBLE);
			}
			if (fakeCount % 11 == 9) {
				midopenlighton.setVisibility(View.GONE);
				frontopenlighton.setVisibility(View.VISIBLE);

			}
			if (fakeCount % 11 == 10) {
				frontopenlighton.setVisibility(View.GONE);
			}

		}
	}

	private class updataUIThread extends Thread {

		@Override
		public void run() {
			while (true) {
				try {
					Thread.sleep(3000);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				// TODO Auto-generated method stub
				updataUIHandler.sendEmptyMessage(0);
			}
		}
	}
}
