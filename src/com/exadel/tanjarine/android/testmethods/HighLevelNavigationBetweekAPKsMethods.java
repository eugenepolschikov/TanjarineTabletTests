package com.exadel.tanjarine.android.testmethods;

//Import the uiautomator libraries
import com.android.uiautomator.core.UiObject;
import com.android.uiautomator.core.UiObjectNotFoundException;
import com.android.uiautomator.core.UiScrollable;
import com.android.uiautomator.core.UiSelector;
import com.android.uiautomator.testrunner.UiAutomatorTestCase;

public class HighLevelNavigationBetweekAPKsMethods extends UiAutomatorTestCase {

	protected UiObject uiElementInit(UiSelector selector)
			throws UiObjectNotFoundException {
		return new UiObject(selector);
	}

	public void dropTableFromDashboard() throws UiObjectNotFoundException {
		/*
		 * UiObject callServerIcon = new UiObject(new UiSelector().className(
		 * "android.widget.ImageView").longClickable(true)
		 * 
		 * );
		 */

		UiObject callServerIcon = uiElementInit(new UiSelector().className(
				"android.widget.ImageView").longClickable(true));

		callServerIcon.longClick();

		String codeToDropTable = "357159";

		UiObject passInputToDropTable = uiElementInit(new UiSelector()
				.className(android.widget.EditText.class.getName()));
		passInputToDropTable.setText(codeToDropTable);

		UiObject okButton = uiElementInit(new UiSelector().text("OK"));
		okButton.clickAndWaitForNewWindow(3000);

	}

	public void navigateByText(String textPattern)
			throws UiObjectNotFoundException {
		UiObject foodeMenu = uiElementInit(new UiSelector().text(textPattern));

		foodeMenu.clickAndWaitForNewWindow(4000);
	}

	public void newTableAssign(String tableName)
			throws UiObjectNotFoundException {

		UiObject tableNameinput = uiElementInit(new UiSelector()
				.className(android.widget.EditText.class.getName()));

		tableNameinput.click();
		tableNameinput.setText(tableName);
		// press assign button

		UiObject assignButton = uiElementInit(new UiSelector().className(
				android.widget.Button.class.getName()).index(4));
		assignButton.clickAndWaitForNewWindow(7000);

	}

	public void carouselSingleSwipe(UiScrollable carousel, int timesToScroll,
			int direction) throws UiObjectNotFoundException {

		int carouselLength = carousel.getChildCount(new UiSelector()
				.className("android.widget.ImageView"));

		// NOTE: 'direction' variable stands for direction, if (direction>=0) =>
		// scrolling carousel from right to left ;
		// from left to right otherwise
		// setting up direction of carousel via if-else
		int directionSet;
		if (direction >= 0) {
			directionSet = carouselLength - 1;
		} else {
			directionSet = 1;
		}
		for (int i = 0; i <= timesToScroll; i++) {
			// Looping through each linear layout view

			UiObject drinkItem = carousel.getChild(new UiSelector().className(
					"android.widget.ImageView").instance(directionSet));

			drinkItem.clickAndWaitForNewWindow(1500);
		}

	}

	public boolean isItemPresent(UiSelector selector) {

		try {
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			UiObject testItem = uiElementInit(selector);
			android.graphics.Rect a = testItem.getBounds();
			UiSelector b = testItem.getSelector();
			android.graphics.Rect c = testItem.getVisibleBounds();

			return true;
		}

		catch (UiObjectNotFoundException e) {
			// TODO Auto-generated catch block
			return false;
		}

	}

	public void carouselLongSwipe() throws UiObjectNotFoundException,
			InterruptedException {
		String carouselClass = "org.lucasr.twowayview.TwoWayView";

		UiScrollable carousel = new UiScrollable(new UiSelector().className(
				carouselClass).scrollable(true));

		// final int STEPS_TO_SWIPE=carousel.getMaxSearchSwipes();
		final int STEPS_TO_SWIPE = 8;

		carousel.swipeLeft(STEPS_TO_SWIPE);
		Thread.sleep(3000);
		carousel.swipeRight(STEPS_TO_SWIPE);
		Thread.sleep(3000);
	}

