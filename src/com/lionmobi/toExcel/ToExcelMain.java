package com.lionmobi.toExcel;

import java.io.FileNotFoundException;
import java.io.IOException;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.TransformerException;

import org.xml.sax.SAXException;


/**
 * 功能解释如下：
 * 	-i 功能：java -jar LangTool.jar ./*.xls
 * 		将EXCEL文件输出到各个语言对应的xml文件。
 * 		输出：/prj/res/(values, values-ar, values-...)
 * 	-e 功能: java -jar LangTool.jar   -e  test_8_16
 * 		test_8_16是工程文件目录目录格式： /prj(test_8_16)/res/(values, values-zh)
 * 		输出：EXCEL文件： KEY, DEFAULT ZH
 * @author Administrator
 *
 */
public class ToExcelMain {

	public static void main(String[] args) throws FileNotFoundException, IOException, ParserConfigurationException, TransformerException, SAXException {
		if(args == null || args.length == 0){
			printHelp();
			return;
		}
		
		if("-i".equals(args[0])){
			ToolImport.run(args[1]);
		}else if("-e".equals(args[0])){
			if (args.length > 2 && "-f".equals(args[2])) {
				ToExcelImpl.run(args[1], args.length > 4 ? args[4] : null, args[3]);
			} else {
				ToExcelImpl.run(args[1], args.length > 2 ? args[2] : null);
			}
		}else{
			printHelp();
		}
	}
	
	private static void printHelp(){
		System.out.println("commands format:");
		System.out.println("\texport: -e <project dir> [-f <input file name>] <output file>");
		System.out.println("\timport: -i <input file>");
	}
}
