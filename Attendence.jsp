<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <%@page import="java.util.Scanner,java.util.ArrayList, java.util.Iterator" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

   
<form action="Attendence.jsp">
   <input type="text" name="name" >
    <input type="submit" value="show">
<%
ArrayList<String> e = new ArrayList<String>(); 
e.add("Atul");
e.add("Abhinav");
e.add("Prince");
e.add("Gaurav");

for(int i = 0 ;i<4;i++)
{
	out.print(e);
}

 
// or  
for(Iterator<String> iter = e.iterator(); iter.hasNext(); ) 
	{ 
	out.println(iter.next()); 
 
	if(iter.hasNext()) 
	{
		String n ;
		Scanner sc =new Scanner(System.in);
		n=sc.nextLine();
		if(n=="yes")
		{
			out.print("yes");
		}
	}
		
	} 




%>
</form>
</body>
</html>