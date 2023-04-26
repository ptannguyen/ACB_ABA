package common

import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject

import com.kms.katalon.core.annotation.Keyword
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile
import com.kms.katalon.core.model.FailureHandling
import com.kms.katalon.core.testobject.TestObject
import com.kms.katalon.core.util.KeywordUtil
import io.appium.java_client.AppiumDriver
import io.appium.java_client.MobileElement
import com.kms.katalon.core.mobile.keyword.internal.MobileDriverFactory
import com.kms.katalon.core.webui.driver.DriverFactory as DriverFactory
import org.openqa.selenium.WebElement as WebElement
import org.openqa.selenium.By as By
import com.kms.katalon.core.webui.common.WebUiCommonHelper as WebUiCommonHelper
import com.kms.katalon.core.mobile.helper.MobileCommonHelper as MobileCommonHelper
import com.kms.katalon.core.mobile.helper.AndroidHelper as AndroidHelper
import com.kms.katalon.core.mobile.helper.MobileElementCommonHelper as MobileElementCommonHelper
import com.kms.katalon.core.helper.KeywordHelper
import internal.GlobalVariable

/**
 * <b>General description:</b> List out some common keywords used for mobile application<p></p>
 * 
 * <b>Keyword list:</b>
 * 
 * <pre>
 * 	<b>{@link #verifyObjectPresent verifyObjectPresent}</b>
 * 	<b>{@link #verifyObjectVisible verifyObjectVisible}</b>
 * 	<b>{@link #verifyObjectEnabled verifyObjectEnabled}</b>
 * 	<b>{@link #verifyObjectChecked verifyObjectChecked}</b>
 * 	<b>{@link #inputDataToTestobject inputDataToTestObject}</b>
 * 	<b>{@link #printStepMessage printStepMessage}</b>
 * 	<b>{@link #clickToRadioButton clickToRadioButton}</b>
 * 	<b>{@link #clickToCheckBox clickToCheckBox}</b>
 * 	<b>{@link #clickToButton clickToButton}</b>
 * 	<b>{@link #getTextFromTestObject getTextFromTestObject}</b>
 * 	<b>{@link #getTextFromInput getTextFromInput}</b>
 * 	<b>{@link #selectListItemByIndex selectListItemByIndex}</b>
 * 	<b>{@link #selectListItemByLabel selectListItemByLabel}</b>
 * 	<b>{@link #selectListViewItem selectListViewItem}</b>
 * 	<b>{@link #selectMenuItem selectMenuItem}</b>
 * 	<b>{@link #swipeFromTopToBottom swipeFromTopToBottom}</b>
 * 	<b>{@link #swipeFromBottomToTop swipeFromBottomToTop}</b>
 * 	<b>{@link #swipeFromRightToLeft swipeFromRightToLeft}</b>
 * 	<b>{@link #swipeFromLeftToRight swipeFromLeftToRight}</b>
 * 	<b>{@link #closeTestApp closeTestApp}</b>
 * 	<b>{@link #verifyItemsInList verifyItemsInList}</b>
 * 	<b>{@link #clickTonItemInList clickTonItemInList}</b>
 * 	<b>{@link #inputListDataToListObject inputListDataToListObject}</b>
 * 	<b>{@link #getOTP getOTP}</b>  
 * 	<b>{@link #verifyBySMSMethod verifyBySMSMethod}</b>
 * 	<b>{@link #inputDataIntoTextBoxPressButtonAndVerifyText inputDataIntoTextBoxPressButtonAndVerifyText}</b>
 * 	<b>{@link #selectDropdownItem selectDropdownItem}</b>
 * 	<b>{@link #selectDropdownItemByListObject selectDropdownItemByListObject}</b>
 * 	<b>{@link #getAllDropdownItemName getAllDropdownItemName}</b>
 * 	<b>{@link #switchLanguage switchLanguage}</b>
 * </pre>
 * 
 * @since 03/03/2023 
 * 
 * @author ABA Automation team
 */
public class MobileCommon {
	/**
	 * Custom keyword name: verifyObjectPresent(TestObject objPath, int iTimeOut)</br></br>
	 *
	 * General description: Custom keyword is used for verify object existence on a mobile application
	 *
	 * @param objPath	: The object name in the Object Repository
	 * @param iTimeOut	: The maximum time for waiting object is displayed on mobile application
	 *
	 * @return
	 *			true if element presents; otherwise, false
	 *
	 * @since 05/02/2023
	 *
	 * @author ABA Automation team
	 */
	@Keyword
	def static Boolean verifyObjectPresent(TestObject objPath, int iTimeOut) {
		try{
			//Verify that the object exists or not
			if(Mobile.verifyElementExist(objPath, iTimeOut, FailureHandling.CONTINUE_ON_FAILURE)) {
				//System.out.println("The object is existence.")
				return true
			} else {
				KeywordUtil.markFailed(GlobalVariable.GMsgCKW01 + objPath.objectId.split('/').last() + GlobalVariable.GMsgCKW05)
				return false
			}
		} catch(Exception ex) {
			KeywordUtil.markFailed(GlobalVariable.GMsgCKW25)
			return false
		}
	}

