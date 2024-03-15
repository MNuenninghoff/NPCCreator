<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!doctype html>
<html>
<c:set var = "title" scope = "session" value = "Edit NPC"/>
<c:import url="head.jsp"/>
<body>
<c:import url="navbar.jsp"/>
<div class="container">
    <div class="row">
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
                            <button type="submit" class="btn btn-primary" name="submit" value="updateDescription">Update Description</button>
                        </form>
                    </td>
                </tr>
                <tr>
                    <th scope="row">Name</th>
                    <td>${npc.name}</td>
                    <td>
                        <form action="generateNPC" method="post">
                            <button type="submit" class="btn btn-primary" name="submit" value="rerollName">Reroll Name</button>
                        </form>
                    </td>
                </tr>
                <tr>
                    <th scope="row">Ability</th>
                    <td>${npc.ability.ability}</td>
                    <td>
                        <form action="generateNPC" method="post">
                            <button type="submit" class="btn btn-primary" name="submit" value="rerollAbility">Reroll Ability</button>
                        </form>
                    </td>
                </tr>
                <tr>
                    <th scope="row">Appearance</th>
                    <td>${npc.appearance.appearance}</td>
                    <td>
                        <form action="generateNPC" method="post">
                            <button type="submit" class="btn btn-primary" name="submit" value="rerollAppearance">Reroll Appearance</button>
                        </form>
                    </td>
                </tr>
                <tr>
                    <th scope="row">Bond</th>
                    <td>${npc.bond.bond}</td>
                    <td>
                        <form action="generateNPC" method="post">
                            <button type="submit" class="btn btn-primary" name="submit" value="rerollBond">Reroll Bond</button>
                        </form>
                    </td>
                </tr>
                <tr>
                    <th scope="row">Flaw</th>
                    <td>${npc.flaw.flaw}</td>
                    <td>
                        <form action="generateNPC" method="post">
                            <button type="submit" class="btn btn-primary" name="submit" value="rerollFlaw">Reroll Flaw</button>
                        </form>
                    </td>
                </tr>
                <tr>
                    <th scope="row">Interaction Traits</th>
                    <td>${npc.interactionTraits.interactionTraits}</td>
                    <td>
                        <form action="generateNPC" method="post">
                            <button type="submit" class="btn btn-primary" name="submit" value="rerollInteractionTraits">Reroll Interaction Traits</button>
                        </form>
                    </td>
                </tr>
                <tr>
                    <th scope="row">Mannerisms</th>
                    <td>${npc.mannerisms.mannerisms}</td>
                    <td>
                        <form action="generateNPC" method="post">
                            <button type="submit" class="btn btn-primary" name="submit" value="rerollMannerisms">Reroll Mannerisms</button>
                        </form>
                    </td>
                </tr>
                <tr>
                    <th scope="row">Race</th>
                    <td>${npc.race.race}</td>
                    <td>
                        <form action="generateNPC" method="post">
                            <button type="submit" class="btn btn-primary" name="submit" value="rerollRace">Reroll Race</button>
                        </form>
                    </td>
                </tr>
                <tr>
                    <th scope="row">Talent</th>
                    <td>${npc.talent.talent}</td>
                    <td>
                        <form action="generateNPC" method="post">
                            <button type="submit" class="btn btn-primary" name="submit" value="rerollTalent">Reroll Talent</button>
                        </form>
                    </td>
                </tr>
            </tbody>
        </table>
    </div>
    <div class="row">
        <form action="generateNPC" method="post">
            <div class="col">
                <button type="submit" class="btn btn-success" name="submit" value="saveNPC">Save NPC</button>
            </div>
            <div class="col">
                <button type="submit" class="btn btn-danger" name="submit" value="deleteNPC">Delete NPC</button>
            </div>
        </form>
    </div>
</div>

</body>
</html>
