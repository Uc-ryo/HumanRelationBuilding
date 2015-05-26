<%@page pageEncoding="UTF-8"%>
<html>
<head>
<title>Human RelationBuilding: delete</title>
</head>
<body>
<jsp:include page="../common/header.jsp"/>

<div align="center">
  <h1>削除完了</h1>
  削除が完了しました。
</div>
<div align="center">
<html:errors/>
</div>
<div align="center">
<s:form>
  <a href="http://localhost:8080/human-relation-building/">topへ</a>
  <a href="http://localhost:8080/human-relation-building/employees/">社員一覧</a>
</s:form>
</div>
<jsp:include page="../common/footer.jsp"/>
</body>
</html>