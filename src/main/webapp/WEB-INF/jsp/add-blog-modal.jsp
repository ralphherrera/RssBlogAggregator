<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../layout/taglibs.jsp"%>
<!-- Modal -->
<div class="modal fade" id="exampleModalCenter" tabindex="-1" role="dialog" aria-labelledby="exampleModalCenterTitle" aria-hidden="true" data-backdrop="static" data-keyboard="false">
  <div class="modal-dialog modal-dialog-centered" role="document">
    <div class="modal-content">
      <div class="modal-header">
        <h5 class="modal-title" id="exampleModalLongTitle">New Blog</h5>
        <button type="button" class="close" data-dismiss="modal" aria-label="Close">
          <span aria-hidden="true">&times;</span>
        </button>
      </div>
      <div class="modal-body">
        <form:form commandName="blog">
       	 <div class="form-group">
        	<div class="input-group">
        		<label for="blogname" class="sr-only">Blog Name</label>
				<form:input path="name" type="text" class="form-control" id="blogname" name="blogname" placeholder="Blog name" required="required" />
			</div>
		</div>
		<div class="form-group">
			<div class="input-group">
        		<label for="blog-url" class="sr-only">Blog Name</label>
				<form:input path="url" type="text" class="form-control" id="blogurl" name="blogurl" placeholder="Blog URL" required="required" />
			</div>
		</div>
	      <div class="modal-footer">
	        <button type="button" class="btn btn-secondary" data-dismiss="modal">Close</button>
	        <button type="submit" class="btn btn-primary">Save</button>
	      </div>
      </form:form>
      </div>
    </div>
  </div>
</div>