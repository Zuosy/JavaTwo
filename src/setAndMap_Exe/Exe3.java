package setAndMap_Exe;

import java.io.File;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeMap;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Exe3 {
	public static Map<String, Integer> map = new TreeMap<>(); 
	
	public static void main(String[] args) throws Exception {
		File file = new File("input.txt");
		String sb = "";
		Scanner input = new Scanner(file);
		while(input.hasNextLine()) {
			sb += input.nextLine() + "\n";
		}
		input.close();
		
		//去除注释 空格 换行符
		Pattern pattern1 = Pattern.compile("//.+");
		Matcher matcher1 = pattern1.matcher(sb);
		sb = matcher1.replaceAll(" ");//去除单行注释
		
		Pattern pattern2 = Pattern.compile("/\\*.*?\\*/", Pattern.DOTALL);
		//Pattern.DoTALL这个字段的意思是：可以匹配任何字符，包括行结束符
//		System.out.println(pattern2.toString());
		Matcher matcher2 = pattern2.matcher(sb);
		sb = matcher2.replaceAll(" ");//去除多行注释
		
		//还可以去除换行符 Let's we try it.
		Pattern pattern3 = Pattern.compile("\\n");
		Matcher matcher3 = pattern3.matcher(sb);
		sb = matcher3.replaceAll(" ");//去除换行符
		
		Pattern pattern4 = Pattern.compile("\\t");
		Matcher matcher4 = pattern4.matcher(sb);
		sb = matcher4.replaceAll(" ");//除去制表符
		
		Pattern pattern5 = Pattern.compile("\".+\"");
		Matcher matcher5 = pattern5.matcher(sb);
		sb = matcher5.replaceAll(" ");//出去字符串
		
		System.out.println(sb);		
		addKeywords();//把关键字加入到Map中 没毛病老铁
		String[] strs = sb.split("[ ,.?!(){};:]");
//		String[] strs = sb.split(" ");
		//遍历每个单词 如果是关键字就++
		for(int i = 0; i < strs.length; i++) {
			if(map.containsKey(strs[i])) {
				int value = map.get(strs[i]) + 1;
				map.put(strs[i], value);
			}
		}
		
		//遍历一下map 如果value>0 就output
		//当然是用刚刚学的骚套路才行
		Set<Map.Entry<String, Integer>> set = map.entrySet();
		//然后用foreach遍历
		for(Map.Entry<String, Integer> entry : set) {
			if(entry.getValue() > 0) {
				System.out.println(entry.getKey() + ":\t" + entry.getValue());
			}
		}
	}
	
	public static void addKeywords(){
		String[] keywordString = {"abstract", "assert", "boolean",
				"break", "byte", "case", "catch", "char", "class",
				"const", "continue", "default", "do", "double",
				"else", "enum", "extends", "for", "final", "finally",
				"float", "goto", "if", "implements", "import", "instanceof",
				"int", "interface", "long", "native", "new", "package",
				"private", "protected", "public", "return", "short",
				"static", "strictfp", "super", "switch", "synchronized",
				"this", "throw", "throws", "transient", "try",
				"void", "volatile", "while", "true", "false", "null"};
		for(int i = 0; i < keywordString.length; i++) {
			map.put(keywordString[i], 0);
		}
	}
}
/**
 * 总结：这个还是有bug的比如：
 * for(int
 *  这样的单词是无法被匹配的。
 * 但是，我想我应该完成书上的练习要求了。
 */