	/**
	 * Custom keyword name: verifyObjectVisible(TestObject objPath, int iTimeOut)</br></br>
	 *
	 * General description: Custom keyword is used for verify object visible on a mobile application
	 *
	 * @param objPath	: The object name in the Object Repository
	 * @param iTimeOut	: The maximum time for waiting object is displayed on mobile application
	 *
	 * @return
	 *			true if element presents; otherwise, false
	 *
	 * @since 05/02/2023
	 *
	 * @author ABA Automation team
	 */
	@Keyword
	def static Boolean verifyObjectVisible(TestObject objPath, int iTimeOut) {
		try{
			//Verify that the object exists or not
			if(Mobile.verifyElementVisible(objPath, iTimeOut, FailureHandling.CONTINUE_ON_FAILURE)) {
				//System.out.println("The object is visible.")
				return true
			} else {
				KeywordUtil.markFailed(GlobalVariable.GMsgCKW01 + objPath.objectId.split('/').last() + GlobalVariable.GMsgCKW10)
				return false
			}
		} catch(Exception ex) {
			KeywordUtil.markFailed(GlobalVariable.GMsgCKW25)
			return false
		}
	}

	/**
	 * Custom keyword name: verifyObjectEnabled(TestObject objPath, int iTimeOut)</br></br>
	 *
	 * General description: Custom keyword is used for verify object enabled on a mobile application
	 *
	 * @param objPath	: The object name in the Object Repository
	 * @param iTimeOut	: The maximum time for waiting object is displayed on mobile application
	 *
	 * @return
	 *			true if the element is present and clickable; otherwise, false
	 *
	 * @since 05/02/2023
	 *
	 * @author ABA Automation team
	 */
	@Keyword
	def static Boolean verifyObjectEnabled(TestObject objPath, int iTimeOut) {
		try{
			//Verify that the object is enabled or not
			if(Mobile.verifyElementAttributeValue(objPath, "enabled", "true", iTimeOut)) {
				//System.out.println("The object is enabled.")
				return true
			} else {
				KeywordUtil.markFailed(GlobalVariable.GMsgCKW01 + objPath.objectId.split('/').last() + GlobalVariable.GMsgCKW15)
				return false
			}
		} catch(Exception ex) {
			KeywordUtil.markFailed(GlobalVariable.GMsgCKW25)
			return false
		}
	}

	/**
	 * Custom keyword name: verifyObjectNotChecked(TestObject objPath, int iTimeOut)</br></br>
	 *
	 * General description: Custom keyword is used for verify if the given object is not checked on a mobile application
	 *
	 * @param objPath	: The object name in the Object Repository
	 * @param iTimeOut	: The maximum time for waiting object is displayed on mobile application
	 *
	 * @return
	 *			true if the element is present and clickable; otherwise, false
	 *
	 * @since 05/02/2023
	 *
	 * @author ABA Automation team
	 */	
	@Keyword
	def static Boolean verifyObjectNotChecked(TestObject objPath, int iTimeOut) {
		try{
			//Verify that the object is enabled or not
			if(Mobile.verifyElementNotChecked(objPath, iTimeOut, FailureHandling.CONTINUE_ON_FAILURE) == true) {
				return true
			} else {
				KeywordUtil.markFailed(GlobalVariable.GMsgCKW01 + objPath.objectId.split('/').last() + GlobalVariable.GMsgCKW20)
				return false
			}
		} catch(Exception ex) {
			KeywordUtil.markFailed(GlobalVariable.GMsgCKW25)
			return false
		}
	}

	/**
	 * Custom keyword name: inputDataToTestObject(String sObjPath, String sText, int iTimeOut)</br></br>
	 *
	 * General description: Custom keyword is used for inputting a text string to object on a mobile application
	 *
	 * @param objPath	: The object name in the Object Repository
	 * @param sText		: The text string is input in object
	 * @param iTimeOut	: The maximum time for waiting object is displayed on mobile application
	 *
	 * @return
	 * 			none
	 *
	 * @since 05/02/2023
	 *
	 * @author ABA Automation team
	 */
	@Keyword
	def static void inputDataToTestObject(TestObject objPath, String sText, int iTimeOut) {
		try{
			if(verifyObjectPresent(objPath, iTimeOut) == true) {
				if(verifyObjectEnabled(objPath, iTimeOut) == true) {
					Mobile.sendKeys(objPath, sText)
					if(getTextFromObject(objPath, iTimeOut).equals(sText)) {
						//KeywordUtil.markPassed("The object is inputed data successful.")
					} else {
						KeywordUtil.markFailed(GlobalVariable.GMsgCKW30)
					}
				}
			}
		} catch(Exception ex) {
			KeywordUtil.markFailed(GlobalVariable.GMsgCKW55 + objPath.objectId.split('/').last() + GlobalVariable.GMsgCKW56)
		}
	}

	/**
	 * Custom keyword name: printStepMessage(String sPageNameOrScreen, String sAction, String sObjName)</br></br>
	 *
	 * General description: Custom keyword is used for print step message to console
	 *
	 * @param sPageNameOrScreen	: The name of page or screen
	 * @param sAction      		: The name of action
	 * @param objName    		: The name of object
	 *
	 * @return
	 * 			None
	 *
	 * @since 17/02/2023
	 *
	 * @author ABA Automation team
	 */

