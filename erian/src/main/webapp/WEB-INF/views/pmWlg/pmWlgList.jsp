<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="tags" tagdir="/WEB-INF/tags" %>
<c:set var="ctx" value="${pageContext.request.contextPath}"/>

<html>
<head>
	<title> PM_WLG  Management </title>
</head>

<body>
	<c:if test="${not empty message}">
		<div id="message" class="alert alert-success"><button data-dismiss="alert" class="close">×</button>${message}</div>
	</c:if>
	<div class="row">
		<div class="span4 offset7">
			<form class="form-search" action="#">
				<label>NO.：</label> <input type="text" name="search_LIKE_pmnum" class="input-medium" value="${param.search_LIKE_pmnum}"> 
				<button type="submit" class="btn" id="search_btn">Search</button>
		    </form>
	    </div>
	    <tags:sort/>
	</div>
	
	<table id="contentTable" class="table table-striped table-bordered table-condensed">
		<thead><tr><th> ID </th><th> PM_Num </th><th> DateTime </th><th> Management </th></tr></thead>
		<tbody>
		<c:forEach items="${pmWlgs.content}" var="pmWlg">
			<tr>
				<td><a href="${ctx}/pmWlg/update/${pmWlg.id}">${pmWlg.id}</a></td>
				<td><a href="">${pmWlg.pmnum}</a></td>
				<td><a href="">${pmWlg.dateTime}</a></td>
				<td><a href="${ctx}/pmWlg/delete/${pmWlg.id}">delete</a></td>
			</tr>
		</c:forEach>
		</tbody>
	</table>
	
	<tags:pagination page="${pmWlgs}" paginationSize="5"/>

	<div><a class="btn" href="${ctx}/pmWlg/create">create PM_WLG record</a></div>
</body>
</html>
