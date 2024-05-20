document.addEventListener('DOMContentLoaded', function () {
    // Sample JSON data received from servlet
    const jsonData = `{"recipeBoxesHtml": ${json_data_here}}`; // Replace json_data_here with your actual JSON data

    // Parse JSON data
    const recipes = JSON.parse(jsonData).recipeBoxesHtml;

    // Get the container where recipe boxes will be appended
    const container = document.querySelector('.container');

    // Create recipe boxes dynamically
    recipes.forEach(recipe => {
        const recipeBox = document.createElement('div');
        recipeBox.classList.add('recipe-box');

        const heading = document.createElement('h2');
        heading.textContent = recipe.dishName; // Change 'name' to 'dishName' based on your JSON structure

        const ingredients = document.createElement('p');
        ingredients.innerHTML = `<strong>Ingredients:</strong> ${recipe.dishIngredients}`; // Change 'ingredients' to 'dishIngredients'

        const url = document.createElement('p');
        url.innerHTML = `<strong>URL:</strong> <a href="${recipe.dishUrl}">${recipe.dishUrl}</a>`; // Change 'url' to 'dishUrl'

        const timeTaken = document.createElement('p');
        timeTaken.innerHTML = `<strong>Time Taken:</strong> ${recipe.dishtimetaken} mins`; // Change 'timeTaken' to 'dishtimetaken'

        recipeBox.appendChild(heading);
        recipeBox.appendChild(ingredients);
        recipeBox.appendChild(url);
        recipeBox.appendChild(timeTaken);

        container.appendChild(recipeBox);
    });
});
