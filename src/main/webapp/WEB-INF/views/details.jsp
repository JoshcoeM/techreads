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
<a href="/books/delete/<c:out value="${book.id}"/>"> Delete This Book</a>
<a href="/books/edit/<c:out value="${book.id}"/>"> Edit This Book</a>


<c:if test="${not empty book}">
    <ul>
        <table>
            <tr>
                <th>ID</th>
                <th>Book Cover</th>
                <th>Title</th>
                <th>Author</th>
                <th>Rating</th>
            </tr>
                <tr>
                    <td><c:out value="${book.id}"/></td>
                    <td><c:out value="${book.title}"/></td>
                    <td><c:out value="${book.coverUrl}"/></td>
                    <td><c:out value="${book.author}"/></td>
                    <td><div class="center"><c:out value="${book.rating}"/></div></td>
                </tr>
        </table>

    </ul>
</c:if>

</body>
</html>