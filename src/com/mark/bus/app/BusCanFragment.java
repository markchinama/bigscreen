package com.mark.bus.app;

import android.support.v4.app.Fragment;
import android.R.raw;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.View.OnTouchListener;
import android.widget.ImageView;

import com.mark.bus.R;
import com.mark.bus.data.DataFromBusCanModule;
import com.mark.bus.data.DataHandler1;

public class BusCanFragment extends Fragment {
	private final int DOUBLE_TAP_TIMEOUT = 200;
	private MotionEvent mCurrentDownEvent;
	private MotionEvent mPreviousUpEvent;
	private View view;

	private ImageView iv_qianmentabudeng;
	private ImageView iv_zuoxinglicangzhaomingdeng;
	private ImageView iv_houwudeng;
	private ImageView iv_yuanguangdeng;
	private ImageView iv_youxinglicangzhaomingdeng;
	private ImageView iv_zhidongdeng;
	private ImageView iv_qianwudeng;
	private ImageView iv_zhongmentabudeng;
	private ImageView iv_daochedeng;
	private ImageView iv_jinguangdeng;
	private ImageView iv_weishengjianyourenzhishideng;
	private ImageView iv_gaoyacangdeng;
	private ImageView iv_qianmenkaidiancifa;
	private ImageView iv_dianshijidianyuan;
	private ImageView iv_qidongjidianqi;
	private ImageView iv_qianmenguandiancifa;
	private ImageView iv_zhongmenguanmendiancifa;
	private ImageView iv_weishengjianqiangzhipaiwufa;
	private ImageView iv_penshuidianji;
	private ImageView iv_zhongmenkaimendiancifa;
	private ImageView iv_nuanshuidiancifa;
	private ImageView iv_qilaba;
	private ImageView iv_lupaideng;
	private ImageView iv_lupaidianyuan;
	private boolean isStop = false;
	UIHandler mHandler = new UIHandler();

	@Override
	public void onPause() {

		isStop = true;
		super.onPause();
	}

