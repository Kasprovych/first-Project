<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<div class="row">
	<nav class="navbar navbar-default">
		<div class="container-fluid">
			<button type="button" class="navbar-toggle" data-toggle="collapse"
				data-target="#myNavbar">
				<span class="icon-bar"></span> <span class="icon-bar"></span> <span
					class="icon-bar"></span>
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
						<form:form class="form-horizontal" action="/admin/power"
							method="POST" modelAttribute="power">
							
							<div class="form-group">
							<div class="form-group">
								<label for="maxPower" class="col-sm-offset-3 col-sm-9"><form:errors
										path="maxPower" /></label>
							</div>
								<label for="maxPower" class="col-sm-3 control-label">MaxPower</label>
								<div class="col-sm-9">
									<form:input class="form-control" path="maxPower" id="maxPower" />
								</div>
							</div>
							
							<div class="form-group">
							<div class="form-group">
								<label for="voltageAtMaxPover" class="col-sm-offset-3 col-sm-9"><form:errors
										path="voltageAtMaxPover" /></label>
							</div>
								<label for="voltageAtMaxPover" class="col-sm-3 control-label">VoltageAtMaxPover</label>
								<div class="col-sm-9">
									<form:input class="form-control" path="voltageAtMaxPover"
										id="voltageAtMaxPover" />
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
			<div class="col-md-3 col-xs-3">
				<h5>MaxPower</h5>
			</div>
			<div class="col-md-3 col-xs-3">
				<h5>VoltageAtMaxPover</h5>
			</div>
			<div class="col-md-3 col-xs-3">
				<h5>Update</h5>
			</div>
			<div class="col-md-3 col-xs-3">
				<h5>Delete</h5>
			</div>
		</div>
		<c:forEach items="${powers}" var="power">
			<div class="row">
				<div class="col-md-3 col-xs-3">${power.maxPower}</div>
				<div class="col-md-3 col-xs-3">${power.voltageAtMaxPover}</div>
				<div class="col-md-3 col-xs-3">
					<a class="btn btn-warning" href="/admin/power/update/${power.id}">update</a>
				</div>
				<div class="col-md-3 col-xs-3">
					<a class="btn btn-danger" href="/admin/power/delete/${power.id}">delete</a>
				</div>
			</div>
		</c:forEach>
	</div>
	<div class="col-md-2 col-xs-12"></div>
</div>