package net.ibizsys.model.res;

import java.util.Properties;

import net.ibizsys.model.IPSSystemObject;
import net.ibizsys.model.control.IPSEditorType;


/**
 * 系统编辑器样式对象接口
 * @author lionlau
 *
 */
public interface IPSSysEditorStyle extends IPSSystemObject
{
	/**
	 * 获取编辑器类型
	 * @return
	 */
	String getPSEditorTypeId();
	
	
//	/**
//	 * 系统应用插件
//	 * @return
//	 */
//	IPSSysPFPlugin getPSSysPFPlugin();
	
	
	
	/**
	 * 是否替换默认样式
	 * @return
	 */
	boolean isReplaceDefault();
	
	
	
	/**
	 * 编辑器宽度
	 * @return
	 */
	double getEditorWidth();
	
	
	
	/**
	 * 编辑器高度
	 * @return
	 */
	double getEditorHeight();
	
	
	
	/**
	 * 获取编辑器参数集合
	 * @return
	 */
	Properties getEditorParams();
	
	
	
	/**
	 * 获取编辑器参数（整型）
	 * @param strEditorParam
	 * @param nDefault
	 * @return
	 */
	int getEditorParam(String strEditorParam,int nDefault);
	
	
	
	/**
	 * 获取编辑器参数（字符串）
	 * @param strEditorParam
	 * @param strDefault
	 * @return
	 */
	String getEditorParam(String strEditorParam,String strDefault);
	
	
	
	/**
	 * 获取编辑器参数（双精度）
	 * @param strEditorParam
	 * @param fDefault
	 * @return
	 */
	double getEditorParam(String strEditorParam,double fDefault);
	
	
	
	
	/**
	 * 获取编辑器参数（布尔型）
	 * @param strEditorParam
	 * @param bDefault
	 * @return
	 */
	boolean getEditorParam(String strEditorParam,boolean bDefault);
	
	
	
	/**
	 * 获取后台处理对象类型
	 * @return
	 */
	String getAjaxHandlerType();
	
	
	
	
	
	/**
	 * 获取异步处理对象标识
	 * @return
	 */
	String getPSAjaxHandlerId();
	
	
	
	/**
	 * 获取平台编辑器类型对象
	 * @return
	 * @throws Exception
	 */
	IPSEditorType getPSEditorType() throws Exception;
	
	
	/**
	 * 获取引用视图显示模式，值参考 SA.SRFDA.PS.Core.Control.IPSEditorType.REFVIEWSHOWMODE_XXX 定义
	 * @return
	 */
	String getRefViewShowMode();
	
	
	/**
	 * 获取引用视图显示模式，值参考 SA.SRFDA.PS.Core.Control.IPSEditorType.LINKVIEWSHOWMODE_XXX 定义
	 * @return
	 */
	String getLinkViewShowMode();
}
