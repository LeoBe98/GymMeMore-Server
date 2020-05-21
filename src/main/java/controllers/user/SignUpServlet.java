package controllers.user;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.sql.SQLIntegrityConstraintViolationException;

import userManagement.SignUp;

@WebServlet("/user/signup")

public class SignUpServlet extends HttpServlet {

    private static final long serialVersionUID = 1L;

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String name = request.getParameter("name");
        String lastName = request.getParameter("lastName");
        String email = request.getParameter("email");
        String password = request.getParameter("password");
        String birthDate = request.getParameter("birthDate");
        int type = Integer.parseInt(request.getParameter("type"));


        System.out.println(name +" "+ lastName +" " +email +" " + password + " " + birthDate+ " "+ type);

        int result= SignUp.addUser(email, name, lastName, birthDate, password, type);



        System.out.println("Result: " + result);

        if (result == 1) {

            response.setStatus(200);

            System.out.println("Utente inserito correttamente!");
            return;

        } else if (result == 2) {

            response.setStatus(500);
            System.out.println("Errore mell'inserimento di un nuovo utente!");
            return;

        } else if (result == 0) {

            response.setStatus(409);
            System.out.println("Esiste già un utente registrato con questa email!");
            return;

        }

    }
}
