import java.util.*;

public class displayData {
//	  public static void showGrades(Map<Integer, Map<String, Map<String, Double>>> data)
	public static void showGrades(Map<String, Map<String, Double>> data) {
		//Get the first and last semesters in the ordered set
		Set<String> sems = data.keySet();
		Iterator<String> it1 = sems.iterator();
		Iterator<String> it2 = sems.iterator();
		//The first one's first so we can grab it right away
		String first = it1.next();
		while(it1.hasNext()) {
			it1.next();
			//it2 trails behind it1 so when it1 !hasNext(), it2's .next() is the final value
			it2.next();
		}
		//Get the final value
		String last = it2.next();
/*
		System.out.println("OHLONE STATS FOR SEMESTERS FROM " + data.get(0).keySet().toString() + " TO " + data.get(data.keySet().size() - 1).keySet().toString());
		System.out.println("-------------------------------------------------------------------------\n");
		for(int i = 0; i <= data.keySet().size() - 1; i++) {
			Map<String, Map<String, Double>> sems = data.get(i);
			for(String sem : sems.keySet())
				System.out.println("In the " + sem + " semester, " + sems.get(sem).get("A") + "% students got A's, while " + sems.get(sem).get("D") + "% got D's.");
		}
*/
		System.out.println("OHLONE STATS FOR SEMESTERS FROM " + first + " TO " + last);
		System.out.println("-------------------------------------------------------------------------\n");
		for(String sem : sems)
			System.out.println("In the " + sem + " semester, " + data.get(sem).get("A") + "% students got A's, while " + data.get(sem).get("D") + "% got D's.");
	}
}
