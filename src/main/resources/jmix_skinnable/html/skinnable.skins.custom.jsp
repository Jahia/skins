<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>

<div class="${fn:escapeXml(currentNode.properties['j:classname'].string)}" <c:if test="${! empty currentNode.properties['j:id']}">id="${fn:escapeXml(currentNode.properties['j:id'].string)}"</c:if>>
     ${wrappedContent}
</div>