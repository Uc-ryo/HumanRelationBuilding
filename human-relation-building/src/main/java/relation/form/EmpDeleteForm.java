package relation.form;

import java.io.Serializable;

public class EmpDeleteForm implements Serializable {

	private static final long serialVersionUUID = 1L;

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
	public String contactStatus;

	/** メモ */
	public String memo;

	/** デリートフラグ */
	public Integer deleteFlag;

}
