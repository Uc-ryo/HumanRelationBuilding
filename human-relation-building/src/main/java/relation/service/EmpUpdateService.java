package relation.service;

import org.seasar.extension.jdbc.service.S2AbstractService;

import relation.dto.EmpUpdateDto;
import relation.entity.Emp;
import relation.util.SetContactStatus;

public class EmpUpdateService extends S2AbstractService<Emp> {

	public EmpUpdateDto empUpdateDto;


	/**
	 * DBからIDをもとにデータを探してくる
	 * @param empId
	 * @return
	 */
	public Emp findById(Integer empId) {
		return jdbcManager.from(entityClass).id(empId).getSingleResult();
	}

	/**
	 * findByIdメソッドが探してきたエンティティをDtoに格納する
	 * @param empId
	 * @return createUpdateDtoメソッド
	 */
	public EmpUpdateDto getDtoById(Integer empId) {
		Emp emp = findById(empId);
		return createUpdateDto(emp);
	}

	/**
	 * 渡されたDto(更新内容入力後)をもとにレコードを更新する
	 * @param empId
	 * @return
	 */
	public int update(EmpUpdateDto empUpdateDto) {
		Emp entity = setEntity(empUpdateDto);
		return update(entity);
	}

	/**
	 * 渡されたエンティティをDtoに格納する(更新内容入力前)
	 * contactStatusはboolean型で送られ来るので
	 * String型に変換してから格納する
	 * @param emp エンティティ
	 * @return Dto
	 */
	private EmpUpdateDto createUpdateDto(Emp emp) {
		SetContactStatus scs = new SetContactStatus();
		String stringContactStatus = scs.changeContactStatusIntegerToStr(emp.contactStatus);

		empUpdateDto.empId               = emp.empId;
		empUpdateDto.lastNameKanji       = emp.lastNameKanji;
		empUpdateDto.firstNameKanji      = emp.firstNameKanji;
		empUpdateDto.lastNameKana        = emp.lastNameKana;
		empUpdateDto.firstNameKana       = emp.firstNameKana;
		empUpdateDto.birthYear           = emp.birthYear;
		empUpdateDto.birthMonth          = emp.birthMonth;
		empUpdateDto.birthDay            = emp.birthDay;
		empUpdateDto.cellphoneNumber     = emp.cellphoneNumber;
		empUpdateDto.stringContactStatus = stringContactStatus;
		empUpdateDto.memo                = emp.memo;
		empUpdateDto.deleteFlag          = emp.deleteFlag;
		empUpdateDto.resisterTime        = emp.resisterTime;

		return empUpdateDto;
	}

	/**
	 * 入力され、Dtoに格納された値をエンティティに詰め替える(更新内容入力後)
	 * @param empUpdateDto
	 */
	public Emp setEntity(EmpUpdateDto empUpdateDto) {
		Emp entity = new Emp();
		entity.empId           = empUpdateDto.empId;
		entity.lastNameKanji   = empUpdateDto.lastNameKanji;
		entity.firstNameKanji  = empUpdateDto.firstNameKanji;
		entity.lastNameKana    = empUpdateDto.lastNameKana;
		entity.firstNameKana   = empUpdateDto.firstNameKana;
		entity.birthYear       = empUpdateDto.birthYear;
		entity.birthMonth      = empUpdateDto.birthMonth;
		entity.birthDay        = empUpdateDto.birthDay;
		entity.cellphoneNumber = empUpdateDto.cellphoneNumber;
		entity.contactStatus   = empUpdateDto.contactStatus;
		entity.memo            = empUpdateDto.memo;
		entity.deleteFlag      = empUpdateDto.deleteFlag;
		entity.resisterTime    = empUpdateDto.resisterTime;

		return entity;
	}

}
