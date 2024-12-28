<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page import="java.util.Date"
         contentType="text/html;charset=UTF-8"
         session="false"
         isELIgnored="false" %>
<html>
    <head>
        <title>Clase de JSP y JSTL para los estudiantes de Cometa 7 (modulo 3)</title>
        <!-- Esta es la forma de insertar un comentario en HTML -->

    </head>
    <body>
        <%@ include file="encabezado.jsp"%>
        <h2>Hola queridos estudiantes de Codegym</h2>
        <h1>
            <%
                out.print("Esto es un ejemplo de una impresion con un Scriptlet de JSP </br>");
                for (int i = 1; i <= 10; i++) {
                    out.print(i);
            %>
            </br>
            <%
                }
            %>
        </h1>
        <h3>La hora y fecha actual es: <%= new Date() %></h3>
        <h3><%= Math.sqrt(105) %></h3>
        <p>Método HTTP utilizado para la solicitud: <%= request.getMethod() %></p>
        <!-- Un comentario en HTML no impide que el código de un scriptlet sea ejecutado
            <h2>Esto es un mensaje escrito en una etiqueta HTML
                <% out.print("(esto es adicional dentro de la etiqueta H2)"); %>
            </h2>
        -->
        <%-- Esto es un comentario JSP. Estos comentarios inhabilitan el código Java y HTML/CSS/JS
        <h4> Valor de PI: <%= Math.PI %><br/>
             Valor de E: <%= Math.E %>
        </h4>
        --%>
        <hr style="border: 1px solid black"/>
        <jsp:useBean id="estudiante"
                     class="javabeans.Estudiante"
                     scope="application"/>
        <jsp:setProperty name="estudiante" property="nombre" value="Karen Arellano"/>
        <jsp:setProperty name="estudiante" property="pais" value="Mexico"/>
        <jsp:setProperty name="estudiante" property="edad" value="31"/>
        <div>Nombre del estudiante: <jsp:getProperty name="estudiante" property="nombre"/></div>
        <div>Pais del estudiante: <jsp:getProperty name="estudiante" property="pais"/></div>
        <div>Edad del estudiante: <jsp:getProperty name="estudiante" property="edad"/></div>
        <hr style="border: 1px solid black"/>
        <c:out value="Hola, me llamo ${estudiante.nombre},
                     tengo ${estudiante.edad} años y vivo en ${estudiante.pais}"/>
        <br/>
        <c:if test="${estudiante.edad gt 18}">
            <c:out value="Quieres una cerveza?"/>
        </c:if>
        <br/>
        <c:forEach var="i" begin="1" end="10">
            <span>Valor de i: <c:out value="${i}"/></span><br/>
        </c:forEach>

        <hr style="border: 1px solid black"/>
        <%@include file="piedepagina.jsp"%>
    </body>
</html>
