<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="java.sql.*, java.util.*" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Attendance Page</title>
    <style>
        body {
            background-color:#96DED1;
            margin:0;
            font-family: Arial, sans-serif;
        }

        /* Navbar */
        ul {
            list-style-type: none;
            margin: 0;
            padding: 0;
            overflow: hidden;
            background-color: white;
        }
        li {
            float: right;
        }
        li a {
            display: block;
            color: purple;
            font-weight: bold;
            text-align: center;
            font-size: 20px;
            padding: 20px 22px;
            text-decoration: none;
        }
        li a:hover {
            background-color: grey;
            color: white;
        }

        /* Layout */
        .parent {
            width: 90%;
            margin: auto;
            padding: 2rem;
            text-align: center;
        }
        .c {
            display: inline-block;
            height: 300px;
            width: 600px;
            margin-top: 50px;
            background-image: url("AttendanceImages.jpg");
            background-size: cover;
            background-position: center;
            float: left;
            border-radius: 10px;
        }
        .child1 {
            display: inline-block;
            padding: 2rem;
            width: 500px;
            background: #fff;
            border-radius: 10px;
            box-shadow:0 0 10px rgba(0,0,0,0.2);
            float: right;
            text-align: left;
        }

        /* Form */
        form {
            font-size: 18px;
        }
        label {
            display: block;
            margin: 15px 0 5px;
            font-weight: bold;
        }
        input[type="text"] {
            width: 100%;
            padding: 10px;
            font-size: 16px;
            border: 1px solid #ccc;
            border-radius: 5px;
        }
        input[type="submit"] {
            margin-top: 20px;
            padding: 12px 20px;
            font-size: 18px;
            border: none;
            border-radius: 5px;
            background-color: purple;
            color: white;
            cursor: pointer;
        }
        input[type="submit"]:hover {
            background-color: grey;
        }

        /* Result */
        .result {
            margin-top: 20px;
            font-size: 18px;
            color: darkblue;
        }
    </style>
</head>
<body>

<!-- Navbar -->
<nav class="navbar">
    <ul>
        <li><a href="FeedBack.html">FeedBack</a></li>
        <li><a href="Contact.html">Contact</a></li>
        <li><a href="Registration.html">Register</a></li>
        <li><a href="About.html">About</a></li>
        <li><a href="Home1.html">Home</a></li>
    </ul>
</nav>

<!-- Content -->
<div class="parent">
    <div class="c"></div>

    <div class="child1">
        <h2>Mark Attendance</h2>
        <form action="Attend.jsp" method="post">
            <label for="name">Prachi</label>
            <input type="text" name="name" placeholder="yes / no">

            <label for="name1">Tej</label>
            <input type="text" name="name1" placeholder="yes / no">

            <label for="name2">Sagarika</label>
            <input type="text" name="name2" placeholder="yes / no">

            <input type="submit" value="Submit">
        </form>

        <div class="result">
        <%
            try {
                String n = request.getParameter("name");
                String n1 = request.getParameter("name1");
                String n2 = request.getParameter("name2");

                if(n != null) {
                    if(n.equalsIgnoreCase("yes"))
                        out.print("<p>Prachi is <b>Present</b></p>");
                    else if(n.equalsIgnoreCase("no"))
                        out.print("<p>Prachi is <b>Absent</b></p>");
                }

                if(n1 != null) {
                    if(n1.equalsIgnoreCase("yes"))
                        out.print("<p>Tej is <b>Present</b></p>");
                    else if(n1.equalsIgnoreCase("no"))
                        out.print("<p>Tej is <b>Absent</b></p>");
                }

                if(n2 != null) {
                    if(n2.equalsIgnoreCase("yes"))
                        out.print("<p>Sagarika is <b>Present</b></p>");
                    else if(n2.equalsIgnoreCase("no"))
                        out.print("<p>Sagarika is <b>Absent</b></p>");
                }
            } catch(Exception e) {
                out.println("<p style='color:red'>Error: " + e.getMessage() + "</p>");
            }
        %>
        </div>
    </div>
</div>

</body>
</html>
