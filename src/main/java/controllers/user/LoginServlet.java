package controllers.user;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

import com.google.gson.*;
import datatype.dto.UserDto;
import userManagement.Login;

@WebServlet("/user/login")

public class LoginServlet extends HttpServlet {

    private final long serialVersionUID = 1L;

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {


        String email = request.getParameter("email");
        String password = request.getParameter("password");

        JsonObject jsonResult = new JsonObject();
        try {
            jsonResult = Login.login(email, password);

            if (jsonResult.get("state").getAsInt() == 1) {
                jsonResult.remove("state");
                response.setStatus(200);
                System.out.println("Login effettuato correttamente!");
                PrintWriter out = response.getWriter();
                out.print(jsonResult);
                return;

            } else if (jsonResult.get("state").getAsInt() == 0) {
                response.setStatus(404);
                System.out.println("Utente non trovato!");
                return;

            } else if (jsonResult.get("state").getAsInt() == 2) {
                response.setStatus(401);
                System.out.println("Password errata!");
                return;
            }
        } catch (Exception e) {
            System.out.println(e);
            response.setStatus(500);
            System.out.println("Errore nell'effettuare il login!");
            return;
        }
    }
}