package com.mark.bus.app;

import com.mark.bus.R;
import com.mark.bus.data.DataFromBusCanModule;
import com.mark.bus.data.DataHandler1;

import android.app.Activity;
import android.graphics.Point;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.v4.app.FragmentActivity;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ImageButton;
import android.widget.ImageView;

public class BusCanActivity extends FragmentActivity {

	private ImageButton closeBtn;

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

	private ImageView iv_zuoqianzhuanxiang;
	private ImageView iv_yuedudengshuchu;
	private ImageView iv_houcangmendianciganyingshixianweikaiguan;
	private ImageView iv_youqianzhuanxiang;
	private ImageView iv_dingdanbaideng;
	private ImageView iv_fadongjishuiweichuanganqidianyuan;
	private ImageView iv_yuguaqikuaidang;
	private ImageView iv_dingshuangbaideng;
	private ImageView iv_cedianzilupai;
	private ImageView iv_kongtiaokaiguandianyuan;
	private ImageView iv_jiashiyuandingdeng;
	private ImageView iv_disansuidongqiaokongzhidiancifa;
	private ImageView iv_ganzaoqi;
	private ImageView iv_youzhuanxiangdeng;
	private ImageView iv_weishengjian;
	private ImageView iv_shigaoqi;
	private ImageView iv_zuozhuanxiangdeng;
	private ImageView iv_zhizongdianyuanjidianqi;
	private ImageView iv_yuguaqimandang;
	private ImageView iv_dinglandeng;
	private ImageView iv_houdianzilupai;
	private ImageView iv_jiansuqidianyuan;
	private ImageView iv_xinglijiadeng;
	private ImageView iv_qiandianzilupai;
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
		DataFromBusCanModule dbcm = DataHandler1.dbcm;
		iv_qianmentabudeng = (ImageView) this
				.findViewById(R.id.bca_qianmentabudeng);
		if (dbcm.qianmentabudeng == 1)
			iv_qianmentabudeng.setBackgroundResource(R.drawable.onstatus);
		else
			iv_qianmentabudeng.setBackgroundResource(R.drawable.offstatus);
		
		iv_zuoxinglicangzhaomingdeng = (ImageView) this
				.findViewById(R.id.bca_zuoxinglicangzhaomingdeng);
		if (dbcm.zuoxinglicangzhaomingdeng == 1)
			iv_zuoxinglicangzhaomingdeng.setBackgroundResource(R.drawable.onstatus);
		else
			iv_zuoxinglicangzhaomingdeng.setBackgroundResource(R.drawable.offstatus);
		System.out.println("******************************************"+dbcm.houwudeng);

		iv_houwudeng = (ImageView) this.findViewById(R.id.bca_houwudeng);
		if (dbcm.houwudeng == 1)
			iv_houwudeng.setBackgroundResource(R.drawable.onstatus);
		else
			iv_houwudeng.setBackgroundResource(R.drawable.offstatus);
		
		iv_yuanguangdeng = (ImageView) this
				.findViewById(R.id.bca_yuanguangdeng);
		if (dbcm.yuanguangdeng == 1)
			iv_yuanguangdeng.setBackgroundResource(R.drawable.onstatus);
		else
			iv_yuanguangdeng.setBackgroundResource(R.drawable.offstatus);

		iv_youxinglicangzhaomingdeng = (ImageView) this
				.findViewById(R.id.bca_youxinglicangzhaomingdeng);
		if (dbcm.youxinglicangzhaomingdeng == 1)
			iv_youxinglicangzhaomingdeng.setBackgroundResource(R.drawable.onstatus);
		else
			iv_youxinglicangzhaomingdeng.setBackgroundResource(R.drawable.offstatus);

		iv_zhidongdeng = (ImageView) this.findViewById(R.id.bca_zhidongdeng);
		if (dbcm.zhidongdeng == 1)
			iv_zhidongdeng.setBackgroundResource(R.drawable.onstatus);
		else
			iv_zhidongdeng.setBackgroundResource(R.drawable.offstatus);

		iv_qianwudeng = (ImageView) this.findViewById(R.id.bca_qianwudeng);
		if (dbcm.qianwudeng == 1)
			iv_qianwudeng.setBackgroundResource(R.drawable.onstatus);
		else
			iv_qianwudeng.setBackgroundResource(R.drawable.offstatus);

		iv_zhongmentabudeng = (ImageView) this
				.findViewById(R.id.bca_zhongmentabudeng);
		if (dbcm.zhongmentabudeng == 1)
			iv_zhongmentabudeng.setBackgroundResource(R.drawable.onstatus);
		else
			iv_zhongmentabudeng.setBackgroundResource(R.drawable.offstatus);

