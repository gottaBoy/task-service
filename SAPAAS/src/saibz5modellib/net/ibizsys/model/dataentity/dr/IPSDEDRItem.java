package net.ibizsys.model.dataentity.dr;

import net.ibizsys.model.core.IPSModelObject;
import net.ibizsys.model.dataentity.action.IPSDEAction;
import net.ibizsys.model.dataentity.priv.IPSDEOPPriv;
import net.ibizsys.model.res.IPSLanguageRes;
import net.ibizsys.model.res.IPSSysImage;

import com.fasterxml.jackson.databind.node.ObjectNode;


/**
 * 实体界面关系项对象接口
 * 
 * @author Administrator
 *
 */
public interface IPSDEDRItem extends IPSModelObject {

	// 定义关系项类型代码表

	/**
	 * 关系项类型：1:N关系
	 */
	public final static String DRITEMTYPE_DER1N = "DER1N";

	/**
	 * 关系项类型：系统1:N关系
	 */
	public final static String DRITEMTYPE_SYSDER1N = "SYSDER1N";

	/**
	 * 关系项类型：1:1关系
	 */
	public final static String DRITEMTYPE_DER11 = "DER11";

	/**
	 * 关系项类型：系统1:1关系
	 */
	public final static String DRITEMTYPE_SYSDER11 = "SYSDER11";

	// 定义启用模式代码表

	/**
	 * 启用模式：全部启用
	 */
	public final static String ENABLEMODE_ALL = "ALL";

	/**
	 * 启用模式：流程中启用
	 */
	public final static String ENABLEMODE_INWF = "INWF";

	/**
	 * 启用模式：全部流程状态启用
	 */
	public final static String ENABLEMODE_ALLWF = "ALLWF";

	/**
	 * 启用模式：自定义
	 */
	public final static String ENABLEMODE_CUSTOM = "CUSTOM";

	/**
	 * 启用模式：实体数据操作标识
	 */
	public final static String ENABLEMODE_DEOPPRIV = "DEOPPRIV";

	

	/**
	 * 获取标题
	 * 
	 * @return
	 */
	String getCaption(String strLanguage);

	/**
	 * 获取分类类型，值参考 SA.SRFDA.PS.Core.DataEntity.DR.IPSDEDRItem.DRITEMTYPE_XXX 定义
	 * 
	 * @return
	 */
	String getItemType();

	/**
	 * 获取数据关系分组标识
	 * 
	 * @return
	 */
	String getPSDEDRGroupId();

	/**
	 * 获取关系视图标识
	 * 
	 * @return
	 */
	String getPSDEViewId();

	/**
	 * 获取系统图片资源
	 * 
	 * @return
	 */
	IPSSysImage getPSSysImage();

	/**
	 * 获取启用模式，值参考 SA.SRFDA.PS.Core.DataEntity.DR.IPSDEDRItem.ENABLEMODE_XXX 定义
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
	 * 获取关系项参数
	 * 
	 * @return
	 */
	ObjectNode getViewParamJO();

	/**
	 * 获取标题语言资源
	 * 
	 * @return
	 */
	IPSLanguageRes getCapPSLanguageRes();
}
