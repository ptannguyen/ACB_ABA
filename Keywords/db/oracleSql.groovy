package db

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
import java.sql.*
import org.postgresql.jdbc.PgConnection
//import com.kms.katalon.core.annotation.Keyword
import com.kms.katalon.core.util.KeywordUtil

public class oracleSql {
	private static Connection connection = null;

	@Keyword
	def static connectDB(String driverType, String url, String dbname, String port, String username, String password) {
		//Load driver class for your specific database type
		String conn = "jdbc:oracle:"+ driverType + ":@" + url + ":" + port + ":" + dbname

		if (connection != null && !connection.isClosed()) {
			connection.close()
		}
		connection = DriverManager.getConnection(conn, username, password)
		return connection
	}

	@Keyword
	def static executeQueryGetData(String queryString) {
		Statement stm = connection.createStatement()
		ResultSet resultSet = stm.executeQuery(queryString)
		ResultSetMetaData metadata = resultSet.getMetaData()
		int columnCount = metadata.getColumnCount()
		List<List<String>> rowList = new LinkedList<List<String>>()
		while (resultSet.next()) {
			List<String> row = new LinkedList<>()
			for(int i =1; i <= columnCount; i++) {
				Object value = resultSet.getObject(i)
				row.add(value)
			}
			rowList.add(row)
		}
		int rowCount = 1
		for(List<String> row : rowList) {
			KeywordUtil.logInfo("row " + rowCount)
			for(String data : row) {
				KeywordUtil.logInfo(data)
			}
			rowCount++
		}
//		print(rowList)
		return rowList
	}

	@Keyword
	def static executeQuery(String queryString) {
		Statement stm = connection.createStatement()
		ResultSet rs = stm.executeQuery(queryString)
		return rs
	}

	@Keyword
	def static execute(String queryString) {
		Statement stm = connection.createStatement()
		boolean result = stm.execute(queryString)
		return result
	}

	@Keyword
	def static closeDatabaseConnection() {
		if(connection != null && !connection.isClosed()) {
			connection.close()
		}
		connection = null
	}

}
