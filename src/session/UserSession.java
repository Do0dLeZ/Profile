package session;

import entity.user.User;
import entity.user.Users;
import parser.IUserParser;
import parser.UserXmlParser;

import java.io.File;
import java.util.concurrent.ConcurrentHashMap;

public class UserSession {
    private static UserSession session;

    private static File file = new File("D:\\Programming\\SpringLessons\\anketa\\src\\users.xml");
    private static final IUserParser parser = new UserXmlParser();

    private ConcurrentHashMap<String, User> usersMap;
    private Users users;
    private User user;

    public synchronized static UserSession getInstance() {
        if (session == null) {
            session = new UserSession();
            return session;
        }
        return session;
    }

    private UserSession() {
        users = parser.getUsers(file, Users.class);
        usersMap = new ConcurrentHashMap<>();
        for (User user : users.getUsers()) {
            usersMap.put(user.getLogin(), user);
        }
    }

    public User getUser(String login, String password){
        user = usersMap.get(login);
        if (user != null) {
            if (user.getPassword().equals(password) || password == null) {
                return user;
            } else return null;
        } else {
            user = new User(login, password);
            addUser(user);
            return user;
        }
    }

    public User getUser(){
        return user;
    }

    public void addUser(User user) {
        users.getUsers().add(user);
        saveUsers();
    }

    public void saveUsers(){
        parser.saveUser(file, users);
    }
}
