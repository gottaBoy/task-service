package net.ibizsys.model.app.view;

import java.util.ArrayList;
import java.util.Iterator;

import com.fasterxml.jackson.databind.node.ObjectNode;

import net.ibizsys.model.app.IPSAppModule;
import net.ibizsys.model.app.IPSApplicationObject;
import net.ibizsys.model.app.func.IPSAppFunc;
import net.ibizsys.model.codelist.IPSCodeList;
import net.ibizsys.model.control.IPSAjaxControl;
import net.ibizsys.model.control.IPSControl;
import net.ibizsys.model.control.IPSControlContainer;
import net.ibizsys.model.control.ajax.IPSAjaxHandler;
import net.ibizsys.model.control.counter.IPSSysCounterRef;
import net.ibizsys.model.control.titlebar.IPSTitleBar;
import net.ibizsys.model.core.IPSModelObject;
import net.ibizsys.model.dataentity.IPSDataEntity;
import net.ibizsys.model.res.IPSSysCss;
import net.ibizsys.model.res.IPSSysImage;
import net.ibizsys.model.view.IPSUIAction;
import net.ibizsys.model.view.IPSViewType;
import net.ibizsys.paas.view.IView;

/**
 * 应用视图对象接口
 * @author Administrator
 *
 */
public interface IPSAppView extends IPSApplicationObject,IPSModelObject,IPSControlContainer,IView{

	
	/**
	 * 视图参数：界面部件定义
	 */
	public final static String VIEWPARAM_UI_CTRL = "UI.CTRL";

	/**
	 * 视图参数：显示标题栏
	 */
	public final static String VIEWPARAM_UI_SHOWCAPTIONBAR = "UI.SHOWCAPTIONBAR";
	
	
	/**
	 * 视图使用模式，默认
	 */
	public final static int VIEWUSAGE_DEFAULT = 1;
	
	/**
	 * 视图使用模式，模式弹出
	 */
	public final static int VIEWUSAGE_MODAL = 2;
	
	/**
	 * 视图使用模式，嵌入
	 */
	public final static int VIEWUSAGE_EMBEDED = 4;
	
	/**
	 * 获取视图抬头
	 * 
	 * @return
	 */
	String getTitle();

	/**
	 * 获取视图标题
	 * 
	 * @return
	 */
	String getCaption();

	/**
	 * 获取视图子标题
	 * 
	 * @return
	 */
	String getSubCaption();
	
	/**
	 * 是否为动态视图
	 * @return
	 */
	boolean isDynamicView();
	
	
	
	/**
	 * 获取视图绑定的实体对象 
	 * @return
	 */
	IPSDataEntity getPSDataEntity();
	
	
	/**
	 * 获取全部控件
	 * 
	 * @return
	 */
	java.util.ArrayList<IPSControl> getAllPSControls();

	/**
	 * 获取全部异步控件集合
	 * 
	 * @return
	 */
	ArrayList<IPSAjaxControl> getAllPSAjaxControls();
	
	
	/**
	 * 获取视图界面行为集合
	 * 
	 * @return
	 */
	java.util.Iterator<IPSUIAction> getPSUIActions();

	/**
	 * 获取指定界面行为的参数
	 * 
	 * @param iPSUIAction
	 * @return
	 * @throws Exception
	 */
	ObjectNode getPSUIActionParamJO(IPSUIAction iPSUIAction) throws Exception;
	
	
	/**
	 * 是否为重定向视图
	 * 
	 * @return
	 */
	boolean isRedirectView();

	/**
	 * 是否为实体视图
	 * 
	 * @return
	 */
	boolean isPSDEView();
	
//	
//
//	
//
//
//	/**
//	 * 代码名称
//	 * 
//	 * @return
//	 */
//	String getCodeName();
//
//	/**
//	 * 获取完整代码名称（附加模块代码）
//	 * 
//	 * @return
//	 */
//	String getFullCodeName();

	/**
	 * 获取部件
	 * 
	 * @param strControlName
	 * @return
	 * @throws Exception
	 */
	IPSControl getPSControl(String strControlName) throws Exception;

	/**
	 * 是否有指定控件
	 * 
	 * @param strControlName
	 * @return
	 */
	boolean hasPSControl(String strControlName);

