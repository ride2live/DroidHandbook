package com.example.learndroidbook;




import android.app.ActionBar;
import android.app.Activity;
import android.app.FragmentTransaction;
import android.content.res.Configuration;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.Toast;

public class MainActivity extends Activity implements TabChangeListener, ListviewCallback {
	android.app.ActionBar actionTabsBar;
	FragmentLeftListview mFragmentLeftListview;
	FragmentRightText mFragmentRightText;
	FrameLayout leftFrame;
	LinearLayout menuOpener;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        actionTabsBar = getActionBar();
        actionTabsBar.setNavigationMode(ActionBar.NAVIGATION_MODE_TABS);
        TabsCreator.buildActionBar(actionTabsBar, this);
        leftFrame = (FrameLayout) findViewById(R.id.containerLeft);
        menuOpener = (LinearLayout) findViewById(R.id.aaa);
		//tab1.setTabListener(new MyTabListener(this));
//		tab2.setTabListener(new MyTabListener(this));
        
        menuOpener.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				leftFrame.setVisibility(View.VISIBLE);
			}
		});
        
    }
    
    @Override
    public void onConfigurationChanged(Configuration newConfig) {
    	// TODO Auto-generated method stub
    	Log.e("ldb", "onConfigurationChanged");
    	super.onConfigurationChanged(newConfig);
    	  if (newConfig.orientation == Configuration.ORIENTATION_LANDSCAPE) {
    	        Toast.makeText(this, "landscape", Toast.LENGTH_SHORT).show();
    	    } else if (newConfig.orientation == Configuration.ORIENTATION_PORTRAIT){
    	        Toast.makeText(this, "portrait", Toast.LENGTH_SHORT).show();
    	    }
    }

	@Override
	public void pageChanged(int position) {
		// TODO Auto-generated method stub
		switch (position) {
		case 0:
			if (mFragmentLeftListview == null)
				mFragmentLeftListview = new FragmentLeftListview();
			if (mFragmentRightText == null)
				mFragmentRightText = new FragmentRightText();
			FragmentTransaction ft = getFragmentManager().beginTransaction();
			ft.add(R.id.containerLeft, mFragmentLeftListview);
			ft.add(R.id.containerRight, mFragmentRightText);
			ft.commit();
			break;

		default:
			break;
		}
	}

	// Maaaan, rewrite this asap.Use xml and parse it.
	@Override
	public void clickedItemWithTag(String tag) {
		// TODO Auto-generated method stub
		leftFrame.setVisibility(View.GONE);
//		FragmentTransaction ft = getFragmentManager().beginTransaction();
//		ft.remove(mFragmentLeftListview);
//		ft.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_FADE);
		
		//ft.hide(mFragmentLeftListview);
	//	ft.commit();
		if (tag.equals("CLASS_RELATIONSHIP"))
			mFragmentRightText.changeWebView ("file:///android_asset/class_relationship.html");
		if (tag.equals("OOP"))
		{
			mFragmentRightText.changeWebView ("file:///android_asset/index5.html");
			leftFrame.setVisibility(View.VISIBLE);
		}
		if (tag.equals("ABSTRACT_CLASS"))
			mFragmentRightText.changeWebView ("file:///android_asset/abstract.html");
		if (tag.equals("INNER_CLASS"))
			mFragmentRightText.changeWebView ("file:///android_asset/inner_classes.html");
		Log.e("itemTag", tag);
	}
	
	public void openMenu (View V)
	{
		leftFrame.setVisibility(View.VISIBLE);
	}

    
    
}
