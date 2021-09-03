<%--
  Created by IntelliJ IDEA.
  User: razhaka
  Date: 7/14/2021
  Time: 10:26 AM
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
    <title>CarouselPage</title>
</head>
<body>
<template:page pageTitle="${pageTitle}">
   <cms:pageSlot position="customCarousel" var="feature">
        <cms:component component="${feature}" />
    </cms:pageSlot>
<div class="welcomeInfoParaSlotName">
    <cms:pageSlot position="welcomeInfoParaSlotName" var="feature">
        <cms:component component="${feature}" />
    </cms:pageSlot>
        <cms:pageSlot position="ManufractureDetailSlotName1" var="feature">
            <cms:component component="${feature}" />
        </cms:pageSlot>
        <cms:pageSlot position="CustomBannerSlotName5" var="feature">
            <cms:component component="${feature}" />
        </cms:pageSlot>
</template:page>

</body>
</html>
