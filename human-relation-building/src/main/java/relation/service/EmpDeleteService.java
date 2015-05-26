package relation.service;

import org.seasar.extension.jdbc.service.S2AbstractService;

import relation.dto.EmpDeleteDto;
import relation.entity.Emp;
import relation.form.EmployeesForm;
import relation.util.SetContactStatus;

public class EmpDeleteService extends S2AbstractService<Emp> {

	public EmployeesForm employeesDeleteForm;

	/**
	 * DBからIDをもとにデータを探してくる
	 * @param empId
	 * @return
	 */
	public Emp findById(Integer empId) {
		return select().id(empId).getSingleResult();
	}

	public EmpDeleteDto getDtoById(Integer empId) {
		Emp emp = findById(empId);
		return createDeleteDto(emp);
	}

	/**
	 * findByIdメソッドが探してきたエンティティをDtoに格納する
	 * @param empId
	 * @return createUpdateDtoメソッド
	 */
	private EmpDeleteDto createDeleteDto(Emp emp) {
		EmpDeleteDto empDeleteDto    = new EmpDeleteDto();
		SetContactStatus scs = new SetContactStatus();
		String scsContactStatus = scs.setContactSatus(emp.contactStatus);

		empDeleteDto.lastNameKanji         = emp.lastNameKanji;
		empDeleteDto.firstNameKanji        = emp.firstNameKanji;
		empDeleteDto.lastNameKana          = emp.lastNameKana;
		empDeleteDto.firstNameKana         = emp.firstNameKana;
		empDeleteDto.birthYear             = emp.birthYear;
		empDeleteDto.birthMonth            = emp.birthMonth;
		empDeleteDto.birthDay              = emp.birthDay;
		empDeleteDto.cellphoneNumber       = emp.cellphoneNumber;
		empDeleteDto.stringContactStatus   = scsContactStatus;
		empDeleteDto.memo                  = emp.memo;
		empDeleteDto.deleteFlag            = emp.deleteFlag;

		return empDeleteDto;
	}

	/**
	 * DBのデータをIDで指定して削除する
	 * @param empId
	 * @return
	 */
	public int deleteById(Integer empId) {
		Emp entity = new Emp();
		entity.empId = empId;
		entity.deleteFlag = 1;

		return jdbcManager.update(entity)
					.includes("deleteFlag")
					.execute();
	}

}
