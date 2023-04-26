import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import static com.kms.katalon.core.testobject.ObjectRepository.findWindowsObject
import com.kms.katalon.core.checkpoint.Checkpoint as Checkpoint
import com.kms.katalon.core.cucumber.keyword.CucumberBuiltinKeywords as CucumberKW
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile
import com.kms.katalon.core.model.FailureHandling as FailureHandling
import com.kms.katalon.core.testcase.TestCase as TestCase
import com.kms.katalon.core.testdata.TestData as TestData
import com.kms.katalon.core.testng.keyword.TestNGBuiltinKeywords as TestNGKW
import com.kms.katalon.core.testobject.TestObject as TestObject
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import com.kms.katalon.core.windows.keyword.WindowsBuiltinKeywords as Windows
import internal.GlobalVariable as GlobalVariable
import org.openqa.selenium.Keys as Keys
import com.kms.katalon.core.util.KeywordUtil as KeywordUtil
import common.WebUICommon as WebUICommon

WebUI.comment("TC_07_LOGIN_ORANGE_HRM_UNSUCCESSFULLY_WITH_INVALID_DATA")

String SInvalidUsername = "Admin123"

WebUI.comment("Step 1: Navigate to OrangeHRM login page")
WebUI.openBrowser('')
WebUI.maximizeWindow()
WebUI.navigateToUrl(GlobalVariable.GUrlOrangeHRM)

WebUI.comment("Step 2: Set username and password ")
//Input data into Username text box
WebUICommon.inputDataToTestObject(findTestObject('Object Repository/Page_OrangeHRM/Login/txtUsername'), SInvalidUsername, GlobalVariable.GTimeOut10)

//Input data into Password textbox
WebUICommon.inputDataToTestObject(findTestObject('Object Repository/Page_OrangeHRM/Login/txtPassword'), GlobalVariable.GPassWordOrangeHRM, GlobalVariable.GTimeOut10)

WebUI.comment("Step 3: Press Login button ")
WebUICommon.clickToButton(findTestObject('Object Repository/Page_OrangeHRM/Login/btnLogin'), GlobalVariable.GTimeOut10)

WebUI.comment("Step 4: Verify error message is visible ")
WebUICommon.verifyObjectVisible(findTestObject('Object Repository/Page_OrangeHRM/Login/pInvalidCredentials'), GlobalVariable.GTimeOut10)

WebUI.comment("Step 5: Close Browser ")
//Close browser
WebUI.closeBrowser()