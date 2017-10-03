package session;

import entity.question.Question;
import entity.question.Questions;
import parser.IQuestionParser;
import parser.QuestionXmlParser;

import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;

public class QuestionContainer {
    private static final String FILE_PATH = "D:\\Programming\\SpringLessons\\anketa\\src\\questions.xml";
    private static QuestionContainer ourInstance = new QuestionContainer();

    private static HashMap<Integer, Question> questionsMap;
    private static Questions questions;

    public static QuestionContainer getInstance() {
        return ourInstance;
    }

    private QuestionContainer() {
        IQuestionParser parser = new QuestionXmlParser();
        questions = parser.getQuestions(new File(FILE_PATH), Questions.class);
        questionsMap = new HashMap<>();
        for (Question question : questions.getQuestions()) {
            questionsMap.put(question.getId(), question);
        }
    }

    public Question getQuestion(int id){
        return questionsMap.get(id);
    }

    public ArrayList<Question> getQuestions() {
        return questions.getQuestions();
    }
}
