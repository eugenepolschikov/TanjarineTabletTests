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
		String carouselSectionName = "FEATURED DRINKS";
		navigateByText(carouselSectionName);

		String carouselClass = "org.lucasr.twowayview.TwoWayView";

		UiScrollable carousel = new UiScrollable(new UiSelector().className(
				carouselClass).scrollable(true));

		int carouselLength = carousel.getChildCount(new UiSelector()
				.className("android.widget.ImageView"));

		int timesToScroll = carouselLength + 2;
		int rightDirectinoToScroll = 1;
		int leftDirectionToScroll = -1;

		// carousel swipe implementation (RIGHT direction)
		carouselSwipe(carousel, timesToScroll, rightDirectinoToScroll);

		// carousel swipe implementation (LEFT direction)
		carouselSwipe(carousel, timesToScroll, leftDirectionToScroll);

		// getting back to dashboard
		getUiDevice().pressBack();
		getUiDevice().pressBack();
		getUiDevice().pressBack();

	}

	public void test4GetBackToDashboardAndDropTheTable()
			throws UiObjectNotFoundException {

		dropTableFromDashboard();
	}

}
