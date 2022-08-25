package com.realestate.paramountProperty.gennericUtility;

import java.io.FileInputStream;
import java.util.Properties;

public class FileUtility {

/**
 *   its used return the value from the property file based on key
 * @Rakesh key
 * @return value
 * @throws Throwable
 */
	public String getPropertyKeyValue(String key) throws Throwable {
		
		FileInputStream fis = new FileInputStream(IConstatants.PropertyFilePath);
		Properties pObj = new Properties();
		pObj.load(fis);
		String value = pObj.getProperty(key);
		return value;
		
	}


}
