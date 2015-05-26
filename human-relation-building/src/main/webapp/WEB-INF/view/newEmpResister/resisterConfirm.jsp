<%@page pageEncoding="UTF-8"%>
<html>
<head>
<title>Human RelationBuilding: resister</title>
</head>
<body>
<jsp:include page="../common/header.jsp"/>
<div align="center">
<h1>新規登録：確認</h1>
</div>
<html:errors/>
<div align="center">
  <table>
    <tr>
      <td>
        ●名前
      </td>
      <td>
        ${f:h(newEmpResisterDto.lastNameKanji)}
        ${f:h(newEmpResisterDto.firstNameKanji)}
      </td>
    </tr>
    <tr>
      <td>
        ●フリガナ
      </td>
      <td>
        ${f:h(newEmpResisterDto.lastNameKana)}
        ${f:h(newEmpResisterDto.firstNameKana)}
      </td>
    </tr>
    <tr>
      <td>
        ●生年月日
      </td>
      <td>
        ${f:h(newEmpResisterDto.birthYear)}年${f:h(newEmpResisterDto.birthMonth)}月${f:h(newEmpResisterDto.birthDay)}日
      </td>
    </tr>
    <tr>
      <td>
        ●携帯番号
      </td>
      <td>
        ${f:h(newEmpResisterDto.cellphoneNumber)}
      </td>
    </tr>
    <tr>
      <td>
        ●会話
      </td>
      <td>
        ${f:h(newEmpResisterDto.strContactStatus)}
      </td>
    </tr>
    <tr>
      <td>
        ●メモ
      </td>
      <td>
        ${f:h(newEmpResisterDto.memo)}
      </td>
    </tr>
  </table>
  </div>
<s:form>
  <div align="center">
    <input type="submit" name="goBackInput" value="戻る">
    <input type="submit" name="goResisterConpleted" value="登録">
  </div>
</s:form>

</body>
</html>