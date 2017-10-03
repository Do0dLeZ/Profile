package entity.user;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.ArrayList;

@SuppressWarnings("serial")
@XmlRootElement(name = "users")
public class Users {

    @XmlElement(name = "user")
    private static ArrayList<User> users = new ArrayList<>();

    public ArrayList<User> getUsers() {
        return users;
    }
}
