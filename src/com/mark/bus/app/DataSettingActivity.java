package com.mark.bus.app;

import com.mark.bus.R;
import com.mark.bus.app.ButtonsFragment.lightListener;
import com.mark.bus.data.DataHandler;

import android.app.Activity;
import android.content.Context;
import android.media.AudioManager;
import android.os.Bundle;
import android.provider.Settings.SettingNotFoundException;
import android.view.View;
import android.view.Window;
import android.view.View.OnClickListener;
import android.view.WindowManager;
import android.widget.ImageButton;
import android.widget.SeekBar;
import android.widget.SeekBar.OnSeekBarChangeListener;

public class DataSettingActivity extends Activity {

	private ImageButton wlanButton;
	private ImageButton dataButton;
	private ImageButton intensityButton;
	private ImageButton lockButton;
	private ImageButton wifiButton;
	private ImageButton nfcButton;
	private ImageButton videoButton;
	private ImageButton fileButton;
	private SeekBar intensity;
	private SeekBar volumn;
	private int begin;
	private int end;
	private ImageButton setclosebtn;
	int[] lightsOffResource = { R.drawable.wlan_off, R.drawable.data_off,
			R.drawable.intensity_off, R.drawable.lock_off, R.drawable.wifi_off,
			R.drawable.nfc_off, R.drawable.video_off, R.drawable.file_off };
	int[] lightsOnResource = { R.drawable.wlan_on, R.drawable.data_on,
			R.drawable.intensity_on, R.drawable.lock_on, R.drawable.wifi_on,
			R.drawable.nfc_on, R.drawable.video_on, R.drawable.file_on

	};

	public void initialize() {
		BusApplication ba = (BusApplication) getApplication();
		int[] buttonStatus = ba.getButtonStatus();

		ImageButton[] ims = { wlanButton, dataButton, intensityButton,
				lockButton, wifiButton, nfcButton, videoButton, fileButton };

		for (int i = 0; i < ims.length; i++) {
			if (buttonStatus[i] == 0)
				ims[i].setBackgroundResource(lightsOffResource[i]);
			else
				ims[i].setBackgroundResource(lightsOnResource[i]);
		}
		screenBrightness_check();
		systemVolumn_check();
	}

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		super.requestWindowFeature(Window.FEATURE_NO_TITLE);
		super.setContentView(R.layout.setting_activity);
		wlanButton = (ImageButton) this.findViewById(R.id.wlan);
		dataButton = (ImageButton) this.findViewById(R.id.data);
		intensityButton = (ImageButton) this.findViewById(R.id.intensity);
		lockButton = (ImageButton) this.findViewById(R.id.lock);
		wifiButton = (ImageButton) this.findViewById(R.id.wifi);
		nfcButton = (ImageButton) this.findViewById(R.id.nfc);
		videoButton = (ImageButton) this.findViewById(R.id.video);
		fileButton = (ImageButton) this.findViewById(R.id.file);
		wlanButton.setOnClickListener(new lightListener(0));
		dataButton.setOnClickListener(new lightListener(1));
		intensityButton.setOnClickListener(new lightListener(2));
		lockButton.setOnClickListener(new lightListener(3));
		wifiButton.setOnClickListener(new lightListener(4));
		nfcButton.setOnClickListener(new lightListener(5));
		videoButton.setOnClickListener(new lightListener(6));
		fileButton.setOnClickListener(new lightListener(7));

