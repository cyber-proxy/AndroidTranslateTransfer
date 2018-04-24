package tools.transfer.main;

import java.io.IOException;

import javax.xml.parsers.ParserConfigurationException;

import org.xml.sax.SAXException;

import tools.transfer.toExcel.ToExcelImpl;

public class Transfer {

	public static void main(String[] args) throws SAXException, IOException, ParserConfigurationException {
		if(args == null || args.length == 0){
			System.out.println("Project folder doesn't exists");
			return;
		}
		ToExcelImpl.run(null, args[0], args.length > 1 ? args[1] : null, null);
	}

}
