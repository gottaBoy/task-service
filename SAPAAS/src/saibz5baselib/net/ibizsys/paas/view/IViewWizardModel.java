package net.ibizsys.paas.view;

import java.util.ArrayList;

import net.ibizsys.paas.controller.IViewController;
import net.sf.json.JSONObject;

/**
 * 视图向导模型
 * @author Administrator
 *
 */
public interface IViewWizardModel extends IViewWizard{

	/**
	 * 填充视图向导集合
	 * @param strQuery
	 * @param viewWizardList
	 * @return 填充数量
	 * @throws Exception
	 */
	int fillViewWizards(IViewController iViewController,String strQuery,ArrayList<IViewWizard> viewWizardList) throws Exception;
	
	
	
	/**
	 * 导出JSON
	 * @param bDetailMode
	 * @return
	 * @throws Exception
	 */
	JSONObject toJSONObject(boolean bDetailMode) throws Exception;
}
