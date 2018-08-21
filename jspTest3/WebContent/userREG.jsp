<!DOCTYPE html>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<html>

<head>

  <meta charset="UTF-8">

  <title>用户注册</title>

  <style>
html,body,div,span,applet,object,iframe,h1,h2,h3,h4,h5,h6,p,blockquote,pre,a,abbr,acronym,address,big,cite,code,del,dfn,em,img,ins,kbd,q,s,samp,small,strike,strong,sub,sup,tt,var,b,u,i,center,dl,dt,dd,ol,ul,li,fieldset,form,label,legend,table,caption,tbody,tfoot,thead,tr,th,td,article,aside,canvas,details,embed,figure,figcaption,footer,header,hgroup,menu,nav,output,ruby,section,summary,time,mark,audio,video{margin:0;padding:0;border:0;font-size:100%;font:inherit;vertical-align:baseline}article,aside,details,figcaption,figure,footer,header,hgroup,menu,nav,section{display:block}body{line-height:1}ol,ul{list-style:none}blockquote,q{quotes:none}blockquote:before,blockquote:after,q:before,q:after{content:'';content:none}table{border-collapse:collapse;border-spacing:0}

</style>

    <style>
* {
  box-sizing: border-box;
}

body {
  font-family: "HelveticaNeue-Light","Helvetica Neue Light","Helvetica Neue",Helvetica,Arial,"Lucida Grande",sans-serif;
  color: white;
  font-size: 12px;
  background: #333333 url(/images/classy_fabric.png);
}

form {
  background: #111;
  width: 300px;
  margin: 30px auto;
  border-radius: 0.4em;
  border: 1px solid #191919;
  overflow: hidden;
  position: relative;
  box-shadow: 0 5px 10px 5px rgba(0, 0, 0, 0.2);
}

form:after {
  content: "";
  display: block;
  position: absolute;
  height: 1px;
  width: 100px;
  left: 20%;
  background: linear-gradient(to right, #111111, #444444, #b6b6b8, #444444, #111111);
  top: 0;
}

form:before {
  content: "";
  display: block;
  position: absolute;
  width: 8px;
  height: 5px;
  border-radius: 50%;
  left: 34%;
  top: -7px;
  box-shadow: 0 0 6px 4px #fff;
}

.inset {
  padding: 20px;
  border-top: 1px solid #19191a;
}

form h1 {
  font-size: 18px;
  text-shadow: 0 1px 0 black;
  text-align: center;
  padding: 15px 0;
  border-bottom: 1px solid black;
  position: relative;
}

form h1:after {
  content: "";
  display: block;
  width: 250px;
  height: 100px;
  position: absolute;
  top: 0;
  left: 50px;
  pointer-events: none;
  transform: rotate(70deg);
  background: linear-gradient(50deg, rgba(255, 255, 255, 0.15), rgba(0, 0, 0, 0));
}

label {
  color: #666;
  display: block;
  padding-bottom: 9px;
}

input[type=text],
input[type=password] {
  width: 100%;
  padding: 8px 5px;
  background: linear-gradient(#1f2124, #27292c);
  border: 1px solid #222;
  box-shadow: 0 1px 0 rgba(255, 255, 255, 0.1);
  border-radius: 0.3em;
  margin-bottom: 20px;
}

label[for=remember] {
  color: white;
  display: inline-block;
  padding-bottom: 0;
  padding-top: 5px;
}

input[type=checkbox] {
  display: inline-block;
  vertical-align: top;
}

.p-container {
  padding: 0 20px 20px 20px;
}

.p-container:after {
  clear: both;
  display: table;
  content: "";
}

.p-container span {
  display: block;
  float: left;
  color: #0d93ff;
  padding-top: 8px;
}

input[type=submit] {
  padding: 5px 20px;
  border: 1px solid rgba(0, 0, 0, 0.4);
  text-shadow: 0 -1px 0 rgba(0, 0, 0, 0.4);
  box-shadow: inset 0 1px 0 rgba(255, 255, 255, 0.3), inset 0 10px 10px rgba(255, 255, 255, 0.1);
  border-radius: 0.3em;
  background: #0184ff;
  color: white;
  float: right;
  font-weight: bold;
  cursor: pointer;
  font-size: 13px;
}

input[type=submit]:hover {
  box-shadow: inset 0 1px 0 rgba(255, 255, 255, 0.3), inset 0 -10px 10px rgba(255, 255, 255, 0.1);
}

input[type=text]:hover,
input[type=password]:hover,
label:hover ~ input[type=text],
label:hover ~ input[type=password] {
  background: #27292c;
}

</style>

    <script src="js/prefixfree.min.js"></script>

    <script src="js/modernizr.js"></script>

</head>

<body>

  <form id="form" method="post" action="servlet/UserREG" >
  <h1>注册</h1>
  <div class="inset">
  <p>
    <label for="email">用户名</label>
    <input type="text" value="${account }" name="account"
				id="account" />
  </p>
  <p>
    <label for="password">密码</label>
    <input type="password" value="${password }" name="password"
				id="password" />
  </p>
    <p>
    <label for="password">角色</label>
     <select id="jueseid" class="select" name= "jueseid">
        <option value="1">亲人</option>
        <option value="2">服务商</option>
        
    </select>
				
  </p>
  <p>
    <label for="password">验证码</label>
    <input type="text" name="VC" size="5">
	<a href="javascript:changeCode()"><img alt="" src="ValidateCode"></a>
    
  </p>
 <p>
 	<font id="error" color="red">${error }</font>
 </p>
  </div>
  <p class="p-container">
		<a class="submit" id="btn_login" href="javascript:login()"><input type="submit" name="go" id="go" value="注册"></a>
		<a class="btn_style" id="btn_reset" href="javascript:reset()">重置</a> 
		
  </p>
</form>


  <script src='js/jquery.js'></script>
  <script type="text/javascript">
	function reset() {
		document.getElementById("account").value = "";
		document.getElementById("password").value = "";
		document.getElementById("error").innerHTML = "";
	}
	function login() {
		document.getElementById('form').submit();
	}
</script>
<script type="text/javascript">
		function changeCode(){
			var img = document.getElementsByTagName("img")[0];				//得到图片元素
			img.src = "ValidateCode?time="+new Date().getTime();			//改变src值则发出请求
		}
	</script>

<div style="text-align:center;clear:both;">
<script src="/gg_bd_ad_720x90.js" type="text/javascript"></script>
<script src="/follow.js" type="text/javascript"></script>
</div>
</body>

</html>