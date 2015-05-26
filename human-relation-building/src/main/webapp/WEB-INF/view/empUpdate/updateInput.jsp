<%@ page pageEncoding="UTF-8"%>
<html>
<head>
<title>Human RelationBuilding: update</title>
</head>
<body>
<jsp:include page="../common/header.jsp"/>
<div align="center">
<h1>更新</h1>
</div>

<s:form>
<html:hidden property="empId"/>
<div align="center">
<html:errors/>
    <dl>
    <dt>名前</dt>
      <dd>
      <html:text property="lastNameKanji" value="${empUpdateForm.lastNameKanji != null ? empUpdateForm.lastNameKanji : empUpdateDto.lastNameKanji}"/>
      <html:text property="firstNameKanji" value="${empUpdateForm.firstNameKanji != null ? empUpdateForm.firstNameKanji : empUpdateDto.firstNameKanji}"/>
      </dd>
    </dl>
    <dl>
    <dt>フリガナ</dt>
      <dd>
      <html:text property="lastNameKana" value="${empUpdateForm.lastNameKana != null ? empUpdateForm.lastNameKana : empUpdateDto.lastNameKana}"/>
      <html:text property="firstNameKana" value="${empUpdateForm.firstNameKana != null ? empUpdateForm.firstNameKana : empUpdateDto.firstNameKana}"/>
      </dd>
    </dl>
    <dl>
    <dt>生年月日</dt>
    <dd>
        <select name="birthYear">
            <option value="">----</option>
            <c:forEach begin="1900" end="2000" step="1" varStatus="status">
                <option value='${status.index}' ${(empUpdateForm.birthYear != null ? empUpdateForm.birthYear : empUpdateDto.birthYear) == status.index ? 'selected="selected"' : ''}>${status.index}</option>
                <!--option value='${status.index}' ${updateEmpDto.birthYear == status.index ? 'selected="selected"' : ''}>${status.index}</option-->
            </c:forEach>
        </select> 年-

        <select name="birthMonth">
            <option value="">----</option>
            <c:forEach begin="1" end="12" step="1" varStatus="status">
                <option value='${status.index}' ${(empUpdateForm.birthMonth != null ? empUpdateForm.birthMonth : empUpdateDto.birthMonth) == status.index ? 'selected="selected"' : ''}>${status.index}</option>
                <!--option value='${status.index}' ${updateEmpDto.birthMonth == status.index ? 'selected="selected"' : ''}>${status.index}</option-->
            </c:forEach>
        </select> 月

        <select name="birthDay">
            <option value="">----</option>
            <c:forEach begin="1" end="31" step="1" varStatus="status">
                <option value='${status.index}' ${(empUpdateForm.birthDay != null ? empUpdateForm.birthDay : empUpdateDto.birthDay) == status.index ? 'selected="selected"' : ''}>${status.index}</option>
                <!--option value='${status.index}' ${updateEmpDto.birthDay == status.index ? 'selected="selected"' : ''}>${status.index}</option-->
            </c:forEach>
        </select> 日
    </dd>
    </dl>
    <dl>
    <dt>電話番号(ハイフンなし (例)：999-9999-9999 → 99999999999)</dt>
      <dd>
      <html:text property="cellphoneNumber" value="${empUpdateForm.cellphoneNumber != null ? empUpdateForm.cellphoneNumber : empUpdateDto.cellphoneNumber}"/>
      </dd>
    </dl>
    <dl>
    <dt>会話をしたことがありますか？</dt>
      <dd>
        <input type="radio" name="contactStatus" value="0" ${empUpdateDto.stringContactStatus == 'ある' ? 'checked="checked"' : ''}>ある
        <input type="radio" name="contactStatus" value="1" ${empUpdateDto.stringContactStatus == 'ない' ? 'checked="checked"' : ''}>ない
      </dd>
    </dl>
    <dl>
    <dt>メモ</dt>
      <dd>
      <html:textarea property="memo" value="${empUpdateForm.memo != null ? empUpdateForm.memo : empUpdateDto.memo}"/><br>
      </dd>
    </dl>
  </div>
  <div align="center">
  <input type="hidden" name="empId" value="${empUpdateDto.empId}">
  <button type="button" onclick="location.href='http://localhost:8080/human-relation-building/employees/'">社員一覧</button>
  <input type="submit" name="goUpdateConfirm" value="確認画面へ">
  </div>
</s:form>
<jsp:include page="../common/footer.jsp"/>
</body>
</html>