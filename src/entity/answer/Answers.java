package entity.answer;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.ArrayList;

@XmlRootElement(name = "answers")
public class Answers {
    @XmlElement(name = "answer")
    private ArrayList<Answer> answers = new ArrayList<>();

    public ArrayList<Answer> getAnswers() {
        return answers;
    }
}
