$(function(){
    //상태 객체
    var status = {
        memberId:false,
        memberPw:false,
        memberPwCheck:false,
        memberNickname:false,
        memberContact:false,
        memberBirth:false,
        memberEmail:false,
        memberAddress:false,
        ok:function(){
            return this.memberId && this.memberPw 
                        && this.memberPwCheck && this.memberNickname 
                        && this.memberContact && this.memberBirth
                        && this.memberEmail && this.memberAddress;
        },
    };

    $("[name=memberId]").blur(function(e){
        var regex = /^[a-z][a-z0-9]{4,19}$/;
        var isValid = regex.test($(e.target).val());
        
        if(isValid) {//형식이 유효하다면
            
            $.ajax({
                url:"/rest/member/idCheck",
                method:"post",
                // data : {memberId : e.target.value },
                data : { memberId : $(e.target).val() },
                success : function(response){
                    $(e.target).removeClass("success fail fail2");
                    if(response == "Y") {//사용가능
                        $(e.target).addClass("success");
                        status.memberId = true;
                    }
                    else {//사용불가(중복)
                        $(e.target).addClass("fail2");
                        status.memberId = false;
                    }
                },
                error : function(){
                    alert("서버와의 통신이 원활하지 않습니다");
                },
            });
            
        }
        else {//형식이 유효하지 않다면(1차실패)
            $(e.target).removeClass("success fail fail2");
            $(e.target).addClass("fail");
            status.memberId = false;
        }
    });
    $("[name=memberPw]").blur(function(){
        var regex = /^(?=.*[A-Z])(?=.*[a-z])(?=.*[0-9])(?=.*[!@#$])[A-Za-z0-9!@#$]{8,16}$/;
        var isValid = regex.test($(this).val());
        $(this).removeClass("success fail");
        $(this).addClass(isValid ? "success" : "fail");
        status.memberPw = isValid;
    });
    $("#password-check").blur(function(){
        var pw1 = $("[name=memberPw]").val();
        var pw2 = $(this).val();
        $(this).removeClass("success fail fail2");
        if(pw1.length == 0) {
            $(this).addClass("fail2");
            status.memberPwCheck = false;
        }
        else if(pw1 == pw2) {
            $(this).addClass("success");
            status.memberPwCheck = true;
        }
        else {
            $(this).addClass("fail");
            status.memberPwCheck = false;
        }
    });
    $("[name=memberNickname]").blur(function(e){
        var regex = /^[ㄱ-ㅎㅏ-ㅣ가-힣0-9]{2,10}$/;
        var isValid = regex.test($(e.target).val());
        
        if(isValid) {//형식 통과

            $.ajax({
                url:"/rest/member/nicknameCheck",
                method:"post",
                // data:{ memberNickname : e.target.value },//JS
                data : { memberNickname : $(e.target).val() },//jQuery
                success : function(response){
                    $(e.target).removeClass("success fail fail2");
                    if(response == "Y") {//사용 가능한 닉네임
                        $(e.target).addClass("success");
                        status.memberNickname = true;
                    }
                    else {//이미 사용중인 닉네임
                        $(e.target).addClass("fail2");
                        status.memberNickname = false;
                    }
                },
                error : function(){
                    alert("서버와의 통신이 원활하지 않습니다");
                },
            });

        }
        else {//형식 오류
            $(e.target).removeClass("success fail fail2");
            $(e.target).addClass("fail");
            status.memberNickname = false;
        }
    });
    $("[name=memberEmail]").blur(function(){
        var regex = /^[a-zA-Z0-9+-\_.]+@[a-zA-Z0-9-]+\.[a-zA-Z0-9-.]+$/;
        var email = $(this).val();
        var isValid = email.length == 0 || regex.test(email);
        $(this).removeClass("success fail");
        $(this).addClass(isValid ? "success" : "fail");
        status.memberEmail = isValid;
    });
    $("[name=memberContact]").blur(function(){
        var regex = /^010[1-9][0-9]{7}$/;
        var contact = $(this).val();
        var isValid = contact.length == 0 || regex.test(contact);
        $(this).removeClass("success fail");
        $(this).addClass(isValid ? "success" : "fail");
        status.memberContact = isValid;
    });
    $("[name=memberBirth]").blur(function(){
        var regex = /^(19[0-9]{2}|20[0-9]{2})-(0[1-9]|1[0-2])-(0[1-9]|[12][0-9]|3[01])$/;
        var birth = $(this).val();
        var isValid = birth.length == 0 || regex.test(birth);
        $(this).removeClass("success fail");
        $(this).addClass(isValid ? "success" : "fail");
        status.memberBirth = isValid;
    });
    $("[name=memberAddr2]").blur(function(){
        //this 사용 불가(확실히 누군지 알 수 없음)
        var post = $("[name=memberPost]").val();
        var addr1 = $("[name=memberAddr1]").val();
        var addr2 = $("[name=memberAddr2]").val();

        var isBlank = post.length == 0 && addr1.length == 0 && addr2.length == 0;
        var isFill = post.length > 0 && addr1.length > 0 && addr2.length > 0;

        var isValid = isBlank || isFill;
        $("[name=memberPost],[name=memberAddr1],[name=memberAddr2]").removeClass("success fail");
        $("[name=memberPost],[name=memberAddr1],[name=memberAddr2]").addClass(isValid ? "success" : "fail");

        status.memberAddress = isValid;
    });

    //페이지 이탈 방지
    //- window에 beforeunload 이벤트 설정
    $(window).on("beforeunload", function(){
        return false;
    });

    //- form 전송할 때는 beforeunload 이벤트를 제거
    $(".join-form").submit(function(e){
        $(".form-input").blur();
        if(!status.ok()) {
            e.preventDefault();
            //return false;
        }
        else {
            $(window).off("beforeunload");
        }
    });
});