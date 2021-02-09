<%-- 
    Document   : editnote
    Created on : 9-Feb-2021, 9:50:45 AM
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
        <h3>Edit Note</h3>
        <form method="post" action="note">
        <b>Title: </b> <input type="text" name="title" value="${note.getTitle()}">
        <br>
        <b>Contents: </b> <textarea name="content">${note.getContent()}</textarea>
        <br><input type="submit" value="Say Hello!">
        </form>
    </body>
</html>
