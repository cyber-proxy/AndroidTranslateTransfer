package tools.transfer.toXML;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

/**
 * targetXml: <font color="#4A90E2">%1$s</font> is safe
 * <string name="security_result_eliminated_num">&lt;font color=\"#8F4E586A\"&gt;%1$s&lt;/font&gt; threats eliminated</string>
 * 要求：>&lt;font color=\"#8F4E586A\"&gt;%1$s&lt;/font&gt;是格式化的文字，不能有错误，否则会崩溃。
 * 	1、\"#8F4E586A\"之间不能有空格，检测方式就是调用一次，
 * 	2、
 * @author Administrator
 *
 */
public class CompleteLanaguageXml {

	public static void complete(String targetXml, String key, String value) throws Exception {
		value = value.replaceAll("<", "&lt;").replaceAll(">", "&gt;");
		// BufferedReader br = new BufferedReader(new FileReader(targetXml));
		BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(targetXml), "UTF-8"));
		String line = null;
		boolean found = false;
		StringBuilder sb = new StringBuilder();
		while ((line = br.readLine()) != null) {
			String prefix = key.split("_")[0];
			if (line.matches(" name=\"" + prefix)) {
				sb.append(String.format("<string name=\"%s\">%s</string>", key, value) + "\r\n");
				found = true;
			}
			if (line.trim().equals("</resources>")) {
				if (!found) {
					sb.append(String.format("<string name=\"%s\">%s</string>", key, value) + "\r\n");
				}
			}
			sb.append(line + "\r\n");
		}

		br.close();
		OutputStreamWriter outputStreamWriter = new OutputStreamWriter(new FileOutputStream(targetXml), "utf-8");
		outputStreamWriter.write(sb.toString());
		byte[] bytes = sb.toString().getBytes();
		StringBuilder byttt = new StringBuilder();
		for (byte b : bytes) {
			byttt.append((int) b);
		}

		outputStreamWriter.close();
	}
}
