<%@page import="com.javalec.ex.MemberDao"%>
<%@page import="java.sql.Timestamp"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%request.setCharacterEncoding("UTF-8"); %>
<!-- 자바빈으로 dto에 정보를 보낸다 -->
<jsp:useBean id="dto" class="com.javalec.ex.MemberDto"></jsp:useBean>
<jsp:setProperty property="*" name="dto"/> <!-- 자바빈에 모든 정보저장 -->
<%
dto.setrDate(new Timestamp(System.currentTimeMillis())); //sql
MemberDao dao=MemberDao.getInstance(); // MemberDao에 만들어놓은 객체


if(dao.confirmId(dto.getId())==MemberDao.MEMBER_EXISTENT){
%>

	<script type="text/javascript">
		alert("아이디가 이미 존재합니다.");
		history.back(); // 뒤로가기
	</script>

<%
}else{
		int ri=dao.insertMember(dto);
		
		if(ri==MemberDao.MEMBER_JOIN_SUCCESS){
		session.setAttribute("id",dto.getId());//
%>
		<script type="text/javascript">
			alert("회원가입을 축하합니다!");
			document.location.href="login.jsp"; //login.jsp페이지로 이동(자바스크립트처리방식)
		</script>
<%
		}else{
%>
		<script type="text/javascript">
			alert("회원가입에 실패했습니다.");
			document.location.href="login.jsp"; 
		</script>
<%
	 	}
}
%>		
	
</body>
</html>