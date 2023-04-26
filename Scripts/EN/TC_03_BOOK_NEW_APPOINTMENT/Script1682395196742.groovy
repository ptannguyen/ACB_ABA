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
import en.CustomKeys as CustomKeys

WebUI.comment("TC_03_BOOK_NEW_APPOINTMENT")

WebUI.comment("Step 1: Navigate to login page")
WebUI.openBrowser('')
WebUI.maximizeWindow()
WebUI.navigateToUrl(GlobalVariable.GUrl)
// Verify Navigate to URL Success
WebUICommon.verifyObjectPresent(findTestObject('Object Repository/EN/bookAppointment/Page_CURA Healthcare Service/btnMakeAppointment'), 20)

WebUI.comment('Step 2: Login with User Account')
// Click to button: Make Appointment
WebUICommon.clickToButton(findTestObject('Object Repository/EN/bookAppointment/Page_CURA Healthcare Service/btnMakeAppointment'), 20)
// Input data to text box: UserName
WebUICommon.inputDataToTestObject(findTestObject('Object Repository/bookAppointment/Page_CURA Healthcare Service/txtUsername'), sUserName, 20)
// Get Text from text box: txtUserName
println(WebUICommon.getTextFromObjectByInput(findTestObject('Object Repository/bookAppointment/Page_CURA Healthcare Service/txtUsername'), 20))
// Input data to text box: txtPassword
WebUICommon.inputDataToTestObject(findTestObject('Object Repository/bookAppointment/Page_CURA Healthcare Service/txtPassword'), sPassWord, 20)
// Get Text from text box: txtPassword
println(WebUICommon.getTextFromObjectByInput(findTestObject('Object Repository/bookAppointment/Page_CURA Healthcare Service/txtPassword'), 20))
// Click to button: Login
WebUICommon.clickToButton(findTestObject('Object Repository/EN/bookAppointment/Page_Login/btnLogin'), 20)
// Verify login success, web Navigate to Make Appointment page
WebUICommon.verifyObjectPresent(findTestObject('Object Repository/EN/bookAppointment/Page_MakeAppointment/txvListFacilities'), 20)

WebUI.comment('Step 3: Make Appointment')
// Click comboBox
WebUICommon.clickToCheckBox(findTestObject('Object Repository/EN/bookAppointment/Page_MakeAppointment/txvListFacilities'), 20)
// Click choose
WebUICommon.clickToCheckBox(findTestObject('Object Repository/bookAppointment/Page_CURA Healthcare Service/txvFacitity3'), 20)
// Click to check box: Apply for hospital read mission
WebUICommon.clickToCheckBox(findTestObject('Object Repository/bookAppointment/Page_CURA Healthcare Service/ckApply'), 20)
// Click to radio button: None programs
WebUICommon.clickToRadioButton(findTestObject('Object Repository/bookAppointment/Page_CURA Healthcare Service/rdNonePrograms'), 20)
// Input data to text box: Date
WebUICommon.inputDataToTestObject(findTestObject('Object Repository/bookAppointment/Page_CURA Healthcare Service/txtDate'), sVisitDay, 20)
// Input data to text box: Comment
WebUICommon.inputDataToTestObject(findTestObject('Object Repository/EN/bookAppointment/Page_MakeAppointment/txfComment'), sTestComment, 20)
// Click to button: Book Appointment
WebUICommon.clickToButton(findTestObject('Object Repository/bookAppointment/Page_CURA Healthcare Service/btnBookAppointment'), 20)
// verify Make Appointment success, web navigate to Appointment Confirm
WebUICommon.verifyObjectPresent(findTestObject('Object Repository/EN/bookAppointment/Page_MakeAppointment/lblAppointmentConfirmation'), 20)
// Verify data Book
WebUICommon.verifyObjectText(findTestObject('Object Repository/EN/bookAppointment/Page_MakeAppointment/txvVisitDayBook'), sVisitDay)
WebUICommon.verifyObjectText(findTestObject('Object Repository/EN/bookAppointment/Page_MakeAppointment/txvCommentBook'), sTestComment)

WebUI.comment('Step 4: Close Browser')
CustomKeys.logoutAndCloseBrowser()
