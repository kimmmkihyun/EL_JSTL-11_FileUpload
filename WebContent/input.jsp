<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
input.jsp<br>

<form action="fileServ" method="post" enctype="multipart/form-data">

	이름 : <input type="text" name="name"> <br><br>
	파일 : <input type="file" name="file"> <br><br>
	
	<input type="submit" value="전송">
	
</form>