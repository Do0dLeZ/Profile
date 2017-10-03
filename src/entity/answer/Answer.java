package entity.answer;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlValue;
import java.util.ArrayList;

@XmlRootElement(name = "answer")
public class Answer {
    private String login;
    private ArrayList<AQuestion> questions = new ArrayList<>();

    public String getLogin() {
        return login;
    }

    @XmlAttribute
    public void setLogin(String login) {
        this.login = login;
    }

    public ArrayList<AQuestion> getQuestions() {
        return questions;
    }

    @XmlElement(name = "question")
    public void setQuestions(ArrayList<AQuestion> questions) {
        this.questions = questions;
    }
}
