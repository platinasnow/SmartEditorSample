<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>    
<html>
<head>
<script src="http://code.jquery.com/jquery-1.9.1.js"></script>
<script src="http://code.jquery.com/jquery-migrate-1.1.0.js"></script>
<script src="//netdna.bootstrapcdn.com/bootstrap/3.1.1/js/bootstrap.min.js"></script>
<link rel="stylesheet" href="//netdna.bootstrapcdn.com/bootstrap/3.1.1/css/bootstrap.min.css">
<link rel="stylesheet" href="//netdna.bootstrapcdn.com/bootstrap/3.1.1/css/bootstrap-theme.min.css">
<style type="text/css"> 
	.title-wrap{height: 50px;margin: 100px 0 0;}
	.contents{width:800px;margin: 100px auto;padding: 20px; border: 1px solid #ccc; border-radius: 10px; }
	.title-wrap{margin: 0 10px;padding: 20px; border-bottom: 1px solid #888;}
	.contents-wrap{padding: 20px; min-height: 500px;}
	.recode-wrap{text-align: right; margin: 5px 10px; color: #999;}
	.hit-wrap{color:#999; margin: 20px 0;}
</style>
</head>

<body>
	<div class="container contents">
		<div class="title-wrap">
			${item.title }
		</div>	
		<div class="recode-wrap">
			<fmt:formatDate value="${item.recodeDate }" pattern="yyyy-MM-dd"/> 
		</div>
		
		<div class="contents-wrap">
			${item.contents }
		</div>
		
		<div class="hit-wrap">
			<b>조회수</b> ${item.hit }
		</div>
		
		<form class="viewForm" method="post">
			<input type="hidden" name="seq" value="${item.seq }" />
		<button type="button" onclick="onModify()" class="btn btn-primary">수정</button>
		<button type="button" onclick="onList()" class="btn btn-primary">목록</button>
	</form>
	</div>
	
	
</body>
<script type="text/javascript">
	var onModify = function(){
		var form = $('.viewForm')[0];
		form.action = 'modify';
		form.submit();
	};
	
	var onList = function(){
		location.href='/se';
	};
</script>
</html>


