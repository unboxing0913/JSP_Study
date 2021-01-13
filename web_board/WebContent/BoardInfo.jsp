<%@page import="model.BoardBean"%>
<%@page import="model.BoardDAO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<% request.setCharacterEncoding("UTF-8"); %>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style type="text/css">
.centered{
	display:table;
	margin-left:auto;
	margin-right:auto;
}
</style>
</head>
<body>
<!-- trim() 혹시모를 공백제거 -->
<%
 int num = Integer.parseInt(request.getParameter("num").trim());
 BoardDAO bdao = new BoardDAO();
 BoardBean bean = bdao.getOneBoard(num);
%>

<div class="centered">
<h2>게시글 보기</h2>
<table width="600" border="1" bgcolor="skyblue">
<tr height="20">
<td width="100" align="center">글번호</td>
<td width="180" align="left"><%=bean.getNum() %></td>
<td width="120" align="center">조회수</td>
<td width="180" align="center"><%=bean.getReadcount() %></td>
</tr>

<tr height="40">
<td width="100" align="center">작성자</td>
<td width="180" align="left"><%=bean.getWriter()%></td>
<td width="120" align="center">작성일</td>
<td width="180" align="center"><%=bean.getReg_date() %></td>
</tr>

<tr height="40">
<td width="120" align="center">이메일</td>
<td colspan="3" align="left"><%=bean.getEmail()%></td>
</tr>

<tr height="40">
<td width="120" align="center">제목</td>
<td colspan="3" align="center"><%=bean.getSubject() %></td>
</tr>

<tr height="80">
<td width="120" align="center">글내용</td>
<td colspan="3" align="center"><%=bean.getContent() %></td>
</tr>

<tr height="40">
<td align="center" colspan="4">
<input type="button" value="답글쓰기"
onclick="location.href='BoardReWriteForm.jsp?num=<%=bean.getNum()%>&ref=<%=bean.getRef() %>&re_step=<%=bean.getRe_step()%>&re_level=<%=bean.getRe_level() %>'">
<input type="button" value="수정하기" onclick="location.href='BoardUpdateForm.jsp?num=<%=bean.getNum() %>'">
<input type="button" value="삭제하기" onclick="location.href='BoardDeleteForm.jsp?num=<%=bean.getNum() %>'">
<input type="button" value="목록하기" onclick="location.href='BoardList.jsp?num=<%=bean.getNum() %>'">
</td>
</tr>
</table>
</div>
</body>
</html>