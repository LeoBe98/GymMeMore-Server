package datatype.dao;

import database.Database;
import datatype.dto.UserDto;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class GymDao {

    public UserDto getGymById(int gym_id) {
        UserDto user = null;
        Connection connection = Database.getDbConnection();
        ResultSet resultSet = null;
        try {
            String sql = "SELECT * FROM gyms WHERE id = ?;";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setInt(1, gym_id);
            resultSet = statement.executeQuery();
            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String address = resultSet.getString("address");
                String name = resultSet.getString("name");
                String lastName = resultSet.getString("lastname");
                String email = resultSet.getString("email");
                String birthDate = resultSet.getString("birthdate");
                String hashedPassword = resultSet.getString("password");
                int type = resultSet.getInt("type");

                user = new UserDto(id, email, name, lastName, hashedPassword, birthDate, type);

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
