<%@ page language="java" pageEncoding="UTF-8" contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="string" uri="http://www.springframework.org/tags" %>

<div id="start" class="container content">
    <div class="row">
        <div class="col-md-10 col-md-offset-1">
<h2 style="text-align: center"><spring:message code="page.index.alert.result"/> "${search}"</h2>
            <c:if test="${empty sort}">
                <div id="post-alert" class="alert alert-warning" role="alert">
                    <spring:message code="page.index.alert.noSearch"/>
                </div>
            </c:if>
            <c:forEach items="${sort}" var="item">
                <article class="clearfix">
                    <div class="post-date">
                        <fmt:formatDate value="${item.publishedDate}" pattern="dd-MM-yyyy HH:mm:ss"/>
                    </div>
                    <h2>
                        <a href="<c:out value="${item.link}"/>" target="_blank">${item.title}</a>
                    </h2>

                    <p> ${item.description}
                        <a href="<c:out value="${item.link}"/>" target="_blank"><spring:message code="page.index.readMore"/></a>
                    </p>
                </article>
            </c:forEach>




        </div>
    </div>
</div>



