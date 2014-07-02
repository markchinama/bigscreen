package com.mark.bus.data;

public class DataHandler {
	static {
		System.loadLibrary("candata");
		initialize();
	}
	public static ACData2Bus ac2bus = new ACData2Bus();



	public void setDw1(int i) {
	}

	public static void setButtonsStatus(int[] i) {
		setButtons(i);
	}
	public static void setACData() {
		setAC(ac2bus.fengsudangwei, ac2bus.shedingwendu,
				ac2bus.kongtiaosongfengmoshi, ac2bus.kongtiaogongzuomoshi,
				ac2bus.kongtiaogonglv, ac2bus.kongtiaogongzuozhuangtai);

	}


	public static native void setAC(int a ,int b,int c,int d,float  e,int f);

	public static native void setButtons(int[] i);

	public static native void initialize();

}
