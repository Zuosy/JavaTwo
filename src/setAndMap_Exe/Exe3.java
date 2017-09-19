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
		
		//ȥ��ע�� �ո� ���з�
		Pattern pattern1 = Pattern.compile("//.+");
		Matcher matcher1 = pattern1.matcher(sb);
		sb = matcher1.replaceAll(" ");//ȥ������ע��
		
		Pattern pattern2 = Pattern.compile("/\\*.*?\\*/", Pattern.DOTALL);
		//Pattern.DoTALL����ֶε���˼�ǣ�����ƥ���κ��ַ��������н�����
//		System.out.println(pattern2.toString());
		Matcher matcher2 = pattern2.matcher(sb);
		sb = matcher2.replaceAll(" ");//ȥ������ע��
		
		//������ȥ�����з� Let's we try it.
		Pattern pattern3 = Pattern.compile("\\n");
		Matcher matcher3 = pattern3.matcher(sb);
		sb = matcher3.replaceAll(" ");//ȥ�����з�
		
		Pattern pattern4 = Pattern.compile("\\t");
		Matcher matcher4 = pattern4.matcher(sb);
		sb = matcher4.replaceAll(" ");//��ȥ�Ʊ��
		
		Pattern pattern5 = Pattern.compile("\".+\"");
		Matcher matcher5 = pattern5.matcher(sb);
		sb = matcher5.replaceAll(" ");//��ȥ�ַ���
		
		System.out.println(sb);		
		addKeywords();//�ѹؼ��ּ��뵽Map�� ûë������
		String[] strs = sb.split("[ ,.?!(){};:]");
//		String[] strs = sb.split(" ");
		//����ÿ������ ����ǹؼ��־�++
		for(int i = 0; i < strs.length; i++) {
			if(map.containsKey(strs[i])) {
				int value = map.get(strs[i]) + 1;
				map.put(strs[i], value);
			}
		}
		
		//����һ��map ���value>0 ��output
		//��Ȼ���øո�ѧ��ɧ��·����
		Set<Map.Entry<String, Integer>> set = map.entrySet();
		//Ȼ����foreach����
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
 * �ܽ᣺���������bug�ı��磺
 * for(int
 *  �����ĵ������޷���ƥ��ġ�
 * ���ǣ�������Ӧ��������ϵ���ϰҪ���ˡ�
 */
