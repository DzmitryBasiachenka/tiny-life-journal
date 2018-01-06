<%@ page language="java"
contentType="text/html; charset=utf-8"
pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<div class="modal fade" id="add-article" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel" aria-hidden="true">
  <div class="modal-dialog" role="document">
    <div class="modal-content">
      <div class="modal-header">
        <ul class="nav nav-tabs  bg-secondary" role="tablist">
          <li class="nav-item">
            <a class="nav-link active text-dark" id="default-tab" data-toggle="tab" href="#default" role="tab" aria-controls="default" aria-selected="true">Default</a>
          </li>
          <li class="nav-item">
            <a class="nav-link text-dark" id="singleUpload-tab" data-toggle="tab" href="#singleUpload" role="tab" aria-controls="singleUpload" aria-selected="false">Single upload</a>
          </li>
        </ul>
        <button type="button" class="close" data-dismiss="modal" aria-label="Close">
          <span aria-hidden="true">&times;</span>
        </button>
      </div>
      <div class="tab-content">
        <div class="tab-pane fade show active" id="default" role="tabpanel" aria-labelledby="default-tab">
          <form action="<c:url value='/article/add'/>" method="POST">
            <div class="modal-body">
              <div class="form-group">
                <label for="recipient-name" class="col-form-label">Заголовок:</label>
                <input type="text" class="form-control" id="recipient-name" name = "title" maxlength="128">
              </div>
              <div class="form-group">
                <label for="message-text" class="col-form-label">Текст:</label>
                <textarea class="form-control" id="message-text" name = "text" rows="15"></textarea>
              </div>
            </div>
            <div class="modal-footer">
              <button type="button" class="btn btn-secondary" data-dismiss="modal">Закрыть</button>
              <button type="submit" class="btn btn-dark">Сохранить</button>
            </div>
          </form>
        </div>
        <div class="tab-pane fade" id="singleUpload" role="tabpanel" aria-labelledby="singleUpload-tab">
          <div class="container mt-3  mb-3">
            <div class="row">
              <div class="col-sm">
              </div>
              <div class="col-sm">
                <form action="<c:url value='/article/upload'/>" enctype="multipart/form-data" method="POST">
                  <div class="input-group">
                    <div class="input-group-prepend">
                      <button class="btn btn-outline-secondary mr-2" type="submit">Upload</button>
                    </div>
                    <label class="custom-file">
                      <input type="file" id="inputGroupFile03" name="file" class="custom-file-input" required>
                      <span class="custom-file-control"></span>
                    </label>
                  </div>
                </form>
              </div>
              <div class="col-sm">
              </div>
            </div>
          </div>
        </div>
      </div>
    </div>
  </div>
</div>
