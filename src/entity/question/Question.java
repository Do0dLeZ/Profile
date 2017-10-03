package entity.question;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.ArrayList;

@XmlRootElement(name = "question")
public class Question {
    private int id;
    private String questionValue;

    @XmlElement(name = "answer")
    private ArrayList<QAnswer> QAnswers = new ArrayList<>();

    public int getId() {
        return id;
    }

    @XmlAttribute(name = "id")
    public void setId(int id) {
        this.id = id;
    }

    public String getQuestionValue() {
        return questionValue;
    }

    @XmlAttribute(name = "value")
    public void setQuestionValue(String questionValue) {
        this.questionValue = questionValue;
    }

    public ArrayList<QAnswer> getQAnswers() {
        return QAnswers;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Question question = (Question) o;

        return id == question.id;
    }

    @Override
    public int hashCode() {
        return id;
    }
}
