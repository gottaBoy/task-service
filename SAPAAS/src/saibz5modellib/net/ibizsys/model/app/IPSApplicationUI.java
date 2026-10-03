package net.ibizsys.model.app;

import net.ibizsys.model.core.IPSModelObject;

/**
 * 应用程序界面设置对象接口
 * @author Administrator
 *
 */
public interface IPSApplicationUI extends IPSModelObject {

	/**
	*表格行激活模式：无
	*/
	public final static int GRIDROWACTIVEMODE_NONE = 0 ;

	/**
	*表格行激活模式：单击
	*/
	public final static int GRIDROWACTIVEMODE_CLCIK = 1 ;

	/**
	*表格行激活模式：双击
	*/
	public final static int GRIDROWACTIVEMODE_DBCLICK = 2 ;
	
	
//	/**
//	 * 获取应用技术
//	 * @return
//	 */
//	String getPFType();
//	
//	
//	
//	
//	/**
//	 * 获取应用技术样式
//	 * @return
//	 */
//	String getPFStyle();
	
	
	
	
//	/**
//	 * 获取应用技术对象
//	 * @return
//	 */
//	IPSPF getPSPF();
//	
//	
//	/**
//	 * 获取应用样式对象
//	 * @return
//	 */
//	IPSPFStyle getPSPFStyle();
	
	
	
	 /**
	  * 获取视图样式属性
	 * @param strKey
	 * @return
	 */
	Object getPFStyleParam(String strKey) throws Exception;
	
	
	
	/**
	 * 获取boolean 应用样式属性
	 * @param strKey
	 * @param bDefault
	 * @return
	 */
	boolean getPFStyleParam(String strKey,boolean bDefault)  throws Exception;
	
	
	/**
	 * 获取String 应用样式属性
	 * @param strKey
	 * @param strDefault
	 * @return
	 */
	String getPFStyleParam(String strKey,String strDefault)  throws Exception;
	
	/**
	 * 获取Integer 应用样式属性
	 * @param strKey
	 * @param nDefault
	 * @return
	 */
	int getPFStyleParam(String strKey,int nDefault)  throws Exception;
	
	 
	/**
	 * 获取Double 应用样式属性
	 * @param strKey
	 * @param fDefault
	 * @return
	 */
	double getPFStyleParam(String strKey,double fDefault)  throws Exception;
	
	
	
	/**
	 * 获取应用视图默认的主菜单对齐方向
	 * @return
	 */
	String getMainMenuAlign();
	
	
	
	/**
	 * 获取按钮没有权限的显示模式：具体值参考 SA.SRFDA.PS.Core.View.IPSUIAction.NOPRIVDISPLAYMODE_XXX 定义
	 * @return
	 */
	int getButtonNoPrivDisplayMode();
	
	
	
	/**
	 * 是否自动转换12列栅格布局至24列栅格布局
	 * @return
	 */
	boolean isEnableCol12ToCol24();
	
	
	
	/**
	 * 获取表格是否默认适应屏宽
	 * @return
	 */
	boolean isGridForceFit();
	
	
	/**
	 * 获取表格行数据默认激活模式，值参考  SA.SRFDA.PS.Core.App.IPSApplicationUI.GRIDROWACTIVEMODE_XXX 定义
	 * @return
	 */
	int getGridRowActiveMode();
	
	
	
	/**
	 * 获取表单默认布局模式
	 * @return
	 */
	String getFormLayoutMode();
	
	
	
	
	/**
	 * 获取编辑表单标题宽度
	 * @return
	 */
	int getEditFormLabelWidth();
}
