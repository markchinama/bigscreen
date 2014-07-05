package com.mark.bus.app;

import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.mark.bus.R;
import com.mark.bus.data.DataHandler1;

public class CrashCheckFragment extends Fragment {

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		if(!DataHandler1.dfc.dProtected)
			return inflater.inflate(R.layout.crash_check_fragment01, container,
					false);
		else
			return inflater.inflate(R.layout.crash_check_fragment02, container,
					false);

	}
}