	@Keyword
	def static void printStepMessage(String sPageNameOrScreen, String sAction, String sObjName) {
		KeywordUtil.logInfo(sPageNameOrScreen + " - " + sAction + " - " + sObjName)
	}

	/**
	 * Custom keyword name: clickToRadioButton(String sObjPath, int iTimeOut)</br></br>
	 *
	 * General description: Custom keyword is used for clicked a radio button on a mobile application
	 *
	 * @param objPath	: The object name in the Object Repository
	 * @param iTimeOut	: The maximum time for waiting object is displayed on mobile application
	 *
	 * @return
	 * 			none
	 *
	 * @since 05/02/2023
	 *
	 * @author ABA Automation team
	 */
	@Keyword
	def static void clickToRadioButton(TestObject objPath, int iTimeOut) {
		try{
			//Verify that the object exists or not and verify that the object is enabled or not
			if(verifyObjectPresent(objPath, iTimeOut) == true) {
				if(verifyObjectEnabled(objPath, iTimeOut) == true) {
					//Verify that the object is checked or not
					if(verifyObjectNotChecked(objPath, iTimeOut) == true) {
						Mobile.tap(objPath, iTimeOut)
						//System.out.println("The object is clicked successful.")
					}
				}
			}
		} catch(Exception ex) {
			KeywordUtil.markFailed(GlobalVariable.GMsgCKW55 + objPath.objectId.split('/').last() + GlobalVariable.GMsgCKW56)
		}
	}

	/**
	 * Custom keyword name: clickToCheckBox(TestObject objPath, int iTimeOut)</br></br>
	 *
	 * General description: Custom keyword is used for clicked a check box on a mobile application
	 *
	 * @param objPath	: The object name in the Object Repository
	 * @param iTimeOut	: The maximum time for waiting object is displayed on mobile application
	 *
	 * @return
	 * 			none
	 *
	 * @since 05/02/2023
	 *
	 * @author ABA Automation team
	 */
	@Keyword
	def static void clickToCheckBox(TestObject objPath, int iTimeOut) {
		try{
			//Verify that the object exists or not and verify that the object is enabled or not
			if(verifyObjectPresent(objPath, iTimeOut) == true) {
				if(verifyObjectEnabled(objPath, iTimeOut) == true) {
					//Verify that the object is checked or not
					if(verifyObjectNotChecked(objPath, iTimeOut) == true) {
						Mobile.tap(objPath, iTimeOut)
						//System.out.println("The object is clicked successful.")
					}
				}
			}
		} catch(Exception ex) {
			KeywordUtil.markFailed(GlobalVariable.GMsgCKW55 + objPath.objectId.split('/').last() + GlobalVariable.GMsgCKW56)
		}
	}

	/**
	 * Custom keyword name: clickToButton(TestObject objPath, int iTimeOut)</br></br>
	 *
	 * General description: Custom keyword is used for clicked a button on a mobile application
	 *
	 * @param objPath	: The represent a web element in the Object Repository
	 * @param iTimeOut	: The maximum time for waiting object is displayed on mobile application
	 *
	 * @return
	 * 			none
	 *
	 * @since 05/02/2023
	 *
	 * @author ABA Automation team
	 */
	@Keyword
	def static void clickToButton(TestObject objPath, int iTimeOut) {
		try{
			if(verifyObjectPresent(objPath, iTimeOut) == true) {
				if(verifyObjectEnabled(objPath, iTimeOut) == true) {
					Mobile.tap(objPath, iTimeOut)
					//KeywordUtil.markPassed("The object is clicked successful.")
				}
			}
		} catch(Exception ex) {
			KeywordUtil.markFailed(GlobalVariable.GMsgCKW55 + objPath.objectId.split('/').last() + GlobalVariable.GMsgCKW56)
		}
	}

	/**
	 * Custom keyword name: getTextFromObject(TestObject objPath, int iTimeOut)</br></br>
	 *
	 * General description: Custom keyword is used for getting a text string from object(button, radio button, label,...) on a mobile application
	 *
	 * @param objPath	: The object name in the Object Repository
	 * @param iTimeOut	: The maximum time for waiting object is displayed on mobile application
	 *
	 * @return
	 * 			innerText of the test object
	 *
	 * @since 05/02/2023
	 *
	 * @author ABA Automation team
	 */	
	@Keyword
	def static String getTextFromObject(TestObject objPath, int iTimeOut) {
		try{
			if(verifyObjectPresent(objPath, iTimeOut) == true) {
				if(verifyObjectEnabled(objPath, iTimeOut) == true) {
					return Mobile.getText(objPath, iTimeOut)
				}
			}
		} catch(Exception ex) {
			KeywordUtil.markFailed(GlobalVariable.GMsgCKW55 + objPath.objectId.split('/').last() + GlobalVariable.GMsgCKW56)
		}
	}

