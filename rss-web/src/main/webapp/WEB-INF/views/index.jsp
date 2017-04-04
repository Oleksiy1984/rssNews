<%@ page language="java" pageEncoding="UTF-8" contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="string" uri="http://www.springframework.org/tags" %>

<div id="start" class="container content">
    <div class="row">
        <div class="col-md-10 col-md-offset-1">

            <c:choose>
                <c:when test="${page.content == null || page.number == 0}">
                    <div id="post-alert" class="alert alert-warning" role="alert">
                        <spring:message code="page.index.alert.noMessages"/>
                    </div>
                </c:when>
            </c:choose>
            <c:forEach items="${page.content}" var="item">
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



            <div class="paging clearfix">
                <a class="btn pull-left" href="<spring:url value="/?page=0#start"/>"><span>First page</span></a>
                <a class="btn pull-left" href="<spring:url value="/?page=${page.number + 1}#start"/>"><i class="icon-arrow-left2 left"></i><span><string:message
                        code="page.footer.olderPosts"/></span></a>
                <a class="btn pull-right" href="<spring:url value="/?page=${page.totalPages-1}#start"/>"><span>Last page</span></a>
                <a class="btn pull-right" href="<spring:url value="/?page=${page.number - 1}#start"/>"><span><string:message code="page.footer.newerPosts"/></span><i
                        class="icon-arrow-right2 right"></i></a>

            </div>

        </div>
    </div>
</div>



