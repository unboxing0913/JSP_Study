<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<jsp:useBean id="member" class="com.saeyan.javabeans.MemberBean"></jsp:useBean>
1.자바 빈 객체 생성후 저장된 정보 출력하기<br>
이름 : <%=member.getName() %> <br>
아이디 : <%=member.getUserid() %> <br>
<hr>
2.정보 변경한 후 변경된 정보 출력하기<br>
<%
member.setName("홍길동");
member.setUserid("pinksubin");
%>
이름 : <%=member.getName() %> <br>
아이디 : <%=member.getUserid() %> <br>
</body>
</html>