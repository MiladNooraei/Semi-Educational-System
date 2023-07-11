package com.company;
import java.util.ArrayList;
import java.util.Scanner;

public class Homework {

    public String name;
    public Professor professor;
    public int grades;
    public String answers;

    public Homework() {
        setAnswers(answers);
        setGrades(grades);
        setProfessor(professor);
        setName(name);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Professor getProfessor() {
        return professor;
    }

    public void setProfessor(Professor professor) {
        this.professor = professor;
    }

    public int getGrades() {
        return grades;
    }

    public void setGrades(int grades) {
        this.grades = grades;
    }

    public String getAnswers() {
        return answers;
    }

    public void setAnswers(String answers) {
        this.answers = answers;
    }

    public static ArrayList<String> hwClassNameQuestions = new ArrayList<String>();
    public static ArrayList<String> hwStudentNumberHomeWorkNameAnswers = new ArrayList<String>();
    public static ArrayList<String> stdNumberHwNameScore = new ArrayList<String>();

    public static void setHomeWork(Professor professor){
        Scanner scanner = new Scanner(System.in);
        while (true){
            System.out.println("Please choose an option :\n1: Create HomeWork\n2: See HomeWorks\n3: Grading HomeWork\n4: Back");
            int chooseOption = scanner.nextInt();
            scanner.nextLine();
            if(chooseOption == 1){
                hwClassNameQuestions.add(professor.className);
                System.out.println("Please enter the HomeWork name :");
                String homeWorkName = scanner.nextLine();
                hwClassNameQuestions.add(homeWorkName);
                System.out.println("How many Questions does this HomeWork has :");
                int questionsNumber = scanner.nextInt();
                scanner.nextLine();
                for(int i=1;i<=questionsNumber;i++){
                    String theQuestion = scanner.nextLine();
                    hwClassNameQuestions.add(i + " : " + theQuestion);
                }
                hwClassNameQuestions.add("HW");
                System.out.println("HomeWork is created\n");
            }else if(chooseOption == 2){
                for(int i=0;i<hwClassNameQuestions.size();i++){
                    if(hwClassNameQuestions.get(i).equals(professor.className)){
                        System.out.println("* " + hwClassNameQuestions.get(i+1));
                    }
                }
                System.out.println("Choose the HomeWorks name :");
                String theHomeWork = scanner.nextLine();
                int index = hwClassNameQuestions.indexOf(theHomeWork);
                System.out.println("\t*** " + hwClassNameQuestions.get(index) + " ***\n");
                index++;
                while(!hwClassNameQuestions.get(index).equals("HW")){
                    System.out.println(hwClassNameQuestions.get(index));
                    index++;
                }
                System.out.println("\n");
            }else if(chooseOption == 3){
                System.out.println("Choose the HomeWorks name :");
                String theHomeWork = scanner.nextLine();
                for(int i=0;i<hwStudentNumberHomeWorkNameAnswers.size()-1;i++){
                    if(hwStudentNumberHomeWorkNameAnswers.get(i).equals("HW") && hwStudentNumberHomeWorkNameAnswers.get(i+2).equals(theHomeWork)){
                        System.out.println("<" + hwStudentNumberHomeWorkNameAnswers.get(i+1) + ">");
                        int index = i+3;
                        while(!hwStudentNumberHomeWorkNameAnswers.get(index).equals("HW")){
                            System.out.println(hwStudentNumberHomeWorkNameAnswers.get(index));
                            index++;
                        }
                    }
                }
                System.out.println("\n");
                while (true){
                    System.out.println("Please choose an option :\n1: Add Grade\n2: Edit Grade\n3: See Grades\n4: Back");
                    chooseOption = scanner.nextInt();
                    scanner.nextLine();
                    if(chooseOption == 1){
                        System.out.println("Please enter the student number :");
                        String theStdNumber = scanner.nextLine();
                        stdNumberHwNameScore.add(theStdNumber);
                        stdNumberHwNameScore.add(theHomeWork);
                        System.out.println("Please enter the students grade :");
                        String theGrade = scanner.nextLine();
                        stdNumberHwNameScore.add(theGrade);
                    }else if(chooseOption == 2){
                        System.out.println("Please enter the student number :");
                        String theStdNumber = scanner.nextLine();
                        System.out.println("Please enter the students grade :");
                        String theGrade = scanner.nextLine();
                        for(int i=0;i<stdNumberHwNameScore.size();i++){
                            if(stdNumberHwNameScore.get(i).equals(theStdNumber) && stdNumberHwNameScore.get(i+1).equals(theHomeWork)){
                                stdNumberHwNameScore.set(i+2, theGrade);
                                break;
                            }
                        }
                        System.out.println("Done !");
                    }else if(chooseOption == 3){
                        for(int i=0;i<stdNumberHwNameScore.size();i+=3){
                            System.out.println(stdNumberHwNameScore.get(i) + " <" + stdNumberHwNameScore.get(i+1) + "> " + " : " + stdNumberHwNameScore.get(i+2));
                        }
                    }else if(chooseOption == 4){
                        break;
                    }else{
                        System.out.println("Invalid Option !\n\n");
                    }
                }
            }else if(chooseOption == 4){
                break;
            }else{
                System.out.println("Invalid Option !\n\n");
            }
        }
    }

    public static void studentHomeWork(Student student, String theClass){
        Scanner scanner = new Scanner(System.in);
        while (true){
            System.out.println("Please choose an option :\n1: See HomeWorks\n2: Answer HomeWork\n3: See HomeWorks grade\n4: Back");
            int chooseOption = scanner.nextInt();
            scanner.nextLine();
            if(chooseOption == 1){
                for(int i=0;i<hwClassNameQuestions.size();i++){
                    if(hwClassNameQuestions.get(i).equals(theClass)){
                        System.out.println("* " + hwClassNameQuestions.get(i+1));
                    }
                }
                System.out.println("Choose the HomeWorks name :");
                String theHomeWork = scanner.nextLine();
                int index = hwClassNameQuestions.indexOf(theHomeWork);
                System.out.println("\t*** " + hwClassNameQuestions.get(index) + " ***\n");
                index++;
                while(!hwClassNameQuestions.get(index).equals("HW")){
                    System.out.println(hwClassNameQuestions.get(index));
                    index++;
                }
                System.out.println("\n");
            }else if(chooseOption == 2){
                hwStudentNumberHomeWorkNameAnswers.add(student.studentNumber);
                System.out.println("Choose the HomeWorks name :");
                String theHomeWork = scanner.nextLine();
                hwStudentNumberHomeWorkNameAnswers.add(theHomeWork);
                int index = hwClassNameQuestions.indexOf(theHomeWork);
                System.out.println("\t*** " + hwClassNameQuestions.get(index) + " ***\n");
                index++;
                while(!hwClassNameQuestions.get(index).equals("HW")){
                    System.out.println(hwClassNameQuestions.get(index));
                    String theAnswer = scanner.nextLine();
                    hwStudentNumberHomeWorkNameAnswers.add(theAnswer);
                    index++;
                }
                hwStudentNumberHomeWorkNameAnswers.add("HW");
            }else if(chooseOption == 3){
                System.out.println("Please enter the HomeWorks name :");
                String theHomeWork = scanner.nextLine();
                for(int i=0;i<stdNumberHwNameScore.size();i++){
                    if(stdNumberHwNameScore.get(i).equals(student.studentNumber) && stdNumberHwNameScore.get(i+1).equals(theHomeWork)){
                        System.out.println("Your grade is : " + stdNumberHwNameScore.get(i+2));
                        break;
                    }
                }
            }else if(chooseOption == 4){
                break;
            }else{
                System.out.println("Invalid Option !\n\n");
            }
        }
    }

}