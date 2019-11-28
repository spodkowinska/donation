<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<jsp:include page="header.jsp"/>




<form:form method="post" modelAttribute="donation">
<%--Zaznacz co chcesz oddać--%>
<%--<form:checkboxes path="donation.categories" items="${categories}"/>--%>

<%--        <form:checkbox  path="${categories}" value="${category.name}"/>--%>


    Podaj liczbę 60l worków, w które zapakowałes/aś rzeczy:<br>

    <p>Liczba 60l worków: <form:input path="${quantity}" type="text"></form:input></p>
    <button value="Dalej"></button>
</form:form>

<%--<form:select path="institution" items="${institutions}"/>--%>
<%--<form:input path="zipCode" />--%>
<%--<form:input path="street" />--%>
<%--<form:input path="city"/>--%>
<%--<form:input path="quantity"/>--%>
<%--<form:textarea path="pickUpComment"/>--%>
<%--<form:input type="date" path="pickUpDate"/>--%>
<%--<form:input type="time" path="pickUpTime" />--%>



<jsp:include page="footer.jsp"/>