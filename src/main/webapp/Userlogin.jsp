<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>LOGIN</title>
<style>
  body {
    font-family: Arial, sans-serif;
    background-color: #f4f4f4;
    margin: 0;
    padding: 0;
    display: flex;
    justify-content: center;
    align-items: center;
    height: 100vh;
  }
  
  .container {
    background-color: #fff;
    padding: 40px;
    border-radius: 8px;
    box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);
    text-align: center;
    max-width: 400px;
    width: 100%;
  }

  h2 {
    margin-bottom: 20px;
  }

  input[type="text"],
  input[type="password"] {
    width: calc(100% - 20px);
    padding: 10px;
    margin: 8px 0;
    border: 1px solid #ccc;
    border-radius: 4px;
    box-sizing: border-box;
  }

  button {
    background-color: #4caf50;
    color: white;
    padding: 14px 20px;
    margin: 8px 0;
    border: none;
    border-radius: 4px;
    cursor: pointer;
    width: 100%;
  }

  button:hover {
    background-color: #45a049;
  }

  .signup-link, .signin-link {
    margin-top: 20px;
    font-size: 14px;
  }

</style>
</head>
<body>

<div class="container">
  <h2>Welcome! Please enter your details.</h2>
  <form action="#" method="post" id="signin-form">
    <input type="text" id="email" name="email" placeholder="Email">
    <br>
    <input type="password" id="password" name="password" placeholder="Password">
    <br>
    <select id="role" name="role">
      <option value="" disabled selected>Select Role</option>
      <option value="Admin">Admin</option>
      <option value="Student">Student</option>
      <option value="Teacher">Teacher</option>
    </select>
    <br>
    <button type="submit"><a href="home.html">sign in</a></button>
  </form>
  <div class="signup-link">
    <span>Don't have an account? </span>
    <a href="#" onclick="showSignup()">Sign Up</a>
  </div>

  <div class="signup-form" style="display: none;">
    <h2>Sign Up</h2>
    <form action="#" method="post" id="signup-form">
      <input type="text" id="id" name="id" placeholder="Enter your ID">
      <br>
      <input type="text" id="email" name="email" placeholder="Enter your Email">
      <br>
      <input type="password" id="password" name="password" placeholder="Password">
      <br>
      <input type="password" id="confirm_password" name="confirm_password" placeholder="Re-type Password">
      <br>
      <button type="submit">Create Account</button>
    </form>
    <div class="signin-link">
      <span>Already have an account? </span>
      <a href="#" onclick="showSignin()">Sign In</a>
    </div>
  </div>
</div>

<script>
  function showSignup() {
    document.getElementById('signin-form').style.display = 'none';
    document.querySelector('.signup-form').style.display = 'block';
  }

  function showSignin() {
    document.getElementById('signin-form').style.display = 'block';
    document.querySelector('.signup-form').style.display = 'none';
  }
</script>

</body>
</html>
