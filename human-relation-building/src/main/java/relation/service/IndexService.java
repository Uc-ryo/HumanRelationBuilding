package relation.service;

import java.util.List;

import org.seasar.extension.jdbc.service.S2AbstractService;
import org.seasar.extension.jdbc.where.SimpleWhere;

import relation.entity.Emp;

public class IndexService extends S2AbstractService<Emp> {

	/**
	 * DBから引数と同じIDのデータを探してくる
	 * @param empId 社員ID
	 * @return レコードリスト
	 */
	public List<Emp> searchEmployees(Emp emp) {
		return select().where()
						.getResultList();
	}

	/**
	 * 論理削除されていない社員の総数
	 * @return 上記のレコード数
	 */
	public long allEmpCount(Integer deleteFlag) {
		long count = jdbcManager
						.from(Emp.class)
						.where(new SimpleWhere().eq("deleteFlag", deleteFlag))
						.getCount();
		return count;
	}

	/**
	 * 論理削除されていない,会話状況に対応した社員数
	 * @return 上記のレコード数
	 */
	public long contactedEmpCount(Integer deleteFlag, Integer contactStatus) {
		long count = jdbcManager
				.from(Emp.class)
				.where(new SimpleWhere().eq("deleteFlag", deleteFlag)
										.eq("contactStatus", contactStatus)
										)
				.getCount();
		return count;
	}

	/**
	 * 割合計算
	 * @param contactCount 分子
	 * @param allEmpCount 分母
	 * @return 割合
	 */
	public double calcurateContactRate(long contactCount, long allEmpCount) {
		double doubleContactCount = contactCount;
		double doubleAllEmpCount = allEmpCount;
		double contactRate = doubleContactCount / doubleAllEmpCount * 100;
		return contactRate;
	}

}
