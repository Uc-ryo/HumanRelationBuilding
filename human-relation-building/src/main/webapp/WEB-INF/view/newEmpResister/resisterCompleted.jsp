<%@page pageEncoding="UTF-8"%>
<html>
<head>
<title>Human RelationBuilding: resister</title>
</head>
<body>
<jsp:include page="../common/header.jsp"/>
<div align="center">
<h1>新規登録完了</h1>
新規登録が完了しました。
</div>
<html:errors/>
<div align="center">
<s:form>
  <input type="submit" name="goTop" value="Topへ">
  <input type="submit" name="goEmployees" value="社員一覧へ">
</s:form>
</div>
<jsp:include page="../common/footer.jsp"/>
</body>
</html>