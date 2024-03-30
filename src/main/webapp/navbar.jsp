<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!doctype html>
<nav class="navbar navbar-expand-lg bg-light">
    <div class="container-fluid">
        <!-- TODO: set up so that current page is class="active"-->
        <a class="navbar-brand" href="index.jsp">Home</a>
        <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarNavDropdown" aria-controls="navbarNavDropdown" aria-expanded="false" aria-label="Toggle navigation">
            <span class="navbar-toggler-icon"></span>
        </button>
        <div class="collapse navbar-collapse" id="navbarNavDropdown">
            <div class="navbar-nav">
            <c:choose>
                <c:when test="${empty user}">
                        <a class="nav-link" href="logIn">Login</a>
                </c:when>
                <c:otherwise>
                        <a class="nav-link" href="generateNPC.jsp">Generate NPC</a>
                        <a class="nav-link" href="viewNPCs.jsp">View NPCs</a>
                        <a class="nav-link" href="logOut">Logout</a>
                </c:otherwise>
            </c:choose>
            </div>
        </div>

    </div>
</nav>