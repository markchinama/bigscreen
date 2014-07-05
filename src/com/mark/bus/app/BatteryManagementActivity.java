package com.mark.bus.app;

import java.util.ArrayList;
import java.util.List;

import com.mark.bus.R;
import com.mark.bus.data.DataFromBMS1;
import com.mark.bus.data.DataFromBMS2;
import com.mark.bus.data.DataFromBMS3;
import com.mark.bus.data.DataHandler1;

import android.graphics.Point;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.view.ViewPager;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ImageButton;
import android.widget.TextView;

public class BatteryManagementActivity extends FragmentActivity {

	private ImageButton closeBtn;

	private TextView tv_dianchizongdianya;
	private TextView tv_dianchisoc;
	private TextView tv_dianchizongxiangshu;
	private TextView tv_shengyunengliang;
	private TextView tv_shunshigonglv;
	private TextView tv_shunshigonghao;
	private TextView tv_dianchichongfangdiandianliu;
	private TextView tv_mokuaizuigaowendu;
	private TextView tv_mokuaizuidiwendu;
	private TextView tv_zuigaowendudianchiweizhi;
	private TextView tv_zuidiwendudianchiweizhi;
	private TextView tv_dantizuigaodianya;
	private TextView tv_dantizuididianya;
	private TextView tv_zuigaodianyadianchiweizhi;
	private TextView tv_zuididianyadianchiweizhi;
	private TextView tv_zuigaodianyadianchixiangjieshu;
	private TextView tv_zuididianyadianchixiangjieshu;
	private TextView tv_chongdianzhuanglianjiebiaozhiwei;
	private TextView tv_jinzhichongdianbiaozhi;
	List<Fragment> fragmentList = new ArrayList<Fragment>();

	private boolean isStop = false;
	UIHandler mHandler = new UIHandler();
	private final class UIHandler extends Handler {
		public void handleMessage(Message msg) {			
			initialize();
		}
	}
	@Override
	public void onPause() {

		isStop = true;
		super.onPause();
	}
	
	/** 页面title list **/

	List<String> titleList = new ArrayList<String>();

