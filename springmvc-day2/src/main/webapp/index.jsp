<%@ page language="java" contentType="text/html; charset=UTF-8"
pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<title>Insert title here</title>
	</head>
	<body>
	<script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery.min.js">

</script>
		<script type="text/javascript">
			function jsonTest(){
			
				$.ajax({
					url:"${pageContext.request.contextPath}/jsonTest",
					type:"post",
					contentType:"application/json;charset=utf-8",
					data:'{"username":"aaa","password":"aaa"}',
					dataType:"json",
					success:function(data){
						alert(data);
						alert(data.username);
					}
				})
			}
		</script>

			<form action="${pageContext.request.contextPath}/fileUpload" method="post"   enctype="multipart/form-data">
				<input type="file" name="uploadFile">
				<input type="submit"  value="上传">
			</form>
			
			
			<form action="#" method="post" >
			<input type="button" onclick="jsonTest()" value="测试">
			</form>
			
			<form action="${pageContext.request.contextPath}/annoationTest" method="post">
				<input type="text"  name ="username">
				<input type="submit"  value="ceshi">
			</form>
			
			<form action="${pageContext.request.contextPath}/uploadFileServer" method="post"   enctype="multipart/form-data">
				<input type="file" name="uploadFile">
				<input type="submit"  value="上传">
					
			</form>
			
	</body>
</html>