	/**
	 * Custom keyword name: getTextFromObjectByInput(TestObject objPath, int iTimeOut)</br></br>
	 *
	 * General description: Custom keyword is used for getting a text string from object(with html tag name input) on a mobile application
	 *
	 * @param objPath		: The object name in the Object Repository
	 * @param iTimeOut		: The maximum time for waiting object is displayed on mobile application
	 *
	 * @return
	 * 			innerText of the test object
	 *
	 * @since 05/02/2023
	 *
	 * @author ABA Automation team
	 */
	@Keyword
	def static String getTextFromObjectByInput(TestObject objPath, int iTimeOut) {
		try{
			if(verifyObjectPresent(objPath, iTimeOut) == true) {
				if(verifyObjectEnabled(objPath, iTimeOut) == true) {
					return Mobile.getAttribute(objPath, "value", iTimeOut)
				}
			}
		} catch(Exception ex) {
			KeywordUtil.markFailed(GlobalVariable.GMsgCKW55 + objPath.objectId.split('/').last() + GlobalVariable.GMsgCKW56)
		}
	}


	/**
	 * Custom keyword name: selectListItemByIndex(TestObject objPath, int itemIndex, int iTimeOut)</br></br>
	 *
	 * General description: Custom keyword is used for select item on list view control that have a index matching the "index" argument on a mobile application
	 *
	 * @param objPath		: The object name in the Object Repository
	 * @param itemIndex		: The index index range of the options to select from object. Index starts from 0.
	 * @param iTimeOut		: The maximum time for waiting object is displayed on mobile application
	 *
	 * @return
	 * 			none
	 *
	 * @since 05/02/2023
	 *
	 * @author ABA Automation team
	 */
	@Keyword
	def static void selectListItemByIndex(TestObject objPath, int sItemIndex, int iTimeOut) {
		try{
			//Verify that the object exists or not and enable or disable
			if(verifyObjectPresent(objPath, iTimeOut) == true) {
				if (verifyObjectEnabled(objPath, iTimeOut) == true) {
					if(sItemIndex >= 0) {
						Mobile.selectListItemByIndex(objPath, sItemIndex, iTimeOut)
					} else {
						KeywordUtil.markFailed(GlobalVariable.GMsgCKW35)
					}
				}
			}
		} catch(Exception ex) {
			KeywordUtil.markFailed(GlobalVariable.GMsgCKW55 + objPath.objectId.split('/').last() + GlobalVariable.GMsgCKW56)
		}
	}

	/**
	 * Custom keyword name: selectListItemByLabel(TestObject objPath, String itemValue, int iTimeOut)</br></br>
	 *
	 * General description: Custom keyword is used for select item on list view control that have a value matching the "value" argument on a mobile application
	 *
	 * @param objPath		: The object name in the Object Repository
	 * @param itemValue		: The value of the options to select from object
	 * @param iTimeOut		: The maximum time for waiting object is displayed on mobile application
	 *
	 * @return
	 * 			none
	 *
	 * @since 05/02/2023
	 *
	 * @author ABA Automation team
	 */
	@Keyword
	def static void selectListItemByLabel(TestObject objPath, String sItemValue, int iTimeOut) {
		try{
			//Verify that the object exists or not
			if(verifyObjectPresent(objPath, iTimeOut) == true) {
				if (verifyObjectEnabled(objPath, iTimeOut) == true) {
					if(!sItemValue.equals("")) {
						Mobile.selectListItemByLabel(objPath, sItemValue, iTimeOut)
					} else {
						KeywordUtil.markFailed(GlobalVariable.GMsgCKW45)
					}
				}
			}
		} catch(Exception ex) {
			KeywordUtil.markFailed(GlobalVariable.GMsgCKW55 + objPath.objectId.split('/').last() + GlobalVariable.GMsgCKW56)
		}
	}

	/**
	 * Custom keyword name: selectListViewItem(TestObject objPath, int iTimeout)</br></br>
	 *
	 * General description: Custom keyword is used to click an item from listview on a mobile application
	 *
	 * @param objPath		: The object name in the Object Repository
	 * @param iTimeOut		: The maximum time for waiting object is displayed on mobile application
	 *
	 * @return
	 * 			none
	 *
	 * @since 05/02/2023
	 *
	 * @author ABA Automation team
	 */
	@Keyword
	def static void selectListViewItem(TestObject objPath, int iTimeout) {
		try {
			if(verifyObjectPresent(objPath, iTimeout) == true) {
				if(verifyObjectEnabled(objPath, iTimeout) == true) {
					Mobile.tap(objPath, iTimeout)
				}
			}
		} catch(Exception ex) {
			KeywordUtil.markFailed(GlobalVariable.GMsgCKW55 + objPath.objectId.split('/').last() + GlobalVariable.GMsgCKW56)
		}
	}

	/**
	 * Custom keyword name: selectMenuItem(TestObject objPath, int iTimeout)</br></br>
	 *
	 * General description: Custom keyword is used to click an item from Menu on a mobile application
	 *
	 * @param objPath		: The object name in the Object Repository
	 * @param iTimeOut		: The maximum time for waiting object is displayed on mobile application
	 *
	 * @return
	 * 			none
	 *
	 * @since 05/02/2023
	 *
	 * @author ABA Automation team
	 */
	@Keyword
	def static void selectMenuItem(TestObject objPath, int iTimeout) {
		try {
			if(verifyObjectPresent(objPath, iTimeout) == true) {
				if(verifyObjectEnabled(objPath, iTimeout) == true) {
					Mobile.tap(objPath, iTimeout)
				}
			}
		} catch(Exception ex) {
			KeywordUtil.markFailed(GlobalVariable.GMsgCKW55 + objPath.objectId.split('/').last() + GlobalVariable.GMsgCKW56)
		}
	}

