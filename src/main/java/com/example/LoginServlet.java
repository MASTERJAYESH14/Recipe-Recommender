package com.example;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;

public class LoginServlet extends HttpServlet {
    Connection connection;
    PreparedStatement statement;

    public void init() throws ServletException {
        // Initialize database connection

        try {
            Class.forName("com.mysql.jdbc.Driver");
            String url = "jdbc:mysql://localhost:3306/clientid";
            String user = "root";
            String password = "141204";
            this.connection = DriverManager.getConnection(url, user, password);
            this.statement = connection.prepareStatement("SELECT password FROM users WHERE emailid = ?");
            System.out.println("Connection successfull");
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
    }

    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        // Retrieve user input from the form
        String email = request.getParameter("email");
        String password = request.getParameter("password");
        try {
            // Set the email parameter for the prepared statement
            statement.setString(1, email);

            // Execute the query to retrieve the password for the given email
            ResultSet resultSet = statement.executeQuery();

            if (resultSet.next()) {
                // Password found for the email ID
                String storedPassword = resultSet.getString("password");

                if (password.equals(storedPassword)) {
                    // Passwords match, login successful
                    response.sendRedirect("HomePage.jsp");

                } else {
                    // Passwords don't match, display error message
                    PrintWriter out = response.getWriter();
                    out.println("<html><body>");
                    out.println("<h2>PASSWORD INCORRECT! ENTER AGAIN PLEASE :)</h2>");

                }
            } else {
                PrintWriter out = response.getWriter();
                out.println("<html><body>");
                out.println("<h2>EMAIL ID NOT FOUND! KINDLY ENTER AGAIN OR SIGNUP</h2>");
            }
        } catch (SQLException e) {
            e.printStackTrace();
            throw new ServletException("Error executing SQL statement.", e);
        }
    }
}
