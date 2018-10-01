(function(){
	window.onload=function(){
		var local=window.localStorage;
		var locals=window.sessionStorage;
		var pass=document.getElementsByClassName("pass");
		var submit=document.getElementById("login");
		var form=document.getElementById("form");
		var show=document.getElementsByClassName("red")[0];
		var passone=pass[0];
		var passtwo=pass[1];
		submit.onclick=function(){
			if(passtwo.value!=passone.value){
				form.action="#";
				locals.setItem("信息","<img src='../.././img/alert_2.jpg'>两次密码输入不一致");
			}else {
				var phone=document.getElementsByClassName("phone")[0].value;
				var user=document.getElementsByClassName("user")[0].value;
				form.action="/useradd?username="+user+"&password="+passtwo.value+"&beizhuziliao="+phone;
			}
		}
		var information=locals.getItem("信息");
		if(information!=null){
			show.innerHTML=information;
		}
	}
})()