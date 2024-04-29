<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>User Management</title>
</head>
<body>
    <h1>User Management System</h1>
    <h2>Create User</h2>
    <form action="create_user.jsp" method="post">
        <label for="username">Username:</label>
        <input type="text" id="username" name="username" required><br><br>
        <label for="email">Email:</label>
        <input type="email" id="email" name="email" required><br><br>
        <label for="password">Password:</label>
        <input type="password" id="password" name="password" required><br><br>
        <input type="submit" value="Create User">
    </form>

    <h2>Update User</h2>
    <form action="update_user.jsp" method="post">
        <label for="userId">User ID:</label>
        <input type="text" id="userId" name="userId" required><br><br>
        <label for="newUsername">New Username:</label>
        <input type="text" id="newUsername" name="newUsername"><br><br>
        <label for="newEmail">New Email:</label>
        <input type="email" id="newEmail" name="newEmail"><br><br>
        <label for="newPassword">New Password:</label>
        <input type="password" id="newPassword" name="newPassword"><br><br>
        <input type="submit" value="Update User">
    </form>

    <h2>Delete User</h2>
    <form action="delete_user.jsp" method="post">
        <label for="deleteUserId">User ID:</label>
        <input type="text" id="deleteUserId" name="deleteUserId" required><br><br>
        <input type="submit" value="Delete User">
    </form>

    <h2>View All Users</h2>
    <form action="view_all_users.jsp" method="get">
        <input type="submit" value="View All Users">
    </form>
</body>
</html>
