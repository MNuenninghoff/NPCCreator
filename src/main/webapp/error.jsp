<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!doctype html>
<html lang="en">
<c:set var="title" scope="page" value="NPC Generator - Error"/>
<c:import url="head.jsp"/>
<body>
    <c:import url="navbar.jsp"/>
    <h2>Something went wrong!</h2>
    <h3>${errorMessage}</h3>
</body>
</html>
