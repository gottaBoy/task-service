package net.ibizsys.paas.view;

import net.ibizsys.paas.core.IDynaModelJsonExporter;
import net.ibizsys.paas.core.IDynaModelJsonLoader;
import net.ibizsys.paas.demodel.IDataEntityModel;

/**
 * 动态界面行为模型接口
 * @author Administrator
 *
 */
public interface IDynaUIActionModel extends IUIAction,IDynaModelJsonLoader,IDynaModelJsonExporter {

	/**
	 * 模型属性：操作目标
	 */
	public final static String ATTR_ACTIONTARGET = "actiontarget";
	
	
	/**
	 * 模型属性：支持切换
	 */
	public final static String ATTR_ENABLETOGGLE = "enabletoggle";
	
	
	/**
	 * 模型属性：操作类型
	 */
	public final static String ATTR_ACTIONMODE = "actionmode";
	
	
    /**
     *  界面行为模式：系统预定义
     */
    public final static String ACTIONMODE_SYS = "SYS";
    /**
     *  界面行为模式：前台调用
     */
    public final static String ACTIONMODE_FRONT = "FRONT";
    /**
     *  界面行为模式：后台调用
     */
    public final static String ACTIONMODE_BACKEND = "BACKEND";
    /**
     *  界面行为模式：工作流前台调用
     */
    public final static String ACTIONMODE_WFFRONT = "WFFRONT";
    /**
     *  界面行为模式：工作流后台调用
     */
    public final static String ACTIONMODE_WFBACKEND = "WFBACKEND";
	
    
	//定义数据目标代码表

	/**
	*数据目标：单项数据
	*/
	public final static String ACTIONTARGET_SINGLE = "SINGLE" ;

	/**
	*数据目标：单项数据（主键）
	*/
	public final static String ACTIONTARGET_SINGLEKEY = "SINGLEKEY" ;

	/**
	*数据目标：多项数据（主键）
	*/
	public final static String ACTIONTARGET_MULTI = "MULTI" ;

	/**
	*数据目标：单项或多项数据（主键）
	*/
	public final static String ACTIONTARGET_ALL = "ALL" ;

	/**
	*数据目标：无数据
	*/
	public final static String ACTIONTARGET_NONE = "NONE" ;
	
	
	
	/**
	*界面行为类型：实体界面行为
	*/
	public final static String ACTIONTYPE_DEUIACTION = "DEUIACTION" ;
	
	
	/**
	*界面行为类型：工作流界面行为
	*/
	public final static String ACTIONTYPE_WFUIACTION = "WFUIACTION" ;
	
	/**
	 * 初始化
	 * @param iDataEntityModel
	 * @param modelObject
	 * @throws Exception
	 */
	void init(IDataEntityModel iDataEntityModel,Object modelObject)throws Exception;
	
}
