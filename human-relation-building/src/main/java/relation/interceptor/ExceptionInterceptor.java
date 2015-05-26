package relation.interceptor;

import org.aopalliance.intercept.MethodInvocation;
import org.seasar.framework.aop.interceptors.AbstractInterceptor;
import org.seasar.framework.log.Logger;
import org.seasar.struts.annotation.Execute;

public class ExceptionInterceptor extends AbstractInterceptor {

	private static final long serialVersionUID = 1L;

	private static final Logger logger = Logger.getLogger(ExceptionInterceptor.class);

	@Override
	@Execute(validator = false)
	public Object invoke(MethodInvocation invocation) throws Throwable {

		try {
			return invocation.proceed();
		} catch (Exception ex) {
			//エラーログを出力
			logger.error("エラーが発生しました。", ex);

			//エラー画面に遷移
			return "/error/";
		}
	}
}
