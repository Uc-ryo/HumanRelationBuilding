<%@page pageEncoding="UTF-8"%>
<html>
<head>
<title>Human RelationBuilding: detailEmp</title>
</head>
<body>
<jsp:include page="../common/header.jsp"/>
<div align="center">
<h1>詳細</h1>
</div>
<html:errors/>
<div align="center">
  <table>
    <tr>
      <td>名前</td>
      <td>
          ${f:h(empDto.lastNameKanji)}
          ${f:h(empDto.firstNameKanji)}
      </td>
    </tr>
    <tr>
      <td>フリガナ</td>
        <td>
          ${f:h(empDto.lastNameKana)}
          ${f:h(empDto.firstNameKana)}
        </td>
    </tr>
    <tr>
      <td>生年月日</td>
      <td>${f:h(empDto.birthYear)}年${f:h(empDto.birthMonth)}月${f:h(empDto.birthDay)}日</td>
    <tr>
      <td>携帯番号</td>
      <td>${f:h(empDto.cellphoneNumber)}</td>
    </tr>
    <tr>
      <td>会話済みか</td>
      <td>${f:h(empDto.stringContactStatus)}</td>
    </tr>
    <tr>
      <td>メモ</td>
      <td>${f:h(empDto.memo)}</td>
    </tr>
  </table>
  <s:form method="POST" action="/empUpdate">
    <input type="hidden" name="empId" value="${empId}">
    <input type="submit" name="goUpdate" value="更新">
  </s:form>
  <s:form method="POST" action="/empDelete">
    <input type="hidden" name="empId" value="${empId}">
    <input type="submit" name="goDelete" value="削除">
  </s:form>
  <s:form>
    <input type="submit" name="goEmployees" value="戻る">
  </s:form>
</div>

</body>
</html>