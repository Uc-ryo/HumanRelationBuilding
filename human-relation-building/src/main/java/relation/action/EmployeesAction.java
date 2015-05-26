package relation.action;

import javax.annotation.Resource;

import org.seasar.struts.annotation.ActionForm;
import org.seasar.struts.annotation.Execute;

import relation.dto.EmpCollectionDto;
import relation.dto.EmpCollectionDto.EmpDto;
import relation.form.EmployeesForm;
import relation.service.EmpDeleteService;
import relation.service.EmpService;


/**
 * 社員一覧に関するクラス
 * @author ryousuke
 *
 */
public class EmployeesAction {

	@ActionForm
	@Resource
	protected EmployeesForm employeesForm;

	@Resource
	protected EmpService empService;

	public EmpDeleteService empDeleteService;

	public EmpCollectionDto empCollectionDto;
	public EmpDto empDto;

	/**
	 * 社員一覧を表示するメソッド
	 * @return
	 */
	@Execute(validator = false)
	public String index() {
		empCollectionDto = empService.getDtoByDeleteFlag(false);
		return "employees.jsp";
	}

	/**
	 * 検索結果を表示するメソッド
	 * @return
	 */
	@Execute(validator = false)
	public String serchEmp() {
		if (!employeesForm.keyWord.equals("")) {
			empCollectionDto = empService.getSearchedEmp(employeesForm.keyWord);
		return "employees.jsp";
		} else {
			empCollectionDto = empService.getDtoByDeleteFlag(false);
			return "employees.jsp";
		}
	}

	/**
	 * 詳細画面へ飛ぶメソッド
	 * @return
	 */
	@Execute(validator = false)
	public String goDetailEmp() {
		Integer id = employeesForm.empId;
		empDto = empService.createDetailDto(empService.findById(id));
		return "detailEmp.jsp";
	}
}