	/**
	 * Custom keyword name: swipeFromTopToBottom(int iFrom, int iTo)</br></br>
	 *
	 * General description: Custom keyword is used to swipe Vertical from top to bottom on a mobile application
	 *
	 * @param iFrom		: Position ready to swipe 
	 * @param iTo		: Position to end swipe
	 *
	 * @return
	 * 			none
	 *
	 * @since 05/02/2023
	 *
	 * @author ABA Automation team
	 */
	@Keyword
	def static void swipeFromTopToBottom(int iFrom, int iTo) {
		try {
			Mobile.swipe(0, iTo, 0, iFrom)
		} catch(Exception ex) {
			KeywordUtil.markFailed(GlobalVariable.GMsgCKW90)
		}
	}

	/**
	 * Custom keyword name: swipeFromBottomToTop(int iFrom, int iTo)</br></br>
	 *
	 * General description: Custom keyword is used to swipe Vertical from bottom to top on a mobile application
	 *
	 * @param iFrom		: Position ready to swipe 
	 * @param iTo		: Position to end swipe
	 *
	 * @return
	 * 			none
	 *
	 * @since 05/02/2023
	 *
	 * @author ABA Automation team
	 */
	@Keyword
	def static void swipeFromBottomToTop(int iFrom, int iTo) {
		try {
			Mobile.swipe(0, iFrom, 0, iTo)
		} catch(Exception ex) {
			KeywordUtil.markFailed(GlobalVariable.GMsgCKW90)
		}
	}

	/**
	 * Custom keyword name: swipeFromRightToLeft(int iFrom, int iTo)</br></br>
	 *
	 * General description: Custom keyword is used to swipe Horizontal from right to left on a mobile application
	 *
	 * @param iFrom		: Position ready to swipe
	 * @param iTo		: Position to end swipe
	 *
	 * @return
	 * 			none
	 *
	 * @since 05/02/2023
	 *
	 * @author ABA Automation team
	 */
	@Keyword
	def static void swipeFromRightToLeft(int iFrom, int iTo) {
		try {
			Mobile.swipe(iFrom, 0, iTo, 0)
		} catch(Exception ex) {
			KeywordUtil.markFailed(GlobalVariable.GMsgCKW90)
		}
	}

	/**
	 * Custom keyword name: swipeFromLeftToRight(int iFrom, int iTo)</br></br>
	 *
	 * General description: Custom keyword is used to swipe Horizontal from left to right on a mobile application
	 *
	 * @param iFrom		: Position ready to swipe
	 * @param iTo		: Position to end swipe
	 *
	 * @return
	 * 			none
	 *
	 * @since 05/02/2023
	 *
	 * @author ABA Automation team
	 */
	@Keyword
	def static void swipeFromLeftToRight(int iFrom, int iTo) {
		try {
			Mobile.swipe(iTo, 0, iFrom, 0)
		} catch(Exception ex) {
			KeywordUtil.markFailed(GlobalVariable.GMsgCKW90)
		}
	}

	/**
	 * Custom keyword name: closeTestApp(String appId)</br></br>
	 *
	 * General description: Custom keyword is used to close application
	 *
	 * @param appId		: The application ID
	 *
	 * @return
	 * 			none
	 *
	 * @since 05/02/2023
	 *
	 * @author ABA Automation team
	 */
	@Keyword
	def static void closeTestApp(String sAppId) {
		AppiumDriver<?> driver = MobileDriverFactory.getDriver()
		driver.terminateApp(sAppId)
	}

	/**
	 * Custom keyword name: verifyItemsInList(List<TestObject> testObject, List<String> expectedText, int iTimeOut)
	 *
	 * General description: Custom keyword is used to close application
	 *
	 * @param objList	: The list of objects
	 * @param expectedText	: The list of expected text is used to compare
	 * @param iTimeOut	: The time for waiting object is displayed on web page
	 *
	 * @return
	 * 			none
	 *
	 * @since 05/02/2023
	 *
	 * @author ABA Automation team
	 */
	@Keyword
	def static boolean verifyItemsInList(List<TestObject> objList, List<String> expectedText, int iTimeOut) {
		try {
			def extractedText = []
			for (def obj : objList) {
				if(verifyObjectPresent(obj, iTimeOut)) {
					if (verifyObjectEnabled(obj, iTimeOut)) {
						extractedText.add(Mobile.getText(obj, iTimeOut))
					}
				}
			}
			//Verify that the actual text and expected text is the same as or not
			if (extractedText.equals(expectedText)) {
				//KeywrodUtil.markPassed("Passed!")
				return true
			} else {
				KeywordUtil.markFailed(GlobalVariable.GMsgCKW70 + extractedText + GlobalVariable.GMsgCKW75 + expectedText)
				return false
			}
		} catch (Exception e) {
			KeywordUtil.markFailed(GlobalVariable.GMsgCKW95)
		}
	}

