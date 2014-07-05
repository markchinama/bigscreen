package com.mark.bus.data;

import com.mark.bus.app.BusApplication;
import com.mark.bus.app.BusVideoFragment;

public class DataHandler {
	static {
		System.loadLibrary("candata");
		initialize();
	}
	public static ACData2Bus ac2bus = new ACData2Bus();
	public static WorkMode2Bus workMode2Bus = new WorkMode2Bus();
	public static int[] btnsStatus ={0,0,0,0,0,0,0,0,0,0,0,0};//here,cannot use the buttonstatus in BusApplication. buttonstatus can only be used among activities or fragments.
	
	public static void setACData() {
		setAC(ac2bus.fengsudangwei, ac2bus.shedingwendu,
				ac2bus.kongtiaosongfengmoshi, ac2bus.kongtiaogongzuomoshi,
				ac2bus.kongtiaogonglv, ac2bus.kongtiaogongzuozhuangtai);
	}
	public static void setWorkModeData() {
		setWorkMode(workMode2Bus.mode,workMode2Bus.crash);
	}
	
	public static void setButtonsStatus() {System.out.println("btnsStatus[0]: ");System.out.println(btnsStatus[0]);
		setButtons(
				btnsStatus[0],//btns.frontFogButton,
				btnsStatus[1],//btns.rearFogButton,
				btnsStatus[2],//btns.hyperbaricCabinButton,
				btnsStatus[3],//btns.rootLightsButton,
				btnsStatus[4],//btns.dRootLightsButton,
				btnsStatus[5],//btns.tvPowerButton,
				btnsStatus[6],//btns.guideBoardButton,
				btnsStatus[7],//btns.leftTurnningButton,
				btnsStatus[8],//btns.rightTurnningButton,
				btnsStatus[9],//btns.noneButton,	
				btnsStatus[10],//btns.closeFrontButton,
				btnsStatus[11]);//btns.closeMidButton
	}
	
	public static native void setAC(int a ,int b,int c,int d,float  e,int f);
	public static native void setWorkMode(int  mode,int crash);
	public static native void setButtons(int frontFogButton,int rearFogButton,int hyperbaricCabinButton,int rootLightsButton,int dRootLightsButton,int tvPowerButton,int guideBoardButton,int leftTurnningButton,int rightTurnningButton,int noneButton,	int closeFrontButton,int closeMidButton);
	public static native void initialize();

}
