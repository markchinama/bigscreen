package com.mark.bus.app;

import java.text.DecimalFormat;

import android.support.v4.app.Fragment;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.View.OnTouchListener;
import android.widget.ImageButton;
import android.widget.TableRow;
import android.widget.TextView;

import com.mark.bus.R;
import com.mark.bus.data.DataFromBMS1;
import com.mark.bus.data.DataFromBMS2;
import com.mark.bus.data.DataFromBMS3;
import com.mark.bus.data.DataHandler1;

public class BatteryManagementFragment extends Fragment {

	private CharSequence jinzhichongdian;
	private CharSequence yunxuchongdian;
	private CharSequence yilianjie;
	private CharSequence weilianjie;

	private boolean stop = false;
	private boolean flag = true;
	private TableRow tab11;
	private TableRow tab12;
	private TableRow tab13;
	private TableRow tab14;

	private TableRow tab21;
	private TableRow tab22;
	private TableRow tab23;
	private TableRow tab24;

	private TableRow tab31;
	private TableRow tab32;

	private ImageButton collapse;

	private final int DOUBLE_TAP_TIMEOUT = 200;
	private MotionEvent mCurrentDownEvent;
	private MotionEvent mPreviousUpEvent;
	private View view;

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

	private TextView bmf_m1_count;
	private TextView bmf_m2_count;
	
	private TextView bmf_m1_high_temperature;
	private TextView bmf_m2_high_temperature;
	
	private TextView bmf_m1_low_temperature;
	private TextView bmf_m2_low_temperature;
	
	private TextView bmf_m1b1;
	private TextView bmf_m1b2;
	private TextView bmf_m1b3;
	private TextView bmf_m1b4;
	private TextView bmf_m1b5;
	private TextView bmf_m1b6;
	private TextView bmf_m1b7;
	private TextView bmf_m1b8;
	private TextView bmf_m1b9;
	private TextView bmf_m1b10;
	private TextView bmf_m1b11;
	private TextView bmf_m1b12;
	private TextView bmf_m1b13;
	private TextView bmf_m1b14;
	private TextView bmf_m1b15;
	private TextView bmf_m1b16;
	private TextView bmf_m1b17;
	private TextView bmf_m1b18;
	private TextView bmf_m1b19;
	private TextView bmf_m1b20;
	private TextView bmf_m1b21;
	private TextView bmf_m1b22;
	private TextView bmf_m1b23;
	private TextView bmf_m1b24;
	private TextView bmf_m1b25;
	private TextView bmf_m1b26;
	private TextView bmf_m1b27;
	private TextView bmf_m1b28;
	private TextView bmf_m1b29;
	private TextView bmf_m1b30;
	private TextView bmf_m1b31;
	private TextView bmf_m1b32;

	private TextView bmf_m2b1;
	private TextView bmf_m2b2;
	private TextView bmf_m2b3;
	private TextView bmf_m2b4;
	private TextView bmf_m2b5;
	private TextView bmf_m2b6;
	private TextView bmf_m2b7;
	private TextView bmf_m2b8;
	private TextView bmf_m2b9;
	private TextView bmf_m2b10;
	private TextView bmf_m2b11;
	private TextView bmf_m2b12;
	private TextView bmf_m2b13;
	private TextView bmf_m2b14;
	private TextView bmf_m2b15;
	private TextView bmf_m2b16;
	private TextView bmf_m2b17;
	private TextView bmf_m2b18;
	private TextView bmf_m2b19;
	private TextView bmf_m2b20;
	private TextView bmf_m2b21;
	private TextView bmf_m2b22;
	private TextView bmf_m2b23;
	private TextView bmf_m2b24;
	private TextView bmf_m2b25;
	private TextView bmf_m2b26;
	private TextView bmf_m2b27;
	private TextView bmf_m2b28;
	private TextView bmf_m2b29;
	private TextView bmf_m2b30;
	private TextView bmf_m2b31;
	private TextView bmf_m2b32;
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