	/**
	 * Custom keyword name: clickTonItemInList(List<TestObject> lObjectList, int iTimeOut)</br></br>
	 *
	 * General description: Custom keyword is used to swipe Horizontal from left to right on a mobile application
	 *
	 * @param lObjectList		: The list object name in repository
	 * @param iTimeOut			: The maximum time for waiting object is displayed on mobile application
	 *
	 * @return
	 * 			none
	 *
	 * @since 28/02/2023
	 *
	 * @author ABA Automation team
	 */
	@Keyword
	def static void clickTonItemInList(List<TestObject> lObjectList, int iTimeOut) {
		try {
			for(TestObject objPath : lObjectList) {
				clickToButton(objPath, iTimeOut)
			}
		} catch(Exception ex) {
			KeywordUtil.markFailed(GlobalVariable.GMsgCKW95)
		}
	}

	/**
	 * Custom keyword name: inputListDataToListObject(List<TestObject> lObjectList, List<String> lText, int iTimeOut)</br></br>
	 *
	 * General description: Custom keyword is used to swipe Horizontal from left to right on a mobile application
	 *
	 * @param lObjectList		: The list object name in repository
	 * @param lText				: The list of texts want to inputting
	 * @param iTimeOut			: The maximum time for waiting object is displayed on mobile application
	 *
	 * @return
	 * 			none
	 *
	 * @since 28/02/2023
	 *
	 * @author ABA Automation team
	 */
	@Keyword
	def static void inputListDataToListObject(List<TestObject> lObjectList, List<String> lText, int iTimeOut) {
		try {
			if(lObjectList.size() == lText.size()) {
				for (int i = 0; i < lObjectList.size(); i++) {
					Mobile.clearText(lObjectList.get(i), iTimeOut)
					inputDataToTestObject(lObjectList.get(i), lText.get(i), iTimeOut)
				}
			}
		} catch(Exception ex) {
			KeywordUtil.markFailed(GlobalVariable.GMsgCKW95)
		}
	}


	/**
	 * Custom keyword name: String getOTP(TestObject objPath, String sApplicationId, int iTimeOut)</br></br>
	 *
	 * General description: Custom keyword is used to open messaging application and get OTP message on a mobile application
	 *
	 * @param lObjectList		: The list object name in repository
	 * @param sVerifyName		: The name of object want to action in list object
	 * @param iTimeOut			: The maximum time for waiting object is displayed on mobile application
	 *
	 * @return
	 * 			none
	 *
	 * @since 28/02/2023
	 *
	 * @author ABA Automation team
	 */
	@Keyword
	def static String getOTP(TestObject objPath, String sApplicationId, int iTimeOut) {
		String sFinalOtp = ""
		String sOtp = ""
		char[] arrDestArray = new char[6]
		try {
			//Start messaging application
			Mobile.startExistingApplication(sApplicationId)
			//Verify object existence and get a string OTP from object
			if (verifyObjectPresent(objPath,iTimeOut)) {
				sOtp = Mobile.getText(objPath, 10).replaceAll("[^0-9]", "")
				if(!sOtp.equals("")) {
					sOtp.getChars(0, 6, arrDestArray, 0)
					//Get OTP value in Array
					for(int i = 0; i < arrDestArray.length; i++) {
						sFinalOtp = sFinalOtp + arrDestArray[i]
					}
					return sFinalOtp
				} else {
					KeywordUtil.markFailed(GlobalVariable.GMsgCKW60)
					return sFinalOtp
				}
			}
		} catch (Exception ex) {
			KeywordUtil.markFailed(GlobalVariable.GMsgCKW65)
		}
	}

	/**
	 * Custom keyword name: verifyBySMSMethod(List<TestObject> lObjectList, String sApplicationIDFirst, String sApplicationIDSecond, int iTimeOut)</br></br>
	 *
	 * General description: Custom keyword is used to verify success screen after make a transaction and verify by SMS method on a mobile application
	 *
	 * @param lObjectList			: The list object name in repository
	 * @param sApplicationIDFirst	: The id of first application
	 * @param sApplicationIDSecond	: The id of second application
	 * @param iTimeOut				: The maximum time for waiting object is displayed on mobile application
	 *
	 * @return
	 * 			none
	 *
	 * @since 28/02/2023
	 *
	 * @author ABA Automation team
	 */
	@Keyword
	def static void verifyBySMSMethod(List<TestObject> lObjectList, String sApplicationIDFirst, String sApplicationIDSecond, int iTimeOut) {
		//Open banking application
		Mobile.startExistingApplication(sApplicationIDFirst)

		//Input password to password text box
		inputDataToTestObject(lObjectList.get(0), GlobalVariable.gPassword, iTimeOut)

		//Click to login button
		clickToButton(lObjectList.get(1), iTimeOut)

		//Click to NapTienDt button
		clickToButton(lObjectList.get(2), iTimeOut)

		//Click to TiepTuc button
		clickToButton(lObjectList.get(3), iTimeOut)

		//Select SMS verify option
		clickToButton(lObjectList.get(4), iTimeOut)
		clickToButton(lObjectList.get(5), iTimeOut)

		//Click to XacNhan button
		clickToButton(lObjectList.get(6), 10)

		//Open messaging application to get OTP
		String finalOtp =  getOTP(lObjectList.get(7), sApplicationIDSecond, 10)

		//Re launch banking application to enter OTP
		Mobile.startExistingApplication(sApplicationIDFirst)

		//Input SMS code to SMS text box
		inputDataToTestObject(lObjectList.get(8), finalOtp, 10)

		//Verify success screen
		//...................
	}

