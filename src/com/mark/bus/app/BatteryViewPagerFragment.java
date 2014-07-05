package com.mark.bus.app;

import java.text.DecimalFormat;

import com.mark.bus.R;
import com.mark.bus.data.DataHandler1;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

@SuppressLint("ValidFragment")
public class BatteryViewPagerFragment extends Fragment {

	private TextView mokuai1;
	private TextView mokuai2;
	private TextView mokuai3;
	private TextView mokuai4;
	private TextView mokuai5;
	private TextView mokuai6;

	private TextView bma_m1_high_temperature;
	private TextView bma_m2_high_temperature;
	private TextView bma_m3_high_temperature;
	private TextView bma_m4_high_temperature;
	private TextView bma_m5_high_temperature;
	private TextView bma_m6_high_temperature;

	private TextView bma_m1_low_temperature;
	private TextView bma_m2_low_temperature;
	private TextView bma_m3_low_temperature;
	private TextView bma_m4_low_temperature;
	private TextView bma_m5_low_temperature;
	private TextView bma_m6_low_temperature;

	private TextView bma_m1_count;
	private TextView bma_m2_count;
	private TextView bma_m3_count;
	private TextView bma_m4_count;
	private TextView bma_m5_count;
	private TextView bma_m6_count;

	private TextView m1b1;
	private TextView m1b2;
	private TextView m1b3;
	private TextView m1b4;
	private TextView m1b5;
	private TextView m1b6;
	private TextView m1b7;
	private TextView m1b8;
	private TextView m1b9;
	private TextView m1b10;
	private TextView m1b11;
	private TextView m1b12;
	private TextView m1b13;
	private TextView m1b14;
	private TextView m1b15;
	private TextView m1b16;
	private TextView m1b17;
	private TextView m1b18;
	private TextView m1b19;
	private TextView m1b20;
	private TextView m1b21;
	private TextView m1b22;
	private TextView m1b23;
	private TextView m1b24;
	private TextView m1b25;
	private TextView m1b26;
	private TextView m1b27;
	private TextView m1b28;
	private TextView m1b29;
	private TextView m1b30;
	private TextView m1b31;
	private TextView m1b32;

	private TextView m2b1;
	private TextView m2b2;
	private TextView m2b3;
	private TextView m2b4;
	private TextView m2b5;
	private TextView m2b6;
	private TextView m2b7;
	private TextView m2b8;
	private TextView m2b9;
	private TextView m2b10;
	private TextView m2b11;
	private TextView m2b12;
	private TextView m2b13;
	private TextView m2b14;
	private TextView m2b15;
	private TextView m2b16;
	private TextView m2b17;
	private TextView m2b18;
	private TextView m2b19;
	private TextView m2b20;
	private TextView m2b21;
	private TextView m2b22;
	private TextView m2b23;
	private TextView m2b24;
	private TextView m2b25;
	private TextView m2b26;
	private TextView m2b27;
	private TextView m2b28;
	private TextView m2b29;
	private TextView m2b30;
	private TextView m2b31;
	private TextView m2b32;

	private TextView m3b1;
	private TextView m3b2;
	private TextView m3b3;
	private TextView m3b4;
	private TextView m3b5;
	private TextView m3b6;
	private TextView m3b7;
	private TextView m3b8;
	private TextView m3b9;
	private TextView m3b10;
	private TextView m3b11;
	private TextView m3b12;
	private TextView m3b13;
	private TextView m3b14;
	private TextView m3b15;
	private TextView m3b16;
	private TextView m3b17;
	private TextView m3b18;
	private TextView m3b19;
	private TextView m3b20;
	private TextView m3b21;
	private TextView m3b22;
	private TextView m3b23;
	private TextView m3b24;
	private TextView m3b25;
	private TextView m3b26;
	private TextView m3b27;
	private TextView m3b28;
	private TextView m3b29;
	private TextView m3b30;
	private TextView m3b31;
	private TextView m3b32;

	private TextView m4b1;
	private TextView m4b2;
	private TextView m4b3;
	private TextView m4b4;
	private TextView m4b5;
	private TextView m4b6;
	private TextView m4b7;
	private TextView m4b8;
	private TextView m4b9;
	private TextView m4b10;
	private TextView m4b11;
	private TextView m4b12;
	private TextView m4b13;
	private TextView m4b14;
	private TextView m4b15;
	private TextView m4b16;
	private TextView m4b17;
	private TextView m4b18;
	private TextView m4b19;
	private TextView m4b20;
	private TextView m4b21;
	private TextView m4b22;
	private TextView m4b23;
	private TextView m4b24;
	private TextView m4b25;
	private TextView m4b26;
	private TextView m4b27;
	private TextView m4b28;
	private TextView m4b29;
	private TextView m4b30;
	private TextView m4b31;
	private TextView m4b32;

