package session;

import entity.answer.AQuestion;
import entity.answer.Answer;
import entity.answer.Answers;
import entity.question.QAnswer;
import entity.question.Question;
import parser.AnswerXmlParser;
import parser.IAnswerParser;

import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;

public class AnswerContainer {

    private static final File FILE = new File("D:\\Programming\\SpringLessons\\anketa\\src\\answers.xml");
    private static Answers objectAnswers;
    private HashMap<String, ArrayList<AQuestion>> answers = new HashMap<>();

    public AnswerContainer() {
        IAnswerParser parser = new AnswerXmlParser();
        objectAnswers = parser.getAnswers(FILE, Answers.class);
        for (Answer answer : objectAnswers.getAnswers()) {
            this.answers.put(answer.getLogin(), answer.getQuestions());
        }
    }

    public String getAnswers(String userLogin){
        ArrayList<AQuestion> answers = this.answers.get(userLogin);
        String outputAnswers = "Your answers: <br/>";
        for (AQuestion question : answers) {
            Question q = QuestionContainer.getInstance().getQuestion(question.getId());
            outputAnswers += q.getQuestionValue() + ": ";
            for (QAnswer item : q.getQAnswers()) {
                if (item.getId() == Integer.parseInt(question.getValue())){
                    outputAnswers += item.getValue() + "<br/>";
                }
            }
        }
        return outputAnswers;
    }

    public void addAnswer(Answer answer){
        objectAnswers.getAnswers().add(answer);
        IAnswerParser parser = new AnswerXmlParser();
        parser.addAnswers(FILE, objectAnswers);
    }
}
