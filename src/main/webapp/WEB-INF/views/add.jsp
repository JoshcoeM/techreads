<!DOCTYPE html>

<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<html>
<body>
    <h1>Add Book</h1>

    <form:form method="post" modelAttribute="bookForm" action="${pageContext.request.contextPath}/books">
        <form:input path="id" type="hidden"/>
        <h2>Title <br> <form:input path="title" type="text"/></h2>
        <h2>CoverUrl <br> <form:input path="coverUrl" type="text"/></h2>
        <h2>Author <br><form:input path="author" type="text"/></h2>
        <h2>Rating <br><form:input path="rating" type="text"/></h2>
        <button type="submit">Add</button>
    </form:form>

</body>
</html>