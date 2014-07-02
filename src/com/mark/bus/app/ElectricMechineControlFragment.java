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
import com.mark.bus.data.DataFromEM1;
import com.mark.bus.data.DataFromEM2;
import com.mark.bus.data.DataFromEM3;
import com.mark.bus.data.DataHandler1;

public class ElectricMechineControlFragment extends Fragment {

	private View view;
	private TextView mc_zhiliucedianya;
	private TextView mc_dianjixiangdianliu;
	private TextView mc_dianjiwendu;
	private TextView mc_dianjikongzhiqiwendu;
	private TextView mc_dianjizuidazhidongzhuanju;
	private TextView mc_dianjizuidazhidonggonglv;
	private TextView mc_dianjizuidadiandongzhuanju;
	private TextView mc_dianjizuidaqudonggonglv;
	private TextView mc_dianjizhuansu;
	private TextView mc_dianjizhuanju;
	private TextView mc_readyxinhao;
	private TextView mc_zhujiechuqizhuangtai;
	private TextView mc_dianjiyunzhuanfangxiang;
	private TextView mc_nengliangliudongfangxiang;
	private TextView mc_dianjikongzhiqiyunxingzhuangtai;
	private TextView mc_zhuansuzhuanjumoshi;
	private TextView mc_kongzhuan;
	
	private CharSequence unconnect ;
	private CharSequence connect ;
	private CharSequence normalturning ;
	private CharSequence reverseturning;
	private CharSequence diandong ;
	private CharSequence fadian ;
	private CharSequence normal ;
	private CharSequence issue;
	private CharSequence zhuanjumoshi;
	private CharSequence zhuansumoshi;
	private CharSequence no;
	private CharSequence yes;
	private boolean isStop = false;
	static Handler mHandler;	
	
