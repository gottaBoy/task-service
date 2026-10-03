package net.ibizsys.model.dataentity.action;

import net.ibizsys.model.dataentity.IPSDataEntityObject;
import net.ibizsys.paas.core.IDEAction;


/**
 * 实体操作行为对象接口
 * @author lionlau
 *
 */
public interface IPSDEAction extends IPSDataEntityObject,IDEAction
{
	/**
	 * 模板方法
	 */
	final static String ACTIONTYPE_TEMPL = "TEMPL";
	
	

	//定义行为参数模式代码表

	/**
	*全部参数
	*/
	public final static int PARAMMODE_ALL = 1 ;

	/**
	*指定参数
	*/
	public final static int PARAMMODE_SOME = 2 ;
	
	
	
	
	/**
	 *  获取代码名称
	 * @return
	 */
	String getCodeName();
	

	
	
	/**
	 * 获取逻辑名称
	 * @return
	 */
	String getLogicName();
	
	
	
	/**
	 * 是否自定义传入参数
	 * @return
	 */
	boolean isCustomParam();
	
	
	/**
	 * 获取行为参数模式，值参考 SA.SRFDA.PS.Core.DataEntity.Action.IPSDEAction.PARAMMODE_XXX 定义
	 * @return
	 */
	int getParamMode();
	
	
	/**
	 * 获取实体附加逻辑 
	 * @param strAttachMode
	 * @return
	 */
	java.util.Iterator<IPSDEActionLogic> getPSDEActionLogics(String strAttachMode);
	
	
	/**
	 * 获取实体行为附加逻辑集合 
	 * @return
	 */
	java.util.Iterator<IPSDEActionLogic> getPSDEActionLogics();
	
	
	
	/**
	 * 获取实体行为参数集合
	 * @return
	 */
	java.util.Iterator<IPSDEActionParam> getPSDEActionParams();
	
	
	/**
	 * 是否产生默认测试单元
	 * @return
	 */
	boolean isGenerateTestUnit();
	

	/**
	 * 获取是否默认发布服务接口
	 * @return
	 */
	boolean isPubServiceDefault();
	
	
	
//	/**
//	 * 获取RESTful接口设置
//	 * @return
//	 */
//	IPSRESTfulAPI getPSRESTfulAPI();
	
		
	
	/**
	 * 获取扩展模式，值参考 SA.SRFDA.PS.Core.DataEntity.IPSDataEntity.EXTENDMODE_XXX 定义
	 * 
	 * @return
	 */
	int getExtendMode();
}
