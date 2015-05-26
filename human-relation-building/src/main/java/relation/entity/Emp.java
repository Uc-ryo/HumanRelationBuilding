package relation.entity;

import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "emp")
public class Emp {

	public static final int CONTACTED = 1;
	public static final int NOT_CONTACTED = 0;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "emp_id", precision = 10, nullable = false, unique = true)
	/** ID */
	public Integer empId;

	/** 姓 漢字 */
	@Column(name = "lastname_kanji")
	public String lastNameKanji;

	/** 名 漢字 */
	@Column(name = "firstname_kanji")
	public String firstNameKanji;

	/** 姓 カナ */
	@Column(name = "lastname_katakana")
	public String lastNameKana;

	/** 名 カナ */
	@Column(name = "firstname_katakana")
	public String firstNameKana;

	/** 年 */
	@Column(name = "birth_year")
	public String birthYear;

	/** 月 */
	@Column(name = "birth_month")
	public String birthMonth;

	/** 日 */
	@Column(name = "birth_day")
	public String birthDay;

	/** 携帯場号 */
	@Column(name = "cellphone_num")
	public String cellphoneNumber;

	/** 会話状況 */
	@Column(name = "contact_status")
	public Integer contactStatus;

	/** メモ */
	@Column(name = "memo")
	public String memo;

	/** デリートフラグ */
	@Column(name = "delete_flag")
	public Integer deleteFlag;

	/** 登録日時 */
	@Column(name = "register_time")
	public Timestamp resisterTime;

	/** 更新日時 */
	@Column(name = "update_time")
	public Timestamp updateTime;
}
