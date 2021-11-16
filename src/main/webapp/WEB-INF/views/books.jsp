<!DOCTYPEhtml>

<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<html>
<style>
    table, th, td {
        border: 1px solid black;
    }
    .center{
        text-align: center;
    }
</style>
<body>
    <h1>Books</h1>

    <a href="<c:url value="/books/add" />">Add Books</a>

    <c:if test="${not empty books}">
        <ul>
            <table>
                <tr>
                    <th>ID</th>
                    <th>Title</th>
                    <th>Book Cover</th>
                    <th>Author</th>
                    <th>Rating</th>
                </tr>
                    <c:forEach var="book" items="${books}">
                        <tr>
                            <td><a href="/books/<c:out value="${book.id}"/>"><c:out value="${book.id}"/></a></td>
                            <td><c:out value="${book.title}"/></td>
                            <td><img src="<c:out value="${book.coverUrl}"/>" /></td>
                            <td><c:out value="${book.author}"/></td>
                            <td><div class="center"><c:out value="${book.rating}"/></div></td>                        </tr>
                    </c:forEach>
            </table>

        </ul>
    </c:if>

</body>
</html>