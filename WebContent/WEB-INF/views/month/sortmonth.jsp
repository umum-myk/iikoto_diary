<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<c:import url="../layout/app.jsp">
	<c:param name="content">


		<table id="diary_list">
			<tbody>
				<tr>
					<th class="diary_text">いいこと一覧</th>
					<th class="diary_date">日付</th>
					<th class="diary_iine">スタンプ</th>
				</tr>
				<c:forEach var="sort" items="${sort_month}"
					varStatus="status">
					<tr class="row${status.count % 2}">
						<td class="diary_text">${sort.bodytext}</td>
						<td class="diary_date"><fmt:formatDate
								value='${sort.createDate}' pattern='yyyy-MM-dd' /></td>
						<td class="diary_iine"><c:choose>
								<c:when test="${sort.iine == 0}">
									<form method="POST" action="<c:url value="/create/like" />">
										<input type="image"
											src="/iikoto_diary/images/icon_white_star.png" width="20"
											height="20"> <input type="hidden" name="id"
											value="${sort.id}">
									</form>
								</c:when>
								<c:when test="${sort.iine != 0}">
									<img src="/iikoto_diary/images/icon_yellow_star.png" width="20"
										height="20">
								</c:when>
								<c:otherwise>
								一致しません。
								</c:otherwise>
							</c:choose>
					</tr>
				</c:forEach>
			</tbody>
		</table>

<nav aria-label="...">
  <ul class="pagination pagination-lg">
			<li>（全 ${diarys_count} 件）</li>
			<c:forEach var="i" begin="1" end="${((diarys_count - 1) / 10) + 1}"
				step="1">
				<c:choose>
					<c:when test="${i == page}">
                    <li class="page-item disabled"><a class="page-link"><c:out value="${i}" /></a></li>&nbsp;
                    </c:when>
					<c:otherwise>
					<li class="page-item">
						<a class="page-link" href="<c:url value='/sort?page=${i}&mon=${mon}' />"><c:out value="${i}" /></a></li>&nbsp;
                    </c:otherwise>
				</c:choose>
			</c:forEach>
  </ul>
</nav>

		<p>
			<a href="<c:url value="/index" />">一覧に戻る</a>
		</p>

	</c:param>
</c:import>