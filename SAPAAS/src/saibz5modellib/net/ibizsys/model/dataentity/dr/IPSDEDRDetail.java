package net.ibizsys.model.dataentity.dr;

import net.ibizsys.model.core.IPSModelObject;
import net.ibizsys.model.dataentity.action.IPSDEAction;
import net.ibizsys.model.dataentity.priv.IPSDEOPPriv;
import net.ibizsys.model.res.IPSLanguageRes;
import net.ibizsys.model.res.IPSSysImage;
import net.ibizsys.model.res.IPSSysPDTView;


/**
 * 数据关系界面组成员接口对象
 * 
 * @author lionlau
 *
 */
public interface IPSDEDRDetail extends IPSModelObject {

	/**
	 * 关系成员类型：关系界面
	 */
	static String DETAILTYPE_DRITEM = "DRITEM";

	/**
	 * 关系成员类型：预置视图
	 */
	static String DETAILTYPE_PDTVIEW = "PDTVIEW";


	
	/**
	 * 获取实体关系组对象
	 * @return
	 */
	IPSDEDataRelation getPSDEDR();
	
	
	/**
	 * 获取标题
	 * 
	 * @return
	 */
	String getCaption();
	
	/**
	 * 获取标题
	 * 
	 * @return
	 */
	String getCaption(String strLanguage);

	/**
	 * 获取分类类型，值参考 SA.SRFDA.PS.Core.DataEntity.DR.IPSDEDRDetail.DETAILTYPE_XXX 定义
	 * 
	 * @return
	 */
	String getDetailType();

	/**
	 * 获取数据关系分组标识
	 * 
	 * @return
	 */
	String getPSDEDRGroupId();

	/**
	 * 获取关系视图编号
	 * 
	 * @return
	 */
	String getPSDEViewId();

	/**
	 * 获取关系界面
	 * 
	 * @return
	 */
	String getPSDEDRItemId();

	/**
	 * 获取关系界面项
	 * 
	 * @return
	 */
	IPSDEDRItem getPSDEDRItem();

	/**
	 * 获取系统预置视图
	 * 
	 * @return
	 */
	IPSSysPDTView getPSSysPDTView();

	/**
	 * 获取系统图片资源
	 * 
	 * @return
	 */
	IPSSysImage getPSSysImage();

	/**
	 * 获取启用模式
	 * 
	 * @return
	 */
	String getEnableMode();

	/**
	 * 获取计数器标识
	 * 
	 * @return
	 */
	String getCounterId();

	/**
	 * 判断启用判断实体行为
	 * 
	 * @return
	 */
	IPSDEAction getTestPSDEAction();

	/**
	 * 获取实体操作标示
	 * 
	 * @return
	 */
	IPSDEOPPriv getTestPSDEOPPriv();

	/**
	 * 获取标题语言资源对象
	 * 
	 * @return
	 */
	IPSLanguageRes getCapPSLanguageRes();

//	/**
//	 * 获取实体树视图标识
//	 * 
//	 * @return
//	 */
//	String getPSDETreeId();
}
