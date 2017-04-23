<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%--
  Created by IntelliJ IDEA.
  User: Reha Kılıç
  Date: 16.4.2017
  Time: 00:21
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<title>${headerMessage}</title>
<form:errors path="testObjectM.*"/>
<form action="/submitform" method="post">
    <table>
        <tr>
            <td>test form name:</td>
            <td> <input type="text" name="testname"></td>
        </tr>
        <tr>
            <td>test form item:</td>
            <td> <input type="text" name="testitem"></td>
        </tr>
        <tr>
            <td>test form mobile:</td>
            <td> <input type="text" name="mobile"></td>
        </tr>
        <tr>
            <td>test form dob:</td>
            <td> <input type="text" name="dob"></td>
        </tr>
        <tr>
            <td>test form skills:</td>
            <td>
                <select name="skills" multiple>
                <option value="java">Java</option>
                <option value="php">Php</option>
                <option value="c">C</option>
                 </select>
            </td>
        </tr>
    </table>
<input type="submit" value="click to submit">
</form>
</body>
</html>
