package relation.action;

import org.seasar.struts.annotation.Execute;

public class ErrorAction {

	/**
	 * エラー画面を表示するメソッド
	 * @return
	 */
	@Execute(validator = false)
	public String index() {
		return "error.jsp";
	}

}
