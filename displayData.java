import java.util.Map;

public class displayData {
	public static void showGrades(Map<String, Map<String, Double>> data) {
		for(String sem : data.keySet()) {
			System.out.println("In the " + sem + " semester, " + data.get(sem).get("A") + "% students got A's, while " + data.get(sem).get("D") + "%% got D's.\n");
		}
	}
}
