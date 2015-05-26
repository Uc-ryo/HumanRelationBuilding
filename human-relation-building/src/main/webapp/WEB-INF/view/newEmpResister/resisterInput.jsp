<%@ page pageEncoding="UTF-8"%>
<html>
<head>
<title>Human RelationBuilding: resister</title>
</head>
<body>
<jsp:include page="../common/header.jsp"/>

<div align="center">
<h1>新規登録</h1>
</div>

<html:errors/>
<div align="center">
<s:form>
  <dl>
    <dt>名前</dt>
      <dd>
      <input type="text" name="lastNameKanji" value="${newEmpResisterForm.lastNameKanji}" placeholder="姓"/>
      <input type="text" name="firstNameKanji" value="${newEmpResisterForm.firstNameKanji}" placeholder="名"/>
      </dd>
  </dl>
  <dl>
    <dt>フリガナ</dt>
      <dd>
      <input type=text name="lastNameKana" value="${newEmpResisterForm.lastNameKana}" placeholder="セイ"/>
      <input type=text name="firstNameKana" value="${newEmpResisterForm.firstNameKana}" placeholder="メイ"/><br>
      </dd>
  </dl>
  <dl>
    <dt>生年月日</dt>
      <dd>
        <select name="birthYear">
            <option value="">----</option>
            <c:forEach begin="1900" end="2000" step="1" varStatus="status">
                <option value='${status.index}' ${(newEmpResisterForm.birthYear != null ? newEmpResisterForm.birthYear : newEmpResisterDto.birthYear) == status.index ? 'selected="selected"' : ''}>${status.index}</option>
                <!--option value='${status.index}' ${updateEmpDto.birthYear == status.index ? 'selected="selected"' : ''}>${status.index}</option-->
            </c:forEach>
        </select> 年

        <select name="birthMonth">
            <option value="">----</option>
            <c:forEach begin="1" end="12" step="1" varStatus="status">
                <option value='${status.index}' ${(newEmpResisterForm.birthMonth != null ? newEmpResisterForm.birthMonth : newEmpResisterDto.birthMonth) == status.index ? 'selected="selected"' : ''}>${status.index}</option>
                <!--option value='${status.index}' ${updateEmpDto.birthMonth == status.index ? 'selected="selected"' : ''}>${status.index}</option-->
            </c:forEach>
        </select> 月

        <select name="birthDay">
            <option value="">----</option>
            <c:forEach begin="1" end="31" step="1" varStatus="status">
                <option value='${status.index}' ${(newEmpResisterForm.birthDay != null ? newEmpResisterForm.birthDay : newEmpResisterDto.birthDay) == status.index ? 'selected="selected"' : ''}>${status.index}</option>
                <!--option value='${status.index}' ${updateEmpDto.birthDay == status.index ? 'selected="selected"' : ''}>${status.index}</option-->
            </c:forEach>
        </select> 日
      </dd>
  </dl>
  <dl>
    <dt>電話番号(ハイフンなし (例)：999-9999-9999 → 99999999999)</dt>
      <dd>
      <input type=text name="cellphoneNumber" value="${newEmpResisterForm.cellphoneNumber}"/>
      </dd>
  </dl>
  <dl>
    <dt>会話をしたことがありますか？</dt>
      <dd>
      <input type="radio" name="contactStatus" value="0">ある
      <input type="radio" name="contactStatus" value="1" checked="checked">ない<br>
      </dd>
  </dl>
  <dl>
    <dt>メモ</dt>
      <dd>
      <html:textarea property="memo" value="${newEmpResisterForm.memo}"/><br>
      </dd>
  </dl>





  <input type="submit" name="goTop" value="戻る">
  <input type="submit" name="goResisterConfirm" value="確認画面へ">
</s:form>
</div>
<jsp:include page="../common/footer.jsp"/>
</body>
</html>