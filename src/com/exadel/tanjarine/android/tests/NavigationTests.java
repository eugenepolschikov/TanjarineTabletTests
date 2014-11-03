package com.exadel.tanjarine.android.tests;


import com.android.uiautomator.core.UiObject;
import com.android.uiautomator.core.UiObjectNotFoundException;
import com.android.uiautomator.core.UiSelector;
import com.exadel.tanjarine.android.testmethods.HighLevelNavigationBetweekAPKsMethods;

//import org.apache.commons.lang.*;;

public class NavigationTests extends HighLevelNavigationBetweekAPKsMethods {

	public void test1NewTableAssignment() throws UiObjectNotFoundException,
			InterruptedException {
		String tableName = "test_1";

		newTableAssign(tableName);

	}

	public void test2DashboardEmenuNavigate() throws UiObjectNotFoundException {

		String foodSectionButtonTitle = "food";

		navigateByText(foodSectionButtonTitle);
		// back button navigate
		getUiDevice().pressBack();

	}

	public void test3DropExistingTable() throws UiObjectNotFoundException{

		dropTableFromDashboard();		

	}
}
