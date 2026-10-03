package net.ibizsys.paas.ctrlhandler;

import net.ibizsys.paas.core.IDEDataRange;

/**
 * 多数据部件后台处理对象接口
 * 
 * @author lionlau
 *
 */
public interface IMDCtrlHandler extends ICtrlHandler, IDEDataRange {
	/**
	 * 导出数据，以Excel格式
	 */
	public final static String EXPORTTYPE_EXCEL = "EXCEL";

	/**
	 * 导出数据，以Html格式
	 */
	public final static String EXPORTTYPE_HTML = "HTML";

	/**
	 * 升序
	 */
	public final static String SORTDIR_ASC = "ASC";

	/**
	 * 降序
	 */
	public final static String SORTDIR_DESC = "DESC";

	/**
	 * 获取数据
	 */
	final static String ACTION_FETCH = "fetch";


	/**
	 * 删除数据
	 */
	final static String ACTION_REMOVE = "remove";

	/**
	 * 批添加数据
	 */
	final static String ACTION_ADDBATCH = "addbatch";

	/**
	 * 用户界面行为
	 */
	final static String ACTION_UIACTION = "uiaction";

	/**
	 * 加载运行时界面行为模型
	 */
	final static String ACTION_LOADUIACTION = "loaduiaction";
	
	/**
	 * 导出数据模型
	 */
	final static String ACTION_EXPORTMODEL = "exportmodel";

	/**
	 * 导出导入模板
	 */
	final static String ACTION_EXPORTIMPTEMPL = "exportimptempl";

	/**
	 * 导出数据
	 */
	final static String ACTION_EXPORTDATA = "exportdata";

	
	/**
	 * 数据项提示
	 */
	final static String ACTION_ITEMTIP = "itemtip";
	
	/**
	 * 是否启用列权限控制
	 * 
	 * @return
	 */
	boolean isEnableItemPriv();
}