	@Override
	public void onPause() {

		isStop=true;
		super.onPause();
	}
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		unconnect=this.getResources().getString(R.string.unconnect);
		connect=this.getResources().getString(R.string.connect);
		normalturning=this.getResources().getString(R.string.normalturning);
		reverseturning=this.getResources().getString(R.string.reverseturning);
		diandong=this.getResources().getString(R.string.diandong);
		fadian=this.getResources().getString(R.string.fadian);
		normal=this.getResources().getString(R.string.normal);
		issue=this.getResources().getString(R.string.issue);
		zhuanjumoshi=this.getResources().getString(R.string.zhuanjumoshi);
		zhuansumoshi=this.getResources().getString(R.string.zhuansumoshi);
		no=this.getResources().getString(R.string.no);
		yes=this.getResources().getString(R.string.yes);
	
		
		view = inflater.inflate(R.layout.electric_machine_control_fragment,
				container, false);
		mc_dianjixiangdianliu = (TextView) view
				.findViewById(R.id.mc_dianjixiangdianliu);
		mc_zhiliucedianya = (TextView) view
				.findViewById(R.id.mc_zhiliucedianya);
		mc_dianjixiangdianliu = (TextView) view
				.findViewById(R.id.mc_dianjixiangdianliu);
		mc_dianjiwendu = (TextView) view.findViewById(R.id.mc_dianjiwendu);
		mc_dianjikongzhiqiwendu = (TextView) view
				.findViewById(R.id.mc_dianjikongzhiqiwendu);
		mc_dianjizuidazhidongzhuanju = (TextView) view
				.findViewById(R.id.mc_dianjizuidazhidongzhuanju);
		mc_dianjizuidazhidonggonglv = (TextView) view
				.findViewById(R.id.mc_dianjizuidazhidonggonglv);
		mc_dianjizuidadiandongzhuanju = (TextView) view
				.findViewById(R.id.mc_dianjizuidadiandongzhuanju);
		mc_dianjizuidaqudonggonglv = (TextView) view
				.findViewById(R.id.mc_dianjizuidaqudonggonglv);
		mc_dianjizhuansu = (TextView) view.findViewById(R.id.mc_dianjizhuansu);
		mc_dianjizhuanju = (TextView) view.findViewById(R.id.mc_dianjizhuanju);
		mc_readyxinhao = (TextView) view.findViewById(R.id.mc_readyxinhao);
		mc_zhujiechuqizhuangtai = (TextView) view
				.findViewById(R.id.mc_zhujiechuqizhuangtai);
		mc_dianjiyunzhuanfangxiang = (TextView) view
				.findViewById(R.id.mc_dianjiyunzhuanfangxiang);
		mc_nengliangliudongfangxiang = (TextView) view
				.findViewById(R.id.mc_nengliangliudongfangxiang);
		mc_dianjikongzhiqiyunxingzhuangtai = (TextView) view
				.findViewById(R.id.mc_dianjikongzhiqiyunxingzhuangtai);
		mc_zhuansuzhuanjumoshi = (TextView) view
				.findViewById(R.id.mc_zhuansuzhuanjumoshi);
		mc_kongzhuan = (TextView) view.findViewById(R.id.mc_kongzhuan);
		//initialize();
		new Thread(){
	    	@Override
	    	public void run(){
	    		 while(!isStop){
	    			 mHandler.sendMessage(mHandler.obtainMessage());	
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

	public void initialize() {
		DataFromEM1 em1 = DataHandler1.de1;
		DataFromEM2 em2 = DataHandler1.de2;
		DataFromEM3 em3 = DataHandler1.de3;
		mc_zhiliucedianya.setText(new Integer(
				em1.diandongkongzhiqizhiliucedianya).toString());
		mc_dianjixiangdianliu.setText(new Integer(em1.diandongjixiangdianliu)
				.toString());
		mc_dianjiwendu.setText(new Integer(em2.diandongjiwendu).toString());
		mc_dianjikongzhiqiwendu.setText(new Integer(em2.kongzhiqiwendu)
				.toString());
		mc_dianjizuidazhidongzhuanju.setText(new Float(
				em3.diandongjizuidadiandongzhuanju).toString());
		mc_dianjizuidazhidonggonglv.setText(new Float(
				em3.diandongjizuidazhidonggonglv).toString());
		mc_dianjizuidadiandongzhuanju.setText(new Float(
				em3.diandongjizuidadiandongzhuanju).toString());
		mc_dianjizuidaqudonggonglv.setText(new Float(
				em3.diandongjizuidaqudonggonglv).toString());
		mc_dianjizhuansu.setText(new Integer(em2.diandongjizhuansu).toString());
		mc_dianjizhuanju.setText(new Integer(em1.diandongjidangqianzhuanju)
				.toString());
		if (em2.readyxinhao == 1)
			mc_readyxinhao.setText("READY");
		else
			mc_readyxinhao.setText("");
		
		if (em1.zhujiechuqizhuangtai == 0) {
			mc_zhujiechuqizhuangtai.setText(unconnect);
		} else {
			mc_zhujiechuqizhuangtai.setText(connect);
		}

		if (em1.zhengzhuanfanzhuan == 0)
			mc_dianjiyunzhuanfangxiang.setText(normalturning);
		else
			mc_dianjiyunzhuanfangxiang.setText(reverseturning);
		if (em1.diandongfadian == 0)
			mc_nengliangliudongfangxiang.setText(diandong);
		else
			mc_nengliangliudongfangxiang.setText(fadian);
		if (em1.zhengchangguzhang == 0)
			mc_dianjikongzhiqiyunxingzhuangtai.setText(normal);
		else
			mc_dianjikongzhiqiyunxingzhuangtai.setText(issue);
		if (em1.zhuanjuzhuansumoshi == 0)
			mc_zhuansuzhuanjumoshi.setText(zhuanjumoshi);
		else
			mc_zhuansuzhuanjumoshi.setText(zhuansumoshi);
		if (em1.qitakongzhuan == 1)
			mc_kongzhuan.setText(no);
		else
			mc_kongzhuan.setText(yes);
			
	}
}