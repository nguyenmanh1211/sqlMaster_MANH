<%@include file="/common/taglib.jsp" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>

<div class="col-2 scroll">
    <!-- slidebar -->
    <ul class="sidebar navbar-nav">
        <li class="nav-item dropdown submenu">
            <c:forEach items="${lessons}" var="lesson">
                <a class="nav-link subcontent" href="" id="lesson">
                        ${lesson.name_lesson}
                </a>
            </c:forEach>
        </li>
    </ul>
    <!-- end slidebar -->
</div>