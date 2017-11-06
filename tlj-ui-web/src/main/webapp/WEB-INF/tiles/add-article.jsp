<%@ page language="java"
contentType="text/html; charset=utf-8"
pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<form action="<c:url value='/article/add'/>" method="POST">
<div class="modal fade" id="add-article" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel" aria-hidden="true">
  <div class="modal-dialog" role="document">
    <div class="modal-content">
      <div class="modal-header">
        <h5 class="modal-title" id="exampleModalLabel">Новая статья</h5>
        <button type="button" class="close" data-dismiss="modal" aria-label="Close">
          <span aria-hidden="true">&times;</span>
        </button>
      </div>
      <div class="modal-body">
        <form>
          <div class="form-group">
            <label for="recipient-name" class="col-form-label">Заголовок:</label>
            <input type="text" class="form-control" id="recipient-name" name = "title" maxlength="128">
          </div>
          <div class="form-group">
            <label for="message-text" class="col-form-label">Текст:</label>
            <textarea class="form-control" id="message-text" name = "text" rows="15"></textarea>
          </div>
        </form>
      </div>
      <div class="modal-footer">
        <button type="button" class="btn btn-secondary" data-dismiss="modal">Закрыть</button>
        <button type="submit" class="btn btn-dark">Сохранить</button>
      </div>
    </div>
  </div>
</div>
</form>
