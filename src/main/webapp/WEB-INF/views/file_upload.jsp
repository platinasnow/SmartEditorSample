<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>

<form id="fileform" name="fileform" method="post">
	<input type="hidden" name="filename" value="${filename }">
	<input type="hidden" name="path" value="${path }">
	<input type="hidden" name="fcode" value="${path }">
</form>
</body>

<script type="text/javascript">
	function fileAttach(){ 
		f = document.fileform;
		fpath = f.path.value;
	    fname = f.filename.value; 
	    fcode = fpath + fname;
	   
	    try{
	    	window.opener.window.parent.pasteHTML(fname); 
	    	window.close();
	    }catch(e){ 
//             alert(e); 
	    }
	}
	fileAttach();
	this.window.close();
</script>
</html>