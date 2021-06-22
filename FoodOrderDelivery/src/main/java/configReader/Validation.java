package configReader;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

public class Validation {

	private Properties properties;
	private final String propertyFilePath = "configs/validationData.properties";

	public Validation() {
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
			throw new RuntimeException("validationData.properties not found at " + propertyFilePath);
		}
	}

	public String getTitle() {
		String title = properties.getProperty("title");
		if (title != null)
			return title;
		else
			throw new RuntimeException("title not specified in the validationData.properties file.");
	}

	public String getRestaurantTitle() {
		String restaurantTitle = properties.getProperty("restaurantTitle");
		if (restaurantTitle != null)
			return restaurantTitle;
		else
			throw new RuntimeException("restaurantTitle not specified in the validationData.properties file.");
	}

	public String getAmount() {
		String amount = properties.getProperty("amount");
		if (amount != null)
			return amount;
		else
			throw new RuntimeException("amount not specified in the validationData.properties file.");
	}

	public String getBagEmpty() {
		String bagEmptyMessage = properties.getProperty("bagEmptyMessage");
		if (bagEmptyMessage != null)
			return bagEmptyMessage;
		else
			throw new RuntimeException("bagEmptyMessage is not displayed in the validationData.properties file.");
	}
}