	/**
	 * 获取控件集合
	 * 
	 * @return
	 */
	java.util.Iterator<IPSControl> getPSControls();

	/**
	 * 获取异步交互控件集合
	 * 
	 * @return
	 */
	Iterator<IPSAjaxControl> getPSAjaxControls();

	/**
	 * 获取应用模块
	 * 
	 * @return
	 * @throws Exception
	 */
	IPSAppModule getPSAppModule() throws Exception;

//	/**
//	 * 获取视图类型对象
//	 * 
//	 * @return
//	 */
//	IPSViewType getPSViewType();

	/**
	 * 是否启用用户数据权限
	 * 
	 * @return
	 */
	boolean isEnableDP();

	/**
	 * 获取宽度
	 * 
	 * @return
	 */
	int getWidth();

	/**
	 * 获取高度
	 * 
	 * @return
	 */
	int getHeight();

	/**
	 * 获取引用的视图
	 * 
	 * @param strRefMode
	 * @param bTry
	 * @return
	 * @throws Exception
	 */
	IPSAppView getRefPSAppView(String strRefMode, boolean bTry) throws Exception;

	/**
	 * 获取引用的视图集合
	 * 
	 * @param strRefModePrefix
	 *            引用模式前缀
	 * @return
	 * @throws Exception
	 */
	java.util.Iterator<IPSAppView> getRefPSAppViews(String strRefModePrefix) throws Exception;

	/**
	 * 获取视图引用
	 * 
	 * @param strRefMode
	 *            引用模式
	 * @param bTry
	 *            尝试模式
	 * @return
	 * @throws Exception
	 */
	IPSAppViewRef getPSAppViewRef(String strRefMode, boolean bTry) throws Exception;

	/**
	 * 获取系统界面样式
	 * 
	 * @return
	 */
	IPSSysCss getPSSysCss();
	
	/**
	 * 获取视图系统样式集合
	 * 
	 * @return
	 */
	java.util.Iterator<IPSSysCss> getPSSysCsses();

	/**
	 * 获取视图图片资源集合
	 * 
	 * @return
	 */
	java.util.Iterator<IPSSysImage> getPSSysImages();

	

//	/**
//	 * 获取应用视图逻辑
//	 * 
//	 * @return
//	 */
//	java.util.Iterator<IPSAppViewLogic> getPSAppViewLogics();

	/**
	 * 获取语言
	 * 
	 * @return
	 */
	String getLanguage();

	/**
	 * 获取后台服务路径
	 * 
	 * @return
	 */
	String getBackendUrl();

	/**
	 * 获取应用视图引用集合
	 * 
	 * @return
	 */
	java.util.Iterator<String> getAppViewRefModes();

	/**
	 * 获取当前视图的所有引用
	 * 
	 * @return
	 */
	java.util.Iterator<IPSAppViewRef> getPSAppViewRefs();

	/**
	 * 获取视图的图标
	 * 
	 * @return
	 */
	String getViewIcon();

	/**
	 * 视图抬头
	 * 
	 * @return
	 */
	String getTitle(IPSAppViewRef iPSAppViewRef);

	/**
	 * 视图标题
	 * 
	 * @return
	 */
	String getCaption(IPSAppViewRef iPSAppViewRef);

	/**
	 * 获取视图打开方式
	 * 
	 * @return
	 */
	String getOpenMode(IPSAppViewRef iPSAppViewRef);

	/**
	 * 获取宽度
	 * 
	 * @return
	 */
	int getWidth(IPSAppViewRef iPSAppViewRef);

	/**
	 * 获取高度
	 * 
	 * @return
	 */
	int getHeight(IPSAppViewRef iPSAppViewRef);

	
	/**
	 * 获取视图打开方式，值参考 net.ibizsys.paas.view.IView.OPENMODE_XXX
	 * 
	 * @return
	 */
	String getOpenMode();

	/**
	 * 是否支持视图模型
	 * 
	 * @return
	 */
	boolean isEnableViewModel();

	/**
	 * 获取视图模型路径
	 * 
	 * @return
	 */
	String getViewModelUrl();

