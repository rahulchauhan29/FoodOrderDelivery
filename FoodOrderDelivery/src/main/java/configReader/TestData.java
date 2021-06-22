package configReader;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

public class TestData {

	private Properties properties;
	private final String propertyFilePath = "configs/testData.properties";

	public TestData() {
		BufferedReader reader;
		try {
			reader = new BufferedReader(new FileReader(propertyFilePath));
			properties = new Properties();
			try {
				properties.load(reader);
				reader.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
			throw new RuntimeException("TestData.properties not found at " + propertyFilePath);
		}
	}

	public String getUserName() {
		String userName = properties.getProperty("userName");
		if (userName != null)
			return userName;
		else
			throw new RuntimeException("username not specified in the TestData.properties file.");
	}

	public String getPassword() {
		String password = properties.getProperty("password");
		if (password != null)
			return password;
		else
			throw new RuntimeException("password not specified in the TestData.properties file.");
	}

	public String getLocation() {
		String location = properties.getProperty("location");
		if (location != null)
			return location;
		else
			throw new RuntimeException("location not specified in the TestData.properties file.");
	}

	public String getQuantity() {
		String quantity = properties.getProperty("quantity");
		if (quantity != null)
			return quantity;
		else
			throw new RuntimeException("quantity not specified in the TestData.properties file.");
	}
}