	public void initialize() {
		DataFromBMS1 db1 = DataHandler1.db1;
		DataFromBMS2 db2 = DataHandler1.db2;
		DataFromBMS3 db3 = DataHandler1.db3;
		tv_dianchizongdianya = (TextView) view
				.findViewById(R.id.bmf_dianchizongdianya);
		tv_dianchizongdianya.setText((CharSequence) Float
				.toString(db1.dianchixitongshishizongdianya));

		tv_dianchisoc = (TextView) view.findViewById(R.id.bmf_dianchisoc);
		tv_dianchisoc.setText((CharSequence) Float.toString(db1.dianchisoc));

		tv_dianchizongxiangshu = (TextView) view
				.findViewById(R.id.bmf_dianchizongxiangshu);
		tv_dianchizongxiangshu.setText((CharSequence) Integer
				.toString(db2.dianchizongxiangshu));

		tv_shengyunengliang = (TextView) view
				.findViewById(R.id.bmf_shengyunengliang);
		tv_shengyunengliang.setText((CharSequence) Float
				.toString(db3.shengyunengliang));

		tv_shunshigonglv = (TextView) view.findViewById(R.id.bmf_shunshigonglv);
		tv_shunshigonghao = (TextView) view
				.findViewById(R.id.bmf_shunshigonghao);

		tv_dianchichongfangdiandianliu = (TextView) view
				.findViewById(R.id.bmf_dianchichongfangdiandianliu);
		tv_dianchichongfangdiandianliu.setText((CharSequence) Float
				.toString(db1.dianchishishidianliu));
		// ////////////////////////////////////////////////
		tv_mokuaizuigaowendu = (TextView) view
				.findViewById(R.id.bmf_mokuaizuigaowendu);
		tv_mokuaizuigaowendu.setText((CharSequence) Float
				.toString(db2.dianchimokuaizuigaowendu));

		tv_mokuaizuidiwendu = (TextView) view
				.findViewById(R.id.bmf_mokuaizuidiwendu);
		tv_mokuaizuidiwendu.setText((CharSequence) Float
				.toString(db2.dianchimokuaizuigaowendu
						- db2.dianchimokuaiwendujicha));
		// /////////////////////////////////////////////////
		tv_zuigaowendudianchiweizhi = (TextView) view
				.findViewById(R.id.bmf_zuigaoweidudianchiweizhi);
		tv_zuigaowendudianchiweizhi.setText((CharSequence) Integer
				.toString(db3.zuigaowendudianchiweizhi));

		tv_zuidiwendudianchiweizhi = (TextView) view
				.findViewById(R.id.bmf_zuidiweidudianchiweizhi);
		tv_zuidiwendudianchiweizhi.setText((CharSequence) Integer
				.toString(db3.zuidiwendudianchiweizhi));

		// /////////////////////////////////////////////////
		tv_dantizuigaodianya = (TextView) view
				.findViewById(R.id.bmf_dantizuigaodianya);

		tv_dantizuididianya = (TextView) view
				.findViewById(R.id.bmf_dantizuididianya);

		// /////////////////////////////////////////////////

		tv_zuigaodianyadianchiweizhi = (TextView) view
				.findViewById(R.id.bmf_zuigaodianyadianchixiangweizhi);
		tv_zuigaodianyadianchiweizhi.setText((CharSequence) Integer
				.toString(db3.zuigaodianyadianchiweizhi));

		tv_zuididianyadianchiweizhi = (TextView) view
				.findViewById(R.id.bmf_zuididianyadianchixiangweizhi);
		tv_zuididianyadianchiweizhi.setText((CharSequence) Integer
				.toString(db3.zuididianyadianchiweizhi));

		tv_zuigaodianyadianchixiangjieshu = (TextView) view
				.findViewById(R.id.bmf_zuigaodianyadianchixiangjieshu);
		tv_zuigaodianyadianchixiangjieshu.setText((CharSequence) Integer
				.toString(db3.zuigaodianyadianchixiangshu));

		tv_zuididianyadianchixiangjieshu = (TextView) view
				.findViewById(R.id.bmf_zuididianyadianchixiangjieshu);
		tv_zuididianyadianchixiangjieshu.setText((CharSequence) Integer
				.toString(db3.zuigaodianyadianchixiangshu));

		tv_chongdianzhuanglianjiebiaozhiwei = (TextView) view
				.findViewById(R.id.bmf_chongdianzhuanglianjiebiaozhiwei);
		tv_chongdianzhuanglianjiebiaozhiwei.setText((CharSequence) Integer
				.toString(db1.chongdianzhuanglianjiebiaozhiwei));

		tv_jinzhichongdianbiaozhi = (TextView) view
				.findViewById(R.id.bmf_jinzhichongdianbiaozhi);
		if (db1.shifoujinzhichongdianbiaozhiwei == 1) {
			tv_jinzhichongdianbiaozhi.setText(jinzhichongdian);
		} else {
			tv_jinzhichongdianbiaozhi.setText(yunxuchongdian);
		}

		if (db1.shifoujinzhichongdianbiaozhiwei == 1) {
			tv_chongdianzhuanglianjiebiaozhiwei.setText(yilianjie);
		} else {
			tv_chongdianzhuanglianjiebiaozhiwei.setText(weilianjie);
		}
		bmf_m1_high_temperature
		.setText(new Integer(
				DataHandler1.dfcb.batteryModuleHighTemperature[0])
				.toString()
				+ "℃");
		bmf_m1_low_temperature
		.setText(new Integer(
				DataHandler1.dfcb.batteryModuleLowTemperature[0])
				.toString()
				+ "℃");
		bmf_m2_high_temperature
		.setText(new Integer(
				DataHandler1.dfcb.batteryModuleHighTemperature[1])
				.toString()
				+ "℃");
		bmf_m2_low_temperature
		.setText(new Integer(
				DataHandler1.dfcb.batteryModuleLowTemperature[1])
				.toString()
				+ "℃");
		bmf_m1_count.setText(new Integer(
				DataHandler1.dfcb.batteryMonomerNumbers[0])
				.toString()
				+ "支");
		bmf_m2_count.setText(new Integer(
				DataHandler1.dfcb.batteryMonomerNumbers[ 1])
				.toString()
				+ "支");
		
		TextView[] texts = { bmf_m1b1, bmf_m1b2, bmf_m1b3, bmf_m1b4, bmf_m1b5,
				bmf_m1b6, bmf_m1b7, bmf_m1b8, bmf_m1b9, bmf_m1b10, bmf_m1b11,
				bmf_m1b12, bmf_m1b13, bmf_m1b14, bmf_m1b15, bmf_m1b16,
				bmf_m1b17, bmf_m1b18, bmf_m1b19, bmf_m1b20, bmf_m1b21,
				bmf_m1b22, bmf_m1b23, bmf_m1b24, bmf_m1b25, bmf_m1b26,
				bmf_m1b27, bmf_m1b28, bmf_m1b29, bmf_m1b30, bmf_m1b31,
				bmf_m1b32, bmf_m2b1, bmf_m2b2, bmf_m2b3, bmf_m2b4, bmf_m2b5,
				bmf_m2b6, bmf_m2b7, bmf_m2b8, bmf_m2b9, bmf_m2b10, bmf_m2b11,
				bmf_m2b12, bmf_m2b13, bmf_m2b14, bmf_m2b15, bmf_m2b16,
				bmf_m2b17, bmf_m2b18, bmf_m2b19, bmf_m2b20, bmf_m2b21,
				bmf_m2b22, bmf_m2b23, bmf_m2b24, bmf_m2b25, bmf_m2b26,
				bmf_m2b27, bmf_m2b28, bmf_m2b29, bmf_m2b30, bmf_m2b31,
				bmf_m2b32 };
		DecimalFormat df = new DecimalFormat();
		String style = "00.00 V";
		df.applyPattern(style);
		for (int i = 0; i < texts.length; i++) {
			int beginIndex = 0;
			int currentModule = (i / 32);

			for (int j = 0; j < currentModule; j++) {
				beginIndex += DataHandler1.dfcb.batteryMonomerNumbers[j];
			}

			if ((i % 32) > DataHandler1.dfcb.batteryMonomerNumbers[currentModule] - 1) {
				texts[i].setText("00.00 V");
			} else {
				Float f = DataHandler1.dfcb.batteryMonomerVoltages[beginIndex
						+ i % 32] / 1000f;
				texts[i].setText(df.format(f));
			}
		}
	}

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		view = inflater.inflate(R.layout.battery_management_fragment,
				container, false);
		jinzhichongdian = this.getResources().getString(
				R.string.jinzhichongdian);
		yunxuchongdian = this.getResources().getString(R.string.yunxuchongdian);
		yilianjie = this.getResources().getString(R.string.yilianjie);
		weilianjie = this.getResources().getString(R.string.weilianjie);

