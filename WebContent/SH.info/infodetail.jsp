<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!-- /SH.info/infodetail.jsp -->
<div id="main">
		<h1 style="font-size: 5em;">공지사항</h1>
		<hr>
		<table style="width: 60%; height:30%;  text-align: center; margin: auto;">
		<tr>
			<th style="font-size: 1.5em;  font-weight:bold; text-align:center; padding-left: 5px; width:10%; ">No.</th>
			<td><input type="text" name="infotitle" value="${vo.infonum }" readonly="readonly" style="width: 90%; height: 50px; font-size: large; padding-left: 10px;"></td>
		</tr>
		<tr>
			<th style="font-size: 1.5em;  font-weight:bold; text-align:center; padding-left: 5px; width:10%; ">제목</th>
			<td><input type="text" name="infotitle" value="${vo.infotitle }" readonly="readonly" style="width: 90%; height: 50px; font-size: large; padding-left: 10px;"></td>
		</tr>
		<tr>
			<th style="font-size: 1.5em;  font-weight:bold; text-align:center; padding-left: 5px; width:10%; ">내용</th>
			<td><textarea rows="30" cols="100" readonly="readonly" style="width: 90%; height: 200px; font-size: large;"> ${vo.infocontent }</textarea></td>
		</tr>
		<tr>
			<td colspan="2" style="text-align: right;">
			<c:choose >
				<c:when test="${sessionScope.mid=='admin'}"><%--운영자로 로그인한 경우 --%>
					<a href="${cp }/info/delete?infonum=${vo.infonum}">삭제</a>	
					<a href="${cp }/info/update?infonum=${vo.infonum}">수정</a>
				</c:when>			
			</c:choose>	
			<a href="${cp }/info/list">목록으로</a>	
			</td>
		</tr>
	</table>

</div>