		intensity = (SeekBar) this.findViewById(R.id.intensity_seekBar);
		volumn = (SeekBar) this.findViewById(R.id.volumn_seekBar);
		setclosebtn =(ImageButton ) this.findViewById(R.id.setclosebtn);
		setclosebtn.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				finish();
			}
		});
		initialize();
	}

	public void systemVolumn_check() {
		AudioManager mAudioManager = (AudioManager) getSystemService(Context.AUDIO_SERVICE);
		int current = mAudioManager
				.getStreamVolume(AudioManager.STREAM_VOICE_CALL);
		volumn.setProgress(current);
		volumn.setOnSeekBarChangeListener(new OnSeekBarChangeListener() {

			@Override
			public void onProgressChanged(SeekBar seekBar, int progress,
					boolean fromUser) {

			}

			@Override
			public void onStartTrackingTouch(SeekBar seekBar) {
				// TODO Auto-generated method stub
				// TODO Auto-generated method stub
				begin = seekBar.getProgress();

			}

			@Override
			public void onStopTrackingTouch(SeekBar seekBar) {
				// TODO Auto-generated method stub
				int seekProgress = seekBar.getProgress();
				end = seekBar.getProgress();
				setSystemVolumn(seekProgress);
			}
		});
	}

	public void setSystemVolumn(int process) {
		AudioManager mAudioManager = (AudioManager) getSystemService(Context.AUDIO_SERVICE);
		if(begin>end){
			 mAudioManager.adjustStreamVolume(AudioManager.STREAM_MUSIC,AudioManager.ADJUST_LOWER,    
                     AudioManager.FX_FOCUS_NAVIGATION_UP);    	
		}else{
			 mAudioManager.adjustStreamVolume(AudioManager.STREAM_MUSIC,AudioManager.ADJUST_RAISE,    
                     AudioManager.FX_FOCUS_NAVIGATION_UP);
		}
	}

	public void screenBrightness_check() {
		// 先关闭系统的亮度自动调节
		try {
			if (android.provider.Settings.System.getInt(getContentResolver(),
					android.provider.Settings.System.SCREEN_BRIGHTNESS_MODE) == android.provider.Settings.System.SCREEN_BRIGHTNESS_MODE_AUTOMATIC) {
				android.provider.Settings.System
						.putInt(getContentResolver(),
								android.provider.Settings.System.SCREEN_BRIGHTNESS_MODE,
								android.provider.Settings.System.SCREEN_BRIGHTNESS_MODE_MANUAL);
			}
		} catch (SettingNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		// 获取当前亮度,获取失败则返回255
		int intScreenBrightness = (int) (android.provider.Settings.System
				.getInt(getContentResolver(),
						android.provider.Settings.System.SCREEN_BRIGHTNESS, 255));
		// 文本、进度条显示
		intensity.setProgress(intScreenBrightness);
		intensity.setOnSeekBarChangeListener(new OnSeekBarChangeListener() {

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
				int seekProgress = intensity.getProgress();
				setScreenBritness(seekProgress);
			}
		});
	}

	private void setScreenBritness(int brightness) {
		// 不让屏幕全暗
		if (brightness <= 1) {
			brightness = 1;
		}
		// 设置当前activity的屏幕亮度
		WindowManager.LayoutParams lp = this.getWindow().getAttributes();
		// 0到1,调整亮度暗到全亮
		lp.screenBrightness = Float.valueOf(brightness / 255f);
		this.getWindow().setAttributes(lp);

		// 保存为系统亮度方法1
		android.provider.Settings.System.putInt(getContentResolver(),
				android.provider.Settings.System.SCREEN_BRIGHTNESS, brightness);

		// 保存为系统亮度方法2
		// Uri uri =
		// android.provider.Settings.System.getUriFor("screen_brightness");
		// android.provider.Settings.System.putInt(getContentResolver(),
		// "screen_brightness", brightness);
		// // resolver.registerContentObserver(uri, true, myContentObserver);
		// getContentResolver().notifyChange(uri, null);

		// 更改亮度文本显示
		// mTextView_light.setText("" + brightness * 100 / 255);
	}

	class lightListener implements OnClickListener {
		public int id;

		public int getId() {
			return id;
		}

		lightListener(int bid) {
			id = bid;
		}

		public void setId(int id) {
			this.id = id;
		}

		public void onClick(View v) {

			BusApplication ba = (BusApplication) getApplication();
			int[] dataStatus = ba.getDataStatus();
			if (dataStatus[id] == 0) {
				dataStatus[id] = 1;
				ba.setButtonStatus(dataStatus);
				v.setBackgroundResource(lightsOnResource[id]);
			} else {
				dataStatus[id] = 0;
				ba.setButtonStatus(dataStatus);
				v.setBackgroundResource(lightsOffResource[id]);
			}

		}

	}

}
