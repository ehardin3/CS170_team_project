package CS170_team_project;

import java.util.*;

public class CS170_team_project {
    public static void main(String[] args) {
        String filePath = "C:\\Users\\pwnag\\Downloads\\GradesSumm.csv";
//        Map<Integer, Map<String, Map<String, Double>>> gradeData = readFromFile.getGrades(filePath);
        Map<String, Map<String, Double>> gradeData = readFromFile.getGrades(filePath);
        displayData.showGrades(gradeData);
    }
}
