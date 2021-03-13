<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<c:import url="../layout/app.jsp">
    <c:param name="content">

        <h2>いいこと記憶を見て元気になりましょう！</h2>
        <h3>いいこと一覧</h3>
		<table id="diary_list">
			<tbody>
				<tr>
					<th class="diary_text">氏名</th>
					<th class="diary_date">日付</th>
				</tr>
				<c:forEach var="diary" items="${diarys}" varStatus="status">
					<tr class="row${status.count % 2}">
						<td class="diary_text">${diary.bodytext}</td>
						<td class="diary_date"><fmt:formatDate value='${diary.createDatetime}' pattern='yyyy-MM-dd' /></td>
					</tr>
				</c:forEach>
			</tbody>
		</table>

		<form method="POST" action="<c:url value='/index' />">
			<textarea name="iikoto" rows="10" cols="50"></textarea>
			<button type="submit" class="btn btn-outline-primary">記録</button>
		</form>

		<div id="pagination">
            （全 ${diarys_count} 件）<br />
            <c:forEach var="i" begin="1" end="${((diarys_count - 1) / 10) + 1}" step="1">
                <c:choose>
                    <c:when test="${i == page}">
                        <c:out value="${i}" />&nbsp;
                    </c:when>
                    <c:otherwise>
                        <a href="<c:url value='/index?page=${i}' />"><c:out value="${i}" /></a>&nbsp;
                    </c:otherwise>
                </c:choose>
            </c:forEach>
        </div>
    </c:param>
</c:import>