import java.util.*;

class QuizQuestion {
    private String question;
    private List<String> options;
    private int correctOption;

    public QuizQuestion(String question, List<String> options, int correctOption) {
        this.question = question;
        this.options = options;
        this.correctOption = correctOption;
    }

    public String getQuestion() {
        return question;
    }

    public List<String> getOptions() {
        return options;
    }

    public int getCorrectOption() {
        return correctOption;
    }
}

class Quiz {
    private List<QuizQuestion> questions;
    private int score;

    public Quiz(List<QuizQuestion> questions) {
        this.questions = questions;
        this.score = 0;
    }

    public void startQuiz() {
        Scanner scanner = new Scanner(System.in);

        for (QuizQuestion question : questions) {
            displayQuestion(question);
            int userAnswer = getUserAnswer(scanner);

            if (userAnswer == question.getCorrectOption()) {
                System.out.println("Correct!\n");
                score++;
            } else {
                System.out.println("Incorrect. The correct answer is option " + (question.getCorrectOption() + 1) + ".\n");
            }
        }

        displayResult();
    }

    private void displayQuestion(QuizQuestion question) {
        System.out.println(question.getQuestion());
        List<String> options = question.getOptions();
        for (int i = 0; i < options.size(); i++) {
            System.out.println((i + 1) + ". " + options.get(i));
        }
    }

    private int getUserAnswer(Scanner scanner) {
        int userAnswer = -1;
        boolean validInput = false;

        while (!validInput) {
            System.out.print("Enter your answer (1-" + questions.get(0).getOptions().size() + "): ");
            if (scanner.hasNextInt()) {
                userAnswer = scanner.nextInt();
                if (userAnswer >= 1 && userAnswer <= questions.get(0).getOptions().size()) {
                    validInput = true;
                } else {
                    System.out.println("Invalid input. Please enter a number between 1 and " + questions.get(0).getOptions().size() + ".");
                }
            } else {
                System.out.println("Invalid input. Please enter a number.");
                scanner.next(); // Consume the invalid input
            }
        }

        return userAnswer - 1; // Adjust to 0-based index
    }

    private void displayResult() {
        System.out.println("Quiz completed!");
        System.out.println("Your Score: " + score + " out of " + questions.size());
    }
}



