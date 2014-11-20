package com.example.learndroidbook;

import android.app.ActionBar;
import android.app.Activity;
import android.app.FragmentTransaction;
import android.content.res.Configuration;
import android.os.Bundle;
import android.support.v4.widget.DrawerLayout;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.Toast;
/** Main activity with fragments
 * @author Nolwe
 * 
 * 
 * */
public class MainActivity extends Activity implements TabChangeListener,
		ListviewCallback {

	android.app.ActionBar actionTabsBar;
	FragmentLeftListview mFragmentLeftListview;
	FragmentRightText mFragmentRightText;
	FrameLayout leftFrame;
	LinearLayout menuOpener;
	Button hideLeftContainerButton;
	DrawerLayout navigationDrawerLayout;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		
		setContentView(R.layout.activity_main);
		actionTabsBar = getActionBar();
		actionTabsBar.setNavigationMode(ActionBar.NAVIGATION_MODE_TABS);
		TabsCreator.buildActionBar(actionTabsBar, this);
		leftFrame = (FrameLayout) findViewById(R.id.containerLeft);
		navigationDrawerLayout = (DrawerLayout) findViewById(R.id.drawer_layout);

	}

	@Override
	public void onConfigurationChanged(Configuration newConfig) {
		// TODO Auto-generated method stub
		Log.e("ldb", "onConfigurationChanged");
		super.onConfigurationChanged(newConfig);
		if (newConfig.orientation == Configuration.ORIENTATION_LANDSCAPE) {
			Toast.makeText(this, "landscape", Toast.LENGTH_SHORT).show();
		} else if (newConfig.orientation == Configuration.ORIENTATION_PORTRAIT) {
			Toast.makeText(this, "portrait", Toast.LENGTH_SHORT).show();
		}
	}

	@Override
	public void pageChanged(int position) {
		// TODO Auto-generated method stub
		switch (position) {
		case 0:
			if (mFragmentLeftListview == null) {
				mFragmentLeftListview = new FragmentLeftListview();
				FragmentTransaction ft = getFragmentManager()
						.beginTransaction();

				ft.add(R.id.containerLeft, mFragmentLeftListview);
				ft.commit();
			}

			if (mFragmentRightText == null) {
				mFragmentRightText = new FragmentRightText();
				FragmentTransaction ft = getFragmentManager()
						.beginTransaction();

				ft.add(R.id.containerRight, mFragmentRightText);
				ft.commit();
			}

			break;

		default:
			break;
		}
	}

	// Maaaan, rewrite this asap.Use xml and parse it.
	@Override
	public void clickedItemWithTag(String tag) {
		// TODO Auto-generated method stub
		// leftFrame.setVisibility(View.GONE);
		// FragmentTransaction ft = getFragmentManager().beginTransaction();
		// ft.remove(mFragmentLeftListview);
		// ft.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_FADE);
		navigationDrawerLayout.closeDrawer(leftFrame);
		// ft.hide(mFragmentLeftListview);
		// ft.commit();
		switch (tag) {
		case "CLASS_RELATIONSHIP":
			mFragmentRightText
					.changeWebView("file:///android_asset/class_relationship.html");
			break;
		case "OOP":
			mFragmentRightText
					.changeWebView("file:///android_asset/index5.html");
			break;
		case "ABSTRACT_CLASS":
			mFragmentRightText
					.changeWebView("file:///android_asset/abstract.html");
			break;
		case "INNER_CLASS":
			mFragmentRightText
					.changeWebView("file:///android_asset/inner_classes.html");
			break;
		case "COLLECTIONS":
			mFragmentRightText
					.changeWebView("file:///android_asset/collections_java.html");
			break;
		case "COLLECTIONS_HABR":
			mFragmentRightText
					.changeWebView("file:///android_asset/collections_java.html");
			break;
		case "COLLECTIONS_THEORY":
			mFragmentRightText
					.changeWebView("file:///android_asset/collections_theory.html");
			break;
		case "COLLECTIONS_LIST":
			mFragmentRightText
					.changeWebView("file:///android_asset/collections_deep.html");
		case "COLLECTIONS_MAP":
			mFragmentRightText
					.changeWebView("file:///android_asset/collections_map.html");
			break;
		case "UML":
			mFragmentRightText.changeWebView("file:///android_asset/UML.html");
			break;

		default:
			break;
		}

	}

	@Override
	public void hideLeft() {
		// TODO Auto-generated method stub
		leftFrame.setVisibility(View.GONE);
	}

}
