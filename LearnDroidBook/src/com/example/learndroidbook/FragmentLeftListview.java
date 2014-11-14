package com.example.learndroidbook;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ListView;

public class FragmentLeftListview extends Fragment {
	ListView list;
	ListviewCallback listViewCallBack;
	public FragmentLeftListview() {
		// TODO Auto-generated constructor stub
	}
	@Override
	public void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
	}
	@Override
	public void onActivityCreated(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		
		list = (ListView) getActivity().findViewById(R.id.listViewRubrics);
		listViewCallBack = (ListviewCallback) getActivity();
		list.setAdapter( new ListViewAdapter(getActivity(), getResources().getStringArray(R.array.java_list_rubrics)));
		//list.setAdapter(new ArrayAdapter<String>(getActivity(), R.layout.simple_list_item_new,getResources().getStringArray(R.array.java_list_rubrics)));
		list.setOnItemClickListener(new OnItemClickListener() {

			@Override
			public void onItemClick(AdapterView<?> parent, View view,
					int position, long id) {
				
				// TODO Auto-generated method stub
				
				listViewCallBack.clickedItemWithTag(view.getTag().toString());
			}
		} );
		super.onActivityCreated(savedInstanceState);
	}
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		
		return inflater.inflate(R.layout.fragment_left_listview, null);
	}

}
