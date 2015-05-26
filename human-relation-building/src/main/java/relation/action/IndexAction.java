package relation.action;

import javax.annotation.Resource;

import org.seasar.struts.annotation.ActionForm;
import org.seasar.struts.annotation.Execute;

import relation.form.IndexForm;
import relation.service.IndexService;

/**
 * トップ画面の表示関連
 * @author ryousuke
 *
 */
public class IndexAction {

	@ActionForm
	@Resource
	protected IndexForm indexForm;

	@Resource
	protected IndexService indexService;

	/**
	 * トップ画像を表示するメソッド
	 * @return
	 */
	@Execute(validator = false)
	public String index() {

		//論理削除されていない会話済みの社員数
		indexForm.contactedEmpCount = indexService.contactedEmpCount(0, 0);

		//論理削除されいな未会話の社員数
		indexForm.notContactedEmpCount = indexService.contactedEmpCount(0, 1);

		//論理削除されていない全登録人数
		indexForm.allEmpCount = indexService.allEmpCount(0);

		//登録人数に対する会話済み人数の割合
		double contactedRate = indexService.calcurateContactRate(indexForm.contactedEmpCount, indexForm.allEmpCount);
		indexForm.contactedEmpRate = Math.round(contactedRate);

		//登録人数に対する未会話人数の割合
		double notContactedRate = indexService.calcurateContactRate(indexForm.notContactedEmpCount, indexForm.allEmpCount);
		indexForm.notContactedEmpRate = Math.round(notContactedRate);
		return "index.jsp";
	}

}
