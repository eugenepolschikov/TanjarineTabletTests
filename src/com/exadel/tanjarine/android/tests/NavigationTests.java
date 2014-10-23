package com.exadel.tanjarine.android.tests;

import com.android.uiautomator.core.UiObject;
import com.android.uiautomator.core.UiObjectNotFoundException;
import com.android.uiautomator.core.UiSelector;
import com.exadel.tanjarine.android.testmethods.HighLevelNavigationBetweekAPKsMethods;

public class NavigationTests extends  HighLevelNavigationBetweekAPKsMethods {

	public void testDashboardEmenuNavigate(){
		
		
		
		 UiObject foodeMenu = new UiObject(new UiSelector().text("food"));
		 try {
			foodeMenu.clickAndWaitForNewWindow();
		} catch (UiObjectNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		// back button navigate
		getUiDevice().pressBack();
		
	}
}
