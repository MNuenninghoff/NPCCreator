<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!doctype html>
<html lang="en">
<c:set var="title" scope="session" value="Home - NPC Generator"/>
<c:import url="head.jsp"/>
<body>
<c:import url="navbar.jsp"/>
<div class="container">
    <h1>Welcome to the NPC Creator!</h1>
        <h2>About the NPC Creator</h2>
        <p>The NPC Creator can generate randomized NPC templates for use in your Dungeons and Dragons Campaign</p>
    <c:choose>
        <c:when test="${empty user}">
                <h2>Log In to Create and View your NPCs</h2>
                <p>Welcome to the NPC Creator. <a href = "logIn">Log in</a> to get started!</p>
        </c:when>
        <c:otherwise>
                <h2>Welcome ${user.userName}</h2>
                <p><a href="generateNPC.jsp">Generate a new NPC</a> or <a href="viewNPCs.jsp">view your previously created NPCs</a>.</p>
        </c:otherwise>
    </c:choose>
</div>

<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-YvpcrYf0tY3lHB60NNkmXc5s9fDVZLESaAA55NDzOxhy9GkcIdslK1eN7N6jIeHz" crossorigin="anonymous"></script>
</body>
</html>
