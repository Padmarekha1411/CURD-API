<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Students Registration</title>
    <link rel="stylesheet" href="css/registration.css">
</head>
<body>
    <div class="wrapper">
        <div class="form">
            <h1 class="title">Student Registration Form</h1>

            <form action="create" method="post" class="myform">
                <div class="control-from">
                    <label for="firstname">First Name *</label>
                    <input type="text" id="firstname" value="" name="first_name" required>
                </div>

                <div class="control-from">
                    <label for="lastname">Last Name *</label>
                    <input type="text" id="lastname" value="" name="last_name" required>
                </div>

                <div class="control-from">
                    <label for="emailaddress">Email *</label>
                    <input type="text" id="emailaddress" value="" name="email" required>
                </div>

                <div class="control-from">
                    <label for="phonenumber">Phone Number *</label>
                    <input type="phone" id="phonenumber" value="" name="phone_no" required>
                </div>

                <div class="full-width">
                    <label for="companyname">Address *</label>
                    <input type="text" id="companyname" value="" name="address" required>
                </div>

                <div class="button">
                    <button id="register">Register</button>
                </div>

            </form>
        </div>
    </div>
</body>
</html>