		iv_daochedeng = (ImageView) this.findViewById(R.id.bca_daochedeng);
		if (dbcm.daochedeng == 1)
			iv_daochedeng.setBackgroundResource(R.drawable.onstatus);
		else
			iv_daochedeng.setBackgroundResource(R.drawable.offstatus);

		iv_jinguangdeng = (ImageView) this.findViewById(R.id.bca_jinguangdeng);
		if (dbcm.jinguangdeng == 1)
			iv_jinguangdeng.setBackgroundResource(R.drawable.onstatus);
		else
			iv_jinguangdeng.setBackgroundResource(R.drawable.offstatus);

		iv_weishengjianyourenzhishideng = (ImageView) this
				.findViewById(R.id.bca_weishengjianyourenzhishideng);
		if (dbcm.weishengjianyourenzhishideng == 1)
			iv_weishengjianyourenzhishideng.setBackgroundResource(R.drawable.onstatus);
		else
			iv_weishengjianyourenzhishideng.setBackgroundResource(R.drawable.offstatus);

		iv_gaoyacangdeng = (ImageView)this.findViewById(R.id.bca_gaoyacangdeng);
		if (dbcm.gaoyacangzhaomingdeng == 1)
			iv_gaoyacangdeng.setBackgroundResource(R.drawable.onstatus);
		else
			iv_gaoyacangdeng.setBackgroundResource(R.drawable.offstatus);
		
		iv_qianmenkaidiancifa= (ImageView)this.findViewById(R.id.bca_qianmenkaidiancifa);
		if (dbcm.qianmenkaimendiancifa == 1)
			iv_qianmenkaidiancifa.setBackgroundResource(R.drawable.onstatus);
		else
			iv_qianmenkaidiancifa.setBackgroundResource(R.drawable.offstatus);
		
		iv_dianshijidianyuan = (ImageView) this
				.findViewById(R.id.bca_dianshijidianyuan);
		if (dbcm.dianshijidianyuan == 1)
			iv_dianshijidianyuan.setBackgroundResource(R.drawable.onstatus);
		else
			iv_dianshijidianyuan.setBackgroundResource(R.drawable.offstatus);

		iv_qidongjidianqi = (ImageView) this
				.findViewById(R.id.bca_qidongjidianqi);
		if (dbcm.qidongjidianqi == 1)
			iv_qidongjidianqi.setBackgroundResource(R.drawable.onstatus);
		else
			iv_qidongjidianqi.setBackgroundResource(R.drawable.offstatus);
		
		iv_qianmenguandiancifa = (ImageView) this
				.findViewById(R.id.bca_qianmenguandiancifa);
		 if (dbcm.qianmenguanmendiancifa == 1)
			 iv_qianmenguandiancifa.setBackgroundResource(R.drawable.onstatus);
		 else
			 iv_qianmenguandiancifa.setBackgroundResource(R.drawable.offstatus);
	
		iv_zhongmenguanmendiancifa = (ImageView) this
				.findViewById(R.id.bca_zhongmenguanmendiacifa);
		if (dbcm.zhongmenguanmendiancifa == 1)
			iv_zhongmenguanmendiancifa.setBackgroundResource(R.drawable.onstatus);
		else
			iv_zhongmenguanmendiancifa.setBackgroundResource(R.drawable.offstatus);
		
		iv_weishengjianqiangzhipaiwufa = (ImageView) this
				.findViewById(R.id.bca_weishengjianqiangzhipaiwufa);
		if (dbcm.weishengjianqiangzhipaiwu == 1)
			iv_weishengjianqiangzhipaiwufa.setBackgroundResource(R.drawable.onstatus);
		else
			iv_weishengjianqiangzhipaiwufa.setBackgroundResource(R.drawable.offstatus);
		 
		iv_penshuidianji = (ImageView) this
				.findViewById(R.id.bca_penshuidianji);
		if (dbcm.penshuidianji == 1)
			iv_penshuidianji.setBackgroundResource(R.drawable.onstatus);
		else
			iv_penshuidianji.setBackgroundResource(R.drawable.offstatus);
		
		iv_zhongmenkaimendiancifa = (ImageView) this
				.findViewById(R.id.bca_zhongmenkaimendiancifa);
		if (dbcm.zhongmenkaimendiancifa == 1)
			iv_zhongmenkaimendiancifa.setBackgroundResource(R.drawable.onstatus);
		else
			iv_zhongmenkaimendiancifa.setBackgroundResource(R.drawable.offstatus);
		
