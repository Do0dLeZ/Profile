package parser;

import entity.answer.Answers;

import java.io.File;

public interface IAnswerParser {
    Answers getAnswers(File file, Class c);
    void addAnswers(File file, Answers answers);
}
