package parser;

import entity.question.Questions;

import java.io.File;

public interface IQuestionParser {
    Questions getQuestions(File file, Class c);
}
