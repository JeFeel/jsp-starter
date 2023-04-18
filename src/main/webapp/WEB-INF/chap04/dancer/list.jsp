<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%--
<%@ page import="java.util.*" %>
<%@ page import="com.jsp.entity.Dancer" %>

<%
    // request객체에 담긴 리스트 꺼내기
    List<Dancer> dancerList = (List<Dancer>) request.getAttribute("dl");
%>
--%>

<!DOCTYPE html>
<html>

<head>
    <meta charset="UTF-8">
    <title>Insert title here</title>

    <style>
        .del-btn {
            padding: 5px 10px;
            outline: none;
            border: none;
            background: red;
            border-radius: 10px;
            color: #fff;
            margin-left: 10px;
            margin-bottom: 10px;
            cursor: pointer;
        }
        .del-btn:hover {
            border: 1px solid orange;
            opacity: 0.8;
        }
    </style>

</head>

<body>

    <h1>mvc 버전 댄서 목록 뷰</h1>

    <ul id="dancer-list">
        <c:forEach var="d" items="${dl}">
            <li>
                # 이름: <span class="dancer-name">${d.name}</span>,
                # 크루명: ${d.crewName},
                # 레벨: ${d.danceLevel},
                # 페이: ${d.danceLevel.payPerEvent}원
                <button class="del-btn">삭제</button>
            </li>
        </c:forEach>
    </ul>


    <a href="/dancer/join">재등록</a>

    <script>

        const $dancerList = document.getElementById('dancer-list');

        $dancerList.onclick = e => {
            if (!e.target.matches('button')) return;

            // console.log('삭제 버튼 눌렀다!!');

            // 서버로 삭제요청을 보내면서 댄서이름을 전달
            const dancerName 
                = e.target.previousElementSibling.textContent;
            // console.log(dancerName);

            // 서버에 링크로 삭제 요청
            window.location.href='/dancer/delete?name=' + dancerName;

        };


    </script>

</body>

</html>