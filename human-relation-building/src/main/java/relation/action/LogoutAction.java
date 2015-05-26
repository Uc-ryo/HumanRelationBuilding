package relation.action;

import org.seasar.framework.aop.annotation.RemoveSession;
import org.seasar.struts.annotation.Execute;

public class LogoutAction {

	/**
	 * セッションを破棄し、ログアウトする。
	 * @return
	 */
	@Execute(validator = false, redirect=true)
	@RemoveSession(name = "loginDto")
	public String index() {
		return "/login/";
	}

}
