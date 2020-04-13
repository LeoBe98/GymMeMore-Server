package userManagement;


import database.Database;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import datatype.dto.UserDto;
import utility.BCrypt;


public class Login {

    protected static UserDto getUser(String userEmail){
        UserDto user=null;
        Connection connection = Database.getDbConnection();
        PreparedStatement statement;
        String sql = "SELECT * FROM public.users WHERE email=?";
        ResultSet resultSet;

        try {
            statement = connection.prepareStatement(sql);
            statement.setString(1, userEmail);

            resultSet= statement.executeQuery(sql);

            while(resultSet.next()){

                int id = resultSet.getInt("id");
                String email = resultSet.getString("email");
                String name = resultSet.getString("name");
                String lastName = resultSet.getString("lastname");
                String birthDate = resultSet.getString("birthdate");
                String hashedPassword = resultSet.getString("password");
                int type = resultSet.getInt("type");

                user = new UserDto(id,email,name,lastName, hashedPassword, birthDate,type);


            }

            statement.close();
            connection.close();

            return user;


        } catch (Exception e) {
            e.printStackTrace();

        }

        return user;

    }


    protected static boolean checkPassword (String password, String hashedPassword){
        return BCrypt.checkpw(password,hashedPassword);
    }


    public static ArrayList<Object> login (String email, String password){

        ArrayList<Object> result = null;

        UserDto user =getUser(email);

        if(result!=null){

            if(checkPassword(password,((UserDto) result).getHashedPassword())
                return result;
        }

            return result;

        }


    }

