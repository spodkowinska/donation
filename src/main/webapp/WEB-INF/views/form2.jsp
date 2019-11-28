<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<jsp:include page="header.jsp"/>


<form:form method="post" modelAttribute="donation">

    Podaj liczbę 60l worków, w które zapakowałes/aś rzeczy:<br>

    <p>Liczba 60l worków: <form:input path="${quantity}" type="text" ></form:input></p>
    <input type="submit" name="Dalej"/>
</form:form>



<jsp:include page="footer.jsp"/>