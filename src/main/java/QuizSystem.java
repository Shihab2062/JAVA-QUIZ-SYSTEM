import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.Collections;
import java.util.Scanner;

public class QuizSystem {
    private static final String USER_FILE = "./src/main/resources/users.json";
    private static final String QUIZ_FILE = "./src/main/resources/quiz.json";
    private static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        System.out.print("Enter your username: ");
        String username = sc.nextLine();
        System.out.print("Enter password: ");
        String password = sc.nextLine();

        JSONObject user = authenticate(username, password);

        if (user != null) {
            String role = (String) user.get("role");
            if (role.equals("admin")) {
                adminModule();
            } else {
                studentModule(username);
            }
        } else {
            System.out.println("Invalid credentials!");
        }
    }

    //Authentication Logic
    private static JSONObject authenticate(String username, String password) {
        try (FileReader reader = new FileReader(USER_FILE)) {
            JSONArray users = (JSONArray) new JSONParser().parse(reader);
            for (Object obj : users) {
                JSONObject u = (JSONObject) obj;
                if (u.get("username").equals(username) && u.get("password").equals(password)) {
                    return u;
                }
            }
        } catch (Exception e) { System.out.println("Error reading users: " + e.getMessage()); }
        return null;
    }

    // Admin Module
    private static void adminModule() {
        System.out.println("Welcome admin! Please create new questions in the question bank.");
        char choice;
        do {
            System.out.print("Input your question: ");
            String q = sc.nextLine();
            System.out.print("Input option 1: "); String o1 = sc.nextLine();
            System.out.print("Input option 2: "); String o2 = sc.nextLine();
            System.out.print("Input option 3: "); String o3 = sc.nextLine();
            System.out.print("Input option 4: "); String o4 = sc.nextLine();
            System.out.print("What is the answer key? ");
            int ans = Integer.parseInt(sc.nextLine());

            saveQuestion(new Question(q, o1, o2, o3, o4, ans));
            System.out.println("Saved successfully!");
            System.out.print("Do you want to add more questions? (s to start, q to quit): ");
            choice = sc.nextLine().toLowerCase().charAt(0);
        } while (choice != 'q');
    }

    private static void saveQuestion(Question q) {
        JSONArray list = new JSONArray();
        JSONParser parser = new JSONParser();
        try {
            File file = new File(QUIZ_FILE);
            if (file.exists() && file.length() != 0) {
                list = (JSONArray) parser.parse(new FileReader(QUIZ_FILE));
            }
            list.add(q.toJSONObject());
            FileWriter fw = new FileWriter(QUIZ_FILE);
            fw.write(list.toJSONString());
            fw.flush();
            fw.close();
        } catch (Exception e) { e.printStackTrace(); }
    }

    //Student Module
    private static void studentModule(String name) {
        System.out.println("Welcome " + name + " to the quiz! We will throw you 10 questions.");
        System.out.print("Are you ready? Press 's' to start: ");
        if (sc.nextLine().equalsIgnoreCase("s")) {
            startQuiz();
        }
    }

    private static void startQuiz() {
        try (FileReader reader = new FileReader(QUIZ_FILE)) {
            JSONArray allQuestions = (JSONArray) new JSONParser().parse(reader);
            Collections.shuffle(allQuestions);

            int score = 0;
            for (int i = 0; i < Math.min(10, allQuestions.size()); i++) {
                JSONObject q = (JSONObject) allQuestions.get(i);
                System.out.println("\n[Question " + (i + 1) + "] " + q.get("question"));
                System.out.println("1. " + q.get("option 1"));
                System.out.println("2. " + q.get("option 2"));
                System.out.println("3. " + q.get("option 3"));
                System.out.println("4. " + q.get("option 4"));
                System.out.print("Student: ");
                int choice = Integer.parseInt(sc.nextLine());

                if (choice == ((Long) q.get("answerkey")).intValue()) {
                    score++;
                }
            }
            displayResult(score);
        } catch (Exception e) { System.out.println("Error loading quiz."); }
    }

    private static void displayResult(int score) {
        if (score >= 8) System.out.println("Excellent! You got " + score + " out of 10");
        else if (score >= 5) System.out.println("Good. You got " + score + " out of 10");
        else if (score >= 3) System.out.println("Very poor! You got " + score + " out of 10");
        else System.out.println("Very sorry you failed. You got " + score + " out of 10");

        System.out.print("\nWould you like to start again? (s/q): ");
        if (sc.nextLine().equalsIgnoreCase("s")) startQuiz();
    }
}
