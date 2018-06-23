<%@taglib prefix="sf" uri="http://www.springframework.org/tags/form" %>


<div class="container">

		<c:if test="${not empty message}">
		<div class="row">
			<div class="col-xs-12">
			
				<div class="alert alert-success alert-dismissible">
					<button type="button" class="close" data-dismiss="alert">&times;${message}</button>
					
					
				</div>
				
			
		
		</div>
		</div>
		
		</c:if>

	<div class="row">

	<!--  -->
		<div class="com-md-offset-2 col-md-8">
			<div class="panel panel-primary">
			
				<div class="panel-heading">
					<h4>Product Management</h4>
				
				</div>
				<div class="panel-body">
				
				<!-- Form Elements -->
				<sf:form class="form-horizontal" modelAttribute="product" action="${contextRoot}/manage/products" enctype="multipart/form-data" method="POST"> 
					<div class="form-group">
					
						<label class="control-label col-md-4" for="name">Enter Product Name</label>					
						<div class="col-md-8">
						
							<sf:input type="text" path="name"  id="name" placeholder="Product Name" class="form-control" />
							<sf:errors path="name" cssClass="help-block" element="em" />
							
						</div>
					</div>
				
				
					<div class="form-group">
					
						<label class="control-label col-md-4" for="brand">Enter Brand Name</label>
					
						<div class="col-md-8">
						
							<sf:input type="text" path="brand"  id="brand" placeholder="Brand Name" class="form-control" />
							
							<sf:errors path="brand" cssClass="help-block" element="em" />
						
						</div>
					</div>
					
					<div class="form-group">
					
						<label class="control-label col-md-4" for="description">Product Description</label>
					
						<div class="col-md-8">
						
							<sf:textarea path="description" id="description" rows="4" placeholder="write a description"></sf:textarea>
							<sf:errors path="description" cssClass="help-block" element="em" />
							</div>
					</div>
					
					<div class="form-group">
					
						<label class="control-label col-md-4" for="unitPrice">Enter Unit Price : </label>
					
						<div class="col-md-8">
						
							<sf:input type="number" path="unitPrice"  id="unitPrice" placeholder="Unit Price In &#8361;" class="form-control" />
							<sf:errors path="unitPrice" cssClass="help-block" element="em" />
						</div>
					</div>
					
					<div class="form-group">
					
						<label class="control-label col-md-4" for="quantity">Quantity Availabel : </label>
					
						<div class="col-md-8">
						
							<sf:input type="number" path="quantity"  id="quantity" placeholder="Quantity Available" class="form-control" />
						
						</div>
					</div>
					
					<div class="form-group">
					
						<label class="control-label col-md-4" for="file">Select an Image : </label>
					
						<div class="col-md-8">
						
							<sf:input type="file" path="file"  id="file" class="form-control" />
						
						</div>
					</div>
					
					<div class="form-group">
					
						<label class="control-label col-md-4" for="categoryId">Select Category : </label>
					
						<div class="col-md-8">
						
							<sf:select class="selectpicker" id="category" path="categoryId" 
								items="${categories}" 
								itemLabel="name"
								itemValue="id"
							/>
								
						
						</div>
					</div>
					
					
					
					<div class="form-group">
										
						<div class="col-md-offset-4 col-md-8">
						
							<input type="submit" name="submit"  id="submit" value="submit" class="btn btn-primary" />
							
							<!-- hidden fild -->
							
							<sf:hidden path="id" />
							<sf:hidden path="code" />
							<sf:hidden path="supplierId" />
							<sf:hidden path="purchases" />
							<sf:hidden path="views" />
							
							
							
						</div>
					</div>
				
				</sf:form>
				
				</div>
			</div>		
		</div>
	</div>
</div>