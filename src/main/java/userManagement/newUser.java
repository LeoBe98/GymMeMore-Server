package userManagement;

import database.Database;

import java.sql.Connection;
import java.sql.PreparedStatement;
import utility.BCrypt;

public class newUser {

    private static int workload = 12;

    public static boolean addUser(String email, String name, String lastname, String birthDate, String password, int type) {

        String salt = BCrypt.gensalt(workload);
        String hashedPassword = BCrypt.hashpw(password, salt);
        Connection connection = Database.getDbConnection();
        PreparedStatement statement;
        try {
            String sql = "INSERT INTO public.users(id, email, name, lastname, password, birthdate, type) VALUES (DEFAULT ,?,?,?,?,TO_TIMESTAMP(?, 'YYYY-MM-DD'),?);";
            statement = connection.prepareStatement(sql);

            statement.setString(1, email);
            statement.setString(2, name);
            statement.setString(3, lastname);
            statement.setString(4, hashedPassword);
            statement.setString(5, birthDate);
            statement.setInt(6, type);

            statement.executeUpdate();
            statement.close();
            connection.close();

            return true;

        } catch (Exception e) {
            e.printStackTrace();

            return false;
        }
    }

}

