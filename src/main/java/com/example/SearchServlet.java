package com.example;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;

public class SearchServlet extends HttpServlet {
    Connection connection;
    PreparedStatement statement;

    public void init() throws ServletException {
        // Initialize database connection
        try {
            Class.forName("com.mysql.jdbc.Driver");
            String url = "jdbc:mysql://localhost:3306/ingredients";
            String user = "root";
            String password = "141204";
            this.connection = DriverManager.getConnection(url, user, password);
            this.statement = connection.prepareStatement("SELECT * FROM ingredientsdataset WHERE `Cleaned-Ingredients` LIKE ? LIMIT 30");
            System.out.println("Connection successful");
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
    }

    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        // Retrieve user input (ingredients) from the form
        String ingredientsInput = request.getParameter("ingredients");
        String[] ingredientsArray = ingredientsInput.split(",\\s*"); // Split input by comma and optional whitespace

        try {
            // Create the initial part of the SQL query
            StringBuilder queryBuilder = new StringBuilder("SELECT * FROM ingredientsdataset WHERE ");
            // Add a dynamic condition for each ingredient using LIKE
            for (int i = 0; i < ingredientsArray.length; i++) {
                queryBuilder.append("`Cleaned-Ingredients` LIKE ?");
                if (i < ingredientsArray.length - 1) {
                    queryBuilder.append(" AND ");
                }
            }

            // Initialize the prepared statement with the dynamically built query
            statement = connection.prepareStatement(queryBuilder.toString());

            // Set the ingredient parameters for the prepared statement
            for (int i = 0; i < ingredientsArray.length; i++) {
                statement.setString(i + 1, "%" + ingredientsArray[i] + "%");
            }

            // Execute the query to retrieve dishes matching any of the provided ingredients
            ResultSet resultSet = statement.executeQuery();

            // Process the ResultSet and generate HTML output as before
            PrintWriter out = response.getWriter();
            out.println("<html><body>");
            out.println("<h2>Dishes matching your ingredients:</h2>");
            boolean hasResults = false; // Flag to track if any results are found
            while (resultSet.next()) {
                hasResults = true; // Set flag to true since at least one result was found
                // Display the details of each dish
                String dishName = resultSet.getString("Recipe Name");
                String dishIngredients = resultSet.getString("Cleaned-Ingredients");
                String dishUrl = resultSet.getString("URL");
                String dishTimeTaken = resultSet.getString("Total Time In Mins");
                out.println("<div class='recipe-box'>");
                out.println("<h3>Dish Name: " + dishName + "</h3>");
                out.println("<p><strong>Ingredients:</strong> " + dishIngredients + "</p>");
                out.println("<p><strong>URL:</strong> <a href='" + dishUrl + "'>" + dishUrl + "</a></p>");
                out.println("<p><strong>Time taken:</strong> " + dishTimeTaken + " mins</p>");
                out.println("</div>");
            }
            if (!hasResults) {
                out.println("<p>No dishes found matching your ingredients.</p>");
            }
            out.println("</body></html>");
        } catch (SQLException e) {
            e.printStackTrace();
            throw new ServletException("Error executing SQL statement.", e);
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

