import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class QuizApplication {
    public static void main(String[] args) {
        
        List<QuizQuestion> questions = new ArrayList<>();
        questions.add(new QuizQuestion("What is the capital of France?", Arrays.asList("Berlin", "Paris", "Madrid", "Rome"), 1));
        questions.add(new QuizQuestion("Which planet is known as the Red Planet?", Arrays.asList("Venus", "Mars", "Jupiter", "Saturn"), 1));
        questions.add(new QuizQuestion("What is the largest mammal in the world?", Arrays.asList("Elephant", "Blue Whale", "Giraffe", "Hippopotamus"), 1));
        Quiz quiz = new Quiz(questions);
        quiz.startQuiz();
    }
}
