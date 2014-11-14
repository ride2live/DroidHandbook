package com.example.learndroidbook;

import android.app.ActionBar;
import android.app.ActionBar.Tab;

public  abstract class TabsCreator {

	
	public final static ActionBar buildActionBar(ActionBar actionTabsBar, TabChangeListener tapChangeListener) {
		// TODO Auto-generated method stub
        Tab javaTab = actionTabsBar.newTab();
		Tab androidTab = actionTabsBar.newTab();
		Tab patternsTab = actionTabsBar.newTab();
		javaTab.setText("Java");
		androidTab.setText("Android");
		patternsTab.setText("Паттерны");

		Tab [] alltabs = new Tab[] {javaTab, androidTab, patternsTab};
		MyTabListener tabListener = new MyTabListener(tapChangeListener);
		for (Tab tab : alltabs) {
			
			tab.setTabListener(tabListener);
			actionTabsBar.addTab(tab);
		}
		return actionTabsBar;
	}
	
	
	

	
	

}
