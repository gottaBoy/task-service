package net.ibizsys.model.dataentity.uiaction;

import net.ibizsys.model.view.IPSUIActionGroupDetail;


/**
 * 实体界面行为组成员对象接口
 * 
 * @author Administrator
 *
 */
public interface IPSDEUIActionGroupDetail extends IPSUIActionGroupDetail {
	
	/**
	*成员类型：实体界面行为
	*/
	public final static String DETAILTYPE_DEUIACTION = "DEUIACTION" ;

	/**
	*成员类型：分割线
	*/
	public final static String DETAILTYPE_SEPERATOR = "SEPERATOR" ;
	
	
	
	/**
	 * 获取界面行为组对象
	 * 
	 * @return
	 */
	IPSDEUIActionGroup getPSDEUIActionGroup();

	/**
	 * 获取实体界面行为对象
	 * 
	 * @return
	 */
	IPSDEUIAction getPSDEUIAction();
	
	
	
	/**
	 * 获取成员类型，值参考 SA.SRFDA.PS.Core.DataEntity.UIAction.IPSDEUIActionGroupDetail.DETAILTYPE_XXX 定义
	 * @return
	 */
	String getDetailType();

}
