<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Social Graph</title>
</head>

<style>

.link {
  fill: none;
  stroke: #666;
  stroke-width: 1.5px;
}

circle {
  fill: #080;
  stroke: #fff;
  stroke-width: 1.5px;
}

text {
  fill: #B22;
  font: 8px sans-serif;
  pointer-events: none;
}

 .node{
 fill: #eee;
 pointer-events: none;
 }



</style>
<body>
<script src="http://d3js.org/d3.v3.min.js"></script>
<script>
var color = d3.scale.category20();
var links = [
  {source: "Namrata Rahul Bajpai", target: "Gaurav Kulshrestha", location: "Bangalore",group:"1"},
  {source: "Namrata Rahul Bajpai", target: "Priyanka Tiwari", location: "Delhi",group:"1"},
  {source: "Namrata Rahul Bajpai", target: "Priyanka Asthana", location: "Delhi",group:"1"},
  {source: "Namrata Rahul Bajpai", target: "Namita Pandey", location: "Delhi",group:"1"},
  {source: "Namrata Rahul Bajpai", target: "Pallavi Dixit", location: "Delhi",group:"1"},
  {source: "Namrata Rahul Bajpai", target: "Gaurav Dewidi", location: "Delhi",group:"1"},
  {source: "Namrata Rahul Bajpai", target: "Narayan Tiwari", location: "Delhi",group:"1"},
  {source: "Namrata Rahul Bajpai", target: "Tarun Asthana", location: "Delhi",group:"1"},
  {source: "Namrata Rahul Bajpai", target: "Preeti Singh", location: "Delhi",group:"1"},
  {source: "Namrata Rahul Bajpai", target: "Tripti", location: "Delhi",group:"1"},
  {source: "Namrata Rahul Bajpai", target: "Tarun Kulshrestha", location: "Delhi",group:"1"},
  {source: "Namrata Rahul Bajpai", target: "Satyam Awasthi", location: "Bangalore",group:"1"},
  {source: "Namrata Rahul Bajpai", target: "Rohit Adalakaha", location: "Bangalore",group:"1"},
  {source: "Namrata Rahul Bajpai", target: "Vel Murgan", location: "Bangalore",group:"1"},
  {source: "Namrata Rahul Bajpai", target: "Ravindra", location: "Bangalore",group:"1"},
  {source: "Namrata Rahul Bajpai", target: "Gaurav Jain", location: "Bangalore",group:"1"},
  {source: "Namrata Rahul Bajpai", target: "Satyam Tiwari", location: "Bangalore",group:"1"},
  {source: "Namrata Rahul Bajpai", target: "Rohit Asthana", location: "Bangalore",group:"1"},
  {source: "Namrata Rahul Bajpai", target: "Vikas Singh", location: "Bangalore",group:"1"},
  {source: "Namrata Rahul Bajpai", target: "Than Ng", location: "Bangalore",group:"1"},
  {source: "Namrata Rahul Bajpai", target: "Meusium Theather", location: "Bangalore",group:"2"},
  {source: "Namrata Rahul Bajpai", target: "Health Group 2000", location: "Bangalore",group:"2"},
  {source: "Namrata Rahul Bajpai", target: "Healthy Habbits", location: "Bangalore",group:"2"},
  {source: "Namrata Rahul Bajpai", target: "Healthy Activity", location: "Bangalore",group:"3"}
  ];

var nodes = {};

// Compute the distinct nodes from the links.
links.forEach(function(link) {
  link.source = nodes[link.source] || (nodes[link.source] = {name: link.source});
  link.target = nodes[link.target] || (nodes[link.target] = {name: link.target});
});

var width = 960,
    height = 500;

var force = d3.layout.force()
    .nodes(d3.values(nodes))
    .links(links)
    .size([width, height])
    .linkDistance(100)
    .charge(-300)
    .on("tick", tick)
    .start();

var svg = d3.select("body").append("svg")
    .attr("width", width)
    .attr("height", height);

var link = svg.selectAll(".link")
    .data(force.links())
  .enter().append("line")
    .attr("class", "link");
   

var node = svg.selectAll(".node")
    .data(force.nodes())
    .enter().append("g")
    .attr("class", "node")
    .style("fill", "#B22")
    .on("mouseover", mouseover)
    .on("mouseout", mouseout)
    .call(force.drag);

node.append("circle")
    .attr("r", 8)
    .style("fill","#080");

node.append("text")
    .attr("x", 12)
    .attr("dy", ".35em")
    .text(function(d) { return d.name; });

function tick() {
  link
      .attr("x1", function(d) { return d.source.x; })
      .attr("y1", function(d) { return d.source.y; })
      .attr("x2", function(d) { return d.target.x; })
      .attr("y2", function(d) { return d.target.y; });

  node
      .attr("transform", function(d) { return "translate(" + d.x + "," + d.y + ")"; });
}

function mouseover() {
  d3.select(this).select("circle").transition()
      .duration(750)
      .attr("r", 16);
}

function mouseout() {
  d3.select(this).select("circle").transition()
      .duration(750)
      .attr("r", 8);
}

</script>
<body>

</body>
</html>