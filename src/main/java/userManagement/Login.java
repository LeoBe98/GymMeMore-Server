package userManagement;


import com.google.gson.JsonObject;
import database.Database;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import datatype.dto.UserDto;
import utility.BCrypt;

import javax.swing.plaf.nimbus.State;


public class Login {

    protected static UserDto getUser(String userEmail) {
        UserDto user = null;
        Connection connection = Database.getDbConnection();

        ResultSet resultSet;

        try {
            String sql = "SELECT * FROM public.users WHERE email='" + userEmail + "';";
            Statement statement = connection.createStatement();

            resultSet = statement.executeQuery(sql);

            while (resultSet.next()) {

                int id = resultSet.getInt("id");
                String email = resultSet.getString("email");
                String name = resultSet.getString("name");
                String lastName = resultSet.getString("lastname");
                String birthDate = resultSet.getString("birthdate");
                String hashedPassword = resultSet.getString("password");
                int type = resultSet.getInt("type");

                user = new UserDto(id, email, name, lastName, hashedPassword, birthDate, type);


            }
            statement.close();
            connection.close();

            return user;


        } catch (Exception e) {
            e.printStackTrace();

        }

        return user;

    }


    protected static boolean checkPassword(String password, String hashedPassword) {
        return BCrypt.checkpw(password, hashedPassword);
    }


    public static JsonObject login(String email, String password) {

        JsonObject jsonResult = new JsonObject();
        jsonResult.addProperty("state", 0);
        UserDto user = null;
        user = getUser(email);

        if (user != null) {
            System.out.println(user.getHashedPassword());
            System.out.println(password);

            if (checkPassword(password, user.getHashedPassword())) {
                jsonResult.addProperty("state", 1);
                jsonResult.addProperty("id", user.getId());
                jsonResult.addProperty("name", user.getName());
                jsonResult.addProperty("lastName", user.getLastname());
                jsonResult.addProperty("email", user.getEmail());
                jsonResult.addProperty("birthDate", user.getBirthDate());
                jsonResult.addProperty("type", user.getType());
                return jsonResult;
            } else {
                jsonResult.addProperty("state", 2);
                return jsonResult;
            }
        }
        return jsonResult;
    }


}

