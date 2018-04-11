package com.lionmobi.toXML;

public class ToXML {
	
	public static void  runTask(String dataPath,String rootPath) throws Exception{
		new Translation().doTranslate(dataPath, rootPath);
	}
}
