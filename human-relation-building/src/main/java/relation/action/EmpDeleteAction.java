package relation.action;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.apache.struts.action.ActionMessage;
import org.apache.struts.action.ActionMessages;
import org.apache.struts.util.TokenProcessor;
import org.seasar.framework.aop.annotation.RemoveSession;
import org.seasar.struts.annotation.ActionForm;
import org.seasar.struts.annotation.Execute;

import relation.dto.EmpDeleteDto;
import relation.entity.Emp;
import relation.form.EmployeesForm;
import relation.service.EmpDeleteService;

public class EmpDeleteAction {

	@ActionForm
	@Resource
	protected EmployeesForm employeesForm;

	@Resource
	protected EmpDeleteService empDeleteService;

	@Resource
	protected HttpServletRequest request;

	public Emp emp;
	public EmpDeleteDto empDeleteDto;


	/**
	 * 削除確認画面を表示
	 * @return 削除確認画面.jsp
	 */
	@Execute(validator = false)
	public String index() {
		TokenProcessor.getInstance().saveToken(request);
		empDeleteDto = empDeleteService.getDtoById(employeesForm.empId);
		return "delete.jsp";
	}

	/**
	 * 削除を行い、削除完了画面へ進む
	 * @return 削除完了画面.jsp
	 */
	@Execute(validator = false, validate = "validate", input = "delete.jsp")
	@RemoveSession(name = "EmpDeleteDto")
	public String goDeleteCompleted() {
		empDeleteService.deleteById(employeesForm.empId);
		return "deleteCompleted.jsp";
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
