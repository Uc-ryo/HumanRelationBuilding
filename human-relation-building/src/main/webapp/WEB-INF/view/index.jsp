<%@ page pageEncoding="UTF-8"%>
<html>
<head>
<title>Human RelationBuilding: Top</title>
</head>
<body>
<jsp:include page="common/header.jsp"/>

<div align="center">
<h1>Human RelationBuilding</h1>
</div>
<br>
<br>
<div align="center">
<section>
  会話済みの社員数
  /
  登録人数<br>
  ${contactedEmpCount}
  /
  ${allEmpCount}..................................${contactedEmpRate}%<br>
  <br>
  <br>
  未会話の社員数
  /
  登録人数<br>
  ${notContactedEmpCount}
  /
  ${allEmpCount}..................................${notContactedEmpRate}%<br>
</section>
<br>
<html:errors/>
<s:form>
  <button type="button" onclick="location.href='http://localhost:8080/human-relation-building/employees/'">社員一覧</button>
  <button type="button" onclick="location.href='http://localhost:8080/human-relation-building/newEmpResister/'">新規登録</button>
</s:form>
</div>
<jsp:include page="common/footer.jsp"/>
</body>
</html>