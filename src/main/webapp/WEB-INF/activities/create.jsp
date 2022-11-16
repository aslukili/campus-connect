<%--
  Created by IntelliJ IDEA.
  User: aslu
  Date: 11/14/22
  Time: 3:25 PM
  To change this template use File | Settings | File Templates.
--%>
<%--<%@ page contentType="text/html;charset=UTF-8" language="java" %>--%>
<%--<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>--%>

<%--<html>--%>
<%--<head>--%>
<%--  <title>create activity</title>--%>
<%--</head>--%>
<%--<body>--%>
<%--<form method="post" action="insert-activity">--%>
<%--  <div>--%>
<%--    <label>start date</label>--%>
<%--    <input type="date" name="start-date">--%>
<%--  </div>--%>
<%--  <div>--%>
<%--    <label>end date</label>--%>
<%--    <input type="date" name="end-date">--%>
<%--  </div>--%>
<%--  <div>--%>

<%--  </div>--%>
<%--  <div>--%>
<%--    <label >Choose a type for this activity:</label>--%>

<%--  </div>--%>
<%--  <div>--%>
<%--    <label >Choose a Responsible for this activity:</label>--%>

<%--  </div>--%>
<%--  <div>--%>
<%--    <input type="submit" name="submit" value="submit">--%>
<%--  </div>--%>
<%--</form>--%>
<%--</body>--%>
<%--</html>--%>

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
          <h3>Add a new Activity</h3>
        </div>
        <div class="row">
          <div class="col-lg-12">
            <div class="card">
              <div class="card-body">
                <h5 class="card-title">You can edit this information later</h5>
                <form method="post" action="insert-activity" class="needs-validation" novalidate accept-charset="utf-8">
                  <div class="row g-2">
                    <div class="mb-3 col-md-6">
                      <label  class="form-label">Activity Title</label>
                      <input type="text" class="form-control" name="title" placeholder="title" required>
                    </div>
                    <div class="mb-3 col-md-6">
                      <label  class="form-label">Choose a responsible for this activity</label>
                      <select  name="responsible" class="form-control">
                        <jsp:useBean id="responsibles" scope="request" type="java.util.List"/>
                        <c:forEach items="${responsibles}" var="responsible">
                          <option value="${responsible.id}">${responsible.firstName}</option>
                        </c:forEach>
                      </select>
                    </div>
                  </div>
                  <div class="mb-3">
                    <label  class="form-label">Description</label>
                    <textarea name="description" class="form-control" rows="4" cols="50"></textarea>
                  </div>
                  <div class="row g-2">
                    <div class="mb-3 col-md-6">
                      <label  class="form-label">start date</label>
                      <input type="date" class="form-control" name="start-date" required>
                    </div>
                    <div class="mb-3 col-md-6">
                      <label  class="form-label">end date</label>
                      <input type="date" class="form-control" name="end-date" required>
                    </div>
                  </div>
                  <div class="row g-2">
                    <div class="mb-3 col-md-6">
                      <label  class="form-label">Activity state</label>
                      <select  name="activity-state" class="form-control">
                        <c:forEach items="${states}" var="enumValue">
                        <option value="${enumValue}">${enumValue}</option>
                        </c:forEach>
                      </select>
                    </div>
                    <div class="mb-3 col-md-6">
                      <label  class="form-label">Activity type</label>
                      <select  name="activity-type" class="form-control">
                        <c:forEach items="${activityTypes}" var="enumValue">
                          <option value="${enumValue}">${enumValue}</option>
                        </c:forEach>
                      </select>
                    </div>
                  </div>
                  <button type="submit" name="submit" value="submit" class="btn btn-primary"><i class="fas fa-save"></i> Save</button>
                </form>
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
