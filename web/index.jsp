<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="UTF-8">
        <title>Message Encoder/Decoder</title>
        <style><%@include file="/WEB-INF/css/style.css"%></style>

    </head>
    <body>

        <h2>Message Encoder/Decoder</h2>

        <form action="MessageEncoderDecoder" method="post">
            <label for="option">Select an Option:</label>
            <select id="option" name="option">
                <option value="encode">Encode</option>
                <option value="decode">Decode</option>
            </select>
            <br><br>

            <label for="message">Message:</label>
            <input type="text" id="message" name="message" required>
            <br><br>

            <input type="submit" value="Submit">
        </form>

        <br><br>

        <% if (request.getAttribute("result") != null) {%>
        <table border="1">
            <tr>
                <th>Result</th>
            </tr>
            <tr>
                <td><%= request.getAttribute("result")%></td>
            </tr>
        </table>
        <% }%>
    </body>
</html>
