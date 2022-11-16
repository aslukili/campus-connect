<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!doctype html>
<html lang="en">
<head>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
  <meta http-equiv="X-UA-Compatible" content="IE=edge">
  <title>Tables | Bootstrap Simple Admin Template</title>
  <link href="${pageContext.request.contextPath}/assets/vendor/fontawesome/css/fontawesome.min.css" rel="stylesheet">
  <link href="${pageContext.request.contextPath}/assets/vendor/fontawesome/css/solid.min.css" rel="stylesheet">
  <link href="${pageContext.request.contextPath}/assets/vendor/fontawesome/css/brands.min.css" rel="stylesheet">
  <link href="${pageContext.request.contextPath}/assets/vendor/bootstrap/css/bootstrap.min.css" rel="stylesheet">
  <link href="${pageContext.request.contextPath}/assets/vendor/datatables/datatables.min.css" rel="stylesheet">
  <link href="${pageContext.request.contextPath}/assets/css/master.css" rel="stylesheet">

</head>

<body>
<div class="wrapper">
  <!-- sidebar navigation component -->
  <nav id="sidebar" class="active">
    <div class="sidebar-header">
      <img src="../assets/img/bootstraper-logo.png" alt="javaclogo" class="app-logo">
    </div>
    <ul class="list-unstyled components text-secondary">
      <li>
        <a href="dashboard"><i class="fas fa-home"></i>Dashboard</a>
      </li>
      <li>
        <a href="activities"><i class="fas fa-file-alt"></i>Activities</a>
      </li>
      <li>
        <a href="exercises"><i class="fas fa-table"></i>Exercises</a>
      </li>
      <li>
        <a href="responsibles"><i class="fas fa-chart-bar"></i>Responsibles</a>
      </li>
      <li>
        <a href="participants"><i class="fas fa-icons"></i>Participants</a>
      </li>
    </ul>
  </nav>
  <!-- end of sidebar component -->
  <div id="body" class="active">
    <!-- navbar navigation component -->
    <nav class="navbar navbar-expand-lg navbar-white bg-white">
      <button type="button" id="sidebarCollapse" class="btn btn-light">
        <i class="fas fa-bars"></i><span></span>
      </button>
    </nav>
    <!-- end of navbar navigation -->
    <div class="content">
      <div class="container">
        <div class="page-title">
          <h3>Activities table</h3>
        </div>
        <div class="row">
          <div class="col-md-12 col-lg-12">
            <div class="card">
              <div class="card-header d-flex justify-content-between"><p>to view more info about an activity, click edit button</p> <a class="link-primary" href="create-activity">add activity</a></div>
              <div class="card-body">
                <p class="card-title"></p>
                <table class="table table-hover" id="dataTables-example" width="100%">
                  <thead>
                  <tr>
                    <th>Title</th>
                    <th>Description</th>
                    <th>Start Date</th>
                    <th>End Date</th>
                    <th>Type</th>
                    <th>State</th>
                    <th>Responsible</th>
                    <th>Actions</th>
                  </tr>
                  </thead>
                  <tbody>
                  <jsp:useBean id="activities" scope="request" type="java.util.List"/>
                  <c:forEach items="${activities}" var="activity">
                    <tr>
                      <td><c:out value="${activity.title}" /></td>
                      <td><c:out value="${activity.description}" /></td>
                      <td><c:out value="${activity.startDate}" /></td>
                      <td><c:out value="${activity.endDate}" /></td>
                      <td><c:out value="${activity.activityType}" /></td>
                      <td><c:out value="${activity.state}" /></td>
                      <td><c:out value="${activity.responsible.getFirstName()}" /></td>
                      <td>
                          <%--          <a href="activity?id=<c:out value='${activity.id}' />">view</a>--%>
                        &nbsp;&nbsp;&nbsp;&nbsp;
                        <a class="link-danger" href="delete-activity?id=<c:out value='${activity.id}' />">Delete</a>
                        &nbsp;&nbsp;
                        <a class="link-warning" href="edit-activity?id=<c:out value='${activity.id}' />">Edit</a>

                      </td>
                    </tr>
                  </c:forEach>
                  </tbody>
                </table>
              </div>
            </div>
          </div>
        </div>
      </div>
    </div>
  </div>
</div>
<script src="${pageContext.request.contextPath}/assets/vendor/jquery/jquery.min.js"></script>
<script src="${pageContext.request.contextPath}/assets/vendor/bootstrap/js/bootstrap.bundle.min.js"></script>
<script src="${pageContext.request.contextPath}/assets/vendor/datatables/datatables.min.css"></script>
<script src="${pageContext.request.contextPath}/assets/js/initiate-datatables.js"></script>
<script src="${pageContext.request.contextPath}/assets/js/script.js"></script>

</body>

</html>
