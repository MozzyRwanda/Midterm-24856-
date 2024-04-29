<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>Sign Up</title>
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

  .signin-link {
    margin-top: 20px;
    font-size: 14px;
  }

</style>
</head> 
<body>

<div class="container">
  <h2>Sign Up</h2>
  <form action="register" method="post" id="signup-form">
    
    <br>
    <input type="text" name="email" placeholder="Enter your Email">
    <br>
    <input type="password" name="pass" placeholder="Password">
    <br>
    <input type="password" name="conpassword" placeholder="Re-type Password">
    <br>
    <select name="role">
      <option value="" disabled selected name="role">Select Role</option>
      <option value="Admin">Admin</option>
      <option value="Student">Student</option>
      <option value="Teacher">Teacher</option>
    </select>
    <br>
    <button type="submit" name="submitAction" value="create">Create Account</button>
  </form>
  <div class="signin-link">
    <span>Already have an account? </span>
    <a href="login.jsp" onclick="showSignin()">Sign In</a>
  </div>
</div>

<script>
  function showSignin() {
    // Redirect to sign in page or toggle display
    // Example: window.location.href = 'signin.html';
  }
</script>
 <script type="text/javascript">
        var status = document.getElementById("status").value;
        if(status == "success"){
        swal("well done","Account Created Successfully","sucess")	
        }
        
        </script>

</body>
</html>
