function infoConfirm(){
	
	if(document.reg_frm.id.value.length == 0){
			alert("아이디는 필수 사항입니다.");
			reg_frm.id.focus();
			return;
		}	
		
		if(document.reg_frm.id.value.length < 4){
			alert("아이디는 4글자 이상이어야 합니다.");
			reg_frm.id.focus();
			return;
		}
		
		if(document.reg_frm.pw.value.length == 0){
			alert("비밀번호는 필수 사항 입니다.");
			reg_frm.pw.focus();
			return;
		}
		
		if(document.reg_frm.pw.value != documnet.reg_frm.pw_check.value){
			alert("비밀번호가 일치하지 않습니다.");
			reg_frm.pw.focus();
			return;
		}
		
		if(document.reg_frm.name.value.length == 0){
			alert("이름은 필수 사항입니다.");
			reg_frm.name.focus();
			return;
		}
		
		if(document.reg_frm.email.value.length == 0){
			alert("메일은 필수 사항입니다.");
			reg_frm.email.focus();
			return;
		}
		
		if(document.reg_frm.address.value.length == 0){
			alert("주소는 필수 사항입니다.");
			reg_frm.address.focus();
			return;
		} 
		
		document.reg_frm.submit(); //동적 javaScript를 끝내고 submit
				
}

function updateInfoConfrim(){
	
	if(document.reg_frm.pw.value == ""){
		alert("패스워드를 입력하세요.")
		document.reg_frm.pw.focus();
		return;
	}
	
	if(document.reg_frm.pw.value != document.reg_frm.pw_check.value ){
		alert("패스워드가 일치하지 않습니다.")
		document.reg_frm.pw.focus();
		return;
	}
	
	if(document.reg_frm.email.value == ""){
		alert("메일은 필수사항 입니다.")
		document.reg_frm.email.focus();
		return;
	}

	document.reg_frm.submit();	
	
}