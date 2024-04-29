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
  input[type="password"],
  select {
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

  .signup-link {
    margin-top: 20px;
    font-size: 14px;
  }

</style>
</head>
<body>

<div class="container">
  <h2>Welcome! Please enter your details.</h2>
  <form action="login" method="post" id="signin-form">
    <input type="text" name="email" placeholder="Email">
    <br>
    <input type="password" name="password" placeholder="Password">
    <br>
    
    <br>
    <button type="submit">Sign In</button>
    
  </form>
  <div class="signup-link">
    <span>Don't have an account? </span>
    <a href="Sign up.jsp" onclick="showSignup()">Sign Up</a>
  </div>
</div>

<script>
  function showSignup() {
    // Redirect to sign up page or toggle display
    // Example: window.location.href = 'signup.html';
  }
</script>
 <script type="text/javascript">
        var status = document.getElementById("status").value;
        if(status == "failed"){
        swal("sorry","Wrong Username or Password","failed")	
        }
        
        </script>
</body>
</html>
