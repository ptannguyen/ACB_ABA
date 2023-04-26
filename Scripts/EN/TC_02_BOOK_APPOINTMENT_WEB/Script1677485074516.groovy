import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import common.WebUICommon


WebUI.comment("TC_02_BOOK_A_APPOINTMENT")
WebUI.openBrowser('')
WebUI.navigateToUrl('https://katalon-demo-cura.herokuapp.com/')

WebUI.comment("Step 1: Navigate to login page")
// Click to button: Make Appointment
WebUICommon.clickToButton(findTestObject('Object Repository/EN/bookAppointment/Page_CURA Healthcare Service/btnMakeAppointment'), 10)

WebUI.comment("Step 2: Set login and password and press login button")
// Input data to text box: UserName
WebUICommon.inputDataToTestObject(findTestObject('Object Repository/EN/bookAppointment/Page_Login/txfUsername'), "John Doe", 10)

// Get Text from text box: txtUserName
println(WebUICommon.getTextFromObjectByInput(findTestObject('Object Repository/EN/bookAppointment/Page_Login/txfUsername'), 10))

// Input data to text box: txtPassword
WebUICommon.inputDataToTestObject(findTestObject('Object Repository/EN/bookAppointment/Page_Login/txfPassword'), "ThisIsNotAPassword", 10)

// Get Text from text box: txtPassword
println(WebUICommon.getTextFromObjectByInput(findTestObject('Object Repository/EN/bookAppointment/Page_Login/txfPassword'), 10))

// Click to button: Login
WebUICommon.clickToButton(findTestObject('Object Repository/EN/bookAppointment/Page_Login/btnLogin'), 10)

WebUI.comment("Step 3: Book a appointment")
// Select item from comboBox: Facility (by index)
WebUICommon.selectComboBoxItemByIndex(findTestObject('Object Repository/bookAppointment/Page_CURA Healthcare Service/cbFacility'), 1, 10)

// Select item from comboBox: Facility (by value)
WebUICommon.selectComboBoxItemByValue(findTestObject('Object Repository/bookAppointment/Page_CURA Healthcare Service/cbFacility'), "Seoul CURA Healthcare Center", 10)

// Click to check box: Apply for hospital readmission
WebUICommon.clickToCheckBox(findTestObject('Object Repository/bookAppointment/Page_CURA Healthcare Service/ckApply'), 10)

// Click to radio button: None programs
WebUICommon.clickToRadioButton(findTestObject('Object Repository/bookAppointment/Page_CURA Healthcare Service/rdNonePrograms'), 10)

// Input data to text box: Date
WebUICommon.inputDataToTestObject(findTestObject('Object Repository/bookAppointment/Page_CURA Healthcare Service/txtDate'), "20/02/2023", 10)

// Click to button: Book Appointment
WebUICommon.clickToButton(findTestObject('Object Repository/bookAppointment/Page_CURA Healthcare Service/btnBookAppointment'), 10)

WebUI.closeBrowser()

