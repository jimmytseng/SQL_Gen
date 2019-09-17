package genClassUtils;

public interface AutoGen {
   
   public static String startCurl = "{";
   public static String endCurl = "}";
   public static String changeLine = "\n";
   public static String changeLineAndSpace = "\n\t";
   public static String emptySpace=" ";
   public String genCode();
}
