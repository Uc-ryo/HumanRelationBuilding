package relation.dto;

import org.seasar.framework.container.annotation.tiger.Component;
import org.seasar.framework.container.annotation.tiger.InstanceType;

@Component(instance = InstanceType.SESSION)
public class DetailEmpDto {

	private static final long serialVersionUID = 1L;

	/** ID */
	public Integer empId;

	/** 姓 漢字 */
	public String lastNameKanji;

	/** 名 漢字 */
	public String firstNameKanji;

	/** 姓 フリガナ */
	public String lastNameKana;

	/** 名 フリガナ */
	public String firstNameKana;

	/** 年 */
	public String birthYear;

	/** 月 */
	public String birthMonth;

	/** 日 */
	public String birthDay;

	/** 携帯番号 */
	public String cellphoneNumber;

	/** 会話 */
	public String stringContactStatus;

	/** メモ */
	public String memo;

	/** デリートフラグ */
	public Integer deleteFlag;

	public DetailEmpDto() {
	}

	public DetailEmpDto(Integer empId, String lastNameKanji, String firstNameKanji, String lastNameKana
			, String firstNameKana, String birthYear, String birthMonth
			, String birthDay, String cellphoneNumber, String stringContactStatus
            , String memo, Integer deleteFlag) {

		this.empId               = empId;
		this.lastNameKanji       = lastNameKanji;
		this.firstNameKanji      = firstNameKanji;
		this.lastNameKana        = lastNameKana;
		this.firstNameKana       = firstNameKana;
		this.birthYear           = birthYear;
		this.birthMonth          = birthMonth;
		this.birthDay            = birthDay;
		this.cellphoneNumber     = cellphoneNumber;
		this.stringContactStatus = stringContactStatus;
		this.memo                = memo;
		this.deleteFlag          = deleteFlag;
	}


}
