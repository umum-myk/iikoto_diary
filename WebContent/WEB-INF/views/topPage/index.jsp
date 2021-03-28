<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<c:import url="../layout/app.jsp">
	<c:param name="content">

<div class="pb-3">
    <div class="row">
<div class="col-10">
		<form method="POST" action="<c:url value='/index' />"
			class="position1">
			<div class="form-row">
				<div class="col-5">
					<input name="iikoto" class="form-control"
						placeholder="今日のいいこと書き込みましょう！">
				</div>
				<div class="col">
					<button type="submit" class="btn btn-primary">記録</button>
				</div>
			</div>
		</form>
    </div>

<div class="col-2">
	  <form method="GET" class="d-flex" action="<c:url value="/search" />">
        <input class="form-control me-2" type="search" placeholder="Search" aria-label="Search" name="search" value="${search}">
        <button class="btn btn-outline-success" type="submit">Search</button>
      </form>
</div>
    </div>
</div>

		<table id="diary_list">
			<tbody>
				<tr>
					<th class="diary_text">いいこと一覧</th>
					<th class="diary_date">日付</th>
					<th class="diary_iine">スタンプ</th>
				</tr>
				<c:forEach var="diary" items="${diarys}" varStatus="status">
					<tr class="row${status.count % 2}">
						<td class="diary_text">${diary.bodytext}</td>
						<td class="diary_date"><fmt:formatDate
								value='${diary.createDate}' pattern='yyyy-MM-dd' /></td>
						<td class="diary_iine"><c:choose>
								<c:when test="${diary.iine == 0}">
									<form method="POST" action="<c:url value="/create/like" />">
										<input type="image" src="/iikoto_diary/images/icon_white_star.png" width="20" height="20">
										<input type="hidden" name="id" value="${diary.id}">
									</form>
								</c:when>
								<c:when test="${diary.iine != 0}">
									<img src="/iikoto_diary/images/icon_yellow_star.png" width="20" height="20">
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
            <c:forEach var="i" begin="1" end="${((diarys_count - 1) / 10) + 1}" step="1">
                <c:choose>
                    <c:when  test="${i == page}">
                    <li class="page-item disabled"><a class="page-link"><c:out value="${i}" /></a></li>&nbsp;
                    </c:when>
                    <c:otherwise>
                    <li class="page-item">
                        <a class="page-link" href="<c:url value='/index?page=${i}' />"><c:out value="${i}" /></a></li>&nbsp;
                    </c:otherwise>
                </c:choose>
            </c:forEach>
  </ul>
</nav>


	</c:param>
</c:import>