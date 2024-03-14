<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!doctype html>
<nav class="navbar">
    <div class="container-fluid">
        <!-- TODO: set up so that current page is class="active"-->
        <!-- TODO: set up so that when user not logged in, only "Home and Login" are visible in navbar -->
        <a class="navbar-brand <c:if test="${title} == 'NPC Generator - Home'">active</c:if>" href="index.jsp">Home</a>
        <a class="nav-link active" href="generateNPC.jsp">Generate NPC</a>
        <a class="nav-link" href="viewNPCs.jsp">View NPCs</a>
        <!-- TODO: set up so that login/login is displayed based on whether user is currently logged in/out -->
        <a class="nav-link" href="logIn">Login</a>
        <a class="nav-link" href="logOut">Logout</a>
    </div>
</nav>