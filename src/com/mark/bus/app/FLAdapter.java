package com.mark.bus.app;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.mark.bus.R;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;

import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.TextView;

public class FLAdapter extends BaseAdapter {

	private List blist = new ArrayList();
	private int current = 0;
	private BusApplication ba = null;
	private List<Integer> mData;
	private LayoutInflater mInflater;
	private Fragment fra;
	private View view;

	public FLAdapter(Fragment fra, View view, List mData) {
		this.view = view;
		this.mInflater = LayoutInflater.from(view.getContext());
		this.mData = mData;
		this.fra = fra;
		ba = (BusApplication) fra.getActivity().getApplication();

	}

	@Override
	public int getCount() {
		return mData.size();
	}

	@Override
	public Object getItem(int arg0) {
		return null;
	}

	@Override
	public long getItemId(int arg0) {
		return 0;
	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		FaultViewHolder holder = null;
		if (convertView == null) {
			holder = new FaultViewHolder();
			convertView = mInflater.inflate(R.layout.lf, null);
			holder.viewText = (TextView) convertView.findViewById(R.id.tid);
			convertView.setTag(holder);
		} else {
			holder = (FaultViewHolder) convertView.getTag();
		}
		holder.viewText.setText((CharSequence) view.getContext().getString(
				mData.get(position)));

		blist.add(holder.viewText);
		holder.viewText.setOnClickListener(new InfoOnClickListener(position));

		return convertView;
	}

	public class InfoOnClickListener implements OnClickListener {

		private int position;

		public InfoOnClickListener(int position) {
			this.position = position;
		}

		@Override
		public void onClick(View v) {

			System.out.println("123123");
		}

	}

}
