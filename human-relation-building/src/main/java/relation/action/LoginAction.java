package relation.action;

import javax.annotation.Resource;

import org.seasar.framework.log.Logger;
import org.seasar.struts.annotation.ActionForm;
import org.seasar.struts.annotation.Execute;

import relation.dto.LoginDto;
import relation.dto.UserDto;
import relation.form.LoginForm;
import relation.interceptor.ExceptionInterceptor;
import relation.service.UserService;

public class LoginAction {

	private static final Logger logger = Logger.getLogger(ExceptionInterceptor.class);

	@ActionForm
	@Resource
	protected LoginForm loginForm;

	@Resource
	protected UserService userService;

	public UserDto userDto;

	public LoginDto loginDto;



	/**
	 * ログイン画面表示メソッド
	 * @return
	 */
	@Execute(validator = false)
	public String index() {
		return "login.jsp";
	}

	/**
	 * ログイン成功時にページ移動するメソッド
	 * @return
	 */
	@Execute(validator = true, input = "login.jsp", redirect=true)
	public String goTop() {
		userDto.userId   = loginForm.userId;
		userDto.password = loginForm.password;


		userService.checkUser(userDto);
		if (userService.checkUser(userDto)) {
			loginDto.userId = userDto.userId;
			return "/";
		} else {
			userDto.errorMasage = "ユーザ名かパスワードが違います。";
			return "/login/";
		}
	}

}