	public void initialize() {
		DataFromBMS1 db1 = DataHandler1.db1;
		DataFromBMS2 db2 = DataHandler1.db2;
		DataFromBMS3 db3 = DataHandler1.db3;
		tv_dianchizongdianya = (TextView) this
				.findViewById(R.id.bma_dianchizongdianya);
		tv_dianchizongdianya.setText((CharSequence) Float
				.toString(db1.dianchixitongshishizongdianya));

		tv_dianchisoc = (TextView) this.findViewById(R.id.bma_dianchisoc);
		tv_dianchisoc.setText((CharSequence) Float
				.toString(db1.dianchisoc));

		tv_dianchizongxiangshu = (TextView) this
				.findViewById(R.id.bma_dianchizongxiangshu);
		tv_dianchizongxiangshu.setText((CharSequence) Integer
				.toString(db2.dianchizongxiangshu));

		tv_shengyunengliang = (TextView) this
				.findViewById(R.id.bma_shengyunengliang);
		tv_shengyunengliang.setText((CharSequence) Float
				.toString(db3.shengyunengliang));

		tv_shunshigonglv = (TextView) this.findViewById(R.id.bma_shunshigonglv);
		tv_shunshigonghao = (TextView) this
				.findViewById(R.id.bma_shunshigonghao);

		tv_dianchichongfangdiandianliu = (TextView) this
				.findViewById(R.id.bma_dianchichongfangdiandianliu);
		tv_dianchichongfangdiandianliu.setText((CharSequence) Float
				.toString(db1.dianchishishidianliu));
		// ////////////////////////////////////////////////
		tv_mokuaizuigaowendu = (TextView) this
				.findViewById(R.id.bma_mokuaizuigaowendu);
		tv_mokuaizuigaowendu.setText((CharSequence) Float
				.toString(db2.dianchimokuaizuigaowendu));

		tv_mokuaizuidiwendu = (TextView) this
				.findViewById(R.id.bma_mokuaizuidiwendu);
		tv_mokuaizuidiwendu.setText((CharSequence) Float
				.toString(db2.dianchimokuaizuigaowendu - db2.dianchimokuaiwendujicha));
		// /////////////////////////////////////////////////
		tv_zuigaowendudianchiweizhi = (TextView) this
				.findViewById(R.id.bma_zuigaowendudianchixiangweizhi);
		tv_zuigaowendudianchiweizhi.setText((CharSequence) Integer
				.toString(db3.zuigaowendudianchiweizhi));

		tv_zuidiwendudianchiweizhi = (TextView) this
				.findViewById(R.id.bma_zuidiwendudianchixiangweizhi);
		tv_zuidiwendudianchiweizhi.setText((CharSequence) Integer
				.toString(db3.zuidiwendudianchiweizhi));

		// /////////////////////////////////////////////////
		tv_dantizuigaodianya = (TextView) this
				.findViewById(R.id.bma_dantizuigaodianya);
		tv_dantizuigaodianya.setText((CharSequence) Integer
				.toString(db2.dianchimokuaizuigaodianya));
		
		tv_dantizuididianya = (TextView) this
				.findViewById(R.id.bma_dantizuididianya);
	    tv_dantizuididianya.setText((CharSequence) Integer
				.toString(db2.dianchimokuaizuididianya));
		// /////////////////////////////////////////////////

		tv_zuigaodianyadianchiweizhi = (TextView) this
				.findViewById(R.id.bma_zuigaodianyadianchixiangweizhi);
		tv_zuigaodianyadianchiweizhi.setText((CharSequence) Integer
				.toString(db3.zuigaodianyadianchiweizhi));

		tv_zuididianyadianchiweizhi = (TextView) this
				.findViewById(R.id.bma_zuididianyadianchixiangweizhi);
		tv_zuididianyadianchiweizhi.setText((CharSequence) Integer
				.toString(db3.zuididianyadianchiweizhi));

		tv_zuigaodianyadianchixiangjieshu = (TextView) this
				.findViewById(R.id.bma_zuigaodianyadianchixiangjieshu);
		tv_zuigaodianyadianchixiangjieshu.setText((CharSequence) Integer
				.toString(db3.zuigaodianyadianchixiangshu));

		tv_zuididianyadianchixiangjieshu = (TextView) this
				.findViewById(R.id.bma_zuididianyadianchixiangjieshu);
		tv_zuididianyadianchixiangjieshu.setText((CharSequence) Integer
				.toString(db3.zuigaodianyadianchixiangshu));

		tv_chongdianzhuanglianjiebiaozhiwei = (TextView) this
				.findViewById(R.id.bma_chongdianzhuanglianjiebiaozhiwei);
		

		tv_jinzhichongdianbiaozhi = (TextView) this
				.findViewById(R.id.bma_jinzhichongdianbiaozhi);
		if (db1.shifoujinzhichongdianbiaozhiwei == 1) {
			tv_jinzhichongdianbiaozhi.setText((CharSequence) this
					.getResources().getString(R.string.jinzhichongdian));
		} else {
			tv_jinzhichongdianbiaozhi.setText((CharSequence) this
					.getResources().getString(R.string.yunxuchongdian));
		}
		
		if (db1.chongdianzhuanglianjiebiaozhiwei == 1) {
			tv_chongdianzhuanglianjiebiaozhiwei.setText((CharSequence) this
					.getResources().getString(R.string.yilianjie));
		} else {
			tv_chongdianzhuanglianjiebiaozhiwei.setText((CharSequence) this
					.getResources().getString(R.string.weilianjie));
		}
	}

	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		super.requestWindowFeature(Window.FEATURE_NO_TITLE);
		super.setContentView(R.layout.battery_management_activity);
		ViewPager vp = (ViewPager)findViewById(R.id.viewPager);
	
		fragmentList.add(new BatteryViewPagerFragment(0));

		fragmentList.add(new BatteryViewPagerFragment(1));

		fragmentList.add(new BatteryViewPagerFragment(2));

		titleList.add("title 1 ");

		titleList.add("title 2 ");

		titleList.add("title 3 ");
		  vp.setAdapter(new BatteryViewPagerAdapter(getSupportFragmentManager(), fragmentList, titleList));
		closeBtn = (ImageButton) this.findViewById(R.id.bma_closebtn);

		closeBtn.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View v) {
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
		//initialize();
		new Thread() {
			@Override
			public void run() {
				while (!isStop) {
					mHandler.sendEmptyMessage(0);
					try {
						Thread.sleep(500);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
			}
		}.start();
	}

}
