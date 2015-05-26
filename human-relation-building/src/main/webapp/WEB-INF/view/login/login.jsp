<%@ page pageEncoding="UTF-8"%>
<html>
<head>
<title>Human RelationBuilding: Login</title>
</head>
<body>
<div align="center">
<h1>Login</h1>
</div>
<html:errors/>
${userDto.errorMasage}
<div align="center">
<s:form>
  <table>
    <tr><td>ユーザID</td><td><html:text property="userId"/></td></tr>
    <tr><td>パスワード</td><td><html:password property="password"/></td></tr>
  </table>
  <input type="submit" name="goTop" value="Login">
</s:form>
</div>
</body>
</html>