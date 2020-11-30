<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix = "c"%>
<%@page isELIgnored="false" %>

<!DOCTYPE html>
<html>
<head>
    <title>Movies</title>
    <style><%@include file="../css/style.css"%></style>
</head>
<body>
<hr>

<h1> Select a Movie </h1>
<form method="get" action="/get/">
    <select name="id">
        <option value="tt3896198">Guardian of Galaxy</option>
        <option value="tt7286456">Joker</option>
        <option value="tt0462499">Rambo</option>
        <option value="tt0099785">Home Alone</option>
        <option value="tt0232500">The Fast and the Furious</option>
        <option value="tt0095016">Die Hard</option>
        <option value="tt1320253">Expendables</option>
        <option value="tt0477080">Unstoppable</option>
        <option value="tt1119646">Hangover</option>


    </select>
    <input type="submit" value="Submit">
</form>
</hr>

<hr>
<form2>
    <table class ="w3-table-all">
        <tr class = "w3-green">
            <th>Recently Viewed</th>
            <c:forEach var = "movie" items = "${movie}">
                <tr>
                <td>${movie.getDescription()}</td>
                </tr>
            </c:forEach>
        </tr>
    </table>
</form2>
<hr/>
<div>
    <h2>Title</h2> <h3><%=request.getParameter("Title")%></h3>
    <h2>Realeased</h2> <h3><%=request.getParameter("Released")%></h3>
    <h2>Run Time</h2> <h3><%=request.getParameter("Runtime")%></h3>
    <h2>Genre</h2> <h3><%=request.getParameter("Genre")%></h3>
    <h2>Director</h2> <h3><%=request.getParameter("Director")%></h3>
</div>

</body>
</html>