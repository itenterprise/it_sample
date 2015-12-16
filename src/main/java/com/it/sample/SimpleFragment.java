package com.it.sample;

import android.os.Bundle;
import android.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

/**
 * Простой фрагмент
 */
public class SimpleFragment extends Fragment {

	private static final String ARG_ITEM_TITLE = "Item_title";

	public SimpleFragment() {
		// Required empty public constructor
	}

	public static SimpleFragment newInstance(String itemTitle) {
		SimpleFragment fragment = new SimpleFragment();
		Bundle args = new Bundle();
		args.putString(ARG_ITEM_TITLE, itemTitle);
		fragment.setArguments(args);
		return fragment;
	}

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
	}

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
	                         Bundle savedInstanceState) {
		// Inflate the layout for this fragment
		View rootView = inflater.inflate(R.layout.fragment_simple, container, false);
		initView(rootView);
		return rootView;
	}

	private void initView(View rootView) {
		if (getArguments() == null) {
			return;
		}
		String itemTitle = getArguments().getString(ARG_ITEM_TITLE);
		if (itemTitle == null) {
			itemTitle = "";
		}
		TextView titleTextView = (TextView) rootView.findViewById(R.id.fragment_simple_title);
		titleTextView.setText(itemTitle);
	}
}