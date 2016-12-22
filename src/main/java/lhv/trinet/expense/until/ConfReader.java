package lhv.trinet.expense.until;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Properties;

public class ConfReader {

	public String Get(String fieldName) {

		Properties prop = new Properties();
		InputStream input = null;

		try {
			input = new FileInputStream("config.properties");
			
			// load a properties file
			prop.load(input);
		} catch (IOException ex) {
			ex.printStackTrace();
		} finally {
			if (input != null) {
				try {
					input.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
		// get the property value and return
		return prop.getProperty(fieldName);
	}

	public void Write(String fieldName, String value) {

		Properties prop = new Properties();
		OutputStream output = null;

		try {
			output = new FileOutputStream("config.properties");

			// set the properties value
			prop.setProperty(fieldName, value);

			// save properties to project root folder
			prop.store(output, null);
		} catch (IOException io) {
			io.printStackTrace();
		} finally {
			if (output != null) {
				try {
					output.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
	}
}
