package com.company;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class Student {
    public String firstName;
    public String lastName;
    public String studentNumber;
    public float gradeAverage;
    public Gender gender;
    public Fields field;
    public String password;

    public Student() {
        setFirstName(firstName);
        setLastName(lastName);
        setGender(gender);
        setStudentNumber(studentNumber);
        setField(field);
        setGradeAverage(gradeAverage);
        setPassword(password);
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getStudentNumber() {
        return studentNumber;
    }

    public void setStudentNumber(String studentNumber) {
        this.studentNumber = studentNumber;
    }

    public float getGradeAverage() {
        return gradeAverage;
    }

    public void setGradeAverage(float gradeAverage) {
        this.gradeAverage = gradeAverage;
    }

    public Gender getGender() {
        return gender;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
    }

    public Fields getField() {
        return field;
    }

    public void setField(Fields field) {
        this.field = field;
    }

    public static ArrayList<Student> listOfStudents = new ArrayList<Student>();
    public static ArrayList<String> uniqueStudentNumber = new ArrayList<String>();

    public static void studentSignUp(){
        Scanner scanner = new Scanner(System.in);
        Student student = new Student();
        while (true){
            System.out.println("Please enter your firstname :");
            student.firstName = scanner.nextLine();
            if ((student.firstName != null) && (!(student.firstName.length() == 0)) && (student.firstName.matches("^[a-zA-Z]*$"))){
                break;
            }else{
                System.out.println("Not accepted ! Please try another one\n");
            }
        }

        while (true){
            System.out.println("Please enter your lastname :");
            student.lastName = scanner.nextLine();
            if ((student.lastName != null) && (!(student.lastName.length() == 0)) && (student.lastName.matches("^[a-zA-Z]*$"))){
                break;
            }else{
                System.out.println("Not accepted ! Please try another one\n");
            }
        }

        while (true){
            System.out.println("Please choose your gender:\n1: MALE\n2: FEMALE");
            int chooseOption = scanner.nextInt();
            scanner.nextLine();
            if(chooseOption == 1){
                student.gender = Gender.MALE;
                break;
            }else if(chooseOption == 2){
                student.gender = Gender.FEMALE;
                break;
            }else{
                System.out.println("Invalid Option !\n\n");
            }
        }

        while (true){
            System.out.println("Please enter your student number :");
            student.studentNumber = scanner.nextLine();
            if ((student.studentNumber.length() == 7) && (student.studentNumber.matches("[0-9]+")) && (!uniqueStudentNumber.contains(student.studentNumber))){
                uniqueStudentNumber.add(student.studentNumber);
                break;
            }else{
                System.out.println("Not accepted ! Please try another one:");
            }
        }

        while (true){
            System.out.println("Please Choose your major :\n1: COMPUTER_ENGINEERING\n2: ELECTRIC_ENGINEERING\n3: MECHANICAL_ENGINEERING\n4: CIVIL_ENGINEERING\n5: ARCHITECTURAL_ENGINEERING\n6: CHEMICAL_ENGINEERING\n7: PETROLEUM_ENGINEERING");
            int chooseOption = scanner.nextInt();
            scanner.nextLine();
            if(chooseOption == 1){
                student.field = Fields.COMPUTER_ENGINEERING;
                break;
            }else if(chooseOption == 2){
                student.field = Fields.ELECTRIC_ENGINEERING;
                break;
            }else if(chooseOption == 3){
                student.field = Fields.MECHANICAL_ENGINEERING;
                break;
            }else if(chooseOption == 4){
                student.field = Fields.CIVIL_ENGINEERING;
                break;
            }else if(chooseOption == 5){
                student.field = Fields.ARCHITECTURAL_ENGINEERING;
                break;
            }else if(chooseOption == 6){
                student.field = Fields.CHEMICAL_ENGINEERING;
                break;
            }else if(chooseOption == 7){
                student.field = Fields.PETROLEUM_ENGINEERING;
                break;
            }else{
                System.out.println("Invalid Option !\n\n");
            }
        }

        System.out.println("Please enter your GPA :");
        student.gradeAverage = scanner.nextFloat();

        String randomString;
        String numbers = "0123456789";
        StringBuilder sb = new StringBuilder();
        Random random = new Random();
        int length = 7;
        for (int i = 0; i < length; i++) {
            int index = random.nextInt(numbers.length());
            char randomChar = numbers.charAt(index);
            sb.append(randomChar);
            }
        randomString = sb.toString();
        System.out.println("You have successfully signed up !");
        System.out.println("Your Password is : " + randomString + "\n\n");
        student.password = randomString;

        listOfStudents.add(student);

    }

    public static Student studentLogin(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Please Enter your Student Number :");
        String stdNumber = scanner.nextLine();
        System.out.println("Please Enter your Password :");
        String stdPassword = scanner.nextLine();
        for(Student std : listOfStudents){
            if(std.studentNumber.equals(stdNumber) && std.password.equals(stdPassword)){
                return std;
            }
        }
        return null;
    }

}