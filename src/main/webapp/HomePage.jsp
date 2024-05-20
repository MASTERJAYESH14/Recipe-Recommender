<!DOCTYPE html>
<html lang="en">
<head>
  <meta charset="UTF-8" />
  <meta name="viewport" content="width=device-width, initial-scale=1.0" />
  <link
          rel="stylesheet"
          href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.4.2/css/all.min.css"
  />
  <link rel="stylesheet" href="HomePage.css" />
  <link rel="stylesheet" href="results.css">
  <title>Khana Khajana</title>
</head>

<body background="HomePage.png"></body>

<body>
<header>
  <div class="logo">
    <p>Khana Khajana</p>
  </div>
  <nav>
    <ul>
      <li><a href="#">Top recipe</a></li>
      <li><a href="#">Ez recipe</a></li>
      <li><a href="#">Special recipe</a></li>
    </ul>
  </nav>
</header>

<div class="container">
  <form
          action="SearchServlet"
          method="post"
          class="search-bar"
  >
    <input
            type="ingredients"
            placeholder="Input the ingredients with a comma"
            name="ingredients"
    />
    <button type="submit"><img src="search.png" /></button>
  </form>
</div>
</body>
</html>