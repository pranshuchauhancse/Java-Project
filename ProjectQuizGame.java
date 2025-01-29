import java.util.Scanner;
import java.util.Timer;
import java.util.TimerTask;

class Question {
    String question;
    String[] options;
    int correctOption;

    public Question(String question, String[] options, int correctOption) {
        this.question = question;
        this.options = options;
        this.correctOption = correctOption;
    }

    public void displayQuestion() {
        System.out.println("\n" + question);
        for (int i = 0; i < options.length; i++) {
            System.out.println((i + 1) + ". " + options[i]);
        }
        System.out.print("Your answer (1-4): ");
    }

    public boolean checkAnswer(int answer) {
        return answer == correctOption;
    }
}

public class ProjectQuizGame {
    private static int score = 0;
    private static int timeLimit = 10; // Time limit in seconds
    private static boolean answered = false;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Quiz Questions
        Question[] questions = {
                new Question("What is the capital of France?", new String[]{"Berlin", "Madrid", "Paris", "Rome"}, 3),
                new Question("Which programming language is used for Android development?", new String[]{"Python", "Java", "C++", "Swift"}, 2),
                new Question("Which data structure follows FIFO?", new String[]{"Stack", "Queue", "Heap", "Graph"}, 2),
                new Question("Who is the founder of Microsoft?", new String[]{"Steve Jobs", "Bill Gates", "Elon Musk", "Mark Zuckerberg"}, 2),
                new Question("What is 5 + 7?", new String[]{"10", "11", "12", "13"}, 3)
        };

        // Start Quiz
        for (Question q : questions) {
            answered = false;
            q.displayQuestion();

            Timer timer = new Timer();
            timer.schedule(new TimerTask() {
                public void run() {
                    if (!answered) {
                        System.out.println("\nTime's up! Moving to the next question...");
                        answered = true;
                    }
                }
            }, timeLimit * 1000);

            int userAnswer = scanner.nextInt();
            answered = true;
            timer.cancel();

            if (q.checkAnswer(userAnswer)) {
                System.out.println("Correct!");
                score++;
            } else {
                System.out.println("Wrong! The correct answer was: " + q.correctOption);
            }
        }

        // Display Final Result
        System.out.println("\nQuiz Over! Your final score: " + score + "/" + questions.length);
        scanner.close();
    }
}
