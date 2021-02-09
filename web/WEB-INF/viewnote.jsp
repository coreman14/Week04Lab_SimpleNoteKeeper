<%-- 
    Document   : viewnote
    Created on : 9-Feb-2021, 9:50:20 AM
    Author     : rcgam
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Simple Note Keeper</h1>

        <h3>View Note</h3>
        <p><b>Title: </b> ${note.getTitle()}</p>
        <p><b>Contents:<br></b>${note.getContent().replaceAll("\\n", "<br>")}</p>
        <a href="note?edit">Edit</a>
    </body>
</html>