	private TextView m5b1;
	private TextView m5b2;
	private TextView m5b3;
	private TextView m5b4;
	private TextView m5b5;
	private TextView m5b6;
	private TextView m5b7;
	private TextView m5b8;
	private TextView m5b9;
	private TextView m5b10;
	private TextView m5b11;
	private TextView m5b12;
	private TextView m5b13;
	private TextView m5b14;
	private TextView m5b15;
	private TextView m5b16;
	private TextView m5b17;
	private TextView m5b18;
	private TextView m5b19;
	private TextView m5b20;
	private TextView m5b21;
	private TextView m5b22;
	private TextView m5b23;
	private TextView m5b24;
	private TextView m5b25;
	private TextView m5b26;
	private TextView m5b27;
	private TextView m5b28;
	private TextView m5b29;
	private TextView m5b30;
	private TextView m5b31;
	private TextView m5b32;
	private TextView m6b1;
	private TextView m6b2;
	private TextView m6b3;
	private TextView m6b4;
	private TextView m6b5;
	private TextView m6b6;
	private TextView m6b7;
	private TextView m6b8;
	private TextView m6b9;
	private TextView m6b10;
	private TextView m6b11;
	private TextView m6b12;
	private TextView m6b13;
	private TextView m6b14;
	private TextView m6b15;
	private TextView m6b16;
	private TextView m6b17;
	private TextView m6b18;
	private TextView m6b19;
	private TextView m6b20;
	private TextView m6b21;
	private TextView m6b22;
	private TextView m6b23;
	private TextView m6b24;
	private TextView m6b25;
	private TextView m6b26;
	private TextView m6b27;
	private TextView m6b28;
	private TextView m6b29;
	private TextView m6b30;
	private TextView m6b31;
	private TextView m6b32;

	private int beginModule;

	// private TextView tv = null;

	@SuppressLint("ValidFragment")
	public BatteryViewPagerFragment(int beginModule) {

		super();
		this.beginModule = beginModule;

	}

