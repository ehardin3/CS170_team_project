import java.util.*;

public class displayData {
	public static void showGrades(Map<String, Map<String, Double>> data) {
		Set<String> temp = data.keySet();
		Iterator<String> it1 = temp.iterator();
		Iterator<String> it2 = temp.iterator();
		String first = it1.next();
		while(it1.hasNext()) {
			it1.next();
			it2.next();
		}
		String last = it2.next();
		System.out.println("OHLONE STATS FOR SEMESTERS FROM " + first.toUpperCase() + " TO " + last.toUpperCase());
		System.out.println("-------------------------------------------------------------------------\n");
		for(String sem : data.keySet()) {
			System.out.println("In the " + sem + " semester, " + data.get(sem).get("A") + "% students got A's, while " + data.get(sem).get("D") + "% got D's.");
		}
	}
}
