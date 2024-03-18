<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!doctype html>
<html lang="en">
<c:set var="title" scope="page" value="NPC Generator - View NPCs"/>
<c:import url="head.jsp"/>
<body>
<c:import url="navbar.jsp"/>
<div class="container">
    <h2>See Your Created NPCs!</h2>
    <table class="table">
        <thead>
            <tr>
                <th scope="col">Description</th>
                <th scope="col">Name</th>
                <th scope="col">Race</th>
            </tr>
        </thead>
        <tbody>
            <c:forEach var="npc" items="${npcs}">
                <tr>
                    <td>
                        ${npc.description}
                    </td>
                    <td>
                        ${npc.name}
                    </td>
                    <td>
                        ${npc.race.race}
                    </td>
                </tr>
            </c:forEach>
        </tbody>
    </table>
</div>
</body>
</html>