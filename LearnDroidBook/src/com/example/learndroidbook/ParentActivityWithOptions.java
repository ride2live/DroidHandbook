package com.example.learndroidbook;



import android.app.Activity;
import android.view.Menu;

public abstract class ParentActivityWithOptions extends Activity{

	
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// TODO Auto-generated method stub
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}
}
