package parser;

import entity.user.Users;

import java.io.File;

public interface IUserParser {
    Users getUsers(File file, Class c);
    void saveUser(File file, Users users);
}