	public void rollingCarouselInBothDirections()
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
		carouselSingleSwipe(carousel, timesToScroll, rightDirectinoToScroll);

		// carousel swipe implementation (LEFT direction)
		carouselSingleSwipe(carousel, timesToScroll, leftDirectionToScroll);
	}

	public void headerNavigateOverFoodCategories()
			throws UiObjectNotFoundException {
		String headerFoodItemsScrolling = "android.widget.HorizontalScrollView";

		UiScrollable foodHeader = new UiScrollable(new UiSelector().className(
				headerFoodItemsScrolling).scrollable(true));

		// @Todo :get list of items that are not expected to be clicked

		// DIRECTION of header categories clicking: from LEFT to RIGHT!
		// subFocus - first category select

		// ============== FIRST PART SCROLLING ====================
		UiObject firstFoodCategory = foodHeader.getChild(new UiSelector()
				.className("android.widget.TextView").instance(0));

		firstFoodCategory.clickAndWaitForNewWindow(1000);

		int headerItemsNum = foodHeader.getChildCount(new UiSelector()
				.className("android.widget.TextView"));

		String flag1 = "";
		String flag2 = "";

		if (headerItemsNum >= 5) {
			// starting counter from 1 as 0 index has been previously selected
			for (int i = 1; i < 5; i++) {
				UiObject foodSectionTitle = foodHeader
						.getChild(new UiSelector().className(
								"android.widget.TextView").instance(i));

				foodSectionTitle.clickAndWaitForNewWindow(1000);
			}

			// setting text for 6th item

			UiObject foodGroup6th = foodHeader.getChild(new UiSelector()
					.className("android.widget.TextView").instance(5));

			flag1 = foodGroup6th.getText().trim();
			foodGroup6th.clickAndWaitForNewWindow(1000);

			foodHeader = new UiScrollable(new UiSelector().className(
					headerFoodItemsScrolling).scrollable(true));
			flag2 = foodHeader
					.getChild(
							new UiSelector().className(
									"android.widget.TextView").instance(5))
					.getText().trim();

			int foodHeaderLength = foodHeader.getChildCount(new UiSelector()
					.className("android.widget.TextView"));

			while (!flag2.equals(flag1)) {
				flag1 = flag2;
				foodHeader.getChild(
						new UiSelector().className("android.widget.TextView")
								.instance(foodHeaderLength - 5))
						.clickAndWaitForNewWindow(2000);
				foodHeader = new UiScrollable(new UiSelector().className(
						headerFoodItemsScrolling).scrollable(true));
				foodHeaderLength = foodHeader.getChildCount(new UiSelector()
						.className("android.widget.TextView"));

				flag2 = foodHeader
						.getChild(
								new UiSelector().className(
										"android.widget.TextView").instance(
										foodHeaderLength - 5)).getText().trim();
			}

			// =========== SCROLLING THE LAST PART OF HEADER
			// =====================
			UiObject toClick;
			for (int count = foodHeaderLength - 4; count < foodHeaderLength - 2; count++) {

				toClick = foodHeader.getChild(new UiSelector().className(
						"android.widget.TextView").instance(count));

				toClick.clickAndWaitForNewWindow(2000);

				foodHeader = new UiScrollable(new UiSelector().className(
						headerFoodItemsScrolling).scrollable(true));
				foodHeaderLength = foodHeader.getChildCount(new UiSelector()
						.className("android.widget.TextView"));

			}

			// ============== SCROLLING OF HEADER is ENDED; END IF ============

		}

		// ========= in case header categories NUM is small number
		else if (headerItemsNum < 5) {
			for (int i = 1; i < headerItemsNum; i++) {
				UiObject foodSectionTitle = foodHeader
						.getChild(new UiSelector().className(
								"android.widget.TextView").instance(i));

				foodSectionTitle.clickAndWaitForNewWindow(1000);
			}

		}
	}

}
