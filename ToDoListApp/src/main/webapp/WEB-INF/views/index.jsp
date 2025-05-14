<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<html>
<head>
    <title>To-Do List</title>
</head>
<body>
    <h2>To-Do List</h2>
    <form:form action="/save" method="post" modelAttribute="task">
        <input type="hidden" name="id" value="${task.id}" />
        Title: <form:input path="title" /><br/>
        Description: <form:input path="description" /><br/>
        Completed: <form:checkbox path="completed" /><br/>
        <input type="submit" value="Save Task"/>
    </form:form>

    <hr/>
    <table border="1">
        <tr><th>Title</th><th>Description</th><th>Status</th><th>Actions</th></tr>
        <c:forEach var="t" items="${listTasks}">
            <tr>
                <td>${t.title}</td>
                <td>${t.description}</td>
                <td><c:choose><c:when test="${t.completed}">Done</c:when><c:otherwise>Pending</c:otherwise></c:choose></td>
                <td>
                    <a href="/edit/${t.id}">Edit</a> |
                    <a href="/delete/${t.id}">Delete</a>
                </td>
            </tr>
        </c:forEach>
    </table>
</body>
</html>