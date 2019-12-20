<%@ page pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>

<form:form modelAttribute="form" action="${acturl}/index" enctype="multipart/form-data">
	<div class="row">
		<div class="form-group col-sm-4">
			<label>Id</label>
			<form:input path="id" class="form-control" readonly="${!empty form.id}"/>
			<form:errors path="id"/>
		</div>
		
		<div class="form-group col-sm-4">
			<label>Password</label>
			<form:password path="password" class="form-control" showPassword="true"/>
			<form:errors path="password"/>
		</div>
		
		<div class="form-group col-sm-4">
			<label>Full Name</label>
			<form:input path="fullname" class="form-control"/>
			<form:errors path="fullname"/>
		</div>
	</div>
	
	<div class="row">
		<div class="form-group col-sm-4">
			<label>Email Address</label>
			<form:input path="email" class="form-control"/>
			<form:errors path="email"/>
		</div>
		
		<div class="form-group col-sm-4">
			<label>Role</label>
			<div class="form-control">
				<form:radiobutton path="admin" value="true" label="Administrator"/>
				<form:radiobutton path="admin" value="false" label="User"/>
			</div>
		</div>
		
		<div class="form-group col-sm-4">
			<label>Activated?</label>
			<div class="form-control">
				<form:radiobutton path="activated" value="true" label="Yes"/>
				<form:radiobutton path="activated" value="false" label="No"/>
			</div>
		</div>
	</div>
	
	<div class="row">
		<div class="form-group col-sm-4">
			<label>Photo (${form.photo})</label>
			<input type="file" name="_photo" class="form-control">
			<form:hidden path="photo"/>
		</div>		
	</div>
	
	<div class="form-group">
		<button class="btn btn-default" formaction="${acturl}/create" ${!empty form.id ? 'disabled':''}>
			<span class="glyphicon glyphicon-log-in"></span> Create
		</button>
		<button class="btn btn-default" formaction="${acturl}/update" ${empty form.id ? 'disabled':''}>
			<span class="glyphicon glyphicon-log-in"></span> Update
		</button>
		<button class="btn btn-default" formaction="${acturl}/delete" ${empty form.id ? 'disabled':''}>
			<span class="glyphicon glyphicon-log-in"></span> Delete
		</button>
		<a href="${acturl}/index" class="btn btn-default">
			<span class="glyphicon glyphicon-log-in"></span> Reset
		</a>
	</div>
</form:form>