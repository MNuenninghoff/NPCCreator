<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: mnuenninghoff
  Date: 3/2/24
  Time: 8:56 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!doctype html>
<html>
<c:set var = "title" scope = "session" value = "Generate NPC"/>
<c:import url="head.jsp"/>
<body>
<c:import url="navbar.jsp"/>
<div class="container-md">
    <form method="POST" action="generateNPC">
        <button type="submit" class="btn btn-primary" name="submit" value="generateNPC">Generate NPC</button>
    </form>
</div>

</body>
</html>
