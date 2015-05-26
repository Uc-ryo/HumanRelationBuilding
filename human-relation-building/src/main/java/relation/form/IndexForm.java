package relation.form;


public class IndexForm {

	/** 姓 漢字 */
	public String lastNameKanji = "漢字";

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

	/** 全社員数 */
	public long allEmpCount;

	/** 会話済み社員数 */
	public long contactedEmpCount;

	/** 未会話の社員数 */
	public long notContactedEmpCount;

	/** 会話済み社員数 */
	public double contactedEmpRate;

	/** 未会話の社員数 */
	public double notContactedEmpRate;

}
