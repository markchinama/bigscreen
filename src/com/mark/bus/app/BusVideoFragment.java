package com.mark.bus.app;

import java.io.IOException;

import com.mark.bus.R;
import com.mark.bus.app.ButtonsFragment.lightListener;
import com.mark.bus.data.DataHandler;

import android.annotation.SuppressLint;
import android.content.Context;
import android.hardware.Camera;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.SurfaceHolder;
import android.view.SurfaceView;
import android.view.View;
import android.view.ViewGroup;
import android.view.View.OnClickListener;
import android.widget.FrameLayout;
import android.widget.ImageButton;

public class BusVideoFragment extends Fragment {
	private View view;
	private SurfaceView surfaceView;
	private Camera mCamera;
	private CameraPreview mPreview;
	private ImageButton closefront;
	private ImageButton closemid;
	
	int[] lightsOffResource = { R.drawable.closedoor_front, R.drawable.closedoor_middle

	};
	int[] lightsOnResource = { R.drawable.opendoor_front, R.drawable.opendoor_middle

	};

	
	public void intialize() {
		BusApplication ba = (BusApplication) BusVideoFragment.this.getActivity()
				.getApplication();
		int[] buttonStatus = ba.getButtonStatus();

		ImageButton[] ims = { closefront, closemid };

		for (int i = 0; i < 2; i++) {
			if (buttonStatus[i+10] == 0)
				ims[i].setBackgroundResource(lightsOffResource[i]);
			else
				ims[i].setBackgroundResource(lightsOnResource[i]);
		}
	}
	
	@SuppressLint("NewApi")
	public static Camera getCameraInstance() {
		Camera c = null;
		try {
			c = Camera.open(0); // 试图获取Camera实例
		} catch (Exception e) {
			// 摄像头不可用（正被占用或不存在）
			System.out.println("can not found a camera");
		}
	
		return c; // 不可用则返回null
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

			BusApplication ba = (BusApplication) BusVideoFragment.this
					.getActivity().getApplication();
			int[] buttonStatus = ba.getButtonStatus();
			if (buttonStatus[id+10] == 0) {
				buttonStatus[id+10] = 1;
				ba.setButtonStatus(buttonStatus);
				v.setBackgroundResource(lightsOnResource[id]);
				DataHandler.btnsStatus[id+10] =1;
			} else {
				buttonStatus[id+10] = 0;
				ba.setButtonStatus(buttonStatus);
				v.setBackgroundResource(lightsOffResource[id]);
				DataHandler.btnsStatus[id+10] =0;
			}
			//DataHandler.setButtonsStatus(buttonStatus);
			//animHandler.sendEmptyMessage(0);

		}
	}
	
	@Override
	public void onDestroyView() {
if(mCamera != null)
		mCamera.release();
super.onDestroyView();
	}

	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {

		view = inflater.inflate(R.layout.bus_video_fragment, container, false);
		
		closefront = (ImageButton) view.findViewById(R.id.bus_qianmen);
		closemid = (ImageButton) view.findViewById(R.id.bus_zhongnmen);	
		closefront.setOnClickListener(new lightListener(0));
		closemid.setOnClickListener(new lightListener(1));
		intialize();
		
		mCamera = getCameraInstance();

		// 创建Preview view并将其设为activity中的内容
		mPreview = new CameraPreview(view.getContext(), mCamera);
		FrameLayout preview = (FrameLayout) view.findViewById(R.id.camera_preview);
		preview.addView(mPreview);
		return view;
	}

	public class CameraPreview extends SurfaceView implements
			SurfaceHolder.Callback {
		private SurfaceHolder mHolder;
		private Camera mCamera;

		public CameraPreview(Context context, Camera camera) {
			super(context);
			mCamera = camera;

			// 安装一个SurfaceHolder.Callback，
			// 这样创建和销毁底层surface时能够获得通知。
			mHolder = getHolder();
			mHolder.addCallback(this);
			// 已过期的设置，但版本低于3.0的Android还需要
			mHolder.setType(SurfaceHolder.SURFACE_TYPE_PUSH_BUFFERS);
		}

		public void surfaceCreated(SurfaceHolder holder) {
			// surface已被创建，现在把预览画面的位置通知摄像头
			try {
				mCamera.setPreviewDisplay(holder);
				mCamera.startPreview();
			} catch (Exception e) {
				System.out.println("can not creat a preview");
			}
		}

		public void surfaceDestroyed(SurfaceHolder holder) {
			// 空代码。注意在activity中释放摄像头预览对象
			mCamera.release();
		}

		public void surfaceChanged(SurfaceHolder holder, int format, int w,
				int h) {
			// 如果预览无法更改或旋转，注意此处的事件
			// 确保在缩放或重排时停止预览

			if (mHolder.getSurface() == null) {
				// 预览surface不存在
				return;
			}

			// 更改时停止预览
			try {
				mCamera.stopPreview();
				mCamera.release();
			} catch (Exception e) {
				// 忽略：试图停止不存在的预览
			}

			// 在此进行缩放、旋转和重新组织格式

			// 以新的设置启动预览
			try {
				mCamera =getCameraInstance();
				mCamera.setPreviewDisplay(mHolder);
				mCamera.startPreview();

			} catch (Exception e) {
			}
		}
	}

}
