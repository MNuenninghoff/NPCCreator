<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!doctype html>
<html lang="en">
<c:set var="title" scope="page" value="View NPCs - NPC Generator"/>
<c:import url="head.jsp"/>
<script type="text/javascript" class="init">
    $(document).ready( function () {
        $('#npcTable').DataTable();
    } );
</script>
<body>
<c:import url="navbar.jsp"/>
<div class="container">
    <h2>See Your Created NPCs!</h2>
    <table id="npcTable" class="table">
        <thead>
            <tr>
                <th scope="col">Description</th>
                <th scope="col">Name</th>
                <th scope="col">Race</th>
                <th scope="col">View Details</th>
            </tr>
        </thead>
        <tbody>
            <c:forEach var="npc" items="${user.npcs}">
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
                    <td><a href="viewNPC?id=${npc.id}">View Details</a></td>
                </tr>
            </c:forEach>
        </tbody>
    </table>
</div>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-YvpcrYf0tY3lHB60NNkmXc5s9fDVZLESaAA55NDzOxhy9GkcIdslK1eN7N6jIeHz" crossorigin="anonymous"></script>
</body>
</html>