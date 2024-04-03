<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="UTF-8">
        <title>Message Encoder/Decoder</title>
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

        <% if (request.getAttribute("error") != null) {%>
        <br><br>
        <table border="1">
            <tr>
                <th>Error</th>
            </tr>
            <tr>
                <td><%= request.getAttribute("error")%></td>
            </tr>
        </table>
        <% }%>

    </body>
</html>
