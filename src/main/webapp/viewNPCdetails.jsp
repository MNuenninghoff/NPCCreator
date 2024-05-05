<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!doctype html>
<html>
<c:set var = "title" scope = "session" value = "NPC Details - NPC Generator"/>
<c:import url="head.jsp"/>
<body>
<c:import url="navbar.jsp"/>
<div class="container">
    <br>
    <h1>NPC Details</h1>
    <div class="row">
        <table class="table">
            <tbody>
            <tr>
                <th scope="row">Description</th>
                <td>
                    ${npc.description}
                </td>
            </tr>
            <tr>
                <th scope="row">Name</th>
                <td>${npc.name}</td>
            </tr>
            <tr>
                <th scope="row">Race</th>
                <td>${npc.race.race}</td>
            </tr>
            <tr>
                <th scope="row">Ability</th>
                <td>${npc.ability.ability}</td>
            </tr>
            <tr>
                <th scope="row">Appearance</th>
                <td>${npc.appearance.appearance}</td>
            </tr>
            <tr>
                <th scope="row">Bond</th>
                <td>${npc.bond.bond}</td>
            </tr>
            <tr>
                <th scope="row">Flaw</th>
                <td>${npc.flaw.flaw}</td>
            </tr>
            <tr>
                <th scope="row">Interaction Traits</th>
                <td>${npc.interactionTraits.interactionTraits}</td>
            </tr>
            <tr>
                <th scope="row">Mannerisms</th>
                <td>${npc.mannerisms.mannerisms}</td>
            </tr>
            <tr>
                <th scope="row">Talent</th>
                <td>${npc.talent.talent}</td>
            </tr>
            </tbody>
        </table>
    </div>
    <div class="container text-center">
        <div class="row">
            <form action="generateNPC" method="post">
                <div class="row">
                    <div class="col">
                        <button type="submit" class="btn btn-outline-primary" name="submit" value="viewNPCs">View NPCs</button>
                    </div>
                    <div class="col">
                        <button type="submit" class="btn btn-primary" name="submit" value="editNPC">Edit NPC</button>
                    </div>
                </div>
            </form>
        </div>
    </div>
</div>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-YvpcrYf0tY3lHB60NNkmXc5s9fDVZLESaAA55NDzOxhy9GkcIdslK1eN7N6jIeHz" crossorigin="anonymous"></script>
</body>
</html>