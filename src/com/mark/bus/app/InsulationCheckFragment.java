package com.mark.bus.app;

import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.mark.bus.R;
import com.mark.bus.data.DataFromInsulation;
import com.mark.bus.data.DataHandler1;

public class InsulationCheckFragment extends Fragment {
	private View view;
	private TextView tv_jueyuanzuzhi;
	private TextView tv_jueyuanjiance;
	private TextView tv_jueyuanjianceyizhuangtai;
	private boolean isStop = false;
	static Handler mHandler;	
	
	@Override
	public void onPause() {

		isStop=true;
		super.onPause();
	}
	public void initialize() {
		DataFromInsulation di = DataHandler1.di;
		tv_jueyuanzuzhi = (TextView) view.findViewById(R.id.ic_jueyuandianzu);
		tv_jueyuanzuzhi.setText((CharSequence) Integer
				.toString(di.jueyuandianzuzhi));
		tv_jueyuanjiance = (TextView) view.findViewById(R.id.ic_jueyuanjiance);
		if (di.jueyuanjinggao == 0) {
			tv_jueyuanjiance.setText((CharSequence) this.getResources()
					.getString(R.string.insulationwarning01));
		} else if (di.jueyuanjinggao == 1) {
			tv_jueyuanjiance.setText((CharSequence) this.getResources()
					.getString(R.string.insulationwarning02));
		} else if (di.jueyuanjinggao == 2) {
			tv_jueyuanjiance.setText((CharSequence) this.getResources()
					.getString(R.string.insulationwarning03));
		}
		tv_jueyuanjianceyizhuangtai = (TextView) view
				.findViewById(R.id.ic_jueyuanjianceyizhuangtai);
		if (di.jueyuanjianceyizhuangtai == 1)
			tv_jueyuanjianceyizhuangtai.setText(this.getResources().getString(
					R.string.insulationstatus01));
		else if (di.jueyuanjianceyizhuangtai == 2)
			tv_jueyuanjianceyizhuangtai.setText(this.getResources().getString(
					R.string.insulationstatus02));
		else if (di.jueyuanjianceyizhuangtai == 4)
			tv_jueyuanjianceyizhuangtai.setText(this.getResources().getString(
					R.string.insulationstatus03));
		else if (di.jueyuanjianceyizhuangtai == 5)
			tv_jueyuanjianceyizhuangtai.setText(this.getResources().getString(
					R.string.insulationstatus04));

		else if (di.jueyuanjianceyizhuangtai == 6)
			tv_jueyuanjianceyizhuangtai.setText(this.getResources().getString(
					R.string.insulationstatus05));

		else if (di.jueyuanjianceyizhuangtai == 7)
			tv_jueyuanjianceyizhuangtai.setText(this.getResources().getString(
					R.string.insulationstatus06));
	}

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {

		view = inflater.inflate(R.layout.insulation_check_fragment, container,
				false);
		//initialize();
		new Thread(){
	    	@Override
	    	public void run(){
	    		 while(!isStop){
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
	    
	    mHandler = new Handler() {
			@Override
	    	public void handleMessage(Message msg) {
	    		super.handleMessage(msg);
	    		initialize();
	    	}
	    };
		return view;
	}
}