		tab11 = (TableRow) view.findViewById(R.id.v11);
		tab12 = (TableRow) view.findViewById(R.id.v12);
		tab13 = (TableRow) view.findViewById(R.id.v13);
		tab14 = (TableRow) view.findViewById(R.id.v14);
		tab21 = (TableRow) view.findViewById(R.id.v21);
		tab22 = (TableRow) view.findViewById(R.id.v22);
		tab23 = (TableRow) view.findViewById(R.id.v23);
		tab24 = (TableRow) view.findViewById(R.id.v24);
		tab31 = (TableRow) view.findViewById(R.id.v31);
		tab32 = (TableRow) view.findViewById(R.id.v32);
		
		bmf_m1_count = (TextView) view.findViewById(R.id.bmf_m1_count);
		bmf_m2_count = (TextView) view.findViewById(R.id.bmf_m2_count);
		bmf_m1_high_temperature = (TextView) view
				.findViewById(R.id.bmf_m1_high_temperature);
		bmf_m2_high_temperature = (TextView) view
				.findViewById(R.id.bmf_m2_high_temperature);
		bmf_m1_low_temperature = (TextView) view
				.findViewById(R.id.bmf_m1_low_temperature);
		bmf_m2_low_temperature = (TextView) view
				.findViewById(R.id.bmf_m2_low_temperature);

