<%@page pageEncoding="UTF-8"%>
<html>
<head>
<title>Human RelationBuilding: update</title>
</head>
<body>
<jsp:include page="../common/header.jsp"/>
<div align="center">
<h1>更新：確認</h1>
</div>
<html:errors/>
<s:form>
<div align="center">
  <table>
    <tr>
      <td>
        ●名前
      </td>
      <td>
        ${f:h(empUpdateDto.lastNameKanji)}&nbsp${f:h(empUpdateDto.firstNameKanji)}<br>
      </td>
    </tr>
    <tr>
      <td>
        ●フリガナ
      </td>
      <td>
        ${f:h(empUpdateDto.lastNameKana)}&nbsp${f:h(empUpdateDto.firstNameKana)}<br>
      </td>
    </tr>
    <tr>
      <td>
        ●生年月日
      </td>
      <td>
        ${f:h(empUpdateDto.birthYear)}年${f:h(empUpdateDto.birthMonth)}月${f:h(empUpdateDto.birthDay)}日<br>
      </td>
    </tr>
    <tr>
      <td>
        ●携帯番号
      </td>
      <td>
        ${f:h(empUpdateDto.cellphoneNumber)}<br>
      </td>
    </tr>
    <tr>
      <td>
        ●会話したかどうか
      </td>
      <td>
        ${f:h(empUpdateDto.stringContactStatus)}<br>
      </td>
    </tr>
    <tr>
      <td>
        ●メモ
      </td>
      <td>
        ${f:h(empUpdateDto.memo)}<br>
      </td>
    </tr>
  </table>
  </div>
  <div align="center">
  <input type="hidden" name="empId" value="${f:h(empUpdateDto.empId)}">
  <input type="submit" name="goBackInput" value="戻る">
  <input type="submit" name="goUpdateCompleted" value="登録">
  </div>
</s:form>
</body>
</html>