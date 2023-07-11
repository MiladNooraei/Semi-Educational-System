package com.company;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class Professor {
    public String firstName;
    public String lastName;
    public Gender gender;
    public Fields field;
    public String password;
    public String className;

    public Professor() {
        setFirstName(firstName);
        setLastName(lastName);
        setField(field);
        setPassword(password);
        setGender(gender);
        setClassName(className);
    }

    public String getClassName() {
        return className;
    }

    public void setClassName(String className) {
        this.className = className;
    }

    public Gender getGender() {
        return gender;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
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

    public Fields getField() {
        return field;
    }

    public void setField(Fields field) {
        this.field = field;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public static ArrayList<Professor> listOfProfessors = new ArrayList<Professor>();
    public static ArrayList<String> uniqueClass = new ArrayList<String>();

    public static void professorSignUp(){
        Scanner scanner = new Scanner(System.in);
        Professor professor = new Professor();

        while (true){
            System.out.println("Please enter your firstname :");
            professor.firstName = scanner.nextLine();
            if ((professor.firstName != null) && (!(professor.firstName.length() == 0)) && (professor.firstName.matches("^[a-zA-Z]*$"))){
                break;
            }else{
                System.out.println("Not accepted ! Please try another one\n");
            }
        }

        while (true){
            System.out.println("Please enter your lastname :");
            professor.lastName = scanner.nextLine();
            if ((professor.lastName != null) && (!(professor.lastName.length() == 0)) && (professor.lastName.matches("^[a-zA-Z]*$"))){
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
                professor.gender = Gender.MALE;
                break;
            }else if(chooseOption == 2){
                professor.gender = Gender.FEMALE;
                break;
            }else{
                System.out.println("Invalid Option !\n\n");
            }
        }

        while (true){
            System.out.println("Please Choose your major :\n1: COMPUTER_ENGINEERING\n2: ELECTRIC_ENGINEERING\n3: MECHANICAL_ENGINEERING\n4: CIVIL_ENGINEERING\n5: ARCHITECTURAL_ENGINEERING\n6: CHEMICAL_ENGINEERING\n7: PETROLEUM_ENGINEERING");
            int chooseOption = scanner.nextInt();
            scanner.nextLine();
            if(chooseOption == 1){
                professor.field = Fields.COMPUTER_ENGINEERING;
                break;
            }else if(chooseOption == 2){
                professor.field = Fields.ELECTRIC_ENGINEERING;
                break;
            }else if(chooseOption == 3){
                professor.field = Fields.MECHANICAL_ENGINEERING;
                break;
            }else if(chooseOption == 4){
                professor.field = Fields.CIVIL_ENGINEERING;
                break;
            }else if(chooseOption == 5){
                professor.field = Fields.ARCHITECTURAL_ENGINEERING;
                break;
            }else if(chooseOption == 6){
                professor.field = Fields.CHEMICAL_ENGINEERING;
                break;
            }else if(chooseOption == 7){
                professor.field = Fields.PETROLEUM_ENGINEERING;
                break;
            }else{
                System.out.println("Invalid Option !\n\n");
            }
        }

        while (true){
            System.out.println("Please enter the course you are going to teach :");
            professor.className = scanner.nextLine();
            if ((professor.className != null) && (!(professor.className.length() == 0)) && (!uniqueClass.contains(professor.className))){
                uniqueClass.add(professor.className);
                break;
            }else{
                System.out.println("Not accepted ! Please try another one\n");
            }
        }

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
        professor.password = randomString;

        listOfProfessors.add(professor);

    }

    public static Professor professorLogin(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Please Enter your Last Name :");
        String psrLastName = scanner.nextLine();
        System.out.println("Please Enter your Password :");
        String psrPassword = scanner.nextLine();
        for(Professor psr : listOfProfessors){
            if(psr.lastName.equals(psrLastName) && psr.password.equals(psrPassword)){
                return psr;
            }
        }
        return null;
    }

}