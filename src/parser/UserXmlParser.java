package parser;

import entity.user.Users;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import java.io.File;

public class UserXmlParser implements IUserParser {

    @Override
    public Users getUsers(File file, Class c) {
        try {
            JAXBContext context = JAXBContext.newInstance(c);
            Unmarshaller unmarshaller = context.createUnmarshaller();
            return (Users) unmarshaller.unmarshal(file);
        } catch (JAXBException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public void saveUser(File file, Users users) {
        try {
            JAXBContext context = JAXBContext.newInstance(users.getClass());
            Marshaller marshaller = context.createMarshaller();
            marshaller.marshal(users, file);
        } catch (JAXBException e) {
            e.printStackTrace();
        }
    }
}
