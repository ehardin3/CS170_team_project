package CS170_team_project;

import java.util.*;

public class CS170_team_project {
    public static void main(String[] args) {
        String filePath = "C:\\Users\\pwnag\\Downloads\\GradesSumm.csv";
        Map<String, Map<String, Double>> gradeData = readFromFile.getGrades(filePath);
        displayData.showGrades(gradeData);
    }
}