	/**
	 * 
	 * 覆盖此函数，先通过inflater inflate函数得到view最后返回
	 */

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {

		View view = inflater.inflate(R.layout.view_pager_fragment_demo1,
				container, false);

		// tv = (TextView) v.findViewById(R.id.viewPagerText);

		// tv.setText(text);

		mokuai1 = (TextView) view.findViewById(R.id.mokuai1);
		mokuai2 = (TextView) view.findViewById(R.id.mokuai2);
		mokuai3 = (TextView) view.findViewById(R.id.mokuai3);
		mokuai4 = (TextView) view.findViewById(R.id.mokuai4);
		mokuai5 = (TextView) view.findViewById(R.id.mokuai5);
		mokuai6 = (TextView) view.findViewById(R.id.mokuai6);
		bma_m1_high_temperature = (TextView) view
				.findViewById(R.id.bma_m1_high_temperature);
		bma_m2_high_temperature = (TextView) view
				.findViewById(R.id.bma_m2_high_temperature);
		bma_m3_high_temperature = (TextView) view
				.findViewById(R.id.bma_m3_high_temperature);
		bma_m4_high_temperature = (TextView) view
				.findViewById(R.id.bma_m4_high_temperature);
		bma_m5_high_temperature = (TextView) view
				.findViewById(R.id.bma_m5_high_temperature);
		bma_m6_high_temperature = (TextView) view
				.findViewById(R.id.bma_m6_high_temperature);
		bma_m1_low_temperature = (TextView) view
				.findViewById(R.id.bma_m1_low_temperature);
		bma_m2_low_temperature = (TextView) view
				.findViewById(R.id.bma_m2_low_temperature);
		bma_m3_low_temperature = (TextView) view
				.findViewById(R.id.bma_m3_low_temperature);
		bma_m4_low_temperature = (TextView) view
				.findViewById(R.id.bma_m4_low_temperature);
		bma_m5_low_temperature = (TextView) view
				.findViewById(R.id.bma_m5_low_temperature);
		bma_m6_low_temperature = (TextView) view
				.findViewById(R.id.bma_m6_low_temperature);
		bma_m1_count = (TextView) view.findViewById(R.id.bma_m1_count);
		bma_m2_count = (TextView) view.findViewById(R.id.bma_m2_count);
		bma_m3_count = (TextView) view.findViewById(R.id.bma_m3_count);
		bma_m4_count = (TextView) view.findViewById(R.id.bma_m4_count);
		bma_m5_count = (TextView) view.findViewById(R.id.bma_m5_count);
		bma_m6_count = (TextView) view.findViewById(R.id.bma_m6_count);
		m1b1 = (TextView) view.findViewById(R.id.m1b1);
		m1b2 = (TextView) view.findViewById(R.id.m1b2);
		m1b3 = (TextView) view.findViewById(R.id.m1b3);
		m1b4 = (TextView) view.findViewById(R.id.m1b4);
		m1b5 = (TextView) view.findViewById(R.id.m1b5);
		m1b6 = (TextView) view.findViewById(R.id.m1b6);
		m1b7 = (TextView) view.findViewById(R.id.m1b7);
		m1b8 = (TextView) view.findViewById(R.id.m1b8);
		m1b9 = (TextView) view.findViewById(R.id.m1b9);
		m1b10 = (TextView) view.findViewById(R.id.m1b10);
		m1b11 = (TextView) view.findViewById(R.id.m1b11);
		m1b12 = (TextView) view.findViewById(R.id.m1b12);
		m1b13 = (TextView) view.findViewById(R.id.m1b13);
		m1b14 = (TextView) view.findViewById(R.id.m1b14);
		m1b15 = (TextView) view.findViewById(R.id.m1b15);
		m1b16 = (TextView) view.findViewById(R.id.m1b16);
		m1b17 = (TextView) view.findViewById(R.id.m1b17);
		m1b18 = (TextView) view.findViewById(R.id.m1b18);
		m1b19 = (TextView) view.findViewById(R.id.m1b19);
		m1b20 = (TextView) view.findViewById(R.id.m1b20);
		m1b21 = (TextView) view.findViewById(R.id.m1b21);
		m1b22 = (TextView) view.findViewById(R.id.m1b22);
		m1b23 = (TextView) view.findViewById(R.id.m1b23);
		m1b24 = (TextView) view.findViewById(R.id.m1b24);
		m1b25 = (TextView) view.findViewById(R.id.m1b25);
		m1b26 = (TextView) view.findViewById(R.id.m1b26);
		m1b27 = (TextView) view.findViewById(R.id.m1b27);
		m1b28 = (TextView) view.findViewById(R.id.m1b28);
		m1b29 = (TextView) view.findViewById(R.id.m1b29);
		m1b30 = (TextView) view.findViewById(R.id.m1b30);
		m1b31 = (TextView) view.findViewById(R.id.m1b31);
		m1b32 = (TextView) view.findViewById(R.id.m1b32);

		m2b1 = (TextView) view.findViewById(R.id.m2b1);
		m2b2 = (TextView) view.findViewById(R.id.m2b2);
		m2b3 = (TextView) view.findViewById(R.id.m2b3);
		m2b4 = (TextView) view.findViewById(R.id.m2b4);
		m2b5 = (TextView) view.findViewById(R.id.m2b5);
		m2b6 = (TextView) view.findViewById(R.id.m2b6);
		m2b7 = (TextView) view.findViewById(R.id.m2b7);
		m2b8 = (TextView) view.findViewById(R.id.m2b8);
		m2b9 = (TextView) view.findViewById(R.id.m2b9);
		m2b10 = (TextView) view.findViewById(R.id.m2b10);
		m2b11 = (TextView) view.findViewById(R.id.m2b11);
		m2b12 = (TextView) view.findViewById(R.id.m2b12);
		m2b13 = (TextView) view.findViewById(R.id.m2b13);
		m2b14 = (TextView) view.findViewById(R.id.m2b14);
		m2b15 = (TextView) view.findViewById(R.id.m2b15);
		m2b16 = (TextView) view.findViewById(R.id.m2b16);
		m2b17 = (TextView) view.findViewById(R.id.m2b17);
		m2b18 = (TextView) view.findViewById(R.id.m2b18);
		m2b19 = (TextView) view.findViewById(R.id.m2b19);
		m2b20 = (TextView) view.findViewById(R.id.m2b20);
		m2b21 = (TextView) view.findViewById(R.id.m2b21);
		m2b22 = (TextView) view.findViewById(R.id.m2b22);
		m2b23 = (TextView) view.findViewById(R.id.m2b23);
		m2b24 = (TextView) view.findViewById(R.id.m2b24);
		m2b25 = (TextView) view.findViewById(R.id.m2b25);
		m2b26 = (TextView) view.findViewById(R.id.m2b26);
		m2b27 = (TextView) view.findViewById(R.id.m2b27);
		m2b28 = (TextView) view.findViewById(R.id.m2b28);
		m2b29 = (TextView) view.findViewById(R.id.m2b29);
		m2b30 = (TextView) view.findViewById(R.id.m2b30);
		m2b31 = (TextView) view.findViewById(R.id.m2b31);
		m2b32 = (TextView) view.findViewById(R.id.m2b32);
		m3b1 = (TextView) view.findViewById(R.id.m3b1);
		m3b2 = (TextView) view.findViewById(R.id.m3b2);
		m3b3 = (TextView) view.findViewById(R.id.m3b3);
		m3b4 = (TextView) view.findViewById(R.id.m3b4);
		m3b5 = (TextView) view.findViewById(R.id.m3b5);
		m3b6 = (TextView) view.findViewById(R.id.m3b6);
		m3b7 = (TextView) view.findViewById(R.id.m3b7);
		m3b8 = (TextView) view.findViewById(R.id.m3b8);
		m3b9 = (TextView) view.findViewById(R.id.m3b9);
		m3b10 = (TextView) view.findViewById(R.id.m3b10);
		m3b11 = (TextView) view.findViewById(R.id.m3b11);
		m3b12 = (TextView) view.findViewById(R.id.m3b12);
		m3b13 = (TextView) view.findViewById(R.id.m3b13);
		m3b14 = (TextView) view.findViewById(R.id.m3b14);
		m3b15 = (TextView) view.findViewById(R.id.m3b15);
		m3b16 = (TextView) view.findViewById(R.id.m3b16);
		m3b17 = (TextView) view.findViewById(R.id.m3b17);
		m3b18 = (TextView) view.findViewById(R.id.m3b18);
		m3b19 = (TextView) view.findViewById(R.id.m3b19);
		m3b20 = (TextView) view.findViewById(R.id.m3b20);
		m3b21 = (TextView) view.findViewById(R.id.m3b21);
		m3b22 = (TextView) view.findViewById(R.id.m3b22);
		m3b23 = (TextView) view.findViewById(R.id.m3b23);
		m3b24 = (TextView) view.findViewById(R.id.m3b24);
		m3b25 = (TextView) view.findViewById(R.id.m3b25);
		m3b26 = (TextView) view.findViewById(R.id.m3b26);
		m3b27 = (TextView) view.findViewById(R.id.m3b27);
		m3b28 = (TextView) view.findViewById(R.id.m3b28);
		m3b29 = (TextView) view.findViewById(R.id.m3b29);
		m3b30 = (TextView) view.findViewById(R.id.m3b30);
		m3b31 = (TextView) view.findViewById(R.id.m3b31);
		m3b32 = (TextView) view.findViewById(R.id.m3b32);
		m4b1 = (TextView) view.findViewById(R.id.m4b1);
		m4b2 = (TextView) view.findViewById(R.id.m4b2);
		m4b3 = (TextView) view.findViewById(R.id.m4b3);
		m4b4 = (TextView) view.findViewById(R.id.m4b4);
		m4b5 = (TextView) view.findViewById(R.id.m4b5);
		m4b6 = (TextView) view.findViewById(R.id.m4b6);
		m4b7 = (TextView) view.findViewById(R.id.m4b7);
		m4b8 = (TextView) view.findViewById(R.id.m4b8);
		m4b9 = (TextView) view.findViewById(R.id.m4b9);
		m4b10 = (TextView) view.findViewById(R.id.m4b10);
		m4b11 = (TextView) view.findViewById(R.id.m4b11);
		m4b12 = (TextView) view.findViewById(R.id.m4b12);
		m4b13 = (TextView) view.findViewById(R.id.m4b13);
		m4b14 = (TextView) view.findViewById(R.id.m4b14);
		m4b15 = (TextView) view.findViewById(R.id.m4b15);
		m4b16 = (TextView) view.findViewById(R.id.m4b16);
		m4b17 = (TextView) view.findViewById(R.id.m4b17);
		m4b18 = (TextView) view.findViewById(R.id.m4b18);
		m4b19 = (TextView) view.findViewById(R.id.m4b19);
		m4b20 = (TextView) view.findViewById(R.id.m4b20);
		m4b21 = (TextView) view.findViewById(R.id.m4b21);
		m4b22 = (TextView) view.findViewById(R.id.m4b22);
		m4b23 = (TextView) view.findViewById(R.id.m4b23);
		m4b24 = (TextView) view.findViewById(R.id.m4b24);
		m4b25 = (TextView) view.findViewById(R.id.m4b25);
		m4b26 = (TextView) view.findViewById(R.id.m4b26);
		m4b27 = (TextView) view.findViewById(R.id.m4b27);
		m4b28 = (TextView) view.findViewById(R.id.m4b28);
		m4b29 = (TextView) view.findViewById(R.id.m4b29);
		m4b30 = (TextView) view.findViewById(R.id.m4b30);
		m4b31 = (TextView) view.findViewById(R.id.m4b31);
		m4b32 = (TextView) view.findViewById(R.id.m4b32);

		m5b1 = (TextView) view.findViewById(R.id.m5b1);
		m5b2 = (TextView) view.findViewById(R.id.m5b2);
		m5b3 = (TextView) view.findViewById(R.id.m5b3);
		m5b4 = (TextView) view.findViewById(R.id.m5b4);
		m5b5 = (TextView) view.findViewById(R.id.m5b5);
		m5b6 = (TextView) view.findViewById(R.id.m5b6);
		m5b7 = (TextView) view.findViewById(R.id.m5b7);
		m5b8 = (TextView) view.findViewById(R.id.m5b8);
		m5b9 = (TextView) view.findViewById(R.id.m5b9);
		m5b10 = (TextView) view.findViewById(R.id.m5b10);
		m5b11 = (TextView) view.findViewById(R.id.m5b11);
		m5b12 = (TextView) view.findViewById(R.id.m5b12);
		m5b13 = (TextView) view.findViewById(R.id.m5b13);
		m5b14 = (TextView) view.findViewById(R.id.m5b14);
		m5b15 = (TextView) view.findViewById(R.id.m5b15);
		m5b16 = (TextView) view.findViewById(R.id.m5b16);
		m5b17 = (TextView) view.findViewById(R.id.m5b17);
		m5b18 = (TextView) view.findViewById(R.id.m5b18);
		m5b19 = (TextView) view.findViewById(R.id.m5b19);
		m5b20 = (TextView) view.findViewById(R.id.m5b20);
		m5b21 = (TextView) view.findViewById(R.id.m5b21);
		m5b22 = (TextView) view.findViewById(R.id.m5b22);
		m5b23 = (TextView) view.findViewById(R.id.m5b23);
		m5b24 = (TextView) view.findViewById(R.id.m5b24);
		m5b25 = (TextView) view.findViewById(R.id.m5b25);
		m5b26 = (TextView) view.findViewById(R.id.m5b26);
		m5b27 = (TextView) view.findViewById(R.id.m5b27);
		m5b28 = (TextView) view.findViewById(R.id.m5b28);
		m5b29 = (TextView) view.findViewById(R.id.m5b29);
		m5b30 = (TextView) view.findViewById(R.id.m5b30);
		m5b31 = (TextView) view.findViewById(R.id.m5b31);
		m5b32 = (TextView) view.findViewById(R.id.m5b32);
		m6b1 = (TextView) view.findViewById(R.id.m6b1);
		m6b2 = (TextView) view.findViewById(R.id.m6b2);
		m6b3 = (TextView) view.findViewById(R.id.m6b3);
		m6b4 = (TextView) view.findViewById(R.id.m6b4);
		m6b5 = (TextView) view.findViewById(R.id.m6b5);
		m6b6 = (TextView) view.findViewById(R.id.m6b6);
		m6b7 = (TextView) view.findViewById(R.id.m6b7);
		m6b8 = (TextView) view.findViewById(R.id.m6b8);
		m6b9 = (TextView) view.findViewById(R.id.m6b9);
		m6b10 = (TextView) view.findViewById(R.id.m6b10);
		m6b11 = (TextView) view.findViewById(R.id.m6b11);
		m6b12 = (TextView) view.findViewById(R.id.m6b12);
		m6b13 = (TextView) view.findViewById(R.id.m6b13);
		m6b14 = (TextView) view.findViewById(R.id.m6b14);
		m6b15 = (TextView) view.findViewById(R.id.m6b15);
		m6b16 = (TextView) view.findViewById(R.id.m6b16);
		m6b17 = (TextView) view.findViewById(R.id.m6b17);
		m6b18 = (TextView) view.findViewById(R.id.m6b18);
		m6b19 = (TextView) view.findViewById(R.id.m6b19);
		m6b20 = (TextView) view.findViewById(R.id.m6b20);
		m6b21 = (TextView) view.findViewById(R.id.m6b21);
		m6b22 = (TextView) view.findViewById(R.id.m6b22);
		m6b23 = (TextView) view.findViewById(R.id.m6b23);
		m6b24 = (TextView) view.findViewById(R.id.m6b24);
		m6b25 = (TextView) view.findViewById(R.id.m6b25);
		m6b26 = (TextView) view.findViewById(R.id.m6b26);
		m6b27 = (TextView) view.findViewById(R.id.m6b27);
		m6b28 = (TextView) view.findViewById(R.id.m6b28);
		m6b29 = (TextView) view.findViewById(R.id.m6b29);
		m6b30 = (TextView) view.findViewById(R.id.m6b30);
		m6b31 = (TextView) view.findViewById(R.id.m6b31);
		m6b32 = (TextView) view.findViewById(R.id.m6b32);
		initialize();
		return view;

	}

