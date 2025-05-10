import java.util.*;

public class displayData {
	public static void showGrades(Map<Integer, Map<String, Map<String, Double>>> data) {
		System.out.println("OHLONE STATS FOR SEMESTERS FROM " + data.get(0).keySet().toString() + " TO " + data.get(data.keySet().size() - 1).keySet().toString());
		System.out.println("-------------------------------------------------------------------------\n");
		for(int i = 0; i <= data.keySet().size() - 1; i++) {
			Map<String, Map<String, Double>> sems = data.get(i);
			for(String sem : sems.keySet())
				System.out.println("In the " + sem + " semester, " + sems.get(sem).get("A") + "% students got A's, while " + sems.get(sem).get("D") + "% got D's.");
		}
	}
}