		iv_nuanshuidiancifa = (ImageView) this
				.findViewById(R.id.bca_nuanshuidiancifa);
		if (dbcm.nuanshuidiancifa == 1)
			iv_nuanshuidiancifa.setBackgroundResource(R.drawable.onstatus);
		else
			iv_nuanshuidiancifa.setBackgroundResource(R.drawable.offstatus);

		iv_qilaba = (ImageView) this.findViewById(R.id.bca_qilaba);
		if (dbcm.labazhuanhuankaiguan == 1)
			iv_qilaba.setBackgroundResource(R.drawable.onstatus);
		else
			iv_qilaba.setBackgroundResource(R.drawable.offstatus);
		
		iv_lupaideng = (ImageView) this.findViewById(R.id.bca_lupaideng);
		if (dbcm.dianzilupaikaiguan == 1)
			iv_lupaideng.setBackgroundResource(R.drawable.onstatus);
		else
			iv_lupaideng.setBackgroundResource(R.drawable.offstatus);
		
		iv_zuoqianzhuanxiang = (ImageView) this
				.findViewById(R.id.bca_zuoqianzhuanxiang);
		if (dbcm.zuoqianzhuanxiang == 1)
			iv_zuoqianzhuanxiang.setBackgroundResource(R.drawable.onstatus);
		else
			iv_zuoqianzhuanxiang.setBackgroundResource(R.drawable.offstatus);
		
		iv_yuedudengshuchu = (ImageView) this
				.findViewById(R.id.bca_yuedudengshuru);
		if (dbcm.yuedudeng == 1)
			iv_yuedudengshuchu.setBackgroundResource(R.drawable.onstatus);
		else
			iv_yuedudengshuchu.setBackgroundResource(R.drawable.offstatus);
		
		iv_houcangmendianciganyingshixianweikaiguan = (ImageView) this
				.findViewById(R.id.bca_houcangmendianciganyingshixianweikaiguan);
		if (dbcm.houcangmendianchiganyingshixianweikaiguan == 1)
			iv_houcangmendianciganyingshixianweikaiguan.setBackgroundResource(R.drawable.onstatus);
		else
			iv_houcangmendianciganyingshixianweikaiguan.setBackgroundResource(R.drawable.offstatus);
		
		iv_youqianzhuanxiang = (ImageView) this
				.findViewById(R.id.bca_youqianxhuanxiang);
		if (dbcm.youqianzhuanxiang == 1)
			iv_youqianzhuanxiang.setBackgroundResource(R.drawable.onstatus);
		else
			iv_youqianzhuanxiang.setBackgroundResource(R.drawable.offstatus);
		
		iv_dingdanbaideng = (ImageView) this
				.findViewById(R.id.bca_dingdanbaideng);
		if (dbcm.dingdanbaideng == 1)
			iv_dingdanbaideng.setBackgroundResource(R.drawable.onstatus);
		else
			iv_dingdanbaideng.setBackgroundResource(R.drawable.offstatus);
		
		iv_fadongjishuiweichuanganqidianyuan = (ImageView) this
				.findViewById(R.id.bca_fadianjishuiweichuanganqidianyuan);
		if (dbcm.fadongjishuiweichuanganqidianyuan ==1)
			iv_fadongjishuiweichuanganqidianyuan.setBackgroundResource(R.drawable.onstatus);
		else
			iv_fadongjishuiweichuanganqidianyuan.setBackgroundResource(R.drawable.offstatus);
		
		iv_yuguaqikuaidang = (ImageView) this
				.findViewById(R.id.bca_yuguaqikuaidang);
		if (dbcm.yuguaqikuaidang == 1)
			iv_yuguaqikuaidang.setBackgroundResource(R.drawable.onstatus);
		else
			iv_yuguaqikuaidang.setBackgroundResource(R.drawable.offstatus);
		
		iv_dingshuangbaideng = (ImageView) this
				.findViewById(R.id.bca_dingshuangbaideng);
		if (dbcm.dingshuangbaideng == 1)
			iv_dingshuangbaideng.setBackgroundResource(R.drawable.onstatus);
		else
			iv_dingshuangbaideng.setBackgroundResource(R.drawable.offstatus);
		
		iv_kongtiaokaiguandianyuan = (ImageView) this
				.findViewById(R.id.bca_kongtiaokaiguandianyuan);
		if (dbcm.kongtiaokaiguandianyuan == 1)
			iv_kongtiaokaiguandianyuan.setBackgroundResource(R.drawable.onstatus);
		else
			iv_kongtiaokaiguandianyuan.setBackgroundResource(R.drawable.offstatus);
		
