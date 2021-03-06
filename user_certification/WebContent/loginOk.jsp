<%@page import="com.javalec.ex.MemberDto"%>
<%@page import="com.javalec.ex.MemberDao"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>


	
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<%
//한글인코딩
request.setCharacterEncoding("Utf-8");

//넘어온 아이디와 비번 값 변수에 저장
String id=request.getParameter("id");
String pw=request.getParameter("pw");

//Dao 인스턴스 생성
MemberDao dao=MemberDao.getInstance();
int checkNum = dao.userCheck(id,pw);

//체크 결과에 따라 안내 메세지 출력
if(checkNum == -1){
%>
	<script type="text/javascript">
		alert("아이디가 존재하지 않습니다.");
		history.go(-1);
	</script>
<%
}else if(checkNum == 0){
%>
	<script type="text/javascript">
		alert("비밀번호가 틀립니다.");
		history.go(-1);
	</script>
<%
}else if(checkNum == 1){
	MemberDto dto = dao.getMember(id);
	if(dto == null){
%>		
	<script type="text/javascript">
		alert("존재하지 않는 회원입니다.");
		history.go(-1);
	</script>
<%
	}else{ //로그인 성공시 세션값 설정
		String name = dto.getName();	
		session.setAttribute("id", id);
		session.setAttribute("name", name);
		session.setAttribute("ValidMem", "yes"); //main에서 처리하기위한 세션
		response.sendRedirect("main.jsp"); //서버가 클라이언트한테 재요청		
	}
	
}
%>	
<body>

</body>
</html>