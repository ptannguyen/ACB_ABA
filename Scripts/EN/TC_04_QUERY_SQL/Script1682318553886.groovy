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
import db.oracleSql as oracleSql

WebUI.comment("TC_04_TC_QUERY_SQL")

WebUI.comment("Step 1: Connect To DataBase")
oracleSql.connectDB("thin", "localhost", "orcl", "1521", "system", "Phuc123pw")

WebUI.comment("Step 2: Get FIRST_NAME,LAST_NAME From EMPLOYEES Table With ID 113")
oracleSql.executeQueryGetData("SELECT FIRST_NAME,LAST_NAME FROM EMPLOYEES WHERE EMPLOYEE_ID = 113")

WebUI.comment("Step 3: Get Data With Conditions")
oracleSql.executeQueryGetData("SELECT * FROM EMPLOYEES WHERE FIRST_NAME LIKE '%Jo%' ORDER BY EMPLOYEE_ID ASC")

WebUI.comment("Step 4: Close Connection")
oracleSql.closeDatabaseConnection()