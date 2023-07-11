package com.company;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.Random;

public class Exam {
    public String examName;
    public String timeDuration;
    public String className;
    public int numberOfQuestions;

    public Exam() {
        setExamName(examName);
        setTimeDuration(timeDuration);
        setClassName(className);
        setNumberOfQuestions(numberOfQuestions);
    }

    public String getExamName() {
        return examName;
    }

    public void setExamName(String examName) {
        this.examName = examName;
    }

    public String getTimeDuration() {
        return timeDuration;
    }

    public void setTimeDuration(String timeDuration) {
        this.timeDuration = timeDuration;
    }

    public String getClassName() {
        return className;
    }

    public void setClassName(String className) {
        this.className = className;
    }

    public int getNumberOfQuestions() {
        return numberOfQuestions;
    }

    public void setNumberOfQuestions(int numberOfQuestions) {
        this.numberOfQuestions = numberOfQuestions;
    }

    public static ArrayList<Exam> listOfExams = new ArrayList<Exam>();
    public static ArrayList<String> examNameStudentNumberQuestionsAnswers = new ArrayList<String>();
    public static ArrayList<String> studentNumberExamNameGrade = new ArrayList<String>();

    public static void setExam(Professor professor){
        Scanner scanner = new Scanner(System.in);
        while (true){
            System.out.println("Please choose an option :\n1: Create Exam\n2: Grading Exam\n3: Edit Exams grade\n4: Back");
            int chooseOption = scanner.nextInt();
            scanner.nextLine();
            if(chooseOption == 1){
                Exam exam = new Exam();
                System.out.println("Please choose a name for your Exam :");
                exam.examName = scanner.nextLine();
                System.out.println("How long the exam will be(Hours) :");
                exam.timeDuration = scanner.nextLine();
                exam.className = professor.className;
                System.out.println("How many questions will the exam have(Questions will randomly be choosed from QuestionBank) :");
                exam.numberOfQuestions = scanner.nextInt();
                scanner.nextLine();
                listOfExams.add(exam);
                System.out.println("The exam is created !");
            }else if(chooseOption == 2){
                int numberOfQuestions = 0;
                System.out.println("Please enter the Exams name :");
                String theExam = scanner.nextLine();
                System.out.println("Please enter the Students StudentNumber :");
                String theStdNumber = scanner.nextLine();
                for(Exam myExam : listOfExams){
                    if(myExam.examName.equals(theExam)){
                        numberOfQuestions = myExam.numberOfQuestions;
                        break;
                    }
                }
                int index = 0;
                for(int i=0;i<examNameStudentNumberQuestionsAnswers.size();i++){
                    if(examNameStudentNumberQuestionsAnswers.get(i).equals(theExam) && examNameStudentNumberQuestionsAnswers.get(i+1).equals(theStdNumber)){
                        index = i+2;
                    }
                }
                for(int i=index;i<(numberOfQuestions*2)+index;i++){
                    System.out.println(examNameStudentNumberQuestionsAnswers.get(i));
                }
                System.out.println("Please Enter the grade :");
                String theGrade = scanner.nextLine();
                studentNumberExamNameGrade.add(theStdNumber);
                studentNumberExamNameGrade.add(theExam);
                studentNumberExamNameGrade.add(theGrade);
            }else if(chooseOption == 3){
                System.out.println("Please enter the exam name :");
                String theExam = scanner.nextLine();
                System.out.println("Please enter the StudentsNumber :");
                String theStdNumber = scanner.nextLine();
                System.out.println("Please enter the new grade :");
                String theGrade = scanner.nextLine();
                for(int i=0;i<studentNumberExamNameGrade.size();i++){
                    if(studentNumberExamNameGrade.get(i).equals(theStdNumber) && studentNumberExamNameGrade.get(i+1).equals(theExam)){
                        studentNumberExamNameGrade.set(i+2, theGrade);
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

    public static void studentExam(Student student, String theClass){
        Scanner scanner = new Scanner(System.in);
        while (true){
            System.out.println("Please choose an option :\n1: Participate in Exam\n2: See Exams grade\n3: Back");
            int chooseOption = scanner.nextInt();
            scanner.nextLine();
            if(chooseOption == 1){
                for(Exam theExam : listOfExams){
                    if(theExam.className.equals(theClass)){
                        System.out.println(" -> " + theExam.examName);
                    }
                }
                while (true){
                    Exam exam = new Exam();
                    System.out.println("Please choose an option :\n1: Participate in Exam\n2: Back");
                    chooseOption = scanner.nextInt();
                    scanner.nextLine();
                    if(chooseOption == 1){
                        System.out.println("Please enter the Exams name :");
                        String theExamName = scanner.nextLine();
                        for(Exam newExam : listOfExams){
                            if(newExam.examName.equals(theExamName)){
                                exam = newExam;
                                break;
                            }
                        }
                        System.out.println(exam.examName + " -> " + exam.timeDuration + " Hours " + " <" + exam.numberOfQuestions + " Questions>");
                        examQuestions(exam, student);
                    }else if(chooseOption == 2){
                        break;
                    }else{
                        System.out.println("Invalid Option !\n\n");
                    }
                }
            }else if(chooseOption == 2){
                System.out.println("Please Enter the Exams name :");
                String theExam = scanner.nextLine();
                for(int i = 0; i< studentNumberExamNameGrade.size(); i++){
                    if(studentNumberExamNameGrade.get(i).equals(student.studentNumber) && studentNumberExamNameGrade.get(i+1).equals(theExam)){
                        System.out.println("Your Grade is -> " + studentNumberExamNameGrade.get(i+2) + " \n");
                        break;
                    }
                }
            }else if(chooseOption == 3){
                break;
            }else{
                System.out.println("Invalid Option !\n\n");
            }
        }
    }

    public static void examQuestions(Exam exam, Student student){
        Scanner scanner = new Scanner(System.in);
        Random rand = new Random();
        ArrayList<Integer> numbers = new ArrayList<Integer>();
        while(!(numbers.size() == exam.numberOfQuestions)){
            int randomNumber = rand.nextInt(Class.classQuestionBank.size());
            if(!numbers.contains(randomNumber) && randomNumber%2 != 0){
                numbers.add(randomNumber);
            }
        }
        examNameStudentNumberQuestionsAnswers.add(exam.examName);
        examNameStudentNumberQuestionsAnswers.add(student.studentNumber);
        for(Integer num : numbers){
            String theQuestion = Class.classQuestionBank.get(num);
            System.out.println(" -> " + theQuestion);
            examNameStudentNumberQuestionsAnswers.add(" -> " + theQuestion);
            String theAnswer = scanner.nextLine();
            examNameStudentNumberQuestionsAnswers.add(theAnswer);
        }
        numbers.clear();
    }

}