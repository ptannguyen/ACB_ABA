package common

import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject

import org.openqa.selenium.WebElement
import org.openqa.selenium.support.ui.Select

import com.kms.katalon.core.annotation.Keyword
import com.kms.katalon.core.model.FailureHandling
import com.kms.katalon.core.testobject.TestObject
import com.kms.katalon.core.util.KeywordUtil
import com.kms.katalon.core.webui.common.WebUiCommonHelper
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import internal.GlobalVariable

/**
 * <b>General description:</b> List out some common keywords used for web application<p></p>
 * 
 * <b>Keyword list:</b>
 * 
 * <pre>
 *   <b>{@link #verifyObjectPresent verifyObjectPresent}</b>
 *   <b>{@link #verifyObjectVisible verifyObjectVisible}</b>
 *   <b>{@link #verifyObjectClickable verifyObjectClickable}</b>
 *   <b>{@link #verifyObjectNotChecked verifyObjectNotChecked}</b>
 *   <b>{@link #verifyObjectAttributeValue verifyObjectAttributeValue}</b>
 *   <b>{@link #verifyObjectText verifyObjectText}</b>
 *   <b>{@link #inputDataToTestObject inputDataToTestObject}</b>
 *   <b>{@link #inputEncryptedDataToTestObject inputEncryptedDataToTestObject}</b>
 *   <b>{@link #printStepMessage printStepMessage}</b>
 *   <b>{@link #clickToRadioButton clickToRadioButton}</b>
 *   <b>{@link #clickToCheckBox clickToCheckBox}</b>
 *   <b>{@link #clickToButton clickToButton}</b>
 *   <b>{@link #clickToButtonWithOffSet clickToButtonWithOffSet}</b>
 *   <b>{@link #hoverMouseOverElement hoverMouseOverElement}</b>
 *   <b>{@link #hoverMouseOverElementWithOffSet hoverMouseOverElementWithOffSet}</b>
 *   <b>{@link #dragAndDropByOffset dragAndDropByOffset}</b>
 *   <b>{@link #dragAndDropThroughObject dragAndDropThroughObject}</b>
 *   <b>{@link #getTextFromObject getTextFromObject}</b>
 *   <b>{@link #getTextFromObjectByInput getTextFromObjectByInput}</b>
 *   <b>{@link #getAllOptionsTextFromDropDown getAllOptionsTextFromDropDown}</b>
 *   <b>{@link #selectComboBoxItemByIndex selectComboBoxItemByIndex}</b>
 *   <b>{@link #deSelectComboBoxOptionsByIndex deSelectComboBoxOptionsByIndex}</b>
 *   <b>{@link #selectComboBoxItemByValue selectComboBoxItemByValue}</b>
 *   <b>{@link #deSelectComboBoxOptionsByValue deSelectComboBoxOptionsByValue}</b>
 *   <b>{@link #selectListViewItem selectListViewItem}</b>
 *   <b>{@link #selectMenuItem selectMenuItem}</b>
 * </pre>
 * 
 * @since 08/02/2023  
 *
 * @author <b>ABA Automation team</b>
 */
