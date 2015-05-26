package relation.interceptor;

import javax.annotation.Resource;

import org.aopalliance.intercept.MethodInvocation;
import org.seasar.framework.aop.interceptors.AbstractInterceptor;
import org.seasar.struts.annotation.Execute;

import relation.dto.LoginDto;

public class SessionCheckInterceptor extends AbstractInterceptor {

	private static final long serialVersionUID = 1L;

	/**
	 * セッションに保存されているデータ
	 */
	@Resource
	protected LoginDto loginDto;

	@Override
	public Object invoke(MethodInvocation invocation) throws Throwable {

		/*
		if (this.loginDto == null) {
			return "/login/goSessionTimeout/";
		}
		*/

		//両方の条件を満たしていない場合、Loginページへ飛ばす。
		return (!isExecuteMethod(invocation) || isLoggedin()) ?
				invocation.proceed() : "/login/";
	}

	/**
	 * 実行されたActionに@Executeが付いてたかどうか
	 * @param invocation
	 * @return アノテーションがついていればtrue
	 */
	private boolean isExecuteMethod (MethodInvocation invocation) {
		return invocation.getMethod().isAnnotationPresent(Execute.class);
	}

	/**
	 * セッション上にDtoがあるか、あった場合その中にuserIdは保持されているか
	 * @return 満たしていればtrue
	 */
	private boolean isLoggedin() {
		return (loginDto != null && loginDto.userId != null);
	}

}
