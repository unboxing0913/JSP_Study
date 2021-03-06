<%@page import="com.javalec.ex.MemberDao"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<% request.setCharacterEncoding("UTF-8"); %>


<!-- dto객체 만들기 -->
<jsp:useBean id="dto" class="com.javalec.ex.MemberDto" scope="page" />
<jsp:setProperty property="*" name="dto"/>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<%
	String id = (String)session.getAttribute("id"); //중요한 키값(세션에 저장된 id를 가진 회원)
	dto.setId(id);	//아이디에 맞는 dto를 수정해야하기때문에? (어떤회원인지 알기위해)
	MemberDao dao = MemberDao.getInstance();
	int ri = dao.updateMember(dto); //dto를넣기위해 객체를 빈으로 만들어줌
	
	if(ri == 1) {
%>    
	<script type="text/javascript">
		alert("회원정보가 수정되었습니다.");
		document.location.href="main.jsp";
	</script>
<%
	} else {
%>	
	<script type="text/javascript">
		alert("회원정보 수정에 실패했습니다.");
		history.go(-1);
	</script>
<%
	}
%>	
<title>Insert title here</title>
</head>
<body>

</body>
</html>