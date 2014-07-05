package com.mark.bus.app;

import com.mark.bus.R;
import com.mark.bus.app.MainActivity.CrashHandler;
import com.mark.bus.data.DataHandler;
import com.mark.bus.data.DataHandler1;

import android.graphics.Point;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ImageButton;

public class CrashActivity extends FragmentActivity {

	private ImageButton closeBtn;

	private ImageButton protectbtn;

	private CrashHandler crashHandler = null;

	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		super.requestWindowFeature(Window.FEATURE_NO_TITLE);
		super.setContentView(R.layout.crash_activity);
		closeBtn = (ImageButton) this.findViewById(R.id.crash_closebtn);
		protectbtn = (ImageButton) this.findViewById(R.id.protectbtn);
		closeBtn.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View v) {
				finish();

			}
		});

		protectbtn.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View v) {
			  DataHandler.workMode2Bus.crash=0x55;
			  DataHandler1.dfc.dProtected = true;
				finish();

			}
		});

		Window window = getWindow();
		WindowManager.LayoutParams wl = window.getAttributes();
		wl.flags = WindowManager.LayoutParams.FLAG_KEEP_SCREEN_ON;
		wl.alpha = 1.0f;
		wl.x = -50;
		wl.y = -10;
		wl.width = 768;
		wl.height = 770;
		window.setAttributes(wl);

	}

}
