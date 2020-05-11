package controllers.user;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

import userManagement.newUser;

@WebServlet("/user/newUser")

public class NewUserServlet extends HttpServlet {

    private static final long serialVersionUID = 1L;

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {


    String name = request.getParameter("name");
    String lastName = request.getParameter("lastName");
    String email = request.getParameter("email");
    String password = request.getParameter("password");
    String birthDate = request.getParameter("birthDate");
    int type = Integer.parseInt(request.getParameter("type"));


    Boolean result = newUser.addUser(email, name, lastName, birthDate, password, type);

        if (result==true){

    response.setStatus(200);

    System.out.println("Utente inserito correttamente!");
    return;

    } else if(result==false) {

    response.setStatus(500);

    System.out.println("Errore mell'inserimento di un nuovo utente!");
    return;

        }

    }
}
