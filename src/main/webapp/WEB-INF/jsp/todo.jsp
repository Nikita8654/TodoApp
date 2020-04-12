<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%--
  Created by IntelliJ IDEA.
  User: Nikita
  Date: 08-04-2020
  Time: 23:29
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<
<head>
    <title>Todo Management</title>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css"
          integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm"
          crossorigin="anonymous">
</head>
<body>
<div class="container">
    <div class="navigation>">
        <nav role="navigation" class="navbar navbar-expand-lg navbar-light bg-light">
            <a class="navbar-brand" href="#">Todo</a>
            <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarSupportedContent"
                    aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
                <span class="navbar-toggler-icon"></span>
            </button>
            <div class="collapse navbar-collapse">
                <div class="collapse navbar-collapse" id="navbarSupportedContent">
                    <ul class="navbar-nav mr-auto">
                        <li class="nav-item active">
                            <a class="nav-link" href="/">Home <span class="sr-only">(current)</span></a>
                        </li>
                        <li class="nav-item">
                            <a class="nav-link" href="/list-todos">Todos</a>
                        </li>
                        <li class="nav-item">
                            <a class="nav-link" href="/logout">Logout</a>
                        </li>
                    </ul>
                </div>
            </div>
        </nav>
    </div>
    <div>
    </div>
    <div class="row">
        <div class="col-md-6 col-md-offset-3 ">
            <div class="panel panel-primary">
                <div class="panel-heading">Add TODO</div>
                <div class="panel-body">
                    <form:form method="post" modelAttribute="todo" >
                        <form:hidden path="id" />
                        <fieldset class="form-group">
                            <form:label path="description">Description</form:label>
                            <form:input path="description" type="text" class="form-control"
                                        required="required" />
                            <form:errors path="description" cssClass="text-warning" />
                        </fieldset>

                        <fieldset class="form-group">
                            <form:label path="targetDate">Target Date</form:label>
                            <form:input path="targetDate" type="text" class="form-control"
                                        required="required" />
                            <form:errors path="targetDate" cssClass="text-warning" />
                        </fieldset>

                        <button type="submit" class="btn btn-success">Save</button>
                    </form:form>
                </div>
            </div>
        </div>
    </div>
</div>
</body>
</html>
