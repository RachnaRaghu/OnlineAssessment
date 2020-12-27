<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html><body>
<%String names="Ram, Satish, Priya, Sowmya, Surbhi, Suraj, Prakash";
pageContext.setAttribute("names",  names); %>
<c : forTokens items="${names}" delims=","  var="na" begin="2" end ="6" step="2" >
<c : out value="${na}"></c : out><br>
</c : forTokens>
</body></html>