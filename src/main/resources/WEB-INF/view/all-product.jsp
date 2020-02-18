<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>

<html>
<body>
<h1>All product</h1>
<ul>
    <c:forEach var="product" items="${products}">
        <li>ID: ${product.id}</li>
        <li>Title: ${product.title}</li>
        <li>Cost: ${product.cost}</li>
        <br>
    </c:forEach>
</ul>
</body>
</html>