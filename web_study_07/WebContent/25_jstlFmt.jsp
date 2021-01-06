<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%> 
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<pre>
<c:set var="now" value="<%=new java.util.Date() %>"></c:set>
default:<c:out value="${now}"></c:out>
Korea KST<fmt:formatDate value="${now }" type="both" dateStyle="full" timeStyle="full"/>

<!-- timeZone : 타임존을 부분 적용하는 태그 (타임존:한국시간,영군런던시간이 다른데 이와 같은 시간을 사용하는 지역을 묶어서 나누어놓은것  -->
<fmt:timeZone value="GMT">
London GMT : <fmt:formatDate value="${now }" type="both" dateStyle="full" timeStyle="full"/>
</fmt:timeZone>

<!-- GMT : 그리니치 평균시 (+,-)로 시간설정가능 -->
<fmt:timeZone value="GMT-5">
NewYork GMT-5 : <fmt:formatDate value="${now }" type="both" dateStyle="full" timeStyle="full"/>
</fmt:timeZone>

<!-- setTimeZone : 범위설정없이 바로 밑에단 적용 -->
<fmt:setTimeZone value="GMT-1" />
London GMT : <fmt:formatDate value="${now }" type="both" dateStyle="full" timeStyle="full"/>

</pre>

</body>
</html>