package com.exadel.tanjarine.android.tests;

import com.android.uiautomator.core.UiCollection;
import com.android.uiautomator.core.UiObject;
import com.android.uiautomator.core.UiObjectNotFoundException;
import com.android.uiautomator.core.UiScrollable;
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

		
		
	}
	
	public void test3HeaderMenuCategoriesNavigation() throws UiObjectNotFoundException { 
		// navigate through all food categories
		String headerFoodItemsScrolling = "android.widget.HorizontalScrollView";

		UiScrollable foodHeader = new UiScrollable(new UiSelector().className(
				headerFoodItemsScrolling).scrollable(true));

		
		// get list of items that are not expected to be clicked
		
		
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

			int foodHeaderLength= foodHeader.getChildCount(new UiSelector()
			.className("android.widget.TextView"));			
			
			while (!flag2.equals(flag1)) {
				flag1 = flag2;
				foodHeader.getChild(
						new UiSelector().className("android.widget.TextView")
								.instance(foodHeaderLength-5)).clickAndWaitForNewWindow(2000);
				foodHeader = new UiScrollable(new UiSelector().className(
						headerFoodItemsScrolling).scrollable(true));
				foodHeaderLength= foodHeader.getChildCount(new UiSelector()
				.className("android.widget.TextView"));
				
				
				
				flag2 = foodHeader
						.getChild(
								new UiSelector().className(
										"android.widget.TextView").instance(foodHeaderLength-5))
						.getText().trim();
			}
			
//	=========== SCROLLING THE LAST PART OF HEADER =====================
			UiObject toClick;			
			for(int count =foodHeaderLength-4; count<foodHeaderLength-2; count++) {
				

			toClick= foodHeader.getChild(
						new UiSelector().className("android.widget.TextView")
								.instance(count));

				toClick.clickAndWaitForNewWindow(2000);				
				
				
				foodHeader = new UiScrollable(new UiSelector().className(
						headerFoodItemsScrolling).scrollable(true));
				foodHeaderLength= foodHeader.getChildCount(new UiSelector()
				.className("android.widget.TextView"));
				
				/*if(foodHeaderLength<9) {
					foodHeader.getChild(
							new UiSelector().className("android.widget.TextView")
									.instance(0)).clickAndWaitForNewWindow(1500);
					
					foodHeader = new UiScrollable(new UiSelector().className(
							headerFoodItemsScrolling).scrollable(true));
					foodHeaderLength= foodHeader.getChildCount(new UiSelector()
					.className("android.widget.TextView"));
				}*/
				
				
				//UiCollection aa=new  UiCollection(new UiSelector());
				
				
							
			}
			
//			============== SCROLLING OF HEADER is ENDED  ============
			
			

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

	public void test4DropExistingTable() throws UiObjectNotFoundException {
		
		

		getUiDevice().pressBack();
		getUiDevice().pressBack();


		dropTableFromDashboard();

	}
}