	/**
	 * 是否为实体工作流界面
	 * 
	 * @return
	 */
	boolean isEnableWF();

	/**
	 * 是否为用户引用模式
	 * 
	 * @return
	 */
	boolean isUserRefMode();

	/**
	 * 是否支持帮助
	 * 
	 * @return
	 */
	boolean isEnableHelp();

	/**
	 * 获取嵌入的视图引用
	 * 
	 * @param strContainerId
	 * @return
	 */
	java.util.Iterator<IPSAppViewRef> getEmbeddedPSAppViewRefs(String strContainerId) throws Exception;

	
	
	
	
	/**
	 * 获取视图相关的代码表对象集合
	 * 
	 * @param bIncludeEmbed
	 * @return
	 * @throws Exception
	 */
	java.util.Iterator<IPSCodeList> getRelatedPSCodeLists(boolean bIncludeEmbed) throws Exception;
	
	
	/**
	 * 获取视图相关的代码表对象集合，包括嵌入视图
	 * 
	 * @return
	 * @throws Exception
	 */
	java.util.Iterator<IPSCodeList> getAllRelatedPSCodeLists() throws Exception;
	
	
	/**
	 * 获取视图相关的代码表对象集合，不包括嵌入视图
	 * 
	 * @return
	 * @throws Exception
	 */
	java.util.Iterator<IPSCodeList> getRelatedPSCodeLists() throws Exception;

	/**
	 * 获取指定名称控件集合
	 * 
	 * @param strControlName
	 * @param nCount
	 * @return
	 */
	ArrayList<IPSControl> getPSControls(String strControlName, int nCount);

	

	/**
	 * 获取页面路径
	 * 
	 * @return
	 */
	String getPageUrl();

//	/**
//	 * 注册系统计数器
//	 * 
//	 * @param iPSSysCounter
//	 * @param strRefMode
//	 * @return
//	 * @throws Exception
//	 */
//	IPSSysCounterRef registerPSSysCounter(IPSSysCounter iPSSysCounter, JSONObject jsonRefMode) throws Exception;

//	/**
//	 * 获取全部系统计数器引用
//	 * 
//	 * @return
//	 */
//	java.util.Iterator<IPSSysCounterRef> getPSSysCounterRefs();

	/**
	 * 注册应用视图参数
	 * 
	 * @param strKey
	 * @param strValue
	 * @param strDesc
	 * @return
	 * @throws Exception
	 */
	IPSAppViewParam registerPSAppViewParam(String strKey, String strValue, String strDesc) throws Exception;

	/**
	 * 获取全部应用视图参数
	 * 
	 * @return
	 */
	java.util.Iterator<IPSAppViewParam> getPSAppViewParams() throws Exception;

//	/**
//	 * 获取系统视图子类型
//	 * 
//	 * @return
//	 */
//	IPSSubViewType getPSSubViewType();

	/**
	 * 获取视图访问模式，值参考 net.ibizsys.paas.security.AccessUserModes
	 * 
	 * @return
	 */
	int getAccUserMode();

	/**
	 * 获取视图访问资源标示，在视图访问模式为 AccessUserModes.LOGINUSERWITHKEY 时进一步获取访问标识
	 * 
	 * @return
	 */
	String getAccessKey();

//
//	/**
//	 * 获取最后修改时间字符串
//	 * 
//	 * @return
//	 */
//	String getLastModifyTimeStr();

	/**
	 * 是否为移动端视图
	 * 
	 * @return
	 */
	boolean isMobileView();

	/**
	 * 是否为数据选择视图
	 * 
	 * @return
	 */
	boolean isPickupView();

	/**
	 * 获取系统引用标志
	 * 
	 * @return
	 */
	boolean getRefFlag();

//	/**
//	 * 获取系统中的更新面板集合
//	 * 
//	 * @return
//	 */
//	java.util.Iterator<IPSUpdatePanel> getPSUpdatePanels();
//
//	/**
//	 * 获取视图的应用样式
//	 * 
//	 * @return
//	 */
//	IPSPFStyle getPSPFStyle();

//	/**
//	 * 获取视图向导组对象
//	 * 
//	 * @return
//	 */
//	IViewWizardGroup getViewWizardGroup();
//
//	/**
//	 * 获取视图消息组对象
//	 * 
//	 * @return
//	 */
//	IPSViewMsgGroup getPSViewMsgGroup();

