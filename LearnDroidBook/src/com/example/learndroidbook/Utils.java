package com.example.learndroidbook;


public final  class Utils {

//	public static final HashMap<String, String> getTagFromResourseString (String resourseString)
	public static final String [] getTagFromResourseString (String resourseString)
	{
		//String []
//		HashMap<String, String> hash = new HashMap<String, String>();
//
//		int stratTagPosition = resourseString.indexOf("tag:OOP", 0);
//		String value = resourseString.substring(0, stratTagPosition);
//		String key = resourseString.substring(stratTagPosition, resourseString.length());
//		hash.put(key, value);
//		return hash;
		String [] contentAndTag = resourseString.split("\\ tag:");  
		return contentAndTag;
	}
}
