<%@page pageEncoding="UTF-8"%>
<html>
<head>
<title>Human RelationBuilding: delete</title>
</head>
<body>
<jsp:include page="../common/header.jsp"/>
<div align="center">
<h1>削除：確認</h1>
</div>
<div align="center">
<html:errors/>

  本当に削除しますか？
</div>
<div align="center">
  <table>
    <s:form>
      <tr>
        <td>
          ●名前
        </td>
        <td>
          ${empDeleteDto.lastNameKanji}
          ${empDeleteDto.firstNameKanji}
        </td>
      </tr>
      <tr>
        <td>
          ●フリガナ
        </td>
        <td>
          ${empDeleteDto.lastNameKana}
          ${empDeleteDto.firstNameKana}
        </td>
      </tr>
      <tr>
        <td>
          ●生年月日
        </td>
        <td>
          ${empDeleteDto.birthYear}年${empDeleteDto.birthMonth}月${empDeleteDto.birthDay}日
        </td>
      </tr>
      <tr>
        <td>
          ●携帯番号
        </td>
        <td>
          ${empDeleteDto.cellphoneNumber}
        </td>
      </tr>
      <tr>
        <td>
          ●会話済みか<br>
        </td>
        <td>
          ${empDeleteDto.stringContactStatus}
        </td>
      </tr>
    </s:form>
  </table>
  <div align="center">
    <s:form>
      <input type="hidden" name="empId" value="${empId}">
      <button type="button" onclick="location.href='../employees/'">戻る</button>
      <input type="submit" name="goDeleteCompleted" value="削除">
    </s:form>
  </div>

    </div>
</body>
</html>