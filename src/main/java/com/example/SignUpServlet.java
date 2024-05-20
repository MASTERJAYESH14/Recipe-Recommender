package com.example;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.*;

public class SignUpServlet extends HttpServlet {
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
            System.out.println("Connection successfull");
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
    }
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        // Retrieve user input from the form
        String name = request.getParameter("name");
        String email = request.getParameter("email");
        String password = request.getParameter("password");
        System.out.println("GOT THE PARAMETERS SUCCESSFULLY!");
        try {
            // Insert user data into the database
            PreparedStatement statement = connection.prepareStatement("INSERT INTO users  VALUES (?,?,?)");
            statement.setString(1, name);
            statement.setString(2,email);
            statement.setString(3,password);
            statement.executeUpdate();
            System.out.println("ADDED TO DATABASE SUCCESSGULLY!");
            response.sendRedirect("index.jsp");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public void destroy() {
        // Close database connection
        try {
            if (statement != null) {
                statement.close();
            }
            if (connection != null) {
                connection.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
