package genClassUtils;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintStream;
import java.io.UnsupportedEncodingException;

public class GenUtil {
	/**
	 * 將檔案寫出至指定目錄
	 *
	 * @param filename 要出至dir的目錄
	 * @param sb       要寫出的內容
	 */
	public static void writefile(String filename, StringBuilder sb) {
		try {
			PrintStream out = new PrintStream(filename, "UTF-8");
			out.print(sb.toString());
			out.flush();
			out.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	/**
	 * 將檔案寫出至指定目錄
	 *
	 * @param filename 要出至dir的目錄
	 * @param sb       要寫出的內容
	 */
	public static void writefile(String filename, String str) {
		try {
			PrintStream out = new PrintStream(filename, "UTF-8");
			out.print(str);
			out.flush();
			out.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public static void genFileToPackage(String fileName, String clazzStr) {
		File file = new File("");
		System.out.println(file.getAbsolutePath() + "\\src\\main\\java\\entity");
		String packeagePath = file.getAbsolutePath() + "\\\\src\\\\main\\\\java\\\\entity";
		File destPath = new File(packeagePath);
		if (!destPath.exists()) {
			destPath.mkdirs();
		}
		GenUtil.writefile(destPath + "\\" + fileName, clazzStr);
	}

	public static void main(String[] args) {
		// GenReportMain GF = new GenReportMain();
		String destinationLoc = "C://API/GenTest.java";
//		File file = new File(destinationLoc);
//		file.mkdirs();
		StringBuilder genBuilder = new StringBuilder();
		// genBuilder.append("package API;\n");
		genBuilder.append("public class GenTest { \n");
		genBuilder.append("public static void main(String[] args) { \n");
		genBuilder.append("\t System.out.print(1");
		genBuilder.append(");");
		genBuilder.append("\t }\n");
		genBuilder.append("}\n");
		writefile(destinationLoc, genBuilder);
	}

}
