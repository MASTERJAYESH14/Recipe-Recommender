// script.js
document.addEventListener("DOMContentLoaded", function() {
    const ingredientForm = document.getElementById("ingredientForm");
    const recipeResults = document.getElementById("recipeResults");
    const recipeList = document.getElementById("recipeList");

    ingredientForm.addEventListener("submit", function(event) {
        event.preventDefault();
        const ingredients = document.getElementById("ingredients").value.trim();
        if (ingredients) {
            fetchRecipes(ingredients);
        }
    });

    function fetchRecipes(ingredients) {
        // Here you would make an AJAX request to your backend to fetch recipe recommendations
        // For example:
        // fetch("/api/recipes?ingredients=" + encodeURIComponent(ingredients))
        //     .then(response => response.json())
        //     .then(data => displayRecipes(data))
        //     .catch(error => console.error("Error fetching recipes:", error));
        // For demonstration purposes, we'll just simulate some data:
        const recipes = ["Recipe 1", "Recipe 2", "Recipe 3"];
        displayRecipes(recipes);
    }

    function displayRecipes(recipes) {
        recipeList.innerHTML = "";
        recipes.forEach(recipe => {
            const li = document.createElement("li");
            li.textContent = recipe;
            recipeList.appendChild(li);
        });
        recipeResults.classList.remove("hidden");
    }
});
