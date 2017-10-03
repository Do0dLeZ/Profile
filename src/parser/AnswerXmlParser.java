package parser;

import entity.answer.Answers;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import java.io.File;

public class AnswerXmlParser implements IAnswerParser {
    @Override
    public Answers getAnswers(File file, Class c) {
        try {
            JAXBContext context = JAXBContext.newInstance(c);
            Unmarshaller unmarshaller = context.createUnmarshaller();
            return (Answers) unmarshaller.unmarshal(file);
        } catch (JAXBException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public void addAnswers(File file, Answers answers) {
        try {
            JAXBContext context = JAXBContext.newInstance(answers.getClass());
            Marshaller marshaller = context.createMarshaller();
            marshaller.marshal(answers, file);
        } catch (JAXBException e) {
            e.printStackTrace();
        }
    }
}
