package com.mark.bus.app;

import java.util.Map;

import com.mark.bus.app.MainActivity.ACModeHandler;
import com.mark.bus.app.MainActivity.CrashHandler;
import com.mark.bus.app.MainActivity.ModelHandler;
import com.mark.bus.data.DataFromWholeController1;

import android.app.Application;

public class BusApplication extends Application {

	private DataFromWholeController1 dw1 = new DataFromWholeController1();
	private ModelHandler modelhandler = null;
    private ACModeHandler acModeHandler = null;
	private CrashHandler crashHandler = null;

	public ACModeHandler getAcModleHandler() {
		return acModeHandler;
	}

	public void setAcModleHandler(ACModeHandler acModeHandler) {
		this.acModeHandler = acModeHandler;
	}

	public CrashHandler getCrashHandler() {
		return crashHandler;
	}

	public void setCrashHandler(CrashHandler crashHandler) {
		this.crashHandler = crashHandler;
	}

	private int[] buttonStatus = { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 };//buttons of ButtonsFragment
	private int[] dataStatus = { 0, 0, 0, 0, 0, 0, 0, 0 };//buttons of DataSettingActivity

	public int[] getButtonStatus() {
		return buttonStatus;
	}
	public void setButtonStatus(int[] buttonStatus) {
		this.buttonStatus = buttonStatus;
	}
	
	public int[] getDataStatus() {
		return dataStatus;
	}
	public void setDataStatus(int[] dataStatus) {
		this.dataStatus = dataStatus;
	}

	private String crashTime = "";
	private int crashStatus = 0; // 1 not crash 2 protect 3 crash

	public String getCrashTime() {
		return crashTime;
	}

	public void setCrashTime(String crashTime) {
		this.crashTime = crashTime;
	}

	public int getCrashStatus() {
		return crashStatus;
	}

	public void setCrashStatus(int crashStatus) {
		this.crashStatus = crashStatus;
	}

	// set方法
	public void setHandler(ModelHandler m) {
		this.modelhandler = m;
	}

	// get方法
	public ModelHandler getHandler() {
		return modelhandler;
	}

}
