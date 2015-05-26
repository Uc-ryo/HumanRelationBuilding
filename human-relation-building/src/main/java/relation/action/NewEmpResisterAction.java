package relation.action;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.apache.struts.action.ActionMessage;
import org.apache.struts.action.ActionMessages;
import org.apache.struts.util.TokenProcessor;
import org.seasar.framework.aop.annotation.RemoveSession;
import org.seasar.struts.annotation.ActionForm;
import org.seasar.struts.annotation.Execute;

import relation.dto.NewEmpResisterDto;
import relation.form.NewEmpResisterForm;
import relation.service.EmpDeleteService;
import relation.service.NewEmpResisteService;
import relation.util.SetContactStatus;


public class NewEmpResisterAction {

	@ActionForm
	@Resource
	public NewEmpResisterForm newEmpResisterForm;

	@Resource
	protected NewEmpResisteService newEmpResisteService;

	@Resource
	protected EmpDeleteService empDeleteService;

	@Resource
	protected HttpServletRequest request;

	public NewEmpResisterDto newEmpResisterDto;

	/**
	 * 新規登録入力フォーム
	 * @return
	 */
	@Execute(validator = false)
	public String index() {
		TokenProcessor.getInstance().saveToken(request);
		return "resisterInput.jsp";
	}

	/**
	 * 新規登録確認画面へ
	 * @return
	 */
	@Execute(validator = true, input = "resisterInput.jsp")
	public String goResisterConfirm() {

		/** String型のcontactStatusをboolean型に変える */
		SetContactStatus scs = new SetContactStatus();

		Integer contactStatus = scs.changeContactStatusStrToInteger(newEmpResisterForm.contactStatus);

		String stringContactStatus = scs.setContactSatus(contactStatus);

		newEmpResisterDto.lastNameKanji   = newEmpResisterForm.lastNameKanji;
		newEmpResisterDto.firstNameKanji  = newEmpResisterForm.firstNameKanji;
		newEmpResisterDto.lastNameKana    = newEmpResisterForm.lastNameKana;
		newEmpResisterDto.firstNameKana   = newEmpResisterForm.firstNameKana;
		newEmpResisterDto.birthYear       = newEmpResisterForm.birthYear;
		newEmpResisterDto.birthMonth      = newEmpResisterForm.birthMonth;
		newEmpResisterDto.birthDay        = newEmpResisterForm.birthDay;
		newEmpResisterDto.cellphoneNumber = newEmpResisterForm.cellphoneNumber;
		newEmpResisterDto.contactStatus   = contactStatus;
		newEmpResisterDto.strContactStatus = stringContactStatus;
		newEmpResisterDto.memo            = newEmpResisterForm.memo;

		return "resisterConfirm.jsp";
	}

	/**
	 * 新規登録完了画面へ
	 * @return
	 */
	@Execute(validator = false)
	@RemoveSession(name = "newEmpResisterDto")
	public String goResisterConpleted() {

		newEmpResisteService.insert(newEmpResisterDto);

		return "resisterCompleted.jsp";
	}

	/**
	 * トップ画面へ
	 * @return
	 */
	@Execute(validator = false)
	public String goTop() {
		return "/";
	}

	/**
	 * 社員一覧画面へ
	 * @return
	 */
	@Execute(validator = false)
	public String goEmployees() {
		return "/employees";
	}

	/**
	 *
	 * @return
	 */
	@Execute(validator = false)
	public String goBackInput() {

		SetContactStatus scs = new SetContactStatus();

		String contactStatus = scs.changeContactStatusIntegerToStr(newEmpResisterDto.contactStatus);
		Integer stringContactStatus = scs.replaceContactSatus(contactStatus);
		String strContactStatus = scs.replaceContactStatusIntToStr(stringContactStatus);

		newEmpResisterForm.lastNameKanji   = newEmpResisterDto.lastNameKanji;
		newEmpResisterForm.firstNameKanji  = newEmpResisterDto.firstNameKanji;
		newEmpResisterForm.lastNameKana    = newEmpResisterDto.lastNameKana;
		newEmpResisterForm.firstNameKana   = newEmpResisterDto.firstNameKana;
		newEmpResisterForm.birthYear       = newEmpResisterDto.birthYear;
		newEmpResisterForm.birthMonth      = newEmpResisterDto.birthMonth;
		newEmpResisterForm.birthDay        = newEmpResisterDto.birthDay;
		newEmpResisterForm.cellphoneNumber = newEmpResisterDto.cellphoneNumber;
		newEmpResisterForm.contactStatus   = contactStatus;
		newEmpResisterForm.contactStatus   = strContactStatus;
		newEmpResisterForm.memo            = newEmpResisterDto.memo;

		return "resisterInput.jsp";
	}

	/**
	 * ワンタイムトークン
	 * @return
	 */
	public ActionMessages validate() {
		ActionMessages errors = new ActionMessages();
		if (!TokenProcessor.getInstance().isTokenValid(request, true)) {
			errors.add(ActionMessages.GLOBAL_MESSAGE, new ActionMessage(
					"errors.invalid",
					"二度押し"));
		}
		return errors;
	}

}
