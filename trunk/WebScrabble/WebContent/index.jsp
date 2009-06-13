
<%@ page language="java" contentType="text/html; charset=windows-1255"
    pageEncoding="windows-1255" import = "GameWeb.TestClass" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=windows-1255">
<title>Scrabble</title>
<script type="text/javascript">
<!--
function updateHidden()
{
	var text = document.forms[0].userText.value;
	document.forms[0].Vals.value = text;
	
}
// -->
</script>

</head>
<body>
 <form action='<%= request.getRequestURI() %>' method="POST" onsubmit="updateHidden()">
 		
        Your Text: <input type="text" name="userText" size="20"><br>
        <br><br>
        <input type="submit" value="Submit">
        <input type="hidden" name="Vals" value="">
        <%
        String name = (String)session.getAttribute( "userName" );
        if (name == null || name.equals("")){
        	TestClass.counter++;
        	name = "user"+TestClass.counter;
        	session.setAttribute( "userName", name );

        }
 		String item = request.getParameter("Vals");
        
        if (item != null){
 			TestClass.content += (name+" said: "+item+"<br>");
 			out.write(TestClass.content);
        }
 		%>
       
    </form>
</body>
</html>