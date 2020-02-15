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
        // function searchViaAjax() {
        //
        //
        //     var lessonName=$('#lesson').val();
        //     $.ajax({
        //         type : "GET",
        //         contentType : "application/json",
        //         url : "/api",
        //         data : {
        //             name: lessonName
        //         },
        //         dataType : 'json',
        //         timeout : 100000,
        //         success : function(data) {
        //             console.log("SUCCESS: ", data);
        //             alert(data);
        //             if (data != null) {
        //                 alert(name)
        //                 $('#content').innerHTML = data;
        //             } else {
        //                 alert('nullr')
        //             }
        //         },
        //         error : function(e) {
        //             alert('no');
        //             console.log("ERROR: ", e);
        //         }
        //     });
        // }
    </script>


</head>
<body>
<!-- header -->
<div class="fixed-top">
    <section>
        <div>
            <%@include file="user/menu.jsp"%>
        </div>
    </section>

    <!-- main -->
    <div class="container-fluid main" id="col">
        <div class="row">
            <%@include file="user/slidebar.jsp"%>

            <div class="col-10 ml-auto content">
                <div class="container-fluid">
                    <div class="row">
                        <div class="col-12" data-spy="scroll" data-target="#list" data-offset="0" id="content">
                            ${lessons}
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
    <!-- End content -->
</div>
</body>
</html>
