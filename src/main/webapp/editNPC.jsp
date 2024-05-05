<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!doctype html>
<html>
<c:set var = "title" scope = "session" value = "Edit NPC"/>
<c:import url="head.jsp"/>
<body>
<c:import url="navbar.jsp"/>
<div class="container">
    <br>
    <h1>Edit NPC</h1>
    <div class="row">
        <table class="table">
            <tbody>
                <tr>
                    <th scope="row">Description</th>
                    <td colspan="2">
                        <form action="generateNPC" method="post">
                            <div class="row">
                                <div class="col">
                                    <input type="text" class="form-control" name="description" value="${npc.description}">
                                </div>
                                <div class="col">
                                    <button type="submit" class="btn btn-primary" name="submit" value="updateDescription">Update Description</button>
                                </div>
                            </div>
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
                    <th scope="row">Race</th>
                    <td>${npc.race.race}</td>
                    <td>
                        <form action="generateNPC" method="post">
                            <button type="submit" class="btn btn-primary" name="submit" value="rerollRace">Reroll Race</button>
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
    <div class="container text-center">
        <div class="row">
            <form action="generateNPC" method="post">
                <div class="row">
                    <div class="col">
                        <button type="submit" class="btn btn-success" name="submit" value="saveNPC">Save NPC</button>
                    </div>
                    <div class="col">
                        <button type="submit" class="btn btn-danger" name="submit" value="deleteNPC">Delete NPC</button>
                    </div>
                </div>
            </form>
        </div>
    </div>
</div>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-YvpcrYf0tY3lHB60NNkmXc5s9fDVZLESaAA55NDzOxhy9GkcIdslK1eN7N6jIeHz" crossorigin="anonymous"></script>
</body>
</html>
