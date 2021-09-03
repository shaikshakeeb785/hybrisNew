<%--
  Created by IntelliJ IDEA.
  User: razhaka
  Date: 6/10/2021
  Time: 11:08 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="f" uri="http://www.springframework.org/tags/form" %>
<%@ page isELIgnored="false" %>
<%@ taglib prefix="template" tagdir="/WEB-INF/tags/responsive/template"%>
<%@ taglib prefix="cms" uri="http://hybris.com/tld/cmstags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
    <title>Register</title>
</head>
<body>
<template:page pageTitle="${pageTitle}">

<center>
    <div align="center">
        <h2>ADD MANUFACTURERDETAIL</h2>
        <div align="center">
            <%--@elvariable id="manufacturerDetails" type="org.nendrasys.storefront.model"--%>
            <%--<c:url value="/registerManufacturerDetailSave" var="manufacturerDetails"></c:url>--%>
            <f:form action="https://electronics.local:9002/Nendrasysstorefront/registerManufacturerDetailSave"
                    method="post" modelAttribute="manufacturerDetails">
                <f:label path="name">ManufacturerName:</f:label>
                <f:input path="name"/>
                ${error}
                <br>
                <f:label path="city">ManufacturerCity:</f:label>
                <f:input path="city"/>
                <br>
                <%--<f:label path="country">ManufacturerCountry:</f:label>
                <f:input path="country.isocode" />--%>
                <f:select path="country.isocode">
                    <c:choose>
                        <c:when test="${countryData != null}">
                            <c:forEach items="${countryData}" var="allCountry">

                                <f:option label="${allCountry.name}" value="${allCountry.isocode}"/>
                            </c:forEach>
                        </c:when>
                        <c:otherwise>
                            ${error}
                        </c:otherwise>
                    </c:choose>
                </f:select>
                <br>
                <f:button value="submit">Submit</f:button>
            </f:form>
        </div>
    </div>
</center>
</template:page>
</body>
</html>
