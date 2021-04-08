<%--
  Created by IntelliJ IDEA.
  User: stigm
  Date: 07.04.2021
  Time: 17:42
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Person</title>
</head>
<body>

<p>Користувач з ID - ${person.id}</p>
<p>Його звати ${person.name} і йому ${person.age}р.</p>
<p>Його серія паспорта ${passport.serialNumber}</p>
<p>Він їздить на: ${car.brand} ${car.model} ${car.graduation_year}</p>


</body>
</html>
