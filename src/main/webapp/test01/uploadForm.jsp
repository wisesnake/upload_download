<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<c:set var="contextPath" value="${pageContext.request.contextPath}"/>
		<!--파일 업로드 폼은 반~~~~~드시 enctype이 멀티파트 폼데이터로. -->
		<!-- Multipart : MIME의 확장 사양에 잇는 멀티파트라고 하는 여러 다른 종류의 데이터를 수용하는 방법 -->



<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form action="${contextPath }/upload.do" method="post" enctype="multipart/form-data">
    	파일1: <input type="file" name="file1" ><br>
     	파일2: <input type="file" name="file2" > <br>
     	파라미터1: <input type="text" name="param1" > <br>
      	파라미터2: <input type="text" name="param2" > <br>
      	파라미터3: <input type="text" name="param3" > <br>
      	<input type="submit" value="업로드" >
	</form>
</body>
</html>