package service;

import java.sql.Connection;

import dao.UserDAO;
import entite.User;

public class UserService {
    //==============================================================================
    public static void inscription(Connection connection, User user) throws Exception {
        UserDAO.insert(connection, user);
    }

    //==============================================================================
    public static User connection(Connection connection, User user) throws Exception {
        User user2 = null;

        User userTest = UserDAO.selectParEmailMdp(connection, user);
        if (userTest != null) {
            user2 = userTest;
        }

        return user2;
    }
}
