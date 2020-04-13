package controllers.user;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

import datatype.dto.UserDto;
import userManagement.Login;

@WebServlet("/user/login")

public class LoginServlet extends HttpServlet {

    private final long serialVersionUID = 1L;

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {


        String email = request.getParameter("email");
        String password = request.getParameter("password");

        UserDto result = Login.login(email, password);

        if (result!=null){

            response.setStatus(200);

            System.out.println("Login effettuato correttamente!");
            return;

        } else if(result==null) {

            response.setStatus(404);

            System.out.println("Errore nell'effetuare il login!");
            return;

        }

    }
}