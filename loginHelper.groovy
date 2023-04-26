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
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import com.kms.katalon.core.windows.keyword.WindowsBuiltinKeywords as Windows

import internal.GlobalVariable
import common.WebUICommon
import com.kms.katalon.core.util.KeywordUtil

public class loginHelper {
	@Keyword
	def openBrowserAndNavigateToUrl(String sUrl, Integer iTimeOut){
		WebUI.openBrowser('')
		WebUI.maximizeWindow()
		WebUI.navigateToUrl(sUrl)
		WebUI.delay(2)
		WebUICommon.verifyObjectPresent(findTestObject('Object Repository/bookAppointment/Page_CURA Healthcare Service/btnMakeAppointment'), iTimeOut)
	}

	@Keyword
	def loginWithUserAccount(String sUserName, String sPassWord, Integer iTimeOut ){
		// Click to button: Make Appointment
		WebUICommon.clickToButton(findTestObject('Object Repository/bookAppointment/Page_CURA Healthcare Service/btnMakeAppointment'), iTimeOut)
		// Input userName
		WebUICommon.inputDataToTestObject(findTestObject('Object Repository/bookAppointment/Page_CURA Healthcare Service/txtUsername'), sUserName, iTimeOut)
		// Input passWord
		WebUICommon.inputDataToTestObject(findTestObject('Object Repository/bookAppointment/Page_CURA Healthcare Service/txtPassword'), sPassWord, iTimeOut)
		// Click to button: Login
		WebUICommon.clickToButton(findTestObject('Object Repository/bookAppointment/Page_CURA Healthcare Service/btnLogin'), iTimeOut)
		// Verify login success,Web navigate to Book a appointment page
		WebUI.delay(2)
		WebUICommon.verifyObjectVisible(findTestObject('Object Repository/bookAppointment/Page_CURA Healthcare Service/txfMakeAppointmentTitle'), iTimeOut)
	}

	@Keyword
	def logoutAndCloseBrowser(){
		WebUI.closeBrowser()
	}
}
