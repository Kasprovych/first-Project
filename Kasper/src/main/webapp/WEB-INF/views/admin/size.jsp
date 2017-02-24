<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<div class="row">
	<nav class="navbar navbar-default">
		<div class="container-fluid">
			<button type="button" class="navbar-toggle" data-toggle="collapse"
				data-target="#myNavbar">
				<span class="icon-bar"></span>
				<span class="icon-bar"></span>
				<span class="icon-bar"></span>
			</button>
		<div class="collapse navbar-collapse" id="myNavbar">
				<ul class="nav navbar-nav">
					<li><a href="/admin/size">Size</a></li>
					<li><a href="/admin/power">Power</a></li>
					<li><a href="/admin/kind">Kind</a></li>
					<li><a href="/admin/country">Country</a></li>
					<li><a href="/admin/brand">Brand</a></li>
					<li><a href="/admin/item">Item</a></li>
				</ul>
			</div>
		</div>
	</nav>
</div>
<div class="row">
	<div class="col-md-3 col-xs-12"></div>
	<div class="col-md-7 col-xs-12">
		<div class="row">
			<div class="col-md-12 col-xs-12">
				<div class="row">
			<div class="col-md-12 col-xs-12">
				<form:form class="form-horizontal" action="/admin/size" method="POST" modelAttribute="size">
					<div class="form-group">
    					<label for="length" class="col-sm-2 control-label">Length</label>
    					<div class="col-sm-10">
      						<form:input class="form-control" path="length" id="length"/>
    					</div>
  					</div>
  					<div class="form-group">
    					<label for="width" class="col-sm-2 control-label">Width</label>
    					<div class="col-sm-10">
      						<form:input class="form-control" path="width" id="width"/>
    					</div>
  					</div>
  					<div class="form-group">
    					<label for="height" class="col-sm-2 control-label">Height</label>
    					<div class="col-sm-10">
      						<form:input class="form-control" path="height" id="height"/>
    					</div>
  					</div>
  					<div class="form-group">
    					<div class="col-sm-offset-2 col-sm-10">
      						<button type="submit" class="btn btn-default">Create</button>
    					</div>
  					</div>
				</form:form>
			</div>
		</div>
			</div>
		</div>
		<div class="row">
			<div class="col-md-2 col-xs-2"><h3>Length</h3></div>
			<div class="col-md-2 col-xs-2"><h3>Width</h3></div>
			<div class="col-md-2 col-xs-2"><h3>Height</h3></div>
			<div class="col-md-2 col-xs-2"><h3>Update</h3></div>
			<div class="col-md-2 col-xs-2"><h3>Delete</h3></div>
		</div>
			<c:forEach items="${sizes}" var="size">
				<div class="row">							
					<div class="col-md-2 col-xs-2">${size.length}</div>
					<div class="col-md-2 col-xs-2">${size.width}</div>
					<div class="col-md-2 col-xs-2">${size.height}</div>
					<div class="col-md-2 col-xs-2"><a class="btn btn-warning" href="/admin/size/update/${size.id}">update</a></div>
					<div class="col-md-2 col-xs-2"><a class="btn btn-danger" href="/admin/size/delete/${size.id}">delete</a></div>
				</div>
			</c:forEach>
	</div>
	<div class="col-md-2 col-xs-12"></div>
</div>