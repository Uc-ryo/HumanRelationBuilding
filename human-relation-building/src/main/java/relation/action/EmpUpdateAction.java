package relation.action;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.apache.struts.action.ActionMessage;
import org.apache.struts.action.ActionMessages;
import org.apache.struts.util.TokenProcessor;
import org.seasar.framework.aop.annotation.RemoveSession;
import org.seasar.struts.annotation.ActionForm;
import org.seasar.struts.annotation.Execute;

import relation.dto.EmpUpdateDto;
import relation.entity.Emp;
import relation.form.EmpUpdateForm;
import relation.service.EmpUpdateService;
import relation.util.SetContactStatus;

public class EmpUpdateAction {

	@ActionForm
	@Resource
	public EmpUpdateForm empUpdateForm;

	@Resource
	protected HttpServletRequest request;

	public Emp emp;
	public EmpUpdateService empUpdateService;
	public EmpUpdateDto empUpdateDto;

	/**
	 * 更新画面を表示
	 * @return 更新入力画面.jsp
	 */
	@Execute(validator = false, input = "updateInput.jsp")
	public String index() {
		TokenProcessor.getInstance().saveToken(request);
		empUpdateDto = empUpdateService.getDtoById(empUpdateForm.empId);
		return "updateInput.jsp";
	}

	/**
	 * 更新確認画面を表示
	 * @return 更新確認画面.jsp
	 */
	@Execute(validator = true, input = "updateInput.jsp")
	public String goUpdateConfirm() {

		/** String型のcontactStatusをboolean型に変換 */
		SetContactStatus scs = new SetContactStatus();
		Integer scsContactStatus = scs.changeContactStatusStrToInteger(empUpdateForm.contactStatus);
		String stringContactStatus = scs.setContactSatus(scsContactStatus);

		/** 入力された値をDtoに格納 */
		empUpdateDto.empId               = empUpdateForm.empId;
		empUpdateDto.lastNameKanji       = empUpdateForm.lastNameKanji;
		empUpdateDto.firstNameKanji      = empUpdateForm.firstNameKanji;
		empUpdateDto.lastNameKana        = empUpdateForm.lastNameKana;
		empUpdateDto.firstNameKana       = empUpdateForm.firstNameKana;
		empUpdateDto.birthYear           = empUpdateForm.birthYear;
		empUpdateDto.birthMonth          = empUpdateForm.birthMonth;
		empUpdateDto.birthDay            = empUpdateForm.birthDay;
		empUpdateDto.cellphoneNumber     = empUpdateForm.cellphoneNumber;
		empUpdateDto.contactStatus       = scsContactStatus;
		empUpdateDto.stringContactStatus = stringContactStatus;
		empUpdateDto.memo                = empUpdateForm.memo;
		empUpdateDto.deleteFlag          = 0;

		return "updateConfirm.jsp";
	}

	/**
	 * 更新処理を行い、更新完了画面を表示
	 * @return 更新完了画面.jsp
	 */
	@Execute(validator = false, validate = "validate", input = "updateConfirm.jsp")
	@RemoveSession(name = "empUpdateDto")
	public String goUpdateCompleted() {

		empUpdateService.update(empUpdateDto);

		return "updateCompleted.jsp";
	}

	/**
	 *
	 * @return
	 */
	@Execute(validator = false)
	public String goBackInput() {

		SetContactStatus scs = new SetContactStatus();

		String contactStatus = scs.changeContactStatusIntegerToStr(empUpdateDto.contactStatus);
		Integer stringContactStatus = scs.replaceContactSatus(contactStatus);
		String strContactStatus = scs.replaceContactStatusIntToStr(stringContactStatus);

		empUpdateForm.lastNameKanji   = empUpdateDto.lastNameKanji;
		empUpdateForm.firstNameKanji  = empUpdateDto.firstNameKanji;
		empUpdateForm.lastNameKana    = empUpdateDto.lastNameKana;
		empUpdateForm.firstNameKana   = empUpdateDto.firstNameKana;
		empUpdateForm.birthYear       = empUpdateDto.birthYear;
		empUpdateForm.birthMonth      = empUpdateDto.birthMonth;
		empUpdateForm.birthDay        = empUpdateDto.birthDay;
		empUpdateForm.cellphoneNumber = empUpdateDto.cellphoneNumber;
		empUpdateForm.contactStatus   = contactStatus;
		empUpdateForm.contactStatus   = strContactStatus;
		empUpdateForm.memo            = empUpdateDto.memo;

		return "updateInput.jsp";
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
