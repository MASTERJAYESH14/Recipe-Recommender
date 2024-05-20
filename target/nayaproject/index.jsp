<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />
    <link
            rel="stylesheet"
            href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.4.2/css/all.min.css"
    />
    <link rel="stylesheet" href="style.css" />
    <title>KHANA KHAJANA</title>
</head>

<body background="background.png"></body>

<body>
<header>
    <div class="logo">
        <p>KHANA KHAJANA</p>
    </div>
    <nav>
        <ul>
            <li><a href="#">Top recipe</a></li>
            <li><a href="#">Ez recipe</a></li>
            <li><a href="#">New recipe</a></li>
        </ul>
    </nav>
</header>

<div class="container" id="container">
    <div class="form-container sign-up">
        <form action="SignUpServlet" method="post">
            <h1>Create Account</h1>
            <div class="social-icons">
                <a href="" class="icon"
                ><i class="fa-brands fa-google-plus-g"></i
                ></a>
                <a href="" class="icon"><i class="fa-brands fa-facebook-f"></i></a>
                <a href="" class="icon"><i class="fa-brands fa-github"></i></a>
                <a href="" class="icon"
                ><i class="fa-brands fa-linkedin-in"></i
                ></a>
            </div>
            <span>or use your email for registration</span>
            <label>
                <input type="text" placeholder="Name" name="name" />
            </label>
            <label>
                <input type="email" placeholder="Email" name="email" />
            </label>
            <label>
                <input type="password" placeholder="Password" name="password" />
            </label>
            <button type="submit">Sign Up</button>
        </form>
    </div>
    <div class="form-container sign-in">
        <form action="LoginServlet" method="post">
            <h1>Sign In</h1>
            <div class="social-icons">
                <a href="https://github.com/CPT-Dawn/Khana-Khajana" class="icon"
                ><i class="fa-brands fa-google-plus-g"></i
                ></a>
                <a href="https://github.com/CPT-Dawn/Khana-Khajana" class="icon"><i class="fa-brands fa-facebook-f"></i></a>
                <a href="https://github.com/CPT-Dawn/Khana-Khajana" class="icon"><i class="fa-brands fa-github"></i></a>
                <a href="https://github.com/CPT-Dawn/Khana-Khajana" class="icon"
                ><i class="fa-brands fa-linkedin-in"></i
                ></a>
            </div>
            <span>or use your email & password</span>
            <label>
                <input type="email" placeholder="Email" name="email" />
            </label>
            <label>
                <input type="password" placeholder="Password" name="password" />
            </label>
            <a href="#">Forget Your Password?</a>
            <button type="submit">Sign In</button>
        </form>
    </div>
    <div class="toggle-container">
        <div class="toggle">
            <div class="toggle-panel toggle-left">
                <h1>Already Signed Up?</h1>
                <p>Great login back now to browse today's recipe!</p>
                <button class="hidden" id="login">Sign In</button>
            </div>
            <div class="toggle-panel toggle-right">
                <h1>New?</h1>
                <p>Create a new account now to start browsing the recipes!</p>
                <button class="hidden" id="register">Sign Up</button>
            </div>
        </div>
    </div>
</div>

<script src="script.js"></script>
</body>
</html>