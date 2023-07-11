package com.company;
import java.util.ArrayList;
import java.util.Scanner;

public class Class {

    public String name;
    public String professorName;
    public String references;
    public String questions;

    public Class() {
        setName(name);
        setProfessorName(professorName);
        setReferences(references);
        setQuestions(questions);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getProfessorName() {
        return professorName;
    }

    public void setProfessorName(String professorName) {
        this.professorName = professorName;
    }

    public String getReferences() {
        return references;
    }

    public void setReferences(String references) {
        this.references = references;
    }

    public String getQuestions() {
        return questions;
    }

    public void setQuestions(String questions) {
        this.questions = questions;
    }

    public static ArrayList<String> classReference = new ArrayList<String>();
    public static ArrayList<String> classStudent = new ArrayList<String>();
    public static ArrayList<String> classQuestionBank = new ArrayList<String>();

    public static void studentMenu(Student student){
        Scanner scanner = new Scanner(System.in);
        while (true){
            System.out.println("Please Choose an Option :\n1: See all classes\n2: See my classes\n3: Join classes\n4: LogOut");
            int chooseOption = scanner.nextInt();
            scanner.nextLine();
            String fullName = student.firstName + " " + student.lastName;
            if(chooseOption == 1){
                for(Professor classes : Professor.listOfProfessors){
                    System.out.println(" -> " + classes.className);
                }
            }else if(chooseOption == 2){
                for(int i=0;i<classStudent.size();i++){
                    if(classStudent.get(i).equals(fullName)){
                        System.out.println(" -> " + classStudent.get(i-1));
                    }
                }
                while (true){
                    System.out.println("Please choose an option :\n1: Enter a Class\n2: Back");
                    chooseOption = scanner.nextInt();
                    scanner.nextLine();
                    if(chooseOption == 1){
                        System.out.println("Please enter the class name :");
                        String theClass = scanner.nextLine();
                        enterClassStudent(student, theClass);
                    }else if(chooseOption == 2){
                        break;
                    }else{
                        System.out.println("Invalid Option !\n\n");
                    }
                }
            }else if(chooseOption == 3){
                System.out.println("Please enter the Class Name you want to join :");
                String theClass = scanner.nextLine();
                classStudent.add(theClass);
                classStudent.add(fullName);
                System.out.println("You  are added to class");
            }else if(chooseOption == 4){
                break;
            }else{
                System.out.println("Invalid Option !\n\n");
            }
        }
    }

    public static void professorMenu(Professor professor){
        Scanner scanner = new Scanner(System.in);
        while (true){
            System.out.println("Please Choose an Option :\n1: Add References\n2: Set Exam\n3: Set HomeWork\n4: See Students\n5: Add Student to class\n6: Remove Student from class\n7: Add Question to Question Bank\n8: LogOut");
            int chooseOption = scanner.nextInt();
            scanner.nextLine();
            if(chooseOption == 1){
                System.out.println("Please enter the new Reference(Name/Link) :");
                String reference = scanner.nextLine();
                classReference.add(professor.className);
                classReference.add("* " + reference);
                System.out.println("Reference is added");
            }else if(chooseOption == 2){
                Exam.setExam(professor);
            }else if(chooseOption == 3){
                Homework.setHomeWork(professor);
            }else if(chooseOption == 4){
                System.out.println("\n");
                for(int i=0;i<classStudent.size();i++){
                    if(classStudent.get(i).equals(professor.className) && !classStudent.get(i+1).equals("Removed")){
                        System.out.println(" -> " + classStudent.get(i+1));
                    }
                }
                System.out.println("\n");
            }else if(chooseOption == 5){
                System.out.println("Please enter the Student Number :");
                String newStudent = scanner.nextLine();
                Student student = new Student();
                boolean flag = false;
                for(Student std : Student.listOfStudents){
                    if(std.studentNumber.equals(newStudent)){
                        classStudent.add(professor.className);
                        classStudent.add(std.firstName + " " + std.lastName);
                        flag = true;
                        break;
                    }
                }
                if(flag){
                    System.out.println("Student is added to class");
                }else{
                    System.out.println("There is not such a student");
                }
            }else if(chooseOption == 6){
                System.out.println("Please enter the Student Number :");
                String newStudent = scanner.nextLine();
                Student student = new Student();
                boolean flag = false;
                for(Student std : Student.listOfStudents){
                    if(std.studentNumber.equals(newStudent)){
                        String fullName = std.firstName + " " + std.lastName;
                        int index = classStudent.indexOf(fullName);
                        classStudent.set(index, "Removed");
                        flag = true;
                        break;
                    }
                }
                if(flag){
                    System.out.println("Student is removed from class");
                }else{
                    System.out.println("There is not such a student");
                }
            }else if(chooseOption == 7){
                System.out.println("Please enter the question :");
                String question = scanner.nextLine();
                classQuestionBank.add(professor.className);
                classQuestionBank.add(question);
                System.out.println("Question is added\n");
            }else if(chooseOption == 8){
                break;
            }else{
                System.out.println("Invalid Option !\n\n");
            }
        }
    }

    public static void enterClassStudent(Student student, String theClass){
        Scanner scanner = new Scanner(System.in);
        while (true){
            System.out.println("Please choose an option :\n1: See References\n2: My HomeWorks\n3: My Exams\n4: Back");
            int chooseOption = scanner.nextInt();
            scanner.nextLine();
            if(chooseOption == 1){
                for(int i=0;i<classReference.size();i++){
                    if(classReference.get(i).equals(theClass)){
                        System.out.println(classReference.get(i+1));
                    }
                }
            }else if(chooseOption == 2){
                Homework.studentHomeWork(student, theClass);
            }else if(chooseOption == 3){
                Exam.studentExam(student, theClass);
            }else if(chooseOption == 4){
                break;
            }else{
                System.out.println("Invalid Option !\n\n");
            }
        }
    }

}