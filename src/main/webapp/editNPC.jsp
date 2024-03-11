<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!doctype html>
<html>
<c:set var = "title" scope = "session" value = "Edit NPC"/>
<c:import url="head.jsp"/>
<body>
<c:import url="navbar.jsp"/>
 <p>
     ${newNPC}
 </p>

</body>
</html>