	/**
	 * Custom keyword name: inputDataIntoTextBoxPressbuttonAndVerifyText(List<TestObject> lObjectList,List<String> sExpectedText, int iTimeOut)</br></br>
	 *
	 * General description: Custom keyword is used to input data into text box, press button and verify text after pressing button
	 *
	 * @param lObjectList		: The list of object names in repository
	 * @param lExpectedText		: The list of text items for inputting and verifying
	 * @param iTimeOut			: The maximum time for waiting object is displayed on mobile application
	 *
	 * @return
	 * 			True if input data and press button and verify success. Otherwise false
	 *
	 * @since 28/02/2023
	 *
	 * @author ABA Automation team
	 */
	@Keyword
	def static Boolean inputDataIntoTextBoxPressButtonAndVerifyText(List<TestObject> lObjectList,List<String> lExpectedText, int iTimeOut) {
		String sActualText = ""
		try {
			//Input password to text box and press button
			inputDataToTestObject(lObjectList.get(0), lExpectedText.get(0), iTimeOut)
			clickToButton(lObjectList.get(1), iTimeOut)

			//Get text and verify text after click button
			sActualText = getTextFromObject(lObjectList.get(2), iTimeOut)
			if(sActualText.equals(lExpectedText.get(1))) {
				return true
			} else {
				return false
			}
		} catch (Exception ex) {
			KeywordUtil.markFailed(GlobalVariable.GMsgCKW95)
		}
	}


	/**
	 * Custom keyword name: selectDropdownItem(TestObject objPathDropDown, TestObject sObjPathItemDropDown, int iTimeOut)</br></br>     
	 * 
	 * General description: Custom keyword is used to select item in dropdown on mobile apllication</br></br>     
	 * 
	 * @param objPathDropDown   	: The mobile object drop down in the Object Repository
	 * @param sObjPathItemDropDown  : The item of drop down dynamic object in the Object Repository
	 * @param iTimeOut  			: The time for waiting object is displayed on mobile application
	 *
	 * @return
	 *          none
	 *
	 * @since 05/02/2023
	 *
	 * @author ABA Automation team
	 */
	@Keyword
	def static void selectDropdownItem(TestObject objPathDropDown, TestObject sObjPathItemDropDown, int iTimeOut) {
		try {
			//Click dropdown object
			clickToButton(objPathDropDown, iTimeOut)
			//Select item in dropdown
			clickToButton(sObjPathItemDropDown, iTimeOut)
		}catch (Exception ex) {
			KeywordUtil.markFailed(GlobalVariable.GMsgCKW55 + objPathDropDown.objectId.split('/').last() + GlobalVariable.GMsgCKW56)
		}
	}


	/**
	 * Custom keyword name: selectDropdownItemByListObject(List<TestObject> lObjectList, int iTimeOut)</br></br>
	 *
	 * General description: Custom keyword is used to select item in dropdown on mobile apllication</br></br>
	 *
	 * @param lObjectList   : The list of mobile object in the Object Repository
	 * @param iTimeOut  	: The time for waiting object is displayed on mobile application
	 *
	 * @return
	 *          none
	 *
	 * @since 05/02/2023
	 *
	 * @author ABA Automation team
	 */
	@Keyword
	def static void selectDropdownItemByListObject(List<TestObject> lObjectList, int iTimeOut) {
		try {
			//Click dropdown object
			clickToButton(lObjectList.get(0), iTimeOut)
			//Select item in dropdown
			clickToButton(lObjectList.get(1), iTimeOut)
		}catch (Exception ex) {
			KeywordUtil.markFailed(GlobalVariable.GMsgCKW95)
		}
	}

	/**
	 * Custom keyword name: getAllDropdownItemName(TestObject objPathDropDown, String sXpathItemDropDown, int iTimeOut)</br></br>
	 *
	 * General description: Custom keyword is used to select item in dropdown on mobile apllication</br></br>
	 *
	 * @param objPathDropDown   	: The object drop down in the Object Repository
	 * @param sXpathItemDropDown	: The xpath of the item in drop down
	 * @param iTimeOut  			: The time for waiting object is displayed on mobile application
	 *
	 * @return
	 *          List of item name in drop down
	 *
	 * @since 05/02/2023
	 *
	 * @author ABA Automation team
	 */
	@Keyword
	def static List<String> getAllDropdownItemName(TestObject objPathDropDown, String sXpathItemDropDown, int iTimeOut) {
		List<String> listItemName = new ArrayList<String>()
		try {
			//Click dropdown object
			clickToButton(objPathDropDown, iTimeOut)
			//Get list element by appium
			AppiumDriver driver = MobileDriverFactory.getDriver()
			List<MobileElement> listItem = (List<MobileElement>) driver.findElementsByXPath(sXpathItemDropDown);
			for (MobileElement item : listItem) {
				listItemName.add(item.getText())
			}
			return listItemName
		}catch (Exception ex) {
			KeywordUtil.markFailed(GlobalVariable.GMsgCKW55 + objPathDropDown.objectId.split('/').last() + GlobalVariable.GMsgCKW56)
		}
	}

