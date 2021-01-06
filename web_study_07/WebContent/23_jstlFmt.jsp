<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>      
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<!-- fmt 태그 (23 ~ ??학습까지) -->
<!-- 숫자, 날짜, 시간을 formatiiong하는 기능과 국제화, 다국어 지원 기능을 제공 -->


<fmt:formatNumber value="1234567.89"></fmt:formatNumber>
${value }<br>

<!-- groupingUserd : 콤마와 같이 단위를 구분할 때 사용하는 기호를 표시할 지 여부를 결정함
	 true이면 10,000과 같이 구분 기호가 사용되며,
	 false이면 10000 형식으로 출력된다. -->
<fmt:formatNumber value="1234567.89" groupingUsed="false"></fmt:formatNumber>
${value }<br>

<!--type :숫자(number),통화(currency),퍼센트(percent)중 어느형식으로 표시할지 지정  -->
<fmt:formatNumber value="0.5" type="percent"></fmt:formatNumber>
${value }<br>
<fmt:formatNumber value="10000" type="currency"></fmt:formatNumber>
${value }<br>
<!-- type : currency => currencySymbol : 통화표시 설정  -->
<fmt:formatNumber value="10000" type="currency" currencySymbol="$"></fmt:formatNumber>
${value }<br>

<!-- pattern : 사용자가 지정한 형식 패턴  (#:공백처리,0:0으로처리 )-->
<!-- 앞에서 사용될땐 숫자가 부족해도 전부출력해준다 -->
<fmt:formatNumber value="1234567.8912345" pattern="#,#00.0#"></fmt:formatNumber>
${value }<br>
<fmt:formatNumber value="1234567.8" pattern="#,#00.0#"></fmt:formatNumber>
${value }<br>
<fmt:formatNumber value="1234567.89" pattern=".000"></fmt:formatNumber>
${value }<br>
<fmt:formatNumber value="123.89" pattern="00000.###"></fmt:formatNumber>
${value }<br>
<fmt:formatNumber value="123456.89" pattern="#####.###"></fmt:formatNumber>
${value }<br>
<fmt:formatNumber value="123456.89" pattern="##########.###"></fmt:formatNumber>
${value }<br>
</body>
</html>