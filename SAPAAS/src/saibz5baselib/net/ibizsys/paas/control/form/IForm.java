package net.ibizsys.paas.control.form;

import net.ibizsys.paas.control.IControl;

/**
 * 表单部件接口
 * 
 * @author lionlau
 *
 */
public interface IForm extends IControl {

	/**
	 * 编辑表单
	 */
	final static String FORMTYPE_EDITFORM = "EDITFORM";

	/**
	 * 搜索表单
	 */
	final static String FORMTYPE_SEARCHFORM = "SEARCHFORM";

	/**
	 * 表单分页
	 */
	final static String DETAILTYPE_FORMPAGE = "FORMPAGE";

	/**
	 * 分页部件
	 */
	final static String DETAILTYPE_TABPANEL = "TABPANEL";

	/**
	 * 分页面板
	 */
	final static String DETAILTYPE_TABPAGE = "TABPAGE";

	/**
	 * 数据表格
	 */
	final static String DETAILTYPE_DATAGRID = "DATAGRID";

	/**
	 * 表单项
	 */
	final static String DETAILTYPE_FORMITEM = "FORMITEM";

	/**
	 * 用户控件
	 */
	final static String DETAILTYPE_USERCONTROL = "USERCONTROL";

	/**
	 * 表单部件
	 */
	final static String DETAILTYPE_FORMPART = "FORMPART";

	/**
	 * 分组面板
	 */
	final static String DETAILTYPE_GROUPPANEL = "GROUPPANEL";

	/**
	 * 数据关系界面
	 */
	final static String DETAILTYPE_DRUIPART = "DRUIPART";
	

	

	/**
	 * 获取表单项集合
	 * 
	 * @return
	 */
	java.util.Iterator<IFormItem> getFormItems();

	/**
	 * 获取指定表单项
	 * 
	 * @param strName 表单项名称
	 * @param bTryMode 尝试模式
	 * @return
	 * @throws Exception
	 */
	IFormItem getFormItem(String strName, boolean bTryMode) throws Exception;
}
