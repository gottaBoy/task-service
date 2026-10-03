package net.ibizsys.paas.ctrlhandler;

/**
 * 编辑表单处理对象接口
 * 
 * @author lionlau
 *
 */
public interface IEditFormHandler extends ISDCtrlHandler {
	/**
	 * 子项操作类型，表单项后台处理
	 */
	public final static String ITEMACTIONTYPE_FORMITEM = "FI:";

	/**
	 * 子项操作类型，表单项更新后台处理
	 */
	public final static String ITEMACTIONTYPE_FORMITEMUPDATE = "FIU:";

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
	 * 更新表单项
	 */
	final static String ACTION_UPDATEFORMITEM = "updateformitem";

	/**
	 * 获取草稿数据并创建数据
	 */
	final static String ACTION_LOADDRAFTANDCREATE = "loaddraftandcreate";

	/**
	 * 获取草稿数据（从源数据）并创建数据
	 */
	final static String ACTION_LOADDRAFTFROMANDCREATE = "loaddraftfromandcreate";

	
	/**
	 * 表单项提示
	 */
	final static String ACTION_ITEMTIP = "itemtip";
}
