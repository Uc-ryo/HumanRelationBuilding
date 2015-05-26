<%@ page pageEncoding="UTF-8"%>
<html>
<head>
<title>Human RelationBuilding: session time out</title>
</head>
<body>
<h1>セッションタイムアウト</h1>
時間経過によりセッションが切れました。<br>
再度ログインをしてください。
<html:errors/>
<s:form>
  <input type="submit" name="goLogin" value="ログイン画面へ">
</s:form>
</body>
</html>