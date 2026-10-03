package net.ibizsys.model.view;

import net.ibizsys.model.IPSModelJsonExporter;
import net.ibizsys.model.app.view.IPSAppView;
import net.ibizsys.model.core.IPSModelObject;
import net.ibizsys.model.res.IPSLanguageRes;
import net.ibizsys.model.res.IPSSysImage;
import net.ibizsys.paas.view.IUIAction;

import com.fasterxml.jackson.databind.node.ObjectNode;


/**
 * 界面行为接口
 * @author lionlau
 *
 */
public interface IPSUIAction extends IPSModelObject,IUIAction,IPSModelJsonExporter
{
	/**
	 * 视图逻辑附加模式，替换
	 */
	public final static String VIEWLOGICATTACHMODE_REPLACE = "REPLACE";
	
	
	/**
	 * 视图逻辑附加模式，执行之后
	 */
	public final static String VIEWLOGICATTACHMODE_AFTER = "AFTER";
	
	
	/**
	 * 行为无权限显示模式：禁用
	 */
	public final static int NOPRIVDISPLAYMODE_DISABLED = 1;
	
	
	/**
	 * 行为无权限显示模式：隐藏
	 */
	public final static int NOPRIVDISPLAYMODE_HIDE = 2;
	
	
	
	/**
	 * 行为无权限显示模式：隐藏且默认隐藏
	 */
	public final static int NOPRIVDISPLAYMODE_HIDEDEFAULT = 6;
	
	
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
     *  系统预定义，注意：值为对象值，不能直接用于 == 比较
     */
    public final static String UIACTIONMODE_SYS = "SYS";
    /**
     *  前台调用，注意：值为对象值，不能直接用于 == 比较
     */
    public final static String UIACTIONMODE_FRONT = "FRONT";
    /**
     *  后台调用，注意：值为对象值，不能直接用于 == 比较
     */
    public final static String UIACTIONMODE_BACKEND = "BACKEND";
    /**
     *  工作流前台调用，注意：值为对象值，不能直接用于 == 比较
     */
    public final static String UIACTIONMODE_WFFRONT = "WFFRONT";
    /**
     *  工作流后台调用，注意：值为对象值，不能直接用于 == 比较
     */
    public final static String UIACTIONMODE_WFBACKEND = "WFBACKEND";
    
	
	
	
	/**
	 * 获取界面行为标识
	 * @return
	 */
	String getUIActionTag();
	
	
	/**
	 * 获取界面行为完全标识
	 * @return
	 */
	String getUIActionFullTag();
	
	
	/**
	 * 获取界面操作类型
	 * @return
	 */
	String getUIActionType();
	
	
	/**
	 * 获取界面操作模式
	 * @return
	 */
	String getUIActionMode();
	
	
	/**
	 * 填充界面操作项
	 * @param objUICtrlItem
	 * @throws Exception
	 */
	void fillUIActionItem(Object objUIActionItem) throws Exception;
	
	
	/**
	 * 获取标题
	 * @return
	 */
	String getCaption(String strLanguage);
	
	
	
	/**
	 * 是否为界面行为组
	 * @return
	 */
	boolean isUIActionGroup(Object obj)throws Exception;
	
	
	
	
	/**
	 * 获取对应的界面行为组
	 * @param obj
	 * @return
	 * @throws Exception
	 */
	IPSUIActionGroup getPSUIActionGroup(Object obj)throws Exception;
	
	
	/**
	 * 获取代码名称
	 * @return
	 */
	String getCodeName();
	

	
	/**
	 * 是否有效
	 * @return
	 */
	boolean isValid(Object obj)throws Exception;
	
	
	/**
	 * 获取数据操作目标，值参考 net.ibizsys.model.view.IPSUIAction.ACTIONTARGET_XXX 定义
	 * @return
	 */
	String getActionTarget();
	
	
	/**
	 * 获取前端处理类型
	 * @return
	 */
	String getFrontProcessType();
	
	
	
	/**
	 * 获取系统图标对象
	 * @return
	 */
	IPSSysImage getPSSysImage();
	
	
	
	

	/**
	 * 获取提示信息
	 * @return
	 */
	String getTooltip(String strLanguage);
	
	
	/**
	 * 获取Html地址
	 * @return
	 */
	String getHtmlPageUrl();
	
	
	
	/**
	 * 获取操作超时时长
	 * @return
	 */
	long getTimeout();
	
	
	
	/**
	 * 获取操作确认信息
	 * @return
	 */
	String getConfirmMsg();
	
	
	
	
	/**
	 * 获取重新刷新数据
	 * @return
	 */
	boolean isReloadData();
	
	
	
	/**
	 * 获取操作完成提示信息
	 * @return
	 */
	String getSuccessMsg();
	
	
	/**
	 * 获取数据范围行为
	 * @return
	 */
	String getDataAccessAction();
	
	
	
	/**
	 * 关闭编辑视图
	 * @return
	 */
	boolean isCloseEditView();
	
	
	/**
	 * 是否启用Toggle模式
	 * @return
	 */
	boolean isEnableToggleMode();
	
	
	
	/**
	 * 获取视图逻辑附加模式
	 * @return
	 */
	String getViewLogicAttachMode();
	
	
	
	/**
	 * 获取视图逻辑类型
	 * @return
	 */
	String getViewLogicType();
	
	
	
	/**
	 * 获取实体视图逻辑标识
	 * @return
	 */
	String getPSDEUILogicId();
	
	
	
	/**
	 * 获取系统视图逻辑标识
	 * @return
	 */
	String getPSSysViewLogicId();
	
	
	/**
	 * 获取标题语言资源
	 * @return
	 */
	IPSLanguageRes getCapPSLanguageRes();
	
	
	
	
	/**
	 * 获取提示语言资源
	 * @return
	 */
	IPSLanguageRes getTooltipPSLanguageRes();
	
	
	/**
	 * 获取确认消息语言资源
	 * @return
	 */
	IPSLanguageRes getCMPSLanguageRes();
	
	
	/**
	 * 获取成功消息语言资源
	 * @return
	 */
	IPSLanguageRes getSMPSLanguageRes();
	
	
	/**
	 * 获取无权限时的显示模式：具体值参考 net.ibizsys.model.view.IPSUIAction.NOPRIVDISPLAYMODE_XXX 定义
	 * @param iPSAppView 应用视图
	 * @return
	 */
	int getNoPrivDisplayMode(IPSAppView iPSAppView);
	
	
	/**
	 * 获取界面行为参数，字符串形式
	 * @return
	 */
	String getUIActionParam();
	
	
	/**
	 * 获取界面行为参数，JSON形式
	 * @return
	 */
	ObjectNode getUIActionParamJO();
	
	
	
	/**
	 * 获取值项名称，如果需要指定非srfkey数据项
	 * @return
	 */
	String getValueItem();
	
	
	
	/**
	 * 获取文本项名称，如果需要指定非srfmajortext数据项
	 * @return
	 */
	String getTextItem();
	
	
	
	/**
	 * 获取参数项名称，如果需要指定非srfkeys数据项
	 * @return
	 */
	String getParamItem();
	
	
	/**
	 * 获取下一步界面行为
	 * @return
	 */
	IPSUIAction getNextPSUIAction();
}
