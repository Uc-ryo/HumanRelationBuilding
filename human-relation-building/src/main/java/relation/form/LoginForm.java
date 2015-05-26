package relation.form;

import org.seasar.struts.annotation.Arg;
import org.seasar.struts.annotation.Mask;
import org.seasar.struts.annotation.Maxlength;
import org.seasar.struts.annotation.Minlength;
import org.seasar.struts.annotation.Msg;
import org.seasar.struts.annotation.Required;

public class LoginForm {

	@Required(arg0 = @Arg(key = "ユーザID", resource = false))
	@Minlength(minlength = 6)
	@Maxlength(maxlength = 12)
	@Mask(mask = ".*[0-9a-zA-Z_].*", msg = @Msg(key = "errors.existNoArpha"))
	public String userId;

	@Required(arg0 = @Arg(key = "パスワード", resource = false))
	@Minlength(minlength = 6)
	@Maxlength(maxlength = 12)
	@Mask(mask = ".*[0-9a-zA-Z_].*", msg = @Msg(key = "errors.existNoArpha"))
	public String password;

}
