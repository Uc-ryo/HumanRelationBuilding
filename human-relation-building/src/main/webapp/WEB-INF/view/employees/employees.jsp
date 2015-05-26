<%@ page pageEncoding="UTF-8"%>
<html>
<head>
<title>Human RelationBuilding: emplyee list</title>
</head>
<body>
<jsp:include page="../common/header.jsp"/>
<div align="center">
<h1>社員一覧</h1>
</div>
<div align="center">
  <html:errors/>
  <s:form>
    <input type="text" name="keyWord" value="${keyWord}" placeholder="キーワードを入力してください"/><input type="submit" name="serchEmp" value="検索"><br>
  </s:form>
  <br>
 </div>
 <div align="center">
  <section>
  <table border="1">
    <tr>
      <th>名前</th><th>フリガナ</th><th>生年月日</th><th>携帯番号</th><th>会話済みか</th><th>●詳細</th><th>■更新</th><th>×削除</th>
    </tr>
    <c:forEach var="emp" items="${empCollectionDto.empDtos}">
    <s:form>
      <tr>
        <td>
          ${emp.lastNameKanji}
          ${emp.firstNameKanji}
        </td>
        <td>
          ${emp.lastNameKana}
          ${emp.firstNameKana}
        </td>
        <td>
          ${emp.birthYear}年${emp.birthMonth}月${emp.birthDay}日
        </td>

        <td>
          ${emp.cellphoneNumber}
        </td>
        <td>
          ${emp.stringContactStatus}
        </td>
        <td>
        <div align="center">
          <s:form >
            <input type="hidden" name="empId" value="${emp.empId}">
            <input type="submit" name="goDetailEmp" value="●">
          </s:form>
        </div>
        </td>
        <td>
        <div align="center">
          <s:form method="POST" action="/empUpdate">
            <input type="hidden" name="empId" value="${emp.empId}">
            <input type="submit" name="index" value="■">
          </s:form>
        </div>
        </td>
        <td>
        <div align="center">
          <s:form method="POST" action="/empDelete">
            <input type="hidden" name="empId" value="${emp.empId}">
            <input type="submit" name="index" value="×">
          </s:form>
        </div>
        </td>
      </tr>
    </s:form>
    </c:forEach>
  </table>
  </section>
</div>
<br>
<jsp:include page="../common/footer.jsp"/>
</body>
</html>