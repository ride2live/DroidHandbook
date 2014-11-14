package com.example.learndroidbook;

import android.app.Fragment;
import android.content.Context;
import android.os.Bundle;
import android.view.GestureDetector;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;

public class FragmentRightText extends Fragment {
	WebView web;
	MainActivity main;
	Context context;
	public FragmentRightText() {
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
		super.onActivityCreated(savedInstanceState);
		context = (Context)getActivity();
		web = (WebView) getActivity().findViewById(R.id.webView);
		web.loadUrl("file:///android_asset/index5.html");
		
	}
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		
		return inflater.inflate(R.layout.fragment_right_text, null);
	}
	public void changeWebView(String string) {
		// TODO Auto-generated method stub
		web.loadUrl(string);
		
	}

}
