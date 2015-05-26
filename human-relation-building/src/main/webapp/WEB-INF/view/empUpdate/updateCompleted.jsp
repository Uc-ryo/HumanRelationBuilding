<%@page pageEncoding="UTF-8"%>
<html>
<head>
<title>Human RelationBuilding: update</title>
</head>
<body>
<jsp:include page="../common/header.jsp"/>
<div align="center">
<h1>更新完了</h1>
更新が完了しました。
</div>
<html:errors/>
<div align="center">
<s:form>
  <button type="button" onclick="location.href='http://localhost:8080/human-relation-building/'">topへ</button>
  <button type="button" onclick="location.href='http://localhost:8080/human-relation-building/employees/'">社員一覧</button>
</s:form>
</div>
<jsp:include page="../common/footer.jsp"/>
</body>
</html>