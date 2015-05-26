package relation.form;

import org.seasar.struts.annotation.Arg;
import org.seasar.struts.annotation.Mask;
import org.seasar.struts.annotation.Maxlength;
import org.seasar.struts.annotation.Msg;
import org.seasar.struts.annotation.Required;

public class EmpUpdateForm {

	/** ID */
	public Integer empId;

	/** 姓 漢字 */
	@Maxlength(maxlength=10)
	@Mask(mask = "^[^ -~｡-ﾟ]*$", msg = @Msg(key = "errors.fullWidth"))
	public String lastNameKanji;

	/** 名 漢字 */
	@Maxlength(maxlength=10)
	@Mask(mask = "^[^ -~｡-ﾟ]*$", msg = @Msg(key = "errors.fullWidth"))
	public String firstNameKanji;

	/** 姓 フリガナ */
	@Maxlength(maxlength=20)
	@Mask(mask = "^[\u30A0-\u30FF]+$", msg = @Msg(key = "errors.katakana"))
	public String lastNameKana;

	/** 名 フリガナ */
	@Maxlength(maxlength=20)
	@Mask(mask = "^[\u30A0-\u30FF]+$", msg = @Msg(key = "errors.katakana"))
	public String firstNameKana;

	/** 年 */
	@Mask(mask = "\\d\\d\\d\\d", msg = @Msg(key = "errors.year"), args = @Arg(key = "errors.year"))
	public String birthYear;

	/** 月 */
	public String birthMonth;

	/** 日 */
	public String birthDay;

	/** 携帯番号 */
	@Mask(mask = "\\d\\d\\d\\d\\d\\d\\d\\d\\d\\d\\d", msg = @Msg(key = "errors.phone"), args = @Arg(key = "9999999999", resource = false, position = 1))
	public String cellphoneNumber;

	/** 会話 */
	public String contactStatus;

	/** メモ */
	@Required(arg0 = @Arg(key = "メモ", resource = false))
	@Maxlength(maxlength=200)
	public String memo;

	/** デリートフラグ */
	public Integer deleteFlag;
}
