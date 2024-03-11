package edu.phoenix.dao;

import edu.phoenix.model.User;

import java.util.ArrayList;
import java.util.List;

public class Database {
    public static List<User> dataBase = new ArrayList<>();

    public static void addUser(String name, String login, String password) {
        dataBase.add(new User(name, login, password));
    }

    public static User getUser(String login, String password) {
        try {
            if (login.equals("")) {
                throw new Exception("Параметры не могут быть пустыми");
            }
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
        if (password.isEmpty()) {
            return dataBase.stream()
                    .filter(obj -> obj.getLogin().equals(login))
                    .findFirst()
                    .orElse(null);
        }
        return dataBase.stream()
                .filter(obj -> obj.getLogin().equals(login) &&
                        obj.getPassword().equals(password))
                .findFirst()
                .orElse(null);
    }

    public static void deleteUser(String login) {
        dataBase.remove(getUser(login, ""));
    }

    public static void updateUser(User user) {
        //? Как я должен находить пользователя, если непонятно, относительно какого пользователя должен происходить поиск?
        // #1
        // TODO: Переделать так, чтобы позиция в list-е осталась той же
        dataBase.indexOf(getUser(user.getLogin(), user.getPassword()));
        dataBase.set(1, user);
    }

}
