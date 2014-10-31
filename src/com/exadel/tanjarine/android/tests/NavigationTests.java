package com.exadel.tanjarine.android.tests;

import com.android.uiautomator.core.UiObject;
import com.android.uiautomator.core.UiObjectNotFoundException;
import com.android.uiautomator.core.UiSelector;
import com.exadel.tanjarine.android.testmethods.HighLevelNavigationBetweekAPKsMethods;
//import org.apache.commons.lang.*;;

public class NavigationTests extends  HighLevelNavigationBetweekAPKsMethods {




	public void test1NewTableAssignment(){
		String aa="test_1";
		UiObject tableNameinput = new UiObject(new UiSelector().className(android.widget.EditText.class.getName()));
		try {
			tableNameinput.click();
			tableNameinput.setText(aa/*+RandomStringUtils.randomAlphabetic(4)*/);
		} catch (UiObjectNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}



		//		 press assign button


		UiObject  assignButton= new UiObject(new UiSelector().className(android.widget.Button.class.getName()).index(4));
		try {
			assignButton.clickAndWaitForNewWindow(6000);
		} catch (UiObjectNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}



		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}



	public void test2DashboardEmenuNavigate(){



		UiObject foodeMenu = new UiObject(new UiSelector().text("food"));
		try {
			foodeMenu.clickAndWaitForNewWindow(3000);
		} catch (UiObjectNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		// back button navigate
		getUiDevice().pressBack();


	}  

	public void test3DropExistingTable() throws UiObjectNotFoundException{


		// back button navigate to unwake the device
		//getUiDevice().pressBack();

		//call server click 
		
		//UiObject  callServerIcon= new UiObject(new UiSelector().className(android.widget.TextView.class.getName()));
		
		/*
		UiObject  callServerIcon=new UiObject(
				 new UiSelector()
		   .className("android.widget.RelativeLayout").instance(1)
		   .childSelector(new UiSelector().className("android.widget.ImageView"))
		   );
		*/
		
		
		UiObject  callServerIcon=new UiObject(
				new UiSelector().className("android.widget.ImageView").longClickable(true)
		   
		   );
		
		
		
		/*UiObject  callServerIcon=new UiObject(
				new UiSelector().className("android.widget.TextView").fromParent(
						new UiSelector().className("android.widget.RelativeLayout")));*/
		
		callServerIcon.longClick();
		
	
		
		//357159
		
		UiObject  passInputToDropTable= new UiObject(new UiSelector().className(android.widget.EditText.class.getName()));
		passInputToDropTable.setText("357159");
		
		UiObject okButton = new UiObject(new UiSelector().text("OK"));
		okButton.clickAndWaitForNewWindow(4000);



	}
}
