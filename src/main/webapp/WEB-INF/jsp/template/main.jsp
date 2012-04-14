<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="css/twitter.css" type="text/css" rel="stylesheet" media="screen">
		<title>Twitter API</title>
	</head>

	<body>
		<div id="header-style"><tiles:insertAttribute name="header" /></div>
		<div id="menu-style"><h2><tiles:insertAttribute name="menu" /></h2></div>
		<div id="content-style"><tiles:insertAttribute name="content" /></div>
		<div id="footer-style"><tiles:insertAttribute name="footer" /></div>
	</body>
</html>