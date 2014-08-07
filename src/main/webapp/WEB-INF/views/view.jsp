<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>    
<html>
<head>
<script src="http://code.jquery.com/jquery-1.9.1.js"></script>
<script src="http://code.jquery.com/jquery-migrate-1.1.0.js"></script>
<link rel="stylesheet" href="//netdna.bootstrapcdn.com/bootstrap/3.1.1/css/bootstrap.min.css">
<link rel="stylesheet" href="//netdna.bootstrapcdn.com/bootstrap/3.1.1/css/bootstrap-theme.min.css">
<style type="text/css"> 

	.contents-wrap{margin:30px 0 0 0;min-height: 500px;}
	.contents{ margin: 60px 0 0 0;}
	.recode-wrap{text-align: right; color: #888;}
	.hit-wrap{color:#888; margin: 10px 0;}
	.viewForm{margin: 20px 0 0 0;}
</style>
</head>

<body>
	<div class="container ">
		<div class="contents panel panel-success">
			<div class="title-wrap panel-heading">
				${item.title }
			</div>	
			<div class="panel-body">
				<div class="recode-wrap">
					${item.name } | <fmt:formatDate value="${item.recodeDate }" pattern="yyyy-MM-dd"/> 
				</div>
				<div class="contents-wrap">
				${item.contents }
				</div>
				<div class="hit-wrap">
					<b>조회수</b> ${item.hit }
				</div>
			</div>
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


