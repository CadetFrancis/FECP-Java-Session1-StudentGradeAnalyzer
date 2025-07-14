package org.example;
import java.util.*;

public class Main{
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        char letter_grade= 'A';
        float ave = 0.0f;

        System.out.print("Enter number of students: ");
        int studentNum=s.nextInt();
        System.out.println();
        ArrayList<String> names = new ArrayList<>(studentNum);
        ArrayList<Integer> grades = new ArrayList<>(studentNum);
        ArrayList<Character> lgrades = new ArrayList<>(studentNum);

        for (int i=1;i<=studentNum;i++){
            System.out.printf("Enter name of student %d: ",i);
            String student_name=s.next();
            names.add(student_name);
            System.out.printf("Enter score for %s:",student_name);
            int grade=s.nextInt();
            grades.add(grade);
            letter_grade=letterGrade(grade);
            System.out.printf("%s got grade: %c%n%n",student_name,letter_grade);
            lgrades.add(letter_grade);
        }
        System.out.println("----- Class Summary -----");
        ave=class_average(grades);
        System.out.printf("Average Score: %.2f%n",ave);
        int[] count = grade_counts(lgrades);
        System.out.printf("Grade Counts: A:%d B:%d C:%d D:%d F:%d %n",count[0],count[1],count[2],count[3],count[4]);
        ArrayList<String> topStudents = top_student(names, grades);
        int max_grade = Collections.max(grades);
        System.out.printf("Top Student(s): %s (%d)%n", String.join(", ", topStudents),max_grade);
    }

    public static char letterGrade(int grade){
        if (grade >= 90) {
            return 'A';
        } else if (grade >= 80) {
            return 'B';
        } else if (grade >= 70) {
            return 'C';
        } else if (grade >= 60) {
            return 'D';
        } else {
            return 'F';
        }
    }
    public static float class_average(ArrayList<Integer> class_grades){
        int sum_grades=0;

        for (int i=0;i<= class_grades.size()-1;i++){
            sum_grades += class_grades.get(i);
        }
        return (float) sum_grades/class_grades.size();
    }
    public static int[] grade_counts(ArrayList<Character> letter){
        int A = 0;
        int B = 0;
        int C = 0;
        int D = 0;
        int F = 0;
        for (int i=0;i<=letter.size()-1;i++){
            switch (letter.get(i)){
                case 'A':
                    A++;
                    break;
                case 'B':
                    B++;
                    break;
                case 'C':
                    C++;
                    break;
                case 'D':
                    D++;
                    break;
                case 'F':
                    F++;
                    break;
                default:
                    break;
            }
        }
        return new int[]{A, B, C, D, F};
    }
    public static ArrayList<String> top_student(ArrayList<String> student_name, ArrayList<Integer> grade){
        ArrayList<String> topStudents = new ArrayList<>();

        int maxGrade = Collections.max(grade);

        for (int i = 0; i < grade.size(); i++) {
            if (grade.get(i) == maxGrade) {
                topStudents.add(student_name.get(i));
            }
        }
        return topStudents;
    }

}

