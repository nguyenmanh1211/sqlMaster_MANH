<%@include file="/common/taglib.jsp" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>SQL MASTER</title>
    <link rel="stylesheet" href="<c:url value="/template/css/bootstrap.min.css"/>"/>
    <link rel="stylesheet" href="<c:url value="/template/css/style.css"/>"/>
    <link href="<c:url value="https://fonts.googleapis.com/css?family=Dancing+Script&display=swap"/>" rel="stylesheet">
    <link href="<c:url value="https://fonts.googleapis.com/css?family=Noto+Serif&display=swap" />" rel="stylesheet">
    <link href="<c:url value="https://fonts.googleapis.com/css?family=Courier+Prime&display=swap"/>" rel="stylesheet">
    <link href="<c:url value="https://fonts.googleapis.com/css?family=Playfair+Display&display=swap"/>"
          rel="stylesheet">
    <script src="<c:url value="/template/js/jquery-3.4.1.min.js"/>"></script>
    <script src="<c:url value="/template/js/popper.min.js"/>"></script>
    <script src="<c:url value="/template/js/bootstrap.min.js"/>"></script>
    <script src="<c:url value="/template/js/style.js"/>"></script>
    <script src="<c:url value="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"/>"></script>
        <script>
        function get(lessonId) {
            $('#lesson').val(lessonId);
            console.log($('#lesson').val());
            var  id =lessonId;
            $.ajax({
                type : "GET",
                url : "http://localhost:8080/api?id="+id+" ",
                dataType : "json",
                success : function(response) {

                    // alert("ok"+response.nameLesson+" "+response.tutorial);
                    a = response.tutorial

                    $('#content').html(a);
                    document.getElementById("content").innerHTML = a;


                },
                error : function(response) {
                    console.log("failed");
                    console.log(response);
                }
            });
        }
        $(document).on('click','ul li a',function () {
            $('a').removeClass('active')
            $(this).addClass('active')
        })
    </script>


</head>
<body>
<!-- header -->
<div class="fixed-top">
    <section>
        <%@include file="user/menu.jsp" %>
    </section>
</div>
<!-- main -->

<div class="container-fluid main" id="col">
    <div class="row">
        <div class="cola scroll">
            <!-- slidebar -->
            <ul class="sidebar navbar-nav">
                <li class="nav-item dropdown submenu" id="lia">
                    <c:forEach items="${lessons}" var="lesson">
                        <a class="nav-link subcontent xaxa" id="lesson" onclick="get(${lesson.id})">
                                ${lesson.nameLesson}
                        </a>
                    </c:forEach>
                </li>
            </ul>
        </div>
    </div>
    <div class="col-10 ml-auto content">
        <div class="container-fluid">
            <div class="row">
                <div class="col-12" data-spy="scroll" data-target="#list" data-offset="0" id="content">

                </div>
            </div>
        </div>
    </div>

    <!-- End content -->
</div>


</body>
</html>
