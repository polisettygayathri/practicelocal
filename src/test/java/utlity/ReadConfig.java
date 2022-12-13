package utlity;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class ReadConfig {

	Properties prop;

	public ReadConfig() throws Exception {

		FileInputStream fis = new FileInputStream("./testData/config.properties");

		prop = new Properties();

		prop.load(fis);

	}

	public String appURL() {

		return prop.getProperty("appURL");

	}

	public String getSampleAppURL() {

		return prop.getProperty("sample_appURL");

	}
	
	public String getEmail() {

		return prop.getProperty("adminUserName");

	}

	public String getPass() {

		return prop.getProperty("adminPassword");

	}

}
