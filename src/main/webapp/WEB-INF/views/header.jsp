<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix = "fmt" uri = "http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html lang="pl">
<head>
    <meta charset="UTF-8"/>
    <meta name="viewport" content="width=device-width, initial-scale=1.0"/>
    <meta http-equiv="X-UA-Compatible" content="ie=edge"/>
    <title>Charity</title>

    <link rel="stylesheet" href="<c:url value="/resources/css/style.css"/>"/>

    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
    <script src="https://cdn.jsdelivr.net/jquery.validation/1.15.1/jquery.validate.min.js"></script>
    <script src="<c:url value="resources/js/validation.js"/>"></script>
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/2.1.1/jquery.min.js"></script>
    <script type="text/javascript">
    $(function() {
    $('#my_form').change(function(){
    var str = "First name: " + $( "#name" ).val() + "<br>Last name: " + $( "#surname" ).val() +"<br>";

    $('#check_before_submit').html( str );
    });
    });
    </script>
    <script type="text/javascript">
        $("#form").validate({
            rules: {
                quantity: {
                    required: true,
                    min: 3,
                    max: 10
                },
                categories: {
                    required: true
                },
                institution: {
                    required: true
                },
                zipcode: "required",
                pickUpDate: {
                    required: true,
                    future: true
                },
                pickUpTime: "required"
            },
            // Specify validation error messages
            messages: {
                quantity: {
                    required: "Proszę uzupełnić liczbę worków",
                    min: "Minimalna ilość worków wynosi 3",
                    max: "Maksymalna ilość worków wynosi 10"
                },
                categories: {
                    required: "Proszę uzupełnić przynajmniej jedną kategorię"
                },
                institution: {
                    required: "Proszę uzupełnić instytucję"
                },
                zipcode: "Podano niepoprawny kod pocztowy",
                pickUpDate: {
                    required: "Podano niepoprawną datę",
                    future: "Podana data nie jest w przyszłosci"
                },
                pickUpTime: "Proszę uzupełnić godzinę"
            },
        });
    </script>
</head>
<body>
<header>
    <nav class="container container--70">
        <ul class="nav--actions">
            <li><a href="<c:url value="/login"/>">Zaloguj</a></li>
            <li class="highlighted"><a href="<c:url value="/registration"/>">Załóż konto</a></li>
        </ul>

        <ul>
            <li><a href="#" class="btn btn--without-border active">Start</a></li>
            <li><a href="#" class="btn btn--without-border">O co chodzi?</a></li>
            <li><a href="#" class="btn btn--without-border">O nas</a></li>
            <li><a href="#" class="btn btn--without-border">Fundacje i organizacje</a></li>
            <li><a href="#" class="btn btn--without-border">Kontakt</a></li>
        </ul>
    </nav>