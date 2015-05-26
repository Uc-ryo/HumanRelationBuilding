package relation.service;

import org.seasar.extension.jdbc.service.S2AbstractService;

import relation.dto.NewEmpResisterDto;
import relation.entity.Emp;
import relation.form.NewEmpResisterForm;

public class NewEmpResisteService extends S2AbstractService<Emp> {

	public NewEmpResisterForm newEmpResisterForm;

	/**
	 * DBに新規登録する
	 * @param newEmpResisterDto
	 * @return
	 */
	public int insert(NewEmpResisterDto newEmpResisterDto) {
		Emp entity = new Emp();
		entity.lastNameKanji   = newEmpResisterDto.lastNameKanji;
		entity.firstNameKanji  = newEmpResisterDto.firstNameKanji;
		entity.lastNameKana    = newEmpResisterDto.lastNameKana;
		entity.firstNameKana   = newEmpResisterDto.firstNameKana;
		entity.birthYear       = newEmpResisterDto.birthYear;
		entity.birthMonth      = newEmpResisterDto.birthMonth;
		entity.birthDay        = newEmpResisterDto.birthDay;
		entity.cellphoneNumber = newEmpResisterDto.cellphoneNumber;
		entity.contactStatus   = newEmpResisterDto.contactStatus;
		entity.memo            = newEmpResisterDto.memo;
		entity.deleteFlag      = 0;
		entity.resisterTime    = newEmpResisterDto.resisterTime;
		return insert(entity);
	}
}
