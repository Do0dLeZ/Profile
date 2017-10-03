package entity.question;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.ArrayList;

@XmlRootElement(name = "questions")
public class Questions{

    @XmlElement(name = "question")
    private ArrayList<Question> questions = new ArrayList<>();

    public ArrayList<Question> getQuestions() {
        return questions;
    }
}