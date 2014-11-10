package com.exadel.tanjarine.android.tests;

import com.android.uiautomator.core.*;
//import com.android.uiautomator.core.UiObjectNotFoundException;
//import com.android.uiautomator.core.UiScrollable;
//import com.android.uiautomator.core.UiSelector;
import com.exadel.tanjarine.android.testmethods.HighLevelNavigationBetweekAPKsMethods;

public class DrinksCarouselTests extends HighLevelNavigationBetweekAPKsMethods {

	public void test1TableAssign() throws UiObjectNotFoundException {
		String tableName = "test_1";

		newTableAssign(tableName);
	}

	public void test2NavigateToDrinks() throws UiObjectNotFoundException {

		String drinksSection = "drink";
		navigateByText(drinksSection);

	}

	public void test3PickupCarouselSectionAndSwipe()
			throws UiObjectNotFoundException {
		rollingCarouselInBothDirections();

	}

	public void test4swipeCarouselFastInBothDirections()
			throws UiObjectNotFoundException, InterruptedException {

		carouselLongSwipe();

	}

	public void test5GetBackToDashboardAndDropTheTable()
			throws UiObjectNotFoundException {

		// getting back to dashboard
		getUiDevice().pressBack();
		getUiDevice().pressBack();
		getUiDevice().pressBack();

		dropTableFromDashboard();
	}

}
