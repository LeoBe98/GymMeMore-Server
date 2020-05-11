package datatype.dao;

import database.Database;
import datatype.dto.UserDto;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.PreparedStatement;

public class UserDao {

    public UserDto getUserById(int id_paziente) {
        UserDto user = null;
        Connection connection = Database.getDbConnection();
        ResultSet resultSet = null;
        try {
            String sql = "SELECT * FROM users WHERE id = ?;";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setInt(1, id_paziente);
            resultSet = statement.executeQuery();
            while (resultSet.next()) {

                int id = resultSet.getInt("id");
                String email = resultSet.getString("email");
                String name = resultSet.getString("name");
                String lastName = resultSet.getString("lastname");
                String password = resultSet.getString("password");
                String birthDate = resultSet.getString("birthdate");
                int type = resultSet.getInt("type");

                user = new UserDto(id, email, name, lastName, password, birthDate, type);

            }
            resultSet.close();
            statement.close();
            connection.close();
        } catch (Exception e) {
            e.printStackTrace();
        }

        return user;
    }


}