		iv_jiashiyuandingdeng = (ImageView) this
				.findViewById(R.id.bca_jiashiyuandingdeng);
		if (dbcm.jiashiyuandingdeng == 1)
			iv_jiashiyuandingdeng.setBackgroundResource(R.drawable.onstatus);
		else
			iv_jiashiyuandingdeng.setBackgroundResource(R.drawable.offstatus);
		
		iv_disansuidongqiaokongzhidiancifa = (ImageView) this
				.findViewById(R.id.bca_disansuidongqiaokongzhidiancifa);
		if (dbcm.disansuidongqiaokongzhidiancifa == 1)
			iv_disansuidongqiaokongzhidiancifa.setBackgroundResource(R.drawable.onstatus);
		else
			iv_disansuidongqiaokongzhidiancifa.setBackgroundResource(R.drawable.offstatus);

		iv_youzhuanxiangdeng = (ImageView) this
				.findViewById(R.id.bca_youzhuanxiangdeng);
		if (dbcm.youzhuanxiangdeng == 1)
			iv_youzhuanxiangdeng.setBackgroundResource(R.drawable.onstatus);
		else
			iv_youzhuanxiangdeng.setBackgroundResource(R.drawable.offstatus);
		
		iv_weishengjian = (ImageView) this.findViewById(R.id.bca_weishengjian);
		if (dbcm.weishangjiandeng == 1)
			iv_weishengjian.setBackgroundResource(R.drawable.onstatus);
		else
			iv_weishengjian.setBackgroundResource(R.drawable.offstatus);
		
		iv_shigaoqi = (ImageView) this.findViewById(R.id.bca_shigaodeng);
		if (dbcm.shigaodeng == 1)
			iv_shigaoqi.setBackgroundResource(R.drawable.onstatus);
		else
			iv_shigaoqi.setBackgroundResource(R.drawable.offstatus);

		iv_zuozhuanxiangdeng = (ImageView) this
				.findViewById(R.id.bca_zuozhuanxiangdeng);
		if (dbcm.zuozhuanxiangdeng == 1)
			iv_zuozhuanxiangdeng.setBackgroundResource(R.drawable.onstatus);
		else
			iv_zuozhuanxiangdeng.setBackgroundResource(R.drawable.offstatus);
		
		iv_zhizongdianyuanjidianqi = (ImageView) this
				.findViewById(R.id.bca_zhizongdianyuanjidianqi);
		if (dbcm.zhizongdianyuanjidianqi == 1)
			iv_zhizongdianyuanjidianqi.setBackgroundResource(R.drawable.onstatus);
		else
			iv_zhizongdianyuanjidianqi.setBackgroundResource(R.drawable.offstatus);
		
		iv_yuguaqimandang = (ImageView) this
				.findViewById(R.id.bca_yuguaqimandang);
		if (dbcm.yuguaqimandang == 1)
			iv_yuguaqimandang.setBackgroundResource(R.drawable.onstatus);
		else
			iv_yuguaqimandang.setBackgroundResource(R.drawable.offstatus);
		
		iv_dinglandeng = (ImageView) this.findViewById(R.id.bca_dinglandeng);
		if (dbcm.dinglandeng == 1)
			iv_dinglandeng.setBackgroundResource(R.drawable.onstatus);
		else
			iv_dinglandeng.setBackgroundResource(R.drawable.offstatus);
		
		
		iv_jiansuqidianyuan = (ImageView) this
				.findViewById(R.id.bca_jiansuqidianyuan);
		if (dbcm.jiansuqidianyuan == 1)
			iv_jiansuqidianyuan.setBackgroundResource(R.drawable.onstatus);
		else
			iv_jiansuqidianyuan.setBackgroundResource(R.drawable.offstatus);
		 
		iv_xinglijiadeng = (ImageView) this
				.findViewById(R.id.bca_xinglijiadeng);
		if (dbcm.xinglijiadeng == 1)
			iv_xinglijiadeng.setBackgroundResource(R.drawable.onstatus);		
		else
			iv_xinglijiadeng.setBackgroundResource(R.drawable.offstatus);		
	}

	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		super.requestWindowFeature(Window.FEATURE_NO_TITLE);
		super.setContentView(R.layout.bus_can_activity);
		closeBtn = (ImageButton) this.findViewById(R.id.bca_closebtn);

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