	/**
	 * 获取主菜单对齐方向
	 * 
	 * @return
	 */
	String getMainMenuAlign();

//	/**
//	 * 获取抬头语言资源
//	 * 
//	 * @return
//	 */
//	IPSLanguageRes getTitlePSLanguageRes();
//
//	/**
//	 * 获取抬头语言资源
//	 * 
//	 * @return
//	 */
//	IPSLanguageRes getTitlePSLanguageRes(IPSAppViewRef iPSAppViewRef);

	/**
	 * 获取抬头语言资源标识
	 * 
	 * @return
	 */
	String getTitleLanResTag();

	/**
	 * 获取抬头语言资源标识
	 * 
	 * @return
	 */
	String getTitleLanResTag(IPSAppViewRef iPSAppViewRef);

//	/**
//	 * 获取标题语言资源对象
//	 * 
//	 * @return
//	 */
//	IPSLanguageRes getCapPSLanguageRes();

	/**
	 * 获取标题语言资源标识
	 * 
	 * @return
	 */
	String getCapLanResTag();

//	/**
//	 * 获取子标题语言资源对象
//	 * 
//	 * @return
//	 */
//	IPSLanguageRes getSubCapPSLanguageRes();

	/**
	 * 获取子标题语言资源标识
	 * 
	 * @return
	 */
	String getSubCapLanResTag();

//	/**
//	 * 获取视图的默认帮助模块标识
//	 * 
//	 * @return
//	 */
//	String getPSHelpModuleId();

	/**
	 * 是否显示标题栏
	 * 
	 * @return
	 */
	boolean isShowCaptionBar();

	/**
	 * 获取视图系统引用标识
	 * 
	 * @return
	 */
	boolean getSysRefFlag();

	/**
	 * 获取系统图片资源
	 * 
	 * @return
	 */
	IPSSysImage getPSSysImage();

	/**
	 * 是否自定义视图样式
	 * 
	 * @return
	 */
	boolean isCustomViewStyle();

	/**
	 * 获取全部关联视图
	 * 
	 * @return
	 * @throws Exception
	 */
	java.util.Iterator<IPSAppView> getAllRelatedPSAppViews() throws Exception;

	

	/**
	 * 获取应用功能集合
	 * 
	 * @return
	 * @throws Exception
	 */
	java.util.Iterator<IPSAppFunc> getPSAppFuncs();

	

	/**
	 * 获取按钮没有权限的显示模式：具体值参考
	 * SA.SRFDA.PS.Core.View.IPSUIAction.NOPRIVDISPLAYMODE_XXX 定义
	 * 
	 * @return
	 */
	int getButtonNoPrivDisplayMode();
	

	
	
	/**
	 * 获取标题栏对象
	 * @return
	 */
	IPSTitleBar getPSTitleBar();
	
	
	
	
	/**
	 * 是否为嵌入视图
	 * @return
	 */
	boolean isEmbeddedView();
	
	
	
	/**
	 * 获取视图后台处理对象
	 * @return
	 */
	IPSAjaxHandler getPSAjaxHandler();
	
	

	
	
	/**
	 * 判断视图使用方法
	 * @param nViewUsage
	 * @return
	 */
	boolean testViewUsage(int nViewUsage);
	
	
	
	/**
	 * 获取视图用法
	 * @return
	 */
	int getViewUsage();
	
	
	/**
	 * 获取视图类型对象接口
	 * @return
	 */
	IPSViewType getPSViewType();
	
//	/**
//	 * 获取系统视图布局面板
//	 * @return
//	 */
//	IPSSysViewLayoutPanel getPSSysViewLayoutPanel();
	


	/**
	 * 获取视图系统计数器引用集合
	 * @return
	 */
	Iterator<IPSSysCounterRef> getPSSysCounterRefs();

	
	
	/**
	 * 获取最后修改时间
	 * @return
	 */
	long getLastModifyTime();
	
	
	/**
	 * 获取动态模型内容
	 * @return
	 */
	String getDynaModelContent() throws Exception;
}