public class WebUICommon {
	/**
	 * Custom keyword name: verifyObjectPresent(TestObject objPath, int iTimeOut)</br></br>
	 *
	 * General description: Custom keyword is used for verify object existence on a web page</br></br>
	 *
	 * @param objPath	: The object name in the Object Repository
	 * @param iTimeOut	: The maximum time for waiting object is displayed on web page
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
			if(WebUI.verifyElementPresent(objPath, iTimeOut, FailureHandling.CONTINUE_ON_FAILURE)) {
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
			//Wait for object visible
			WebUI.waitForElementVisible(objPath, iTimeOut, FailureHandling.CONTINUE_ON_FAILURE)
			//Verify that the object exists or not
			if(WebUI.verifyElementVisible(objPath, FailureHandling.CONTINUE_ON_FAILURE)) {
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
	 * Custom keyword name: verifyObjectClickable(TestObject objPath)</br></br>
	 *
	 * General description: Custom keyword is used for verify object enabled on a web page</br></br>
	 *
	 * @param objPath	: The object name in the Object Repository
	 * @param iTimeOut	: The maximum time for waiting object is displayed on web page
	 *
	 * @return
	 *			true if the element is present and clickable; otherwise, false
	 *
	 * @since 05/02/2023
	 *
	 * @author ABA Automation team
	 */
	@Keyword
	def static Boolean verifyObjectClickable(TestObject objPath) {
		try{
			//Verify that the object is enabled or not
			if(WebUI.verifyElementClickable(objPath, FailureHandling.CONTINUE_ON_FAILURE)) {
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
	 * General description: Custom keyword is used for verify if the given object is checked on a web page</br></br>
	 *
	 * @param objPath	: The object name in the Object Repository
	 * @param iTimeOut	: The maximum time for waiting object is displayed on web page
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
			if(WebUI.verifyElementNotChecked(objPath, iTimeOut, FailureHandling.CONTINUE_ON_FAILURE)) {
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
	 * <b>Custom keyword name:</b> verifyObjectAttributeValue(TestObject objPath, int iTimeOut)</br></br>
	 *
	 * <b>General description:</b> Custom keyword is used for verify if the given object has the attribute with the specified name and value on web page</br></br>
	 *
	 * @param objPath	  : The object in the Object Repository
	 * @param sAttribute : The name of the attribute to verify
	 * @param sValue	  : The value of the attribute to verify
	 * @param iTimeOut	  : The time waiting for the object to display on the web page
	 *
	 * @return
	 *			true if the specified attribute has the matching value; otherwise, false
	 *
	 * @since 05/02/2023
	 *
	 * @author ABA Automation team
	 */
	@Keyword
	def static Boolean verifyObjectAttributeValue(TestObject objPath, String sAttribute, String sValue, int iTimeOut) {
		try {
			if(WebUI.verifyElementAttributeValue(objPath, sAttribute, sValue, iTimeOut)) {
				return true
			} else {
				KeywordUtil.markFailed(GlobalVariable.GMsgCKW80 + objPath.objectId.split('/').last() + GlobalVariable.GMsgCKW85)
				return false
			}
		} catch (Exception ex) {
			KeywordUtil.markFailed(GlobalVariable.GMsgCKW25)
			return false
		}
	}

	/**
	 * <b>Custom keyword name:</b> verifyObjectText(TestObject objPath, String sText)</br></br>
	 *
	 * <b>General description:</b> Custom keyword is used for verify if the given object has expected text on web page</br></br>
	 *
	 * @param objPath : The object in the Object Repository
	 * @param sText   : The expected text of the element to verify.
	 *
	 * @return
	 *			true if the specified attribute has the matching value; otherwise, false
	 *
	 * @since 05/02/2023
	 *
	 * @author ABA Automation team
	 */
	@Keyword
	def static Boolean verifyObjectText(TestObject objPath, String sText) {
		try {
			if(WebUI.verifyElementText(objPath, sText, FailureHandling.CONTINUE_ON_FAILURE)) {
				return true
			} else {
				String sActualText = WebUI.getText(objPath)
				KeywordUtil.markFailed(GlobalVariable.GMsgCKW70 + sActualText + GlobalVariable.GMsgCKW75 + sText)
				return false
			}
		} catch (Exception ex) {
			KeywordUtil.markFailed(GlobalVariable.GMsgCKW25)
			return false
		}
	}


	/**
	 * Custom keyword name: inputDataToTestObject(String sObjPath, String sText, int iTimeOut)</br></br>
	 *
	 * General description: Custom keyword is used for inputting a text string to object on a web page</br></br>
	 *
	 * @param objPath	: The object name in the Object Repository
	 * @param sText		: The text string is input in object
	 * @param iTimeOut	: The maximum time for waiting object is displayed on web page
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
			if(verifyObjectPresent(objPath, iTimeOut)) {
				if(verifyObjectClickable(objPath)) {
					WebUI.setText(objPath, sText)
					if(!getTextFromObjectByInput(objPath, iTimeOut).equals(sText)) {
						KeywordUtil.markFailed(GlobalVariable.GMsgCKW30 + objPath.objectId.split('/').last() + GlobalVariable.GMsgCKW31)
					}
				}
			}
		} catch(Exception ex) {
			KeywordUtil.markFailed(GlobalVariable.GMsgCKW55 + objPath.objectId.split('/').last() + GlobalVariable.GMsgCKW56)
		}
	}

	/**
	 * <b>Custom keyword name:</b> inputEncryptedDataToTestObject(String sObjPath, String sText, int iTimeOut)</br></br>
	 *
	 * <b>General description:</b> Custom keyword is used to inputting the ENCRYPTED text string to object on web page</br></br>
	 *
	 * @param objPath				: The object in the Object Repository
	 * @param sEncryptedText		: The ENCRYPTED text string has input to the given object
	 * @param iTimeOut				: The time waiting for object to displayed on the web page
	 *
	 * @return
	 * 			none
	 *
	 * @since 16/03/2023
	 *
	 * @author GreenCSR Automation team
	 */
	@Keyword
	def static void inputEncryptedDataToTestObject(TestObject objPath, String sEncryptedText, int iTimeOut) {
		try{
			if(verifyObjectPresent(objPath, iTimeOut)) {
				if(verifyObjectClickable(objPath)) {
					WebUI.setEncryptedText(objPath, sEncryptedText)
				}
			}
		} catch(Exception ex) {
			KeywordUtil.markFailed(GlobalVariable.GMsgCKW55 + objPath.objectId.split('/').last() + GlobalVariable.GMsgCKW56)
		}
	}

	/**
	 * Custom keyword name: printStepMessage(String sPageNameOrScreen, String sAction, String sObjName)</br></br>
	 *
	 * General description: Custom keyword is used for print step message to console</br></br>
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
	 * General description: Custom keyword is used for clicked a radio button on a web page</br></br>
	 *
	 * @param objPath	: The object name in the Object Repository
	 * @param iTimeOut	: The maximum time for waiting object is displayed on web page
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
				if(verifyObjectClickable(objPath) == true) {
					//Verify that the object is checked or not
					if(verifyObjectNotChecked(objPath, iTimeOut) == true) {
						WebUI.click(objPath)
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
	 * General description: Custom keyword is used for clicked a check box on a web page</br></br>
	 *
	 * @param objPath	: The object name in the Object Repository
	 * @param iTimeOut	: The maximum time for waiting object is displayed on web page
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
				if(verifyObjectClickable(objPath) == true) {
					//Verify that the object is checked or not
					if(verifyObjectNotChecked(objPath, iTimeOut) == true) {
						WebUI.click(objPath)
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
	 * General description: Custom keyword is used for clicked a button on a web page</br></br>
	 *
	 * @param objPath	: The represent a web element in the Object Repository
	 * @param iTimeOut	: The maximum time for waiting object is displayed on web page
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
				if(verifyObjectClickable(objPath) == true) {
					WebUI.click(objPath)
				}
			}
		} catch(Exception ex) {
			KeywordUtil.markFailed(GlobalVariable.GMsgCKW55 + objPath.objectId.split('/').last() + GlobalVariable.GMsgCKW56)
		}
	}


	/**
	 * <b>Custom keyword name</b> : clickToButtonWithOffSet(TestObject objPath, int iOffSetX, int iOffSetY, int iTimeOut)<br></br>
	 *
	 * <b>General description</b> : Custom keyword is used to clicking on element depends on relative position between X-offset and Y-offset and start from top-left corner of that element<br></br>
	 *
	 * @param objPath		: The object in Object Repository
	 * @param iOffSetX		: The horizontal position of that object
	 * @param iOffSetY		: The vertical position of that object
	 * @param iTimeOut		: The time waiting for the object to display on the web page
	 *
	 * @return
	 * 			none
	 * @author GreenCSR Automation Team
	 */
	@Keyword
	def static void clickToButtonWithOffSet(TestObject objPath, int iOffSetX, int iOffSetY, int iTimeOut) {
		try {
			if(verifyObjectPresent(objPath,iTimeOut)) {
				if(verifyObjectClickable(objPath)) {
					WebUI.clickOffset(objPath, iOffSetX, iOffSetY)
				}
			}
		} catch(Exception ex) {
			KeywordUtil.markFailed(GlobalVariable.GMsgCKW55 + objPath.objectId.split('/').last() + GlobalVariable.GMsgCKW56)
		}
	}

	/**
	 * <b>Custom keyword name</b> : hoverMouseOverElement(TestObject objPath, int iTimeOut)<br></br>
	 *
	 * <b>General description</b> : Custom keyword is used to hovering mouse over element<br></br>
	 *
	 * @param objPath	: The object in the Object Repository
	 * @param iTimeOut	: The time waiting for the object to display on the web page
	 * @return
	 * 			none
	 * @author GreenCSR Automation Team
	 */
	@Keyword
	def static void hoverMouseOverElement(TestObject objPath, int iTimeOut) {
		try {
			if(verifyObjectPresent(objPath, iTimeOut)) {
				WebUI.mouseOver(objPath)
			}
		} catch(Exception ex) {
			KeywordUtil.markFailed(GlobalVariable.GMsgCKW55 + objPath.objectId.split('/').last() + GlobalVariable.GMsgCKW56)
		}
	}

	/**
	 * <b>Custom keyword name</b> : hoverMouseOverElementWithOffSet(TestObject objPath, int iOffSetX, int iOffSetY, int iTimeOut)<br></br>
	 *
	 * <b>General description</b> : Custom keyword is used to hovering mouse over element depends on relative position between X-offset and Y-offset and start from top-left corner of that element<br></br>
	 *
	 * @param objPath		: The object in the Object Repository
	 * @param iOffSetX		: The horizontal position of that object
	 * @param iOffSetY		: The vertical position of that object
	 * @param iTimeOut		: The time waiting for the object to display on the web page
	 *
	 * @return
	 * 			none
	 * @author GreenCSR Automation Team
	 */
	@Keyword
	def static void hoverMouseOverElementWithOffSet(TestObject objPath, int iOffSetX, int iOffSetY, int iTimeOut) {
		try {
			if(verifyObjectPresent(objPath, iTimeOut)) {
				WebUI.mouseOverOffset(objPath, iOffSetX, iOffSetY)
			}
		} catch(Exception ex) {
			KeywordUtil.markFailed(GlobalVariable.GMsgCKW55 + objPath.objectId.split('/').last() + GlobalVariable.GMsgCKW56)
		}
	}

	/**
	 * <b>Custom keyword name:</b> dragAndDropByOffset(TestObject objPath, int iOffSetX, int iOffSetY, int iTimeOut)</br><br>
	 *
	 * <b>General description:</b> Custom keyword is used for dragging the object to dropping it to the offset (X,Y) location</br><br>
	 *
	 * @param objPath		: The object in Object Repository
	 * @param iOffSetX		: The horizontal position of that object
	 * @param iOffSetY		: The vertical position of that object
	 * @param iTimeOut		: The time waiting for the object to display on the web page
	 *
	 * @return
	 * 			none
	 * @since 10/03/2023
	 *
	 * @author GreenCSR Automation team
	 */
	@Keyword
	def static void dragAndDropByOffset(TestObject objPath, int iOffSetX, int iOffSetY, int iTimeOut) {
		try {
			if (verifyObjectPresent(objPath, iTimeOut) && verifyObjectAttributeValue(objPath, "draggable", "true", iTimeOut)) {
				WebUI.dragAndDropByOffset(objPath, iOffSetX, iOffSetY)
			}
		} catch(Exception ex) {
			KeywordUtil.markFailed(GlobalVariable.GMsgCKW55 + objPath.objectId.split('/').last() + GlobalVariable.GMsgCKW56)
		}
	}

	/**
	 * <b>Custom keyword name:</b> dragAndDropThroughObject(TestObject objPathSrc, TestObject objPathDst, int iTimeOut)</br><br>
	 *
	 * <b>General description:</b> Custom keyword is used for dragging the source object and dropping it to the destination object</br><br>
	 *
	 * @param objPathSrc	: The source object in Object Repository
	 * @param objPathDst	: The destination object in Object Repository
	 * @param iTimeOut		: The time waiting for the object to display on the web page
	 *
	 * @return
	 * 			none
	 * @since 10/03/2023
	 *
	 * @author GreenCSR Automation team
	 */
	@Keyword
	def static void dragAndDropThroughObject(TestObject objPathSrc, TestObject objPathDst, int iTimeOut) {
		try {
			if (verifyObjectPresent(objPathSrc, iTimeOut) && verifyObjectAttributeValue(objPathSrc, "draggable", "true", iTimeOut)) {
				if (verifyObjectPresent(objPathDst, iTimeOut) && verifyObjectAttributeValue(objPathDst, "draggable", "true", iTimeOut)) {
					WebUI.dragAndDropToObject(objPathSrc, objPathDst)
				}
			}
		} catch(Exception ex) {
			KeywordUtil.markFailed(GlobalVariable.GMsgCKW55 + objPathSrc.objectId.split('/').last() + " and " + objPathDst.objectId.split('/').last() + GlobalVariable.GMsgCKW56)
		}
	}


	/**
	 * Custom keyword name: getTextFromObject(TestObject objPath, int iTimeOut)</br></br>
	 *
	 * General description: Custom keyword is used for getting a text string from object(button, radio button, label,...) on a web page</br></br>
	 *
	 * @param objPath	: The object name in the Object Repository
	 * @param iTimeOut	: The maximum time for waiting object is displayed on web page
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
			if(verifyObjectPresent(objPath, iTimeOut)) {
				if(verifyObjectClickable(objPath)) {
					return WebUI.getText(objPath)
				}
			}
		} catch(Exception ex) {
			KeywordUtil.markFailed("Verify object by hand.")
		}
	}

	/**
	 * Custom keyword name: getTextFromObjectByInput(TestObject objPath, int iTimeOut)</br></br>
	 *
	 * General description: Custom keyword is used for getting a text string from object(with html tag name input) on a web page</br></br>
	 *
	 * @param objPath		: The object name in the Object Repository
	 * @param iTimeOut		: The maximum time for waiting object is displayed on web page
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
			if(verifyObjectPresent(objPath, iTimeOut)) {
				if(verifyObjectClickable(objPath)) {
					return WebUI.getAttribute(objPath, "value")
				}
			}
		} catch(Exception ex) {
			KeywordUtil.markFailed(GlobalVariable.GMsgCKW55 + objPath.objectId.split('/').last() + GlobalVariable.GMsgCKW56)
		}
	}

	/**
	 * <b>Custom keyword name:</b> getAllOptionsTextFromDropDown(TestObject objPath, int iTimeOut)</br><br>
	 *
	 * <b>General description:</b> Custom keyword is used for getting a list of all options's text from a drop-down list</br><br>
	 *
	 * @param objPath		: The object in Object Repository
	 * @param iTimeOut		: The time waiting for the object to display on the web page
	 *
	 * @return
	 * 			a list of all options's text
	 * @since 24/02/2023
	 *
	 * @author GreenCSR Automation team
	 */
	@Keyword
	def static List<String> getAllOptionsTextFromDropDown(TestObject objPath, int iTimeOut) {
		try {
			if(verifyObjectPresent(objPath, iTimeOut)) {
				if(verifyObjectClickable(objPath)) {
					List<String> listOptionsText = new ArrayList<String>()
					WebElement selectElement = WebUiCommonHelper.findWebElement(objPath, iTimeOut)
					Select select = new Select(selectElement)
					List<WebElement> options = select.getOptions()
					for(int i = 0; i < options.size(); i++) {
						listOptionsText.add(options.get(i).getText())
					}
					return listOptionsText
				}
			}
		} catch(Exception ex) {
			KeywordUtil.markFailed(GlobalVariable.GMsgCKW55 + objPath.objectId.split('/').last() + GlobalVariable.GMsgCKW56)
		}
	}


	/**
	 * Custom keyword name: selectComboBoxItemByIndex(TestObject objPath, int itemIndex, int iTimeOut)</br></br>
	 *
	 * General description: Custom keyword is used for select all items that have a index matching the "index" argument on a web page</br></br>
	 *
	 * @param objPath		: The object name in the Object Repository
	 * @param itemIndex		: The index index range of the options to select from object. Index starts from 0.
	 * @param iTimeOut		: The maximum time for waiting object is displayed on web page
	 *
	 * @return
	 * 			none
	 *
	 * @since 05/02/2023
	 *
	 * @author ABA Automation team
	 */
	@Keyword
	def static void selectComboBoxItemByIndex(TestObject objPath, int sItemIndex, int iTimeOut) {
		try{
			//Verify that the object exists or not
			if(verifyObjectPresent(objPath, iTimeOut)) {
				if(verifyObjectClickable(objPath)) {
					if(sItemIndex >= 0) {
						WebUI.selectOptionByIndex(objPath, sItemIndex)
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
	 * <b>Custom keyword name:</b> deSelectComboBoxItemByIndex(TestObject objPath, int itemIndex, int iTimeOut)</br></br>
	 *
	 * <b>General description:</b> Custom keyword is used for specifying the index range of the options to be de-selected in the combo box</br></br>
	 *
	 * @param objPath		: The object in the Object Repository
	 * @param iItemIndex	: The index range to de-select the specified options of the given object. The index starts from 0.
	 * @param iTimeOut		: The time waiting for the object to display on the web page
	 *
	 * @return
	 * 			none
	 *
	 * @since 10/03/2023
	 *
	 * @author GreenCSR Automation team
	 */
	@Keyword
	def static void deSelectComboBoxOptionsByIndex(TestObject objPath, int iItemIndex, int iTimeOut) {
		try{
			if(verifyObjectPresent(objPath, iTimeOut) == true) {
				if (verifyObjectClickable(objPath) == true) {
					if(iItemIndex >= 0) {
						WebUI.deselectOptionByIndex(objPath, iItemIndex)
					} else {
						KeywordUtil.markFailed(GlobalVariable.GMsgCKW40)
					}
				}
			}
		} catch(Exception ex) {
			KeywordUtil.markFailed(GlobalVariable.GMsgCKW55 + objPath.objectId.split('/').last() + GlobalVariable.GMsgCKW56)
		}
	}

	/**
	 * Custom keyword name: selectComboBoxItemByValue(TestObject objPath, String itemValue, int iTimeOut)</br></br>
	 *
	 * General description: Custom keyword is used for select all items that have a value matching the "value" argument on a web page</br></br>
	 *
	 * @param objPath		: The object name in the Object Repository
	 * @param itemValue		: The value of the options to select from object
	 * @param iTimeOut		: The maximum time for waiting object is displayed on web page
	 *
	 * @return
	 * 			none
	 *
	 * @since 05/02/2023
	 *
	 * @author ABA Automation team
	 */
	@Keyword
	def static void selectComboBoxItemByValue(TestObject objPath, String sItemValue, int iTimeOut) {
		try{
			//Verify that the object exists or not
			if(verifyObjectPresent(objPath, iTimeOut) == true) {
				if(verifyObjectClickable(objPath) == true) {
					if(!sItemValue.equals("")) {
						WebUI.selectOptionByValue(objPath, sItemValue, false)
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
	 * <b>Custom keyword name:</b> deSelectComboBoxItemByValue(TestObject objPath, String itemValue, int iTimeOut)</br></br>
	 *
	 * <b>General description:</b> Custom keyword is used for specifying the value of the options to be de-selected through matching the "value" 
	 * arguments in the combo box</br></br>
	 *
	 * @param objPath		: The object in the Object Repository
	 * @param sItemValue	: The matching value to de-select the specified options of the given object.
	 * @param iTimeOut		: The time waiting for the object to display on the web page
	 *
	 * @return
	 * 			none
	 *
	 * @since 10/03/2023
	 *
	 * @author GreenCSR Automation team
	 */
	@Keyword
	def static void deSelectComboBoxOptionsByValue(TestObject objPath, String sItemValue, int iTimeOut) {
		try{
			if(verifyObjectPresent(objPath, iTimeOut) == true) {
				if (verifyObjectClickable(objPath) == true) {
					if(!sItemValue.equals("")) {
						WebUI.deselectOptionByValue(objPath, sItemValue, false)
					} else {
						KeywordUtil.markFailed(GlobalVariable.GMsgCKW50)
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
	 * General description: Custom keyword is used to click an item from listview on the website</br></br>
	 *
	 * @param objPath		: The object name in the Object Repository
	 * @param iTimeOut		: The maximum time for waiting object is displayed on web page
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
			if(verifyObjectPresent(objPath, iTimeout)) {
				if(verifyObjectClickable(objPath)) {
					WebUI.click(objPath)
				}
			}
		} catch(Exception ex) {
			KeywordUtil.markFailed(GlobalVariable.GMsgCKW55 + objPath.objectId.split('/').last() + GlobalVariable.GMsgCKW56)
		}
	}

	/**
	 * Custom keyword name: selectMenuItem(TestObject objPath, int iTimeout)</br></br>
	 *
	 * General description: Custom keyword is used to click an item from Menu on the website</br></br>
	 *
	 * @param objPath		: The object name in the Object Repository
	 * @param iTimeOut		: The maximum time for waiting object is displayed on web page
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
			if(verifyObjectPresent(objPath, iTimeout)) {
				if(verifyObjectClickable(objPath)) {
					WebUI.click(objPath)
				}
			}
		} catch(Exception ex) {
			KeywordUtil.markFailed(GlobalVariable.GMsgCKW55 + objPath.objectId.split('/').last() + GlobalVariable.GMsgCKW56)
		}
	}
}