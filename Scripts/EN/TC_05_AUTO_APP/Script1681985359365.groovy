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
import common.MobileCommon as MobileCommon

WebUI.comment("TC_05_AURTO_APP")

WebUI.comment("Step 1: Open Android Navite Demo App ")
Mobile.startApplication('D:\\AndroidNativeDemoApp.apk', true)

WebUI.comment("Step 2: Click To WebView")
MobileCommon.clickToButton(findTestObject('Object Repository/EN/AndroidApp/android.widget.TextView - Webview (1)'), 60)

WebUI.comment("Step 3: Click To Toggle navigation bar ")
MobileCommon.clickToButton(findTestObject('Object Repository/EN/AndroidApp/android.widget.Button - Toggle navigation bar'), 60)

WebUI.comment("Step 4: Close Application ")
Mobile.closeApplication()

