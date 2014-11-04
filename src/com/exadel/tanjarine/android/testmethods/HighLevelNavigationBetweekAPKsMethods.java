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

	public void carouselSwipe(UiScrollable carousel, int timesToScroll,
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
			UiObject testItem=	uiElementInit(selector);
			android.graphics.Rect a=testItem.getBounds();
			UiSelector b=testItem.getSelector();
			android.graphics.Rect c = testItem.getVisibleBounds();
			
			return true;
		}

		catch (UiObjectNotFoundException e) {
			// TODO Auto-generated catch block
			return false;
		}

	}

}
