import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject

import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile

import mobileCustomKeywords.Common

Mobile.startExistingApplication("com.VCB")

Common.inputDataToTestObject(findTestObject('null'), "Khoa@123", 10)
//Mobile.sendKeys(findTestObject('null'), "Khoa@123")

println(Common.getTextFromObject(findTestObject('null'), 10))

Common.clickToButton(findTestObject('null'), 10)
//Mobile.tap(findTestObject('null'), 10)
Mobile.delay(5)
Common.swipeFromTopToBottom(0, 1000)

//Common.selectMenuItem(findTestObject('null'), 10)
//Mobile.tap(findTestObject('null'), 10)


//Mobile.tap(findTestObject('null'), 10)
//Mobile.tap(findTestObject('null'), 10)
//Mobile.tap(findTestObject('null'), 10)
//Mobile.tap(findTestObject('null'), 10)