	public void initialize() {
		mokuai1.setText("模块" + new Integer(beginModule * 6 + 1).toString());
		mokuai2.setText("模块" + new Integer(beginModule * 6 + 2).toString());
		mokuai3.setText("模块" + new Integer(beginModule * 6 + 3).toString());
		mokuai4.setText("模块" + new Integer(beginModule * 6 + 4).toString());
		mokuai5.setText("模块" + new Integer(beginModule * 6 + 5).toString());
		mokuai6.setText("模块" + new Integer(beginModule * 6 + 6).toString());

		bma_m1_high_temperature
				.setText(new Integer(
						DataHandler1.dfcb.batteryModuleHighTemperature[beginModule * 6])
						.toString()
						+ "℃");
		bma_m2_high_temperature
				.setText(new Integer(
						DataHandler1.dfcb.batteryModuleHighTemperature[beginModule * 6 + 1])
						.toString()
						+ "℃");
		bma_m3_high_temperature
				.setText(new Integer(
						DataHandler1.dfcb.batteryModuleHighTemperature[beginModule * 6 + 2])
						.toString()
						+ "℃");
		bma_m4_high_temperature
				.setText(new Integer(
						DataHandler1.dfcb.batteryModuleHighTemperature[beginModule * 6 + 3])
						.toString()
						+ "℃");
		bma_m5_high_temperature
				.setText(new Integer(
						DataHandler1.dfcb.batteryModuleHighTemperature[beginModule * 6 + 4])
						.toString()
						+ "℃");
		bma_m6_high_temperature
				.setText(new Integer(
						DataHandler1.dfcb.batteryModuleHighTemperature[beginModule * 6 + 5])
						.toString()
						+ "℃");

		bma_m1_low_temperature.setText(new Integer(
				DataHandler1.dfcb.batteryModuleLowTemperature[beginModule * 6])
				.toString()
				+ "℃");
		bma_m2_low_temperature
				.setText(new Integer(
						DataHandler1.dfcb.batteryModuleLowTemperature[beginModule * 6 + 1])
						.toString()
						+ "℃");
		bma_m3_low_temperature
				.setText(new Integer(
						DataHandler1.dfcb.batteryModuleLowTemperature[beginModule * 6 + 2])
						.toString()
						+ "℃");
		bma_m4_low_temperature
				.setText(new Integer(
						DataHandler1.dfcb.batteryModuleLowTemperature[beginModule * 6 + 3])
						.toString()
						+ "℃");
		bma_m5_low_temperature
				.setText(new Integer(
						DataHandler1.dfcb.batteryModuleLowTemperature[beginModule * 6 + 4])
						.toString()
						+ "℃");
		bma_m6_low_temperature
				.setText(new Integer(
						DataHandler1.dfcb.batteryModuleLowTemperature[beginModule * 6 + 5])
						.toString()
						+ "℃");
		bma_m1_count.setText(new Integer(
				DataHandler1.dfcb.batteryMonomerNumbers[beginModule * 6])
				.toString()
				+ "支");
		bma_m2_count.setText(new Integer(
				DataHandler1.dfcb.batteryMonomerNumbers[beginModule * 6 + 1])
				.toString()
				+ "支");
		bma_m3_count.setText(new Integer(
				DataHandler1.dfcb.batteryMonomerNumbers[beginModule * 6 + 2])
				.toString()
				+ "支");
		bma_m4_count.setText(new Integer(
				DataHandler1.dfcb.batteryMonomerNumbers[beginModule * 6 + 3])
				.toString()
				+ "支");
		bma_m5_count.setText(new Integer(
				DataHandler1.dfcb.batteryMonomerNumbers[beginModule * 6 + 4])
				.toString()
				+ "支");
		bma_m6_count.setText(new Integer(
				DataHandler1.dfcb.batteryMonomerNumbers[beginModule * 6 + 5])
				.toString()
				+ "支");
		TextView[] texts = { m1b1, m1b2, m1b3, m1b4, m1b5, m1b6, m1b7, m1b8,
				m1b9, m1b10, m1b11, m1b12, m1b13, m1b14, m1b15, m1b16, m1b17,
				m1b18, m1b19, m1b20, m1b21, m1b22, m1b23, m1b24, m1b25, m1b26,
				m1b27, m1b28, m1b29, m1b30, m1b31, m1b32, m2b1, m2b2, m2b3,
				m2b4, m2b5, m2b6, m2b7, m2b8, m2b9, m2b10, m2b11, m2b12, m2b13,
				m2b14, m2b15, m2b16, m2b17, m2b18, m2b19, m2b20, m2b21, m2b22,
				m2b23, m2b24, m2b25, m2b26, m2b27, m2b28, m2b29, m2b30, m2b31,
				m2b32, m3b1, m3b2, m3b3, m3b4, m3b5, m3b6, m3b7, m3b8, m3b9,
				m3b10, m3b11, m3b12, m3b13, m3b14, m3b15, m3b16, m3b17, m3b18,
				m3b19, m3b20, m3b21, m3b22, m3b23, m3b24, m3b25, m3b26, m3b27,
				m3b28, m3b29, m3b30, m3b31, m3b32, m4b1, m4b2, m4b3, m4b4,
				m4b5, m4b6, m4b7, m4b8, m4b9, m4b10, m4b11, m4b12, m4b13,
				m4b14, m4b15, m4b16, m4b17, m4b18, m4b19, m4b20, m4b21, m4b22,
				m4b23, m4b24, m4b25, m4b26, m4b27, m4b28, m4b29, m4b30, m4b31,
				m4b32, m5b1, m5b2, m5b3, m5b4, m5b5, m5b6, m5b7, m5b8, m5b9,
				m5b10, m5b11, m5b12, m5b13, m5b14, m5b15, m5b16, m5b17, m5b18,
				m5b19, m5b20, m5b21, m5b22, m5b23, m5b24, m5b25, m5b26, m5b27,
				m5b28, m5b29, m5b30, m5b31, m5b32, m6b1, m6b2, m6b3, m6b4,
				m6b5, m6b6, m6b7, m6b8, m6b9, m6b10, m6b11, m6b12, m6b13,
				m6b14, m6b15, m6b16, m6b17, m6b18, m6b19, m6b20, m6b21, m6b22,
				m6b23, m6b24, m6b25, m6b26, m6b27, m6b28, m6b29, m6b30, m6b31,
				m6b32 };
		DecimalFormat df = new DecimalFormat();
		String style = "00.00 V";
		df.applyPattern(style);

		for (int i = 0; i < texts.length; i++) {
			int beginIndex = 0;
			int currentModule = (i / 32) + beginModule * 6;
			
			for (int j = 0; j < currentModule; j++) {
				beginIndex += DataHandler1.dfcb.batteryMonomerNumbers[j];
			}
			
		
			if ((i % 32) > DataHandler1.dfcb.batteryMonomerNumbers[currentModule]-1) {
				texts[i].setText("00.00 V");
			} else {
				Float f = DataHandler1.dfcb.batteryMonomerVoltages[beginIndex
						+ i%32 ] / 1000f;
				texts[i].setText(df.format(f));
			}
		}
	}
}