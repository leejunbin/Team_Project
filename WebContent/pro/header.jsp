<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!-- header.jsp -->
<div id="header">
	<div id="gnb">
		<ul>
			<li><button type="button" class="navyBtn" onClick="location.href='${cp }/info/list'">공지사항</button></li>
			<li><button type="button" class="navyBtn" onClick="location.href='${cp }/SW_pro/QnAlist'">고객만족센터</button></li>
			<li><button type="button" class="navyBtn" onClick="location.href='${cp }/SW_review/Rlist'">구매후기</button></li>
			<li><button type="button" class="navyBtn" onClick="window.open('https://www.ilogen.com/web/personal/tkSearch')">배송조회</button></li>
   		<c:choose>
   	 		<c:when test="${empty sessionScope.mid }"> <%--로그인 안한 경우 --%>
   	 			<li><button type="button" class="navyBtn" onClick="location.href='${cp }/login.do'">로그인</button></li>
   	 			<li><button type="button" class="navyBtn" onClick="location.href='${cp }/insert.do'">회원가입</button></li>
			</c:when>
    		<c:otherwise>      <%--로그인 한 경우 --%>
				<li><button type="button" class="navyBtn" onClick="location.href='${cp }/SW_write/Wlist'">회원문의</button></li>
				<li><button type="button" class="navyBtn" onClick="location.href='${cp }/user/mypage'">마이페이지</button></li>
				
				<li><button type="button" class="navyBtn" onClick="location.href='${cp }/user/logout'"><span style="color:red;font-weight: bold">로그아웃</span></button></li>
            </c:otherwise>
       	</c:choose>
		</ul>
	</div>
	<div id="logo">
		<a href="${cp }/pro/home"><img src="${cp}/images/HS.png" ></a>
	</div>
	<div id="banner">
		<ul>
			<li><button type="button" class="Btn" onClick="location.href='${cp }/go/serch?&level=0'">상품검색</button></li>
			<li><button type="button" class="Btn" onClick="location.href='${cp }/inventory/list?jnum=100&level=0'">귀걸이</button></li>
			<li><button type="button" class="Btn" onClick="location.href='${cp }/inventory/list?jnum=200&level=0'">목걸이</button></li>
			<li><button type="button" class="Btn" onClick="location.href='${cp }/inventory/list?jnum=400&level=0'">팔찌</button></li>
			<li><button type="button" class="Btn" onClick="location.href='${cp }/inventory/list?jnum=300&level=0'">시계</button></li>
		</ul>
	</div>
</div>


