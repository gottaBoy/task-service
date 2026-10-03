package net.ibizsys.paas.ctrlhandler;

/**
 * 表格处理对象接口
 * 
 * @author lionlau
 *
 */
public interface IGridHandler extends IMDCtrlHandler, ISDCtrlHandler {
	
	/**
	 * 子项操作类型，表格编辑项后台处理
	 */
	public final static String ITEMACTIONTYPE_GRIDEDITITEM = "GEI:";
	/**
	 * 子项操作类型，表格编辑项更新后台处理
	 */
	public final static String ITEMACTIONTYPE_GRIDEDITITEMUPDATE = "GEIU:";

	/**
	 * 表单项数据
	 */
	final static String ACTION_ITEMFETCH = "itemfetch";

	/**
	 * 获取草稿数据
	 */
	final static String ACTION_LOADDRAFT = "loaddraft";

	/**
	 * 获取草稿数据（从源数据）
	 */
	final static String ACTION_LOADDRAFTFROM = "loaddraftfrom";

	
	/**
	 * 获取草稿数据(从粘贴数据中）
	 */
	final static String ACTION_LOADDRAFTPASTE = "loaddraftpaste";
	
	/**
	 * 更新表格编辑项
	 */
	final static String ACTION_UPDATEGRIDEDITITEM = "updategridedititem";
	
}
