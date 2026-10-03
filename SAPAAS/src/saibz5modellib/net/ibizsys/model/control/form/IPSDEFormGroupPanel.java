package net.ibizsys.model.control.form;

/**
 * 表单分组对象接口
 * 
 * @author Administrator
 *
 */
public interface IPSDEFormGroupPanel extends IPSDEFormDetail {
	/**
	 * 分组标题栏关闭模式：无关闭
	 */
	public final static int TITLEBARCLOSEMODE_NONE = 0;

	/**
	 * 分组标题栏关闭模式：启用关闭（默认打开）
	 */
	public final static int TITLEBARCLOSEMODE_OPENDEFAULT = 1;

	/**
	 * 分组标题栏关闭模式：启用关闭（默认关闭）
	 */
	public final static int TITLEBARCLOSEMODE_CLOSEDEFAULT = 2;
	

	//定义内置操作代码表

	/**
	*新建
	*/
	public final static int BUILDINACTION_NEW = 1 ;

	/**
	*更多操作
	*/
	public final static int BUILDINACTION_MORE = 2 ;
	

	/**
	 * 获取布局模式
	 * 
	 * @return
	 */
	String getLayoutMode();

	/**
	 * 获取列宽度集合，表格布局使用
	 * 
	 * @return
	 */
	double[] getColumnWidths();

	

	/**
	 * 获取分组表单成员集合
	 * 
	 * @return
	 */
	java.util.Iterator<IPSDEFormDetail> getPSDEFormDetails();
	
	
	
	/**
	 * 获取分组表单成员数量
	 * @return
	 */
	int getPSDEFormDetailCount();
	
	
	/**
	 * 获取指定位置的表单成员
	 * @param nIndex
	 * @return
	 * @throws Exception
	 */
	IPSDEFormDetail getPSDEFormDetail(int nIndex)throws Exception;

	/**
	 * 获取默认的标签单元格信息
	 * 
	 * @return
	 */
	int getLabelColSpan();

	/**
	 * 获取默认的控件单元格信息
	 * 
	 * @return
	 */
	int getCtrlColSpan();

	/**
	 * 获取列数量
	 * 
	 * @return
	 */
	int getColumnCount();

	/**
	 * @return
	 */
	int getChildColXS();

	/**
	 * @return
	 */
	int getChildColSM();

	/**
	 * @return
	 */
	int getChildColMD();

	/**
	 * @return
	 */
	int getChildColLG();

	
	/**
	 * 获取标题绑定的表单项名称
	 * 
	 * @return
	 */
	String getCaptionItemName();

	/**
	 * 获取子标题内容
	 * 
	 * @return
	 */
	String getSubCaption();
	
	
	/**
	 * 获取标题栏关闭模式，值参考 SA.SRFDA.PS.Core.Control.Form.IPSDEFormGroupPanel.TITLEBARCLOSEMODE_XXX 定义
	 * 
	 * @return
	 */
	int getTitleBarCloseMode();
	
	/**
	 * 是否支持锚点
	 * @return
	 */
	boolean isEnableAnchor();
	
	
	
	/**
	 * 获取分组的内置行为，值参考 SA.SRFDA.PS.Core.Control.Form.IPSDEFormGroupPanel.BUILDINACTION_XXX 定义
	 * @return
	 */
	int getBuildInActions();
	
	
	/**
	 * 是否支持内置行为
	 * @param nAction
	 * @return
	 */
	boolean isEnableBuildInAction(int nAction);
}
