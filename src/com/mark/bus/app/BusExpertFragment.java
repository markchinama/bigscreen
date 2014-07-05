package com.mark.bus.app;

import java.util.List;

import com.mark.bus.R;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

public class BusExpertFragment  extends Fragment{
	private View view;
	private ListView faultInfoList;
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {

		view = inflater.inflate(R.layout.bus_expert_fragment, container, false);
		List data = FaultList.getDataList();
		FLAdapter adapter = new FLAdapter(this,view,data);
		faultInfoList = (ListView) view.findViewById(R.id.faultInfoList);
		faultInfoList.setAdapter(adapter);
		
		return view;
	}
}
