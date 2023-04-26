package en

import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import static com.kms.katalon.core.testobject.ObjectRepository.findWindowsObject

import com.kms.katalon.core.annotation.Keyword
import com.kms.katalon.core.checkpoint.Checkpoint
import com.kms.katalon.core.cucumber.keyword.CucumberBuiltinKeywords as CucumberKW
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile
import com.kms.katalon.core.model.FailureHandling
import com.kms.katalon.core.testcase.TestCase
import com.kms.katalon.core.testdata.TestData
import com.kms.katalon.core.testobject.TestObject
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.webui.common.WebUiCommonHelper
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import com.kms.katalon.core.windows.keyword.WindowsBuiltinKeywords as Windows

import internal.GlobalVariable
import common.WebUICommon


public class CustomKeys {

	/**
	 * Custom keyword name: openBrowserAndNavigateToUrl(String sUrl, int iTimeOut)</br></br>
	 *
	 * General description: Custom keyword is used for open browser and navigate to web page</br></br>
	 *
	 * @param sUrl	: The Url of web Page
	 * @param iTimeOut	: The maximum time for waiting object is displayed on web page
	 *
	 * @since 20/04/2023
	 *
	 * @author ABA Automation team
	 */
	@Keyword
	def static openBrowserAndNavigateToUrl(String sUrl, int iTimeOut){
		WebUI.openBrowser('')
		WebUI.navigateToUrl(sUrl)
		WebUI.maximizeWindow()
		WebUICommon.verifyObjectPresent(findTestObject('Object Repository/EN/bookAppointment/Page_CURA Healthcare Service/btnMakeAppointment'), iTimeOut)
	}


	@Keyword
	def static loginWithUserAccount(String sUserName, String sPassWord, int iTimeOut){
		// Click to button: Make Appointment
		WebUICommon.clickToButton(findTestObject('Object Repository/EN/bookAppointment/Page_CURA Healthcare Service/btnMakeAppointment'), iTimeOut)
		// Input data to text box: UserName
		WebUICommon.inputDataToTestObject(findTestObject('Object Repository/EN/bookAppointment/Page_Login/txfUsername'), sUserName, iTimeOut)
		// Get Text from text box: txtUserName
		println(WebUICommon.getTextFromObjectByInput(findTestObject('Object Repository/EN/bookAppointment/Page_Login/txfUsername'), iTimeOut))
		// Input data to text box: txtPassword
		WebUICommon.inputDataToTestObject(findTestObject('Object Repository/EN/bookAppointment/Page_Login/txfPassword'), sPassWord, iTimeOut)
		// Get Text from text box: txtPassword
		println(WebUICommon.getTextFromObjectByInput(findTestObject('Object Repository/EN/bookAppointment/Page_Login/txfPassword'), iTimeOut))
		// Click to button: Login
		WebUICommon.clickToButton(findTestObject('Object Repository/EN/bookAppointment/Page_Login/btnLogin'), iTimeOut)
		// Verify login success, web Navigate to Make Appointment page
		WebUICommon.verifyObjectPresent(findTestObject('Object Repository/EN/bookAppointment/Page_MakeAppointment/txvListFacilities'), iTimeOut)
	}

	@Keyword
	def static logoutAndCloseBrowser(){
		WebUI.closeBrowser()
	}

	@Keyword
	def static createNewAppointmentWithDataTest(String sVisitDay, String sTestComment, int iTimeOut) {
		// Click comboBox
		WebUICommon.clickToCheckBox(findTestObject('Object Repository/EN/bookAppointment/Page_MakeAppointment/txvListFacilities'), iTimeOut)
		//		// Click choose Facility
		//		WebUI.click(findTestObject('Object Repository/EN/bookAppointment/Page_MakeAppointment/txvFacility3')
		// Click to check box: Apply for hospital read mission
		WebUICommon.clickToCheckBox(findTestObject('Object Repository/bookAppointment/Page_CURA Healthcare Service/ckApply'), iTimeOut)
		// Click to radio button: None programs
		WebUICommon.clickToRadioButton(findTestObject('Object Repository/bookAppointment/Page_CURA Healthcare Service/rdNonePrograms'), iTimeOut)
		// Input data to text box: Date
		WebUICommon.inputDataToTestObject(findTestObject('Object Repository/bookAppointment/Page_CURA Healthcare Service/txtDate'), sVisitDay, iTimeOut)
		// Input data to text box: Comment
		WebUICommon.inputDataToTestObject(findTestObject('Object Repository/EN/bookAppointment/Page_MakeAppointment/txfComment'), sTestComment, iTimeOut)
		// Click to button: Book Appointment
		WebUICommon.clickToButton(findTestObject('Object Repository/bookAppointment/Page_CURA Healthcare Service/btnBookAppointment'), iTimeOut)
		// verify Make Appointment success, web navigate to Appointment Confirm
		WebUICommon.verifyObjectPresent(findTestObject('Object Repository/EN/bookAppointment/Page_MakeAppointment/lblAppointmentConfirmation'), iTimeOut)
		// Verify data Book
		WebUICommon.verifyObjectText(findTestObject('Object Repository/EN/bookAppointment/Page_MakeAppointment/txvVisitDayBook'), sVisitDay)
		WebUICommon.verifyObjectText(findTestObject('Object Repository/EN/bookAppointment/Page_MakeAppointment/txvCommentBook'), sTestComment)
	}
}
