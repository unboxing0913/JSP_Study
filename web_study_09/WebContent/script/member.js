/*
 *  WebContent 아래에 script 폴더에 저장한다.
 * 
 *   폼에 입력된 정보가 올바른지 판단하는 스크립트
 * 
 *   아이디와 암호 모두 입력되었을 때만 로그인 인증 처리 수행
 * 
 *   입력이 안되면 알림창으로 에러 메시지 출력
 */



function loginCheck() {
   if (document.frm.userid.value.length == 0) {
      alert("아이디를 입력하세요.")
      frm.userid.focus();

      return false;
   }

   if (document.frm.pwd.value == "") {
      alert("패스워드는 반드시 입력해야 합니다.")
      frm.pwd.focus();

      return false;
   }

   return true;
}

function idCheck(){
   if(document.frm.userid.value==""){
   alert("아이디 입력");
   document.frm.userid.focus();
   return false;
   }
   var url = "idCheck.do?userid="+document.frm.userid.value;
   var setting = "toolbar=no, menubar=no, scrollbars=yes, resizable=no,"+
                "width=450, height=200";
   
   window.open(url,"_blank_1",setting);

}

function idOk(userid){
	
	opener.frm.userid.value = document.frm.userid.value;
	
	opener.frm.reid.value = document.frm.userid.value;
	//reid(hidden) 인풋태그에 값을 넣어줌
	
	//그대로 남아있게하고 종료
	 self.close()
}





function joinCheck(){
    if(document.frm.name.value.length == 0){
        alert('이름을 입력하세요');
        frm.name.focus();
        return false;
    }
    if(document.frm.userid.value.length == 0){
        alert('id를 입력하세요');
        frm.userid.focus();
        return false;
    }
    if(document.frm.userid.value.length < 4){
        alert('id를 4글자 이상 입력하세요');
        frm.userid.focus();
        return false;
    }
    if(document.frm.pwd.value.length == 0){
        alert('비번을 입력하세요');
        frm.pwd.focus();
        return false;
    }
    if(document.frm.pwd.value != document.frm.pwd_check.value){
        alert('비번이 일치하지 않습니다.');
        frm.pwd_check.focus();
        return false;
    }
    if(document.frm.reid.value.length == 0){
	//reid (hidden으로 묶어둔 input 태그  hidden은 값을 저장할수있음)
        alert('중복체크를 해야 합니다.');
        frm.userid.focus();
        return false;
    }
    //  종료 -> join.jsp의 submit하러 가자!
    return true;
}