	/**
	 * Custom keyword name: loginScreenByPasswordFailMoreFiveTimes(List<TestObject> lObjectList, List<String> lExpectedText, List<String> lErrorMessage, int iTimeOut)</br></br>
	 *
	 * General description: Custom keyword is used to loop input password and verify dialog message block account on mobile apllication</br></br>
	 *
	 * @param lObjectList   	: The list of mobile object in the Object Repository
	 * @param lInvalidPassword	: The list contains invalid passwords for inputting
	 * @param lErrorMessage		: The list contains failed relevant messages for verifying
	 * @param iTimeOut  		: The time for waiting object is displayed on mobile application
	 *
	 * @return
	 *          none
	 *
	 * @since 10/03/2023
	 *
	 * @author ABA Automation team
	 */
	@Keyword
	def static Boolean loginScreenByPasswordFailMoreFiveTimes(List<TestObject> lObjectList, List<String> lInvalidPassword, List<String> lErrorMessage, int iTimeOut) {
		try {
			for (int i = 0; i <= lInvalidPassword.size(); i++) {
				//Input invalid password to password text box
				Mobile.clearText(lObjectList.get(0), iTimeOut)
				inputDataToTestObject(lObjectList.get(0), lInvalidPassword.get(i), iTimeOut)
				//Click login button
				clickToButton(lObjectList.get(1), iTimeOut)
				//Verify dialog message wrong password then close dialog
				if (getTextFromObject(lObjectList.get(2), iTimeOut).equals(lErrorMessage.get(1))) {
					clickToButton(lObjectList.get(3), iTimeOut)
				}
				//Verify dialog message block account
				if (lInvalidPassword.size() > 5) {
					if (getTextFromObject(lObjectList.get(4), iTimeOut).equals(lErrorMessage.get(2))) {
						//KeywordUtil.markPassed("Message block account showed.")
						return true
					} else {
						//KeywordUtil.markFailed("No message block account found.")
						return false
					}
				}
				return true
			}
		}catch (Exception ex) {
			KeywordUtil.markFailed(GlobalVariable.GMsgCKW95)
			return false
		}
	}

	/**
	 * Custom keyword name: loginScreenByPasswordFailLessFiveTimes(List<TestObject> lObjectList,List<String> sExpectedText, int iTimeOut)</br></br>     *
	 * General description: Custom keyword is used to input password fail below 5 times
	 *
	 * @param lObjectList       : The list of object names in repository
	 * @param lExpectedText     : The list contains invalid passwords and failed relevant messages for inputting and verifying
	 * @param sErrorMessage		: The text contains failed relevant messages for verifying
	 * @param iTimeOut          : The maximum time for waiting object is displayed on mobile application
	 *
	 * @return
	 *          none
	 *
	 * @since 28/02/2023
	 *
	 * @author ABA Automation team
	 */
	@Keyword
	def static void inputPasswordFailLessFiveTimes(List<TestObject> lObjectList,List<String> lExpectedText, String sErrorMessage, int iTimeOut) {
		try {
			for(int i = 0; i <= lExpectedText.size(); i++) {
				//Input password
				Mobile.clearText(lObjectList.get(0), iTimeOut)
				inputDataToTestObject(lObjectList.get(0), lExpectedText.get(i), iTimeOut)
				//Click Login button
				clickToButton(lObjectList.get(1), iTimeOut)
				//Verify message dialog is show after input password failed
				if(getTextFromObject(lObjectList.get(2), iTimeOut).equals(sErrorMessage)) {
					//click Close button
					clickToButton(lObjectList.get(3), iTimeOut)
				}
			}
		}catch (Exception ex) {
			KeywordUtil.markFailed(GlobalVariable.GMsgCKW95)
		}
	}

	/**
	 * Custom keyword name: switchLanguage(List<TestObject> lObjectList,String sExpectedText, String sLanguage, int iTimeOut)</br></br>     *
	 * General description: Custom keyword is used to change language on mobile application
	 *
	 * @param lObjectList       : The list of object names in repository
	 * @param sExpectedText     : The expected text used for verify language changed
	 * @param sLanguage			: The language want to change to
	 * @param iTimeOut          : The maximum time for waiting object is displayed on mobile application
	 *
	 * @return
	 *          none
	 *
	 * @since 28/02/2023
	 *
	 * @author ABA Automation team
	 */
	@Keyword
	def static void switchLanguage(List<TestObject> lObjectList,String sExpectedText, String sLanguage, int iTimeOut) {
		try {
			switch(sLanguage) {
				case "VN":
					clickToButton(lObjectList.get(0), iTimeOut)
					if (getTextFromObject(lObjectList.get(1), iTimeOut).equals(sExpectedText)) {
						KeywordUtil.markPassed("Language have change to vietnamese.")
					} else {
						KeywordUtil.markFailed("Language not have change to vietnamese.")
					}
				case "EN":
					clickToButton(lObjectList.get(0), iTimeOut)
					if (getTextFromObject(lObjectList.get(1), iTimeOut).equals(sExpectedText)) {
						KeywordUtil.markPassed("Language have change to english.")
					} else {
						KeywordUtil.markFailed("Language not have change to english.")
					}
			}
		}catch (Exception ex) {
			KeywordUtil.markFailed("Get error when change language.")
		}
	}



}