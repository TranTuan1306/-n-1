<%@ page pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>

<form:form modelAttribute="form" action="${acturl}/index" enctype="multipart/form-data">
	<div class="row">
		<div class="form-group col-sm-4">
			<label>Id</label>
			<form:input path="id" class="form-control" readonly="true"/>
			<form:errors path="id"/>
		</div>
				
		<div class="form-group col-sm-4">
			<label>Name</label>
			<form:input path="name" class="form-control"/>
			<form:errors path="name"/>
		</div>
		
		<div class="form-group col-sm-4">
			<label>Unit Price</label>
			<form:input path="unitPrice" class="form-control"/>
			<form:errors path="unitPrice"/>
		</div>
	</div>
	
	<div class="row">
		<div class="form-group col-sm-4">
			<label>Discount</label>
			<form:input path="discount" class="form-control"/>
			<form:errors path="discount"/>
		</div>
		
		<div class="form-group col-sm-4">
			<label>Quantity</label>
			<form:input path="quantity" class="form-control"/>
			<form:errors path="quantity"/>
		</div>
		
		<div class="form-group col-sm-4">
			<label>Product Date</label>
			<form:input path="productDate" class="form-control" placeholder="01/01/2019"/>
			<form:errors path="productDate"/>
		</div>
	</div>
	
	<div class="row">		
		<div class="form-group col-sm-4">
			<label>Image (${form.image})</label>
			<input type="file" name="_photo" class="form-control">
			<form:hidden path="image"/>
		</div>
		
		<div class="form-group col-sm-4">
			<label>Category</label>
			<form:select path="category.id" class="form-control">
				<form:options items="${cates}" itemValue="id" itemLabel="nameVN"/>
			</form:select>
			<form:errors path="category.id"/>
		</div>
		
		<div class="form-group col-sm-4">
			<label>View Count</label>
			<form:input path="viewCount" class="form-control"/>
			<form:errors path="viewCount"/>
		</div>
	</div>
	
	<div class="row">
		<div class="form-group col-sm-4">
			<label>Special?</label>
			<div class="form-control">
				<form:radiobutton path="special" value="true" label="Yes"/>
				<form:radiobutton path="special" value="false" label="No"/>
			</div>
		</div>
		
		<div class="form-group col-sm-4">
			<label>Available?</label>
			<div class="form-control">
				<form:radiobutton path="available" value="true" label="Yes"/>
				<form:radiobutton path="available" value="false" label="No"/>
			</div>
		</div>	
	</div>
	
	<div class="row">
		<div class="form-group col-sm-12">
			<label>Description</label>
			<form:textarea path="description" rows="4" class="form-control"/>
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