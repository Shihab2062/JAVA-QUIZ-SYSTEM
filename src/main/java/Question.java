import org.json.simple.JSONObject;

public class Question {
    String question, opt1, opt2, opt3, opt4;
    int answer;

    public Question(String q, String o1, String o2, String o3, String o4, int ans) {
        this.question = q;
        this.opt1 = o1; this.opt2 = o2; this.opt3 = o3; this.opt4 = o4;
        this.answer = ans;
    }

    // Convert Object to JSON format for saving
    public JSONObject toJSONObject() {
        JSONObject obj = new JSONObject();
        obj.put("question", question);
        obj.put("option 1", opt1);
        obj.put("option 2", opt2);
        obj.put("option 3", opt3);
        obj.put("option 4", opt4);
        obj.put("answerkey", answer);
        return obj;
    }
}
