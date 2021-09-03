<%--
  Created by IntelliJ IDEA.
  User: razhaka
  Date: 6/4/2021
  Time: 4:28 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page isELIgnored="false" %>
<html>
<head>
    <title>list of manuafactureDetails</title>
</head>
<h1 style="color:Red"></h1>
<body style="background-image: url('https://study.com/cimages/videopreview/videopreview-full/dl4oegfq0k.jpg')" >
    <center><h2 style="color: white">List of ManufacturerDetail</h2>
    <table  cellpadding="8" cellspacing="8" border="4"style="background-image: url('data:image/png;base64,iVBORw0KGgoAAAANSUhEUgAAAOEAAADhCAMAAAAJbSJIAAAAA1BMVEX///+nxBvIAAAASElEQVR4nO3BgQAAAADDoPlTX+AIVQEAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAADwDcaiAAFXD1ujAAAAAElFTkSuQmCC')">
        <tr>
            <th>ManufacturerId</th><th>ManufacturerName</th><th>ManufacturerCity</th><th>ManufacturerCountryName</th>
        </tr>
        <c:if test="${list!=null}">
      <c:forEach var="object" items="${list}">

         <tr>
              <td>${object.id}</td><td>${object.name}</td><td>${object.city}</td><td> ${object.country.name}</td>
         </tr>

        </c:forEach>
        </c:if>
    </table>
        <a href="0" style="color: white">PageNo:0|</a>
        <a href="1" style="color: white">PageNo:1|</a>
        <a href="2" style="color: white">PageNo:2|</a>

    </center>

</body>
</html>
