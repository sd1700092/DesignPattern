package com.imooc.util;

import org.apache.commons.lang3.StringUtils;

import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Properties;

public class PropertiesUtil {
  private static Properties prop;
  static {
    String fileName ="type.properties";
    prop = new Properties();
    try {
      prop.load(new InputStreamReader(PropertiesUtil.class.getClassLoader().getResourceAsStream(fileName), "UTF-8"));
    } catch (IOException e) {
      e.printStackTrace();
    }
  }
  
  public static String getProperty(String key){
    String value = prop.getProperty(key.trim());
    if (StringUtils.isBlank(value)){
      return null;
    }
    return value.trim();
  }
  
  public static String getProperty(String key, String defaultValue){
    String value = prop.getProperty(key.trim());
    if(StringUtils.isBlank(value)){
      return defaultValue;
    }
    return value.trim();
  }
}
