package setAndMap_Exe;

import java.util.Map;
import java.util.Set;
import java.util.TreeMap;
import java.util.TreeSet;

public class Exe7 {
	public static void main(String[] args) {
		String text = "Good morning. Have a good class. " + 
				"Have a good visit. Have fun!";
		Map<String, Integer> map = new TreeMap<>();
		String[] words = text.split("[ \n\t\r.,;:!?(){}]");
		for(int i = 0; i < words.length; i++) {
			String key = words[i].toLowerCase();
			if(key.length() > 0) {
				if(!map.containsKey(key)) {
					map.put(key, 1);
				} else {
					int value = map.get(key) + 1;
					map.put(key, value);
				}
			}
		}
		Set<Map.Entry<String, Integer>> entrySet = map.entrySet();
		//List<WordOccurrence> list = new ArrayList<>();
		
		TreeSet<WordOccurrence> set = new TreeSet<>();
		for(Map.Entry<String, Integer> entry : entrySet) {
			
			//list.add(new WordOccurrence(entry.getKey(), entry.getValue()));
			
			System.out.println(entry.getKey() + "---->" + entry.getValue());
			set.add(new WordOccurrence(entry.getKey(), entry.getValue()));
			
//			System.out.println(set.add(new WordOccurrence(entry.getKey(), entry.getValue()))
//					);
		}
		System.out.println(set);
		
		
		//Collections.sort(list);
		//System.out.println(list);
	}
}
/*
[class:	1
, fun:	1
, morning:	1
, visit:	1
, a:	2
, good:	3
, have:	3
]
*/
/*
[class:	1
, a:	2
, good:	3
]
 */