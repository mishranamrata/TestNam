<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Welcome</title>
</head>
<script type="text/javascript" src="jscharts.js"></script>
<body>
<div id="graph">Loading...</div>


<script type="text/javascript">
	
	var myChart = new JSChart('graph', 'pie', 'b4949a117e0bff9be30,bd6b66a2c65ee32a549');
	myChart.setDataXML("PieUsersBangalore.xml");
	myChart.setTitle("Bangalore");
	myChart.draw();
	
	function callback() {
		alert('User click');
	}
	
</script>

<div id="Delhi">Loading...</div>


<script type="text/javascript">
	
	var myChart = new JSChart('Delhi', 'pie');
	myChart.setDataXML("PieUsersDelhi.xml");
	myChart.setTitle("Delhi");
	myChart.draw();
	
	function callback() {
		alert('User click');
	}
	
</script>
</body>
</html>