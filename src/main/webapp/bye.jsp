<%@ page contentType="text/html; charset=UTF-8" language="java" %>

<%@ page import="java.time.LocalDate"%>
<%
  String name = request.getParameter("name");
  int age =Integer.parseInt(request.getParameter("age"));
  int year = LocalDate.now().getYear();
  int birthYear= year - age + 1;
%>

<!DOCTYPE html>
<html lang="en">
<head>
  <meta charset="UTF-8">
  <meta http-equiv="X-UA-Compatible" content="IE=edge">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <title>Document</title>
</head>
<body>
  <h1><%=name%>님은 <%=birthYear%>년생입니다</h1>
  <% for (int i=0;i<3;i++) { %>
    <h2>jsp 버전</h2>
  <% } %>

</body>
</html>