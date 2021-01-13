<%@page import="model.BoardBean"%>
<%@page import="java.util.Vector"%>
<%@page import="model.BoardDAO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style type="text/css">
.centered{
	display:table;
	margin-left: auto;
	margin-right: auto;
}
</style>
</head>
<body>
<%
BoardDAO bdao=new BoardDAO();
Vector<BoardBean> vec = bdao.getAllBoard();
%>
<div class="centered">
<h2 align="center">전체 게시글 보기</h2>
<table height="400" border="1" bgcolor="skyblue">
<tr height="20">
<td width="50" align="center">번호</td>
<td width="320" align="center">제목</td>
<td width="100" align="center">작성자</td>
<td width="150" align="center">작성일</td>
<td width="80" align="center">조회수</td>
<%
/* 백터에 저장되어 있는 빈 클래스 하나씩 추출 */
for(int i=0;i<vec.size();i++){
	BoardBean bean = vec.get(i);
%>
</tr>
<tr heght="40">
<td width="50" align="center"><%=i+1 %></td>
<td width="320" align="left"><a href="BoardInfo.jsp?num=<%=bean.getNum()%>"><%=bean.getSubject() %></a></td>
<td width="100" align="center"><%=bean.getWriter() %></td>
<td width="150" align="center"><%=bean.getReg_date() %></td>
<td width="80" align="center"><%=bean.getReadcount() %></td>
</tr>
<%
}
%>
<tr height="20">
<td align="right" colspan="5">
<input type="button" value="글쓰기" onclick="location.href='BoardWriteForm.jsp'">
</td>
</table>
</div>
</body>
</html>