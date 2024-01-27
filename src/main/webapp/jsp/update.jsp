<%@page import="com.example.StudentRegistration.bean.StudentDetails"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Update Data</title>
<link rel="stylesheet" href="css/registration.css">
</head>
<body>
 <div class="wrapper">
        <div class="form">
            <h1 class="title">Student Registration Form</h1>

            <form action="update" method="post" class="myform">
            <%StudentDetails s=(StudentDetails)session.getAttribute("students"); %>
            
             
                    <input type="hidden" id="firstname" value="<%=s.getID() %>" name="ID" required>
              
                
                <div class="control-from">
                    <label for="firstname">First Name *</label>
                    <input type="text" id="firstname" value="<%=s.getFirst_name() %>" name="first_name" required>
                </div>

                <div class="control-from">
                    <label for="lastname">Last Name *</label>
                    <input type="text" id="lastname" value="<%=s.getLast_name() %>" name="last_name" required>
                </div>

                <div class="control-from">
                    <label for="emailaddress">Email *</label>
                    <input type="text" id="emailaddress" value="<%=s.getEmail() %>" name="email" required>
                </div>

                <div class="control-from">
                    <label for="phonenumber">Phone Number *</label>
                    <input type="phone" id="phonenumber" value="<%=s.getPhone_no() %>" name="phone_no" required>
                </div>

                <div class="full-width">
                    <label for="companyname">Address *</label>
                    <input type="text" id="companyname" value="<%=s.getAddress() %>" name="address" required>
                </div>

                <div class="button">
                    <button id="index">Update</button>
                </div>

            </form>
        </div>
    </div>
</body>
</html>