package setAndMap_Exe;

import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedHashSet;

public class Exe1 {
	public static void main(String[] args) {
		String[] str1 = {"George", "Jim", "John", "Blake", "Kevin", "Michael"};
		String[] str2 = {"George", "Katie", "Kevin", "Michelle", "Ryan"};
		LinkedHashSet<String> linkedHashSet1 =
				new LinkedHashSet<>(Arrays.asList(str1));
		LinkedHashSet<String> linkedHashSet2 =
				new LinkedHashSet<>(Arrays.asList(str2));
		
		System.out.print("A: ");
		System.out.println(linkedHashSet1);
		System.out.print("B: ");
		System.out.println(linkedHashSet2);
		
		//并集
		LinkedHashSet<String> bingji = 
				new LinkedHashSet<>();
		bingji.addAll(linkedHashSet1);
		for(Iterator<String> i = linkedHashSet2.iterator();
				i.hasNext(); ) {
			String temp = i.next();
			if(!bingji.contains(temp))
				bingji.add(temp);
		}
		System.out.print("并集: ");
		System.out.println(bingji);
		
		//差集 属于A 不属于B
		LinkedHashSet<String> chaji =
				new LinkedHashSet<>();
		chaji.addAll(linkedHashSet1);
		for(Iterator<String> i = linkedHashSet2.iterator();
				i.hasNext(); ) {
			String temp = i.next();
			if(chaji.contains(temp))
				chaji.remove(temp);//直接写这句应该也行吧。
		}
		System.out.print("差集: ");
		System.out.println(chaji);
		
		//交集
		LinkedHashSet<String> jiaoji = 
				new LinkedHashSet<>();
		for(Iterator<String> i = linkedHashSet2.iterator(); 
				i.hasNext(); ) {
			String temp = i.next();
			if(linkedHashSet1.contains(temp)) {
				jiaoji.add(temp);
			}
		}
		System.out.print("交集: ");
		System.out.println(jiaoji);
	}
}
