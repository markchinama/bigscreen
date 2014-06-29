package com.mark.bus.app;

import com.mark.bus.R;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.drawable.BitmapDrawable;
import android.os.Handler;
import android.os.Message;
import android.util.AttributeSet;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.AnimationSet;
import android.view.animation.TranslateAnimation;

public class AirView extends View {
	private Animation alphaAnimation = null;
	private TranslateAnimation translateAnimation;

	public AirView(Context context, AttributeSet attrs) {
		super(context, attrs);
	}

	@Override
	protected void onDraw(Canvas canvas) {
		super.onDraw(canvas);
		// 加载一个图片
		canvas.drawBitmap(
				((BitmapDrawable) getResources().getDrawable(R.drawable.air))
						.getBitmap(), 0, 0, null);
	}

	@Override
	public boolean onTouchEvent(MotionEvent event) {
		System.out.println("1231231");
		alphaAnimation = new AlphaAnimation(0.1f, 1.0f);
		// 设置动画时间
		alphaAnimation.setDuration(3000);
		this.startAnimation(alphaAnimation);

		return true;
	}

	final class AirAnimHandler extends Handler {
		@Override
		public void handleMessage(Message msg) {

			System.out.println("1231231");
			alphaAnimation = new AlphaAnimation(0.1f, 1.0f);
			translateAnimation = new TranslateAnimation(
					Animation.RELATIVE_TO_SELF, 0f,  //X轴的开始位置  
	                Animation.RELATIVE_TO_SELF, 0f,  //X轴的结束位置  
	                Animation.RELATIVE_TO_SELF, 0f,  //Y轴的开始位置  
	                Animation.RELATIVE_TO_SELF, 2.0f); // Y轴的结束位置
			//translateAnimation.setDuration(2000);
			// 设置动画时间
			AnimationSet set = new AnimationSet(true);
			set.addAnimation(alphaAnimation);
			set.addAnimation(translateAnimation);
			set.setDuration(3000);
			AirView.this.startAnimation(set);

		}
	}
}
