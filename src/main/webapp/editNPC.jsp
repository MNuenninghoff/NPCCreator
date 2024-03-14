<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!doctype html>
<html>
<c:set var = "title" scope = "session" value = "Edit NPC"/>
<c:import url="head.jsp"/>
<body>
<c:import url="navbar.jsp"/>
 <p>
     ${npc}
 </p>
<div class="container">
    <table class="table">
        <thead>
            <th scope="col">Edit NPC</th>
        </thead>
        <tbody>
            <tr>
                <th scope="row">Description</th>
                <td>
                    <form action="generateNPC" method="post">
                        <input type="text" class="form-control" id="description" value="${npc.description}">
                        <button type="submit" class="btn btn-primary" name="updateDescription">Update Description</button>
                    </form>
                </td>
            </tr>
            <tr>
                <th scope="row">Name</th>
                <td>${npc.name}</td>
                <td>
                    <form action="generateNPC" method="post">
                        <button type="submit" class="btn btn-primary" name="rerollName">Reroll Name</button>
                    </form>
                </td>
            </tr>
            <tr>
                <th scope="row">Ability</th>
                <td>${npc.ability.ability}</td>
                <td>
                    <form action="generateNPC" method="post">
                        <button type="submit" class="btn btn-primary" name="rerollAbility">Reroll Ability</button>
                    </form>
                </td>
            </tr>
            <tr>
                <th scope="row">Appearance</th>
                <td>${npc.appearance.appearance}</td>
                <td>
                    <form action="generateNPC" method="post">
                        <button type="submit" class="btn btn-primary" name="rerollAppearance">Reroll Appearance</button>
                    </form>
                </td>
            </tr>
            <tr>
                <th scope="row">Bond</th>
                <td>${npc.bond.bond}</td>
                <td>
                    <form action="generateNPC" method="post">
                        <button type="submit" class="btn btn-primary" name="rerollBond">Reroll Bond</button>
                    </form>
                </td>
            </tr>
            <tr>
                <th scope="row">Flaw</th>
                <td>${npc.flaw.flaw}</td>
                <td>
                    <form action="generateNPC" method="post">
                        <button type="submit" class="btn btn-primary" name="rerollFlaw">Reroll Flaw</button>
                    </form>
                </td>
            </tr>
            <tr>
                <th scope="row">Interaction Traits</th>
                <td>${npc.interactionTraits.interactionTraits}</td>
                <td>
                    <form action="generateNPC" method="post">
                        <button type="submit" class="btn btn-primary" name="rerollInteractionTraits">Reroll Interaction Traits</button>
                    </form>
                </td>
            </tr>
            <tr>
                <th scope="row">Mannerisms</th>
                <td>${npc.mannerisms.mannerisms}</td>
                <td>
                    <form action="generateNPC" method="post">
                        <button type="submit" class="btn btn-primary" name="rerollMannerisms">Reroll Mannerisms</button>
                    </form>
                </td>
            </tr>
            <tr>
                <th scope="row">Race</th>
                <td>${npc.race.race}</td>
                <td>
                    <form action="generateNPC" method="post">
                        <button type="submit" class="btn btn-primary" name="rerollRace">Reroll Race</button>
                    </form>
                </td>
            </tr>
            <tr>
                <th scope="row">Talent</th>
                <td>${npc.talent.talent}</td>
                <td>
                    <form action="generateNPC" method="post">
                        <button type="submit" class="btn btn-primary" name="rerollTalent">Reroll Talent</button>
                    </form>
                </td>
            </tr>
        </tbody>
    </table>
</div>

</body>
</html>