	public void initialize() {
		DataFromBusCanModule dbcm = DataHandler1.dbcm;
		if (dbcm.qianmentabudeng == 0)
			iv_qianmentabudeng.setBackgroundResource(R.drawable.offstatus);
		else
			iv_qianmentabudeng.setBackgroundResource(R.drawable.onstatus);
		if (dbcm.zuoxinglicangzhaomingdeng == 0)
			iv_zuoxinglicangzhaomingdeng
					.setBackgroundResource(R.drawable.offstatus);
		else
			iv_zuoxinglicangzhaomingdeng
					.setBackgroundResource(R.drawable.onstatus);

		System.out.println("###############################" + dbcm.houwudeng);
		if (dbcm.houwudeng == 0)
			iv_houwudeng.setBackgroundResource(R.drawable.offstatus);
		else
			iv_houwudeng.setBackgroundResource(R.drawable.onstatus);

		if (dbcm.yuanguangdeng == 0)
			iv_yuanguangdeng.setBackgroundResource(R.drawable.offstatus);
		else
			iv_yuanguangdeng.setBackgroundResource(R.drawable.onstatus);
		if (dbcm.youxinglicangzhaomingdeng == 0)
			iv_youxinglicangzhaomingdeng
					.setBackgroundResource(R.drawable.offstatus);
		else
			iv_youxinglicangzhaomingdeng
					.setBackgroundResource(R.drawable.onstatus);
		if (dbcm.zhidongdeng == 0)
			iv_zhidongdeng.setBackgroundResource(R.drawable.offstatus);
		else
			iv_zhidongdeng.setBackgroundResource(R.drawable.onstatus);
		if (dbcm.zhongmentabudeng == 0)
			iv_zhongmentabudeng.setBackgroundResource(R.drawable.offstatus);
		else
			iv_zhongmentabudeng.setBackgroundResource(R.drawable.onstatus);
		if (dbcm.daochedeng == 0)
			iv_daochedeng.setBackgroundResource(R.drawable.offstatus);
		else
			iv_daochedeng.setBackgroundResource(R.drawable.onstatus);
		if (dbcm.jinguangdeng == 0)
			iv_jinguangdeng.setBackgroundResource(R.drawable.offstatus);
		else
			iv_jinguangdeng.setBackgroundResource(R.drawable.onstatus);
		if (dbcm.weishengjianyourenzhishideng == 0)
			iv_weishengjianyourenzhishideng
					.setBackgroundResource(R.drawable.offstatus);
		else
			iv_weishengjianyourenzhishideng
					.setBackgroundResource(R.drawable.onstatus);

		if (dbcm.dianshijidianyuan == 0)
			iv_dianshijidianyuan.setBackgroundResource(R.drawable.offstatus);
		else
			iv_dianshijidianyuan.setBackgroundResource(R.drawable.onstatus);
		if (dbcm.dianshijidianyuan == 0)
			iv_dianshijidianyuan.setBackgroundResource(R.drawable.offstatus);
		else
			iv_dianshijidianyuan.setBackgroundResource(R.drawable.onstatus);
		if (dbcm.qidongjidianqi == 0)
			iv_qidongjidianqi.setBackgroundResource(R.drawable.offstatus);
		else
			iv_qidongjidianqi.setBackgroundResource(R.drawable.onstatus);
		if (dbcm.zhongmenguanmendiancifa == 0)
			iv_zhongmenguanmendiancifa
					.setBackgroundResource(R.drawable.offstatus);
		else
			iv_zhongmenguanmendiancifa
					.setBackgroundResource(R.drawable.onstatus);
		if (dbcm.weishengjianqiangzhipaiwu == 0)
			iv_weishengjianqiangzhipaiwufa
					.setBackgroundResource(R.drawable.offstatus);
		else
			iv_weishengjianqiangzhipaiwufa
					.setBackgroundResource(R.drawable.onstatus);

		if (dbcm.penshuidianji == 0)
			iv_penshuidianji.setBackgroundResource(R.drawable.offstatus);
		else
			iv_penshuidianji.setBackgroundResource(R.drawable.onstatus);

		if (dbcm.zhongmenguanmendiancifa == 0)
			iv_zhongmenkaimendiancifa
					.setBackgroundResource(R.drawable.offstatus);
		else
			iv_zhongmenkaimendiancifa
					.setBackgroundResource(R.drawable.onstatus);

	}

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {

		view = inflater.inflate(R.layout.bus_can_fragment, container, false);

		OnTouchListener mTouchListener = new OnTouchListener() {

			@Override
			public boolean onTouch(View v, MotionEvent event) {
				if (event.getAction() == MotionEvent.ACTION_DOWN) {
					if (mPreviousUpEvent != null
							&& mCurrentDownEvent != null
							&& isConsideredDoubleTap(mCurrentDownEvent,
									mPreviousUpEvent, event)) {

						Intent intent = new Intent(view.getContext(),
								BusCanActivity.class);

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
		iv_qianmentabudeng = (ImageView) view
				.findViewById(R.id.bcf_qianmentabudeng);
		iv_zuoxinglicangzhaomingdeng = (ImageView) view
				.findViewById(R.id.bcf_zuoxinglicangzhaomingdeng);
		iv_houwudeng = (ImageView) view.findViewById(R.id.bcf_houwudeng);

		iv_yuanguangdeng = (ImageView) view
				.findViewById(R.id.bcf_yuanguangdeng);
		iv_youxinglicangzhaomingdeng = (ImageView) view
				.findViewById(R.id.bcf_youxinglicangzhaomingdeng);
		iv_zhidongdeng = (ImageView) view.findViewById(R.id.bcf_zhidongdeng);
		iv_qianwudeng = (ImageView) view.findViewById(R.id.bcf_qianwudeng);
		iv_zhongmentabudeng = (ImageView) view
				.findViewById(R.id.bcf_zhongmentabudeng);
		iv_daochedeng = (ImageView) view.findViewById(R.id.bcf_daochedeng);
		iv_jinguangdeng = (ImageView) view.findViewById(R.id.bcf_jinguangdeng);
		iv_weishengjianyourenzhishideng = (ImageView) view
				.findViewById(R.id.bcf_weishengjianyourenzhishideng);
		iv_gaoyacangdeng = (ImageView) view
				.findViewById(R.id.bcf_gaoyacangdeng);
		iv_qianmenkaidiancifa = (ImageView) view
				.findViewById(R.id.bcf_qianmenkaidiancifa);
		iv_dianshijidianyuan = (ImageView) view
				.findViewById(R.id.bcf_dianshijidianyuan);
		iv_qidongjidianqi = (ImageView) view
				.findViewById(R.id.bcf_qidongjidianqi);
		iv_qianmenguandiancifa = (ImageView) view
				.findViewById(R.id.bcf_qianmenguandiancifa);
		iv_zhongmenguanmendiancifa = (ImageView) view
				.findViewById(R.id.bcf_zhongmenguanmendiacifa);
		iv_weishengjianqiangzhipaiwufa = (ImageView) view
				.findViewById(R.id.bcf_weishengjianqiangzhipaiwufa);
		iv_penshuidianji = (ImageView) view
				.findViewById(R.id.bcf_penshuidianji);
		iv_zhongmenkaimendiancifa = (ImageView) view
				.findViewById(R.id.bcf_zhongmenkaimendiancifa);
		iv_nuanshuidiancifa = (ImageView) view
				.findViewById(R.id.bcf_nuanshuidiancifa);
		iv_qilaba = (ImageView) view.findViewById(R.id.bcf_qilaba);
		iv_lupaideng = (ImageView) view.findViewById(R.id.bcf_lupaideng);
		iv_lupaidianyuan = (ImageView) view
				.findViewById(R.id.bcf_lupaidianyuan);

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

	private final class UIHandler extends Handler {
		public void handleMessage(Message msg) {
			initialize();
		}
	}
}