		bmf_m1b1 = (TextView) view.findViewById(R.id.bmf_m1b1);
		bmf_m1b2 = (TextView) view.findViewById(R.id.bmf_m1b2);
		bmf_m1b3 = (TextView) view.findViewById(R.id.bmf_m1b3);
		bmf_m1b4 = (TextView) view.findViewById(R.id.bmf_m1b4);
		bmf_m1b5 = (TextView) view.findViewById(R.id.bmf_m1b5);
		bmf_m1b6 = (TextView) view.findViewById(R.id.bmf_m1b6);
		bmf_m1b7 = (TextView) view.findViewById(R.id.bmf_m1b7);
		bmf_m1b8 = (TextView) view.findViewById(R.id.bmf_m1b8);
		bmf_m1b9 = (TextView) view.findViewById(R.id.bmf_m1b9);
		bmf_m1b10 = (TextView) view.findViewById(R.id.bmf_m1b10);
		bmf_m1b11 = (TextView) view.findViewById(R.id.bmf_m1b11);
		bmf_m1b12 = (TextView) view.findViewById(R.id.bmf_m1b12);
		bmf_m1b13 = (TextView) view.findViewById(R.id.bmf_m1b13);
		bmf_m1b14 = (TextView) view.findViewById(R.id.bmf_m1b14);
		bmf_m1b15 = (TextView) view.findViewById(R.id.bmf_m1b15);
		bmf_m1b16 = (TextView) view.findViewById(R.id.bmf_m1b16);
		bmf_m1b17 = (TextView) view.findViewById(R.id.bmf_m1b17);
		bmf_m1b18 = (TextView) view.findViewById(R.id.bmf_m1b18);
		bmf_m1b19 = (TextView) view.findViewById(R.id.bmf_m1b19);
		bmf_m1b20 = (TextView) view.findViewById(R.id.bmf_m1b20);
		bmf_m1b21 = (TextView) view.findViewById(R.id.bmf_m1b21);
		bmf_m1b22 = (TextView) view.findViewById(R.id.bmf_m1b22);
		bmf_m1b23 = (TextView) view.findViewById(R.id.bmf_m1b23);
		bmf_m1b24 = (TextView) view.findViewById(R.id.bmf_m1b24);
		bmf_m1b25 = (TextView) view.findViewById(R.id.bmf_m1b25);
		bmf_m1b26 = (TextView) view.findViewById(R.id.bmf_m1b26);
		bmf_m1b27 = (TextView) view.findViewById(R.id.bmf_m1b27);
		bmf_m1b28 = (TextView) view.findViewById(R.id.bmf_m1b28);
		bmf_m1b29 = (TextView) view.findViewById(R.id.bmf_m1b29);
		bmf_m1b30 = (TextView) view.findViewById(R.id.bmf_m1b30);
		bmf_m1b31 = (TextView) view.findViewById(R.id.bmf_m1b31);
		bmf_m1b32 = (TextView) view.findViewById(R.id.bmf_m1b32);

