<%@ page language="java" contentType="text/html; charset=windows-1255"
    pageEncoding="windows-1255"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=windows-1255">
<title>Scrabble</title>
<script type="text/javascript">
<!--
function updateHidden()
{
	var Name = document.forms[0].firstName.value;
	var surname = document.forms[0].surname.value;
	document.forms[0].Vals.value = Name+" "+surname;
	//document.write(Name+" "+surname);
}
// -->
</script>

</head>
<body>
 <form action='<%= request.getRequestURI() %>' method="POST" onsubmit="updateHidden()">
 		<%
 		String item = request.getParameter("Vals");
 		out.println(item);
 		%>
        First Name: <input type="text" name="firstName" size="20"><br>
        Surname: <input type="text" name="surname" size="20">
        <br><br>
        <input type="submit" value="Submit">
        <input type="hidden" name="Vals" value="">
       
    </form>
</body>
</html>