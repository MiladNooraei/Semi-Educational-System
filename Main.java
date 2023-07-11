package com.company;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Homework.hwClassNameQuestions.add("HW");
        Homework.hwStudentNumberHomeWorkNameAnswers.add("HW");
        Scanner scanner = new Scanner(System.in);
        System.out.println("\t*** WELCOME TO EXAM SYSTEM ***\n");
        while(true){
            System.out.println("Please Choose an Option :\n1: Login\n2: Sign Up\n3: Exit");
            int chooseOption = scanner.nextInt();
            scanner.nextLine();
            if(chooseOption == 1){
                while(true){
                    System.out.println("1: Login as Student\n2: Login as Professor\n3: Back");
                    chooseOption = scanner.nextInt();
                    scanner.nextLine();
                    if(chooseOption == 1){
                        Student student = new Student();
                        student = Student.studentLogin();
                        if(student != null){
                            System.out.println("\t*** Hello " + student.firstName + " " + student.lastName + " ***");
                            System.out.println("\n");
                            Class.studentMenu(student);
                        }else{
                            System.out.println("Student not found !");
                        }
                    }else if(chooseOption == 2){
                        Professor professor = new Professor();
                        professor = Professor.professorLogin();
                        if(professor != null){
                            System.out.println("\t*** Hello " + professor.firstName + " " + professor.lastName + " ***");
                            System.out.println("\n");
                            Class.professorMenu(professor);
                        }else{
                            System.out.println("Professor not found !");
                        }
                    }else if(chooseOption == 3){
                        System.out.println("\n");
                        break;
                    }else{
                        System.out.println("Invalid Option !\n\n");
                    }
                }
            }else if(chooseOption == 2){
                while(true){
                    System.out.println("1: Sign Up as Student\n2: Sign Up as Professor\n3: Back");
                    chooseOption = scanner.nextInt();
                    scanner.nextLine();
                    if(chooseOption == 1){
                        System.out.println("\n\n");
                        Student.studentSignUp();
                    }else if(chooseOption == 2){
                        System.out.println("\n\n");
                        Professor.professorSignUp();
                    }else if(chooseOption == 3){
                        System.out.println("\n");
                        break;
                    }else{
                        System.out.println("Invalid Option !\n\n");
                    }
                }
            }else if(chooseOption == 3){
                System.out.println("\n");
                break;
            }else{
                System.out.println("Invalid Option !\n\n");
            }
        }

    }

}