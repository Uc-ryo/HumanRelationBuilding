package relation.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.seasar.extension.jdbc.service.S2AbstractService;
import org.seasar.extension.jdbc.where.SimpleWhere;

import relation.dto.EmpCollectionDto;
import relation.dto.EmpCollectionDto.EmpDto;
import relation.dto.NewEmpResisterDto;
import relation.entity.Emp;
import relation.util.SetContactStatus;

public class EmpService extends S2AbstractService<Emp> {

	/**
	 * DBからIDをもとにレコードを探してくる
	 * @param empId
	 * @return エンティティ
	 */
	public Emp findById(Integer empId) {
		return select().id(empId).getSingleResult();
	}

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
		entity.deleteFlag      = newEmpResisterDto.deleteFlag;
		return insert(entity);
	}

	/**
	 * findAllが探してきたレコードを取得する
	 * @return empCollectionDto
	 */
	public EmpCollectionDto getAllDto() {
		List<Emp> emps = findAll();
		EmpCollectionDto empCollectionDto = createDto(emps);
		return empCollectionDto;
	}

	/**
	 * 論理削除されていないデータ(deleteFlagがgfalse)のみを探しだす
	 * @param deleteFlag
	 * @return エンティティ
	 */
	public List<Emp> findByDeleteFlag(boolean deleteFlag) {
		return select().where(new SimpleWhere().eq("deleteFlag", deleteFlag))
						.getResultList();
	}

	/**
	 * findByDeleteFlagが探し出した論理削除されていないレコードを所得し、
	 * createDtoに渡す。
	 * @param deleteFlag
	 * @return Dto型のemp
	 */
	public EmpCollectionDto getDtoByDeleteFlag(boolean deleteFlag) {
		List<Emp> emps = findByDeleteFlag(deleteFlag);
		return createDto(emps);
	}

	/**
	 * Dtoにentityの値を入れる
	 * @param emps エンティティデータ
	 * @return Dto
	 */
	private EmpCollectionDto createDto(List<Emp> emps) {
		EmpCollectionDto empCollectionDto = new EmpCollectionDto();
		for (Emp emp : emps) {

			SetContactStatus scs = new SetContactStatus();
			String contactStatus = scs.setContactSatus(emp.contactStatus);

			EmpDto empDisp = new EmpDto(emp.empId, emp.lastNameKanji, emp.firstNameKanji, emp.lastNameKana
					, emp.firstNameKana, emp.birthYear, emp.birthMonth, emp.birthDay
					, emp.cellphoneNumber, contactStatus, emp.memo, emp.deleteFlag);

			empCollectionDto.empDtos.add(empDisp);
		}
		return empCollectionDto;
	}

	/**
	 * Dtoにエンティティデータを入れる
	 * @param emp
	 */
	public EmpDto createDetailDto(Emp emp) {
		EmpDto empDto = new EmpDto();
		SetContactStatus scs = new SetContactStatus();

		String strContactStatus = scs.setContactSatus(emp.contactStatus);

		empDto.empId                 = emp.empId;
		empDto.lastNameKanji         = emp.lastNameKanji;
		empDto.firstNameKanji        = emp.firstNameKanji;
		empDto.lastNameKana          = emp.lastNameKana;
		empDto.firstNameKana         = emp.firstNameKana;
		empDto.birthYear             = emp.birthYear;
		empDto.birthMonth            = emp.birthMonth;
		empDto.birthDay              = emp.birthDay;
		empDto.cellphoneNumber       = emp.cellphoneNumber;
		empDto.stringContactStatus   = strContactStatus;
		empDto.memo                  = emp.memo;
		empDto.deleteFlag            = emp.deleteFlag;

		return empDto;
	}

	/**
	 * データベースから検索したレコードを
	 * Dtoに格納する
	 * @param keyWord
	 * @return Dto
	 */
	public EmpCollectionDto getSearchedEmp(String keyWord) {
		Map<Integer, Emp> searchedEmp = serachEmp(keyWord);
		List<Emp> result = new ArrayList<Emp>(searchedEmp.values());
		return createDto(result);
	}

	/**
	 * 重複を避け、複数語句の検索に対応するレコードを探し出す
	 * @return 取得したレコード
	 */
	private Map<Integer, Emp> serachEmp(String keyWord) {
		String key = keyWord.replaceAll("　", " ");	//全角スペースを半角スペースに
		String trimedKey = key.trim();											//先頭と末尾のスペースを削除
		String replacedKey = trimedKey.replaceAll(" {2}", "");							//2つ以上連続するスペースを削除
		String[] keys = replacedKey.split(" ", 0);							//空白で分ける

		List<Emp> searchedEmp = new ArrayList<>();
		Map<Integer, Emp> employees = new HashMap<>();
		for (String word : keys){
			searchedEmp = jdbcManager
							.selectBySql(Emp.class,
								" SELECT * FROM emp" +
									" WHERE" +
										" delete_flag = '0' AND" +
										" lastname_kanji LIKE '%' ? '%'" +
										" OR" +
										" firstname_kanji LIKE '%' ? '%'" +
										" OR" +
										" lastname_katakana LIKE '%' ? '%'" +
										" OR" +
										" firstname_katakana LIKE '%' ? '%'" +
										" OR" +
										" birth_year LIKE '%' ? '%'" +
										" OR" +
										" birth_month LIKE '%' ? '%'" +
										" OR" +
										" birth_day LIKE '%' ? '%'" +
										" OR" +
										" cellphone_num LIKE '%' ? '%'" +
										" OR" +
										" memo LIKE '%' ? '%';",
										word,word,word,word,word,word,word,word,word
						).getResultList();
			for (Emp emp : searchedEmp) {
				employees.put(emp.empId, emp);
			}
		}
		return employees;
	}
}
