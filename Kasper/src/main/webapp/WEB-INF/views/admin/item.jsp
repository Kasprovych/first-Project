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
				<form:form class="form-horizontal" action="/admin/item" method="POST" modelAttribute="item">
					<div class="form-group">
    					<label for="name" class="col-sm-3 control-label">Name</label>
    					<div class="col-sm-9">
      						<form:input class="form-control" path="name" id="name"/>
    					</div>
  					</div>
  					<div class="form-group">
    					<label for="name" class="col-sm-3 control-label">Brand</label>
    					<div class="col-sm-9">
      						<form:select class="form-control" path="brand" id="name" items="${brands}" itemLabel="name" itemValue="id"/>
    					</div>
  					</div>
  					<div class="form-group">
    					<label for="name" class="col-sm-3 control-label">Kind</label>
    					<div class="col-sm-9">
      						<form:select class="form-control" path="kind" id="name" items="${kinds}" itemLabel="name" itemValue="id"/>
    					</div>
  					</div>
  					<div class="form-group">
    					<label for="name" class="col-sm-3 control-label">Size</label>
    					<div class="col-sm-9">
      						<form:select class="form-control" path="size" id="name" items="${sizes}" itemLabel="presentation" itemValue="id"/>
    					</div>
  					</div>
  					<div class="form-group">
    					<label for="name" class="col-sm-3 control-label">Power</label>
    					<div class="col-sm-9">
      						<form:select class="form-control" path="power" id="name" items="${powers}" itemLabel="presentation" itemValue="id"/>
    					</div>
  					</div>
  					<div class="form-group">
    					<label for="name" class="col-sm-3 control-label">Price</label>
    					<div class="col-sm-9">
      						<form:input class="form-control" path="price" id="name"/>
    					</div>
  					</div>
  					<div class="form-group">
    					<div class="col-sm-offset-3 col-sm-9">
      						<button type="submit" class="btn btn-default">Create</button>
    					</div>
  					</div>
				</form:form>
			</div>
		</div>
			</div>
		</div>
		<div class="row">
			<div class = "col-md-4 col-xs-4" >
				<div class="col-md-6 col-xs-6"><h5>Name</h5></div>
				<div class="col-md-6 col-xs-6"><h5>Brands</h5></div>
			</div>	
			<div class = "col-md-4 col-xs-4" >
				<div class="col-md-4 col-xs-4"><h5>Kind</h5></div>
				<div class="col-md-4 col-xs-4"><h5>Size</h5></div>
				<div class="col-md-4 col-xs-4"><h5>Power</h5></div>
			</div>	
			<div class = "col-md-4 col-xs-4" >
				<div class="col-md-6 col-xs-6"><h5>Price</h5></div>
				<div class="col-md-6 col-xs-6"><h5>Delete</h5></div>
			</div>
		</div>
			<c:forEach items="${items}" var="item">
				<div class="row">	
				<div class = "col-md-4 col-xs-4" >						
					<div class="col-md-6 col-xs-6">${item.name}</div>
					<div class="col-md-6 col-xs-6">${item.brand.name}</div>
				</div>	
				<div class = "col-md-4 col-xs-4" >
					<div class="col-md-4 col-xs-4">${item.kind.name}</div>
					<div class="col-md-4 col-xs-4">${item.size.presentation}</div>
					<div class="col-md-4 col-xs-4">${item.power.presentation}</div>
				</div>
				<div class = "col-md-4 col-xs-4" >	
					<div class="col-md-6 col-xs-6">${item.price}</div>
					<div class="col-md-6 col-xs-6"><a class="btn btn-danger" href="/admin/item/delete/${item.id}">delete</a></div>
				</div>	
				</div>
			</c:forEach>
	</div>
	<div class="col-md-2 col-xs-12"></div>
</div>