		bmf_m2b1 = (TextView) view.findViewById(R.id.bmf_m2b1);
		bmf_m2b2 = (TextView) view.findViewById(R.id.bmf_m2b2);
		bmf_m2b3 = (TextView) view.findViewById(R.id.bmf_m2b3);
		bmf_m2b4 = (TextView) view.findViewById(R.id.bmf_m2b4);
		bmf_m2b5 = (TextView) view.findViewById(R.id.bmf_m2b5);
		bmf_m2b6 = (TextView) view.findViewById(R.id.bmf_m2b6);
		bmf_m2b7 = (TextView) view.findViewById(R.id.bmf_m2b7);
		bmf_m2b8 = (TextView) view.findViewById(R.id.bmf_m2b8);
		bmf_m2b9 = (TextView) view.findViewById(R.id.bmf_m2b9);
		bmf_m2b10 = (TextView) view.findViewById(R.id.bmf_m2b10);
		bmf_m2b11 = (TextView) view.findViewById(R.id.bmf_m2b11);
		bmf_m2b12 = (TextView) view.findViewById(R.id.bmf_m2b12);
		bmf_m2b13 = (TextView) view.findViewById(R.id.bmf_m2b13);
		bmf_m2b14 = (TextView) view.findViewById(R.id.bmf_m2b14);
		bmf_m2b15 = (TextView) view.findViewById(R.id.bmf_m2b15);
		bmf_m2b16 = (TextView) view.findViewById(R.id.bmf_m2b16);
		bmf_m2b17 = (TextView) view.findViewById(R.id.bmf_m2b17);
		bmf_m2b18 = (TextView) view.findViewById(R.id.bmf_m2b18);
		bmf_m2b19 = (TextView) view.findViewById(R.id.bmf_m2b19);
		bmf_m2b20 = (TextView) view.findViewById(R.id.bmf_m2b20);
		bmf_m2b21 = (TextView) view.findViewById(R.id.bmf_m2b21);
		bmf_m2b22 = (TextView) view.findViewById(R.id.bmf_m2b22);
		bmf_m2b23 = (TextView) view.findViewById(R.id.bmf_m2b23);
		bmf_m2b24 = (TextView) view.findViewById(R.id.bmf_m2b24);
		bmf_m2b25 = (TextView) view.findViewById(R.id.bmf_m2b25);
		bmf_m2b26 = (TextView) view.findViewById(R.id.bmf_m2b26);
		bmf_m2b27 = (TextView) view.findViewById(R.id.bmf_m2b27);
		bmf_m2b28 = (TextView) view.findViewById(R.id.bmf_m2b28);
		bmf_m2b29 = (TextView) view.findViewById(R.id.bmf_m2b29);
		bmf_m2b30 = (TextView) view.findViewById(R.id.bmf_m2b30);
		bmf_m2b31 = (TextView) view.findViewById(R.id.bmf_m2b31);
		bmf_m2b32 = (TextView) view.findViewById(R.id.bmf_m2b32);

		OnTouchListener mTouchListener = new OnTouchListener() {

			@Override
			public boolean onTouch(View v, MotionEvent event) {
				if (event.getAction() == MotionEvent.ACTION_DOWN) {
					if (mPreviousUpEvent != null
							&& mCurrentDownEvent != null
							&& isConsideredDoubleTap(mCurrentDownEvent,
									mPreviousUpEvent, event)) {

						Intent intent = new Intent(view.getContext(),
								BatteryManagementActivity.class);

						view.getContext().startActivity(intent);

					}
					mCurrentDownEvent = MotionEvent.obtain(event);
				} else if (event.getAction() == MotionEvent.ACTION_UP) {
					mPreviousUpEvent = MotionEvent.obtain(event);
				}
				return true;
			}

			private boolean isConsideredDoubleTap(MotionEvent firstDown,
					MotionEvent firstUp, MotionEvent secondDown) {
				if (secondDown.getEventTime() - firstUp.getEventTime() > DOUBLE_TAP_TIMEOUT) {
					return false;
				}
				int deltaX = (int) firstUp.getX() - (int) secondDown.getX();
				int deltaY = (int) firstUp.getY() - (int) secondDown.getY();
				return deltaX * deltaX + deltaY * deltaY < 10000;
			}
		};

		view.setOnTouchListener(mTouchListener);
		// initialize();
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

		return view;
	}
}